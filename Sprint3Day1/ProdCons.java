class ItemBox {
    int item;
    boolean hasItem = false;

    synchronized void produce(int v) {
        while (hasItem) {
            try { wait(); } catch (Exception e) {}
        }
        item = v;
        hasItem = true;
        System.out.println("made: " + v);
        notify();
    }

    synchronized void consume() {
        while (!hasItem) {
            try { wait(); } catch (Exception e) {}
        }
        System.out.println("used: " + item);
        hasItem = false;
        notify();
    }
}

public class ProdCons {
    public static void main(String[] args) {
        ItemBox box = new ItemBox();

        Thread p = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                box.produce(i);
                try { Thread.sleep(100); } catch (Exception e) {}
            }
        });

        Thread c = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                box.consume();
                try { Thread.sleep(150); } catch (Exception e) {}
            }
        });

        p.start();
        c.start();
    }
}