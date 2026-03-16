package session07.hw03;

public class MomoPayment implements EWalletPayable {

    @Override
    public void processEWallet(double amount) {
        System.out.println("Xử lý thanh toán MoMo: " + amount + " - Thành công");
    }

    @Override
    public void pay(double amount) {
        processEWallet(amount);
    }
}
