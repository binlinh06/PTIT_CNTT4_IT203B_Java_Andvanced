package session07.hw03;

public interface CardPayable extends PaymentMethod {
    void processCard(double amount);
}
