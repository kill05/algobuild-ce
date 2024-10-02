package com.github.kill05.algobuildce.package_a.a;

import com.github.kill05.algobuildce.package_a.c.a.ViewOptions;
import com.github.kill05.algobuildce.package_a.f.ABFiles;
import com.github.kill05.algobuildce.package_a.i.Translator;
import com.github.kill05.algobuildce.json.JSONObject;
import com.github.kill05.algobuildce.json.JsonWriter;
import com.github.kill05.algobuildce.package_a.k.GlobalVariables;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public final class m extends JDialog implements ActionListener, ChangeListener {
    private final Frame a;
    private final JComboBox<String> comboBox;
    private final Font c;
    private final Font d;
    private final JSpinner e;
    private final JSpinner f;
    private final JSpinner g;
    private final JButton h;
    private final JButton i;
    private final JButton j;
    private final JButton k;
    private final JButton l;
    private final com.github.kill05.algobuildce.package_a.c.a.b m;

    public m(Frame var1, com.github.kill05.algobuildce.package_a.c.a.b var2) {
        super(var1, Translator.translate("fontDialogTitle"));
        this.a = var1;
        this.m = var2;
        JPanel var6;
        (var6 = new JPanel()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setContentPane(var6);
        var6.setLayout(new GridBagLayout());
        this.setVisible(false);
        this.setLocation(100, 100);
        this.setResizable(false);
        this.c = var2.getViewOptions().getCodeFont();
        this.d = var2.getViewOptions().getConsoleFont();
        this.comboBox = new JComboBox<>();
        String[] var7 = new String[]{"Dialog", "DialogInput", "Monospaced", "Serif", "SansSerif"};
        System.currentTimeMillis();

        for (int var3 = 0; var3 < 5; ++var3) {
            if ((new Font(var7[var3], Font.PLAIN, 1)).canDisplayUpTo("abcdefghilmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789|!\"$%&/()=?'^[]@#<>,;.:_+-*/") < 0) {
                this.comboBox.addItem(var7[var3]);
            }
        }

        try {
            this.comboBox.setSelectedItem(this.c.getName());
        } catch (Exception ignored) {
        }

        Dimension var10 = this.comboBox.getPreferredSize();
        this.comboBox.addActionListener(this);
        this.comboBox.setMaximumSize(var10);
        this.comboBox.setSelectedItem(this.c.getName());
        GridBagConstraints var4;
        (var4 = new GridBagConstraints()).anchor = 21;
        var4.weightx = 1.0D;
        var4.gridwidth = 3;
        var4.gridx = 0;
        var4.gridy = 0;
        this.add(new JLabel(Translator.translate("fontFace")), var4);
        var4.gridx = 1;
        this.add(this.comboBox, var4);
        SpinnerNumberModel var8 = new SpinnerNumberModel((int) Math.round((double) this.c.getSize() / GlobalVariables.getFontZoomRatio()), 8, 50, 2);
        this.e = new JSpinner(var8);
        Dimension var9 = this.e.getPreferredSize();
        this.e.setMaximumSize(var9);
        this.e.addChangeListener(this);
        var4.gridwidth = 1;
        var4.gridx = 0;
        var4.gridy = 1;
        this.add(new JLabel(Translator.translate("fontSize")), var4);
        var4.gridx = 1;
        this.add(this.e, var4);
        SpinnerNumberModel var11 = new SpinnerNumberModel((int) Math.round((double) this.d.getSize() / GlobalVariables.getFontZoomRatio()), 8, 50, 2);
        this.f = new JSpinner(var11);
        var10 = this.f.getPreferredSize();
        this.f.setMaximumSize(var10);
        this.f.addChangeListener(this);
        var4.gridx = 0;
        var4.gridy = 2;
        this.add(new JLabel(Translator.translate("fontRunSize")), var4);
        var4.gridx = 1;
        this.add(this.f, var4);
        this.h = new JButton();
        this.h.setPreferredSize(var9);
        this.h.setMaximumSize(var9);
        this.h.setBackground(this.m.getViewOptions().getBackgroundColor());
        this.h.addActionListener(this);
        var4.gridx = 0;
        var4.gridy = 3;
        this.add(new JLabel(Translator.translate("btnBackgroundColor")), var4);
        var4.gridx = 1;
        this.add(this.h, var4);
        this.i = new JButton();
        this.i.setPreferredSize(var9);
        this.i.setMaximumSize(var9);
        this.i.setBackground(this.m.getViewOptions().getFillingColor());
        this.i.addActionListener(this);
        var4.gridx = 0;
        var4.gridy = 4;
        this.add(new JLabel(Translator.translate("btnFillingColor")), var4);
        var4.gridx = 1;
        this.add(this.i, var4);
        this.j = new JButton("LC");
        this.j.setPreferredSize(var9);
        this.j.setMaximumSize(var9);
        this.j.setBackground(this.m.getViewOptions().getBackgroundColor());
        this.j.addActionListener(this);
        var4.gridx = 0;
        var4.gridy = 5;
        this.add(new JLabel(Translator.translate("btnPenColor")), var4);
        var4.gridx = 1;
        this.add(this.j, var4);
        var11 = new SpinnerNumberModel(1, 1, 10, 1);
        this.g = new JSpinner(var11);
        var10 = this.g.getPreferredSize();
        this.g.setMaximumSize(var10);
        this.g.addChangeListener(this);
        this.g.setValue(var2.getViewOptions().getLineWidth());
        var4.gridx = 0;
        var4.gridy = 6;
        this.add(new JLabel(Translator.translate("lineSize")), var4);
        var4.gridx = 1;
        this.add(this.g, var4);
        var4.gridx = 0;
        var4.gridy = 7;
        this.add(new JLabel(" "), var4);
        var4.gridx = 1;
        this.add(new JLabel(" "), var4);
        this.k = new JButton();
        this.k.setPreferredSize(var9);
        this.k.setMaximumSize(var9);
        this.k.addActionListener(this);
        var4.gridx = 0;
        var4.gridy = 8;
        this.add(new JLabel(Translator.translate("btnSaveFontAndLinePreferences")), var4);
        var4.gridx = 1;
        this.add(this.k, var4);
        this.l = new JButton();
        this.l.setPreferredSize(var9);
        this.l.setMaximumSize(var9);
        this.l.addActionListener(this);
        var4.gridx = 0;
        var4.gridy = 9;
        this.add(new JLabel(Translator.translate("btnRestoreFontAndLineDefaults")), var4);
        var4.gridx = 1;
        this.add(this.l, var4);
        this.pack();
    }

    public void actionPerformed(ActionEvent var1) {
        Object var5;
        if ((var5 = var1.getSource()) == this.comboBox) {
            this.b();
            this.a();
        } else {
            Color var6;
            if (var5 == this.h) {
                if ((var6 = JColorChooser.showDialog(this.a, Translator.translate("btnBackgroundColor"), this.m.getViewOptions().getBackgroundColor())) != null) {
                    this.h.setBackground(var6);
                    this.m.getViewOptions().setBackgroundColor(var6);
                    this.m.a(true);
                }
            } else if (var5 == this.i) {
                if ((var6 = JColorChooser.showDialog(this.a, Translator.translate("btnFillingColor"), this.m.getViewOptions().getFillingColor())) != null) {
                    this.i.setBackground(var6);
                    this.m.getViewOptions().setFillingColor(var6);
                    this.m.a(true);
                }
            } else if (var5 == this.j) {
                if ((var6 = JColorChooser.showDialog(this.a, Translator.translate("btnPenColor"), this.m.getViewOptions().getLineColor())) != null) {
                    this.j.setBackground(var6);
                    this.m.getViewOptions().setLineColor(var6);
                    this.m.a(true);
                }
            } else {
                if (var5 == this.k) {
                    try {
                        JSONObject optionsJson = this.m.getViewOptions().serialize();
                        File var11 = new File(ABFiles.getABFolder(), "ViewOptions.abopt");

                        try (FileWriter var12 = new FileWriter(var11)) {
                            JsonWriter writer = new JsonWriter(var12);
                            writer.start();
                            writer.writeKey("opt");
                            writer.writeValue(optionsJson);
                            writer.end();
                        }

                        return;
                    } catch (IOException var4) {
                        JOptionPane.showMessageDialog(this.a, Translator.translate("abpErrorWritingFile"), Translator.translate("abpErrorFileOperation"), 0);
                        return;
                    }
                }

                if (var5 == this.l) {
                    ViewOptions var7;
                    (var7 = this.m.getViewOptions()).a();
                    this.comboBox.setSelectedItem(var7.getCodeFont().getFontName());
                    this.e.setValue((int) Math.round((double) var7.getCodeFont().getSize() / GlobalVariables.getFontZoomRatio()));
                    this.f.setValue((int) Math.round((double) var7.getConsoleFont().getSize() / GlobalVariables.getFontZoomRatio()));
                    this.h.setBackground(var7.getBackgroundColor());
                    this.i.setBackground(var7.getFillingColor());
                    this.j.setBackground(var7.getBackgroundColor());
                    this.g.setValue(var7.getLineWidth());
                    this.m.a(true);
                }
            }

        }
    }

    private void a() {
        try {
            int var1 = (int) (Double.parseDouble(this.f.getValue().toString()) * GlobalVariables.getFontZoomRatio());
            Font var3 = new Font((String) this.comboBox.getSelectedItem(), Font.PLAIN, var1);
            this.m.getViewOptions().setConsoleFont(var3);
            this.m.a(true);
        } catch (Exception ignored) {
        }
    }

    private void b() {
        try {
            int var1 = (int) (Double.parseDouble(this.e.getValue().toString()) * GlobalVariables.getFontZoomRatio());
            Font var2 = new Font((String) this.comboBox.getSelectedItem(), Font.PLAIN, var1);
            this.m.getViewOptions().setCodeFont(var2);
            this.m.getViewOptions().b((var1 + 1) / 2);
            this.m.a(true);
        } catch (Exception ignored) {
        }
    }

    public void stateChanged(ChangeEvent var1) {
        Object var2;
        if ((var2 = var1.getSource()) == this.e) {
            this.b();
        } else if (var2 == this.f) {
            this.a();
        } else {
            if (var2 == this.g) {
                this.m.getViewOptions().setLineWidth(Integer.parseInt(this.g.getValue().toString()));
                this.m.a(true);
            }

        }
    }
}
