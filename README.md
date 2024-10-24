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

### Another Decorator pattern example
```mermaid
classDiagram
direction TB
class Chocolates {
  + deliverFlowers() String
}
class ChocolateswithRibbons {
  + deliverFlowers() String
}
class DecorateRosesWithRibbons {
  + deliverFlowers() String
}
class DecoratorpatternApplication {
  + run(String[]) void
  + main(String[]) void
}
class IBouquet {
<<Interface>>
  + deliverFlowers() String
}
class RibbonsOnRoses {
  + deliverFlowers() String
}
class Roses {
  + deliverFlowers() String
}
class Tulips {
  + deliverFlowers() String
}

Chocolates  ..>  IBouquet 
Chocolates "1" *--> "roses 1" Roses 
ChocolateswithRibbons "1" *--> "decorateRosesWithRibbons 1" DecorateRosesWithRibbons 
ChocolateswithRibbons  ..>  IBouquet 
DecorateRosesWithRibbons  ..>  IBouquet 
DecorateRosesWithRibbons "1" *--> "bouquet 1" IBouquet 
DecoratorpatternApplication "1" *--> "bouquet 1" IBouquet 
RibbonsOnRoses  -->  Roses 
Roses  ..>  IBouquet 
Tulips  ..>  IBouquet 

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

### Facade Pattern

```mermaid
classDiagram
    direction LR

    %% Facade class
    class Facade {
        + operationA(): void
        + operationB(): void
    }

    %% Subsystem classes
    class Subsystem1 {
        + operation1(): void
    }

    class Subsystem2 {
        + operation2(): void
    }

    class Subsystem3 {
        + operation3(): void
    }

    %% Relationships
    Facade --> Subsystem1 : uses
    Facade --> Subsystem2 : uses
    Facade --> Subsystem3 : uses

```
Example:
- java.net.URL
  - openStream()

### Proxy Design Pattern
```mermaid
classDiagram
    direction TB
    
    class Client {
    }

    %% Subject Interface
    class Subject {
      <<Interface>>
      + request(): void
    }

    %% RealSubject Class
    class RealSubject {
        + request(): void
    }

    %% Proxy Class
    class Proxy {
        - realSubject: RealSubject
        + request(): void
    }

    %% Relationships
    Client ..> Subject
    Subject <|-- RealSubject
    Subject <|-- Proxy
    Proxy *-- RealSubject

    %% Comments
    %% Inheritance: ClassA --|> ClassB
    %% Realization: ClassA ..|> InterfaceB
    %% Composition: ClassA *-- ClassB
    %% Aggregation: ClassA o-- ClassB
    %% Dependency: ClassA ..> ClassB
    %% Association: ClassA -- ClassB

```

## Behavioral Design Patterns

### Chain of Responsibility
```mermaid
classDiagram
    direction LR

    %% Handler Interface
    class Handler {
        + handleRequest(request: Request): void
        + setNext(handler: Handler): void
    }

    %% Concrete Handlers
    class ConcreteHandler1 {
        + handleRequest(request: Request): void
    }

    class ConcreteHandler2 {
        + handleRequest(request: Request): void
    }

    class ConcreteHandler3 {
        + handleRequest(request: Request): void
    }

    %% Request class
    class Request {
        + getRequestType(): String
    }

    %% Relationships
    Request ..> Handler
    Handler <|.. ConcreteHandler1
    Handler <|.. ConcreteHandler2
    Handler <|.. ConcreteHandler3
    Handler o--> Handler : "next"

```

### Command Pattern

```mermaid
classDiagram
    %% Command Interface
    class Command {
      +execute()
    }

    %% Concrete Commands
    class ConcreteCommandA {
      -receiver : Receiver
      +execute()
    }
    
    class ConcreteCommandB {
      -receiver : Receiver
      +execute()
    }

    %% Receiver Class
    class Receiver {
      +actionA()
      +actionB()
    }

    %% Invoker Class
    class Invoker {
      -command : Command
      +setCommand(Command)
      +executeCommand()
    }

    %% Client Class
    class Client {
      +main()
    }

    %% Associations
    Command <|-- ConcreteCommandA
    Command <|-- ConcreteCommandB
    ConcreteCommandA --> Receiver
    ConcreteCommandB --> Receiver
    Invoker --> Command
    Client --> Invoker

    %% Descriptions
    Command : Interface for executing operations
    ConcreteCommandA : Binds receiver to action A
    ConcreteCommandB : Binds receiver to action B
    Receiver : Knows how to perform the action
    Invoker : Asks the command to carry out the request
    Client : Creates and configures the command objects

```

### Interpreter design pattern

```mermaid
classDiagram
    class Context {
        +lookup(String key) : Any
        +assign(Expression exp, Any value)
    }
    
    class AbstractExpression {
        <<interface>>
        +interpret(Context context) : Any
    }
    
    class TerminalExpression {
        +interpret(Context context) : Any
    }

    class NonTerminalExpression {
        +interpret(Context context) : Any
    }

    Context -- AbstractExpression
    AbstractExpression <|-- TerminalExpression
    AbstractExpression <|-- NonTerminalExpression
    
    class Client {
        +context : Context
        +expressions : List~AbstractExpression~
        +interpret() : Any
    }

    Client --> AbstractExpression : interprets


```

### Iterator pattern

```mermaid
classDiagram
    class Iterator {
        <<interface>>
        +hasNext() bool
        +next() Object
    }
    
    class ConcreteIterator {
        -collection : ConcreteCollection
        -index : int
        +hasNext() bool
        +next() Object
    }

    class Aggregate {
        <<interface>>
        +createIterator() Iterator
    }

    class ConcreteCollection {
        -items : List~Object~
        +createIterator() Iterator
        +addItem(Object item)
        +getItem(int index) Object
        +getSize() int
    }

    Iterator <|-- ConcreteIterator
    Aggregate <|-- ConcreteCollection
    ConcreteIterator --> ConcreteCollection : accesses
```

### Memento Pattern

```mermaid
classDiagram
    %% Originator Class
    class Originator {
      -state : String
      +setState(String)
      +getState() : String
      +saveState() : Memento
      +restoreState(memento: Memento)
    }

    %% Memento Class
    class Memento {
      -state : String
      +getState() : String
    }

    %% Caretaker Class
    class Caretaker {
      -mementoList : List~Memento~
      +addMemento(Memento)
      +getMemento(index: int) : Memento
    }

    %% Associations
    Originator --> Memento : Creates
    Caretaker --> Memento : Stores
    Originator --> Caretaker : Uses

    %% Descriptions
    Originator : Creates and stores states inside Memento
    Memento : Stores internal state of the Originator
    Caretaker : Maintains the history of Mementos

```

### Observer Pattern

```mermaid
classDiagram
    %% Subject Interface
    class Subject {
      +attach(Observer)
      +detach(Observer)
      +notify()
    }

    %% Concrete Subject
    class ConcreteSubject {
      -state : String
      +getState() : String
      +setState(String)
    }

    %% Observer Interface
    class Observer {
      +update()
    }

    %% Concrete Observer
    class ConcreteObserverA {
      -subject : ConcreteSubject
      +update()
    }
    
    class ConcreteObserverB {
      -subject : ConcreteSubject
      +update()
    }

    %% Associations
    Subject <|-- ConcreteSubject
    Observer <|-- ConcreteObserverA
    Observer <|-- ConcreteObserverB
    ConcreteSubject --> Observer : notifies
    ConcreteObserverA --> ConcreteSubject : observes
    ConcreteObserverB --> ConcreteSubject : observes

    %% Descriptions
    Subject : Maintains list of observers and notifies them of changes
    ConcreteSubject : Has state that changes and notifies observers
    Observer : Interface with update() method
    ConcreteObserverA : Updates based on subject's state
    ConcreteObserverB : Updates based on subject's state

```

### State Pattern

```mermaid
classDiagram
    %% Context Class
    class Context {
      -state : State
      +setState(State)
      +request()
    }

    %% State Interface
    class State {
      +handle(Context)
    }

    %% Concrete State A
    class ConcreteStateA {
      +handle(Context)
    }

    %% Concrete State B
    class ConcreteStateB {
      +handle(Context)
    }

    %% Associations
    Context --> State : delegates to
    State <|-- ConcreteStateA
    State <|-- ConcreteStateB

    %% Descriptions
    Context : Maintains current state and changes behavior based on state
    State : Interface declaring the handle() method
    ConcreteStateA : Implements state-specific behavior
    ConcreteStateB : Implements state-specific behavior

```

### Strategy Pattern

```mermaid
classDiagram
    direction LR
    class Context {
        -Strategy strategy
        +setStrategy(Strategy strategy)
        +executeStrategy()
    }

    class Strategy {
        <<interface>>
        +execute()
    }

    class ConcreteStrategyA {
        +execute()
    }

    class ConcreteStrategyB {
        +execute()
    }

    class ConcreteStrategyC {
        +execute()
    }

    Context --> Strategy : "uses"
    Strategy <|-- ConcreteStrategyA
    Strategy <|-- ConcreteStrategyB
    Strategy <|-- ConcreteStrategyC

```