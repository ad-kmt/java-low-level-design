# Factory Method Pattern

The Factory Method Pattern defines an interface for creating an object but lets subclasses decide which class to instantiate, promoting loose coupling and scalability in the application.

## What problem it solves?

The issue it solves is directly related to extending a system to incorporate new types of objects without modifying existing code.

In essence, the pattern helps manage and decouple the creation process from the usage of objects, allowing for easier expansion and maintenance of the system. This approach eliminates the need for code riddled with conditionals for object creation, facilitating cleaner and more modular code that is easier to extend and maintain.

See Example here: [Factory Pattern - Refactoring Guru](https://refactoring.guru/design-patterns/factory-method "Factory Pattern | Refactoring Guru")


## Structure

[![Factory Method Pattern](https://refactoring.guru/images/patterns/diagrams/factory-method/structure.png "Factory Method Pattern")](https://refactoring.guru/design-patterns/factory-method "Factory Method Pattern")

The structure involves these components:

1. **Product Interface**: Defines the methods that must be implemented by any concrete product.
2. **Concrete Product Classes**: Implements Product Interface
3. **Creator Class / Interface**: Declares the factory method that returns new Product objects.
    - You can declare the factory method as abstract to force all ConcreteCreator classes to implement their own versions of the method. As an alternative, the base factory method can return some default product type.
4. **Concrete Creator Classes**: Concrete Creators override the base factory method so it returns a different type of product.
    - Note that the factory method doesn’t have to create new instances all the time. It can also return existing objects from a cache, an object pool, or another source.

## Implementation

1. Make all products follow the same interface. This interface should declare methods that make sense in every product.

2. Add an abstract factory method inside the creator class. The return type of the method should match the common product interface.

3. Now, create a set of creator subclasses for each type of product listed in the factory method. Override the factory method in the subclasses and implement creation of each type of product.

4. If there are too many product types and it doesn’t make sense to create subclasses for all of them, you can use the control parameter from the creator class in subclasses.
    - Control Parameter: This is a parameter passed to the factory method to indicate which type of product to create. It acts as a signal or flag for the method to decide the course of action (which product class to instantiate).



## Basic Java Code Example

```java
interface Product {
    void operate();
}

class ConcreteProductA implements Product {
    public void operate() {
        System.out.println("Operating ConcreteProductA");
    }
}

class ConcreteProductB implements Product {
    public void operate() {
        System.out.println("Operating ConcreteProductB");
    }
}

abstract class Creator {
    abstract Product factoryMethod();
    
    public void anOperation() {
        Product product = factoryMethod();
        product.operate();
    }
}

class ConcreteCreatorA extends Creator {
    Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {
    Product factoryMethod() {
        return new ConcreteProductB();
    }
}
```

## Advantages and Disadvantages

### Advantages
- Promotes loose coupling by reducing the dependency of the application on specific classes.
- Single Responsibility Principle. You can move the product creation code into one place in the program, making the code easier to support.
- Open/Closed Principle. You can introduce new types of products into the program without breaking existing client code.

### Disadvantages
- The code may become more complicated since you need to introduce a lot of new subclasses to implement the pattern.

## Applicability

The Factory Method Pattern is best applied in scenarios where:

- **Use the Factory Method when your code that actually works with product is independent of how its products are created**
    - When a system should be independent of how its products are created, composed, and represented, and it needs to be configured with one of multiple product variants.

- **Use the factory method in situations where a piece of code needs to work with various types of objects but doesn't know in advance which specific classes will be required.**

- **Use the Factory Method when you want to provide users of your library or framework with a way to extend its internal components.**


## Real-world Applications

- **Dynamic Report Generation**: A reporting system where the specific type of report (PDF, HTML, etc.) is decided at runtime based on user input or configuration.
- **UI Toolkits**: Creating UI components where the specific type of component (buttons, text fields) can be decided at runtime.


## Additional Implementations

- **Parameterized Factory Method**: Where a single factory method takes a parameter that specifies the type of object to create.
- **Static Factory Method**: Utilizes static methods to create instances, offering an alternative to having multiple subclasses.

## TODO

- Advanced java code example on Factory Method
  [Java Code Factory Method - Refactoring Guru](https://refactoring.guru/design-patterns/factory-method/java/example "Advanced Java Code Example - Factory Method - Refactoring Guru")

