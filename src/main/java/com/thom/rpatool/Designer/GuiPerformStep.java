package com.thom.rpatool.Designer;

import com.thom.rpatool.Event.Reference.EventReference;

import javax.swing.*;
import java.awt.*;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/5/2018
 */
public class GuiPerformStep extends JFrame {
    private SampleDesigner designer;
    private String identifier;

    private JPanel panel = new JPanel(new BorderLayout());

    public GuiPerformStep(SampleDesigner designer, String identifier) {
        super(identifier);
        this.designer = designer;
        this.identifier = identifier;
        setSize(400, 200);
        add(panel);
        panel.setVisible(true);
        setVisible(true);
        drawScreen();
    }

    private JButton addStep;

    private void drawScreen() {
        // Universal Components
        addStep = new JButton("Add Step");
        panel.add(addStep, BorderLayout.SOUTH);
        addStep.setVisible(true);

        switch (identifier) {
            case "Mouse Move":
                drawMouseMove();
                break;
            case "Mouse Click":
                drawMouseClick();
                break;
            case "Key Click":
                drawKeyClick();
                break;
        }
    }

    private void drawKeyClick() {
        char[] keyChars = new char[255];
        for (int i = 0; i < 255; i++) { keyChars[i] = (char)i; }

        String[] keys = new String[255];
        for (int i = 0; i < 255; i++) {
            keys[i] = String.valueOf(keyChars[i]);
        }

        JComboBox keyList = new JComboBox(keys);
        panel.add(keyList);

        addStep.addActionListener(e -> {
            designer.stepList.add(new Step("Key Click: " + keyList.getSelectedItem().toString()).setEvent(EventReference.KEY_PRESSED_EVENT));
            designer.putWorkflowComponents();
            dispose();
        });
    }

    private void drawMouseClick() {
        addStep.addActionListener(e -> {
            designer.stepList.add(new Step("Mouse Click").setEvent(EventReference.MOUSE_PRESSED_EVENT));
            designer.putWorkflowComponents();
            dispose();
        });
    }

    private void drawMouseMove() {
        addStep.addActionListener(e -> {
            designer.stepList.add(new Step("Mouse Move").setEvent(EventReference.MOUSE_MOVED_EVENT));
            designer.putWorkflowComponents();
            dispose();
        });
    }
}
