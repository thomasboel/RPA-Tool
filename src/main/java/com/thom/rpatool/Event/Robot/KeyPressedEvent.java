package com.thom.rpatool.Event.Robot;

import com.thom.rpatool.Event.Event;
import com.thom.rpatool.Event.Reference.EventReference;
import lombok.Getter;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/3/2018
 */
public class KeyPressedEvent extends Event {
    @Getter
    private final int keyCode;

    public KeyPressedEvent(int keyCode) {
        super(EventReference.KEY_PRESSED_EVENT);
        this.keyCode = keyCode;
    }
}
