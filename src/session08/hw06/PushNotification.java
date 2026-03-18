package session08.hw06;

class PushNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Gửi push notification: " + message);
    }
}
