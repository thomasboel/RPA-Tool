package com.thom.rpatool.Util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/8/2018
 */
public class ImageUtil {
    public static ImageIcon getScaledImageIcon(String path, int scaleX, int scaleY) {
        Image image = getImage(path);
        return new ImageIcon(image.getScaledInstance(scaleX, scaleY, Image.SCALE_DEFAULT));
    }

    public static BufferedImage getBufferedImage(String path) {
        File f = new File(path);
        BufferedImage img = null;

        try {
            img = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public static Image getImage(String path) {
        Image img = null;

        try {
            img = Toolkit.getDefaultToolkit().getImage(path);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return img;
    }
}
