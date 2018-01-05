package com.thom.rpatool.Designer;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/5/2018
 */
@Data
@Accessors(chain = true)
public class Step {
    private final String name;
    private String event;
}
