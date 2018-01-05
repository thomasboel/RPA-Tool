package com.thom.testenv;

import com.thom.rpatool.Event.EventHandler;
import com.thom.rpatool.Event.Robot.*;
import com.thom.rpatool.Util.LogUtil;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/3/2018
 */
public class RobotEventHandler {
    @EventHandler
    public void onRobotKeyPress(KeyPressedEvent event) {
        LogUtil.info("Key pressed with keycode: " + event.getKeyCode());
    }

    @EventHandler
    public void onRobotKeyRelease(KeyReleasedEvent event) {
        LogUtil.info("Key released with keycode: " + event.getKeyCode());
    }

    @EventHandler
    public void onRobotMouseMove(MouseMovedEvent event) {
        LogUtil.info("Mouse moved to (" + event.getXPos() + "," + event.getYPos() + ")");
    }

    @EventHandler
    public void onRobotMouseButtonPress(MousePressedEvent event) {
        LogUtil.info("Mouse button " + event.getButton() + " pressed");
    }

    @EventHandler
    public void onRobotMouseButtonRelease(MouseReleasedEvent event) {
        LogUtil.info("Mouse button " + event.getButton() + " released");
    }

    @EventHandler
    public void onRobotTypeString(StringTypedEvent event) {
        LogUtil.info("String typed using paste functionality: " + event.getString());
    }

    @EventHandler
    public void onRobotDelayTriggered(DelayEvent event) {

    }
}
