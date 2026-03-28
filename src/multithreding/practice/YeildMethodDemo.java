package multithreding.practice;

public class YeildMethodDemo {
    public static void main(String[] args) {

 /*      yield() tells the scheduler:
 "I am willing to pause and let other threads run"
        It is just a hint, NOT a guarantee.

        Thread may pause ✅
        Thread may continue running ❌ (yes, this can happen)
        When a thread calls yield():

        It moves from Running → Runnable state
        Scheduler may pick another thread of same priority*/

        Runnable task = ()->{
            for(int i =0; i<10;i++){
                System.out.println(i +Thread.currentThread().getName());
                Thread.yield();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
    }
}
