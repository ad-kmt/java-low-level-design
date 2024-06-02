package org.kmt.lld.design.old.behavorial.observer;

import java.util.ArrayList;

public class StockPublisher implements Publisher{

    ArrayList<Subscriber> subscribers;
    double ibmPrice;
    double applePrice;
    double googlePrice;

    StockPublisher(){
        subscribers = new ArrayList<>();
    }

    @Override
    public void register(Subscriber s) {
        subscribers.add(s);
    }

    @Override
    public void unregister(Subscriber s) {
        int subscriberIndex = subscribers.indexOf(s);
        subscribers.remove(subscriberIndex);
        System.out.println("Subscriber " + (subscriberIndex+1) + " deleted");
    }

    @Override
    public void notifySubscribers() {
        for(Subscriber s : subscribers){
            s.update(ibmPrice, applePrice, googlePrice);
        }
    }

    public void setIbmPrice(double ibmPrice) {
        this.ibmPrice = ibmPrice;
        notifySubscribers();
    }

    public void setApplePrice(double applePrice) {
        this.applePrice = applePrice;
        notifySubscribers();
    }

    public void setGooglePrice(double googlePrice) {
        this.googlePrice = googlePrice;
        notifySubscribers();
    }
}
