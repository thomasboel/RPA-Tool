package com.thom.rpatool.Event.Robot;

import com.thom.rpatool.Event.Event;
import com.thom.rpatool.Event.Reference.EventReference;
import lombok.Getter;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/3/2018
 */
public class MouseMovedEvent extends Event {
    @Getter
    private int xPos;
    @Getter
    private int yPos;

    public MouseMovedEvent(int xPos, int yPos) {
        super(EventReference.MOUSE_MOVED_EVENT);
        this.xPos = xPos;
        this.yPos = yPos;
    }
}
