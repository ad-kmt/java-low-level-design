package org.kmt.lld.design.patterns.behavorial.strategy;

/**
 * Strategy Pattern using Java Enum
 *
 * This variation uses Java Enums to implement the Strategy pattern, where each enum constant represents a strategy.
 */
public class StrategyPatternEnum {

    /**
     * Strategy enum
     *
     * Defines the strategies as enum constants with their corresponding algorithm implementations.
     */
    public enum Strategy {
        ADD {
            @Override
            public void execute(int a, int b) {
                System.out.println("Enum Strategy: Result of addition is " + (a + b));
            }
        },
        SUBTRACT {
            @Override
            public void execute(int a, int b) {
                System.out.println("Enum Strategy: Result of subtraction is " + (a - b));
            }
        };

        public abstract void execute(int a, int b);
    }

    /**
     * Context class
     *
     * Maintains a reference to a Strategy enum and uses it to execute the algorithm with parameters.
     */
    public static class Context {
        private Strategy strategy;

        public Context(Strategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(Strategy strategy) {
            this.strategy = strategy;
        }

        public void executeStrategy(int a, int b) {
            strategy.execute(a, b);
        }
    }

    public static void main(String[] args) {
        // Create context with Strategy.ADD
        Context context = new Context(Strategy.ADD);
        context.executeStrategy(5, 3); // Output: Result of addition is 8

        // Change strategy to Strategy.SUBTRACT
        context.setStrategy(Strategy.SUBTRACT);
        context.executeStrategy(5, 3); // Output: Result of subtraction is 2
    }
}

