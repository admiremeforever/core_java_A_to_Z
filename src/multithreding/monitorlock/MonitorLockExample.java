package multithreding.monitorlock;

public class MonitorLockExample {
    public synchronized void task1() throws InterruptedException  {
        System.out.println("inside task1 method..will go to sleep now ");
      Thread.sleep(5000);
        System.out.println("Task 1 is ending now...");
    }

    public void task2(){
        System.out.println("Inside task 2 before synchronization");

        synchronized (this){
            System.out.println("Task 2 inside synchronized block..");
        }
        System.out.println("Task 2 ended..");
    }


    public  void task3()  {
        System.out.println("inside task3 method.. ");

        System.out.println("Task 3 is ending now...");
    }


}
