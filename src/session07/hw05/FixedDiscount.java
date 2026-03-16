package session07.hw05;

public class FixedDiscount implements DiscountStrategy {

    private double value;

    public FixedDiscount(double value){
        this.value = value;
    }

    public double apply(double amount){
        return amount - value;
    }
}