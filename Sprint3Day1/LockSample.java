import java.util.concurrent.locks.*;

public class LockSample {
    static int balance = 0;
    static ReentrantLock locker = new ReentrantLock();

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            locker.lock();
            balance += 100;
            System.out.println("added by t1");
            locker.unlock();
        });

        Thread t2 = new Thread(() -> {
            locker.lock();
            balance += 200;
            System.out.println("added by t2");
            locker.unlock();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("final: " + balance);
    }
}