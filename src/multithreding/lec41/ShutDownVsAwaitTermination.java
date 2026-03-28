package multithreding.lec41;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutDownVsAwaitTermination {
    public static void main(String[] args)  {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Submitting a runnable task..1");
        });

        //shutdown() executos will not accet new task submissions however it will allow the
        //already submitted task to complete
        executorService.shutdown();

      try{
          //It waits for timeout time to check if    executorService.shutdown(); is complete it blocks the main thread
       boolean isTerminated = executorService.awaitTermination(2, TimeUnit.SECONDS);
          System.out.println("Is Terminated in 2 seconds: " +isTerminated);
      }catch(InterruptedException e){

      }

        try{
            //It waits for timeout time to check if    executorService.shutdown(); is complete it blocks the main thread
            boolean isTerminated = executorService.awaitTermination(7, TimeUnit.SECONDS);
            System.out.println("Is Terminated in 7 seconds: " +isTerminated);
        }catch(InterruptedException e){

        }
        System.out.println("Main thread is unblocked");
        //if i call below submit that is after shutdown is called it will throw runtime error
//        executorService.submit(()->{
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//            System.out.println("Submitting a runnable task..2");
//        });

    }
}
