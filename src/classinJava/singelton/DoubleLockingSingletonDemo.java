package classinJava.singelton;

import org.w3c.dom.ls.LSOutput;

public class DoubleLockingSingletonDemo {
    public static void main(String[] args) {
        DoubleLockingSingleton obj1 = DoubleLockingSingleton.getInstance();
        DoubleLockingSingleton obj2 = DoubleLockingSingleton.getInstance();
        System.out.println(obj1==obj2);
    }



}


class DoubleLockingSingleton{
    private static volatile DoubleLockingSingleton instance;
   private DoubleLockingSingleton(){

   }

   public static DoubleLockingSingleton getInstance(){

         if(instance==null){
             synchronized (DoubleLockingSingleton.class){
                 if(instance==null){
                     instance= new DoubleLockingSingleton();
                 }

             }

         }

       return instance;
   }

}

/*
Concept	Why it matters
volatile	Prevents partially constructed instance visibility
double if(instance == null)	First check avoids unnecessary synchronization, second check ensures singleton
synchronized	Ensures only one thread can create the instance*/
