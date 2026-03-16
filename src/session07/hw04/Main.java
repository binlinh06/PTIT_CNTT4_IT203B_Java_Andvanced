package session07.hw04;

public class Main {

    public static void main(String[] args) {

        // Cấu hình 1: File + Email
        OrderRepository repo1 = new FileOrderRepository();
        NotificationService notify1 = new EmailService();

        OrderService orderService1 =
                new OrderService(repo1, notify1);

        Order order1 = new Order("ORD001");
        orderService1.createOrder(order1);


        System.out.println("---------------");


        // Cấu hình 2: Database + SMS
        OrderRepository repo2 = new DatabaseOrderRepository();
        NotificationService notify2 = new SMSNotification();

        OrderService orderService2 =
                new OrderService(repo2, notify2);

        Order order2 = new Order("ORD002");
        orderService2.createOrder(order2);
    }
}