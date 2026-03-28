package multithreding.locksandcondition;

import java.util.concurrent.locks.StampedLock;

public class StampedLockResourceOptimistic {
int a  = 10;


StampedLock lock = new StampedLock();

//notic no lock put in produce method
    public void produce( ){
        long stamp = lock.tryOptimisticRead();
        try{
            System.out.println("Taken Optimistic lock..");

            Thread.sleep(6000);

            if(lock.validate(stamp)){
                a= 99;
                System.out.println("Updated a value successfully by producer "+Thread.currentThread().getName());
            }

            System.out.println(a);

        }catch(Exception e){

        }


    }


    public void consume(){
        long stamp = lock.writeLock();
        try{

            System.out.println("Stamped write lock acquired by : " +Thread.currentThread().getName());
            a = 9;
        }catch(Exception e){

        }
        finally{
            lock.unlockWrite(stamp);
            System.out.println("Write Lock released by : "+ Thread.currentThread().getName());
        }

    }






}
