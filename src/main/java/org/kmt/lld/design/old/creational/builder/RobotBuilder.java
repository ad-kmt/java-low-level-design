package org.kmt.lld.design.old.creational.builder;

public interface RobotBuilder {
    public void buildRobotHead();

    public void buildRobotTorso();

    public void buildRobotArms();

    public void buildRobotLegs();

    public Robot getRobot();
}
