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

BusinessCardDesigner ..> Customer
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

### Bridge Design Pattern
```mermaid
classDiagram
    class Client {
    }

    direction LR
    
    class Abstraction {
    - Implementor implementor
    + Abstraction(Implementor implementor)
    + operation(): void
    }


    %% Refined Abstraction directly below Abstraction
    class RefinedAbstraction {
        + operation(): void
    }
    
    %% Implementor
    class Implementor {
        + implementation(): void
    }

    %% Concrete Implementors
    class ConcreteImplementorA {
        + implementation(): void
    }

    class ConcreteImplementorB {
        + implementation(): void
    }

    %% Depends
    Client ..> Abstraction
    %% Inheritance
    RefinedAbstraction --|> Abstraction
    %% Composition
    Abstraction *--> Implementor
    Implementor <|-- ConcreteImplementorA
    Implementor <|-- ConcreteImplementorB
    
    %% Inheritance: ClassA --|> ClassB
    %% Composition: ClassA *-- ClassB
    %% Aggregation: ClassA o-- ClassB
    %% Association: ClassA -- ClassB
    %% Dependency: ClassA ..> ClassB
    %% Realization: ClassA ..|> InterfaceB
%%
```
#### Java Examples
- Collections.newSetFromMap()
- java.sql.Driver

## Decorator Design Pattern
```mermaid
classDiagram
    direction TB

%% Component Interface
    class Component {
        + operation(): void
    }

%% Concrete Component
    class ConcreteComponent {
        + operation(): void
    }

%% Decorator
    class Decorator {
        - Component component
        + Decorator(Component component)
        + operation(): void
    }

%% Concrete Decorators
    class ConcreteDecoratorA {
        + operation(): void
    }

    class ConcreteDecoratorB {
        + operation(): void
    }

%% Relationships
    Component <|-- ConcreteComponent
    Component <|-- Decorator
    Decorator *-- Component
    Decorator <|-- ConcreteDecoratorA
    Decorator <|-- ConcreteDecoratorB

```

Implementation
```mermaid
classDiagram
direction TB
class Base64EncodedMessage {
  - Message msg
  + getContent() String
}
class Client {
  + main(String[]) void
}
class HtmlEncodedMessage {
  - Message msg
  + getContent() String
}
class Message {
<<Interface>>
  + getContent() String
}
class TextMessage {
  - String msg
  + getContent() String
}

Base64EncodedMessage  ..>  Message 
Base64EncodedMessage "1" *--> "msg 1" Message 
Client  ..>  Base64EncodedMessage : «create»
Client  ..>  HtmlEncodedMessage : «create»
Client  ..>  TextMessage : «create»
HtmlEncodedMessage  ..>  Message 
HtmlEncodedMessage "1" *--> "msg 1" Message 
TextMessage  ..>  Message

%% Inheritance: ClassA --|> ClassB
%% Composition: ClassA *-- ClassB
%% Aggregation: ClassA o-- ClassB
%% Association: ClassA -- ClassB
%% Dependency: ClassA ..> ClassB
%% Realization: ClassA ..|> InterfaceB

```

Java examples
- java.io.OutputStream

```java
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

class Example {
    public static void main(String[] args) {
        try(OutputStream os = new BufferedOutputStream(new FileOutputStream("xfiles_mulder_notes.txt"))) {
            os.write('x');
            os.flush();

        }
    }    
}

```

### Composite Design Pattern
```mermaid
classDiagram
    direction TB

    %% Component
    class Component {
        + operation(): void
    }

    %% Leaf
    class Leaf {
        + operation(): void
    }

    %% Composite
    class Composite {
        - children: List<Component>
        + operation(): void
        + add(child: Component): void
        + remove(child: Component): void
    }

    %% Relationships
    Component <|-- Leaf
    Component <|-- Composite
    Composite *-- Leaf

    %% Client
    class Client {
        + clientOperation(Component component): void
    }

    %% Dependency
    Client ..> Component


```
Example code
```mermaid
classDiagram
    direction TB

    %% BinaryFile Class
    class BinaryFile {
        - size: long
        + addFile(File): void
        + ls(): void
        + removeFile(File): boolean
        + getFiles(): File[]
    }

    %% Client Class
    class Client {
        + main(String[]): void
        - createTreeOne(): File
        - createTreeTwo(): File
    }

    %% Directory Class
    class Directory {
        - children: List<File>
        + addFile(File): void
        + removeFile(File): boolean
        + getFiles(): File[]
        + ls(): void
    }

    %% File Class
    class File {
        - name: String
        + ls(): void
        + removeFile(File): boolean
        + setName(String): void
        + getFiles(): File[]
        + getName(): String
        + addFile(File): void
    }

    %% Relationships
    BinaryFile <|-- File
    Client ..> BinaryFile : "«create»"
    Client ..> Directory : "«create»"
    Directory <|-- File
    Directory "1" *-- "children\n*" File
    Directory ..> File : "«create»"

```