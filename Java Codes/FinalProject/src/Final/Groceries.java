package Final;

public class Groceries extends Product { //groceries is a subclass of product
    public Groceries(String name, double price) {
        super(name, price, "Groceries");
     // Call the superclass (Product) constructor with the product type "groceries"
    }
}

