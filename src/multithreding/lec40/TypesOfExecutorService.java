package multithreding.lec40;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TypesOfExecutorService {
    public static void main(String[] args) {
        //Type 1 :- Fixed threadpool executor used when we exactly know the number of Asnc task required
        ExecutorService fixedThreadPoolExecutor = Executors.newFixedThreadPool(10);
        fixedThreadPoolExecutor.submit(()-> System.out.println("This is an example of ExecutorService with FixedThreadPool"));


        //Type 2 : Cashed ThreadPool

        ExecutorService cashedThreadPoolExecutor = Executors.newCachedThreadPool();
        cashedThreadPoolExecutor.submit(()-> System.out.println("This is example of cashedThreadPoolExecutor"));


        //Type 3 : SingleThreadPoolExecutor
        ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
        singleExecutorService.submit(()-> System.out.println("This is example of singleExecutorService"));
    }
}
