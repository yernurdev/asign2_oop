import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    List<Order> orders;
    private String shippingAddress;

    public Customer(int userId, String name, String email, String shippingAddress) {
        super(userId, name, email);
        this.shippingAddress = shippingAddress;
        this.orders = new ArrayList<>();
    }

    @Override
    public void displayDetails() {
        System.out.println("Customer ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Shipping Address: " + shippingAddress);
        System.out.println("Orders Count: " + orders.size());
    }

    public void placeOrder(Product product, int quantity, String paymentMethod) {
        if (product.getStock() < quantity) {
            System.out.println("Order failed: Insufficient stock for product " + product.getName());
            return;
        }

        product.reduceStock(quantity);
        double totalPrice = product.getPrice() * quantity;
        Order order = new Order("O" + (orders.size() + 1), this, product, quantity, totalPrice, "Placed");
        orders.add(order);
        System.out.println("Order placed successfully: " + order.getOrderId());
    }

    public void cancelOrder(Order order) {
        if (orders.contains(order)) {
            order.cancelOrder();
            orders.remove(order);
            System.out.println("Order cancelled: " + order.getOrderId());
        } else {
            System.out.println("Order not found.");
        }
    }
}
