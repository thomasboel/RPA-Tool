package com.thom.rpatool.Designer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/4/2018
 */
public class SampleDesigner extends JFrame {
    private JPanel panel = new JPanel(new BorderLayout());

    public SampleDesigner() throws HeadlessException {
        super("Sample Designer Interface");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        add(panel);
        drawScreen();
        resize(800, 600);
    }

    private void drawScreen() {
        drawWorkflow();
        drawButtons();
    }

    //public List<JLabel> stepList = new ArrayList<>();
    public List<Step> stepList = new ArrayList<>();
    private JPanel workflowPanel = new JPanel(new FlowLayout());

    private void drawWorkflow() {
        workflowPanel.setVisible(true);
        //workflowPanel.setBorder(new LineBorder(Color.red, 3));
        workflowPanel.setBackground(Color.white);

        // Components
        putWorkflowComponents();

        panel.add(workflowPanel, BorderLayout.CENTER);
    }

    public void putWorkflowComponents() {
        workflowPanel.removeAll();
        workflowPanel.revalidate();
        workflowPanel.repaint();

        for (Step step : stepList) {
            JLabel lbl = new JLabel(step.getName());
            lbl.setBorder(new LineBorder(Color.black, 1));
            workflowPanel.add(lbl);
        }
        resize(801, 600);
        resize(800, 600);
    }

    private List<JButton> buttonList = new ArrayList<>();
    private JPanel buttonPanel = new JPanel();

    private void drawButtons() {
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setVisible(true);
        //buttonPanel.setBorder(new LineBorder(Color.green, 3));
        panel.add(buttonPanel, BorderLayout.EAST);

        // Components
        JButton btn_add_mousemove_step = new JButton("Mouse Move");
        JButton btn_add_mouseclick_step = new JButton("Mouse Click");
        JButton btn_add_keyclick_step = new JButton("Key Click");

        initButton(btn_add_mousemove_step);
        initButton(btn_add_mouseclick_step);
        initButton(btn_add_keyclick_step);
    }

    private void initButton(JButton button) {
        buttonList.add(button);
        button.setPreferredSize(new Dimension(200, 20));
        buttonPanel.add(button);
        buttonPanel.add(Box.createRigidArea(new Dimension(200, 5)));
        button.addActionListener(new ButtonListenerDesigner(this, button.getText()));
        button.setVisible(true);
    }

    // Testing only
    public static void main(String[] args) {
        new SampleDesigner();
    }
}
