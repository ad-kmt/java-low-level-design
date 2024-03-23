# Prototype Pattern

The Prototype Pattern is a creational design pattern that focuses on the cloning of objects. The pattern is used when the creation of an object directly is inefficient or complex due to reasons like costly database operations, network latency, or simply because the object is too heavyweight, and its creation from scratch is resource-intensive.

## Applicability

Use the Prototype pattern when:

- The costs of creating an object are more significant than copying an existing object.
- An object needs to be created that is similar to an existing object, and it is more convenient to copy the existing object to make the necessary changes rather than creating a new object from scratch.
- The creation of objects should be independent of their systems or the way objects are created, composed, and represented.

## Implementation

A typical implementation involves an abstract base class that declares an interface for cloning itself. Concrete subclasses implement the cloning method to create exact copies of themselves.

[![Prototype Pattern](https://www.pentalog.com/wp-content/uploads/2023/05/prototype-design-pattern.png "Prototype Pattern")](https://www.pentalog.com/blog/design-patterns/prototype-design-pattern/ "Prototype Pattern")


## Advantages

- **Added Flexibility**: The Prototype pattern enhances flexibility by allowing for the dynamic addition and customization of objects at runtime through cloning. This capability enables systems to adapt and modify object configurations or compositions on the fly, without being tightly coupled to specific object classes.
- **Reduced Subclassing**: Clone operations allow for the instantiation of configured objects without needing a class that matches the configuration.
- **Performance Gains**: Cloning can be more efficient than creating objects afresh, especially if the object creation involves costly operations.

## Disadvantages

- **Complicated Cloning**: Cloning complex objects that have circular references might be very challenging.
- **Clone and Constructor**: The cloning bypasses the constructor call which might lead to issues if the object construction involves some logic.

## Real-world Applications

- **Document Editors**: Prototype patterns are extensively used in document editors for implementing features like copy-paste. The document object can be cloned and modified without going through the complex creation process.
- **Game Development**: In games, objects like trees, cars, buildings, or even NPCs (Non-Player Characters) can be prototypes that are cloned multiple times to populate the game world.

## Cloneable Interface in Java and the Prototype Pattern
The `Cloneable` interface facilitates the prototype pattern in Java by enabling object cloning through the `clone()` method, which is protected in the Object class. When a class implements the Cloneable interface and overrides the clone() method to make it public, it can create copies of its instances, effectively using the Prototype pattern.

## Deep Copy vs. Shallow Copy

When using the Prototype pattern, it's crucial to understand the difference between **deep copy** and **shallow copy**, as this affects how the cloned objects relate to their originals, especially in terms of shared references.

#### Shallow Copy
A shallow copy of an object copies the 'outer' structure of the object but not the internal objects it references. The copied object gets references to the same internal objects as the original object. This means that changes made to the internal state of the copied object can affect the original object, and vice versa.

#### Deep Copy
A deep copy duplicates everything. Not only is the 'outer' structure of the original object copied, but all objects referenced by the original object are also recursively copied. This results in two objects that do not share references, ensuring changes to the cloned object have no impact on the original object.

#### Note for primitive data types
Primitive data types in Java (such as int, char, float, boolean, etc.) are copied by value. This means that when you clone an object, each primitive data type within that object is copied directly. So shallow copy will also create independent primitive variables in copied objects.

## TODO

#### Prototype Registry
Discuss the implementation and benefits of a prototype registry, which provides a way to access frequently used prototypes without knowing their classes.
