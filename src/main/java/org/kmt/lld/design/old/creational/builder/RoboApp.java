package org.kmt.lld.design.old.creational.builder;

public class RoboApp {
    public static void main(String[] args) {
        RobotBuilder robotBuilder = new OldRobotBuilder();
        RobotDirector robotDirector = new RobotDirector(robotBuilder);

        robotDirector.makeRobot();

        Robot firstRobot = robotDirector.getRobot();

        System.out.println("Robot Built");

        System.out.println("Robot Head Type: " + firstRobot.getRobotHead());

        System.out.println("Robot Torso Type: " + firstRobot.getRobotTorso());

        System.out.println("Robot Arm Type: " + firstRobot.getRobotArms());

        System.out.println("Robot Leg Type: " + firstRobot.getRobotLegs());
    }
}
