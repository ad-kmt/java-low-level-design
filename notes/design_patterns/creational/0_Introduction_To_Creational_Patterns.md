# Introduction to Creational Patterns

Creational patterns are fundamentally about the art of object creation. They aim to solve specific problems related to object creation while keeping the system independent of the way its objects are created, composed, and represented.

In the journey of software design, we often find ourselves needing more control over how objects are created, considering factors like the initial state of objects and the overall impact on the system's architecture.

## Why Creational Patterns?

When we develop software, the instantiation of objects can often introduce complexity into our designs. Creational patterns help us manage this complexity by:
#### Encapsulating Knowledge About Which Concrete Classes The System Uses
We hide the details of object creation, making the system more modular and easier to maintain.

**Example**: Consider a document editor that can create different types of documents, like text documents, spreadsheets, and presentations. By using a factory design pattern, the editor can instantiate document objects without knowing the concrete classes of the documents it creates. This encapsulation allows adding new document types without altering the editor's code that utilizes the factory.

### Hiding How Instances of These Classes Are Created and Combined
This encapsulation makes it easier to introduce new types and representations without affecting the system.

**Example**: Extending the document editor example, suppose the creation process of documents becomes complex, involving not just instantiation but also configuration steps. By encapsulating this creation logic within a factory, the rest of the application remains unaffected by changes to the creation process, such as adding new configuration steps or introducing new dependencies.

### Providing Greater Flexibility in Deciding Which Objects Are Needed for a Given Case
We can defer object creation to subclasses, choosing at runtime which objects are best suited for the current context.

**Example**: If our document editor needs to support different environments or configurations, like a lightweight mode where it only supports text documents, or a full-featured mode with support for all document types, the factory pattern can dynamically decide which document types to instantiate based on the runtime environment, enhancing flexibility and adaptability.

## Types of Creational Patterns

There are several creational design patterns, each addressing different aspects of object creation:
- **Singleton**: Ensures a class only has one instance and provides a global point of access to it.
- **Factory Method**: Defines an interface for creating an object, but lets subclasses alter the type of objects that will be created.
- **Abstract Factory**: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
- **Builder**: Allows constructing complex objects step by step, separating the construction process from its representation.
- **Prototype**: Creates new objects by copying an existing object, known as the prototype.

Each creational pattern offers a unique approach to handling object creation, providing us with flexibility and control over the system's structure and behavior. As we delve into each pattern, we'll explore their specific advantages, use cases, and implementation details.
