package com.thom.rpatool.Event.Robot;

import com.thom.rpatool.Event.Event;
import com.thom.rpatool.Event.Reference.EventReference;
import lombok.Getter;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/3/2018
 */
public class KeyReleasedEvent extends Event {
    @Getter
    private final int keyCode;

    public KeyReleasedEvent(int keyCode) {
        super(EventReference.KEY_RELEASED_EVENT);
        this.keyCode = keyCode;
    }
}
