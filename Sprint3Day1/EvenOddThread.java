public class EvenOddThread {
    public static void main(String[] args) {
        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("even: " + i);
                try { Thread.sleep(100); } catch (Exception e) {}
            }
        });

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                System.out.println("odd: " + i);
                try { Thread.sleep(100); } catch (Exception e) {}
            }
        });

        evenThread.start();
        oddThread.start();
    }
}