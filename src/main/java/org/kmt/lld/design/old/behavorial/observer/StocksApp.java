package org.kmt.lld.design.old.behavorial.observer;

public class StocksApp {
    public static void main(String[] args) {
        StockPublisher stockPublisher = new StockPublisher();
        StockSubscriber stockSubscriber1 = new StockSubscriber(stockPublisher);
        stockPublisher.setIbmPrice(10);
        stockPublisher.setApplePrice(20);
        stockPublisher.setGooglePrice(30);

        StockSubscriber stockSubscriber2 = new StockSubscriber(stockPublisher);
        stockPublisher.setIbmPrice(15);
        stockPublisher.setApplePrice(25);
        stockPublisher.setGooglePrice(35);

        stockPublisher.unregister(stockSubscriber1);

        stockPublisher.setIbmPrice(10);
        stockPublisher.setApplePrice(20);
        stockPublisher.setGooglePrice(30);

        Runnable getIBM = new GetTheStockRunnable(stockPublisher, 2, "IBM", 197.00);

        Runnable getAAPL = new GetTheStockRunnable(stockPublisher, 2, "APPLE", 677.60);

        Runnable getGOOG = new GetTheStockRunnable(stockPublisher, 2, "GOOGLE", 676.40);

        new Thread(getIBM).start();
        new Thread(getAAPL).start();
        new Thread(getGOOG).start();

    }
}
