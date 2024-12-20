package patterns.decorator;

//Use decorator to edit to the price of product without enter the class code in every time 

import models.ProductComponent;

/**
 *
 * @author moham
 */
public abstract class ProductDecorator implements ProductComponent {
    protected ProductComponent product;
    
    public ProductDecorator(ProductComponent product) {
        this.product = product;
    }

    @Override
    public int getId() {
        return product.getId();
    }

    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public String getCategory() {
        return product.getCategory();
    }

    @Override
    public double getPrice() {
        return product.getPrice();
    }
    
}
