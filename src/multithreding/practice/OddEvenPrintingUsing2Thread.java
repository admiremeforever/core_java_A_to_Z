package multithreding.practice;

public class OddEvenPrintingUsing2Thread {
    public static void main(String[] args) {
        OddEven oddEven = new OddEven(1,20);
        Thread printOdd  = new Thread(()->oddEven.printOdd());
        Thread printEven  = new Thread(()->oddEven.printEven());
        printEven.setName("printEven");
        printOdd.setName("printOdd");
        printEven.start();
        printOdd.start();
    }
}

class OddEven{
    int counterStart;
    int end;



    OddEven(int counterStart,int end){
        this.counterStart=counterStart;
        this.end=end;
    }

    public  synchronized void printEven(){
      while(counterStart<end){
          if(counterStart%2==1){
              try {
                  wait();
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
          else{
              System.out.println(counterStart +" printed by Thread : " +  Thread.currentThread().getName());
              counterStart++;
              notifyAll();
          }

      }
    }

    public synchronized void printOdd(){
        while(counterStart<end){
            if(counterStart%2==0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                System.out.println(counterStart +" printed by Thread : " +  Thread.currentThread().getName());
                counterStart++;
                notifyAll();
            }

        }
    }
}
