package Final;

public abstract class Product { //product in the system
    private String name; // name of product
    private double price; // price of the product
    private String type; //type of product
    public Product(String name, double price, String type) {
    	// Constructor to initialize product attributes
        this.name = name;
        this.price = price;
        this.type = type;
    }
    public String getName() { // Method to get the name of the product
        return name;
    }
    public double getPrice() { // Method to get the price of the product
        return price;
    }
    public String getType() { // Method to get the type of the product
        return type;
    }
}

