package multithreding;

public class DeadLockDemo {
    public static void main(String[] args) {
        ResourceDeadLock resourceDeadLock = new ResourceDeadLock();
        Thread t1 = new Thread(()-> {
            try {
                resourceDeadLock.method1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(()-> {
            try {
                resourceDeadLock.method2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }
}


class ResourceDeadLock{
    Object object1=new Object();
    Object object2 = new Object();

  public void method1() throws InterruptedException {
      synchronized (object1){
          System.out.println(Thread.currentThread().getName()+ " accquired lock on object1 ");
          Thread.sleep(1000);
          synchronized (object2){
              System.out.println(Thread.currentThread().getName()+ " accquired lock on object2 ");
          }
      }



  }

    public void method2() throws InterruptedException{
        synchronized (object2){
            System.out.println(Thread.currentThread().getName()+ " accquired lock on object2 ");
            Thread.sleep(1000);
            synchronized (object1){
                System.out.println(Thread.currentThread().getName()+ " accquired lock on object1 ");
            }
        }



    }



}