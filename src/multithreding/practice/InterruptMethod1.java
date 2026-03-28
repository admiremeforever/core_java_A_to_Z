package multithreding.practice;

public class InterruptMethod1 {
    public static void main(String[] args) {
   /*     Thread t1 = new Thread(()->{
            for(int i=0;i<100;i++)
                System.out.println(i);
        });
        t1.start();
        System.out.println("checking if interrupted "+ t1.isInterrupted());
        t1.interrupt();
        System.out.println("checking if interrupted "+ t1.isInterrupted());*/

       //neeche wale thread me manually check krte hai interrupt ka magic

                Thread t1 = new Thread(()->{
            for(int i=0;i<100;i++){
                System.out.println(i);


                  if(Thread.currentThread().isInterrupted()){
                      System.out.println("Sala mere ko interrupt kia aab mai exit ho jaunga ");
                      break;
                  }

            }

        });
        t1.start();
        System.out.println("checking if interrupted "+ t1.isInterrupted());
        t1.interrupt();
        System.out.println("checking if interrupted "+ t1.isInterrupted());


        Thread t2= new Thread(()->{
        try{
            System.out.println("t2 thread started and will go to sleep now "+Thread.currentThread().getName());
            Thread.sleep(5000);
        }catch(InterruptedException e){
            System.out.println(" t2 Thread got interrupted ..");
        }
        });
        t2.start();
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){

        }
        System.out.println("t2 is interrupted? checing before  t2.interrupt() is called "+t2.isInterrupted());

        t2.interrupt();
        System.out.println("t2 is interrupted? "+t2.isInterrupted());
        System.out.println("t2 is alive? "+t2.isAlive());


        //AA jao game samjhte hai
        // Jab thread blocked state (sleep/wait/join) me hota hai:
// thread.interrupt() call karne par:
// 1. thread ko jagaya jata hai
// 2. InterruptedException throw hoti hai
// 3. interrupt flag automatically reset (false) ho jata hai

// Jab thread normal running state me hota hai:
// thread.interrupt() sirf interrupt flag ko true set karta hai
// lekin agar thread us flag ko check nahi karta,
// toh execution normally chalta rehta hai



        //koi normal thread me isInterrupt condition daal kar hmlog keh sakte hai ki jab interrupt krke aab ye kaam kar





    }
}
