package org.kmt.lld.design.patterns.behavorial.strategy;

import java.util.function.BiConsumer;

/**
 * Strategy Pattern using java.util.function Package
 *
 * This variation uses Java's `java.util.function.BiConsumer` to implement the Strategy pattern.
 */
public class StrategyPatternFunction {

    /**
     * Context class
     *
     * Maintains a reference to a BiConsumer strategy and uses it to execute the algorithm with parameters.
     */
    public static class Context {
        private BiConsumer<Integer, Integer> strategy;

        public Context(BiConsumer<Integer, Integer> strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(BiConsumer<Integer, Integer> strategy) {
            this.strategy = strategy;
        }

        public void executeStrategy(int a, int b) {
            strategy.accept(a, b);
        }
    }

    public static void main(String[] args) {
        // Create context with a BiConsumer for addition
        Context context = new Context((a, b) -> System.out.println("Function Strategy: Result of addition is " + (a + b)));
        context.executeStrategy(5, 3); // Output: Result of addition is 8

        // Change strategy to a BiConsumer for subtraction
        context.setStrategy((a, b) -> System.out.println("Function Strategy: Result of subtraction is " + (a - b)));
        context.executeStrategy(5, 3); // Output: Result of subtraction is 2
    }
}

