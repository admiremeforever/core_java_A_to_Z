package multithreding.locksandcondition;

public class DemoOptemisticStampedLock {
    public static void main(String[] args) {
        StampedLockResourceOptimistic stampedLockResourceOptimistic = new StampedLockResourceOptimistic();

        Thread t1  = new Thread(()->stampedLockResourceOptimistic.produce());


        Thread t2 = new Thread(()->stampedLockResourceOptimistic.consume());
        t1.start();
        t2.start();
    }
}
