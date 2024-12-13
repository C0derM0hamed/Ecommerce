package patterns.singleton;

import java.util.ArrayList;
import java.util.List;
import models.Product;

public class CartManager {
    private static CartManager instance;
    private List<Product> cart;

    private CartManager() {
        cart = new ArrayList<>();
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addToCart(Product product) {
        cart.add(product);
    }

    public List<Product> getCartItems() {
        return cart;
    }
}
