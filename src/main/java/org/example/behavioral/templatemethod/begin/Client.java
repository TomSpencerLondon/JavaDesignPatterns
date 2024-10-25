package org.example.behavioral.templatemethod.begin;

import java.io.FileNotFoundException;

public class Client {

	public static void main(String[] args) throws FileNotFoundException {
		Order order = new Order("1001");

		order.addItem("Soda", 2.50);
		order.addItem("Sandwich", 11.95);
		order.addItem("Pizza", 15.95);

		OrderPrinter printer = new TextPrinter();
		OrderPrinter htmlPrinter = new HtmlPrinter();

		printer.printOrder(order, "1001.txt");
		htmlPrinter.printOrder(order, "1001.html");
	}
}
