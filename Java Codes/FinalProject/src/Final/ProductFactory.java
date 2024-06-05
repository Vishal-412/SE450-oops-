package Final;
public class ProductFactory {
    public static Product createProduct(String category, String name, double price) {
        switch (category) {
            case "Electronics": // If category is Electronics, create an Electronics object
                return new Electronics(name, price);
            case "Clothing": // If category is Clothing, create a Clothing object
                return new Clothing(name, price);
            case "Groceries": // If category is Groceries, create a Groceries object
                return new Groceries(name, price);
            case "Books": // If category is Books, create a Books object
                return new Books(name, price);
            case "Pet Supplies": // If category is Pet Supplies, create a PetSupplies object
                return new PetSupplies(name, price);
            case "Beauty": // If category is Beauty, create a Beauty object
                return new Beauty(name, price);
            default:
                throw new IllegalArgumentException("Invalid product category: " + category);
        }
    }
}

