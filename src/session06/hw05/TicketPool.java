package session06.hw05;

import java.util.*;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int capacity) {

        this.roomName = roomName;

        for (int i = 1; i <= capacity; i++) {

            String id = roomName + "-" + String.format("%03d", i);
            tickets.add(new Ticket(id, roomName));
        }
    }

    // giữ vé
    public synchronized Ticket holdTicket(boolean vip, String counter) {

        for (Ticket t : tickets) {

            if (!t.isSold() && !t.isHeld()) {

                t.hold(vip);

                System.out.println(counter +
                        ": Đã giữ vé " + t.getTicketId() +
                        (vip ? " (VIP)" : "") +
                        ". Thanh toán trong 5s");

                return t;
            }
        }

        return null;
    }

    // thanh toán
    public synchronized void sellHeldTicket(Ticket t, String counter) {

        if (t != null && t.isHeld()) {

            t.sell();

            System.out.println(counter +
                    ": Thanh toán thành công vé "
                    + t.getTicketId());
        }
    }

    // trả vé hết hạn
    public synchronized void releaseExpiredTickets() {

        for (Ticket t : tickets) {

            if (t.isExpired()) {

                System.out.println(
                        "TimeoutManager: Vé "
                                + t.getTicketId()
                                + " hết hạn giữ, trả lại kho");

                t.release();
            }
        }
    }

    public String getRoomName() {
        return roomName;
    }
}
