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





