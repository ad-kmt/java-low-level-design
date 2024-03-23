package org.kmt.lld.design.patterns.old.creational.builder;

public class RobotDirector {
    private RobotBuilder robotBuilder;

    RobotDirector(RobotBuilder robotBuilder){
        this.robotBuilder = robotBuilder;
    }

    public Robot getRobot(){
        return this.robotBuilder.getRobot();
    }

    public void makeRobot(){
        this.robotBuilder.buildRobotArms();
        this.robotBuilder.buildRobotLegs();
        this.robotBuilder.buildRobotHead();
        this.robotBuilder.buildRobotTorso();
    }
}
