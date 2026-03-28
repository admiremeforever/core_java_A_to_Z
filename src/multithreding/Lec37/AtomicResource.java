package multithreding.Lec37;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicResource {

    //without using atomic integer
    AtomicInteger counter = new AtomicInteger(0);

    public void increament() {
        counter.incrementAndGet();
    }

    public int get() {
        return counter.get();
    }


















    //without using atomic integer
//    int counter;
//    public  void increament(){
//        counter++;
//    }
//
//    public int get(){
//        return counter;
//    }
}
