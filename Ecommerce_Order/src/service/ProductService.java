package service;

import model.Product;
import java.util.*;

public class ProductService {
    public Map<Integer, Product> products = new HashMap<>();

    public void addProduct(int id, String name, int stock, double price) {
        if (products.containsKey(id)) {
            System.out.println("Duplicate Product ID");
            return;
        }
        products.put(id, new Product(id, name, stock, price));
    }

    public Product getProduct(int id) {
        return products.get(id);
    }

    public void viewProducts() {
        products.values().forEach(p ->
            System.out.println(p.id + " " + p.name + " Stock:" + p.stock)
        );
    }
}