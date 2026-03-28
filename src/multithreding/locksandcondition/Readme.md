//There are 4 types of locks and they do not depend on if same object is being used or diffrent objects are used
1)Re-entrant lock
-> can lock different objects as well
-----------------------------------------

Read and Write Lock
Read Lock -> More then 1 thread can acquire th read lock ..generally we use it when we only have to read the objects and
//not modify anything there

Write Lock -> Only one thread can acquire a write lock
Read write lock is used when read is very high and write is less

************************************************************
Optimistic loking -> is like proceed without licking but capture the state and one it is captured
validate it before doing any update

Stamped lock ->it provides read lock write lock + optimistic read lock

StampedLock is a lock that supports three modes:


Write lock (exclusive)
Read lock (shared)
Optimistic read (non-blocking, fast but unsafe unless validated)
Analogy
“I’ll read without locking… I hope nobody changes it 🤞”


********************************************************************

                                 Semaphore lock

just one extra functionality that we can manage the number of allowed threads that can execute a lock parallely
//use cases

Wi-Fi hotspot connections → max 10 devices at a time
Database connection pool → only N connections allowed concurrently
Printing queue → only a limited number of printers available

*******************************************

for  the above advanced locks other then synchronized locks we use below mmethods as 
we use 

await() in place of wait();

signal() = notify()
the waiting and notifing happens on lock level not on the objects 