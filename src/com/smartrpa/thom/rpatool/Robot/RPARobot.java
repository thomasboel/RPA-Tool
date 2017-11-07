package com.smartrpa.thom.rpatool.Robot;

import com.smartrpa.thom.rpatool.Component.GuiComponent;
import com.smartrpa.thom.rpatool.Screen.ScreenCapture;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * @author Thomas Boel Micheelsen
 *         Created 07-11-2017.
 */
public class RPARobot {
    @Getter
    private Robot robot;

    @Getter @Setter
    private ScreenCapture currentWorkspace;

    public RPARobot(Robot robot, int startupDelay) {
        this.robot = robot;
        robot.delay(startupDelay);
    }

    public void moveMouseTo(GuiComponent component) {
        minorDelay();
        robot.mouseMove(component.getX() + (component.getWidth() / 2), component.getY() + (component.getHeight() / 2));
    }

    public void clickOnComponent(GuiComponent component) {
        moveMouseTo(component);
        leftClick();
    }

    public void doubleClickOnComponent(GuiComponent component) {
        moveMouseTo(component);
        doubleClick();
    }

    public void leftClick() {
        minorDelay();
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public void doubleClick() {
        leftClick();
        leftClick();
    }

    public void minorDelay() {
        robot.delay( 25);
    }
}
