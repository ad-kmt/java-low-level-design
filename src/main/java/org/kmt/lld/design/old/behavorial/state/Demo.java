package org.kmt.lld.design.old.behavorial.state;

/**
 * Demo class. Everything comes together here.
 */
public class Demo {
    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer();
        UI ui = new UI(player);
        ui.init();
    }
}
