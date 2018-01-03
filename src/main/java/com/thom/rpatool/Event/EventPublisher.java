package com.thom.rpatool.Event;

import java.lang.reflect.Method;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/3/2018
 */
public class EventPublisher {
    public static void raiseEvent(final Event event)
    {
        new Thread(() -> raise(event)).start();
    }

    private static void raise(final Event event) {
        for (Class handler : HandlerRegistry.getHandlers()) {
            Method[] methods = handler.getMethods();

            for (Method method : methods) {
                EventHandler eventHandler = method.getAnnotation(EventHandler.class);

                if (eventHandler != null) {
                    Class[] methodParams = method.getParameterTypes();

                    if (methodParams.length < 1) {
                        continue;
                    }
                    if (!event.getClass().getSimpleName().equals(methodParams[0].getSimpleName())) {
                        continue;
                    }

                    try {
                        method.invoke(handler.newInstance(), event);
                    } catch (Exception e) {
                        e.printStackTrace(System.err);
                    }
                }
            }
        }
    }
}
