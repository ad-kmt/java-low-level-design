package org.kmt.design_patterns.creational.factory.solution;

import org.kmt.design_patterns.creational.factory.BigUFOEnemyShip;
import org.kmt.design_patterns.creational.factory.EnemyShip;
import org.kmt.design_patterns.creational.factory.RocketEnemyShip;
import org.kmt.design_patterns.creational.factory.UFOEnemyShip;

public class EnemyShipFactory {
    public EnemyShip makeEnemyShip(String newShipType) {
        EnemyShip newShip = null;
        return switch (newShipType) {
            case "U" -> new UFOEnemyShip();
            case "R" -> new RocketEnemyShip();
            case "B" -> new BigUFOEnemyShip();
            default -> null;
        };
    }
}
