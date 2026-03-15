package session06.hw06;

import java.util.*;

public class TicketSupplier implements Runnable {

    private List<Room> rooms;

    public TicketSupplier(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(5000);
            } catch (Exception e) {}

            for (Room r : rooms) {

                r.addTickets(2);

                System.out.println("Supplier: thêm 2 vé vào phòng "
                        + r.getName());
            }
        }
    }
}
