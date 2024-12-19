package patterns.singleton;

import java.util.ArrayList;
import java.util.List;
import models.Product;
import models.ProductComponent;

public class CartManager {
    private static CartManager instance;
    private List <ProductComponent> cart;

    private CartManager() {
        cart = new ArrayList<>();
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addProduct(ProductComponent product) {
        cart.add(product);
        System.out.println(product.getName() + " added to the cart.");
    }
       public void clearCart() {
        cart.clear();
    }
    public double calculateCartTotal() {
        double total = 0.0;

        // Iterate through all products in the cart
        for (ProductComponent product : CartManager.getInstance().getCartItems()) {
            total += product.getPrice();
        }

       return total;
}

    public List<ProductComponent> getCartItems() {
        return cart;
    }
    public void updateProduct(int index, ProductComponent product) {
        cart.set(index, product);
    }

  
    
}
