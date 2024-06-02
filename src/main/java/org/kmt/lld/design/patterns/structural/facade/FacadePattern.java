package org.kmt.lld.design.patterns.structural.facade;

/**
 * Facade Design Pattern
 *
 * Problem:
 * A complex system requires multiple classes and configurations to perform an operation.
 * Using these classes directly in the client code would make it tightly coupled and difficult to maintain.
 *
 * Solution:
 * The Facade pattern provides a simplified interface to this complex subsystem.
 * It defines a higher-level interface that makes the subsystem easier to use.
 *
 * Where to Use:
 * Use the Facade pattern when you need to simplify interaction with a complex subsystem.
 * This pattern is useful when you want to provide a simple interface to a complex set of classes.
 *
 * Components:
 * - Facade: Provides a simple method to interact with the subsystem.
 * - Subsystem classes: Complex components that perform the actual work.
 * - Client: Uses the Facade instead of directly interacting with the subsystem.
 */

// Client code that uses the Facade to interact with the subsystem
public class FacadePattern {
    public static void main(String[] args) {
        // Client uses the Facade
        FacadeInterface facade = new FacadeImpl();
        facade.simpleOperation(); // Facade simplifies the interaction with the subsystem
    }
}

// Subsystem class that performs a specific operation
class ServiceA {
    public void operationA() {
        System.out.println("ClassA: Operation A");
    }
}

// Subsystem class that performs a specific operation
class ServiceB {
    public void operationB() {
        System.out.println("ClassB: Operation B");
    }
}

// Subsystem class that performs a specific operation
class ServiceC {
    public void operationC() {
        System.out.println("ClassC: Operation C");
    }
}

// Facade interface that defines the simple operation method
interface FacadeInterface {
    void simpleOperation();
}

// Implementation of the Facade interface
class FacadeImpl implements FacadeInterface {
    private ServiceA serviceA;
    private ServiceB serviceB;
    private ServiceC serviceC;

    public FacadeImpl() {
        // Initializing subsystem classes
        serviceA = new ServiceA();
        serviceB = new ServiceB();
        serviceC = new ServiceC();
    }

    @Override
    public void simpleOperation() {
        System.out.println("Facade: Starting operation...");

        // Delegate calls to subsystem classes
        serviceA.operationA(); // Call to ServiceA
        serviceB.operationB(); // Call to ServiceB
        serviceC.operationC(); // Call to ServiceC

        System.out.println("Facade: Operation completed.");
    }
}
