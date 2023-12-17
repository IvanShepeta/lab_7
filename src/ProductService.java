import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class ProductService {
    private List<OnlineStore> onlineStores;

    public ProductService() {
        this.onlineStores = new ArrayList<>();
    }

    public void addOnlineStore(OnlineStore onlineStore) {
        onlineStores.add(onlineStore);
    }

    // Знаходження мінімальної ціни на заданий товар (з використанням типізованого циклу for-each)
    public double findMinPrice(Product product) {
        double minPrice = Double.MAX_VALUE;

        for (OnlineStore store : onlineStores) {
            double price = store.getProductPrice(product);
            if (price < minPrice) {
                minPrice = price;
            }
        }

        return minPrice;
    }

    // Складання список магазинів, в яких товар можна купити по мінімальній ціні (з використанням типізованого ітератора)
    public List<OnlineStore> findStoresWithMinPrice(Product product) {
        double minPrice = findMinPrice(product);
        List<OnlineStore> storesWithMinPrice = new ArrayList<>();

        for (Iterator<OnlineStore> iterator = onlineStores.iterator(); iterator.hasNext();) {
            OnlineStore store = iterator.next();
            if (store.getProductPrice(product) == minPrice) {
                storesWithMinPrice.add(store);
            }
        }

        return storesWithMinPrice;
    }

    // Визначення, чи є магазин, усі товари якого можна купити по ціні, дешевшій ніж рекомендована ціна виробника (з використанням нетипізованого ітератора)
    public boolean hasStoreWithCheaperPrices(Product product) {
        for (Iterator iterator = onlineStores.iterator(); iterator.hasNext();) {
            OnlineStore store = (OnlineStore) iterator.next();
            if (store.getProductPrice(product) >= product.getManufacturerPrice()) {
                return false;
            }
        }
        return true;
    }
}