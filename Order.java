import java.util.Map;

public class Order {
    private Cart cart;
    private String customerName;
    private String address;

    public Order(Cart cart, String customerName, String address) {
        this.cart = cart;
        this.customerName = customerName;
        this.address = address;
    }

    public void placeOrder() {
        if (cart.getItems().isEmpty()) {
            System.out.println("Cannot place an order with an empty cart.");
        } else {
            System.out.println("Placing order for " + customerName);
            cart.displayCart();
            System.out.printf("Shipping to: %s\n", address);
            System.out.printf("Total: $%.2f\n", cart.getTotal());
            System.out.println("Order placed successfully!\n");
        }
    }
}
