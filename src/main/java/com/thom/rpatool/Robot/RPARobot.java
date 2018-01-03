package com.thom.rpatool.Robot;

import com.thom.rpatool.Component.GuiComponent;
import com.thom.rpatool.Event.EventPublisher;
import com.thom.rpatool.Event.Robot.*;
import com.thom.rpatool.Screen.ScreenCapture;
import com.thom.rpatool.Screen.ScreenReader;
import com.thom.rpatool.Util.LogUtil;
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
        robot.delay(startupDelay);
    }

    /**
     * RPARobot sub-constructor, calls the main constructor with a default startup delay of 1000 ms.
     * @param robot Instance of a java.awt.Robot object
     */
    public RPARobot(Robot robot) {
        this(robot, 1000);
    }

    /**
     * Moves the mouse to the specified gui component.
     * @param component The gui component to move the mouse to
     */
    public void moveMouseTo(GuiComponent component) {
        minorDelay();
        moveMouse(component.getX() + (component.getWidth() / 2), component.getY() + (component.getHeight() / 2));
    }

    /**
     * Moves the mouse to, and left-clicks the specified gui component.
     * @param component The gui component to move to and click
     */
    public void clickOnComponent(GuiComponent component) {
        moveMouseTo(component);
        leftClick();
    }

    /**
     * Moves the mose to, and double-clicks the specified gui component.
     * @param component The gui component to move to and double click
     */
    public void doubleClickOnComponent(GuiComponent component) {
        moveMouseTo(component);
        doubleClick();
    }

    /**
     * Clicks on mouse-button 1 (typically left click).
     */
    public void leftClick() {
        minorDelay();
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    /**
     * Clicks on mouse-button 2 (typically right click).
     */
    public void rightClick() {
        minorDelay();
        robot.mousePress(InputEvent.BUTTON2_MASK);
        robot.mouseRelease(InputEvent.BUTTON2_MASK);
    }

    /**
     * Double clicks mouse button 1 (typically left click).
     */
    public void doubleClick() {
        leftClick();
        leftClick();
    }

    /**
     * Moves the mouse to (0, 0).
     */
    public void resetMousePosition() {
        LogUtil.info("Mouse Reset...");
        moveMouse(50, 50);
    }

    /**
     * Adds a minor delay of 25 ms, for gui components to update.
     */
    public void minorDelay() {
        delay(25);
    }

    /**
     * Adds a delay of a given time period in ms.
     * @param delay
     */
    public void delay(int delay) {
        robot.delay(delay);
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
     * Sets the clipboard contents to the string and prints it using ctrl+v.
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
    }

    /**
     * Converts the String to an int[] of keycodes and then presses each individual key - !!!NOTE!!!: SLOWER than typeString()
     */
    public void typeStringManual(String str) {
        minorDelay();
        int[] keycodeMap = mapStringToKeyCodes(str);

        for (int keycode : keycodeMap) {
            keyPress(keycode);
            keyRelease(keycode);
        }
    }

    private int[] mapStringToKeyCodes(String str) {
        char[] input = str.toCharArray();
        int[] keyCodes = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            keyCodes[i] = KeyEvent.getExtendedKeyCodeForChar(input[i]);
        }
        return keyCodes;
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
}
