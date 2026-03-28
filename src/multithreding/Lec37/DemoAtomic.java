package multithreding.Lec37;

public class DemoAtomic {
    public static void main(String[] args) throws InterruptedException {
        AtomicResource atomicResource = new AtomicResource();

//        for(int i=0;i<400;i++)
//            atomicResource.increament();
//        System.out.println(atomicResource.get());
        //doing it with thread

        Thread t1 = new Thread(()->{
            for(int i=0;i<2000;i++)
                atomicResource.increament();
        });

        Thread t2= new Thread(()->{
            for(int i=0;i<2000;i++)
                atomicResource.increament();
        });

        t1.start();
        t2.start();
t1.join();
t2.join();
        System.out.println(atomicResource.get());
    }

}
