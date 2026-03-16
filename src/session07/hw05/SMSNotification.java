package session07.hw05;

public class SMSNotification implements NotificationService {

    public void send(String message, String recipient){
        System.out.println("Đã gửi SMS xác nhận");
    }
}
