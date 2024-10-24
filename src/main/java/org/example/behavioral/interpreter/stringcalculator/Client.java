package org.example.behavioral.interpreter.stringcalculator;


public class Client {
    public static void main(String[] args) {
        // Input expression
        String expression = "3 + 4 * 2";

        // Create interpreter
        Context context = new Context();
        Interpreter interpreter = new Interpreter(context);

        // Interpret expression
        int result = interpreter.interpret(expression);
        System.out.println("Result: " + result);
    }
}
