package org.kmt.lld.design.patterns.behavorial.strategy;

/**
 * Strategy Pattern using Java 8 Functional Interfaces
 *
 * This variation uses Java 8's functional interfaces and lambda expressions to simplify the Strategy pattern implementation.
 */
public class StrategyPatternFunctionalInterface {

    /**
     * Strategy interface
     *
     * Defines the interface for the algorithm using a functional interface.
     */
    @FunctionalInterface
    public interface Strategy {
        void execute();
    }

    /**
     * Context class
     *
     * Maintains a reference to a Strategy object and uses it to execute the algorithm.
     */
    public static class Context {
        private Strategy strategy;

        public Context(Strategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(Strategy strategy) {
            this.strategy = strategy;
        }

        public void executeStrategy() {
            strategy.execute();
        }
    }

    public static void main(String[] args) {
        // Create context with a lambda expression for ConcreteStrategyA
        Context context = new Context(() -> System.out.println("Lambda Strategy: Executing algorithm A."));
        context.executeStrategy(); // Output: Executing algorithm A

        // Change strategy to another lambda expression for ConcreteStrategyB
        context.setStrategy(() -> System.out.println("Lambda Strategy: Executing algorithm B."));
        context.executeStrategy(); // Output: Executing algorithm B
    }
}

