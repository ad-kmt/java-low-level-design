package org.kmt.lld.design.patterns.creational.factory.solution;

import org.kmt.lld.design.patterns.creational.factory.EnemyShip;

import java.util.Scanner;

public class GameWithFactoryPattern {
    public static void main(String[] args) {

        EnemyShipFactory enemyShipFactory = new EnemyShipFactory();
        EnemyShip theEnemy = null;

        Scanner userInput = new Scanner(System.in);
        System.out.print("What type of ship? (U / R / B)");

        if (userInput.hasNextLine()){

            String typeOfShip = userInput.nextLine();
            theEnemy = enemyShipFactory.makeEnemyShip(typeOfShip);

            if(theEnemy != null){
                doStuffEnemy(theEnemy);
            } else System.out.print("Please enter U, R, or B next time");
        }
    }

    public static void doStuffEnemy(EnemyShip anEnemyShip){
        anEnemyShip.displayEnemyShip();
        anEnemyShip.followHeroShip();
        anEnemyShip.enemyShipShoots();
    }
}
