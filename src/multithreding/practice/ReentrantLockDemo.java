package multithreding.practice;

import multithreding.locksandcondition.ReentrantLockResource;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
//Exmaple for fair lock
        ReentrantLock reentrantLock = new ReentrantLock();

        Runnable task = ()->{
           // System.out.println("Thread trying to acquire lock... "+ Thread.currentThread().getName());
            reentrantLock.lock();
            try {
                System.out.println("reentrantLock acquired ... "+ Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
              //  System.out.println(Thread.currentThread().getName()+ " releasing the lock");
                reentrantLock.unlock();
            }
        };

        for(int i=0;i<10;i++){
            Thread th = new Thread(task, "Thread:" +i);
            th.start();

        }
    }
}


/*
From
java.util.concurrent.locks.ReentrantLock

        A flexible, explicit lock used for thread synchronization.

         Why “Reentrant”?

1)Same thread ek hi lock ko multiple times acquire kar sakta hai

2. tryLock() (Non-blocking)
👉 Lock available → acquire
👉 Lock busy → skip

3. tryLock with Timeout
infinite lock avoided
4. Interruptible Lock

 interrupt() se wait tod sakte ho
synchronized me possible nahi ❌
5). Fair Lock
ReentrantLock lock = new ReentrantLock(true);

👉 Threads ko FIFO order me lock milega order decide kar sakte hai */
