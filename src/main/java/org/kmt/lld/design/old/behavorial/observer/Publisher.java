package org.kmt.lld.design.old.behavorial.observer;

public interface Publisher {
    public void register(Subscriber s);
    public void unregister(Subscriber s);
    public void notifySubscribers();
}
