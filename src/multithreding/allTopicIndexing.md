1)Tread and process 
2)Java memory model ->Heap, code segment, data segment, register , counter stack
3)Create thread with runnable interface and thread class 
4)Thread life cycle (new , runnable , running, terminated, waiting , timed waiting, blocked,sleep,wait,notifyall,notify,
join, 
diffrence between sleep() and wait()


Thread Locking 
1)Synchronized
2)Re-etrant lock 
3)Read Write Lock
4)Stamped Lock( has optimistic locking feature)
5)Semaphores
 



Concurrecnt without locks (Lock Free concurrency)
CAS algotithm  ABA problem
AtomicInteger
AtomicBoolean
Atomicrefrence

Concurrent collection 
COncurrentHashMap -> Bucket based locking not locks whole map 


ThreaPool   its advantage 
Java.util.conciurrent Package 
Executors Freamwork



1)ExecutorService exexutor = new ThreadPoolexecutor(minSize,maxSize,KeepLaive time, Timeout, Queue,)
2)Executors.newFixedThreadPoolExecutor
3)Executors.newCachedThreadPoolExecutor
4)Executors.newSingLeThreadPoolExecutor
5)Executors.newWorksteelingPoo() has 2 queues submission queue and work steeling queue
6)Executors.newScheduledThreadPoolExecutor() -> can run threads once after fixed time and repetadely after some time 
Runnable, callable 
Futures, completableFutures ->ThenApply, thenCompose (Async also)


Executors.shutdown
Executos.shutdownNow
Executrs.AwaitTermination

ThreadLocla variable 
VirtualTHread
volatile keyword


Coding problems 
1)Producer consumer porblem 
2)Deadlock using thread

mics problem 
Deadlock/Livelock/Starvation
CountDownLatch
CyclicBarrier barrier
Why spurious wakeup while using if 






