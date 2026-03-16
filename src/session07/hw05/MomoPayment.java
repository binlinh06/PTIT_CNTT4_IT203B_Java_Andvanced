package session07.hw05;

public class MomoPayment implements PaymentMethod {

    public void pay(double amount){
        System.out.println("Thanh toán MoMo: " + amount);
    }
}
