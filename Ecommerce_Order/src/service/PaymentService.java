package service;

import java.util.Random;

public class PaymentService {
    Random rand = new Random();

    public boolean processPayment(double amount) {
        return rand.nextBoolean();
    }
}