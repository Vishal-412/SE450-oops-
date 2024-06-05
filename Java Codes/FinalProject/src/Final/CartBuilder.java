package Final;

public class CartBuilder { // Class responsible for building shopping carts
    private Cart cart; // Instance of the shopping cart
    public CartBuilder() { // Constructor to initialize the cart
        cart = Cart.getInstance(); 
    }
    public CartBuilder addItem(Product product) { // Method to add an item to the cart
        cart.addItem(product); // Add the product to the cart
        return this; 
    }
    public CartBuilder removeItem(Product product) { // Method to remove an item from the cart
        cart.removeItem(product); // Remove the product from the cart
        return this; 
    }
    public CartBuilder clearCart() { // Method to clear the cart
        cart.clear(); // Clear all items from the cart
        return this; 
    }
    public Cart build() { // Method to build the cart
        return cart; 
    }
}


