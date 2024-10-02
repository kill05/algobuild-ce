package com.github.kill05.algobuildce.package_a.a;

import com.github.kill05.algobuildce.package_a.c.a.ExecutionOptions;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.i.Translator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeListener;

public final class ExecutionOptionsDialogue extends JDialog implements ActionListener {

    public static final int[] CLOCK_SPEEDS = new int[]{1, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000};

    private final ABProgram program;
    private final JCheckBox traceCheckBox;
    private final JCheckBox singleStepCheckBox;
    private final JSpinner clockSpeedSpinner;

    public ExecutionOptionsDialogue(Frame frame, ABProgram program) {
        super(frame, Translator.translate("abedDialogRunOptionsTitle"));
        this.program = program;
        JPanel var4 = new JPanel();
        var4.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setContentPane(var4);
        var4.setLayout(new GridBagLayout());
        this.setVisible(false);
        this.setLocation(100, 100);
        this.setResizable(false);

        ExecutionOptions options = this.program.getExecutionOptions();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = 21;
        constraints.weightx = 1.0D;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;

        this.traceCheckBox = new JCheckBox();
        this.traceCheckBox.setSelected(options.isTraceEnabled());
        this.traceCheckBox.addActionListener(this);

        this.add(new JLabel(Translator.translate("execTrace")), constraints);
        constraints.gridx = 1;
        this.add(this.traceCheckBox, constraints);

        this.singleStepCheckBox = new JCheckBox();
        this.singleStepCheckBox.setSelected(options.isStepEnabled());
        this.singleStepCheckBox.addActionListener(this);
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;

        this.add(new JLabel(Translator.translate("execOneStep")), constraints);
        constraints.gridx = 1;
        this.add(this.singleStepCheckBox, constraints);

        // Clock speed
        this.clockSpeedSpinner = new JSpinner(new ClockSpeedSpinnerModel());
        this.clockSpeedSpinner.setEditor(new ClockSpeedEditor());
        this.clockSpeedSpinner.setPreferredSize(new Dimension(55, 18));
        this.clockSpeedSpinner.setEnabled(!options.isStepEnabled());
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 2;

        this.add(new JLabel(Translator.translate("execStepTime") + " "), constraints);
        constraints.gridx = 1;
        this.add(this.clockSpeedSpinner, constraints);

        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == this.traceCheckBox) {
            this.program.getExecutionOptions().setTraceEnabled(this.traceCheckBox.isSelected());
            this.program.update(true);
        }

        if (source == this.singleStepCheckBox) {
            boolean var3 = this.singleStepCheckBox.isSelected();
            this.clockSpeedSpinner.setEnabled(!var3);
            this.program.getExecutionOptions().setStepEnabled(var3);
            this.program.update(true);
        }
    }


    public class ClockSpeedSpinnerModel implements SpinnerModel {

        private int value = 1000;

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public void setValue(Object value) {
            try {
                program.getExecutionOptions().setClockSpeed(value instanceof Number ? ((Number) value).intValue() : Integer.parseInt(value.toString()));
                program.update(true);

                this.value = program.getExecutionOptions().getClockSpeed();
            } catch (NumberFormatException ignored) {
            }

            ClockSpeedEditor editor = (ClockSpeedEditor) clockSpeedSpinner.getEditor();
            editor.setText(String.valueOf(this.value));
        }

        @Override
        public Object getNextValue() {
            for (int speed : CLOCK_SPEEDS) {
                if (value < speed) return speed;
            }

            return null;
        }

        @Override
        public Object getPreviousValue() {
            for (int i = CLOCK_SPEEDS.length - 1; i >= 0; i--) {
                int speed = CLOCK_SPEEDS[i];
                if (value > speed) return speed;
            }

            return null;
        }


        @Override
        public void addChangeListener(ChangeListener l) {

        }

        @Override
        public void removeChangeListener(ChangeListener l) {

        }
    }

    public class ClockSpeedEditor extends JTextField {
        public ClockSpeedEditor() {
            super(1);
            setText(String.valueOf(clockSpeedSpinner.getValue()));

            addActionListener(e -> {
                clockSpeedSpinner.setValue(getText());
            });
        }
    }
}
