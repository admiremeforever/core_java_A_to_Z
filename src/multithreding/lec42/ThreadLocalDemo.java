package multithreding.lec42;

public class ThreadLocalDemo {
    public static void main(String[] args) {

//enables each thread to have its separate value of user
         ThreadLocal<String> user = new ThreadLocal<>();

                Runnable task1 = () -> {
                    user.set("Alice");
                    System.out.println("Thread 1: " + user.get());
                };

                Runnable task2 = () -> {
                    user.set("Bob");
                    System.out.println("Thread 2: " + user.get());
                };

                new Thread(task1).start();
                new Thread(task2).start();
            }

}
