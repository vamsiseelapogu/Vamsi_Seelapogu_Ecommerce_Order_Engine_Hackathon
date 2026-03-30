package service;

import model.Cart;
import model.Product;
import java.util.*;

public class CartService {
    private Map<String, Cart> carts = new HashMap<>();
    private ProductService ps;

    public CartService(ProductService ps) {
        this.ps = ps;
    }

    public void addToCart(String user, int pid, int qty) {
        Product p = ps.getProduct(pid);

        if (p == null || p.stock < qty) {
            System.out.println("Insufficient stock");
            return;
        }

        synchronized (p) { // locking
            p.stock -= qty;
        }

        carts.putIfAbsent(user, new Cart(user));
        Cart cart = carts.get(user);

        cart.items.put(pid, cart.items.getOrDefault(pid, 0) + qty);
    }

    public Cart getCart(String user) {
        return carts.get(user);
    }

    public void clearCart(String user) {
        carts.put(user, new Cart(user));
    }
}