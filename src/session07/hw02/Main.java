package session07.hw02;

public class Main {
    public static void main(String[] args) {

        double total = 1000000;

        // Percentage 10%
        OrderCalculator percentCalc =
                new OrderCalculator(new PercentageDiscount(10));
        System.out.println("Số tiền sau giảm: " + percentCalc.calculate(total));

        // Fixed 50k
        OrderCalculator fixedCalc =
                new OrderCalculator(new FixedDiscount(50000));
        System.out.println("Số tiền sau giảm: " + fixedCalc.calculate(total));

        // No discount
        OrderCalculator noCalc =
                new OrderCalculator(new NoDiscount());
        System.out.println("Số tiền sau giảm: " + noCalc.calculate(total));

        // Holiday 15%
        OrderCalculator holidayCalc =
                new OrderCalculator(new HolidayDiscount());
        System.out.println("Số tiền sau giảm: " + holidayCalc.calculate(total));
    }
}
