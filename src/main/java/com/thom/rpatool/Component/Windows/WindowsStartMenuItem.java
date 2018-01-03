package com.thom.rpatool.Component.Windows;

import com.thom.rpatool.Component.Component;
import com.thom.rpatool.Component.GuiComponent;

import java.awt.*;

/**
 * @author Thomas Boel Micheelsen
 *         Created 08-11-2017.
 */
public class WindowsStartMenuItem extends GuiComponent implements Component {
    public WindowsStartMenuItem(int x, int y) {
        super(x, y,308,45);
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
