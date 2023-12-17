import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

        OnlineStore store1 = new OnlineStore("Store1");
        OnlineStore store2 = new OnlineStore("Store2");

        Product product1 = new Product("Laptop", 1000.0);
        Product product2 = new Product("Phone", 500.0);

        store1.addProduct(product1, 950.0);
        store1.addProduct(product2, 480.0);

        store2.addProduct(product1, 980.0);
        store2.addProduct(product2, 490.0);

        productService.addOnlineStore(store1);
        productService.addOnlineStore(store2);

        // Виконання завдань

        // 1) Знаходження мінімальної ціни для товару 'Laptop' (з використанням типізованого циклу for-each)
        System.out.println("Мінімальна ціна для товару '" + product1.getName() + "': " + productService.findMinPrice(product1));

        // 2) Складання список магазинів, в яких можна купити товар 'Laptop' по мінімальній ціні (з використанням нетипізованого ітератора)
        List<OnlineStore> storesWithMinPrice = productService.findStoresWithMinPrice(product1);
        System.out.println("Магазини, в яких можна купити товар '" + product1.getName() + "' по мінімальній ціні:");
        for (OnlineStore store : storesWithMinPrice) {
            System.out.println(store.getStoreName());
        }

        // 3) Визначення, чи є магазин, усі товари якого можна купити по ціні, дешевшій ніж рекомендована ціна виробника (з використанням типізованого ітератора)
        boolean hasStoreWithCheaperPrices = productService.hasStoreWithCheaperPrices(product1);
        System.out.println("Чи є магазин, усі товари якого можна купити по ціні, дешевшій ніж рекомендована ціна виробника: " + hasStoreWithCheaperPrices);
    }
}