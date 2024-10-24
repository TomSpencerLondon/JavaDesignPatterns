package org.example.behavioral.strategy.begin;

import java.util.Collection;

//Strategy
public interface OrderPrinter {
    void print(Collection<Order> orders);
}
