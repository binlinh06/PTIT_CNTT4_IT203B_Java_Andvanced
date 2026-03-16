package session07.hw05;

public class HolidayDiscount implements DiscountStrategy {

    public double apply(double amount){
        return amount * 0.85;
    }
}
