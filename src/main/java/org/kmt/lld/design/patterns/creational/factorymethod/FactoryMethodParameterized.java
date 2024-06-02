package org.kmt.lld.design.patterns.creational.factorymethod;

/**
 * Demonstrates the Parameterized Factory Method Pattern.
 *
 * Pattern Overview:
 * The Parameterized Factory Method Pattern extends the basic Factory Method pattern by allowing the creation
 * of objects to be parameterized. Instead of having multiple factory methods or factory classes to create
 * different types of objects, a single method can decide what object to instantiate based on a parameter.
 *
 * Components:
 * - Product Interface: Defines the contract for the products that the factory will create. All products
 *   must implement this interface.
 * - Concrete Products: Implementations of the Product interface. These are the actual objects that the
 *   factory method will create.
 * - Creator: Contains the parameterized factory method. It uses the parameter to decide which concrete
 *   product to instantiate and return.
 *
 */
public class FactoryMethodParameterized {
    public static void main(String[] args) {
        ParameterizedCreator creator = new ParameterizedCreator();
        Product productA = creator.createProduct("A");
        productA.operate();

        Product productB = creator.createProduct("B");
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

    private static class ParameterizedCreator {
        /**
         * The parameterized factory method allows creating different types of products
         * based on the provided parameter.
         *
         * @param type The type of product to create.
         * @return A new Product instance.
         */
        public Product createProduct(String type) {
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

