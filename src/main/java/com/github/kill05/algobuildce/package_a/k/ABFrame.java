package com.github.kill05.algobuildce.package_a.k;

import com.github.kill05.algobuildce.package_a.j.a.g;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;

public final class ABFrame extends JFrame implements WindowListener {
    private c a;
    private g b;
    private JToolBar c = null;

    @Override
    public void setJMenuBar(JMenuBar var1) {
        super.setJMenuBar(var1);
    }

    public void a(JToolBar var1) {
        if (this.c != null) {
            this.remove(this.c);
        }

        this.c = var1;
        if (var1 != null) {
            this.add(var1, "First");
        }

    }

    public ABFrame() {
        ABFrame var1 = this;
        this.addWindowListener(this);
        JLabel var2;
        (var2 = new JLabel()).setBackground(GlobalVariables.color);
        var2.setOpaque(true);
        var2.setHorizontalAlignment(0);
        var2.setLayout(new BorderLayout());
        this.setContentPane(var2);
        this.setDefaultCloseOperation(0);

        try {
            URL var3 = ClassLoader.getSystemClassLoader().getResource("imgs/logo2_arancio_small.png");
            Image var6 = Toolkit.getDefaultToolkit().getImage(var3);
            var2.setIcon(new ImageIcon(var6));
        } catch (Exception var5) {
        }

        try {
            ImageIcon var7 = com.github.kill05.algobuildce.package_a.i.b.a("imgs/AlgoBuildIcon.png");
            var1.setIconImage(var7.getImage());
        } catch (Exception var4) {
        }
    }

    public void a(c var1) {
        this.a = var1;
    }

    @Override
    public void windowActivated(WindowEvent var1) {
    }

    @Override
    public void windowClosed(WindowEvent var1) {
    }

    @Override
    public void windowClosing(WindowEvent var1) {
        this.a.h();
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

    public void a(g var1) {
        JComponent var2 = (JComponent) this.getContentPane();
        if (this.b != null) {
            var2.remove(this.b);
        }

        this.b = var1;
        var2.add(var1, "Center");
        var1.a(this);
        var2.doLayout();
        var2.updateUI();
        var1.b(1);
    }

    public g a() {
        return this.b;
    }

    public boolean b() {
        return this.b != null;
    }
}

