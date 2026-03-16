package session07.hw06;

public class CashPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán tiền mặt tại cửa hàng");
    }
}
