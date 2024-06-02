package org.kmt.lld.design.patterns.behavorial.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// Client code
public class ObserverPatternUsingPropertyChangeListener {

    // Subject class
    public static class Subject {
        private int state;
        private PropertyChangeSupport support;

        public Subject() {
            support = new PropertyChangeSupport(this);
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            int oldState = this.state;
            this.state = state;
            support.firePropertyChange("state", oldState, state);
        }

        public void addPropertyChangeListener(PropertyChangeListener pcl) {
            support.addPropertyChangeListener(pcl);
        }

        public void removePropertyChangeListener(PropertyChangeListener pcl) {
            support.removePropertyChangeListener(pcl);
        }
    }

    // ConcreteObserver class
    public static class ConcreteObserver implements PropertyChangeListener {
        private String name;

        public ConcreteObserver(String name) {
            this.name = name;
        }

        @Override
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            System.out.println(name + ": State changed from " + evt.getOldValue() + " to " + evt.getNewValue());
        }
    }


    public static void main(String[] args) {
        Subject subject = new Subject();
        ConcreteObserver observer1 = new ConcreteObserver("Observer 1");
        ConcreteObserver observer2 = new ConcreteObserver("Observer 2");

        subject.addPropertyChangeListener(observer1);
        subject.addPropertyChangeListener(observer2);

        subject.setState(10);
        subject.setState(20);
    }
}
