package com.smartrpa.thom.rpatool;

import com.smartrpa.thom.rpatool.Robot.RPARobot;
import com.smartrpa.thom.rpatool.Screen.ScreenObject;

import java.awt.*;

/**
 * @author Thomas Boel Micheelsen
 *         Created 07-11-2017.
 */
public class RPATool {
    public static void main(String[] args) {
        try {
            runRobot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void runRobot() throws AWTException {
        // Robot Object
        RPARobot robot = new RPARobot(new Robot(), 1500);
        // Screen Object
        ScreenObject screenObject = new ScreenObject();
        screenObject.loadDefaultObjects();

        /**
         * Robot Script
         */
        robot.clickOnComponent(screenObject.getStartButton());
    }
}
