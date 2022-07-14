## ForkJoinPool
- Worker threads can execute only one task at a time,
- ForkJoinPool doesn’t create a separate thread for every single subtask. Instead, each thread in the pool has its own double-ended queue that store tasks
- **_work-stealing_** algorithm to happen above architecture is needed. if a thread's task deque is empty thread will take tasks from the tail of **_another busy thread's deque or from the global entry queue_**

### fork/join framework can speed up processing of large tasks
To achieve this outcome, we should follow some guidelines:

- Use as few thread pools as possible. In most cases, the best decision is to use one thread pool per application or system.
- Use the default common thread pool if no specific tuning is needed.
- Use a reasonable threshold for splitting ForkJoinTask into subtasks.
- Avoid any blocking in ForkJoinTasks.