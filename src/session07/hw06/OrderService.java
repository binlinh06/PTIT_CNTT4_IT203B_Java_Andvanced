package session07.hw06;

public class OrderService {

    private DiscountStrategy discount;
    private PaymentMethod payment;
    private NotificationService notification;

    public OrderService(SalesChannelFactory factory) {

        this.discount = factory.createDiscount();
        this.payment = factory.createPayment();
        this.notification = factory.createNotification();
    }

    public void processOrder(double amount) {

        double finalAmount = discount.applyDiscount(amount);

        payment.pay(finalAmount);

        notification.notifyUser("Đơn hàng thành công");
    }
}
