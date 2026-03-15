package session06.hw02;

public class Supplier extends Thread {

    private TicketPool pool;

    public Supplier(TicketPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {

        try {

            Thread.sleep(8000);

            pool.addTickets(3);

        } catch (InterruptedException e) {
        }
    }
}
