package Final;
public class User { // Class representing a user in the system
    private String username; // User's username
    private String password; // User's password
    private Cart cart; // User's shopping cart
    public User(String username, String password) { // Constructor to initialize user with username and password
        this.username = username; 
        this.password = password; 
        this.cart = Cart.getInstance(); // Initialize the user's shopping cart
    }
    public String getUsername() { // Method to get the user's username
        return username;
    }
    public String getPassword() { // Method to get the user's password
        return password;
    }
    public Cart getCart() { // Method to get the user's shopping cart
        return cart;
    }
}


