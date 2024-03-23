package org.kmt.lld.design.patterns.creational.factorymethod;

/**
 * Demonstrates the Static Factory Method Pattern.
 *
 * Pattern Overview:
 * The Static Factory Method Pattern is a variation of the Factory Method pattern that uses a static method
 * to create instances. This approach provides a flexible and efficient way to create objects without needing
 * to instantiate a factory object first. It's particularly useful when creating objects doesn't require any
 * additional state that would necessitate having a factory instance.
 *
 * Components:
 * - Product Interface: This defines the common interface for all products created by the factory. It ensures
 *   that all product types can be used interchangeably by the rest of the application.
 * - Concrete Products: These are specific implementations of the Product interface. Each represents a different
 *   type of product that can be created by the factory.
 * - Static Creator: A class that contains one or more static methods for creating Product instances. Each static
 *   method can create and return different types of Concrete Products.
 *
 * Key Concepts:
 * - Simplicity: By using static methods, this pattern simplifies object creation, making it easy to get instances
 *   of the needed products without dealing with the overhead of creating factory objects.
 * - Accessibility: Static factory methods are globally accessible, making it straightforward to obtain instances
 *   from anywhere in the application.
 * - Control over Instantiation: The pattern allows for controlling the instantiation process from a single
 *   location, which can be useful for implementing things like caching or ensuring that only a single instance
 *   of a particular product exists (similar to a Singleton).
 *
 */


public class StaticFactoryMethodDemo {
    public static void main(String[] args) {
        Product productA = StaticCreator.createProduct("A");
        productA.operate();

        Product productB = StaticCreator.createProduct("B");
        productB.operate();
    }

    /**
     * Product interface.
     * Defines the operations that must be implemented by any concrete product.
     */
    private interface Product {
        void operate();
    }

    /**
     * ConcreteProductA class.
     * Implements the Product interface, providing specific behavior for ConcreteProductA.
     */
    private static class ConcreteProductA implements Product {
        @Override
        public void operate() {
            System.out.println("Operating ConcreteProductA");
        }
    }

    /**
     * ConcreteProductB class.
     * Implements the Product interface, providing specific behavior for ConcreteProductB.
     */
    private static class ConcreteProductB implements Product {
        @Override
        public void operate() {
            System.out.println("Operating ConcreteProductB");
        }
    }

    private static class StaticCreator {
        /**
         * A static factory method that creates and returns instances of Product.
         *
         * @param type The type of product to create.
         * @return A new instance of a Product.
         */
        public static Product createProduct(String type) {
            switch (type) {
                case "A":
                    return new ConcreteProductA();
                case "B":
                    return new ConcreteProductB();
                default:
                    throw new IllegalArgumentException("Unknown product type");
            }
        }
    }
}
