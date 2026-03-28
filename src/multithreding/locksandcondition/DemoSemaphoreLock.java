package multithreding.locksandcondition;

public class DemoSemaphoreLock {
    public static void main(String[] args) {
        SemaphoreLockResource semaphoreLockResource = new SemaphoreLockResource();
        Thread t1 = new Thread(()->semaphoreLockResource.producer());
        Thread t2 = new Thread(()->semaphoreLockResource.producer());

        Thread t3 = new Thread(()->semaphoreLockResource.producer());
        Thread t4 = new Thread(()->semaphoreLockResource.producer());

        t1.setName("t1"); t2.setName("t2"); t3.setName("t3"); t4.setName("t4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
