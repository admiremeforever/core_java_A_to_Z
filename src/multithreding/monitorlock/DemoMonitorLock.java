package multithreding.monitorlock;

public class DemoMonitorLock {
    public static void main(String[] args) {
        //to demonstrate we need to make sure that same object of monitorLockExample is used throughout

        MonitorLockExample monitorLockExample = new MonitorLockExample();
        MonitorLockThread1 monitorLockThread1 = new MonitorLockThread1(monitorLockExample);
        MonitorLockThread2 monitorLockthread2 = new MonitorLockThread2(monitorLockExample);

      //  MonitorLockThread3 monitorLockthread3 = new MonitorLockThread3(monitorLockExample);
        Thread t1 = new Thread(monitorLockThread1);
        Thread t2 = new Thread(monitorLockthread2);
        //or we could have used lambda -> meaning passing methods as parameter -> here
        //for task3  i wil use that

        Thread t3 = new Thread(()->monitorLockExample.task3());
        t1.start();
        t2.start();
        t3.start();

//here we saw that when monitor lock happens on task1 t goes inside sleep now it is sleeping ->
        //now we have called thread 2 -> it starts working but task 2 is synchronized with this keyword so it
        //has to wait for thread 1(task1) to finish
        //but thread3(task3) is not synchronized so it will not wait

        //monitor lock helps to make sure only one thread goes inside a particular
        // section of code (when we talk about an object) it may be different method as well
        //here the object is  a shared resource on which we are applying lock


    }
}
