package com.thom.rpatool.Event.Robot;

import com.thom.rpatool.Event.Event;
import com.thom.rpatool.Event.Reference.EventReference;
import lombok.Getter;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/3/2018
 */
public class StringTypedEvent extends Event {
    @Getter
    private String string;

    public StringTypedEvent(String str) {
        super(EventReference.STRING_TYPED_EVENT);
        this.string = str;
    }
}
