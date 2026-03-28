//What is thread pool
-> Its a collection of threads, which are available to perform the submitted task
-> once the thread completes its task it can be reused
->By this we can save thread creation time(stack,heap, programme counter etc..) as creating new thread takes more time as memory allocation needs
to take place for newly created thread
->Performance improves and we don't need overhead of managing thread pool lifecycle

Executor framework present in java.util.concurrent

