package org.example.behavioral.observer.begin;

public interface Observable {
    void attach(OrderObserver observer);

    void detach(OrderObserver observer);
}
