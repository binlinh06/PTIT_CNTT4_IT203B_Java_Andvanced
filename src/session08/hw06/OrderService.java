package session08.hw06;

class OrderService {
    private DiscountStrategy discount;
    private PaymentMethod payment;
    private NotificationService notification;

    public OrderService(SalesChannelFactory factory) {
        this.discount = factory.createDiscountStrategy();
        this.payment = factory.createPaymentMethod();
        this.notification = factory.createNotificationService();
    }

    public void placeOrder(String product, double price, int quantity) {
        double total = price * quantity;
        double finalAmount = discount.applyDiscount(total);

        payment.pay(finalAmount);
        notification.send("Đơn hàng thành công");
    }
}
