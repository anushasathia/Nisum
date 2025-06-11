public class CounterTest {
    static int sharedCount = 0;

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sharedCount++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sharedCount++;
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("count is: " + sharedCount);
    }
}