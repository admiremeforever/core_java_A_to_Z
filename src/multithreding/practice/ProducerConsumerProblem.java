package multithreding.practice;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerProblem {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerResource producerConsumerResource = new ProducerConsumerResource(10);
        Thread producerThread = new Thread(()->producerConsumerResource.produce());
        Thread consumerThread = new Thread(()->producerConsumerResource.consume());
        producerThread.setName("producerThread");
        consumerThread.setName("consumerThread");
        consumerThread.start();
        producerThread.start();
        Thread.sleep(5000);
        producerThread.interrupt();
        consumerThread.interrupt();



    }
}


class ProducerConsumerResource{
    List<Integer> list ;
    int limit;
    ProducerConsumerResource(int limit){
        this.limit=limit;
        list = new ArrayList<>();
    }
    public synchronized void produce() {
        while (!Thread.currentThread().isInterrupted()) {
            while (list.size() == limit) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            list.add(100*(int) Math.random());
            System.out.println(list);
            notifyAll();

        }
    }
    public synchronized void consume() {
        while (!Thread.currentThread().isInterrupted()) {
            while (list.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
            list.remove((list.size()-1));
            System.out.println(list);
            notifyAll();

        }
    }
    }

