package session06.hw02;

public class Main {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A");
        TicketPool roomB = new TicketPool("B");

        // thêm vé ban đầu
        roomA.addTickets(2);
        roomB.addTickets(5);

        BookingCounter counter1 =
                new BookingCounter("Quầy 1", roomA);

        BookingCounter counter2 =
                new BookingCounter("Quầy 2", roomB);

        Supplier supplier =
                new Supplier(roomA);

        counter1.start();
        counter2.start();
        supplier.start();
    }
}
