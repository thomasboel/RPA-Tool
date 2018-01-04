package com.thom.testenv;

import com.thom.rpatool.Event.HandlerRegistry;
import com.thom.rpatool.Robot.RPARobot;
import com.thom.rpatool.Screen.ScreenObject;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/3/2018
 */
public class TestRobot {
    public static void main(String[] args) {
        TestRobot testRobot = new TestRobot();
        HandlerRegistry.register(RobotEventHandler.class);
        
        try {
            testRobot.runRobot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private void runRobot() throws AWTException {
        // Robot Object
        RPARobot robot = new RPARobot(new Robot(), 1500);
        // Screen Object
        ScreenObject screenObject = new ScreenObject();
        screenObject.loadDefaultObjects();

        /*
          Robot Script
         */
        robot.resetMousePosition();
        openCalculator(robot, screenObject);
        performCalculation(robot, 47, 36);
        performCalculation(robot, 1453, 34532);
        performCalculation(robot, 2, 2);
    }

    private void openCalculator(RPARobot robot, ScreenObject screenObject) {
        robot.clickOnComponent(screenObject.getStartButton());
        robot.typeString("calculator");
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(500);
    }

    private void performCalculation(RPARobot robot, int a, int b) {
        robot.typeStringManual(a + "+" + b);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(50);
    }
}
