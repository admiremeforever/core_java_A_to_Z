package classinJava;

public class BilPughSingletonDemo {
}
 class BillPughSingleton{
    private BillPughSingleton(){

    }
    private static class BillPughSingletonHelper{
         private static final BillPughSingleton instance = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return BillPughSingletonHelper.instance;
    }

}


/*3️⃣ Why Bill Pugh Singleton is better
Feature	Explanation
Lazy loading	Instance created only when needed
Thread safe	JVM ensures class loading is synchronized
Performance	No synchronization overhead like double-checked locking
Simplicity	Easy to read and maintain

💡 Memory tip:

JVM guarantees that static inner classes are loaded only once,
and in a thread-safe way. That’s why this pattern is so reliable.*/
