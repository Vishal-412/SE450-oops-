package Final;

import java.util.List;
public class Order { // Class representing an order in the system
    private User user; // User who placed the order
    private List<Product> items; // List of products in the order
    public Order(User user, List<Product> items) { // Constructor to initialize the order with user and items
        this.user = user; // Set the user for the order
        this.items = items; // Set the list of items for the order
    }
    public User getUser() { // Getter method for retrieving the user of the order
        return user; // Return the user of the order
    }
    public List<Product> getItems() { // Getter method for retrieving the list of items in the order
        return items; // Return the list of items in the order
    }
}
