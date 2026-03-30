package model;

import java.util.Map;

public class Order {
    public int id;
    public String user;
    public Map<Integer, Integer> items;
    public double total;
    public OrderStatus status;

    public Order(int id, String user, Map<Integer, Integer> items, double total) {
        this.id = id;
        this.user = user;
        this.items = items;
        this.total = total;
        this.status = OrderStatus.CREATED;
    }
}