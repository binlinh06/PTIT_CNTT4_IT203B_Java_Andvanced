package session06.hw06;

import java.util.*;

public class BookingCounter implements Runnable {

    private String name;
    private List<Room> rooms;
    private volatile boolean running = true;
    private Random random = new Random();

    public BookingCounter(String name, List<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {

        System.out.println(name + " bắt đầu bán vé...");

        while (running) {

            Room room = rooms.get(random.nextInt(rooms.size()));

            Ticket t = room.sellTicket();

            if (t != null) {

                System.out.println(name +
                        " bán vé " + t.getId());
            }

            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}
