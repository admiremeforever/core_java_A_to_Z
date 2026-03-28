package multithreding.locksandcondition;

import java.util.concurrent.locks.ReadWriteLock;

public class ReadWriteResource {
    boolean isAvailable = false;
    public void readResource(ReadWriteLock lock ){
        try{
            lock.readLock().lock();
            System.out.println("Read lock acquired by thread "+Thread.currentThread().getName());
            Thread.sleep(5000);
        }catch(Exception e){

        }finally{
            lock.readLock().unlock();
            System.out.println( System.nanoTime()+ " Read lock released by thread "+Thread.currentThread().getName());
        }
    }


    public void writeResource(ReadWriteLock lock ){
        try{
            lock.writeLock().lock();
            System.out.println(System.nanoTime() + " Write lock acquired by thread "+Thread.currentThread().getName());
            isAvailable=false;
        }catch(Exception e){

        }finally{
            lock.writeLock().unlock();
            System.out.println("Write lock released by thread "+Thread.currentThread().getName());
        }
    }


}
