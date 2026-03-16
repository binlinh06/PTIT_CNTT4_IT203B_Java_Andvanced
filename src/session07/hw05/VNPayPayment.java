package session07.hw05;

public class VNPayPayment implements PaymentMethod {

    public void pay(double amount){
        System.out.println("Thanh toán VNPay: " + amount);
    }
}