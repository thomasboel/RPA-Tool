package com.thom.rpatool.Component.Windows;

import com.thom.rpatool.Component.GuiComponent;
import com.thom.rpatool.Component.Component;
import com.thom.rpatool.Util.ScreenUtil;

import java.awt.*;

/**
 * @author Thomas Boel Micheelsen
 *         Created 07-11-2017.
 */
public class WindowsStartButton extends GuiComponent implements Component {
    public WindowsStartButton() {
        super(0, ScreenUtil.HEIGHT - 50,60,50);
    }

    @Override
    public Point getComponentPosition() {
        return new Point(getX(), getY());
    }

    @Override
    public Dimension getComponentDimensions() {
        return new Dimension(getWidth(), getHeight());
    }
}
