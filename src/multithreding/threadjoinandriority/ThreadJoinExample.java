package multithreding.threadjoinandriority;

public class ThreadJoinExample {
    public static void main(String[] args) throws InterruptedException {
        //when join method is invoked on a thread object, current thread will be blocked
        //and waits for a specific thread to finish


        //the thread that waits is the one that is executing, not the one on which join method is called like
        //in the line 21 oneToHundred.join();  hundredOneTwoHundred will call the so thread hundredOneTwoHundred
        //will wait for thread oneToHundred to complete
        Thread oneToHundred = new Thread(()->{

            for(int i=0;i<100;i++){
                System.out.println(i );
            }
        });




        Thread hundredOneTwoHundred = new Thread(()->{
           try{
               oneToHundred.join();
           }
           catch(Exception ignored){

           }
            for(int i=101;i<159;i++){
                System.out.println(i );
            }
        });
        oneToHundred.start();
        hundredOneTwoHundred.start();

        System.out.println(hundredOneTwoHundred.getPriority());





    }
}
