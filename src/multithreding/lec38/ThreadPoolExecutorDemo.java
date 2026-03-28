package multithreding.lec38;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 1,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(3),
              new CustomThreadFactory(),
                new CustomRejectHandler());

        for(int i=0;i<8;i++){
            threadPoolExecutor.execute(()->{
                try {
                    Thread.sleep(5000);
                    System.out.println("Thread name: "+ Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        threadPoolExecutor.shutdown();
    }
}

class CustomRejectHandler implements RejectedExecutionHandler{


    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task Denied: "+ r.toString());
    }
}


class CustomThreadFactory implements ThreadFactory{
    private int count = 0;
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("Manga" +count++);
        return thread;
    }
}


