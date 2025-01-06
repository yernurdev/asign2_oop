import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private List<Product> products;

    public Admin(int userId, String name, String email) {
        super(userId, name, email);
        this.products = new ArrayList<>();
    }

    @Override
    public void displayDetails() {
        System.out.println("Admin ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Products Managed: " + products.size());
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getName());
    }

    public void removeProduct(String productId) {
        products.removeIf(product -> product.getProductId().equals(productId));
        System.out.println("Product removed: " + productId);
    }

    public void updateStock(String productId, int newStock) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                product.increaseStock(newStock - product.getStock());
                System.out.println("Stock updated for product: " + productId);
                return;
            }
        }
        System.out.println("Product not found: " + productId);
    }
}
