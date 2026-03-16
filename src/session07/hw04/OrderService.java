package session07.hw04;

public class OrderService {

    private OrderRepository orderRepository;
    private NotificationService notificationService;

    public OrderService(OrderRepository orderRepository,
                        NotificationService notificationService) {

        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
    }

    public void createOrder(Order order) {

        orderRepository.save(order);

        notificationService.send(
                "Đơn hàng " + order.getId() + " đã được tạo",
                "customer"
        );
    }
}
