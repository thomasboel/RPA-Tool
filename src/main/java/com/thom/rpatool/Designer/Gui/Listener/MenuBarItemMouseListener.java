package com.thom.rpatool.Designer.Gui.Listener;

import com.thom.rpatool.Util.ImageUtil;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/8/2018
 */
public class MenuBarItemMouseListener implements MouseListener {
    private JPanel menubar;
    private JLabel component;
    private String imagePath;
    private String action;

    public MenuBarItemMouseListener(JPanel menubar, JLabel component, String imagePath, String action) {
        this.menubar = menubar;
        this.component = component;
        this.imagePath = imagePath;
        this.action = action;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Component position: (" + component.getX() + ", " + component.getY() + ")");
//        GuiUtil.
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        component.setIcon(ImageUtil.getScaledImageIcon(imagePath + "_hover.png", 50, 50));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        component.setIcon(ImageUtil.getScaledImageIcon(imagePath + ".png", 50, 50));
    }
}
