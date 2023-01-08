package org.kmt.design_patterns.behavorial.observer;

public interface Publisher {
    public void register(Subscriber s);
    public void unregister(Subscriber s);
    public void notifySubscribers();
}
