package multithreding.practice;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchesDemo {
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Runnable task =  ()->{
     synchronized (lock)   {  try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("I am task from thread "+Thread.currentThread().getName());
            countDownLatch.countDown();}
        };


        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        t1.start();t2.start();t3.start();
        countDownLatch.await();

        System.out.println("Main thread is going to end..");

    }
}
/*

countDownLatch.countDown() count ko decrease karta hai starting from wahtever paramete we have passed in constructor of
CountDownLatch
countDownLatch.await() main thread ko rokta hai
Jab count 0 ho jata hai → main thread aage badhta hai*/
