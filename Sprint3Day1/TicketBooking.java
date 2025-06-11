class TicketBook {
    int tickets = 5;

    public synchronized void bookTicket(String user) {
        if (tickets > 0) {
            System.out.println(user + " booked ticket " + tickets);
            tickets--;
        } else {
            System.out.println(user + " tried booking but no ticket left");
        }
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        TicketBook tb = new TicketBook();

        Thread user1 = new Thread(() -> {
            tb.bookTicket("Rohan");
        });

        Thread user2 = new Thread(() -> {
            tb.bookTicket("Anusha");
        });

        user1.start();
        user2.start();
    }
}