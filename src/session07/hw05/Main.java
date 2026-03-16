package session07.hw05;

import java.util.*;

public class Main {

    static List<Product> products = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        OrderRepository repo = new FileOrderRepository();
        NotificationService notify = new EmailNotification();

        OrderService service = new OrderService(repo, notify);

        while(true){

            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Tạo đơn hàng");
            System.out.println("4. Xem đơn hàng");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();

            switch(choice){

                case 1:
                    products.add(
                            new Product("SP01","Laptop",15000000,"Điện tử")
                    );
                    System.out.println("Đã thêm sản phẩm SP01");
                    break;

                case 2:
                    customers.add(
                            new Customer("Nguyễn Văn A","a@example.com","0123456789")
                    );
                    System.out.println("Đã thêm khách hàng");
                    break;

                case 3:

                    Product p = products.get(0);
                    Customer c = customers.get(0);

                    List<OrderItem> items = new ArrayList<>();
                    items.add(new OrderItem(p,1));

                    Order order = new Order("ORD001",c,items);

                    DiscountStrategy discount = new PercentageDiscount(10);
                    PaymentMethod payment = new CreditCardPayment();

                    service.createOrder(order,discount,payment);

                    break;

                case 4:
                    for(Order o : repo.findAll()){
                        System.out.println(
                                o.getId() + " - " +
                                        o.getCustomer().getName() +
                                        " - " + o.getTotal()
                        );
                    }
                    break;

                case 0:
                    return;
            }
        }
    }
}
