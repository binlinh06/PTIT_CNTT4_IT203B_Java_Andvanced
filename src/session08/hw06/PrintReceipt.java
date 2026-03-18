package session08.hw06;

class PrintReceipt implements NotificationService {
    public void send(String message) {
        System.out.println("In hóa đơn: " + message);
    }
}
