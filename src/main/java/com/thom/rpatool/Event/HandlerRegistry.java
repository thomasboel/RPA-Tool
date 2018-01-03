package com.thom.rpatool.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/3/2018
 */
public class HandlerRegistry {
    private static List<Class> handlers = new ArrayList<>();

    public static void register(Class clazz) {
        handlers.add(clazz);
    }

    public static List<Class> getHandlers() {
        return handlers;
    }
}
