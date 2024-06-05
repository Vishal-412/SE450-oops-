package Final;
import java.util.HashMap;
import java.util.Map;
public class UserService { // Class responsible for user management
    private Map<String, User> users = new HashMap<>(); // Map to store registered users

    public void register(String username, String password) {
        if (!users.containsKey(username)) { // Check if the username already exists
            users.put(username, new User(username, password));
        }
    }
    public User login(String username, String password) { // Method to authenticate a user
        User user = users.get(username); // Retrieve the user based on the username
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null; // Otherwise, return null
    }
}
