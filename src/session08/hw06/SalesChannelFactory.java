package session08.hw06;

abstract class SalesChannelFactory {
    abstract DiscountStrategy createDiscountStrategy();
    abstract PaymentMethod createPaymentMethod();
    abstract NotificationService createNotificationService();
}
