package multithreding.locksandcondition;

import java.util.concurrent.Semaphore;

public class SemaphoreLockResource {
    int resource = 10;
    Semaphore lock = new Semaphore(2);
    public void producer(){

        try{
            lock.acquire();
            resource++;
            System.out.println("Lock acquired by Thread "+Thread.currentThread().getName() +" "+ System.nanoTime());
            Thread.sleep(100);
        }catch(Exception e){

        }finally{
            lock.release();
            System.out.println("Lock released by Thread "+Thread.currentThread().getName() +" "+ System.nanoTime());
        }
    }
}
