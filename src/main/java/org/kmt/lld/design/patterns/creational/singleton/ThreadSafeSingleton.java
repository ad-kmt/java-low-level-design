package org.kmt.lld.design.patterns.creational.singleton;

/**
 * The Singleton class demonstrates a thread-safe, lazily initialized Singleton pattern in Java.
 */
public class ThreadSafeSingleton {
    /**
     * The single instance of the Singleton class.
     * Declared volatile to ensure atomic access to the variable.
     */
    private static volatile ThreadSafeSingleton instance;

    /**
     * Private constructor to prevent instantiation from outside the class.
     */
    private ThreadSafeSingleton() {}

    /**
     * Returns the single instance of this class, creating it if necessary.
     * This method uses double-checked locking to ensure that only one instance of the Singleton class is created,
     * even when multiple threads are executing the method at the same time.
     *
     * @return The single instance of the Singleton class.
     */
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) { // Check 1: Avoid locking if instance is already initialized, improving performance.
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) { // Check 2: Ensures the instance is still not initialized by any other thread that might have acquired the lock in the meantime.
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    // Example method that can be called on the singleton instance
    public void someMethod() {
        System.out.println("Executing a method on the Singleton instance.");
    }
}