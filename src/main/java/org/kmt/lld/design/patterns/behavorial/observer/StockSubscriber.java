package org.kmt.lld.design.patterns.behavorial.observer;

public class StockSubscriber implements Subscriber{

    double ibmPrice;
    double applePrice;
    double googlePrice;

    private static int observerIdTracker = 0;
    private int observerId;
    private Publisher stockPublisher;

    public StockSubscriber(Publisher stockPublisher){
        this.stockPublisher = stockPublisher;
        this.observerId = ++observerIdTracker;
        System.out.println("New Observer: " + observerId);
        stockPublisher.register(this);
    }
    @Override
    public void update(double ibmPrice, double applePrice, double googlePrice) {
        this.ibmPrice = ibmPrice;
        this.applePrice = applePrice;
        this.googlePrice = googlePrice;
        printStockPrices();
    }

    public void printStockPrices(){
        System.out.println("ObserverId: " + observerId + "\nibm: " + ibmPrice + "\napple: " + applePrice + "\ngoogle: " + googlePrice + "\n");
    }
}
