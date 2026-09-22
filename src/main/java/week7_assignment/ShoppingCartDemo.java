package week7_assignment;

class Cart {
    private double[] prices;   // private array to store item prices
    private int count;         // how many items have been added
    private final String cartId; // final cart ID

    // Constructor with cart ID and maximum size
    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.count = 0;
    }

    // Add an item price
    public void addItem(double price) {
        if (count < prices.length) {
            prices[count] = price;
            count++;
        } else {
            System.out.println("Cart is full. Cannot add more items.");
        }
    }

    // Read-only total (computed on request)
    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    // Read-only item count
    public int getItemCount() {
        return count;
    }

    // Read-only cart ID
    public String getCartId() {
        return cartId;
    }
}

public class ShoppingCartDemo {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Total: Rs " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}
