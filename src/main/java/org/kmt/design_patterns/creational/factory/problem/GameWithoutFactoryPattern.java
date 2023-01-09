package org.kmt.design_patterns.creational.factory.problem;

import org.kmt.design_patterns.creational.factory.BigUFOEnemyShip;
import org.kmt.design_patterns.creational.factory.EnemyShip;
import org.kmt.design_patterns.creational.factory.RocketEnemyShip;
import org.kmt.design_patterns.creational.factory.UFOEnemyShip;

import java.util.Scanner;

public class GameWithoutFactoryPattern {
    public static void main(String[] args) {

        /*
            APPROACH 1:
            Old way of creating objects
            When we use new we are not being dynamic
         */

        EnemyShip theEnemy = null;
        EnemyShip ufoShip = new UFOEnemyShip();
        doStuffEnemy(ufoShip);
        System.out.print("\n");


        /*
            APPROACH 2:
            This allows me to make the program more dynamic
            It doesn't close the code from being modified
            and that is bad!
            Also, there are lots of if else statements which is making code bloated
         */

        Scanner userInput = new Scanner(System.in);
        String enemyShipOption = "";
        System.out.print("What type of ship? (U or R)");

        if (userInput.hasNextLine()){
            enemyShipOption = userInput.nextLine();
        }

        if (enemyShipOption == "U"){
            theEnemy = new UFOEnemyShip();
        } else if (enemyShipOption == "R"){
            theEnemy = new RocketEnemyShip();
        } else {
            theEnemy = new BigUFOEnemyShip();
        }
        doStuffEnemy(theEnemy);
    }

    // Executes methods of the super class
    public static void doStuffEnemy(EnemyShip anEnemyShip){
        anEnemyShip.displayEnemyShip();
        anEnemyShip.followHeroShip();
        anEnemyShip.enemyShipShoots();
    }
}
