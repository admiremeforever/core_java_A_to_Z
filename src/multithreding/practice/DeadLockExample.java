package multithreding.practice;

public class DeadLockExample {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Thread t1 = new Thread(()->resource.method1());
        Thread t2 = new Thread(()->resource.method2());
        t1.start();
        t2.start();

        //understand the game here
        //t1 acquired lock on resource1 and t2 acquired lock on resource2, now t1 for its completion wants to
        //acquire lock on resource2 buts its not available in same way t2 wants to acquire lock on resource 1 but it is
        //locked
    }
}

class Resource{
    Object resource1 = new Object();
    Object resource2 = new Object();
    public void method1(){
        synchronized (resource1){
            System.out.println("lock acquired on resource1 by thread" + Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){

            }
            synchronized ((resource2)){
                System.out.println("lock acquired on resource2 by thread" + Thread.currentThread().getName());
            }
        }
    }


    public void method2(){
        synchronized (resource2){

            System.out.println("lock acquired on resource2 by thread" + Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){

            }
            synchronized ((resource1)){
                System.out.println("lock acquired on resource1 by thread" + Thread.currentThread().getName());
            }
        }
    }

}
