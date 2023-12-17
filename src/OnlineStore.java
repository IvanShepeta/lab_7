import java.util.ArrayList;
import java.util.List;
public class OnlineStore {
    private String storeName;
    private List<Product> products;
    private List<Double> prices;

    public OnlineStore(String storeName) {
        this.storeName = storeName;
        this.products = new ArrayList<>();
        this.prices = new ArrayList<>();
    }

    public void addProduct(Product product, double price) {
        products.add(product);
        prices.add(price);
    }

    public String getStoreName() {
        return storeName;
    }

    public Double getProductPrice(Product product) {
        int index = products.indexOf(product);
        if (index != -1) {
            return prices.get(index);
        } else {
            return null; // Якщо товар не знайдено
        }
    }

    public List<Product> getAvailableProducts() {
        return new ArrayList<>(products);
    }
}