package com.thom.rpatool.Event.Robot;

import com.thom.rpatool.Event.Event;
import com.thom.rpatool.Event.Reference.EventReference;
import lombok.Getter;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/4/2018
 */
public class MouseReleasedEvent extends Event {
    @Getter
    private final int button;

    public MouseReleasedEvent(int button) {
        super(EventReference.MOUSE_RELEASED_EVENT);
        this.button = button;
    }
}
