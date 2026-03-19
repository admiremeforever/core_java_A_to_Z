package multithreding.monitorlock;

public class MonitorLockThread1  implements Runnable{
    MonitorLockExample monitorLockExample;
 public    MonitorLockThread1(MonitorLockExample monitorLockExample){
     this.monitorLockExample = monitorLockExample;
 }



    public void run(){
        try {
            monitorLockExample.task1();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
