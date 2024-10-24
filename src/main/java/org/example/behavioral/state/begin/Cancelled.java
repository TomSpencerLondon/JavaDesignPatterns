package org.example.behavioral.state.begin;

public class Cancelled implements OrderState {

    @Override
    public double handleCancellation() {
        throw new IllegalStateException("Cancelled order. Can't cancel anymore");
    }
}
