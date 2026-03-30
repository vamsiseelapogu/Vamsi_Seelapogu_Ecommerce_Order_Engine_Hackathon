package service;

import model.*;
import java.util.*;

public class OrderService {
    private Map<Integer, Order> orders = new HashMap<>();
    private int orderId = 1;

    private ProductService ps;
    private CartService cs;
    private PaymentService pay;

    public OrderService(ProductService ps, CartService cs, PaymentService pay) {
        this.ps = ps;
        this.cs = cs;
        this.pay = pay;
    }

    public void placeOrder(String user) {
        Cart cart = cs.getCart(user);

        if (cart == null || cart.items.isEmpty()) {
            System.out.println("Cart empty");
            return;
        }

        double total = 0;
        for (int pid : cart.items.keySet()) {
            total += ps.getProduct(pid).price * cart.items.get(pid);
        }

        Order order = new Order(orderId, user, cart.items, total);
        order.status = OrderStatus.PENDING_PAYMENT;

        if (!pay.processPayment(total)) {
            order.status = OrderStatus.FAILED;

            // rollback
            for (int pid : cart.items.keySet()) {
                ps.getProduct(pid).stock += cart.items.get(pid);
            }

            System.out.println("Payment failed → rolled back");
            return;
        }

        order.status = OrderStatus.PAID;
        orders.put(orderId, order);

        cs.clearCart(user);

        System.out.println("Order success ID: " + orderId);
        orderId++;
    }

    public void viewOrders() {
        orders.values().forEach(o ->
            System.out.println(o.id + " " + o.user + " " + o.status)
        );
    }
}