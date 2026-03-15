package session06.hw05;

import java.util.Random;

public class BookingCounter implements Runnable {

    private String name;
    private TicketPool[] pools;
    private Random random = new Random();

    public BookingCounter(String name, TicketPool[] pools) {
        this.name = name;
        this.pools = pools;
    }

    @Override
    public void run() {

        while (true) {

            TicketPool pool =
                    pools[random.nextInt(pools.length)];

            boolean vip = random.nextInt(5) == 0;

            Ticket t = pool.holdTicket(vip, name);

            if (t != null) {

                try {
                    Thread.sleep(3000);
                } catch (Exception e) {}

                pool.sellHeldTicket(t, name);
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
}
