package session08.hw06;

class EmailNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Gửi email: " + message);
    }
}
