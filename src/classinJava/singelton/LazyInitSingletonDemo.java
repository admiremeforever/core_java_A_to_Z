package classinJava.singelton;

public class LazyInitSingletonDemo {
    LazyInitSingleton lazyInitSingleton = LazyInitSingleton.getInstance();
}

class LazyInitSingleton{
    private static LazyInitSingleton instance;
    private LazyInitSingleton( ){

    }
    //thread unsafe
    public static LazyInitSingleton getInstance(){
        if(instance==null){
            instance = new LazyInitSingleton();
        }
        return instance;
    }

    //thread safe
    public synchronized  static LazyInitSingleton getInstanceSynchronized(){
        if(instance==null){
            instance = new LazyInitSingleton();
        }
        return instance;
    }
}
