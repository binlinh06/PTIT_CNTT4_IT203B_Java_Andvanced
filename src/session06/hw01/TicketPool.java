package session06.hw01;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    private Queue<Ticket> tickets = new LinkedList<>();
    private String roomName;

    public TicketPool(String roomName) {
        this.roomName = roomName;
    }

    public void addTicket(Ticket t) {
        tickets.add(t);
    }

    public Ticket getTicket() {
        return tickets.poll();
    }

    public void returnTicket(Ticket t) {
        if (t != null) {
            tickets.add(t);
        }
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean hasTicket() {
        return !tickets.isEmpty();
    }
}
