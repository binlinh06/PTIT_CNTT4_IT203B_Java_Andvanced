package session06.hw03;

import session06.hw01.Ticket;

import java.util.LinkedList;
import java.util.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    private Queue<Ticket> tickets = new LinkedList<>();
    private String roomName;
    private int ticketCounter = 1;

    public TicketPool(String roomName, int initial) {
        this.roomName = roomName;

        for (int i = 0; i < initial; i++) {
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", ticketCounter++)));
        }
    }

    // bán vé
    public synchronized Ticket sellTicket() {

        if (tickets.isEmpty()) {
            return null;
        }

        return tickets.poll();
    }

    // thêm vé
    public synchronized void addTickets(int count) {

        for (int i = 0; i < count; i++) {

            tickets.add(new Ticket(
                    roomName + "-" + String.format("%03d", ticketCounter++)
            ));
        }

        System.out.println("Nhà cung cấp: Đã thêm "
                + count + " vé vào phòng " + roomName);
    }

    public synchronized int getRemainingTickets() {
        return tickets.size();
    }
}
