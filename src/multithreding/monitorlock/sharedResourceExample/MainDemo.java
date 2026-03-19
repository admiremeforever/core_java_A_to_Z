package multithreding.monitorlock.sharedResourceExample;

public class MainDemo {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread producerOrAddItemThread = new Thread(new ProduceTaskOrAddItemTask(sharedResource));
        Thread consumerThread = new Thread(new ConsumeItemTask(sharedResource));
        producerOrAddItemThread.start();
        consumerThread.start();


        //description
        //we call the addTask and consume task together and both are synchronized but before we enter to
        // additem it is made to sleep(before entering inside) so the consume method is entered first and
        // it aquires lock and now it invokes wait method whcih release the monito lock and then addItem is executed
    }
}
