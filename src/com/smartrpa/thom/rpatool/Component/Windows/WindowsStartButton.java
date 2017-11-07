package com.smartrpa.thom.rpatool.Component.Windows;

import com.smartrpa.thom.rpatool.Component.Component;
import com.smartrpa.thom.rpatool.Component.GuiComponent;

import java.awt.*;

/**
 * @author Thomas Boel Micheelsen
 *         Created 07-11-2017.
 */
public class WindowsStartButton extends GuiComponent implements Component {
    public WindowsStartButton() {
        super(0,Toolkit.getDefaultToolkit().getScreenSize().height - 50,60,50);
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
