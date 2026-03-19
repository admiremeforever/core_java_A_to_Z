package multithreding.monitorlock;


public class MonitorLockThread2 implements Runnable{

    MonitorLockExample monitorLockExample;
    public MonitorLockThread2(MonitorLockExample monitorLockExample){
        this.monitorLockExample = monitorLockExample;
    }



    public void run(){

            monitorLockExample.task2();}

}
