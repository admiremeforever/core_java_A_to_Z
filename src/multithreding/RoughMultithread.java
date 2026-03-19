package multithreding;

public class RoughMultithread {
    public static void main(String[] args) {

        //see carefully what's happening here we are passing thread test1 as parameter in the constructor of Thread t1 -> go and
        //check the constructor of Thread -> it takes runnable object as parameter ->
        //Test1 is not actually a thread rather since Thread class internally implemets run menthod so runnable only has the capablity
        //get passed as constructor parameter.
        //check by passing some other type of class which is not runnable in the thread constructor

        //why we need to override run method
        //for Runnable classes objects -> it invokes the runnable run object
        //for Normal extended thread it invokes the extended method
        Test1 test1 = new Test1();
        RoughMultithread roughMultithread = new RoughMultithread();
        Thread t1 = new Thread(test1);
        t1.start();

        ExtendThreadClass extendThreadClass = new ExtendThreadClass();
        extendThreadClass.start();
    }
}
