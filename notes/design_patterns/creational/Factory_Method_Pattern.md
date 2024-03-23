# Factory Method Pattern

The Factory Method Pattern defines an interface for creating an object but lets subclasses decide which class to instantiate. It lets a class defer instantiation to subclasses, promoting loose coupling and scalability in the application.

## Applicability

The Factory Method Pattern is best applied in scenarios where:

- **Flexibility in Object Creation is Needed**: When a system should be independent of how its products are created, composed, and represented, and it needs to be configured with one of multiple product variants.

- **Subclassing Mechanism**: When a class wants its subclasses to specify the objects it creates. The pattern allows classes to defer instantiation to subclasses which makes it easier to extend the system with new types of products without changing the existing code.

- **Decoupling Product and Creator**: It provides a way to encapsulate the instantiation of a product. This encapsulation helps to decouple the implementation of the product from the client that uses the product. The client only needs to know about the abstract product interface, not the concrete product class.

## Implementation

A typical implementation involves a `Creator` interface with a method that returns objects of a `Product` interface. The specific product class instantiated by the factory method can be determined by subclasses, making the system flexible and extendable.

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
- Supports easy scalability as new classes can be introduced with little to no change to the application.

### Disadvantages
- Can complicate the code structure by introducing a large number of subclasses.

## Design Considerations
TODO

## Real-world Applications

- **Dynamic Report Generation**: A reporting system where the specific type of report (PDF, HTML, etc.) is decided at runtime based on user input or configuration.
- **UI Toolkits**: Creating UI components where the specific type of component (buttons, text fields) can be decided at runtime.


## Additional Implementations

- **Parameterized Factory Method**: Where a single factory method takes a parameter that specifies the type of object to create.
- **Static Factory Method**: Utilizes static methods to create instances, offering an alternative to having multiple subclasses.
