package org.kmt.lld.design.patterns.creational.factory.solution;

import org.kmt.lld.design.patterns.creational.factory.RocketEnemyShip;
import org.kmt.lld.design.patterns.creational.factory.UFOEnemyShip;
import org.kmt.lld.design.patterns.creational.factory.BigUFOEnemyShip;
import org.kmt.lld.design.patterns.creational.factory.EnemyShip;

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
