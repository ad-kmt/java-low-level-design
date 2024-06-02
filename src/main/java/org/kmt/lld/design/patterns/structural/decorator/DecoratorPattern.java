package org.kmt.lld.design.patterns.structural.decorator;

/**
 * Decorator Design Pattern Example
 *
 * The Decorator design pattern allows behavior to be added to individual objects, dynamically, without affecting the
 * behavior of other objects from the same class.
 *
 * Components:
 * - Component: Interface for objects that can have responsibilities added to them dynamically.
 * - ConcreteComponent: The core object that has responsibilities added to it.
 * - Decorator: Abstract class that implements the Component interface and contains a reference to a Component object.
 * - ConcreteDecorator: Concrete class that extends the Decorator and adds responsibilities to the Component.
 * - Client: Uses the Decorator pattern to add responsibilities to the Component.
 *
 * Inheritance vs. Composition:
 * Extending a class is the first thing that comes to mind when you need to alter an object’s behavior. However, inheritance has several serious caveats:
 * - Inheritance is static. You can’t alter the behavior of an existing object at runtime. You can only replace the whole object with another one that’s created from a different subclass.
 * - Subclasses can have just one parent class. Inheritance doesn’t let a class inherit behaviors of multiple classes at the same time.
 *
 * One of the ways to overcome these caveats is by using Aggregation or Composition instead of Inheritance. Both alternatives work almost the same way:
 * one object has a reference to another and delegates it some work, whereas with inheritance, the object itself is able to do that work, inheriting the behavior from its superclass.
 *
 * With this new approach, you can easily substitute the linked “helper” object with another, changing the behavior of the container at runtime.
 * An object can use the behavior of various classes, having references to multiple objects and delegating them all kinds of work.
 * Aggregation/composition is the key principle behind many design patterns, including Decorator.
 */

// Component interface
interface Component {
    void operation();
}

// ConcreteComponent class
class ConcreteComponent implements Component {
    @Override
    public void operation() {
        // Core functionality
        System.out.println("ConcreteComponent: Performing operation");
    }
}

// Decorator abstract class
abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        // Delegating the operation to the wrapped component
        component.operation();
    }
}

// ConcreteDecoratorA class
class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation(); // Calling the wrapped component's operation
        addedBehavior();   // Adding new behavior
    }

    private void addedBehavior() {
        // Additional behavior
        System.out.println("ConcreteDecoratorA: Adding behavior A");
    }
}

// ConcreteDecoratorB class
class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation(); // Calling the wrapped component's operation
        addedBehavior();   // Adding new behavior
    }

    private void addedBehavior() {
        // Additional behavior
        System.out.println("ConcreteDecoratorB: Adding behavior B");
    }
}

// Client code
public class DecoratorPattern {
    public static void main(String[] args) {
        // Creating a core component
        Component component = new ConcreteComponent();

        // Decorating the component with ConcreteDecoratorA
        component = new ConcreteDecoratorA(component);

        // Further decorating the component with ConcreteDecoratorB
        component = new ConcreteDecoratorB(component);

        // The client calls the operation method, which now includes additional behaviors
        component.operation(); // Output includes core functionality and added behaviors from decorators
    }
}

