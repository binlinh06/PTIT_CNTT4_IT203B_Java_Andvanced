package session07.hw06;

public class MobileFactory implements SalesChannelFactory {

    @Override
    public DiscountStrategy createDiscount() {
        return new FirstTimeDiscount();
    }

    @Override
    public PaymentMethod createPayment() {
        return new MomoPayment();
    }

    @Override
    public NotificationService createNotification() {
        return new PushNotification();
    }
}
