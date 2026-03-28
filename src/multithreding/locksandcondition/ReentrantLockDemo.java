package multithreding.locksandcondition;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ReentrantLockResource r1 = new ReentrantLockResource();
        Thread t1 = new Thread(()->{
            r1.produce(lock);
        });
        ReentrantLockResource r2 = new ReentrantLockResource();
        Thread t2= new Thread(()->{
            r2.produce(lock);
        });

        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}
