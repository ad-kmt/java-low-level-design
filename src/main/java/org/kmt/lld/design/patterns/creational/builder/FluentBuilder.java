package org.kmt.lld.design.patterns.creational.builder;



/**
 * The FluentBuilderDemo showcases the Builder design pattern implemented with a
 * Fluent Interface, enhancing readability and ease of use. By enabling method chaining,
 * the construction process of complex objects becomes more intuitive and expressive.
 *
 * Pattern Overview:
 * - The Builder pattern with a Fluent Interface still aims to separate the construction
 *   of a complex object from its representation but does so in a way that each builder
 *   method returns the builder instance itself. This allows for chaining method calls
 *   in a single expression, making the code more streamlined and easier to understand.
 *
 * Components Used:
 * - Car: The product, representing the complex object being constructed.
 * - CarBuilder: The builder interface with methods designed for fluent chaining,
 *   declaring the necessary steps to construct a Car instance.
 * - SportsCarBuilder: A concrete implementation of the CarBuilder, which realizes
 *   the construction steps for a Car. It returns itself in each step, enabling the
 *   fluent interface.
 *
 * This demo illustrates how a Car object can be built using a fluent builder,
 * demonstrating the improved readability and succinctness of using method chaining
 * in the Builder pattern.
 */
public class FluentBuilder {
    public static void main(String[] args) {
        // Building a car with method chaining
        CarBuilder builder = new SportsCarBuilder();
        Car car = builder
                    .buildEngine("V8")
                    .buildWheels(4)
                    .getCar();
        System.out.println(car);
    }

    /**
     * Represents the product class in the Builder pattern.
     * This class is a complex object that is to be constructed by the Builder.
     */
    private static class Car {
        private String engine;
        private int wheels;

        public void setEngine(String engine) {
            this.engine = engine;
        }

        public void setWheels(int wheels) {
            this.wheels = wheels;
        }

        @Override
        public String toString() {
            return "Car with engine: " + engine + " and wheels: " + wheels;
        }
    }

    /**
     * The Builder interface with Fluent Interface support. Declares the construction
     * steps that are required to build a product, with each method returning the Builder instance.
     */
    private interface CarBuilder {
        CarBuilder buildEngine(String engine);
        CarBuilder buildWheels(int wheels);
        Car getCar();
    }

    /**
     * Concrete Builder implementation.
     * Constructs and assembles parts of the product by implementing the Builder interface
     * with Fluent Interface support for method chaining.
     */
    private static class SportsCarBuilder implements CarBuilder {
        private Car car;

        public SportsCarBuilder() {
            this.car = new Car();
        }

        @Override
        public CarBuilder buildEngine(String engine) {
            car.setEngine(engine);
            return this; // Returning the builder itself for chaining
        }

        @Override
        public CarBuilder buildWheels(int wheels) {
            car.setWheels(wheels);
            return this; // Returning the builder itself for chaining
        }

        @Override
        public Car getCar() {
            return car;
        }
    }
}

