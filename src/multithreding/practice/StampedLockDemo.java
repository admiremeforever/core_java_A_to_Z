package multithreding.practice;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
    public static void main(String[] args) {
        StampedLockResource resource = new StampedLockResource();

        // Multiple readers
        for (int i = 0; i < 3; i++) {
            new Thread(()->resource.read(),"Thread: "+i).start();
        }
        // Multiple optimistic readers
        for (int i = 0; i < 2; i++) {
            new Thread(()->resource.optimisticRead(),"OptimisticThread: "+i).start();
        }

        // Writer
        new Thread(() -> resource.write(100), "Writer-1").start();
    }
    }



class StampedLockResource{
    StampedLock stampedLock = new StampedLock();
    int data =0;
    public void read (){
      long stamp=  stampedLock.readLock();
     try{
         System.out.println("reading data: "+ data);
     }finally {
         stampedLock.unlock(stamp);
     }
    }

    public void write (int val){
        long stamp=  stampedLock.writeLock();
        try{

            System.out.println("Updating data: "+ data);
            data= val;
            System.out.println("Updated data: "+ data);
        }finally {
            stampedLock.unlock(stamp);
        }
    }

    public void optimisticRead() {
        long stamp = stampedLock.tryOptimisticRead();
        int temp = data;

        if (!stampedLock.validate(stamp)) {
            // fallback to read lock
            stamp = stampedLock.readLock();
            try {
                temp = data;
            } finally {
                stampedLock.unlockRead(stamp);
            }
        } else {
            System.out.println("Optimistic read successful: " + temp);
        }
    }
}


/*
StampedLock Java ka ek advanced read-write
lock hai jo high-performance read-heavy applications
ke liye bana hai. Isme teen cheezein hoti hain:

Read lock – multiple threads ek saath data padh sakte hain,
lekin write lock ke samay readers wait karte hain.
Write lock – sirf ek thread hi data likh sakta hai, aur saare
readers aur writers ko block karta hai.
Optimistic read – thread bina lock liye data padh sakta hai,
 aur baad me validate(stamp) se check karta hai ki koi writer ne data change to nahi kiya.

Stamp ek internal version number hai jo har write ke saath
 increment hota hai. Jab optimistic reader tryOptimisticRead()
 call karta hai, woh current stamp note kar leta hai.
 Baad me validate(stamp) call karke check karta hai:
 agar stamp same hai → data safe hai;
 agar stamp badal gaya → data change ho gaya, fallback me normal read lock leke safe read karte hain.

        Important:

Read lock me data change nahi hota → stamp increment nahi hota
Write lock me data change hota hai → stamp increment hota hai
Agar koi thread read lock ke andar data change kar de → stamp increment nahi hoga, aur ye unsafe hai

Simple analogy: stamp = version number, optimistic read = bina lock padhna,
write lock = version increment karke safe writing, validate() = check karo koi writing to nahi hui.*/