package session07.hw03;

public class Main {
    public static void main(String[] args) {

        // COD
        PaymentProcessor codProcessor =
                new PaymentProcessor(new CODPayment());
        codProcessor.process(500000);

        // Credit Card
        PaymentProcessor cardProcessor =
                new PaymentProcessor(new CreditCardPayment());
        cardProcessor.process(1000000);

        // MoMo
        PaymentProcessor momoProcessor =
                new PaymentProcessor(new MomoPayment());
        momoProcessor.process(750000);

        // Kiểm tra LSP
        PaymentMethod payment = new CreditCardPayment();
        payment = new MomoPayment(); // thay thế implementation

        PaymentProcessor processor = new PaymentProcessor(payment);
        processor.process(300000);
    }
}
