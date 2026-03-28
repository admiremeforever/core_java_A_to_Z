package multithreding.lec41;

import java.util.concurrent.*;

public class ScheduledThreadPoolExecutorDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //ScheduledThreadPoolExecutor is child of ThreadPool Executor
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);

        //4 methods are important here
        //1)schedule(Runnable..) schedules a runnable task after specific delay , task runs only one time
        scheduledThreadPoolExecutor.schedule(()->{
            System.out.println("I am a runnable task so i cant return anything ...");
          try{
              Thread.sleep(100);
          }catch(InterruptedException e){

          }
        }, 5, TimeUnit.SECONDS);

        //2)schedule(Callable..) schedules a Callable task after specific delay , task runs only one time
    Future<String> taskObj= scheduledThreadPoolExecutor.schedule(()->{
            System.out.println("I am a Callable task so i can return anything ...");
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){

            }
            return "Returning Callable Task";
        }, 7, TimeUnit.SECONDS);

        System.out.println(taskObj.get());


        //3)scheduleAtFixedRate(Runnable..) schedules a runnable task after repeatedExecution with fixed rate ,

   Future<?>  schecduleObject1=    scheduledThreadPoolExecutor.scheduleAtFixedRate(()->{
            System.out.println("I am a Runnable task from scheduleAtFixedRate  ...");
            try{
                Thread.sleep(100);
            }catch(InterruptedException e) {

            }
        }, 2, 5,TimeUnit.SECONDS);


//we can cancel this cancelling schecduleObject1 by calling cancel method
        Thread.sleep(20000);

        schecduleObject1.cancel(true);



        //4)scheduleAtFixedDelay(Runnable..) schedules a runnable task after repeatedExecution runs after previous task finishes + delay ,

        Future<?>  schecduleObject2=    scheduledThreadPoolExecutor.scheduleWithFixedDelay(()->{
            System.out.println("I am a Runnable task from scheduleWithFixedDelay  ...");
            try{
                Thread.sleep(10000);
            }catch(InterruptedException e) {

            }
        }, 2, 3,TimeUnit.SECONDS);


//we can cancel this cancelling schecduleObject1 by calling cancel method
        Thread.sleep(20000);

        schecduleObject2.cancel(true);



    }
}
