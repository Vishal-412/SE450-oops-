package Final;
import java.util.ArrayList;
import java.util.List;
public class ProductCatalog { // Class representing a catalog of products in the system
    private List<Product> products; // List to store products in the catalog
    public ProductCatalog() { // Constructor to initialize the product catalog
        this.products = new ArrayList<>(); // Initialize the product list
    }
    public void addProduct(Product product) {
        products.add(product); // Add the product to the list
    }
    public List<Product> getProducts() { // Method to retrieve all products in the catalog
        return products; // Return the list of products
    }
}
