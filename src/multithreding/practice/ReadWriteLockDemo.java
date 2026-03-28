package multithreding.practice;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource();
        Thread t0 = new Thread(()->sharedResource.read());
        Thread t1 = new Thread(()->sharedResource.read());
        Thread t2 = new Thread(()->sharedResource.read());
        t0.start();t1.start();t2.start();
        //No need of this sleep because even if the any read is active write threads won't proceed
         // Thread.sleep(20000);
        Thread t4 = new Thread(()->sharedResource.write(10));
        Thread t5 = new Thread(()->sharedResource.write(11));
        Thread t6 = new Thread(()->sharedResource.write(12));
        t4.start();t5.start();t6.start();
    }
}


 class  SharedResource {
     private int data = 0;
     private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

     public void read() {
         try {
             readWriteLock.readLock().lock();
             System.out.println("Reading data " + data);
             System.out.println("Going to sleep Now" +Thread.currentThread().getName());
             Thread.sleep(3000);
             System.out.println("So kar uth gaya bhai" +Thread.currentThread().getName());

         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         } finally {
             readWriteLock.readLock().unlock();
         }
     }

     public void write(int value) {
         try {
             readWriteLock.writeLock().lock();
             System.out.println("before updating  data " + data);
             data = value;
             System.out.println("After Updating data " + data);
             Thread.sleep(3000);
             System.out.println("SO ar uth gaya bhai" +Thread.currentThread().getName());

         } catch (InterruptedException e) {
             throw new RuntimeException(e);

         } finally {
             readWriteLock.writeLock().unlock();
         }
     }


 }
/*

A Read-Write Lock in Java is a synchronization mechanism that allows:

Multiple threads to read simultaneously
But only one thread to write at a time
And no reads while writing is happening

This improves performance compared to a normal lock when reads are frequent and writes are rare.
Main Interface

Java provides this via:

ReadWriteLock

The most commonly used implementation is:

ReentrantReadWriteLock

A ReadWriteLock has two locks:

Read Lock
Multiple threads can acquire it together
Only if no thread holds the write lock
Write Lock
Exclusive (only one thread)
Blocks both readers and other writers*/
