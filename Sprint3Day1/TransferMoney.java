import java.util.concurrent.locks.*;

class MyAccount {
    int bal;
    Lock lock = new ReentrantLock();

    MyAccount(int b) {
        bal = b;
    }

    @Override
    public String toString() {
        return "Account[bal=" + bal + "]";
    }

    void send(MyAccount to, int amt) {
        boolean done = false;
        while (!done) {
            if (this.lock.tryLock()) {
                try {
                    if (to.lock.tryLock()) {
                        try {
                            if (bal >= amt) {
                                bal -= amt;
                                to.bal += amt;
                                System.out.println(Thread.currentThread().getName() + ": Transferred $" + amt + " from " + this + " to " + to);
                            } else {
                                System.out.println(Thread.currentThread().getName() + ": Failed to transfer $" + amt + " from " + this + " (Insufficient funds).");
                            }
                            done = true;
                        } finally {
                            to.lock.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + ": Couldn't acquire lock on " + to + ". Retrying...");
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            System.out.println(Thread.currentThread().getName() + ": Interrupted while waiting for lock.");
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                } finally {
                    this.lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + ": Couldn't acquire lock on " + this + ". Retrying...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + ": Interrupted while retrying sender lock.");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }
}

public class TransferMoney {
    public static void main(String[] args) throws InterruptedException {
        MyAccount acc1 = new MyAccount(500);
        MyAccount acc2 = new MyAccount(400);

        System.out.println("Initial balances: Acc1 = " + acc1.bal + ", Acc2 = " + acc2.bal);

        Thread t1 = new Thread(() -> acc1.send(acc2, 100), "TransferThread-1");
        Thread t2 = new Thread(() -> acc2.send(acc1, 50), "TransferThread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("\nFinal balances: Acc1 = " + acc1.bal + ", Acc2 = " + acc2.bal);
    }
}
