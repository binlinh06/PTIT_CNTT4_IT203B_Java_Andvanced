package session07.hw05;

import java.util.List;

public class Order {

    private String id;
    private Customer customer;
    private List<OrderItem> items;
    private double total;

    public Order(String id, Customer customer, List<OrderItem> items) {
        this.id = id;
        this.customer = customer;
        this.items = items;
    }

    public String getId(){ return id; }
    public Customer getCustomer(){ return customer; }
    public List<OrderItem> getItems(){ return items; }

    public void setTotal(double total){
        this.total = total;
    }

    public double getTotal(){
        return total;
    }
}
