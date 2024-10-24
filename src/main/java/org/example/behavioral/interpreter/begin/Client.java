package org.example.behavioral.interpreter.begin;

public class Client {

	public static void main(String[] args) {
		Report firstReport = new Report("Cashflow report", "FIANCE_ADMIN OR ADMIN");
		ExpressionBuilder builder = new ExpressionBuilder();
		PermissionExpression expression = builder.build(firstReport);

		System.out.println(expression);

		User firstUser = new User("Dave", "USER");

		System.out.println("User access report: " + expression.interpret(firstUser));
	}

}
