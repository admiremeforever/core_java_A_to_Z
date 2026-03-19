package multithreding.monitorlock.sharedResourceExample;

public class ConsumeItemTask implements Runnable{
    SharedResource sharedResource;
    ConsumeItemTask( SharedResource sharedResource){
        this.sharedResource=sharedResource;
    }
    public void run(){
        System.out.println("ConsumerItem thread: "+Thread.currentThread().getName());
        sharedResource.consumeItem();
    }
}
