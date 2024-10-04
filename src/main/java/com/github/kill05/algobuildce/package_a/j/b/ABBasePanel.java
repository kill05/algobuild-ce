package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.j.a.ABTabbedProgramPanel;
import com.github.kill05.algobuildce.package_a.k.GlobalVariables;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ABBasePanel extends JPanel implements ActionListener, MouseListener {

    protected ABProgram program;
    protected ABTabbedProgramPanel flowChartPanel;
    protected boolean d = false;
    protected int centerX = (int) (6.0D * GlobalVariables.getFontZoomRatio());
    protected int centerY = (int) (6.0D * GlobalVariables.getFontZoomRatio());
    private int a = -1;
    protected boolean isHovered = false;
    C_subclass h;

    public ABBasePanel(ABProgram program, ABTabbedProgramPanel flowChartPanel) {
        this.program = program;
        this.flowChartPanel = flowChartPanel;
        this.setLayout(null);
        this.forceSize(new Dimension(2 * this.centerX, 2 * this.centerY));
        this.addMouseListener(this);
        this.setToolTipText(null);
        this.setFont(program.getViewOptions().getCodeFont());
        this.setOpaque(false);
    }

    public final void a(ABBasePanel var1, int var2) {
        var1.add(this, var2);
        this.a = var2;
    }

    public int b() {
        return this.a;
    }

    public String toString() {
        return "ABVFC_BasePanel ";
    }

    public void forceSize(@Nullable Dimension size) {
        this.setPreferredSize(size);
        this.setMinimumSize(size);
        this.setMaximumSize(size);
        if (size != null) this.setSize(size);
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
        this.isHovered = true;
        this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent var1) {
        this.isHovered = false;
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

    protected void setFillingColor(Graphics var1) {
        if (this.isHovered) {
            var1.setColor(this.program.getViewOptions().getFillingColorSelected());
        } else {
            var1.setColor(this.program.getViewOptions().getFillingColor());
        }
    }

    /*
    protected void setLineColor1(Graphics var1) {
        if (this.isHovered) {
            var1.setColor(this.program.getViewOptions().getLineColorSelected());
        } else {
            var1.setColor(this.program.getViewOptions().getLineColor());
        }
    }
     */

    protected void setFillingColor(Graphics var1, int var2) {
        if (this.isHovered) {
            var1.setColor(this.program.getViewOptions().getFillingColorSelected());
        } else {
            var1.setColor(this.program.getViewOptions().getFillingColor());
        }
    }

    protected void setLineColor(Graphics var1) {
        if (this.isHovered) {
            var1.setColor(this.program.getViewOptions().getLineColorSelected());
        } else {
            var1.setColor(this.program.getViewOptions().getLineColor());
        }
    }

    @Override
    protected void paintComponent(Graphics var1) {
        super.paintComponent(var1);

        if (this.h != null) {
            this.h.a(this, var1);
        } else {
            this.drawPanel(var1);
        }
    }

    public final void g() {
        this.centerX = this.centerY = (this.program.getViewOptions().getCodeFont().getSize() + 1) / 2;
        this.setFont(this.program.getViewOptions().getCodeFont());
        if (this.h != null) {
            this.h.a(this);
        } else {
            this.a();
        }
    }

    public void drawPanel(Graphics var1) {
        ((Graphics2D) var1).setStroke(this.program.getViewOptions().getStroke());
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
