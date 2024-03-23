package org.kmt.lld.design.patterns.creational.singleton;

/**
 * EnumSingleton demonstrates a Singleton pattern using an enum in Java.
 *
 * Benefits:
 * - Thread-safe by default.
 * - Serialization is guaranteed by the JVM.
 * - Protection against reflection attacks.
 *
 * Usage:
 * EnumSingleton.INSTANCE.doSomething();
 */
public enum EnumSingleton {
    INSTANCE;

    // Instance variable example
    private int value;

    // Example method to demonstrate usage of the singleton
    public void doSomething() {
        System.out.println("Doing something with value: " + value);
    }

    // Example method to set the instance variable
    public void setValue(int value) {
        this.value = value;
    }

    // Example method to get the instance variable
    public int getValue() {
        return this.value;
    }
}