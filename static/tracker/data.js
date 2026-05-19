const DAYS = [
    {d:1,w:1,tags:["dsa","lld"],title:"DSA pattern audit + Parking Lot LLD",time:["DSA 3.5h","LLD 2h","HLD 1.5h","Review 1h"],tasks:[
            {s:"Morning 5–7:30 AM — DSA",i:["5 Leetcode mediums: 2 arrays, 1 sliding window, 1 hashmap, 1 two-pointer","Tag every problem where you took over 25 min — that's your weak pattern","Review solutions: explain time/space complexity out loud"]},
            {s:"Mid-morning 8–10 AM — LLD",i:["Design Parking Lot — full class diagram + Java code skeleton","Apply: Single Responsibility, Open/Closed principles","Identify which patterns you used: Factory? Strategy? State?"]},
            {s:"Afternoon 11 AM–1:30 PM — HLD",i:["Revise CAP theorem, consistency models, SQL vs NoSQL decision framework","Read: Kafka vs RabbitMQ — when do you pick each? Build the mental model"]},
            {s:"Evening 4:30–6:30 PM — Review",i:["Self-mock: explain Parking Lot out loud for 20 min as if to an interviewer","Write down 3 things you fumbled — these become tomorrow's warmup"]}
        ]},
    {d:2,w:1,tags:["dsa","lld","tools"],title:"Graphs DSA + BookMyShow LLD + Kafka",time:["DSA 2.5h","LLD 2h","HLD 2h","Tools 1h"],tasks:[
            {s:"Morning — DSA (Graphs)",i:["Number of Islands, Clone Graph, Course Schedule (topological sort)","Write BFS/DFS templates from memory before starting","Over 30 min on any? Don't peek — revisit after the next problem"]},
            {s:"Mid-morning — LLD",i:["Design BookMyShow — concurrent seat booking is the core challenge","Two users booking same seat: optimistic lock vs pessimistic — which and why?","Patterns: Strategy for seat selection, Observer for booking notifications"]},
            {s:"Afternoon — HLD",i:["Design URL shortener — hashing, DB schema, Redis caching, 301 vs 302 reasoning","Cover sharding strategy and read-heavy optimization"]},
            {s:"Evening — Tools",i:["Kafka: partitions, consumer groups, offset management","Answer out loud: what happens if a consumer dies mid-processing?"]}
        ]},
    {d:3,w:1,tags:["dsa","lld","tools"],title:"DP patterns + Rate Limiter LLD + Elasticsearch",time:["DSA 2.5h","LLD 2h","HLD 2h","Tools 1h"],tasks:[
            {s:"Morning — DSA (Dynamic Programming)",i:["Climbing Stairs, Coin Change, Longest Common Subsequence","Draw the DP table on paper before writing any code","Note which type each is: 1D, 2D, or knapsack variant"]},
            {s:"Mid-morning — LLD",i:["Token Bucket Rate Limiter in Java — must be thread-safe","Use ReentrantLock or synchronized — no shortcuts","Walk through edge cases: burst traffic, clock skew, distributed scenario"]},
            {s:"Afternoon — HLD",i:["Twitter feed — push vs pull vs hybrid fanout strategy","At what follower count does the model flip from push to pull?","Add: read replica strategy, CDN for media assets"]},
            {s:"Evening — Tools",i:["Elasticsearch: inverted index, how scoring works, sharding basics","Practice: explain ES to an interviewer in exactly 3 minutes"]}
        ]},
    {d:4,w:1,tags:["dsa","lld"],title:"Trees DSA + LRU Cache LLD + WhatsApp HLD",time:["DSA 2.5h","LLD 2h","HLD 2h","Revision 1h"],tasks:[
            {s:"Morning — DSA (Trees)",i:["Validate BST, LCA of BST, Serialize/Deserialize Binary Tree","Serialize/Deserialize: 40 min max, then study the solution carefully","Write traversal templates from memory: inorder, preorder, level-order"]},
            {s:"Mid-morning — LLD",i:["Thread-safe LRU Cache in Java — doubly linked list + hashmap, no LinkedHashMap shortcut","Walk through the race condition: two threads call get() and put() simultaneously — what breaks?","Synchronized method vs block — which is better here and why?"]},
            {s:"Afternoon — HLD",i:["Design WhatsApp: delivery guarantees, offline queue, read receipts","WebSocket vs long polling — when does each break down?"]},
            {s:"Evening — Revision",i:["Review LLD problems from this week — rebuild each mentally","Write: which design patterns are you still slow to reach for?"]}
        ]},
    {d:5,w:1,tags:["dsa","lld","tools"],title:"Sliding Window + Pub-Sub LLD + Kafka design",time:["DSA 2.5h","LLD 2h","HLD+Tools 2.5h","Retro 30min"],tasks:[
            {s:"Morning — DSA (Sliding Window)",i:["Longest Substring Without Repeating, Minimum Window Substring, 3Sum","Minimum Window Substring: 35 min max before moving on","Write the sliding window template you'll reuse in every interview"]},
            {s:"Mid-morning — LLD",i:["Design a Pub-Sub system (mini Kafka) in Java from scratch","Key: multiple subscribers, async delivery, thread-safe publish","Observer pattern at the core — implement it, no library shortcuts"]},
            {s:"Afternoon + Tools",i:["Design notification system for 10M users/day using Kafka as backbone","Full flow: event → Kafka topic → consumer → push notification","Deep dive: Kafka replication, ISR, exactly-once semantics"]},
            {s:"Evening — Week 1 retro",i:["Rate yourself 1–5: DSA speed, LLD confidence, HLD depth, Tools knowledge","Write your top 2 weak areas — these get extra focus in Week 2","Plan which pattern types need more drilling next week"]}
        ]},
    {d:6,w:1,tags:["mock","dsa","lld"],title:"Mock interview day 1",time:["DSA mock 1.5h","LLD mock 1.5h","HLD 2h","Debrief 1h"],tasks:[
            {s:"Morning — Mock DSA (45 min strict)",i:["2 random mediums back-to-back — no hints, no mid-solve peeking","Talk through your approach before coding — that's 30% of your score","After: grade yourself — correct logic? Clean code? Clear communication?"]},
            {s:"Mid-morning — Mock LLD (45 min strict)",i:["Design: Elevator System — cold start, no prep allowed","Structure: requirements (5 min) → class diagram (10 min) → code (20 min) → edge cases (10 min)","This structure is your interview playbook — drill it until it's automatic"]},
            {s:"Afternoon — HLD",i:["Design Swiggy order management — customer placing order to delivery partner pickup","Cover: order state machine, real-time tracking, what triggers surge pricing"]},
            {s:"Evening — Debrief",i:["Write the specific things you fumbled in each mock round","These exact failures become tomorrow morning's warmup exercises","Update your tagged weakness list"]}
        ]},
    {d:7,w:1,tags:["dsa"],title:"Rest + light revision + Week 2 planning",time:["DSA 2h","Revision 2h","Planning 30min"],tasks:[
            {s:"Morning — Light DSA only",i:["3 easy Leetcodes — just to stay warm, not to grind","Review your tagged failure patterns from Days 1–6"]},
            {s:"Afternoon — Consolidation",i:["Rewrite from memory: CAP theorem, consistent hashing, DB indexing","Make a one-page HLD component cheat sheet — write from memory first, then verify"]},
            {s:"Evening — Week 2 prep",i:["Plan your concurrency topics for Mon–Fri","Set daily minimum: 5 DSA problems/day in Week 2"]}
        ]},
    {d:8,w:2,tags:["dsa","lld"],title:"Binary search mastery + Blocking Queue + Thread Pool",time:["DSA 2.5h","LLD 2.5h","HLD 2h","Speed drill 30min"],tasks:[
            {s:"Morning — DSA (Binary Search)",i:["Search in Rotated Array, Find Minimum in Rotated Array, Kth Smallest in BST","Rule: if your solution is O(n), there's a binary search O(log n) version — find it","Write the template with all variants: standard, left bound, right bound, rotated"]},
            {s:"Mid-morning — LLD (Concurrency)",i:["Thread-safe Blocking Queue from scratch using wait()/notify() or ReentrantLock + Condition","Then: build a simple Thread Pool — fixed size, task queue, worker threads","These two back-to-back test your concurrency depth systematically"]},
            {s:"Afternoon — HLD",i:["Design Uber ride dispatch — matching, geo-queries, driver state machine","How do you find the nearest driver at scale? Walk through geohash vs quadtree"]},
            {s:"Evening — Speed drill",i:["20-min timer: design a pattern cold — pick randomly: Decorator, Command, or State","No Googling — draw the UML and write code skeleton from memory"]}
        ]},
    {d:9,w:2,tags:["dsa","lld","tools"],title:"Heap + Food Delivery LLD + Docker/K8s",time:["DSA 2.5h","LLD 2.5h","HLD 2h","Tools 1h"],tasks:[
            {s:"Morning — DSA (Heap)",i:["Kth Largest Element, Merge K Sorted Lists, Top K Frequent Elements","Merge K Sorted Lists: use min-heap approach — classic hard","Understand the trade-off: heap vs sort vs quickselect — explain each in one sentence"]},
            {s:"Mid-morning — LLD",i:["Design Food Delivery system (Swiggy/Zomato level) — full state machine","restaurant accepts → preparing → out for delivery → delivered → cancelled","Concurrency: two users order from same restaurant simultaneously — handle it","Patterns: State, Observer, Strategy for delivery partner assignment"]},
            {s:"Afternoon — HLD",i:["Design Zomato search + ranking — full-text search, filters, personalization","Elasticsearch role, query expansion, how ranking score is computed","Caching strategy for popular search terms"]},
            {s:"Evening — Tools",i:["Docker: layers, networking modes (bridge/host/overlay), multi-stage builds","K8s: pods, services, deployments, rolling updates","Answer this: how does K8s handle a node failure?"]}
        ]},
    {d:10,w:2,tags:["dsa","lld"],title:"Backtracking + Design Pattern speed drills",time:["DSA 2.5h","LLD 2h","HLD 2h","Concurrency 1h"],tasks:[
            {s:"Morning — DSA (Backtracking)",i:["Subsets, Permutations, Word Search — write the backtracking skeleton first","Word Search (grid + backtracking): 40 min max, no peeking","Template: choose → recurse → unchoose — internalize this pattern"]},
            {s:"Mid-morning — LLD speed drills",i:["45 min timed: Design Vending Machine using State pattern","45 min timed: Design ATM using State + Command pattern","Grade: where did you slow down? What caused it?"]},
            {s:"Afternoon — HLD",i:["Design a CDN — edge servers, cache invalidation, consistent hashing","Then: image/video upload (S3-like) — chunked uploads, resumable upload protocol"]},
            {s:"Evening — Concurrency",i:["Implement Semaphore from scratch using wait/notify","Dining Philosophers: explain the deadlock and walk through your solution","Solve LeetCode 1114 Print in Order — tests basic thread coordination"]}
        ]},
    {d:11,w:2,tags:["dsa","lld","tools"],title:"Hard graphs + Notification LLD + Redis",time:["DSA 2.5h","LLD 2h","HLD 2h","Tools 1h"],tasks:[
            {s:"Morning — DSA (Hard graphs)",i:["Word Ladder, Alien Dictionary, Pacific Atlantic Water Flow","Word Ladder: BFS with word transformation — classic medium-hard","Alien Dictionary: topological sort derived from character ordering"]},
            {s:"Mid-morning — LLD",i:["Design Notification System at scale: push, SMS, email channels","Pluggable channels via Strategy pattern — each channel is a strategy","Priority queues: critical alerts vs marketing. Rate limiting per user per channel"]},
            {s:"Afternoon — HLD",i:["Design Google Maps — routing, ETA, live traffic integration","Dijkstra vs A* trade-off, dynamic rerouting on traffic update"]},
            {s:"Evening — Tools",i:["Redis: data types (string, hash, list, set, sorted set), pub/sub, persistence (RDB vs AOF)","When sorted set? When list? Interviewers love this — know the answer cold"]}
        ]},
    {d:12,w:2,tags:["mock","dsa","lld","hld"],title:"Mock interview day 2 — no hints",time:["Mock DSA 1.5h","Mock LLD 1.5h","Mock HLD 1.5h","Debrief 1h"],tasks:[
            {s:"Morning — Mock DSA (45 min)",i:["2 random mediums — one must be graph or tree","No hints. Talk throughout — silence in interviews signals struggle","After: did you communicate your thought process continuously?"]},
            {s:"Mid-morning — Mock LLD (45 min)",i:["Design: Ride Sharing app — driver-rider matching, trip state machine, surge pricing","Write down what you said and drew — review immediately after"]},
            {s:"Afternoon — Mock HLD (45 min)",i:["Design: Instagram — photo upload, feed generation, stories with TTL","Answer out loud: how does the feed stay fresh for 500M daily users?"]},
            {s:"Evening — Debrief",i:["Score each round 1–5","Write your top 3 specific failure points from today","These become tomorrow morning's warmup"]}
        ]},
    {d:13,w:2,tags:["dsa","hld"],title:"Hard DP + Distributed Cache HLD",time:["DSA 2.5h","HLD 2.5h","LLD 2h","Retro 30min"],tasks:[
            {s:"Morning — DSA (Hard DP)",i:["Edit Distance, Regular Expression Matching, Burst Balloons","Edit Distance: write the recurrence relation before touching code","Regex Matching: hardest of the three — 40 min max, then study solution carefully"]},
            {s:"Mid-morning — HLD",i:["Caching deep dive: write-through vs write-back vs write-around, eviction policies","Design distributed cache (Redis Cluster) — consistent hashing, replication, failover","Cache warming: how do you avoid a cold-start stampede on fresh deployment?"]},
            {s:"Afternoon — LLD",i:["Design Library Management System with concurrent reservation — full SOLID","Semaphore-based reservation slot locking — walk through the concurrency model"]},
            {s:"Evening — Week 2 retro",i:["Rate yourself 1–5 on all areas — compare to Week 1","Which company style feels least ready: Swiggy, Zomato, Uber, or Microsoft?","That company's style becomes Week 3's top priority"]}
        ]},
    {d:14,w:2,tags:["mock"],title:"Rest + behavioral prep + Week 3 planning",time:["Behavioral 2h","DSA 2h","Planning 1h"],tasks:[
            {s:"Morning — Behavioral (critical for Microsoft loop)",i:["Write 8 STAR stories from your Whatfix experience","Topics: impact, failure you owned, disagreement, leadership, ambiguity","Each story: Situation (1 line) → Task (1 line) → Action (3 lines) → Result (with numbers)"]},
            {s:"Afternoon — Light DSA",i:["3 easy + 2 medium — flow, not grind","Review your design pattern cheat sheet"]},
            {s:"Evening — Plan Week 3",i:["Look up: what rounds do Swiggy/Zomato/Uber/Microsoft specifically run?","Check Glassdoor + Leetcode discuss — what was recently asked?","Adjust Week 3 priorities based on your retro findings"]}
        ]},
    {d:15,w:3,tags:["dsa","lld"],title:"Swiggy/Zomato tagged DSA + Instamart HLD",time:["DSA 3h","LLD 2h","HLD 2h","Screening 1h"],tasks:[
            {s:"Morning — DSA (company tagged)",i:["6 problems tagged Swiggy/Zomato on Leetcode or GFG company filter","Focus: array + string heavy (most common in food-tech screenings)","Track solve time — target under 25 min for mediums"]},
            {s:"Mid-morning — LLD",i:["Design Order Management System for Swiggy — full state machine","PLACED → ACCEPTED → PREPARING → OUT_FOR_DELIVERY → DELIVERED → CANCELLED","Add: cancellation refund flow, partial failure (one item out of stock)"]},
            {s:"Afternoon — HLD",i:["Design Swiggy Instamart (10-min delivery) — dark store model, inventory management","How do you pre-position inventory? Real-time vs batch reorder triggers","Delivery partner routing from dark store to customer"]},
            {s:"Evening — Screening prep",i:["Practice your 4-min Whatfix intro: what you built, scale, your contribution, impact","Interviewers hear this first — make it crisp and confident"]}
        ]},
    {d:16,w:3,tags:["dsa","lld","hld"],title:"Uber-style DSA + Driver-Rider Matching LLD",time:["DSA 2.5h","LLD 2.5h","HLD 2h","Tools 1h"],tasks:[
            {s:"Morning — DSA (Uber favorites)",i:["Meeting Rooms II, Task Scheduler, Jump Game II","Uber interviews lean heavily on interval/greedy — know these patterns cold","Get the approach right before optimizing — approach is what gets evaluated"]},
            {s:"Mid-morning — LLD",i:["Design Uber Driver-Rider Matching — full OOP with surge pricing","Classes: RideRequest, Driver, Rider, MatchingEngine, PricingEngine","Matching as pluggable Strategy: nearest, fastest, cheapest algorithms","Surge pricing: how is the multiplier calculated in real time?"]},
            {s:"Afternoon — HLD",i:["Real-time location tracking at Uber scale — 1M drivers updating every 4 sec","Full path: driver app → WebSocket → location service → geospatial index → rider app","Geohash vs quadtree: when does each approach start to break down?"]},
            {s:"Evening — Tools",i:["K8s: ingress, HPA (horizontal pod autoscaler), liveness vs readiness probes","Explain in 2 min: how does K8s do zero-downtime rolling deployments?"]}
        ]},
    {d:17,w:3,tags:["mock","dsa","lld","hld"],title:"Mock interview day 3 — Uber/Swiggy style",time:["Mock DSA 1.5h","Mock LLD 1.5h","Mock HLD 1.5h","Debrief 1h"],tasks:[
            {s:"Morning — Mock DSA (45 min)",i:["2 problems from interval/greedy/graph — no hints","Simulate interruptions: interviewer asks 'why this approach?' mid-solve — stay calm and answer"]},
            {s:"Mid-morning — Mock LLD (45 min)",i:["Design: real-time chat system (WhatsApp) — cold start, no prep","WebSocket connection management, message persistence, offline delivery queue","Observer for delivery receipts, Command for message types"]},
            {s:"Afternoon — Mock HLD (45 min)",i:["Design: Uber surge pricing — end to end, no prep","Supply/demand calculation, surge zones, how price is shown to rider, driver incentives","How do you update the surge multiplier every 30 seconds at scale?"]},
            {s:"Evening — Debrief",i:["Debrief all three rounds — which type is still your weakest?","Record 3 STAR stories as voice notes — listen back and notice where you rambled"]}
        ]},
    {d:18,w:3,tags:["hld","dsa","lld"],title:"Microsoft prep — Teams HLD + Event Sourcing LLD",time:["DSA 2.5h","HLD 2.5h","LLD 2h","Tools 1h"],tasks:[
            {s:"Morning — DSA (Microsoft favorites)",i:["Serialize/Deserialize Binary Tree, LFU Cache, Design Twitter","Microsoft loves system-design-as-DSA problems — practice these specifically","LFU Cache is harder than LRU — implement both and compare the complexity"]},
            {s:"Mid-morning — HLD (Microsoft scale)",i:["Design Microsoft Teams video calling — WebRTC, SFU vs MCU architecture","Design OneDrive sync — conflict resolution, delta sync, offline mode","Strong consistency: enterprise clients require it — know the CAP trade-off cold"]},
            {s:"Afternoon — LLD",i:["Design Event Sourcing + CQRS system — event store, projections","How do you replay events? How do you handle schema evolution over time?","This pattern separates mid-level from senior candidates in the Microsoft loop"]},
            {s:"Evening — Tools",i:["Azure: App Service, Queue Storage, Cosmos DB vs SQL Azure — when each?","Elasticsearch: aggregations, mapping, index lifecycle management"]}
        ]},
    {d:19,w:3,tags:["dsa","lld"],title:"Trie + API design + search autocomplete HLD",time:["DSA 2.5h","LLD 2h","HLD 2h","Weak area 1h"],tasks:[
            {s:"Morning — DSA (Trie)",i:["Implement Trie, Word Search II, Design Search Autocomplete System","Autocomplete is both DSA (Trie) and mini-HLD — study it from both angles","Segment tree: understand range query conceptually (won't implement, but may discuss)"]},
            {s:"Mid-morning — LLD (API Design)",i:["Design REST API for ride-sharing — endpoints, versioning, idempotency keys","GraphQL vs REST decision framework — when do you pick each?","Rate limiting at API gateway: token bucket at infra layer vs application layer"]},
            {s:"Afternoon — HLD",i:["Design search autocomplete at Google scale — Trie in memory vs on disk, top-k with frequencies","Real-time vs batch index updates, personalization layer based on user search history"]},
            {s:"Evening — Deep dive weakest topic",i:["Pick the topic you're still least confident about from this week","Spend the full hour on it — don't move on until you can explain it without notes"]}
        ]},
    {d:20,w:3,tags:["mock","hld","lld"],title:"Mock interview day 4 — Microsoft loop sim",time:["Behavioral 1.5h","Coding 1.5h","System design 1.5h","Debrief 1h"],tasks:[
            {s:"Morning — Behavioral round (45 min)",i:["Microsoft runs full behavioral rounds — practice 4 STAR stories back to back","Prompt: 'Tell me about a time you dealt with ambiguity' — give it a full 5 min","Focus: leadership, ownership, learning from failure, cross-team collaboration"]},
            {s:"Mid-morning — Coding round (45 min)",i:["2 problems — verbalize every thought step by step","Microsoft evaluates: clean code, edge cases discussed, time/space analysis explained"]},
            {s:"Afternoon — System design (45 min)",i:["Design: Azure notification service (like AWS SNS) — multi-channel, at-least-once delivery","Cover: topics, subscriptions, fan-out, DLQ (dead letter queue), retry policy with backoff"]},
            {s:"Evening — Debrief + adjust",i:["Which round still feels weakest?","Adjust Week 4: put 40% of mock time on that specific round type"]}
        ]},
    {d:21,w:3,tags:["dsa"],title:"Rest + weakness retargeting + Week 4 planning",time:["DSA 2.5h","HLD 2h","Planning 1h"],tasks:[
            {s:"Morning — Re-solve every tagged weak problem",i:["Go back to every problem flagged as slow or missed across weeks 1–3","Re-solve each without looking at your previous solution","Did your time improve? Are the patterns clicking faster?"]},
            {s:"Afternoon — Weakest HLD redo",i:["Pick the HLD design you felt worst about — redo it from scratch, no notes","Then: what would change at 10x scale? At 100x? Answer both out loud","This question appears in almost every senior HLD round"]},
            {s:"Evening — Plan Week 4",i:["5 full mocks minimum this week — line up partners on Pramp or interviewing.io","If going solo: record yourself on video — watching playback is very effective","Which company style are you most ready for? Least ready? That shapes mock order"]}
        ]},
    {d:22,w:4,tags:["mock","dsa","lld","hld"],title:"Full mock day 1 — Splitwise + job scheduler",time:["Mock DSA 1.5h","Mock LLD 1.5h","Mock HLD 1.5h","Revision 1h"],tasks:[
            {s:"Morning — Timed mock DSA (45 min)",i:["2 problems from graph, tree, or DP — random pick, no preparation","No pause, no hints — simulate the real environment exactly","After: write your approach in 3 sentences — could you explain it under pressure?"]},
            {s:"Mid-morning — Timed mock LLD (45 min)",i:["Design: Splitwise (expense sharing app)","Cover: group expenses, settle-up algorithm, transaction simplification","Concurrency: two users settling the same group simultaneously — handle it"]},
            {s:"Afternoon — Timed mock HLD (45 min)",i:["Design: distributed job scheduler (cron at scale)","Cover: job persistence, at-least-once execution, distributed locking, monitoring"]},
            {s:"Evening — Revision only",i:["No new topics. Review failure notes from all previous mocks only","Update your STAR stories with any new Whatfix examples you haven't used yet"]}
        ]},
    {d:23,w:4,tags:["dsa","lld"],title:"Weak area crunch + hard DSA + job applications",time:["DSA 2.5h","LLD 2h","HLD 2h","Jobs 1h"],tasks:[
            {s:"Morning — DSA hard (partial credit mindset)",i:["Attempt 2 hard problems — goal is to identify the approach and start coding","Options: Trapping Rain Water, Median of Two Sorted Arrays, N-Queens","In interviews: getting the right approach matters more than finishing the code"]},
            {s:"Mid-morning — LLD speed (your slowest pattern only)",i:["Pick the 1 design pattern you're still slowest on","Solve 3 different problems using only that pattern — 30 min each max","Speed is the explicit goal today, not depth or thoroughness"]},
            {s:"Afternoon — Weakest HLD redone",i:["Redo your weakest HLD design — no notes, timed","Then: what changes at 10x scale? 100x? Answer both out loud","This question comes up in almost every senior HLD round"]},
            {s:"Evening — Job applications",i:["Apply to 5 companies — referrals first via LinkedIn, alumni, mutual connections","Target: Swiggy, Zomato, Uber India, Microsoft, PhonePe, Razorpay, CRED","Customise 2–3 lines per application to match their specific stack or product"]}
        ]},
    {d:24,w:4,tags:["mock","dsa","lld","hld"],title:"Full mock day 2 — Zomato style",time:["Mocks 3h","Communication 1h","Screening 1h","Debrief 1h"],tasks:[
            {s:"Morning — Mock (Zomato style)",i:["DSA: string/array focused — 2 mediums in 40 min","LLD: design restaurant listing + review system with abuse prevention","HLD: design Zomato Pro subscription + loyalty points engine"]},
            {s:"Mid-morning — Communication focus",i:["Record yourself doing a 10-min HLD walkthrough","Watch it back: too many 'umms'? Did you structure requirements → estimation → architecture?","Communication clarity is a key differentiator at the senior level"]},
            {s:"Afternoon — Screening round prep",i:["Java internals: GC, JVM memory model, HashMap internals — surface level is enough","Practice: explain Java HashMap internals in 2 minutes — very common screening question","These come up in any Java-shop's screening"]},
            {s:"Evening — Debrief",i:["Which company style feels most comfortable now?","Which still feels shaky? Make that the theme for your next mock"]}
        ]},
    {d:25,w:4,tags:["lld","tools"],title:"Concurrency mastery + microservices patterns",time:["Concurrency 2.5h","API 2h","HLD 2h","Tools 1h"],tasks:[
            {s:"Morning — Concurrency (Java)",i:["Implement: producer-consumer with multiple producers and consumers","Implement: read-write lock from scratch (readers share, writers exclusive)","Implement: barrier — all threads wait until N threads arrive at the gate"]},
            {s:"Mid-morning — API + Microservices",i:["Microservices: sync vs async communication, saga pattern for distributed transactions","REST API design: idempotency keys, versioning, what HATEOAS is (know it, not just the acronym)","Circuit breaker: explain Hystrix/Resilience4j to an interviewer in 2 minutes max"]},
            {s:"Afternoon — HLD advanced topics",i:["Distributed transactions: 2PC vs saga vs outbox pattern — when do you use each?","Event-driven: choreography vs orchestration — trade-offs for each","These are senior-level differentiators that put you ahead of most candidates"]},
            {s:"Evening — Tools final sweep",i:["Docker: ENTRYPOINT vs CMD, networking, volume mounts","K8s: ConfigMap vs Secret, resource limits, namespace isolation","Target: answer any tool question confidently within 2–3 minutes"]}
        ]},
    {d:26,w:4,tags:["mock","hld","lld"],title:"Full mock day 3 — Microsoft loop simulation",time:["Coding+Behavioral 1.5h","System design 1.5h","LLD 1.5h","Debrief 1h"],tasks:[
            {s:"Morning — Coding + Behavioral back to back",i:["Coding (45 min): 2 medium-hard problems — verbalize everything","Immediately: 2 STAR stories (30 min) — no break in between","This back-to-back is intentional: Microsoft tests you when slightly fatigued"]},
            {s:"Mid-morning — System design (60 min)",i:["Design: Azure Event Hub (Kafka-as-a-service) — know this cold for Microsoft","Cover: partitioning, consumer groups, replay, checkpointing, Azure integrations"]},
            {s:"Afternoon — LLD hard (45 min)",i:["Design: concurrent task execution framework (mini Java ExecutorService)","Must have: work stealing, priority queues, cancellation support","Tests both OOP depth and concurrency understanding simultaneously"]},
            {s:"Evening — Final debrief",i:["Score every area 1–5: DSA, LLD, HLD, Tools, Behavioral","Compare to your Day 1 self — write the specific delta","List your top 5 target companies in priority order for this week"]}
        ]},
    {d:27,w:4,tags:["dsa","lld","hld"],title:"Final revision — no new topics",time:["DSA 2h","LLD 2h","HLD 2h","Mindset 30min"],tasks:[
            {s:"Morning — DSA failure list — final pass",i:["Re-solve every problem you tagged as weak across 30 days","Target under 25 min each — if you can, you've genuinely improved","No new hard problems today — reinforce what you already know"]},
            {s:"Mid-morning — LLD cheat sheet from memory",i:["Write: Observer, Strategy, Factory, Decorator, Command, State — all 6 core patterns","For each: 1-line definition + 1 real use case + rough class structure","This becomes your rescue document the night before each interview"]},
            {s:"Afternoon — HLD cheat sheet from memory",i:["Write: your go-to components — LB, CDN, cache, DB, queue, search, monitoring","For each: when to use, what to watch out for, what scale it breaks at","Keep this as a real reference document going forward"]},
            {s:"Evening — Mindset + logistics",i:["You've done the work — trust it","Prep your interview setup: good lighting, quiet room, blank notepad, water, IDE ready","Sleep by 9:30 PM tonight — recovery is preparation"]}
        ]},
    {d:28,w:4,tags:["mock","dsa","lld","hld"],title:"Full mock day 4 — peak simulation",time:["Full loop 3h","Behavioral 1h","Debrief 1h"],tasks:[
            {s:"Morning — Full 3-round loop back to back",i:["Round 1 (45 min): 2 DSA problems — no breaks between rounds","Round 2 (45 min): LLD — pick any you haven't touched in 2 weeks","Round 3 (45 min): HLD — something fresh you haven't rehearsed recently"]},
            {s:"Afternoon — Behavioral gauntlet",i:["6 behavioral questions back-to-back, 5 min each with a timer","Topics: leadership, failure, conflict, ambiguity, impact, learning","Record audio — your energy and structure matter as much as the content"]},
            {s:"Evening — Debrief + reflect",i:["30 days of structured prep completed — that's genuinely rare","Compare your Day 28 self to Day 1 across every area — write the delta","Tomorrow: apply with full confidence. You're ready."]}
        ]},
    {d:29,w:4,tags:["tools"],title:"Application blitz + light maintenance",time:["Applications 2h","DSA 1.5h","Research 1h"],tasks:[
            {s:"Morning — Apply to 8–10 companies",i:["Referral applications first — reach LinkedIn connections at target companies","Direct apply: Swiggy, Zomato, Uber India, Microsoft, PhonePe, Razorpay, CRED, Meesho","Customise 2–3 lines per cover note — mention their specific product or engineering blog"]},
            {s:"Afternoon — Light DSA + sharpness",i:["3 mediums — not to grind, just to stay sharp for incoming interview calls","Keep your solve time logged — don't let it slip"]},
            {s:"Evening — Interview research",i:["For every scheduled interview: check Glassdoor + Leetcode discuss for recent rounds","Read their engineering blog — mention something specific during the interview itself","Sleep well. You've done the work."]}
        ]},
    {d:30,w:4,tags:["mock","dsa","lld","hld"],title:"Day 30 — buffer, catch-up, or final mock",time:["Catch-up or mock 4h","Reflection 1h"],tasks:[
            {s:"If you're behind — use this to catch up",i:["Pick the single week you felt worst about — redo the 2–3 hardest tasks from it","Don't try to catch everything — highest-leverage gap only","Focus beats breadth on the final day"]},
            {s:"If you're on track — one final full mock",i:["Full 3-round mock: DSA + LLD + HLD back to back","You should be scoring 4–5 on most areas by now","If not: note exactly what's missing — put it on your pre-interview review list"]},
            {s:"Regardless — write your Day 30 reflection",i:["Where were you on Day 1? Where are you now? Write both down","What's your target company shortlist in priority order?","What's the one thing you're still least confident about? Review it the night before every interview"]}
        ]}
];
