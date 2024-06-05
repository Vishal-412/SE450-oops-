package Final;

public class AuthenticationService {
	// Reference to the UserService that will be used for user authentication.
    private UserService userService; // Reference to the UserService
    public AuthenticationService(UserService userService) {
        this.userService = userService; // Initialize the UserService reference
    }
    public User authenticate(String username, String password) {
        return userService.login(username, password); // Use UserService to authenticate the user
    }
}

