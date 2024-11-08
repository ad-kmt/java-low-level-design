package org.kmt.lld.design.old.creational.singleton.threads;

import org.kmt.lld.design.old.creational.singleton.Singleton;

import java.util.LinkedList;

public class GetTheTiles implements Runnable {
    @Override
    public void run() {
        // How you create a new instance of Singleton
        Singleton newInstance = Singleton.getInstance();

        // Get unique id for instance object
        System.out.println("Instance ID: " + System.identityHashCode(newInstance));

        // Get all of the letters stored in the List
        System.out.println(newInstance.getLetterList());

        LinkedList<String> playerOneTiles = newInstance.getTiles(7);

        System.out.println("Player: " + playerOneTiles);
        System.out.println("Got Tiles");
    }
}
