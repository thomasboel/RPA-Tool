package com.thom.rpatool.Util;

import javax.swing.*;
import java.awt.*;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/8/2018
 */
public class ImageUtil {
    public static ImageIcon getScaledImageIcon(String path, int scaleX, int scaleY) {
        Image image = Toolkit.getDefaultToolkit().getImage(path);
        return new ImageIcon(image.getScaledInstance(scaleX, scaleY, Image.SCALE_DEFAULT));
    }
}
