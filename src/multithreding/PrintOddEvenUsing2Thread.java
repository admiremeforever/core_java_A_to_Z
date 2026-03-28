package multithreding;

public class PrintOddEvenUsing2Thread {
    public static void main(String[] args) {
        Resource resource = new Resource(1, 34);
       Thread printEven = new Thread(()->resource.printEven());
        Thread printOdd = new Thread(()->resource.printOdd());

        printEven.start();
        printOdd.start();


    }
}

class Resource  {
 int start;
 int end;
    Resource(int start,int end){
        this.start=start;
        this.end=end;
    }

    public synchronized void printOdd(){
        while(start<=end){
            if(start%2==0){
               try{
                   wait();
               }catch (InterruptedException e){

               }
            }else{
                System.out.println("Printing Odd : " + start + " :" + Thread.currentThread().getName());
                start++;
                notify();
            }

        }
    }

    public synchronized void printEven(){
        while(start<=end){
            if(start%2==1){
                try{
                    wait();
                }catch (InterruptedException e){

                }
            }else{
                System.out.println("Printing even : " + start + " :" + Thread.currentThread().getName());
                start++;
                notify();
            }

        }
    }

}
