package com.thom.rpatool.Event.Robot;

import com.thom.rpatool.Event.Event;
import com.thom.rpatool.Event.Reference.EventReference;
import lombok.Getter;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/5/2018
 */
public class DelayEvent extends Event {
    @Getter
    private final int delay;

    public DelayEvent(int delay) {
        super(EventReference.DELAY_EVENT);
        this.delay = delay;
    }
}
