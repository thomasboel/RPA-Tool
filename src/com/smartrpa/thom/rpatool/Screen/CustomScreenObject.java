package com.smartrpa.thom.rpatool.Screen;

import com.smartrpa.thom.rpatool.Component.Windows.WindowsStartButton;
import lombok.Data;

/**
 * @author Thomas Boel Micheelsen
 *         Created 07-11-2017.
 */
@Data
public class CustomScreenObject extends ScreenObject {
    private final ScreenCapture screenCapture;

    public CustomScreenObject(ScreenCapture screenCapture) {
        this.screenCapture = screenCapture;
        loadComponentsFromScreenCapture(screenCapture);
    }

    public void loadComponentsFromScreenCapture(ScreenCapture screenCapture) {
        setStartButton(new WindowsStartButton());
    }
}
