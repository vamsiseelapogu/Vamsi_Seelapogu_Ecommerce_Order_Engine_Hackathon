# Vamsi_Seelapogu_Ecommerce_Order_Engine_Hackathon
Project Overview

This is a console-based Ecommerce Order Engine developed using Core Java and OOP concepts. The system simulates basic e-commerce operations like:

- Product management
- Cart handling
- Order placement
- Payment processing
- Inventory management with rollback

The design focuses on simplicity, modularity, and handling multiple tasks at once.

Features Implemented
- Add and view products
- Add items to cart
- Check stock before adding to cart
- Place order with total calculation
- Simulated payment processing
- Track order status
- Rollback mechanism if payment fails
- Safe stock updates using synchronization

Design Approach

The project follows a layered architecture:

1. Model Layer (model/)
   - Defines core entities:
     - Product: Product details (id, name, stock, price)
     - Cart: User cart with product and quantity mapping
     - Order: Order details with status
     - OrderStatus: Enum for order lifecycle

2. Service Layer (service/)
   - Contains business logic:
     - ProductService: Manages product storage and retrieval
     - CartService: Handles cart operations and deducts stock with synchronization
     - OrderService: Calculates total price, handles order creation, connects with payment service, and performs rollback if payment fails
     - PaymentService: Simulates payment with random success or failure

3. Utility Layer (util/)
   - LockManager: Provides locks for controlling concurrent access
   - Logger: Records messages with timestamps

4. Main Class
   - Provides a menu-driven command line interface
   - Handles user input and triggers services

Assumptions
- Single JVM execution with in-memory storage
- No database persistence
- Payment is randomly simulated
- One cart per user
- Product IDs are unique
- Stock is reduced when items are added to the cart
- Rollback restores stock if payment fails

How to Run the Project
Step 1: Compile
```
javac main/Main.java
```
Step 2: Run
```
java main.Main
```
Sample Menu
1. Add Product
2. View Products
3. Add to Cart
4. Place Order
5. View Orders
0. Exit

Example Flow
- Add product
- View products
- Add to cart (user, productId, quantity)
- Place order
- View orders

Order Lifecycle
CREATED → PENDING_PAYMENT → PAID or FAILED  
If payment fails, stock rollback occurs.  
If successful, the order is saved and the cart is cleared.  

Tech Stack
- Java (Core Java and OOP)
- Collections Framework (HashMap, Map)
- Basic concurrency (synchronized)

Author

vamsi seela pogu
