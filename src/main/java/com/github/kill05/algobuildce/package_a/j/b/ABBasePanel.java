package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.k.GlobalVariables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ABBasePanel extends JPanel implements ActionListener, MouseListener {

    protected com.github.kill05.algobuildce.package_a.c.a.b b;
    protected com.github.kill05.algobuildce.package_a.j.a.a c;
    protected boolean d = false;
    protected int e = (int) (6.0D * GlobalVariables.getFontZoomRatio());
    protected int f = (int) (6.0D * GlobalVariables.getFontZoomRatio());
    private int a = -1;
    protected boolean g = false;
    C_subclass h;

    public ABBasePanel(com.github.kill05.algobuildce.package_a.c.a.b var1, com.github.kill05.algobuildce.package_a.j.a.a var2) {
        this.b = var1;
        this.c = var2;
        this.setLayout(null);
        this.a(new Dimension(2 * this.e, 2 * this.f));
        this.addMouseListener(this);
        this.setToolTipText(null);
        this.setFont(var1.getViewOptions().getCodeFont());
        this.setOpaque(false);
    }

    public final void a(ABBasePanel var1, int var2) {
        var1.add(this, 0);
        this.a = 0;
    }

    public int b() {
        return this.a;
    }

    public String toString() {
        return "ABVFC_BasePanel ";
    }

    public final void a(Dimension var1) {
        this.setPreferredSize(var1);
        this.setMinimumSize(var1);
        this.setMaximumSize(var1);
        this.setSize(var1);
    }

    protected final void a(boolean var1) {
        if (this.f()) {
            this.g();
        }

        this.d |= var1;

        try {
            ((ABBasePanel) this.getParent()).a(this.d);
        } catch (Exception var2) {
            this.invalidate();
        }
    }

    @Override
    public void mouseClicked(MouseEvent var1) {
    }

    @Override
    public void mouseEntered(MouseEvent var1) {
        this.g = true;
        this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent var1) {
        this.g = false;
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent var1) {
    }

    @Override
    public void mouseReleased(MouseEvent var1) {
        if (var1.isPopupTrigger()) {
            this.c();
        } else {
            this.a(var1);
        }
    }

    protected void a(MouseEvent var1) {
    }

    protected void c() {
    }

    @Override
    public void actionPerformed(ActionEvent var1) {
        JOptionPane.showMessageDialog(this, "ABVFC_BasePanel - ActionPerformed - NOT IMPLEMENTED");
    }

    public boolean f() {
        return false;
    }

    protected void b(Graphics var1) {
        if (this.g) {
            var1.setColor(this.b.getViewOptions().getFillingColorSelected());
        } else {
            var1.setColor(this.b.getViewOptions().getFillingColor());
        }
    }

    protected void c(Graphics var1) {
        if (this.g) {
            var1.setColor(this.b.getViewOptions().getLineColorSelected());
        } else {
            var1.setColor(this.b.getViewOptions().getLineColor());
        }
    }

    protected void a(Graphics var1, int var2) {
        if (this.g) {
            var1.setColor(this.b.getViewOptions().getFillingColorSelected());
        } else {
            var1.setColor(this.b.getViewOptions().getFillingColor());
        }
    }

    protected void d(Graphics var1) {
        if (this.g) {
            var1.setColor(this.b.getViewOptions().getLineColorSelected());
        } else {
            var1.setColor(this.b.getViewOptions().getLineColor());
        }
    }

    @Override
    protected void paintComponent(Graphics var1) {
        super.paintComponent(var1);
        if (this.h != null) {
            this.h.a(this, var1);
        } else {
            this.a(var1);
        }
    }

    public final void g() {
        this.e = this.f = (this.b.getViewOptions().getCodeFont().getSize() + 1) / 2;
        this.setFont(this.b.getViewOptions().getCodeFont());
        if (this.h != null) {
            this.h.a(this);
        } else {
            this.a();
        }
    }

    public void a(Graphics var1) {
        ((Graphics2D) var1).setStroke(this.b.getViewOptions().getStroke());
        ((Graphics2D) var1).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void a() {
    }

    public void a(C_subclass var1) {
        this.h = var1;
        if (var1 != null) {
            var1.b(this);
        }

    }

    @Override
    public void printComponent(Graphics var1) {
        this.paintComponent(var1);
    }
}
