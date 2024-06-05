package Final;

public class Electronics extends Product { //we are creating a electronic class which is a subclass of product
    public Electronics(String name, double price) {
        super(name, price, "Electronics");
        // Call the superclass (Product) constructor with the product type "Electronics"
    }
}

