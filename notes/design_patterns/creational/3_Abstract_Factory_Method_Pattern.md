# Abstract Factory Method Pattern

## Intent

Abstract Factory is a creational design pattern that lets you produce families of related objects without specifying their concrete classes. It involves multiple factory methods, one for each type of object to be created.


## Difference Between Abstract Factory and Factory Method

The Abstract Factory and Factory Method patterns are both creational design patterns that deal with object creation, but they serve different purposes and are applied in different scenarios:

- **Factory Method** is about creating a **single object**.
  - It allows a class to defer the instantiation of its objects to its subclasses, providing a way to delegate the creation process to child classes.
  - The Factory Method allows for the extension of the product types and creator types through subclassing the product and  creator interfaces.
- **Abstract Factory** involves creating **families of related or dependent objects** without specifying their concrete classes.
  - It provides an interface for creating families of related objects, without needing to know the exact classes of the objects that will be created.
  - The Abstract Factory pattern uses multiple Factory Methods, one for each type of product to be created
  - The concrete implementations of  Abstract Factory implement these methods to create products belonging to same family.

## What problem it solves?
It solves the challenge of ensuring object compatibility within a family while accommodating system evolution with new products or families without modifying core code.

By defining interfaces for product families and implementing concrete factories per variant, it allows systems to produce compatible objects and easily adapt to new product types.

## Structure

- **AbstractFactory**: Provides an interface for creating a family of related objects.
- **ConcreteFactory**: Implements the interfaces declared by the AbstractFactory to create concrete products.
- **AbstractProduct**: Declares a type for a family of products.
- **ConcreteProduct**: Implements the AbstractProduct interface to define a product to be created by the corresponding ConcreteFactory.
- **Client**: Uses interfaces declared by the AbstractFactory and AbstractProduct classes.

[![Abstract Factory Pattern Structure](https://refactoring.guru/images/patterns/diagrams/abstract-factory/structure.png "Abstract Factory Pattern Structure")](https://refactoring.guru/design-patterns/abstract-factory "Abstract Factory Pattern Structure")

## Example with Pseudocode:

This example illustrates how the Abstract Factory pattern can be used for creating cross-platform UI elements without coupling the client code to concrete UI classes, while keeping all created elements consistent with a selected operating system.

[![Pseudocode example abstract factory method](https://refactoring.guru/images/patterns/diagrams/abstract-factory/example.png "Pseudocode example abstract factory method")](https://refactoring.guru/design-patterns/abstract-factory "Pseudocode example abstract factory method")

- The `GUIFactory `interface declares a set of creation methods that the client code can use to produce different types of UI elements.
- Concrete factories (`WinFactory` and `MacFactory`) correspond to specific operating systems and create the UI elements that match that particular OS.

**Working:** It works like this: when an application launches, it checks the type of the current operating system. The app uses this information to create a factory object from a class that matches the operating system. The rest of the code uses this factory to create UI elements.

**Benefits:**
- With this approach, the client code doesn’t depend on concrete classes of factories (`WinFactory` and `MacFactory`) and UI elements as long as it works with these objects via their abstract interfaces (`GUIFactory`).

- Also, you don’t need to modify the client code each time you add a new variation of UI elements to your app. You just have to create a new factory class that produces these elements and slightly modify the app’s initialization code so it selects that class when appropriate.

**Pseudocode**: TODO

## Advantages and Disadvantages

### Advantages
- Promotes consistency among products.
- You avoid tight coupling between concrete products and client code.
- Single Responsibility Principle. You can extract the product creation code into one place, making the code easier to support.
- Open/Closed Principle. You can introduce new variants of products without breaking existing client code.

### Disadvantages
- The code may become more complicated than it should be, since a lot of new interfaces and classes are introduced along with the pattern.

## Applicability
- **Use the Abstract Factory when your code needs to work with various families of related products, but you don’t want it to depend on the concrete classes of those products**
  - they might be unknown beforehand or you simply want to allow for future extensibility.

- **Consider implementing the Abstract Factory when you have a class with a set of Factory Methods that blur its primary responsibility.**
  -  In a well-designed program each class is responsible only for one thing. When a class deals with multiple product types, it may be worth extracting its factory methods into a stand-alone factory class or a full-blown Abstract Factory implementation.

## Real-world Applications

- **UI Toolkits and Themes**: Differentiating between families of products such as UI elements that vary between operating systems.
- **Cross-platform Software Development**: Creating suites of products where each family corresponds to a different operating system.
- **Database Access Libraries**: Libraries providing a uniform interface to access different types of databases, abstracting the specific database access APIs.

## Design Considerations

Implementing the Abstract Factory Pattern requires careful consideration to maintain flexibility and ensure that adding new families of products does not require extensive changes to the existing factory interface.

## TODO
Advanced java code example on Builder Method

[Families of cross-platform GUI components - Abstract Factory - Refactoring Guru](https://refactoring.guru/design-patterns/abstract-factory/java/example "Families of cross-platform GUI components - Abstract Factory - Refactoring Guru")


