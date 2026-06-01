how many ways to achieve concurrency

1)Lock based mechanism
a)synchronized
b)Reentrant Lock
c)Read-Write Lock
d)Stamped Lock - Optimistic locking feature
e)Semaphore lock

2)Lock free mechanism
CAS -> compare and swap

understand CAS > compare and swap internally

Compare: Check if the current value equals an expected value.
Swap: If it matches, replace it with a new value atomically.
Otherwise: Do nothing (thread retries later).

expected = old value
current = read actual value

if (current == expected)
    value = new value
else
    retry

    this happens internally at OS level by C++ code
    java enables this feature suing Atomic feature


    AtomicInteger
    AtomicLong
    AtomicReference

    ABA Problem:

    If a value changes from A → B → A, CAS may think it’s unchanged.
    Can be solved with AtomicStampedReference. -> It’s an atomic reference that also carries a “stamp” (usually a version number).


    **********
    volatile keyword
    don't store values in thread cash (called l1 cash) rather read it from RAM for all the threads
    or just ensure read and write happens from memory and not from l1 or l2 cash
    //it does not ensure thread safety
    Partially — it ensures visibility across threads:
    use case
    Shared configuration flags that are updated at runtime



    //read concurrency in collections


//Atomic integers F&F
AtomicInteger is a lock-free, thread-safe class used for atomic operations on integers. Instead of using synchronized blocks or explicit locks, it relies on CAS (Compare-And-Swap) operations provided by the CPU. Multiple threads can concurrently attempt updates, and if a CAS operation fails because another thread modified the value, the operation is retried. This avoids blocking and context-switch overhead associated with locks.

One limitation of CAS-based algorithms is the ABA problem, where a value changes from A to B and back to A. A CAS operation may incorrectly assume nothing changed because the final value matches the original value. This can be solved using versioned references such as AtomicStampedReference, which compares both the value and a stamp (version number) rather than only the value.



