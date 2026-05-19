// ── IndexedDB helpers (persist file handle across sessions) ──────────────────
const IDB_NAME  = 'prep30_db';
const IDB_STORE = 'handles';
const IDB_KEY   = 'saveFile';

function openIDB() {
    return new Promise((resolve, reject) => {
        const req = indexedDB.open(IDB_NAME, 1);
        req.onupgradeneeded = e => e.target.result.createObjectStore(IDB_STORE);
        req.onsuccess  = e => resolve(e.target.result);
        req.onerror    = e => reject(e.target.error);
    });
}

async function saveHandleToIDB(handle) {
    const db = await openIDB();
    return new Promise((resolve, reject) => {
        const tx = db.transaction(IDB_STORE, 'readwrite');
        tx.objectStore(IDB_STORE).put(handle, IDB_KEY);
        tx.oncomplete = resolve;
        tx.onerror    = e => reject(e.target.error);
    });
}

async function getHandleFromIDB() {
    const db = await openIDB();
    return new Promise((resolve, reject) => {
        const tx  = db.transaction(IDB_STORE, 'readonly');
        const req = tx.objectStore(IDB_STORE).get(IDB_KEY);
        req.onsuccess = e => resolve(e.target.result);
        req.onerror   = e => reject(e.target.error);
    });
}

// ── File System Access API ────────────────────────────────────────────────────
let fileHandle = null;
let state = { done: [], checks: {}, notes: {} };

async function verifyPermission(handle) {
    const opts = { mode: 'readwrite' };
    if (await handle.queryPermission(opts) === 'granted') return true;
    if (await handle.requestPermission(opts) === 'granted') return true;
    return false;
}

async function readFromFile() {
    try {
        const file = await fileHandle.getFile();
        const text = await file.text();
        const parsed = JSON.parse(text);
        state = parsed;
        if (!Array.isArray(state.done)) state.done = [];
        if (!state.checks) state.checks = {};
        if (!state.notes) state.notes = {};
    } catch(e) {
        state = { done: [], checks: {}, notes: {} };
    }
}

async function saveState() {
    if (!fileHandle) return;
    try {
        const writable = await fileHandle.createWritable();
        await writable.write(JSON.stringify(state, null, 2));
        await writable.close();
    } catch(e) {}
}

// ── Overlay UI ───────────────────────────────────────────────────────────────
function showOverlay() {
    document.getElementById('file-overlay').classList.remove('hidden');
}

function hideOverlay() {
    document.getElementById('file-overlay').classList.add('hidden');
}

function showFileBadge(name) {
    const hdr = document.querySelector('.hdr p');
    const existing = hdr.querySelector('.file-badge');
    if (existing) existing.remove();
    const badge = document.createElement('span');
    badge.className = 'file-badge';
    badge.innerHTML = `<svg width="11" height="11" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round"><polyline points="20 6 9 17 4 12"/></svg>${name}`;
    hdr.appendChild(badge);
}

async function pickOpenFile() {
    try {
        [fileHandle] = await window.showOpenFilePicker({
            types: [{ description: 'JSON', accept: { 'application/json': ['.json'] } }]
        });
        await saveHandleToIDB(fileHandle);
        await readFromFile();
        hideOverlay();
        showFileBadge(fileHandle.name);
        render();
    } catch(e) {
        if (e.name !== 'AbortError') console.error(e);
    }
}

async function pickNewFile() {
    try {
        fileHandle = await window.showSaveFilePicker({
            suggestedName: 'prep30-state.json',
            types: [{ description: 'JSON', accept: { 'application/json': ['.json'] } }]
        });
        state = { done: [], checks: {}, notes: {} };
        await saveState();
        await saveHandleToIDB(fileHandle);
        hideOverlay();
        showFileBadge(fileHandle.name);
        render();
    } catch(e) {
        if (e.name !== 'AbortError') console.error(e);
    }
}

// ── App init ─────────────────────────────────────────────────────────────────
async function init() {
    if (!('showOpenFilePicker' in window)) {
        document.getElementById('file-hint').textContent =
            'Your browser does not support the File System API. Use Chrome or Edge.';
        showOverlay();
        return;
    }
    try {
        const saved = await getHandleFromIDB();
        if (saved && await verifyPermission(saved)) {
            fileHandle = saved;
            await readFromFile();
            showFileBadge(fileHandle.name);
            render();
            return;
        }
    } catch(e) {}
    showOverlay();
}

// ── Rendering ─────────────────────────────────────────────────────────────────
let curWeek = 1;

function tagHtml(t) {
    const m = { dsa:['t-dsa','DSA'], lld:['t-lld','LLD'], hld:['t-hld','HLD'], tools:['t-tools','Tools'], mock:['t-mock','Mock'] };
    const [c, l] = m[t] || ['t-mock', t];
    return `<span class="tg ${c}">${l}</span>`;
}

function render() {
    const container = document.getElementById('days-container');
    container.innerHTML = '';
    const weekDays = DAYS.filter(d => d.w === curWeek);

    weekDays.forEach(day => {
        const gi = day.d - 1;
        const isDone = state.done.includes(gi);
        const note = state.notes[gi] || '';

        const card = document.createElement('div');
        card.className = 'dc' + (isDone ? ' done' : '');
        card.dataset.idx = gi;

        let tbody = '';
        day.tasks.forEach((sec, si) => {
            const items = sec.i.map((item, ii) => {
                const k = `${gi}-${si}-${ii}`;
                const on = state.checks[k] ? 'on' : '';
                const struck = state.checks[k] ? ' x' : '';
                return `<div class="trow">
          <div class="ck ${on}" onclick="toggleCheck('${k}',this)" role="checkbox" aria-checked="${!!state.checks[k]}" aria-label="${item}"></div>
          <span class="tx${struck}" id="tx-${k}">${item}</span>
        </div>`;
            }).join('');
            tbody += `<div class="ts"><div class="ts-t">${sec.s}</div><div class="tlist">${items}</div></div>`;
        });

        const badges = day.time.map(t => `<span class="tbg">${t}</span>`).join('');
        const statusSvg = isDone
            ? `<svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="var(--success-border)" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" aria-label="Done"><path d="M22 11.08V12a10 10 0 1 1-5.93-9.14"/><polyline points="22 4 12 14.01 9 11.01"/></svg>`
            : `<svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="var(--text3)" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" aria-label="Pending"><circle cx="12" cy="12" r="10"/></svg>`;

        const noteHtml = note
            ? `<div class="note-display">&#128221; ${note}</div>` : '';

        card.innerHTML = `
      <div class="dh" onclick="toggleCard(${gi})" role="button" aria-expanded="false">
        <span class="dn">Day ${day.d}</span>
        <span class="dt">${day.title}</span>
        <div class="tags">${(day.tags || []).map(tagHtml).join('')}</div>
        <span class="status-icon" style="margin-left:auto;flex-shrink:0;display:flex;align-items:center">${statusSvg}</span>
        <svg class="chev" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" aria-hidden="true"><polyline points="6 9 12 15 18 9"/></svg>
      </div>
      <div class="dbody">
        ${tbody}
        <div class="tbgs">${badges}</div>
        <div class="fa">
          <button class="btn-d" onclick="markDone(${gi})">
            <svg width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round" aria-hidden="true"><polyline points="20 6 9 17 4 12"/></svg>
            ${isDone ? 'Marked done' : 'Mark complete'}
          </button>
          <div class="note-area">
            <input type="text" id="note-${gi}" placeholder="Add a note for this day..." value="${note.replace(/"/g,'&quot;')}" onkeydown="if(event.key==='Enter')saveNote(${gi})">
            <div class="note-saved" id="ns-${gi}">Saved!</div>
          </div>
          <button class="btn-d" style="background:var(--info-bg);border-color:var(--info-border);color:var(--info-text)" onclick="saveNote(${gi})">Save note</button>
        </div>
        ${noteHtml}
      </div>`;
        container.appendChild(card);
    });
    updateStats();
}

function toggleCard(idx) {
    const card = document.querySelector(`.dc[data-idx='${idx}']`);
    if (!card) return;
    const wasOpen = card.classList.contains('open');
    document.querySelectorAll('.dc.open').forEach(c => {
        c.classList.remove('open');
        c.querySelector('.dh').setAttribute('aria-expanded', 'false');
    });
    if (!wasOpen) {
        card.classList.add('open');
        card.querySelector('.dh').setAttribute('aria-expanded', 'true');
    }
}

function toggleCheck(key, el) {
    state.checks[key] = !state.checks[key];
    el.classList.toggle('on');
    el.setAttribute('aria-checked', String(!!state.checks[key]));
    const tx = document.getElementById('tx-' + key);
    if (tx) tx.classList.toggle('x');
    saveState();
    updateStats();
}

function markDone(idx) {
    const i = state.done.indexOf(idx);
    if (i > -1) { state.done.splice(i, 1); }
    else { state.done.push(idx); }
    saveState();
    render();
    showToast(state.done.includes(idx) ? 'Day marked complete!' : 'Marked incomplete');
}

function saveNote(idx) {
    const input = document.getElementById('note-' + idx);
    if (!input) return;
    state.notes[idx] = input.value.trim();
    saveState();
    const ns = document.getElementById('ns-' + idx);
    if (ns) { ns.style.display = 'block'; setTimeout(() => { ns.style.display = 'none'; }, 1500); }
}

function showWeek(w, btn) {
    curWeek = w;
    document.querySelectorAll('.wb').forEach(b => b.classList.remove('active'));
    btn.classList.add('active');
    render();
}

function updateStats() {
    const td = state.done.length;
    const tl = 30 - td;
    const tc = Object.values(state.checks).filter(Boolean).length;
    const wk = td < 7 ? 'W1' : td < 14 ? 'W2' : td < 21 ? 'W3' : 'W4';
    document.getElementById('s-done').textContent = td;
    document.getElementById('s-left').textContent = tl;
    document.getElementById('s-tasks').textContent = tc;
    document.getElementById('s-week').textContent = wk;
    const pct = Math.round((td / 30) * 100);
    document.getElementById('prog').style.width = pct + '%';
}

function showToast(msg) {
    const t = document.getElementById('toast');
    t.textContent = msg;
    t.classList.add('show');
    setTimeout(() => t.classList.remove('show'), 2000);
}

init();
