package com.thom.rpatool.Util;

import java.awt.event.KeyEvent;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/4/2018
 */
public class RobotUtil {
    public static int[] mapStringToKeyCodes(String str) {
        char[] input = str.toCharArray();
        int[] keyCodes = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            keyCodes[i] = KeyEvent.getExtendedKeyCodeForChar(input[i]);
        }
        return keyCodes;
    }
}
