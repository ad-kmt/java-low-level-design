# Builder Pattern

## Intent
Builder is a creational design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.

## Understanding what problem Builder Pattern solves

#### Problem Overview:
- Constructing complex objects involves detailed initialization of many fields and nested objects.
- Traditional approaches may use:
    - Constructors with many parameters.
    - Subclassing for each object configuration.

#### Specific Challenges:
**Monstrous Constructors:** Initializing numerous fields will require Large constructors with many parameters, making code cumbersome.
**Scattered Initialization:** Alternatively, initialization might be spread across client code, leading to disorganization.
**Over-Subclassing:** Extensive subclassing for each object configuration, leads to a complex class hierarchy.

#### Example Scenario: Building a House
- **Building a House:** Requires constructing walls, floors, doors, windows, and a roof.
- **Variations:** Additional features (e.g., backyards, heating systems) demand new subclasses or more constructor parameters.

**Extensive Subclassing**:
[![Builder Pattern problem - Extensive subclassing](https://refactoring.guru/images/patterns/diagrams/builder/problem1.png "Builder Pattern problem 1")](https://refactoring.guru/design-patterns/builder "Builder Pattern problem 1")

**Large Constructors:**
[![Builder Pattern problem - Large constructors](https://refactoring.guru/images/patterns/diagrams/builder/problem2.png "Builder Pattern problem - Large constructors")](https://refactoring.guru/design-patterns/builder "Builder Pattern problem - Large constructors")

#### Builder Pattern Solution:

**Step-by-Step Construction:** Objects are built using a sequence of steps, improving manageability and readability.
**Separate Builders:** Construction code is moved to separate builder objects, each capable of constructing objects step by step.
**Selective Step Execution:** Only necessary steps are called to produce a specific configuration, avoiding the need for a telescoping constructor.
**Flexible Object Representation:** Different builders can implement construction steps in varied ways, allowing for the creation of diverse object representations without altering the client code.

#### How It Works:
**Organized Construction Steps:** The process is broken down into steps like buildWalls, buildDoor, etc.
**Customizable Builders:** Builders are created for different representations (e.g., wood and glass, stone and iron, gold and diamonds), each executing the same construction steps in different manners.
**Interacting Through Common Interface**: Clients interact with builders using a common interface, allowing flexibility and variation in the constructed objects without dependency on specific builder implementations.

[![Builder Pattern - Solution](https://refactoring.guru/images/patterns/diagrams/builder/solution1.png "Builder Pattern - Solution")](https://refactoring.guru/design-patterns/builder "Builder Pattern - Solution")


#### Key Benefit:
The Builder pattern effectively addresses the problem of constructing complex objects by simplifying the construction process, allowing for flexible configurations, and reducing the dependency on large constructors or excessive subclassing.

## The Role of the Director

The Director plays a crucial role in the Builder Pattern by managing the construction process of a product. It knows which Builder to use and how to use it to execute the building steps in a specific sequence. The Director ensures that the construction process is executed methodically to build a product that meets certain requirements or specifications.

#### Why the Director Might Not Be Used in Some Implementations

The Director is not strictly required for all Builder Pattern implementations. Its necessity depends on the complexity of the construction process and whether the construction logic should be encapsulated within a separate class.

In scenarios where the building process is straightforward or where clients need the flexibility to define their own construction sequence, directly interacting with the Builder might be preferred.

## Structure

[![Builder Pattern Structure](https://refactoring.guru/images/patterns/diagrams/builder/structure-indexed.png "Builder Pattern Structure")](https://refactoring.guru/design-patterns/builder "Builder Pattern Structure")

- **Builder**: Builder interface declares product construction steps that are common to all types of builders.
- **ConcreteBuilder**: Concrete Builders provide different implementations of the construction steps of Builder Interface. Concrete builders may produce products that don't follow the common interface.
- **Director**: The Director class defines the order in which to call construction steps, so you can create and reuse specific configurations of products.
- **Product**: Products are resulting objects. Products constructed by different builders don't have to belong to the same class hierarchy or interface.

## Example with Pseudocode
#### Constructing cars and their corresponding manuals
The Builder pattern's flexibility is showcased through an example of constructing cars and their corresponding manuals, highlighting how the pattern facilitates the creation of different product types using the same construction process.

#### Structure of the Builder Pattern Example:

[![Builder Pattern Example](https://refactoring.guru/images/patterns/diagrams/builder/example-en.png "Builder Pattern Example")](https://refactoring.guru/design-patterns/builder "Builder Pattern Example")

- **Complex Product Creation: **`Car`, with their complex configurations, illustrate the necessity of avoiding a constructor overloaded with parameters. Construction details are encapsulated in a dedicated `CarBuilder` class with methods for configuring parts of a car.

- **Direct or Directed Construction:**
    - **Direct Construction:** Clients may directly interact with the builder for custom car models.
    - **Directed Construction:** A `Director` class can automate the assembly using the builder for popular car models, simplifying the client code.

**Parallel Construction Process for Manuals:**

Every car model comes with a unique `Manual`, necessitating a similar but distinct construction process.
A separate `CarManualBuilder` class for manuals mirrors the car builder's steps but focuses on compiling information rather than assembling physical parts.

**Reusing Construction Logic:**

By employing builders for both cars and manuals under the same director, the construction process is streamlined, demonstrating the pattern's adaptability to different product types.

**Fetching the Constructed Product:**

The result of the construction process—be it a `car` or a `manual`—is retrieved directly from the `builder`, maintaining separation from the `director`. This approach avoids coupling the director to specific product classes.

## Implementation

1. **Define Common Construction Steps:** Identify and clearly define the steps required to construct all variations of the product (`Car` and `Manual`). These steps form the foundation of the Builder pattern implementation.

2. **Base Builder Interface:**
   Declare the identified construction steps within a base builder interface (`Builder`). This outlines the blueprint for building the product.

3. **Concrete Builder Classes:**
    - For each product variation, create a concrete builder class that implements the base builder interface. (`CarBuilder` and `CarManualBuilder` )
    - Implement the construction steps specific to the variation of the product being built by each concrete builder.

4. **Fetching the Construction Result:**
    - Implement a method (e.g. `getResult()`) in each concrete builder  ( `CarBuilder` and `CarManualBuilder` ) to retrieve the final product.
    - The retrieval method's return type may vary across builders if the products don’t share a common interface, making it impractical to declare this method in the base builder interface (`Builder`). However, if the products are part of the same hierarchy, this method can be included in the base interface.

5. **Director Class (Optional):**
   Consider creating a `Director` class that encapsulates different ways to construct the product using the same builder object. This class defines the sequence of building steps to construct a product.

6. **Client Code Responsibilities:**
    - Instantiate both the `Builder` and the `Director` objects.
    - Before construction begins, the client must provide the director with a builder object. This is often done through the director’s constructor.
    - The director then uses this builder for all construction activities. Alternatively, the builder might be passed to a construction method on the director for each build.

7. **Obtaining the Final Product:**
    - If all products implement a common interface, the final product can potentially be retrieved directly from the `Director`.
    - Otherwise, the client should obtain the construction result from the `Builder` after construction is complete.


## Advantages and Disadvantages

### Advantages
-  You can construct objects step-by-step, defer construction steps or run steps recursively.
-  You can reuse the same construction code when building various representations of products.
-  Single Responsibility Principle. You can isolate complex construction code from the business logic of the product.

### Disadvantages
-  The overall complexity of the code increases since the pattern requires creating multiple new classes.

## Real-world Applications

- **Text Converters**: Building different formats of documents, like RTF, HTML, or PDF, from a set of text data.
- **Meal Preparations**: Assembling different types of meals using the same process but with different ingredients and quantities.

#### Java
Builder is widely used in Java core libraries:
- java.lang.StringBuilder#append() (unsynchronized)
- java.lang.StringBuffer#append() (synchronized)

## Design Considerations

Implementing the Builder Pattern requires understanding the product's composition to effectively separate the construction process from its representation.

## Additional Implementations

- **Fluent Interface**: Enhancing the usability of the builder with chainable method calls.
- **Immutable Objects**: Using the builder pattern to ensure the constructed object is immutable.

## TODO
- Advanced java code example on Builder Method
  [Step-by-step car production builder pattern - Refactoring Guru](https://refactoring.guru/design-patterns/builder/java/example "Step-by-step car production builder pattern - Refactoring Guru")