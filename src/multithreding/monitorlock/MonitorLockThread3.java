package multithreding.monitorlock;




public class MonitorLockThread3 implements Runnable{
    MonitorLockExample monitorLockExample ;
    public MonitorLockThread3( MonitorLockExample monitorLockExample){
        this.monitorLockExample = monitorLockExample;
    }




    public void run(){

        monitorLockExample.task3();}

}
