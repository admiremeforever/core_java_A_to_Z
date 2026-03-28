package multithreding.lec39;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) {;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1,
                TimeUnit.HOURS,new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
    Future<?>  futureObj = threadPoolExecutor.submit(()->{
        try{
            Thread.sleep(7000);
            System.out.println("this is a task which thread will execute");

        }catch(Exception e){

        }

        });

    //NOTE :- submit method of ThreadPoolExecutor is overloaded in 3 types..check all the types
        System.out.println("Is done? : " + futureObj.isDone());

      try{
          futureObj.get(2,TimeUnit.SECONDS);
      }catch(TimeoutException e){
          System.out.println("Timeout occured waiting for the task..");
      }catch(Exception e){
          System.out.println("Unknown error occured..");
      }

        try{
            futureObj.get();
            //if you understand below line and know its outout you are in good position
           // System.out.println( "Checking if futureObj.get() has any value "+futureObj.get());
        }catch(Exception e){
            System.out.println("Unknown error occured..");
        }

        System.out.println("Is done? : " + futureObj.isDone());
        System.out.println("Is cancelled? : " + futureObj.isCancelled());

    }
}
