import java.util.ArrayList;
import java.util.List;

public class ShoppingSystem {
    public static void main(String[] args) {
        // Create Admins
        Admin admin1 = new Admin(1, "Alice", "alice@admin.com");
        Admin admin2 = new Admin(2, "Bob", "bob@admin.com");

        // Create Products
        List<Product> products = new ArrayList<>();
        products.add(new Product("P01", "Laptop", 1000.0, 10));
        products.add(new Product("P02", "Phone", 500.0, 15));
        products.add(new Product("P03", "Tablet", 300.0, 20));
        products.add(new Product("P04", "Headphones", 50.0, 50));
        products.add(new Product("P05", "Smartwatch", 200.0, 25));
        products.add(new Product("P06", "Camera", 700.0, 5));
        products.add(new Product("P07", "Keyboard", 30.0, 40));
        products.add(new Product("P08", "Mouse", 20.0, 45));
        products.add(new Product("P09", "Monitor", 150.0, 10));
        products.add(new Product("P10", "Printer", 120.0, 8));


        for (Product product : products) {
            admin1.addProduct(product);
        }


        Customer customer1 = new Customer(101, "Charlie", "charlie@customer.com", "123 Elm Street");
        Customer customer2 = new Customer(102, "Diana", "diana@customer.com", "456 Oak Avenue");
        Customer customer3 = new Customer(103, "Ethan", "ethan@customer.com", "789 Pine Road");
        Customer customer4 = new Customer(104, "Fiona", "fiona@customer.com", "321 Maple Lane");
        Customer customer5 = new Customer(105, "George", "george@customer.com", "654 Birch Boulevard");


        customer1.placeOrder(products.get(0), 2, "Credit Card");
        customer1.placeOrder(products.get(1), 1, "PayPal");
        customer2.placeOrder(products.get(2), 5, "Credit Card");
        customer3.placeOrder(products.get(3), 10, "PayPal");
        customer4.placeOrder(products.get(0), 1, "Credit Card");
        customer4.placeOrder(products.get(9), 3, "PayPal");
        customer5.placeOrder(products.get(8), 2, "Credit Card");


        customer1.placeOrder(products.get(0), 20, "Credit Card");


        admin2.updateStock("P01", 15);


        admin1.removeProduct("P06");


        System.out.println("\nDisplaying All Users:");
        admin1.displayDetails();
        admin2.displayDetails();
        customer1.displayDetails();
        customer2.displayDetails();
        customer3.displayDetails();
        customer4.displayDetails();
        customer5.displayDetails();


        System.out.println("\nDisplaying All Products:");
        for (Product product : products) {
            product.displayDetails();
        }


        System.out.println("\nDisplaying Orders for Customers:");
        for (Customer customer : List.of(customer1, customer2, customer3, customer4, customer5)) {
            System.out.println("\nOrders for Customer: " + customer.name);
            for (Order order : customer.orders) {
                order.displayOrderDetails();
            }
        }
    }
}
