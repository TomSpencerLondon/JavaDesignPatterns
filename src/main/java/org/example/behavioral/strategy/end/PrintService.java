package org.example.behavioral.strategy.end;


import java.util.LinkedList;

//Context 
public class PrintService {

	private OrderPrinter printer;
	
    public PrintService(OrderPrinter printer) {
    	this.printer = printer;
    }

    public void printOrders(LinkedList<Order> orders) {
        printer.print(orders);
    }
}
