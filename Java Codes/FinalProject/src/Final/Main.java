package Final;

import java.util.List;
import java.util.Scanner;
public class Main {
    private static UserService userService = new UserService();
    private static AuthenticationService authService = new AuthenticationService(userService);
    private static ProductCatalog catalog = new ProductCatalog();
    private static OrderService orderService = new OrderService();
    private static PaymentService paymentService = new PaymentService();
    private static User currentUser;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeCatalog();
        while (true) { // Infinite loop for user interaction
            System.out.println("Select an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Browse Products");
            System.out.println("4. Add Product to Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Place Order");
            System.out.println("7. Process Payment");
            System.out.println("8. Exit");

            int option = scanner.nextInt(); // Read user's choice
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    register(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    browseProducts();
                    break;
                case 4:
                    addProductToCart(scanner);
                    break;
                case 5:
                    viewCart();
                    break;
                case 6:
                    placeOrder();
                    break;
                case 7:
                    processPayment(scanner);
                    break;
                case 8:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not a valid option, please try again.");
            }
        }
    }

    private static void register(Scanner scanner) {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        userService.register(username, password);
        System.out.println("User registered successfully.");
    }

    private static void login(Scanner scanner) {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        currentUser = authService.authenticate(username, password);
        if (currentUser != null) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed.");
        }
    }

    private static void browseProducts() {
        List<Product> products = catalog.getProducts();
        System.out.println("Available products:");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " (" + product.getType() + ") - $" + product.getPrice());
        }
    }

    private static void addProductToCart(Scanner scanner) {
        if (currentUser == null) {
            System.out.println("Please login first.");
            return;
        }
        browseProducts();
        System.out.println("Enter the product number to add to cart:");
        int productNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        List<Product> products = catalog.getProducts();
        if (productNumber > 0 && productNumber <= products.size()) {
            Product product = products.get(productNumber - 1);
            CartBuilder cartBuilder = new CartBuilder();
            cartBuilder.addItem(product);
            System.out.println("Product added to cart.");
        } else {
            System.out.println("Invalid product number.");
        }
    }
 // Method to view user's cart
    private static void viewCart() {
        if (currentUser == null) {
            System.out.println("Please login first.");
            return;
        }
        Cart cart = currentUser.getCart();
        List<Product> items = cart.getItems();
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your cart:");
            for (Product item : items) {
                System.out.println(item.getName() + " (" + item.getType() + ") - $" + item.getPrice());
            }
        }
    }
 // Method to place an order
    private static void placeOrder() {
        if (currentUser == null) {
            System.out.println("Please login first.");
            return;
        }
        orderService.placeOrder(currentUser);
    }
 // Method to process payment for an order
    private static void processPayment(Scanner scanner) {
        if (currentUser == null) {
            System.out.println("Please login first.");
            return;
        }
        System.out.println("Enter payment amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        if (paymentService.processPayment(currentUser, amount)) {
            System.out.println("Payment processed successfully.");
        } else {
            System.out.println("Payment failed.");
        }
    }

    private static void initializeCatalog() {
        catalog.addProduct(ProductFactory.createProduct("Electronics", "Smartphone", 999.99));
        catalog.addProduct(ProductFactory.createProduct("Clothing", "T-Shirt", 19.99));
        catalog.addProduct(ProductFactory.createProduct("Electronics", "Laptop", 999.99));
        catalog.addProduct(ProductFactory.createProduct("Clothing", "Jeans", 49.99));
        catalog.addProduct(ProductFactory.createProduct("Groceries", "Apple", 0.99));
        catalog.addProduct(ProductFactory.createProduct("Books", "Java Programming", 29.99));
        catalog.addProduct(ProductFactory.createProduct("Pet Supplies", "Dog Food", 39.99));
        catalog.addProduct(ProductFactory.createProduct("Beauty", "Shampoo", 14.99));
    }
}
