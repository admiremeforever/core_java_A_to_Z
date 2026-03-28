package multithreding.practice;

import java.util.concurrent.atomic.AtomicInteger;

public class WithOrWithoutAtomicInteger {

     int  number = 0;
     AtomicInteger atomicInteger = new AtomicInteger(0);
    public void inceamentWithoutAI(){
        for(int i=0;i<50000;i++)
            number++;
    }

    public void inceamentWitAI(){
        for(int i=0;i<50000;i++)
            atomicInteger.incrementAndGet();
    }


    public static void main(String[] args) throws InterruptedException{
        WithOrWithoutAtomicInteger withOrWithoutAtomicInteger = new WithOrWithoutAtomicInteger();
        Thread t1 = new Thread(()->withOrWithoutAtomicInteger.inceamentWithoutAI());
        Thread t2 = new Thread(()->withOrWithoutAtomicInteger.inceamentWithoutAI());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(withOrWithoutAtomicInteger.number);
        Thread t3 = new Thread(()->withOrWithoutAtomicInteger.inceamentWitAI());
        Thread t4 = new Thread(()->withOrWithoutAtomicInteger.inceamentWitAI());
        t3.start();
        t4.start();
        t3.join();
        t4.join();

        System.out.println(withOrWithoutAtomicInteger.atomicInteger);
    }
}

/*
    AtomicInteger is a class from
👉 java.util.concurrent.atomic

    It allows thread-safe operations on integers without using locks

    usually
    read → increment → write
    Multiple threads → race condition 😬
    Core concept: CAS (Compare And Swap)

👉 AtomicInteger internally uses:

    CPU-level atomic instruction
    CAS (Compare-And-Swap)
🔁 CAS Logic
if (currentValue == expectedValue) {
        update to newValue
    }
else retry


    count.incrementAndGet();

    Internally:

            do {
        oldValue = current
        newValue = oldValue + 1
    } while (!CAS(oldValue, newValue))

            👉 If another thread changes value → retry

    count.incrementAndGet();

    Internally:

            do {
        oldValue = current
        newValue = oldValue + 1
    } while (!CAS(oldValue, newValue))

            👉 If another thread changes value → retry
    solved by indexing
Problem: ABA Problem
🧠 What is ABA?

Value changes from A → B → A
But CAS thinks nothing changed 😬
is resolved by   versioning / stamping*/
