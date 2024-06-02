package org.kmt.lld.design.patterns.creational.factorymethod;

/**
 * Factory Method Pattern Example
 *
 * Variation: Factory Method with Enum
 *
 * This variation uses a factory method that utilizes an enum to decide which specific object to create.
 */

// Parent class containing all static classes for organization
public class FactoryMethodWithEnum {

    /**
     * Product interface
     *
     * Defines the interface for the objects the factory method creates.
     */
    public interface Product {
        void use();
    }

    /**
     * ConcreteProductA class
     *
     * Implements the Product interface and defines the behavior of the product.
     */
    public static class ConcreteProductA implements Product {
        @Override
        public void use() {
            // Specific implementation for ConcreteProductA
            System.out.println("Using ConcreteProductA.");
        }
    }

    /**
     * ConcreteProductB class
     *
     * Implements the Product interface and defines the behavior of the product.
     */
    public static class ConcreteProductB implements Product {
        @Override
        public void use() {
            // Specific implementation for ConcreteProductB
            System.out.println("Using ConcreteProductB.");
        }
    }

    /**
     * ProductType enum
     *
     * Defines the types of products that can be created.
     */
    public enum ProductType {
        TYPE_A, TYPE_B
    }

    /**
     * Creator class
     *
     * Declares the factory method that returns an object of type Product based on an enum.
     */
    public static class Creator {
        public Product factoryMethod(ProductType type) {
            switch (type) {
                case TYPE_A:
                    return new ConcreteProductA(); // Creates and returns ConcreteProductA
                case TYPE_B:
                    return new ConcreteProductB(); // Creates and returns ConcreteProductB
                default:
                    return null;
            }
        }
    }

    /**
     * Demo class
     *
     * Demonstrates the usage of the factory method pattern with enum.
     */
    public static class Demo {
        public static void main(String[] args) {
            Creator creator = new Creator();
            Product productA = creator.factoryMethod(ProductType.TYPE_A);
            if (productA != null) {
                productA.use(); // Uses ConcreteProductA
            }

            Product productB = creator.factoryMethod(ProductType.TYPE_B);
            if (productB != null) {
                productB.use(); // Uses ConcreteProductB
            }
        }
    }
}

