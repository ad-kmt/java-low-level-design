package org.kmt.lld.design.patterns.behavorial.observer;
import java.util.EventListener;
import java.util.EventObject;
import java.util.ArrayList;
import java.util.List;



// Client code
public class ObserverPatternUsingEventListener {

    // StateChangeEvent class
    public static class StateChangeEvent extends EventObject {
        private int newState;

        public StateChangeEvent(Object source, int newState) {
            super(source);
            this.newState = newState;
        }

        public int getNewState() {
            return newState;
        }
    }

    // StateChangeListener interface
    public interface StateChangeListener extends EventListener {
        void stateChanged(StateChangeEvent event);
    }

    // Subject class
    public static class Subject {
        private List<StateChangeListener> listeners = new ArrayList<>();
        private int state;

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
            notifyListeners();
        }

        public void addStateChangeListener(StateChangeListener listener) {
            listeners.add(listener);
        }

        public void removeStateChangeListener(StateChangeListener listener) {
            listeners.remove(listener);
        }

        private void notifyListeners() {
            StateChangeEvent event = new StateChangeEvent(this, state);
            for (StateChangeListener listener : listeners) {
                listener.stateChanged(event);
            }
        }
    }

    // ConcreteObserver class
    public static class ConcreteObserver implements StateChangeListener {
        private String name;

        public ConcreteObserver(String name) {
            this.name = name;
        }

        @Override
        public void stateChanged(StateChangeEvent event) {
            System.out.println(name + ": State changed to " + event.getNewState());
        }
    }


    public static void main(String[] args) {
        Subject subject = new Subject();
        ConcreteObserver observer1 = new ConcreteObserver("Observer 1");
        ConcreteObserver observer2 = new ConcreteObserver("Observer 2");

        subject.addStateChangeListener(observer1);
        subject.addStateChangeListener(observer2);

        subject.setState(10);
        subject.setState(20);
    }
}

