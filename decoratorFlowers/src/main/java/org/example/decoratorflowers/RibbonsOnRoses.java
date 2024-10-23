package org.example.decoratorflowers;

public class RibbonsOnRoses extends Roses {
    @Override
    public String deliverFlowers() {
        return super.deliverFlowers() + "and add Ribbons";
    }
}
