package com.thom.rpatool.Screen;

import com.thom.rpatool.Component.Windows.WindowsStartButton;
import lombok.Data;

/**
 * @author Thomas Boel Micheelsen
 *         Created 07-11-2017.
 */
@Data
public class ScreenObject {
    private WindowsStartButton startButton = null;

    public void loadDefaultObjects() {
        String OS = System.getProperty("os.name");

        switch (OS) {
            case "Windows 10": {
                startButton = new WindowsStartButton();
                break;
            }
            case "Mac OS X": {
                break;
            }
            case "Linux": {
                break;
            }
            default: {
                System.out.println("Could not load default settings for OS: " + OS);
            }
        }
    }
}
