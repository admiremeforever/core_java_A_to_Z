package multithreding.practice;

 class  SharedVariableCount {
     //if no volatile used here then although the Main thread updates its value to false
     //but still the thread1 rads it from cashed value and it would be still true so the looop
     // ever ends
   // public  boolean running = true;
     public volatile boolean running = true;
}

public class WithOrWithoutVolatileExample {
    public static void main(String[] args) {
        SharedVariableCount sharedVariableCount = new SharedVariableCount();
        Thread thread1 = new Thread(()->{
            int count = 0;
            while(sharedVariableCount.running){
                count++;
            }
            System.out.println("Count : " +count);
        });
        thread1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        sharedVariableCount.running = false;
    }
}
