package session07.hw05;

public class OrderService {

    private OrderRepository repository;
    private NotificationService notification;

    public OrderService(OrderRepository repository,
                        NotificationService notification) {

        this.repository = repository;
        this.notification = notification;
    }

    public void createOrder(Order order,
                            DiscountStrategy discount,
                            PaymentMethod payment){

        double total = 0;

        for(OrderItem item : order.getItems()){
            total += item.getTotal();
        }

        double finalAmount = discount.apply(total);

        order.setTotal(finalAmount);

        payment.pay(finalAmount);

        repository.save(order);

        notification.send(
                "Đơn hàng " + order.getId(),
                order.getCustomer().getEmail()
        );
    }
}
