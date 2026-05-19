# PreparationPlan

A 30-day structured interview preparation tracker for software engineering roles at Swiggy, Zomato, Uber, and Microsoft.

## Features

- 30 days of curated prep tasks covering DSA, LLD, HLD, Tools, and Behavioral rounds
- Week-by-week navigation (Diagnose → Speed → Target → Mock mode)
- Per-task checkboxes with progress tracking
- Mark days as complete
- Notes per day
- Overall stats: days done, days left, tasks ticked, current week
- Progress bar across all 30 days
- Dark mode support (follows system preference)
- Data saved to a local JSON file on your computer (not browser storage)

## Project Structure

```
PreparationPlan/
├── index.html          # HTML structure
├── styles.css          # All styling and dark mode
├── data.js             # 30-day plan data (static)
├── app.js              # App logic, file I/O, rendering
├── prep30-state.json   # Your saved progress (auto-created)
└── README.md
```

## Getting Started

1. Open `index.html` in **Chrome or Edge** (required for File System API support)
2. On first load, a prompt will appear — choose:
    - **Open existing save file** — resume from a previously saved `.json` file
    - **Create new save file** — start fresh, creates `prep30-state.json`
3. Your progress is saved automatically to that file on every interaction

> **Note:** The File System Access API used for local file saving is supported only in Chromium-based browsers (Chrome, Edge). Firefox and Safari are not supported.

## How Data is Saved

User progress (completed days, checked tasks, notes) is stored in a plain JSON file on disk:

```json
{
  "done": [0, 1, 5],
  "checks": {
    "0-0-0": true,
    "0-0-1": true
  },
  "notes": {
    "0": "Struggled with sliding window — revisit tomorrow"
  }
}
```

The file handle is remembered via IndexedDB so you are not re-prompted on every visit — the browser will ask for permission once per session.

## Prep Plan Overview

| Week | Theme | Focus |
|------|-------|-------|
| Week 1 | Diagnose | DSA pattern audit, core LLD designs, HLD fundamentals |
| Week 2 | Speed | Concurrency, hard graphs, hard DP, mock interviews |
| Week 3 | Target | Company-specific prep (Swiggy, Zomato, Uber, Microsoft) |
| Week 4 | Mock mode | Full loop simulations, behavioral, final revision |

## Tags

| Tag | Meaning |
|-----|---------|
| DSA | Data Structures & Algorithms |
| LLD | Low-Level Design (OOP, design patterns) |
| HLD | High-Level Design (system design) |
| Tools | Kafka, Redis, Docker, Kubernetes, Elasticsearch |
| Mock | Timed mock interview rounds |
