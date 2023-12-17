public class Product {
    private String name;
    private double manufacturerPrice; // Рекомендована ціна виробника

    public Product(String name, double manufacturerPrice) {
        this.name = name;
        this.manufacturerPrice = manufacturerPrice;
    }

    public String getName() {
        return name;
    }

    public double getManufacturerPrice() {
        return manufacturerPrice;
    }
}