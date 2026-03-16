package session07.hw05;

public class EmailNotification implements NotificationService {

    public void send(String message, String recipient){
        System.out.println("Đã gửi email xác nhận");
    }
}