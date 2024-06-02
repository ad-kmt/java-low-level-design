package org.kmt.lld.design.patterns.behavorial.observer;

import java.util.*;

/**
 * Observer Design Pattern Example
 *
 * Problem:
 * The Observer design pattern defines a one-to-many dependency between objects so that when one object changes state,
 * all its dependents are notified and updated automatically. This is useful when you need to notify multiple objects
 * about changes in another object without tightly coupling them.
 *
 * Solution:
 * The Observer pattern provides a way to attach multiple observers to a subject. When the subject's state changes,
 * all attached observers are notified and updated automatically.
 *
 * Components:
 * - Publisher: The object that maintains a list of subscribers and sends notifications to them when its state changes.
 * - Subscriber: The interface that defines the update method, which is called by the publisher to notify the subscribers
 *   of any state changes.
 * - ConcretePublisher: A concrete implementation of the Publisher, maintaining its own state and notifying subscribers
 *   when the state changes.
 * - ConcreteSubscriber: A concrete implementation of the Subscriber, updating its state to match that of the publisher
 *   when notified.
 *
 * Where to Use:
 * - Use the Observer pattern when changes to one object require changes to others, and you don’t know how many objects
 *   need to be changed.
 * - Use it when an object should be able to notify other objects without making assumptions about who those objects are.
 */

// Subscriber interface
interface Subscriber {
    void update(String state);
}

/**
 * ConcreteSubscriber class
 *
 * Implements the Subscriber interface and updates its state to match the Publisher's state when notified.
 */
class ConcreteSubscriber implements Subscriber {
    private String subscriberState;

    @Override
    public void update(String state) {
        // Update the subscriber's state to match the publisher's state
        this.subscriberState = state;
        System.out.println("Subscriber state updated to: " + subscriberState);
    }
}

// Publisher interface
interface Publisher {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers();
    String getState();
    void setState(String state);
}

/**
 * ConcretePublisher class
 *
 * Implements the Publisher interface, maintaining its own state and notifying subscribers when the state changes.
 */
class ConcretePublisher implements Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String state;

    @Override
    public void subscribe(Subscriber subscriber) {
        // Add a subscriber to the list
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        // Remove a subscriber from the list
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        // Notify all subscribers of the state change
        for (Subscriber subscriber : subscribers) {
            subscriber.update(state);
        }
    }

    @Override
    public String getState() {
        // Return the publisher's state
        return state;
    }

    @Override
    public void setState(String state) {
        // Set the publisher's state and notify subscribers
        this.state = state;
        notifySubscribers(); // Notify subscribers when state changes
    }
}

// Client code
public class ObserverPattern {
    public static void main(String[] args) {
        // Create a concrete publisher
        ConcretePublisher publisher = new ConcretePublisher();

        // Create and subscribe subscribers
        Subscriber subscriber1 = new ConcreteSubscriber();
        Subscriber subscriber2 = new ConcreteSubscriber();
        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);

        // Change the publisher's state
        publisher.setState("State 1"); // Notify subscribers of the state change

        // Change the publisher's state again
        publisher.setState("State 2"); // Notify subscribers of the state change
    }
}

