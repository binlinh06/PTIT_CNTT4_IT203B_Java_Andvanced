package session06.hw05;
public class Main {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A", 5);
        TicketPool roomB = new TicketPool("B", 6);
        TicketPool roomC = new TicketPool("C", 7);

        TicketPool[] pools = {roomA, roomB, roomC};

        // 5 quầy bán vé
        for (int i = 1; i <= 5; i++) {

            Thread t =
                    new Thread(new BookingCounter(
                            "Quầy " + i, pools));

            t.start();
        }

        // Timeout manager
        Thread timeout =
                new Thread(new TimeoutManager(pools));

        timeout.start();
    }
}
