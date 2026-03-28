package multithreding.Lec43;

public class PlatformThreadVsVirtualThread {
    public static void main(String[] args) {

        for (int i = 0; i < 1000000; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {}
            }).start();
        }

        for (int i = 0; i < 100000; i++) {
            Thread.startVirtualThread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {}
            });
        }
   }
}