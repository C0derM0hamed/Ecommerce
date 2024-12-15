
package patterns.factory;

import models.Product;

public class ProductFactory {
    public static Product createProduct(String name,String category, double price) {
        switch (category.toLowerCase()) {
            case "electronics":
                return new Product(name, "electronics", price);
            case "clothing":
                return new Product(name, "clothing", price);
            case "homeAppliances":
                return new Product(name, "home Appliances", price);
            default:
                throw new IllegalArgumentException("Unknown category");
        }
    }
    
        public static Product createProductToCard(int id,String name,String category, double price) {
        switch (category.toLowerCase()) {
            case "electronics":
                return new Product(id,name, "electronics", price);
            case "clothing":
                return new Product(id,name, "clothing", price);
            case "homeAppliances":
                return new Product(id,name, "home Appliances", price);
            default:
                throw new IllegalArgumentException("Unknown category");
        }
        
    }

 
}
