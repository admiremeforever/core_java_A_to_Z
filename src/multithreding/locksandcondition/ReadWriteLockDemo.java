package multithreding.locksandcondition;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();

        ReadWriteResource r = new ReadWriteResource();
        Thread t0 = new Thread(()->r.readResource(lock));

        Thread t1 = new Thread(()->r.readResource(lock));


        Thread t2 = new Thread(()->r.writeResource(lock));

        t0.start();
        t1.start();
        t2.start();

    }
}
