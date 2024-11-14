import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create some sample products
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 999.99, 10));
        products.add(new Product(2, "Smartphone", 499.99, 20));
        products.add(new Product(3, "Headphones", 199.99, 15));

        // Create a user
        User user = new User("John Doe", "123 Main St, Springfield, USA");
        
        // Initialize the user's cart
        Cart cart = new Cart();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the product catalog
            System.out.println("Welcome to the e-commerce system!");
            System.out.println("Here are the available products:");

            for (Product product : products) {
                System.out.println(product);
            }

            // Let the user add products to their cart
            System.out.print("\nEnter product ID to add to cart, or '0' to checkout: ");
            int productId = scanner.nextInt();

            if (productId == 0) {
                // Proceed to checkout
                break;
            }

            Product selectedProduct = null;
            for (Product product : products) {
                if (product.getId() == productId) {
                    selectedProduct = product;
                    break;
                }
            }

            if (selectedProduct == null) {
                System.out.println("Invalid product ID. Please try again.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            cart.addItem(selectedProduct, quantity);
            cart.displayCart();
        }

        // Once user is ready, place the order
        Order order = new Order(cart, user.getName(), user.getAddress());
        order.placeOrder();

        scanner.close();
    }
}
