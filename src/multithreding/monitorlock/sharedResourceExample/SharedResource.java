package multithreding.monitorlock.sharedResourceExample;

public class SharedResource {
    boolean itemAvailable = false;
    public synchronized void addItem(){
        itemAvailable = true;
        System.out.println("Item added by: "+Thread.currentThread().getName()+" and invoking all threads which are waiting..");
        notifyAll(); //see its internal impl for understanding what it does;

    }
    public synchronized void consumeItem(){
        System.out.println("ConsumeItem invoked by: "+Thread.currentThread().getName() );
        while(!itemAvailable){
            try{
                System.out.println("Thread "+Thread.currentThread().getName()+" is waiting now");
                Thread.sleep(500);
                System.out.println("Monitor lock is still acquired can't enter addItem");
                wait();//also understand wait method releases the monitor lock and the add item execution starts after this
                // and if i dont write wait() here the lock will never be released from this method
            }catch (Exception e){

            }
        }
        System.out.println("Item Consumed by : " +  Thread.currentThread().getName());
        itemAvailable = false;
    }


}
