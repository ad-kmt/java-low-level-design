package org.kmt.lld.design.patterns.behavorial.state;

/**
 * State Design Pattern Example
 *
 * Problem:
 * In some cases, an object's behavior depends on its state, and it must change its behavior at runtime based on that state.
 * Traditional implementation using conditional statements (if-else or switch) to handle state-specific behavior can lead
 * to code that is difficult to maintain and extend. This approach also results in tight coupling between the state-specific
 * behavior and the object itself.
 *
 * Solution:
 * The State pattern allows an object to alter its behavior when its internal state changes by encapsulating state-specific
 * behavior into separate state classes. The Context class maintains an instance of a ConcreteState subclass that defines
 * the current state. This design decouples the behavior from the context, making it easier to add new states or change
 * existing ones without modifying the Context class. The object appears to change its class as it transitions from one
 * state to another, providing a flexible and maintainable way to handle state-specific behavior.
 *
 * This is the standard implementation where the state-specific behavior is encapsulated in separate state classes,
 * and the context maintains a reference to the current state.
 *
 * Components:
 * - Context: Maintains an instance of a ConcreteState subclass that defines the current state.
 * - State: Interface for encapsulating the behavior associated with a particular state of the Context.
 * - ConcreteState: Subclasses that implement the behavior associated with a state of the Context.
 *
 * Where to Use:
 * - When an object's behavior depends on its state, and it must change behavior at runtime depending on that state.
 * - When operations have large, multipart conditional statements that depend on the object's state.
 */
public class StatePattern {


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
     * This class represents the first state.
     */
    public static class ConcreteStateA implements State {
        @Override
        public void handle(Context context) {
            // Concrete behavior for state A
            System.out.println("ConcreteStateA: Handling request.");

            // Transition to another state (ConcreteStateB)
            context.setState(new ConcreteStateB());
        }
    }

    /**
     * ConcreteStateB class
     *
     * Implements behavior associated with a particular state of the Context.
     * This class represents the second state.
     */
    public static class ConcreteStateB implements State {
        @Override
        public void handle(Context context) {
            // Concrete behavior for state B
            System.out.println("ConcreteStateB: Handling request.");

            // Transition to another state (ConcreteStateA)
            context.setState(new ConcreteStateA());
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
            this.currentState = new ConcreteStateA();
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

    /**
     *
     * Client code that uses the Context to change states and trigger behavior.
     */
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

