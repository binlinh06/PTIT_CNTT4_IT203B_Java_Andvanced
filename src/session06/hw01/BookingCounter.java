package session06.hw01;

public class BookingCounter extends Thread {

    private String name;
    private TicketPool first;
    private TicketPool second;

    public BookingCounter(String name, TicketPool first, TicketPool second) {
        this.name = name;
        this.first = first;
        this.second = second;
    }

    public void sellCombo() {

        synchronized (first) {

            Ticket t1 = first.getTicket();
            if (t1 == null) {
                System.out.println(name + ": Hết vé phòng " + first.getRoomName());
                return;
            }

            System.out.println(name + ": Đã lấy vé " + t1.getId());

            try {
                Thread.sleep(1000); // tạo điều kiện deadlock
            } catch (InterruptedException e) {}

            synchronized (second) {

                Ticket t2 = second.getTicket();

                if (t2 == null) {
                    first.returnTicket(t1);
                    System.out.println(name + ": Không lấy được vé phòng " + second.getRoomName());
                    return;
                }

                System.out.println(name + " bán combo: " + t1.getId() + " & " + t2.getId());
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            sellCombo();
        }
    }
}
