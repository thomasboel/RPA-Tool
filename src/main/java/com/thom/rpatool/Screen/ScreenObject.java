package com.thom.rpatool.Screen;

import com.thom.rpatool.Component.GuiComponent;
import com.thom.rpatool.Component.Windows.WindowsStartButton;
import com.thom.rpatool.Util.LogUtil;
import lombok.Data;

/**
 * @author Thomas Boel Micheelsen
 *         Created 07-11-2017.
 */
@Data
public class ScreenObject {
    private GuiComponent startButton = null;

    public void loadDefaultObjects() {
        String OS = System.getProperty("os.name");

        switch (OS) {
            case "Windows 10": {
                LogUtil.info("Loading default windows 10 objects");
                startButton = new WindowsStartButton();
                break;
            }
            case "Mac OS X": {
                LogUtil.warn("Mac OS X not yet supported!");
                break;
            }
            case "Linux": {
                LogUtil.warn("Linux OS not yet supported!");
                break;
            }
            default: {
                System.out.println("Could not load default settings for OS: " + OS);
            }
        }
    }
}
