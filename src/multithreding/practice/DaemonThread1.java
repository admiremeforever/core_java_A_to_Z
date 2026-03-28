package multithreding.practice;

public class DaemonThread1 {
    public static void main(String[] args) {
        //Daemon Threads gets killed abruptly as soon as the user threads finished it's execution
        //They can be used in logging monitoring and Garbage collection
        Thread daemonthread = new Thread(()->{
            System.out.println("Hi I am a daemon thread I will go to sleep now ..");
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                System.out.println("Hi I woke up now and I will finish ..");
            }
        });

        daemonthread.setDaemon(true);
        daemonthread.start();
        System.out.println("I am main thread and I will finish now "+ Thread.currentThread().getName());
    }




}
