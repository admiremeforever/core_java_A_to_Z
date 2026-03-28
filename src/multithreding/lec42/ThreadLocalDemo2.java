package multithreding.lec42;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo2 {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocalObj = new ThreadLocal<>();
        ExecutorService poolObj  = Executors.newFixedThreadPool(5);
        poolObj.submit(()->{

            threadLocalObj.set(Thread.currentThread().getName());
            System.out.println( "I am from before loop tasks: and my thread is "+Thread.currentThread().getName()+ " "+threadLocalObj.get());
            //used to clean the threadLocalObj in scenarios when thread my get reuesd
            threadLocalObj.remove();
        });

        for(int i=0;i<15;i++){
            poolObj.submit(()->{
                System.out.println( "I am from for loop tasks: and my thread is "+Thread.currentThread().getName()+ " "+ threadLocalObj.get());
            });



            //just for conceptual clarity
            //above we have 16 tasks that can be distributed among 5 threads ..it may e possible that one tread that executed
            // the before loop tasks pick up some tasks from the loop and in that case this is a scenario of same thread being resued now
            //since we have set threadlocal var for this thread its value will be present for second task as well as the thread is
            //being reused so we should clean it up by using threadLocalObj.remove()
        }
    }


}
