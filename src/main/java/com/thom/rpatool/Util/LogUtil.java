package com.thom.rpatool.Util;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/3/2018
 */
public class LogUtil {
    public static void info(String message) {
        System.err.println("INFO: " + message);
    }

    public static void error(String message) {
        System.err.println("ERROR: " + message);
    }

    public static void warn(String message) {
        System.out.println("WARNING: " + message);
    }

    public static void debug(String message) {
        System.out.println("DEBUG: " + message);
    }

    public static void fatal(String message) {
        System.err.println("FATAL: " + message);
    }
}
