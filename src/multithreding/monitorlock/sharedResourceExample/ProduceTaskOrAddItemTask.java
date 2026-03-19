package multithreding.monitorlock.sharedResourceExample;

public class ProduceTaskOrAddItemTask implements Runnable{
    SharedResource sharedResource;

    ProduceTaskOrAddItemTask( SharedResource sharedResource){
        this.sharedResource= sharedResource;
    }
    public void run(){
        System.out.println("ProducerOrAddItem thread: "+Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sharedResource.addItem();
    }
}
