package multithreding.monitorlock.producerConsumerExample;

public class DemoProducerConsumer {
    public static void main(String[] args) {

        //larn that wait() method releases the monitored lock used by synchronized --its vvi
        Resource resource = new Resource(1);
        Thread producerThread = new Thread(()-> {
            try {
                for(int i=0;i<6;i++){
                    resource.producer(i);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        Thread conSumerThread = new Thread(()-> {

            try {
                for(int i=0;i<6;i++){
                    resource.consumer();
                }

            }
            catch(Exception e) {
                throw new RuntimeException();
            }


        } );

        producerThread.start();
        conSumerThread.start();
    }
}
