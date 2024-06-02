package org.kmt.lld.design.patterns.behavorial.state;

/**
 * State Pattern with Enum
 *
 * This implementation uses enums to represent states, simplifying the implementation by avoiding the need to create
 * separate classes for each state.
 */

public class StatePatternEnum {

    /**
     * State enum
     *
     * Defines the states and encapsulates the behavior associated with each state.
     */
    public enum State {
        STATE_A {
            @Override
            void handle(Context context) {
                // Concrete behavior for state A
                System.out.println("State A: Handling request.");
                context.setState(STATE_B);
            }
        },
        STATE_B {
            @Override
            void handle(Context context) {
                // Concrete behavior for state B
                System.out.println("State B: Handling request.");
                context.setState(STATE_A);
            }
        };

        abstract void handle(Context context);
    }

    /**
     * Context class
     *
     * Maintains an instance of an enum that defines the current state.
     * This class allows the state to be changed at runtime.
     */
    public static class Context {
        private State state;

        public Context() {
            state = State.STATE_A;
        }

        public void setState(State state) {
            this.state = state;
        }

        public void request() {
            state.handle(this);
        }
    }

    public static void main(String[] args) {
        // Create a context object
        Context context = new Context();

        // Request to change state multiple times
        context.request(); // Transition from STATE_A to STATE_B
        context.request(); // Transition from STATE_B to STATE_A
        context.request(); // Transition from STATE_A to STATE_B
        context.request(); // Transition from STATE_B to STATE_A
    }
}

