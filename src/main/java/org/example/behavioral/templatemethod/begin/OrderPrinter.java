package org.example.behavioral.templatemethod.begin;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

//Abstract base class defines the template method
public abstract class OrderPrinter {

    public final void printOrder(Order order, String filename) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.println(start());

            writer.println(formatOrderNumber(order));
            writer.println(formatItems(order));
            writer.println(formatTotal(order));
            writer.println(end());
        }
    }

    protected abstract String start();

    protected abstract String formatOrderNumber(Order order);

    protected abstract String formatItems(Order order);

    protected abstract String formatTotal(Order order);

    protected abstract String end();
}
