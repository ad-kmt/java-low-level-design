package org.kmt.lld.design.old.behavorial.observer;

import java.text.DecimalFormat;

public class GetTheStockRunnable implements Runnable {

    int startTime;
    String stock;
    double price;
    Publisher stockPublisher;

    GetTheStockRunnable(Publisher stockPublisher, int newStartTime, String newStock, double newPrice) {
        this.stockPublisher = stockPublisher;
        this.startTime = newStartTime;
        this.stock = newStock;
        this.price = newPrice;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignored) {}

            double randNum = (Math.random() * (.06)) - .03;
            DecimalFormat df = new DecimalFormat("#.##");
            price = Double.parseDouble(df.format((price + randNum)));
            if (stock.equals("IBM")) ((StockPublisher) stockPublisher).setIbmPrice(price);
            if (stock.equals("APPLE")) ((StockPublisher) stockPublisher).setApplePrice(price);
            if (stock.equals("GOOGLE")) ((StockPublisher) stockPublisher).setGooglePrice(price);
//
//            System.out.println(stock + ": " + df.format((price + randNum)) + " " + df.format(randNum));
//            System.out.println();
        }
    }
}
