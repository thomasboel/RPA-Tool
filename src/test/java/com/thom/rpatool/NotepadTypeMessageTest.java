package com.thom.rpatool;

import com.thom.rpatool.Robot.RPARobot;
import com.thom.rpatool.Screen.ScreenObject;
import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/4/2018
 */
public class NotepadTypeMessageTest {
    @Test
    public void notepadTest() {
        try {
            executeRobot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private String[] text = {
            "Hello World!", "This test involves writing text to the Notepad Application.",
            "It's for testing purposes!", "!#¤%&/()=?`´^¨*'-_.:,;"
    };

    private void executeRobot() throws AWTException {
        RPARobot robot = new RPARobot(new Robot());

        ScreenObject screenObject = new ScreenObject();
        screenObject.loadDefaultObjects();

        /*
         * Script - Workflow
         */
        robot.resetMousePosition();
        robot.clickOnComponent(screenObject.getStartButton());
        robot.typeString("notepad");
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(500);
        // Type Text
        for (String line : text) {
            robot.typeString(line);
            robot.keyPress(KeyEvent.VK_ENTER); //Newline
        }
    }
}
