package session06.hw05;

public class Ticket {

    private String ticketId;
    private String roomName;

    private boolean isSold = false;
    private boolean isHeld = false;
    private boolean isVIP;

    private long holdExpiryTime = 0;

    public Ticket(String id, String roomName) {
        this.ticketId = id;
        this.roomName = roomName;
    }

    public String getTicketId() {
        return ticketId;
    }

    public boolean isSold() {
        return isSold;
    }

    public boolean isHeld() {
        return isHeld;
    }

    public void hold(boolean vip) {
        this.isHeld = true;
        this.isVIP = vip;
        this.holdExpiryTime = System.currentTimeMillis() + 5000;
    }

    public void sell() {
        this.isSold = true;
        this.isHeld = false;
    }

    public void release() {
        this.isHeld = false;
        this.isVIP = false;
        this.holdExpiryTime = 0;
    }

    public boolean isExpired() {
        return isHeld && System.currentTimeMillis() > holdExpiryTime;
    }
}
