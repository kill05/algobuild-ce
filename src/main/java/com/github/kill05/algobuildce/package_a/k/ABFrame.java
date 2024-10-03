package com.github.kill05.algobuildce.package_a.k;

import com.github.kill05.algobuildce.package_a.i.ImageUtils;
import com.github.kill05.algobuildce.package_a.j.a.ABProgramPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;

public final class ABFrame extends JFrame implements WindowListener {

    private ABFrameHolder frameHolder;
    private ABProgramPanel programPanel;
    private JToolBar toolBar = null;

    @Override
    public void setJMenuBar(JMenuBar var1) {
        super.setJMenuBar(var1);
    }

    public void setToolBar(JToolBar toolBar) {
        if (this.toolBar != null) {
            this.remove(this.toolBar);
        }

        this.toolBar = toolBar;
        if (toolBar != null) {
            this.add(toolBar, "First");
        }

    }

    public ABFrame() {
        this.addWindowListener(this);
        JLabel label = new JLabel();
        label.setBackground(GlobalVariables.color);
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setLayout(new BorderLayout());
        this.setContentPane(label);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        try {
            URL var3 = ClassLoader.getSystemClassLoader().getResource("imgs/logo2_arancio_small.png");
            Image var6 = Toolkit.getDefaultToolkit().getImage(var3);
            label.setIcon(new ImageIcon(var6));
        } catch (Exception ignored) {
        }

        try {
            ImageIcon var7 = ImageUtils.loadImage("imgs/AlgoBuildIcon.png");
            this.setIconImage(var7.getImage());
        } catch (Exception ignored) {
        }
    }

    public void setFrameHolder(ABFrameHolder holder) {
        this.frameHolder = holder;
    }

    @Override
    public void windowActivated(WindowEvent var1) {
    }

    @Override
    public void windowClosed(WindowEvent var1) {
    }

    @Override
    public void windowClosing(WindowEvent var1) {
        this.frameHolder.onClose();
    }

    @Override
    public void windowDeactivated(WindowEvent var1) {
    }

    @Override
    public void windowDeiconified(WindowEvent var1) {
    }

    @Override
    public void windowIconified(WindowEvent var1) {
    }

    @Override
    public void windowOpened(WindowEvent var1) {
    }

    public void setProgramPanel(ABProgramPanel programPanel) {
        JComponent contentPane = (JComponent) this.getContentPane();
        if (this.programPanel != null) {
            contentPane.remove(this.programPanel);
        }

        this.programPanel = programPanel;
        contentPane.add(programPanel, "Center");
        programPanel.a(this);
        contentPane.doLayout();
        contentPane.updateUI();
        programPanel.b(1);
    }

    public ABProgramPanel getProgramPanel() {
        return this.programPanel;
    }

    public boolean hasProgramPanel() {
        return this.programPanel != null;
    }
}

