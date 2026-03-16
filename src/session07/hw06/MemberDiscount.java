package session07.hw06;

public class MemberDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double amount) {
        System.out.println("Áp dụng giảm giá thành viên 5%");
        return amount * 0.95;
    }
}
