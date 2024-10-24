package org.example.behavioral.interpreter.stringcalculator;

import java.util.Stack;

public class Parser {
    public static Expression parse(String expression) {
        String[] tokens = expression.split(" ");
        Stack<Expression> operandStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                operandStack.push(new NumberExpression(Integer.parseInt(token)));
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(token)) {
                    Expression right = operandStack.pop();
                    Expression left = operandStack.pop();
                    operandStack.push(createExpression(operatorStack.pop(), right, left));
                }
                operatorStack.push(token);
            }
        }

        // Process remaining operators
        while (!operatorStack.isEmpty()) {
            Expression right = operandStack.pop();
            Expression left = operandStack.pop();
            operandStack.push(createExpression(operatorStack.pop(), right, left));
        }

        return operandStack.pop();
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int precedence(String operator) {
        switch (operator) {
            case "*": case "/": return 2;
            case "+": case "-": return 1;
            default: return 0;
        }
    }

    private static Expression createExpression(String operator, Expression right, Expression left) {
        switch (operator) {
            case "+": return new AdditionExpression(left, right);
            case "-": return new SubtractionExpression(left, right);
            case "*": return new MultiplicationExpression(left, right);
            case "/": return new DivisionExpression(left, right);
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
