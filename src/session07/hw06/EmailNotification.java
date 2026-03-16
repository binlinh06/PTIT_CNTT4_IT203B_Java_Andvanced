package session07.hw06;

public class EmailNotification implements NotificationService {

    @Override
    public void notifyUser(String message) {
        System.out.println("Gửi email xác nhận: " + message);
    }
}
