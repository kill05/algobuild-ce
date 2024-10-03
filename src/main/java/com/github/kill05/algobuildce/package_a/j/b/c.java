package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutionFragment;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.b.q;
import com.github.kill05.algobuildce.package_a.i.Translator;
import com.github.kill05.algobuildce.package_a.j.a.ABFlowChartPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public final class c extends ABInstructionPanel {
    e a;
    private String k;
    private String l;
    private Rectangle m;

    public void a(Rectangle var1) {
        this.m = var1;
    }

    public c(ABProgram var1, ABFlowChartPanel var2, ABExecutable var3) {
        super(var1, var2, var3);
        this.a(var3);
        this.setOpaque(true);
        this.a = new e(var1, var2, null);
        this.add(this.a);
        this.a.g();
        this.g();
        this.a(this.d);
        this.revalidate();
        int var4;
        if ((var4 = ((com.github.kill05.algobuildce.package_a.c.b.q)var3).m()) != 3 && var4 != 2) {
            this.setToolTipText(null);
        } else {
            this.setToolTipText("clic Modifica / Copia / Taglia");
        }
    }

    public void drawPanel(Graphics var1) {
        super.drawPanel(var1);
        this.executable.b();
        Dimension var2;
        int var3 = (int)(var2 = this.getPreferredSize()).getWidth();
        int var8 = (int)var2.getHeight();
        int var4 = this.getWidth();
        int var5 = this.getHeight();
        var1.setColor(this.program.getViewOptions().getBackgroundColor());
        var1.fillRect(0, 0, var4, var5);
        this.setFillingColor(var1, 0);
        var1.fillOval(var3 / 2 - 10 * this.e, this.f, 20 * this.e, 4 * this.f - 1);
        this.setLineColor(var1);
        String var9 = this.k;
        FontMetrics var10 = var1.getFontMetrics();
        var1.drawOval(var3 / 2 - 10 * this.e, this.f, 20 * this.e, 4 * this.f - 1);
        var1.drawLine(var3 / 2, 5 * this.f, var3 / 2, 6 * this.f);
        Rectangle2D var6;
        int var7 = (int)((var6 = var10.getStringBounds(var9, var1)).getWidth() / 2.0);
        int var11 = (int)Math.round(-var6.getHeight() / 2.0 - var6.getY());
        var7 = var3 / 2 - var7;
        var11 += 3 * this.f;
        var1.drawString(var9, var7, var11);
        this.setFillingColor(var1, 1);
        var1.fillOval(var3 / 2 - 10 * this.e, var8 - 5 * this.f, 20 * this.e, 4 * this.f - 1);
        this.setLineColor(var1);
        var9 = this.l;
        var1.drawLine(var3 / 2, var8 - 6 * this.f, var3 / 2, var8 - 5 * this.f);
        var1.drawOval(var3 / 2 - 10 * this.e, var8 - 5 * this.f, 20 * this.e, 4 * this.f);
        var7 = (int)((var6 = var10.getStringBounds(var9, var1)).getWidth() / 2.0);
        var11 = (int)Math.round(-var6.getHeight() / 2.0 - var6.getY());
        var7 = var3 / 2 - var7;
        var11 += var8 - 3 * this.f;
        var1.drawString(var9, var7, var11);
    }

    public void a() {
        com.github.kill05.algobuildce.package_a.c.b.q var1;
        int var2;
        if ((var1 = (com.github.kill05.algobuildce.package_a.c.b.q)this.executable).m() == 2) {
            this.k = "PROC " + var1.j() + "(";

            for(var2 = 0; var2 < var1.k(); ++var2) {
                if (var2 > 0) {
                    this.k = this.k + ", ";
                }

                this.k = this.k + var1.e(var2);
            }

            this.k = this.k + ")";
            this.l = "RET";
        } else if (var1.m() == 3) {
            this.k = "FUNC " + var1.j() + "(";

            for(var2 = 0; var2 < var1.k(); ++var2) {
                if (var2 > 0) {
                    this.k = this.k + ", ";
                }

                this.k = this.k + var1.e(var2);
            }

            this.k = this.k + ")";
            this.l = "RET " + var1.l();
        } else {
            this.k = "START " + var1.j();
            this.l = "END";
        }

        Dimension var5 = new Dimension(22 * this.e, 12 * this.f);
        this.a.g();
        Dimension var3 = this.a.getMinimumSize();
        var5.width = Math.max(var5.width, var3.width);
        var5.height += var3.height;
        this.a(var5);
        int var4 = (int)(var5.getWidth() - var3.getWidth()) / 2;
        this.a.setLocation(var4, 6 * this.f);
        this.j = new Rectangle(var4, this.f, 20 * this.e, 4 * this.f);
        this.m = new Rectangle(var4, var5.height - 5 * this.f, 20 * this.e, 4 * this.f);
        this.revalidate();
    }

    public void a(ABExecutable var1, int var2) {
        ABInstructionPanel var3 = this.b(var1);
        if (this.h != null) {
            C_subclass var4 = this.h.a().a(var3);
            var3.a(var4);
        }

        this.a.a(var3, var2);
        var1.a(var3);
        this.g();
        this.d = true;
        this.a(this.d);
        this.revalidate();
    }

    public void a(int var1) {
        this.a.b(var1);
        this.g();
        this.invalidate();
    }

    public void a(ABExecutable var1, boolean var2) {
        super.a(var1, var2);
        ABExecutionFragment var3;
        if (!var2 && (var3 = this.program.getNextFragment()) != null && var3.d() == this.executable && var3.c() == 0) {
            String var4 = ((q)this.executable).j();
            this.flowChartPanel.c().h(var4);
        }

    }

    @Override
    protected void b_() {
        ABExecutable var1 = null;
        ABExecutionFragment var2;
        if ((var2 = this.program.getNextFragment()) != null) {
            var1 = this.program.getNextFragment().d();
        }

        if (var1 == null) {
            if (this.program.j() != this.executable || this.j == null) {
                return;
            }
        } else if (var1 == this.executable && var2.c() == 1) {
            this.scrollRectToVisible(this.m);
            return;
        }

        this.scrollRectToVisible(this.j);
    }

    @Override
    public void a(MouseEvent var1) {
        if (((q)this.executable).m() != 1) {
            JPopupMenu var2 = new JPopupMenu();
            JMenuItem var3;
            (var3 = new JMenuItem(Translator.translate("instructionModify"))).addActionListener(this);
            var2.add(var3);
            var2.addSeparator();
            (var3 = new JMenuItem(Translator.translate("codeDuplicate"))).addActionListener(this);
            var2.add(var3);
            (var3 = new JMenuItem(Translator.translate("codeDelete"))).addActionListener(this);
            var2.add(var3);
            var2.show(var1.getComponent(), var1.getX(), var1.getY());
        }

    }

    @Override
    public void actionPerformed(ActionEvent var1) {
        String var2;
        if ((var2 = var1.getActionCommand()) != null && !var2.isEmpty()) {
            if (var2.equals(Translator.translate("instructionModify"))) {
                this.modifyInstruction();
                return;
            }

            if (var2.equals(Translator.translate("codeDuplicate"))) {
                JOptionPane.showMessageDialog(this.flowChartPanel.getFrame(), "TO DO!");
                return;
            }

            if (var2.equals(Translator.translate("codeDelete"))) {
                com.github.kill05.algobuildce.package_a.g.c var3 = new com.github.kill05.algobuildce.package_a.g.c(this.program, (q)this.executable);
                this.program.b(((q)this.executable).j());
                this.flowChartPanel.c().a(var3);
            }
        }

    }

    @Override
    protected void modifyInstruction() {
        if (((q)this.executable).m() != 1) {
            com.github.kill05.algobuildce.package_a.g.d var1 = new com.github.kill05.algobuildce.package_a.g.d(this.program, (q)this.executable);
            if (com.github.kill05.algobuildce.package_a.a.c.a(this.flowChartPanel.getFrame(), (q)this.executable, this.program)) {
                this.flowChartPanel.c().a(var1);
                this.program.update(true);
            }

            this.program.a((ABExecutable)null);
        }

    }

    @Override
    public void a(C_subclass var1) {
        super.a(var1);
        var1 = var1.a().a(this.a);
        this.a.a(var1);
    }
}

