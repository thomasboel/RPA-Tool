package com.thom.rpatool;

import com.thom.rpatool.Robot.RPARobot;
import com.thom.rpatool.Screen.ScreenObject;
import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/2/2018
 */
public class OpenCalculatorRobotTest {
    @Test
    public void calculatorOpenTest() {
        try {
            executeRobot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private void executeRobot() throws AWTException {
        RPARobot robot = new RPARobot(new Robot());

        ScreenObject screenObject = new ScreenObject();
        screenObject.loadDefaultObjects();

        /*
         * Script - Workflow
         */
        robot.resetMousePosition();
            // TODO I have to call moveMouseTo() twice for it to work, figure out how to use a moveMouse method that works for multiple monitor setups.
        robot.moveMouseTo(screenObject.getStartButton());
        robot.clickOnComponent(screenObject.getStartButton());
        robot.typeString("calculator");
        robot.keyPress(KeyEvent.VK_ENTER);
    }
}
