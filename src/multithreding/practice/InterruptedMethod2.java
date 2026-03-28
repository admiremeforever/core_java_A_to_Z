package multithreding.practice;

public class InterruptedMethod2 {
    public static void main(String[] args) {

        Thread t = new Thread(() -> {

            System.out.println("1. Initially: " + Thread.currentThread().isInterrupted());

            // interrupt flag check + reset
            System.out.println("2. Thread.interrupted(): " + Thread.interrupted());

            // abhi bhi false hi rahega
            System.out.println("3. After interrupted(): " + Thread.currentThread().isInterrupted());

            // ab manually interrupt karte hain
            Thread.currentThread().interrupt();

            System.out.println("4. After interrupt(): " + Thread.currentThread().isInterrupted());

            // check + reset
            System.out.println("5. Thread.interrupted(): " + Thread.interrupted());

            // ab reset ho chuka hai
            System.out.println("6. Final state: " + Thread.currentThread().isInterrupted());
        });

        t.start();


    }
}
