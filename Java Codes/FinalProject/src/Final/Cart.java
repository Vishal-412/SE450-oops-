package Final;

import java.util.ArrayList;
import java.util.List;
public class Cart {
    private static Cart instance;
    private List<Product> items;
    private Cart() {
        items = new ArrayList<>();
    }
    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }
    public void addItem(Product product) {
        items.add(product);
    }
    public void removeItem(Product product) {
        items.remove(product);
    }
    public List<Product> getItems() {
        return new ArrayList<>(items);
    }
    public void clear() {
        items.clear();
    }
}
