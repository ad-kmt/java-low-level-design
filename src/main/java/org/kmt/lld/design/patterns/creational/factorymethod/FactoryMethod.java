package org.kmt.lld.design.patterns.creational.factorymethod;


/**
 * Demonstrates the Factory Method Design Pattern.
 *
 * Pattern Overview:
 * - The Factory Method pattern defines an interface for creating an object but lets subclasses decide which class to instantiate.
 *   This promotes loose coupling by allowing a class to defer instantiation to subclasses.
 *
 * Components:
 * - Creator: An interface declaring the factory method, which returns an object of type Product. This class also defines a default implementation of the factory method that returns a default Product object.
 * - ConcreteCreator: Subclasses of Creator that override the factory method to return an instance of a specific Product.
 * - Product: An interface for the type of objects the factory method will create.
 * - ConcreteProduct: Implements the Product interface, defining an object to be created by the corresponding ConcreteCreator.
 *
 * Key Benefits:
 * - Enhances flexibility and reusability by decoupling the creator and the concrete products.
 * - Simplifies code maintenance and extension by centralizing the creation logic in one place.
 * - Facilitates the introduction of new product types without changing existing client code.
 *
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Creator creator1 = new ConcreteCreatorA();
        Product product1 = creator1.factoryMethod();
        product1.use();

        Creator creator2 = new ConcreteCreatorB();
        Product product2 = creator2.factoryMethod();
        product2.use();
    }

    /**
     * Product interface.
     * Defines the operations that must be implemented by any concrete product.
     */
    interface Product {
        void use();
    }

    /**
     * ConcreteProductA class.
     * Implements the Product interface, providing specific behavior for ConcreteProductA.
     */
   private static class ConcreteProductA implements Product {
        @Override
        public void use() {
            System.out.println("Using ConcreteProductA");
        }
    }

    /**
     * ConcreteProductB class.
     * Implements the Product interface, providing specific behavior for ConcreteProductB.
     */
    private static class ConcreteProductB implements Product {
        @Override
        public void use() {
            System.out.println("Using ConcreteProductB");
        }
    }


    /**
     * Creator interface.
     * Declares the factory method, which returns an object of type Product.
     * The Creator may also provide a default implementation of the factory method.
     */
    private interface Creator {
        Product factoryMethod();
    }



    /**
     * ConcreteCreatorA class.
     * Overrides the factory method to return an instance of ConcreteProductA.
     */
    private static class ConcreteCreatorA implements Creator {
        @Override
        public Product factoryMethod() {
            return new ConcreteProductA();
        }
    }

    /**
     * ConcreteCreatorB class.
     * Overrides the factory method to return an instance of ConcreteProductB.
     */
    private static class ConcreteCreatorB implements Creator {
        @Override
        public Product factoryMethod() {
            return new ConcreteProductB();
        }
    }
}