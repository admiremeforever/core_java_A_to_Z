package multithreding.lec39;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SubmitMethodUseCase {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 1,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        //submit method use case  1

        Future<?> futureObject1 = threadPoolExecutor.submit(()-> System.out.println("Task 1 with Runnable"));

        try{
          Object object=  futureObject1.get();
          System.out.println("Checking the value of object " +object);
        }catch(Exception e){

        }



        //submit method use case  2
        List<Integer> list= new ArrayList<>();
        Future<List<Integer>> futureObject2 = threadPoolExecutor.submit(()-> {
            list.add(100);
            System.out.println("Task 2 with Runnable and a return type" );
        },list);

        try{
            List<Integer> output=  futureObject2.get();
            System.out.println("Task 2 with Runnable and a return type"+output );
        }catch(Exception e){

        }

        //submit method use case  3
        Future<Integer> futureObject3 = threadPoolExecutor.submit(()-> {
            System.out.println("Task 3 with Callable  return type");
            return 5;
        });

        try{
            Integer output=  futureObject3.get();
            System.out.println("Task 3 with Callable and a return type : "+ output);
        }catch(Exception e){

        }


    }
}
