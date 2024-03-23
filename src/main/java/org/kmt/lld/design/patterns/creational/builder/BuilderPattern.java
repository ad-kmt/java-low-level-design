package org.kmt.lld.design.patterns.creational.builder;



/**
 * The BuilderPatternDemo demonstrates the traditional use of the Builder design pattern
 * to construct a complex object (Car) step by step. This pattern is particularly useful
 * when an object needs to be created with many possible configurations, and its
 * construction process requires multiple steps that might not all be required for every
 * instance of the class.
 *
 * Components Used:
 * - Car: The complex object that is being built.
 * - CarBuilder: The builder interface that declares construction steps for the Car.
 * - SportsCarBuilder: A concrete builder that implements the CarBuilder interface
 *   and realizes the building steps for a specific type of Car.
 * - CarDirector: The director class that manages the construction process using a
 *   CarBuilder instance. It is optional and is used to encapsulate the order of
 *   construction steps.
 *
 * This demo showcases both the construction of a Car with and without the use of
 * a Director, illustrating the pattern's flexibility in managing complex object creation.
 */
public class BuilderPattern {
    public static void main(String[] args) {
        // Using Director
        CarBuilder builder = new SportsCarBuilder();
        CarDirector director = new CarDirector(builder);
        Car car = director.build();
        System.out.println(car);

        // Without using Director, direct build
        builder.buildEngine();
        builder.buildWheels();
        System.out.println(builder.getCar());
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
     * The Builder interface declares the construction steps that are required to build a product.
     */
    private interface CarBuilder {
        void buildEngine();
        void buildWheels();
        Car getCar();
    }

    /**
     * Concrete Builder implementation.
     * Constructs and assembles parts of the product by implementing the Builder interface.
     * The final product is retrieved via the getCar method.
     */
    private static class SportsCarBuilder implements CarBuilder {
        private Car car;

        public SportsCarBuilder() {
            this.car = new Car();
        }

        @Override
        public void buildEngine() {
            car.setEngine("V8");
        }

        @Override
        public void buildWheels() {
            car.setWheels(4);
        }

        @Override
        public Car getCar() {
            return car;
        }
    }

    /**
     * The Director class.
     * Responsible for managing the construction process for a product.
     * It works with a builder instance to ensure the product is built in the correct order of steps.
     */
    private static class CarDirector {
        private CarBuilder builder;

        public CarDirector(CarBuilder builder) {
            this.builder = builder;
        }

        /**
         * Constructs the car by executing a series of steps in order.
         * @return The fully constructed car.
         */
        public Car build() {
            builder.buildEngine();
            builder.buildWheels();
            return builder.getCar();
        }
    }
}

