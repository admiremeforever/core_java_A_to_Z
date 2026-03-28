package multithreding.practice;

public class JoinMethod {
    public static void main(String[] args) {

        //Ek thrad dusre thread ke liye wait krega uske comlete hone tak
        //jo join method call kr rha yaha par t2 call kr rha toh t2 wait krega
        //jispar join call ho rha wo aapna comlete hoga yaha pat t1 par call ho rha
       Thread t1 = new Thread(()->{
           try {
               for(int i=0;i<49;i++){
                   System.out.println(i +" "+Thread.currentThread().getName());
               }
               System.out.println("babu sahab aab 2 second ke liye sone ja rhe ");
               Thread.sleep(2000);
               for(int i=49;i<69;i++){
                   System.out.println(i +" "+Thread.currentThread().getName());
               }
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       });


        Thread t2 = new Thread(()->{
            try {
               t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for(int i=99;i<138;i++) {
                    System.out.println(i + " " + Thread.currentThread().getName());
                }

        });

          t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();

}}
