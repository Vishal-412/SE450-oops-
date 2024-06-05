package Final;

public class OrderService { // Class responsible for placing orders in the system
    public void placeOrder(User user) { // Method to place an order for the given user
        Cart cart = user.getCart(); // Get the user's cart
        Order order = new Order(user, cart.getItems()); // Create a new order with the user and cart items
        cart.clear(); // Clear the user's cart after placing the order
        Logger.log("Order placed for user: " + user.getUsername()); // Log the order placement event
    }
}


