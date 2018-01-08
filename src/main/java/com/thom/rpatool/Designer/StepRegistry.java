package com.thom.rpatool.Designer;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/8/2018
 */
public class StepRegistry {
    @Getter
    private static List<Step> stepList = new ArrayList<>();

    public static List<String> getStepListDisplay() {
        return stepList.stream().map(Step::getName).collect(Collectors.toList());
    }

    public static void addStepToList(Step step) {
        stepList.add(step);
    }
}
