package session06.hw06;

import java.util.*;

public class Room {

    private String name;
    private List<Ticket> tickets = new ArrayList<>();
    private int soldCount = 0;

    public Room(String name, int capacity) {

        this.name = name;

        for (int i = 1; i <= capacity; i++) {

            String id = name + "-" + String.format("%03d", i);
            tickets.add(new Ticket(id));
        }
    }

    public synchronized Ticket sellTicket() {

        for (Ticket t : tickets) {

            if (!t.isSold()) {

                t.sell();
                soldCount++;
                return t;
            }
        }

        return null;
    }

    public synchronized void addTickets(int count) {

        int start = tickets.size() + 1;

        for (int i = 0; i < count; i++) {

            String id = name + "-" + String.format("%03d", start + i);
            tickets.add(new Ticket(id));
        }
    }

    public int getSoldCount() {
        return soldCount;
    }

    public int getCapacity() {
        return tickets.size();
    }

    public String getName() {
        return name;
    }
}
