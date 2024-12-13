
package patterns.factory;

import models.Product;

public class ProductFactory {
    public static Product createProduct(String category, String name, double price) {
        switch (category) {
            case "Electronics":
                return new Product(name, "Electronics", price);
            case "Clothing":
                return new Product(name, "Clothing", price);
            case "HomeAppliances":
                return new Product(name, "Home Appliances", price);
            default:
                throw new IllegalArgumentException("Unknown category");
        }
    }
}
