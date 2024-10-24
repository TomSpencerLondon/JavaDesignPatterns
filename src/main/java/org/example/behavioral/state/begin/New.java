package org.example.behavioral.state.begin;

public class New implements OrderState {


    @Override
    public double handleCancellation() {
        System.out.println("It's a new Order. No processing done");
        return 0;
    }
}
