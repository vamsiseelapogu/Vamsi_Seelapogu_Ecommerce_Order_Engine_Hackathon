package model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    public String user;
    public Map<Integer, Integer> items = new HashMap<>();

    public Cart(String user) {
        this.user = user;
    }
}