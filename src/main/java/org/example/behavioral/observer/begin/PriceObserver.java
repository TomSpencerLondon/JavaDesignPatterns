package org.example.behavioral.observer.begin;

import org.example.behavioral.observer.begin.OrderObserver;

//Concrete observer
public class PriceObserver implements OrderObserver {

    @Override
    public void updated(Order order) {
        double total = order.getItemCost();
        if (total >= 500) {
            order.setDiscount(20);
        } else if (total >= 200) {
            order.setDiscount(10);
        }
    }
}
