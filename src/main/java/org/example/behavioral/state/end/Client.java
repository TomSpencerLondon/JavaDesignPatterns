package org.example.behavioral.state.end;

public class Client {

    public static void main(String[] args) {
        Order order = new Order();
        
        order.paymentSuccessful();
        order.dispatched();
        
        order.cancel();
    }
}
