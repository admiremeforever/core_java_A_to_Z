package multithreding.threadjoinandriority;

public class DeamonThread {
    public static void main(String[] args) throws InterruptedException {
        //normal threads are user threads
        //we need to do thread.setDeamon(true)
        //deamon thread gets finished as soon as all the user  thread is finished working
        //deamon thread is alive till any user thread is alive

        //in garbage collector deamon thread is used , in autosave deamon thread is used can be used in
        //Background Polling / Scheduler
        Thread deamonThread = new Thread(()->{
           while(true){
               System.out.println("deamon thread is running ...");

               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }


           }
        });

        deamonThread.setDaemon(true);
        deamonThread.start();

        for(int i=0;i<10;i++){
            System.out.println("Main thread is running " +i);
              Thread.sleep(1000);
        }

        System.out.println("Main finished..");



    }
}
