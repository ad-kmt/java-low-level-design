package org.kmt.lld.design.patterns.creational.singleton;

/**
 * Eager initialization of Singleton pattern.
 * The instance is created at the time of class loading. This method doesn't require synchronization and
 * is simple, but it has a drawback: the instance is created even though the client application might not use it.
 */
public class EagerSingleton {
    // Instance of Singleton Class is created at the time of class loading.
    private static final EagerSingleton instance = new EagerSingleton();

    // Private constructor to prevent instantiation
    private EagerSingleton() {}

    // Method to return the instance of the class
    public static EagerSingleton getInstance() {
        return instance;
    }

    // Example method that can be called on the singleton instance
    public void someMethod() {
        System.out.println("Executing a method on the EagerSingleton instance.");
    }
}