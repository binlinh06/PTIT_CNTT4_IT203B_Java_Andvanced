package session07.hw03;

public class CreditCardPayment implements CardPayable {

    @Override
    public void processCard(double amount) {
        System.out.println("Xử lý thanh toán thẻ tín dụng: " + amount + " - Thành công");
    }

    @Override
    public void pay(double amount) {
        processCard(amount);
    }
}
