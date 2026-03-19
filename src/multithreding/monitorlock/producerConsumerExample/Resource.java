package multithreding.monitorlock.producerConsumerExample;

import java.util.ArrayList;

public class Resource {

    // I could have used list here as well
    ArrayList<Integer> list ;
    int size ;
    Resource(int size){
        this.size=size;
        this.list=new ArrayList<>();
    }
    public synchronized void producer(int i) throws Exception{
        while(this.list.size()==this.size){
            System.out.println("List size is full foing to wait ..");
            wait();
        }
          list.add(i);
        System.out.println(list  +" : " + "producer Thread..");
      notifyAll();



    }

    public synchronized void consumer() throws InterruptedException {
        while(this.list.isEmpty()){
            System.out.println("List is Empty so consumer is going to wait...");
            wait();
        }
        System.out.println(list  +" : " + "cosnsumer Thread..");
        list.remove(list.size()-1);
        notify();
    }


}
