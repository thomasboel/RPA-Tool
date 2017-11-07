package com.smartrpa.thom.rpatool.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author Thomas Boel Micheelsen
 *         Created 07-11-2017.
 */
public class ScreenReader {
    public static ScreenReader instance = new ScreenReader();

    public ScreenCapture screenCapture() throws AWTException {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenCap = new Robot().createScreenCapture(screenRect);
        return new ScreenCapture(Calendar.getInstance().getTime(), screenCap);
    }

    public void saveScreenCapture(ScreenCapture screenCapture) {
        try {
            String path = "./screenshots/";
            String name = screenCapture.getDate().toString().replace(':','.') + ".png";
            File file = new File(path + name);
            ImageIO.write(screenCapture.getImage(), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
