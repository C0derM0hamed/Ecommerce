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
public class WarrantyDecorator extends ProductDecorator {
    private static final double WARRANTY_COST = 15.0;

    public WarrantyDecorator(ProductComponent product) {
        super(product);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + WARRANTY_COST;
    }

    @Override
    public String getName() {
        return super.getName() + " (With Extended Warranty)";
    }
}
