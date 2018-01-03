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
        robot.clickOnComponent(screenObject.getStartButton());
        robot.typeString("calculator");
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.typeStringManual("5*5");
    }
}
