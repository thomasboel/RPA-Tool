package com.thom.rpatool.Designer.Sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/5/2018
 */
public class ButtonListenerDesigner implements ActionListener {
    private SampleDesigner designer;
    private String identifier;

    public ButtonListenerDesigner(SampleDesigner designer, String identifier) {
        this.designer = designer;
        this.identifier = identifier;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new GuiPerformStep(designer, identifier);
    }
}
