package com.github.kill05.algobuildce.package_a.j.a;

import com.github.kill05.algobuildce.package_a.i.ImageUtils;
import com.github.kill05.algobuildce.package_a.i.Translator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public final class VariableInputDialog extends JDialog implements ActionListener {

    private JButton runButton;
    private JButton pauseButton;
    private JTextField c = new JTextField();
    private String d = null;

    public VariableInputDialog(Window var1, String var2) {
        super((Frame) var1, Translator.translate("abvDialogInputVariable"), true);
        Point var7;
        (var7 = MouseInfo.getPointerInfo().getLocation()).translate(15, 15);
        this.setLocation(var7);
        ImageIcon runIcon = ImageUtils.loadImage("imgs/run_icon.gif");
        ImageIcon pauseIcon = ImageUtils.loadImage("imgs/pause_icon.gif");
        //ImageIcon[] var10000 = new ImageIcon[]{runIcon, pauseIcon};
        this.runButton = new JButton(runIcon);
        this.pauseButton = new JButton(pauseIcon);
        JPanel var10;
        (var10 = new JPanel()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        var10.setLayout(new BorderLayout(10, 10));
        JPanel var12;
        (var12 = new JPanel()).setLayout(new GridLayout(1, 2, 10, 10));
        this.c.setText("CIAOCIAOCIAOCIAOCIAO");
        var10.add(this.c);
        this.runButton.addActionListener(this);
        this.pauseButton.addActionListener(this);
        e var5 = new e(this);
        f var6 = new f(this);
        this.c.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(27, 0), var5);
        this.c.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(120, 0), var6);
        var10.add(new JLabel(var2), "North");
        var10.add(this.c, "Center");
        var12.add(this.runButton);
        var12.add(this.pauseButton);
        var10.add(var12, "South");
        this.setContentPane(var10);
        this.setResizable(false);
        this.pack();
        this.c.setText("");
        Dimension var8 = Toolkit.getDefaultToolkit().getScreenSize();
        Insets var11 = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
        int var13 = (int) var8.getWidth();
        int var9 = (int) var8.getHeight();
        Dimension var14 = this.getSize();
        if (var7.x + var14.width > var13 - var11.right) {
            var7.x -= var7.x + var14.width - var13 + var11.right + 1;
        }

        if (var7.y + var14.height > var9 - var11.bottom) {
            var7.y -= var7.y + var14.height - var9 + var11.bottom + 1;
        }

        this.setLocation(var7);
        this.getRootPane().setDefaultButton(this.runButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.runButton) {
            this.d = this.c.getText();
            this.setVisible(false);
        } else {
            if (var1.getSource() == this.pauseButton) {
                this.d = null;
                this.setVisible(false);
            }

        }
    }

    public final String a() {
        return this.d;
    }

    // $FF: synthetic method
    static void a(VariableInputDialog var0, String var1) {
        var0.d = var1;
    }

    // $FF: synthetic method
    static JTextField a(VariableInputDialog var0) {
        return var0.c;
    }
}
