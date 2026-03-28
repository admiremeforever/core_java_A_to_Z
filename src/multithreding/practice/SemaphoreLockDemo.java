package multithreding.practice;

import java.util.concurrent.Semaphore;

public class SemaphoreLockDemo {
    public static void main(String[] args) {

        SemaphoreResource semaphoreResource = new SemaphoreResource();
        Runnable task = ()->semaphoreResource.useResource();
        for(int i=0;i<7;i++){
            new Thread(task,"Thread :"+i).start();

        }

    }
}

class SemaphoreResource{
   private final Semaphore semaphoreLock = new Semaphore(3);
    public void useResource(){
try{
    semaphoreLock.acquire();
    System.out.println("Semphore lock acquired by.." +Thread.currentThread().getName());
    Thread.sleep(3000);
    System.out.println("Semphore lock relased by.." +Thread.currentThread().getName());

}catch(Exception e){

} finally {
    semaphoreLock.release();
}
    }
}

//new Semaphore(n) → matlab ek saath maximum n threads ko kaam karne do
//Extra threads → wait karte hain tab tak jab tak koi thread kaam khatam karke permit release na kare
//Jaise hi koi thread kaam khatam karega / dead ho jaaye → ek waiting thread aage badh sakta hai