package session07.hw06;

public class POSFactory implements SalesChannelFactory {

    @Override
    public DiscountStrategy createDiscount() {
        return new MemberDiscount();
    }

    @Override
    public PaymentMethod createPayment() {
        return new CashPayment();
    }

    @Override
    public NotificationService createNotification() {
        return new ReceiptPrinter();
    }
}