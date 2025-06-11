public class PrimeSum {
    static int total = 0;

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            for (int i = 2; i <= 5000; i++) {
                if (isPrime(i)) {
                    synchronized (PrimeSum.class) {
                        total += i;
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 5001; i <= 10000; i++) {
                if (isPrime(i)) {
                    synchronized (PrimeSum.class) {
                        total += i;
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("prime sum: " + total);
    }

    static boolean isPrime(int n) {
        for (int i = 2; i*i <= n; i++) if (n % i == 0) return false;
        return n > 1;
    }
}