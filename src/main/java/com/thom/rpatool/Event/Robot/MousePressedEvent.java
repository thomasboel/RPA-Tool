package com.thom.rpatool.Event.Robot;

import com.thom.rpatool.Event.Event;
import com.thom.rpatool.Event.Reference.EventReference;
import lombok.Getter;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/4/2018
 */
public class MousePressedEvent extends Event {
    @Getter
    private final int button;

    public MousePressedEvent(int button) {
        super(EventReference.MOUSE_PRESSED_EVENT);
        this.button = button;
    }
}
