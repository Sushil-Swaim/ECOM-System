import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items;

    public Cart() {
        items = new HashMap<>();
    }

    public void addItem(Product product, int quantity) {
        if (quantity <= product.getStock()) {
            items.put(product, items.getOrDefault(product, 0) + quantity);
            product.reduceStock(quantity);
        } else {
            System.out.println("Not enough stock for " + product.getName());
        }
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            double total = 0;
            for (Map.Entry<Product, Integer> entry : items.entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();
                System.out.println(product + " | Quantity: " + quantity);
                total += product.getPrice() * quantity;
            }
            System.out.printf("Total: $%.2f\n", total);
        }
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }
}
