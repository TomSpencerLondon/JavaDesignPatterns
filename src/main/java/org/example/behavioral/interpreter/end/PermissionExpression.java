package org.example.behavioral.interpreter.end;

//Abstract expression
public interface PermissionExpression {

	boolean interpret(User user); 
}
