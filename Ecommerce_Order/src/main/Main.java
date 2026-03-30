package main;

import service.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProductService ps = new ProductService();
        CartService cs = new CartService(ps);
        PaymentService pay = new PaymentService();
        OrderService os = new OrderService(ps, cs, pay);

        while (true) {
            System.out.println("\n1.Add Product 2.View Products 3.Add Cart 4.Place Order 5.View Orders 0.Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    ps.addProduct(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;
                case 2:
                    ps.viewProducts();
                    break;
                case 3:
                    cs.addToCart(sc.next(), sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    os.placeOrder(sc.next());
                    break;
                case 5:
                    os.viewOrders();
                    break;
                case 0:
                    return;
            }
        }
    }
}