# 🎯 30-Day Interview Prep — SDE2 @ Swiggy · Zomato · Uber · Microsoft

> **3.3 years @ Whatfix → targeting product-based companies**
> Structured 30-day plan covering DSA, LLD, HLD, and tools — built around 9 hrs/day study schedule.

---

## 📋 What's in this repo

| File | Purpose |
|------|---------|
| `README.md` | This file — full plan overview |
| `tracker.html` | Interactive 30-day tracker (opens in browser, saves progress locally) |
| `dsa_questions.html` | 120 curated DSA questions with Leetcode links, filters, and progress tracking |
| `DSA_Practice_List.xlsx` | Same 120 questions in Excel — 5 sheets: All, By Pattern, By Company, Schedule, Stats |

---

## 🗓️ Daily Schedule

| Time | Block |
|------|-------|
| 5:00 – 7:30 AM | Study Block 1 — DSA |
| 7:30 – 8:00 AM | Break / Walk |
| 8:00 – 10:00 AM | Study Block 2 — LLD / Design Patterns |
| 10:00 – 11:00 AM | Bath + Breakfast |
| 11:00 AM – 1:30 PM | Study Block 3 — HLD / System Design |
| 1:30 – 2:00 PM | Break |
| 2:00 – 3:00 PM | Lunch |
| 3:00 – 4:30 PM | Job Applications (LinkedIn, Naukri, Instahyre) |
| 4:30 – 6:30 PM | Study Block 4 — Mock Interviews / Revision |
| 6:30 – 8:30 PM | Personal time |
| 8:30 – 9:00 PM | Dinner |
| 9:00 – 10:00 PM | Study Block 5 — Light Review |
| 10:00 PM | Sleep |

**Total study: ~9 hrs/day**

---

## 📆 4-Week Plan

### Week 1 — Diagnose & Fill Gaps (Days 1–7)

**Goal:** Identify weak patterns. Baseline every topic.

| Day | Focus | Key Tasks |
|-----|-------|-----------|
| 1 | DSA audit + LLD warm-up | 5 mediums (arrays/sliding window/hashmap), Parking Lot LLD, CAP theorem revision |
| 2 | Graphs + LLD | Number of Islands, Clone Graph, Course Schedule, BookMyShow LLD, URL Shortener HLD |
| 3 | DP + Concurrency | Coin Change, LCS, Token Bucket Rate Limiter (thread-safe), Twitter Feed HLD |
| 4 | Trees + LRU | Validate BST, Serialize/Deserialize BT, LRU Cache (no shortcuts), WhatsApp HLD |
| 5 | Sliding Window + Pub-Sub | Min Window Substring, 3Sum, Pub-Sub system in Java, Notification HLD + Kafka deep dive |
| 6 | **Mock Day 1** | 45-min DSA mock, 45-min LLD mock (Elevator), Swiggy Order Management HLD |
| 7 | Rest + Revision | Re-solve tagged failures, write HLD component cheat sheet from memory |

**Week 1 deliverable:** Know your top 2 weak areas. Rate yourself 1–5 on each topic.

---

### Week 2 — Speed & Concurrency (Days 8–14)

**Goal:** Solve mediums under 25 min. Write thread-safe code without thinking.

| Day | Focus | Key Tasks |
|-----|-------|-----------|
| 8 | Binary Search + Blocking Queue | All binary search variants, Blocking Queue + Thread Pool from scratch, Uber Dispatch HLD |
| 9 | Heap + Food Delivery LLD | Merge K Sorted Lists, Top K Frequent, Food Delivery state machine, Zomato Search HLD |
| 10 | Backtracking + Pattern speed | Subsets/Permutations, Vending Machine (45 min), ATM (45 min), Semaphore from scratch |
| 11 | Hard Graphs + Notification LLD | Word Ladder, Alien Dictionary, Notification System (Strategy pattern), Google Maps HLD |
| 12 | **Mock Day 2** | Ride Sharing LLD, Instagram HLD, 2 random mediums (graph or tree) |
| 13 | Hard DP + Caching | Edit Distance, Regex Matching, Distributed Cache (Redis Cluster) HLD |
| 14 | Rest + Behavioral | 8 STAR stories from work experience, light DSA, Week 3 research |

**Week 2 deliverable:** Concurrency module done. 60+ questions ticked.

---

### Week 3 — Target Company Patterns (Days 15–21)

**Goal:** Match the specific style of each target company.

| Day | Focus | Key Tasks |
|-----|-------|-----------|
| 15 | Swiggy/Zomato DSA | 6 company-tagged problems, Swiggy Order Management LLD, Instamart HLD |
| 16 | Uber-style DSA | Meeting Rooms II, Task Scheduler, Uber Driver-Rider Matching LLD, Location Tracking HLD |
| 17 | **Mock Day 3** | WhatsApp LLD cold, Uber Surge Pricing HLD cold, interval/greedy DSA |
| 18 | Microsoft prep | LFU Cache, Teams Video Calling HLD, OneDrive Sync HLD, Event Sourcing + CQRS LLD |
| 19 | Trie + API Design | Trie, Word Search II, Autocomplete, REST API design, rate limiting at gateway level |
| 20 | **Mock Day 4** | Microsoft loop simulation — behavioral + coding + Azure notification HLD |
| 21 | Rest + Weakness retargeting | Re-solve all tagged failures from weeks 1–3, plan Week 4 mocks |

**Week 3 deliverable:** Know which company you're least ready for. Fix it before Week 4.

---

### Week 4 — Full Mock Mode (Days 22–30)

**Goal:** 5 full mocks. No new topics. Aggressively apply.

| Day | Focus | Key Tasks |
|-----|-------|-----------|
| 22 | **Full Mock 1** | Splitwise LLD, Distributed Job Scheduler HLD, random DSA |
| 23 | Weak area crunch | 2 hard DSA (approach > completion), slowest pattern speed drill, 5 job applications |
| 24 | **Full Mock 2** | Zomato style — restaurant LLD, Zomato Pro HLD, communication recording |
| 25 | Concurrency + Microservices | Producer-consumer, read-write lock, circuit breaker, saga pattern, 2PC vs outbox |
| 26 | **Full Mock 3** | Microsoft loop — coding + behavioral back-to-back, Azure Event Hub HLD |
| 27 | Final revision | LLD cheat sheet from memory, HLD cheat sheet from memory, no new topics |
| 28 | **Full Mock 4** | Peak simulation — full 3-round loop + 6 behavioral questions recorded |
| 29 | Application blitz | 8–10 applications (referrals first), light DSA maintenance, interview research |
| 30 | Buffer / Final mock | Catch-up or final full mock, Day 30 reflection |

**Week 4 deliverable:** Applied to 20+ companies. Scoring 4–5/5 on all round types.

---

## 📚 DSA — 120 Questions (Pattern-wise)

All questions mapped to target companies and prep days. See `dsa_questions.html` or `DSA_Practice_List.xlsx` for the full interactive list.

### Pattern breakdown

| Pattern | Count | Key Problems |
|---------|-------|-------------|
| Arrays & Sliding Window | 24 | Two Sum, Merge Intervals, Trapping Rain Water, Meeting Rooms II |
| Strings | 10 | Min Window Substring, Group Anagrams, Valid Parentheses |
| Binary Search | 7 | Search in Rotated Array, Median of Two Sorted Arrays |
| Trees | 10 | Serialize/Deserialize BT, LCA, Level Order Traversal |
| Graphs | 13 | Number of Islands, Word Ladder, Alien Dictionary, Cheapest Flights |
| Heap | 6 | Merge K Sorted Lists, Find Median from Stream, K Closest Points |
| Dynamic Programming | 15 | Edit Distance, Burst Balloons, Word Break, Coin Change |
| Backtracking | 8 | Subsets, Permutations, Combination Sum, N-Queens |
| Trie | 4 | Implement Trie, Word Search II, Design Autocomplete |
| Design (DS) | 11 | LRU Cache, LFU Cache, Design Twitter, Hit Counter |

### Difficulty split

```
Easy    ████░░░░░░░░░░░░░░░░  ~15%   18 questions
Medium  ████████████████░░░░  ~68%   81 questions
Hard    ████░░░░░░░░░░░░░░░░  ~17%   21 questions
```

---

## 🏗️ LLD — Design Problems List

### Core Design Patterns to know cold

```
Observer   →  Pub-Sub, Notification system, Event bus
Strategy   →  Driver matching, Payment methods, Sorting algorithms
Factory    →  Object creation, Plugin systems
Decorator  →  Logging wrappers, Feature flags
Command    →  Undo/redo, Task queues, ATM transactions
State      →  Order lifecycle, Ride lifecycle, Vending machine
```

### LLD problems by week

| Week | Problems |
|------|----------|
| W1 | Parking Lot, BookMyShow, Rate Limiter, LRU Cache, Pub-Sub system |
| W2 | Blocking Queue, Thread Pool, Food Delivery, Vending Machine, ATM, Notification System |
| W3 | Swiggy Order Management, Uber Driver-Rider Matching, Teams Calling, Event Sourcing + CQRS, REST API design |
| W4 | Splitwise, Concurrent Task Framework, Library Management, Speed drills on all W1–W3 problems |

### Java Concurrency must-builds

- [ ] Thread-safe LRU Cache (LinkedHashMap not allowed)
- [ ] Token Bucket Rate Limiter (ReentrantLock)
- [ ] Blocking Queue from scratch (wait/notify)
- [ ] Thread Pool (fixed size, task queue, worker threads)
- [ ] Semaphore from scratch
- [ ] Read-Write Lock from scratch
- [ ] Producer-Consumer (multiple producers + consumers)
- [ ] Barrier (all threads wait until N arrive)

---

## 🏛️ HLD — System Design Problems List

### Design these cold by end of Week 3

| System | Key Concepts |
|--------|-------------|
| URL Shortener | Hashing, sharding, Redis cache, 301 vs 302 |
| Twitter/X Feed | Push vs pull fanout, read replicas, CDN |
| WhatsApp | WebSocket, delivery guarantees, offline queue |
| Swiggy Order System | Order state machine, real-time tracking, surge |
| Swiggy Instamart | Dark store model, inventory, demand forecasting |
| Zomato Search | Elasticsearch, ranking, personalization, caching |
| Uber Ride Dispatch | Geohash/quadtree, driver state machine, matching |
| Uber Location Tracking | 1M drivers × 4 sec updates, WebSocket, geospatial index |
| Uber Surge Pricing | Supply/demand zones, multiplier calc, 30-sec updates |
| Google Maps | Dijkstra vs A*, road graph, ETA, dynamic rerouting |
| Notification System | Kafka backbone, push/SMS/email, priority queues, rate limiting |
| CDN | Edge servers, cache invalidation, consistent hashing |
| Search Autocomplete | Trie in memory, top-k with frequencies, personalization |
| Microsoft Teams | WebRTC, SFU vs MCU, strong consistency |
| OneDrive Sync | Conflict resolution, delta sync, offline mode |
| Distributed Cache | Consistent hashing, replication, failover, cache warming |
| Distributed Job Scheduler | At-least-once execution, distributed locking, monitoring |
| Azure Event Hub | Partitioning, consumer groups, replay, checkpointing |

### HLD framework to use every time

```
1. Requirements (functional + non-functional) — 5 min
2. Capacity estimation (QPS, storage, bandwidth) — 5 min
3. High-level architecture (components + data flow) — 10 min
4. Deep dive (most critical component) — 15 min
5. Bottlenecks + trade-offs + what changes at 10x scale — 10 min
```

---

## 🔧 Tools Deep Dive Checklist

### Kafka
- [ ] Partitions, consumer groups, offset management
- [ ] What happens when a consumer dies mid-processing?
- [ ] Leader election, ISR (in-sync replicas)
- [ ] Exactly-once semantics
- [ ] Kafka vs RabbitMQ vs SQS — when each?

### Elasticsearch
- [ ] Inverted index structure
- [ ] How scoring works (TF-IDF, BM25)
- [ ] Sharding and replication
- [ ] Aggregations and mapping
- [ ] Index lifecycle management

### Docker
- [ ] Layer caching, multi-stage builds
- [ ] Networking modes: bridge / host / overlay
- [ ] ENTRYPOINT vs CMD
- [ ] Volume mounts

### Kubernetes
- [ ] Pods, services, deployments
- [ ] HPA (horizontal pod autoscaler)
- [ ] Liveness vs readiness probes
- [ ] ConfigMap vs Secret
- [ ] Zero-downtime rolling deployments — how it works
- [ ] What happens when a node fails?

### Redis
- [ ] Data types: string, hash, list, set, sorted set
- [ ] When sorted set? When list? (interviewers love this)
- [ ] Persistence: RDB vs AOF
- [ ] Pub/Sub
- [ ] Redis Cluster: consistent hashing, replication

---

## 🎤 Behavioral — STAR Stories Checklist

Prepare these 8 stories from your work experience:

- [ ] Most impactful feature you shipped (with numbers)
- [ ] A failure you owned — what happened, what you did, what changed
- [ ] A disagreement with a teammate or manager — how you resolved it
- [ ] A time you showed leadership without formal authority
- [ ] A time you dealt with ambiguity — unclear requirements, shifting priorities
- [ ] A cross-team collaboration that was difficult
- [ ] A time you learned something fast and applied it
- [ ] Your biggest technical decision and how you made it

**STAR format:** Situation (1 line) → Task (1 line) → Action (3 lines) → Result (with numbers)

---

## 📊 Self-Assessment Tracker

Rate yourself 1–5 at the end of each week. Improve or adjust focus accordingly.

| Topic | Day 1 | Day 7 | Day 14 | Day 21 | Day 30 |
|-------|-------|-------|--------|--------|--------|
| DSA Speed (mediums < 25 min) | | | | | |
| DSA Hard (approach correct) | | | | | |
| LLD Confidence | | | | | |
| LLD Speed (< 45 min) | | | | | |
| HLD Depth | | | | | |
| HLD Estimation | | | | | |
| Concurrency in Java | | | | | |
| Tools (Kafka/ES/Docker/K8s) | | | | | |
| Behavioral Stories | | | | | |

---

## 🔗 Resources

### DSA
- [NeetCode 150](https://neetcode.io/practice) — best curated list by pattern
- [Leetcode Discuss](https://leetcode.com/discuss/interview-experience/) — recent interview reports
- [Striver A2Z Sheet](https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2/) — comprehensive DSA coverage

### System Design
- [System Design Primer](https://github.com/donnemartin/system-design-primer)
- [Grokking System Design](https://www.designgurus.io/course/grokking-the-system-design-interview)
- [ByteByteGo Newsletter](https://blog.bytebytego.com/) — real-world HLD breakdowns

### LLD
- [Refactoring Guru — Design Patterns](https://refactoring.guru/design-patterns) — best visual reference
- [LLD Github Collection](https://github.com/tssovi/grokking-the-object-oriented-design-interview)

### Mock Interviews
- [Pramp](https://www.pramp.com/) — free peer mock interviews
- [interviewing.io](https://interviewing.io/) — anonymous mocks with engineers from target companies

### Company Interview Reports
- [Glassdoor — Swiggy SDE2](https://www.glassdoor.co.in/Interview/Swiggy-Software-Engineer-Interview-Questions-EI_IE952680.htm)
- [Leetcode Discuss — Uber SE2 India](https://leetcode.com/discuss/interview-experience/)

---

## 📝 Weekly Retro Template

Copy and fill this at the end of each week:

```
## Week [X] Retro — [Date]

### Scores (1–5)
- DSA Speed: 
- LLD: 
- HLD: 
- Tools: 
- Behavioral: 

### What went well

### What was harder than expected

### Top 2 weak areas to fix next week
1.
2.

### Mocks completed this week
-

### Questions tagged as weak (pattern: problem name)
-
```

---

## 🚀 Target Companies & Focus Areas

| Company | DSA Focus | LLD Focus | HLD Focus | Special |
|---------|-----------|-----------|-----------|---------|
| **Swiggy** | Arrays, graphs, mediums | Order systems, state machines | Instamart, notification, delivery routing | Bar-raiser round: architecture judgement |
| **Zomato** | Strings, arrays, search | Restaurant systems, search | Search + ranking, subscription | Product thinking expected |
| **Uber** | Intervals, greedy, graphs | Matching, dispatch, surge | Location tracking, maps, pricing | Concurrency heavy in LLD |
| **Microsoft** | Trees, DP, design-as-DSA | Event sourcing, CQRS | Teams, OneDrive, Azure services | Full behavioral round + strong consistency |

---

## 💡 Key Reminders

**On DSA:**
> If your solution is O(n), there's usually a binary search or sliding window O(log n) or O(n) version. Always look for it.

**On LLD:**
> Requirements (5 min) → Class diagram (10 min) → Code (20 min) → Concurrency + edge cases (10 min). Drill this sequence until it's muscle memory.

**On HLD:**
> Always answer "what changes at 10x scale?" — this single question separates senior from mid-level candidates.

**On the gap since January 2026:**
> *"I left my previous company to focus on upskilling for senior-level product company roles. I've been interviewing, studying system design, and have cleared multiple rounds at different companies."* — confident, forward-looking, no apology.

---

*Started: May 2026 · Target: SDE2 @ Swiggy / Zomato / Uber / Microsoft*