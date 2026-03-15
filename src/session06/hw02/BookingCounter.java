package session06.hw02;

public class BookingCounter extends Thread {

    private String name;
    private TicketPool pool;

    public BookingCounter(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }

    @Override
    public void run() {

        while (true) {

            pool.sellTicket(name);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
