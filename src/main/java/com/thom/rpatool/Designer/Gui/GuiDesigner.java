package com.thom.rpatool.Designer.Gui;

import com.thom.rpatool.Designer.Step;
import com.thom.rpatool.Designer.StepRegistry;
import com.thom.rpatool.Event.Reference.EventReference;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * @author Thomas Boel Micheelsen
 * Created 1/8/2018
 */
public class GuiDesigner extends JFrame {
    private static final int DEFAULT_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final int DEFAULT_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public GuiDesigner() {
        super("Designer Interface");
        loadDefaults();
        initPanels();
        drawScreen();

        revalidate();
    }

    private void loadDefaults() {
        setSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        setVisible(true);
    }

    private JPanel panel_menuBar, panel_workflow, panel_emulator, panel_stepSelector, panel_stepInfo;
    private JPanel panel; // pointer for the panel that is currently being worked on upon gui drawing

    private void initPanels() {
        panel_menuBar = new JPanel();
        panel_workflow = new JPanel();
        panel_emulator = new JPanel();
        panel_stepSelector = new JPanel();
        panel_stepInfo = new JPanel();

        panel_menuBar.setLayout(new BoxLayout(panel_menuBar, BoxLayout.Y_AXIS));
        panel_workflow.setLayout(new FlowLayout());
        panel_emulator.setLayout(new BorderLayout());
        panel_stepSelector.setLayout(new BoxLayout(panel_stepSelector, BoxLayout.Y_AXIS));
        panel_stepInfo.setLayout(new GridBagLayout());

        // Underlying panels
        JSplitPane centerSplitPane, workflowSplitPane, stepSplitPane;
        centerSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        workflowSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        stepSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

        // Resize weights
        centerSplitPane.setResizeWeight(.75);
        workflowSplitPane.setResizeWeight(.25);
        stepSplitPane.setResizeWeight(.3);

        // Adding panels
        add(panel_menuBar, BorderLayout.WEST);
        add(centerSplitPane, BorderLayout.CENTER);
        centerSplitPane.add(workflowSplitPane);
        centerSplitPane.add(stepSplitPane);
        workflowSplitPane.add(panel_workflow);
        workflowSplitPane.add(panel_emulator);
        stepSplitPane.add(panel_stepSelector);
        stepSplitPane.add(panel_stepInfo);

        // Visibility
        centerSplitPane.setVisible(true);
        workflowSplitPane.setVisible(true);
        stepSplitPane.setVisible(true);
        panel_menuBar.setVisible(true);
        panel_workflow.setVisible(true);
        panel_emulator.setVisible(true);
        panel_stepSelector.setVisible(true);
        panel_stepInfo.setVisible(true);

        panel_menuBar.setBackground(new Color(45, 75, 118));
        panel_workflow.setBackground(Color.white);

        panel_menuBar.setBorder(new LineBorder(Color.blue, 0));
//        panel_workflow.setBorder(new LineBorder(Color.cyan, 1));
//        panel_emulator.setBorder(new LineBorder(Color.red, 1));
//        panel_stepSelector.setBorder(new LineBorder(Color.magenta, 1));
//        panel_stepInfo.setBorder(new LineBorder(Color.yellow, 1));
    }

    private void drawScreen() {
        drawMenuBar();
        drawWorkflow();
        drawEmulator();
        drawStepSelect();
        drawStepInfo();
    }

    private void drawMenuBar() {
        panel = panel_menuBar;

        GuiUtil.addRigidBox(panel, 80, 15);
        GuiUtil.addMenuBarItem(panel, "menu_hor", "menu");
    }

    private void drawWorkflow() {
        panel = panel_workflow;

        panel.add(new JLabel("Step 01"));
        panel.add(new JLabel("Step 02"));
        panel.add(new JLabel("Step 03"));
    }

    private void drawEmulator() {
        panel = panel_emulator;

    }

    private void drawStepSelect() {
        panel = panel_stepSelector;

        GuiUtil.addRigidBox(panel, panel.getWidth()/2, 30);

        JComboBox stepSelector = new JComboBox(StepRegistry.getStepListDisplay().toArray());
        stepSelector.setMaximumSize(new Dimension(panel.getWidth()-40, 30));
        stepSelector.setEditable(false);
        stepSelector.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(stepSelector);

        GuiUtil.addRigidBox(panel, panel.getWidth()/2, 15);

        JButton addStep = new JButton("Add Step");
        addStep.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(addStep);
    }

    private void drawStepInfo() {
        panel = panel_stepInfo;
    }

    public static void main(String[] args) {
        StepRegistry.addStepToList(new Step("Mouse Move", EventReference.MOUSE_MOVED_EVENT));
        StepRegistry.addStepToList(new Step("Delay", EventReference.DELAY_EVENT));
        StepRegistry.addStepToList(new Step("Key Press", EventReference.KEY_PRESSED_EVENT));
        StepRegistry.addStepToList(new Step("Key Release", EventReference.KEY_RELEASED_EVENT));
        StepRegistry.addStepToList(new Step("Mouse Press", EventReference.MOUSE_PRESSED_EVENT));
        StepRegistry.addStepToList(new Step("Mouse Release", EventReference.MOUSE_RELEASED_EVENT));
        StepRegistry.addStepToList(new Step("String Typed", EventReference.STRING_TYPED_EVENT));
        new GuiDesigner();
    }
}
