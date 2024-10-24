package org.example.behavioral.interpreter.begin;

//Non-terminal expression 
public class AndExpression implements PermissionExpression {

    private final PermissionExpression first;
    private final PermissionExpression second;

    public AndExpression(PermissionExpression first, PermissionExpression second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean interpret(User user) {
        return first.interpret(user) && second.interpret(user);
    }

    @Override
    public String toString() {
        return first + " AND " + second;
    }
}
