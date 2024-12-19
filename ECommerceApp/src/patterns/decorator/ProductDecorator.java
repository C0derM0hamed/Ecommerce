/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.decorator;

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
