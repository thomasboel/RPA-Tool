package com.thom.rpatool.Robot;

import com.thom.rpatool.Component.GuiComponent;
import com.thom.rpatool.Event.EventPublisher;
import com.thom.rpatool.Event.Robot.*;
import com.thom.rpatool.Screen.ScreenCapture;
import com.thom.rpatool.Screen.ScreenReader;
import com.thom.rpatool.Util.RobotUtil;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * @author Thomas Boel Micheelsen
 *         Created 07-11-2017.
 */
public class RPARobot {
    // Instance of the java.awt.Robot
    private Robot robot;

    // ScreenCapture of the current workspace the robot is working on
    @Getter @Setter
    private ScreenCapture currentWorkspace;

    /**
     * RPARobot constructor, with specified robot startup delay.
     * @param robot Instance of a java.awt.Robot object
     * @param startupDelay A startup delay in milliseconds
     */
    public RPARobot(Robot robot, int startupDelay) {
        this.robot = robot;
        delay(startupDelay);
    }

    /**
     * RPARobot sub-constructor, calls the main constructor with a default startup delay of 1000 ms.
     * @param robot Instance of a java.awt.Robot object
     */
    public RPARobot(Robot robot) {
        this(robot, 1000);
    }

    /*
        ========== FUNCTIONALITY METHODS ==========
     */

    /**
     * Moves the mouse to the specified gui component.
     */
    public void moveMouseTo(GuiComponent component) {
        minorDelay();
        moveMouse(component.getX() + (component.getWidth() / 2), component.getY() + (component.getHeight() / 2));
    }

    /**
     * Moves the mouse to, and left-clicks the specified gui component.
     */
    public void clickOnComponent(GuiComponent component) {
        moveMouseTo(component);
        leftClick();
    }

    /**
     * Moves the mose to, and double-clicks the specified gui component.
     */
    public void doubleClickOnComponent(GuiComponent component) {
        moveMouseTo(component);
        doubleClick();
    }

    // TODO Implement logic (use of GuiComponentUpdateEvent, or some other sort of event handling)
    public boolean waitForComponent(GuiComponent guiComponent) {
        return false;
    }

    /**
     * Updates the current workspace that the robot is working on.
     */
    public void updateWorkspace() throws AWTException {
        setCurrentWorkspace(ScreenReader.instance.screenCapture());
    }

    /**
     * Sets the clipboard contents to the string and prints it using the paste functionality (ctrl+v).
     */
    public void typeString(String str) {
        minorDelay();
        StringSelection stringSelection = new StringSelection(str);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        // TODO Save old clipboard and set it accordingly to previous data.

        keyPress(KeyEvent.VK_CONTROL);
        keyPress(KeyEvent.VK_V);
        keyRelease(KeyEvent.VK_V);
        keyRelease(KeyEvent.VK_CONTROL);

        EventPublisher.raiseEvent(new StringTypedEvent(str));
    }

    /**
     * Converts the String to an int[] of keycodes and then presses each individual key.
     * If all needed is to write text, use typeString(String) instead.
     */
    public void typeStringManual(String str) {
        minorDelay();

        for (int keycode : RobotUtil.mapStringToKeyCodes(str)) {
            keyPress(keycode);
            keyRelease(keycode);
        }
    }

    /**
     * Moves the mouse to (50, 50).
     */
    public void resetMousePosition() {
        moveMouse(50, 50);
    }

    /**
     * Adds a minor delay of 25 ms, for gui components to update.
     */
    public void minorDelay() {
        delay(25);
    }

    public void leftClick() {
        mouseClick(InputEvent.BUTTON1_MASK);
    }

    public void rightClick() {
        mouseClick(InputEvent.BUTTON2_MASK);
    }

    public void middleClick() {
        mouseClick(InputEvent.BUTTON3_MASK);
    }

    public void doubleClick() {
        leftClick();
        leftClick();
    }

    private void mouseClick(int button) {
        minorDelay();
        mousePress(button);
        mouseRelease(button);
    }

    private void mousePress(int button) {
        robot.mousePress(button);
        EventPublisher.raiseEvent(new MousePressedEvent(button));
    }

    private void mouseRelease(int button) {
        robot.mouseRelease(button);
        EventPublisher.raiseEvent(new MouseReleasedEvent(button));
    }

    public void keyPress(int keycode) {
        minorDelay();
        robot.keyPress(keycode);
        EventPublisher.raiseEvent(new KeyPressedEvent(keycode));
    }

    public void keyRelease(int keycode) {
        minorDelay();
        robot.keyRelease(keycode);
        EventPublisher.raiseEvent(new KeyReleasedEvent(keycode));
    }

    public void moveMouse(int x, int y) {
        minorDelay();
        robot.mouseMove(x, y);
        EventPublisher.raiseEvent(new MouseMovedEvent(x, y));
    }

    public void delay(int delay) {
        robot.delay(delay);
        EventPublisher.raiseEvent(new DelayEvent(delay));
    }
}
