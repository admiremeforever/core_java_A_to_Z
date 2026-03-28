package multithreding.practice;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
    /*    CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        Runnable task1 = ()->{

             System.out.println("Task 1 started by thread ..." + Thread.currentThread().getName());
             try {
                 Thread.sleep(2000);
                 cyclicBarrier.await();
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             } catch (BrokenBarrierException e) {
                 throw new RuntimeException(e);
             }
             System.out.println("Task 1 ended by thread ..." + Thread.currentThread().getName());
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task1);
        Thread t3 = new Thread(task1);
        t1.start();t2.start();t3.start();*/

        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(3);

        Runnable task2 = ()->{

            System.out.println("Task 2 started by thread ..." + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
                cyclicBarrier1.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Task 2 ended by thread ..." + Thread.currentThread().getName());
        };

        Thread t4 = new Thread(task2);
        Thread t5 = new Thread(task2);
        Thread t6 = new Thread(task2);
        Thread t7 = new Thread(task2);
        Thread t8 = new Thread(task2);
        Thread t9= new Thread(task2);
        t4.start();t5.start();t6.start();t7.start();t8.start();;t9.start();

    }
}

/*A CyclicBarrier lets a fixed number of threads wait for each other at a common point (await()).
Once the required number of threads reach the barrier, all of them are released together and execution continues.
❌ The incorrect part

“If CyclicBarrier(3) and we have 4 threads… 4th thread keeps waiting forever”

This is not correct.

        ✅ What actually happens
CyclicBarrier(3) means:
Every group of 3 threads forms a cycle.
After 3 threads call await():
Barrier is tripped
All 3 threads proceed
Barrier is automatically reset

👉 Then the 4th thread:

Becomes part of the next cycle
It will wait for 2 more threads, not forever
🔄 Example scenario
Threads: T1, T2, T3, T4

Barrier size: 3

T1 → await()
T2 → await()
T3 → await()
✅ Barrier trips → T1, T2, T3 proceed
T4 → await()
⏳ Now waiting for 2 more threads (next cycle)
⚠️ When would a thread wait forever?

Only if:

Required number of threads never arrive, OR
Threads are stuck / crashed / not calling await()
🧠 Key takeaway
CyclicBarrier is reusable (cyclic) — it resets after each batch.
Threads don’t “get stuck forever” unless the required count is never reached.*/
