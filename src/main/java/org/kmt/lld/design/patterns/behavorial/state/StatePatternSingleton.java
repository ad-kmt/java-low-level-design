package org.kmt.lld.design.patterns.behavorial.state;

/**
 * State Pattern with Singleton States
 *
 * This implementation uses singleton instances for state objects to avoid creating multiple instances of state objects.
 */

public class StatePatternSingleton {

    /**
     * State interface
     *
     * Defines the interface for encapsulating the behavior associated with a particular state of the Context.
     */
    public interface State {
        void handle(Context context);
    }

    /**
     * ConcreteStateA class
     *
     * Implements behavior associated with a particular state of the Context.
     * This class represents the first state and uses a singleton instance.
     */
    public static class ConcreteStateA implements State {
        private static final ConcreteStateA instance = new ConcreteStateA();

        private ConcreteStateA() {}

        public static ConcreteStateA getInstance() {
            return instance;
        }

        @Override
        public void handle(Context context) {
            // Concrete behavior for state A
            System.out.println("ConcreteStateA: Handling request.");

            // Transition to another state (ConcreteStateB)
            context.setState(ConcreteStateB.getInstance());
        }
    }

    /**
     * ConcreteStateB class
     *
     * Implements behavior associated with a particular state of the Context.
     * This class represents the second state and uses a singleton instance.
     */
    public static class ConcreteStateB implements State {
        private static final ConcreteStateB instance = new ConcreteStateB();

        private ConcreteStateB() {}

        public static ConcreteStateB getInstance() {
            return instance;
        }

        @Override
        public void handle(Context context) {
            // Concrete behavior for state B
            System.out.println("ConcreteStateB: Handling request.");

            // Transition to another state (ConcreteStateA)
            context.setState(ConcreteStateA.getInstance());
        }
    }

    /**
     * Context class
     *
     * Maintains an instance of a ConcreteState subclass that defines the current state.
     * This class allows the state to be changed at runtime.
     */
    public static class Context {
        private State currentState;

        public Context() {
            // Initialize the context with an initial state
            this.currentState = ConcreteStateA.getInstance();
        }

        public void setState(State state) {
            // Set the current state
            this.currentState = state;
        }

        public void request() {
            // Delegate the request to the current state
            currentState.handle(this);
        }
    }

    public static void main(String[] args) {
        // Create a context object
        Context context = new Context();

        // Request to change state multiple times
        context.request(); // Transition from ConcreteStateA to ConcreteStateB
        context.request(); // Transition from ConcreteStateB to ConcreteStateA
        context.request(); // Transition from ConcreteStateA to ConcreteStateB
        context.request(); // Transition from ConcreteStateB to ConcreteStateA
    }
}
