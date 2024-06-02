package org.kmt.lld.design.patterns.behavorial.strategy;

/**
 * Strategy Design Pattern Example
 *
 * Problem:
 * You need to perform an operation in different ways depending on the context.
 * Using conditional statements to switch between different algorithms is not maintainable.
 *
 * Solution:
 * The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable.
 * This pattern lets the algorithm vary independently from clients that use it.
 *
 * Components:
 * - Strategy: An interface common to all supported algorithms. Context uses this interface to call the algorithm defined by a ConcreteStrategy.
 * - ConcreteStrategy: Implements the algorithm using the Strategy interface.
 * - Context: Maintains a reference to a Strategy object and is configured with a ConcreteStrategy object. It may define an interface that lets Strategy access its data.
 * - Client: Configures a Context with a ConcreteStrategy object.
 *
 * Where to Use:
 * Use the Strategy pattern when you have multiple algorithms for a specific task and want to switch between them dynamically.
 * This pattern is also useful when you want to avoid using conditional statements to choose the appropriate algorithm.
 */
public class StrategyPattern {

    // Strategy interface defining a common interface for all strategies
    public interface Strategy {
        void execute();
    }

    // ConcreteStrategyA class implementing the Strategy interface with a specific algorithm
    public static class ConcreteStrategyA implements Strategy {
        @Override
        public void execute() {
            // Implement algorithm A
            System.out.println("Executing strategy A");
        }
    }

    // ConcreteStrategyB class implementing the Strategy interface with a specific algorithm
    public static class ConcreteStrategyB implements Strategy {
        @Override
        public void execute() {
            // Implement algorithm B
            System.out.println("Executing strategy B");
        }
    }

    // Context class that maintains a reference to a Strategy object and is configured with a ConcreteStrategy object
    public static class Context {
        private Strategy strategy;

        // Set a strategy
        public void setStrategy(Strategy strategy) {
            this.strategy = strategy;
        }

        // Execute the strategy
        public void executeStrategy() {
            strategy.execute(); // Delegate the execution to the strategy
        }
    }

    // Client code that configures a Context with a ConcreteStrategy object
    public static void main(String[] args) {
        Context context = new Context();

        // Use ConcreteStrategyA
        context.setStrategy(new ConcreteStrategyA());
        context.executeStrategy(); // Outputs: Executing strategy A

        // Use ConcreteStrategyB
        context.setStrategy(new ConcreteStrategyB());
        context.executeStrategy(); // Outputs: Executing strategy B
    }
}

