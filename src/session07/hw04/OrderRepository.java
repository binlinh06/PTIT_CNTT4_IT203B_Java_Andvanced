package session07.hw04;

import java.util.List;

public interface OrderRepository {

    void save(Order order);

    List<Order> findAll();
}
