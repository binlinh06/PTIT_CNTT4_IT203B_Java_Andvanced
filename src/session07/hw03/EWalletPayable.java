package session07.hw03;

public interface EWalletPayable extends PaymentMethod {
    void processEWallet(double amount);
}
