package org.kmt.lld.design.patterns.creational.singleton;

import static org.kmt.lld.design.patterns.creational.singleton.EnumSingleton.INSTANCE;

/**
 * Static block initialization for Singleton pattern.
 * Similar to eager initialization, except that instance of Singleton class is created in the static block.
 * This provides the option to handle exceptions.
 */
public class StaticBlockSingleton {
    private static final StaticBlockSingleton instance;

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    // Private constructor to prevent instantiation
    private StaticBlockSingleton() {}

    // Method to return the instance of the class
    public static StaticBlockSingleton getInstance() {
        return instance;
    }

    // Example method that can be called on the singleton instance
    public void someMethod() {
        System.out.println("Executing a method on the StaticBlockSingleton instance.");
    }
}
