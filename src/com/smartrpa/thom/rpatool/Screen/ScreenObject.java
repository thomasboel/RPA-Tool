package com.smartrpa.thom.rpatool.Screen;

import com.smartrpa.thom.rpatool.Component.Windows.WindowsStartButton;
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
            }
            case "Mac OS X": {

            }
            case "Linux": {

            }
            default: {
                System.out.println("Could not load default settings for OS: " + OS);
            }
        }
    }
}
