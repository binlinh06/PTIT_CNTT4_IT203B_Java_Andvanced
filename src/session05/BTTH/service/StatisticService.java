package session05.BTTH.service;

import session05.BTTH.modal.MenuItem;
import session05.BTTH.modal.Order;
import session05.BTTH.modal.OrderItem;
import session05.BTTH.repository.MenuRepository;
import session05.BTTH.repository.OrderRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticService {

    private final MenuRepository menuRepository;
    private final OrderRepository orderRepository;

    public StatisticService(MenuRepository menuRepository, OrderRepository orderRepository) {
        this.menuRepository = menuRepository;
        this.orderRepository = orderRepository;
    }

    public List<MenuItem> findItemsByPriceRange(double min, double max) {
        return menuRepository.findAll().stream()
                .filter(i -> {
                    double price = i.calculatePrice();
                    return price >= min && price <= max;
                })
                .collect(Collectors.toList());
    }

    public double calculateTotalRevenue() {
        return orderRepository.findAll().stream()
                .mapToDouble(Order::totalPrice)
                .sum();
    }

    public List<MenuItem> getBestSellingItems(int topN) {
        Map<MenuItem, Integer> countMap = orderRepository.findAll().stream()
                .flatMap(order -> order.items().stream())
                .collect(Collectors.toMap(
                        OrderItem::item,
                        OrderItem::quantity,
                        Integer::sum
                ));

        return countMap.entrySet().stream()
                .sorted(Map.Entry.<MenuItem, Integer>comparingByValue(Comparator.reverseOrder()))
                .limit(topN)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
