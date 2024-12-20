package patterns.decorator;

import models.ProductComponent;

/**
 *
 * @author moham
 */
public class WarrantyDecorator extends ProductDecorator {
    private static final double WARRANTY_COST = 20.0;

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
