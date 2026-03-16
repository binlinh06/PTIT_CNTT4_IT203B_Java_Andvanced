package session07.hw06;

public class ReceiptPrinter implements NotificationService {

    @Override
    public void notifyUser(String message) {
        System.out.println("In hóa đơn giấy: " + message);
    }
}