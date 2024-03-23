# Singleton Pattern

## Intent

The Singleton Pattern ensures that a class has only one instance and provides a global point of access to that instance.

## What problem it solves ?

- **Ensures that a class has just a single instance.**

    - Why would anyone want to control how many instances a class has? The most common reason for this is to control access to some shared resource—for example, a database or a file.

- **Provide a global access point to that instance.**

    - Remember those global variables that you (all right, me) used to store some essential objects? While they’re very handy, they’re also very unsafe since any code can potentially overwrite the contents of those variables and crash the app.
    - Just like a global variable, the Singleton pattern lets you access some object from anywhere in the program. However, it also protects that instance from being overwritten by other code.

## Applicability

- Use the Singleton pattern when a class in your program should have just a single instance available to all clients; for example, a single database object shared by different parts of the program.
-  Use the Singleton pattern when you need stricter control over global variables.

## Implementation

Implementing a Singleton involves:
1. Add a private static field to the class for storing the singleton instance.

2. Declare a public static creation method for getting the singleton instance.

3. Implement “lazy initialization” inside the static method. It should create a new object on its first call and put it into the static field. The method should always return that instance on all subsequent calls.

4. Make the constructor of the class private. The static method of the class will still be able to call the constructor, but not the other objects.

5. Go over the client code and replace all direct calls to the singleton’s constructor with calls to its static creation method.

## Structure

[![Singleton Pattern](https://refactoring.guru/images/patterns/diagrams/singleton/structure-en.png "Singleton Pattern")](https://refactoring.guru/design-patterns/singleton "Singleton Pattern")



## Advantages
- You can be sure that a class has only a single instance.
- You gain a global access point to that instance.
- Lazily initialized, meaning the instance is created only when it is needed.

## Disadvantages
- The pattern requires special treatment in a multithreaded environment so that multiple threads won’t create a singleton object several times.
-  It may be difficult to unit test the client code of the Singleton because many test frameworks rely on inheritance when producing mock objects. Since the constructor of the singleton class is private and overriding static methods is impossible in most languages, you will need to think of a creative way to mock the singleton.

## Design Considerations

When considering the Singleton pattern, it's essential to weigh its benefits against potential downsides. While it provides easy access to a shared resource, it can:
- Make unit testing difficult due to the global state.
- Lead to issues in a multithreaded context if not implemented with proper synchronization.
- Sometimes be used in scenarios where a global point of access is not genuinely required, leading to design inflexibility.


## Example in Java

The `Singleton` class demonstrates a thread-safe, lazily initialized Singleton pattern.

```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
        // private constructor
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

## Additional Implementations

Different Singleton implementations vary in their initialization time and manner of ensuring thread safety. These include:
- **Eager Initialization**: Instantiates the Singleton instance at class loading time, simple but may lead to resource wastage.
- **Static Block Initialization**: Similar to eager initialization, but provides more control over instance creation.
- **Thread Safe Singleton**: Ensures that only one instance is created even in multithreading environments, with a performance trade-off.
- **Bill Pugh Singleton Implementation**: Uses a static inner helper class to ensure thread safety without the need for synchronization on the getInstance() method.
- **Enum Singleton**: The simplest way to create a thread-safe singleton with serialization and thread-safety guarantees.

## Real-world Applications

Singletons find extensive use in various aspects of software design where a single instance of a class is necessary. Common applications include:
- **Configuration Managers**: Managing access to configuration settings throughout an application.
- **Logging**: Creating a single log file writer instance to write logs from an entire application.
- **Database Connections**: Managing a connection pool where multiple objects might request database connections.

