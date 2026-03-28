package multithreding.locksandcondition;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockResource {
    boolean resource = false;
    public void produce(ReentrantLock lock){
       // System.out.println("Producer started by : "+Thread.currentThread().getName());
        try{
            lock.lock();
            System.out.println("Lock acquired by thread: "+Thread.currentThread().getName() );
            resource=true;
            Thread.sleep(4000);
        } catch(Exception e){

        }
        finally {

        lock.unlock();
            System.out.println("Lock released by thread: "+Thread.currentThread().getName() +" "+ System.nanoTime());

        }
    }
}
