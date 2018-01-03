package com.thom.rpatool.Screen;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.awt.image.BufferedImage;
import java.util.Date;

/**
 * @author Thomas Boel Micheelsen
 *         Created 07-11-2017.
 */
@Data
@RequiredArgsConstructor
public class ScreenCapture {
    private String name;

    private final Date date;
    private final BufferedImage image;
}
