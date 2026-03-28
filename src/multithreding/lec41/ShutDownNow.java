package multithreding.lec41;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ShutDownNow {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(()->{
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Submitting a runnable task..1");
        });
//it terminates all the tasks does not even waits for the current running task
   List<Runnable> taskObj= executorService.shutdownNow();
        System.out.println(taskObj);


        try{
            //It waits for timeout time to check if    executorService.shutdown(); is complete it blocks the main thread
            boolean isTerminated = executorService.awaitTermination(2, TimeUnit.SECONDS);
            System.out.println("Is Terminated in 2 seconds: " +isTerminated);
        }catch(InterruptedException e){

        }
    }
}
