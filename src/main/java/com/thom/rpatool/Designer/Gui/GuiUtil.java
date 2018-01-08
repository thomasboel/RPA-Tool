package com.thom.rpatool.Designer.Gui;

import com.thom.rpatool.Designer.Gui.Listener.MenuBarItemMouseListener;
import com.thom.rpatool.Util.ImageUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/8/2018
 */
public class GuiUtil {
    private static final String res = "./src/main/resources/";

    private static void addRigidBox(JPanel panel, Dimension size) {
        panel.add(Box.createRigidArea(size));
    }

    public static void addRigidBox(JPanel panel, int width, int height) {
        addRigidBox(panel, new Dimension(width, height));
    }

    public static void addMenuBarItem(JPanel menubar, String imageIconName, String action) {
        String path = res + imageIconName;
        ImageIcon icon = ImageUtil.getScaledImageIcon(path + ".png", 50, 50);
        JLabel item = new JLabel(icon);
        item.setAlignmentX(Component.CENTER_ALIGNMENT);
        item.addMouseListener(new MenuBarItemMouseListener(menubar, item, path, action));
        item.setVisible(true);
        menubar.add(item);
    }
}
