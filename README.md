# JavaDesignPatterns

https://capgemini.udemy.com/course/design-patterns-in-java-concepts-hands-on-projects/learn/lecture/9584434#overview


### Adapter Pattern
Adapter example
```mermaid
classDiagram
   direction LR
   
class BusinessCardDesigner {
   + designCard(Customer customer) String
}

 class Customer { 
     + operation() void
 }

class EmployeeAdapter {
+ operation() void
}


class Employee {
+ myOperation() void
}

BusinessCardDesigner --> Customer
EmployeeAdapter ..|> Customer
EmployeeAdapter *--> Employee
```
This is the client code:
```java
public class Main {

	public static void main(String[] args) {
		/** Using Class/Two-way adapter **/ 
		EmployeeClassAdapter adapter  = new EmployeeClassAdapter();
		populateEmployeeData(adapter);
		BusinessCardDesigner designer = new BusinessCardDesigner();
		String card  = designer.designCard(adapter);
		System.out.println(card);
		
		System.out.println("************************************************************");
		/** Using Object Adapter **/
		Employee employee = new Employee();
		populateEmployeeData(employee);
		EmployeeObjectAdapter objectAdapter = new EmployeeObjectAdapter(employee); 
		card = designer.designCard(objectAdapter);
		System.out.println(card);
	}

	private static void populateEmployeeData(Employee employee) {
		employee.setFullName("Elliot Alderson");
		employee.setJobTitle("Security Engineer");
		employee.setOfficeLocation("Allsafe Cybersecurity, New York City, New York");
	}
}
```