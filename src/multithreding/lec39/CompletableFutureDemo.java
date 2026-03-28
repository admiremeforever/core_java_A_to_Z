package multithreding.lec39;

import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) {

        try{
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1,
                    TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(10),
                    Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy()
            );

            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> {
                //this is a task that needs to be completed by thread
                return "Task Completed";
            },threadPoolExecutor);

            System.out.println(asyncTask1.get());



            //thenApply and thenApplyAsync demo

            CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(()->{
                System.out.println("Thread name that runs supplyAsync: " + Thread.currentThread().getName());
                return "Concept and";
            },threadPoolExecutor).thenApply((String val)->{
                System.out.println("Thread Name that runs thenApply: "+Thread.currentThread().getName());
                return val+"Coding";
            });

            System.out.println("Thread Name after asyncTask2 is run: "+Thread.currentThread().getName());


            CompletableFuture<String> asyncTask3 = CompletableFuture.supplyAsync(()->{
                System.out.println("Thread name that runs supplyAsync: " + Thread.currentThread().getName());
                return "Concept and";
            },threadPoolExecutor).thenApplyAsync((String val)->{
                System.out.println("Thread Name that runs thenApplyAsync: "+Thread.currentThread().getName());
                return val+"Coding";
            });

            System.out.println("Thread Name after asyncTask3 is run: "+Thread.currentThread().getName());


            System.out.println("*************************thenAply & thenApplyAsync finished**************");
        }catch (Exception e){


        }

    }


}
