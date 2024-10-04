package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutionFragment;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.b.ABBaseCallInstructionBlock;
import com.github.kill05.algobuildce.package_a.c.b.c;
import com.github.kill05.algobuildce.package_a.c.b.ABInstructionBlock;
import com.github.kill05.algobuildce.package_a.g.e;
import com.github.kill05.algobuildce.package_a.j.a.ABTabbedProgramPanel;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Vector;

public final class b extends ABInstructionPanel {
    private int a;
    private int k;
    private int l;
    private int m;
    private String n;

    public b(ABProgram var1, ABTabbedProgramPanel var2, ABExecutable var3) {
        super(var1, var2, var3);
        var3.a(this);
        this.g();
    }

    @Override
    public void drawPanel(Graphics var1) {
        int var2 = this.getWidth();
        int var3 = this.getHeight();
        this.setFillingColor(var1);
        var1.fillRect(var2 / 2 - this.l / 2, this.centerY, this.l, this.m);
        this.setLineColor(var1);
        var1.drawRect(var2 / 2 - this.l / 2, this.centerY, this.l, this.m);
        var1.drawLine(var2 / 2 - this.l / 2 + this.centerX, this.centerY, var2 / 2 - this.l / 2 + this.centerX, this.m + this.centerY);
        var1.drawLine(var2 / 2 + this.l / 2 - this.centerX, this.centerY, var2 / 2 + this.l / 2 - this.centerX, this.m + this.centerY);
        var1.drawLine(var2 / 2, 0, var2 / 2, this.centerY);
        var1.drawLine(var2 / 2, var3 - this.centerY, var2 / 2, var3);
        var3 = this.k;
        var1.drawString(this.n, var2 / 2 - this.a / 2, var3);
    }

    @Override
    public void a() {
        ABBaseCallInstructionBlock var1;
        Vector var2 = (var1 = (ABBaseCallInstructionBlock) this.executable).k();
        this.n = var1.j() + "(";
        FontMetrics var5 = this.getFontMetrics(this.getFont());
        int var3 = var2.size();

        for (int var4 = 0; var4 < var3; ++var4) {
            if (var4 == 0) {
                this.n = this.n + var2.elementAt(var4);
            } else {
                this.n = this.n + ", " + var2.elementAt(var4);
            }
        }

        this.n = this.n + ")";
        String var6;
        if (this.executable instanceof c && (var6 = ((c) this.executable).l()) != null && var6.length() > 0) {
            this.n = var6 + " = " + this.n;
        }

        this.a = 0;
        Rectangle2D var8 = var5.getStringBounds(this.n, this.getGraphics());
        this.a = var5.charsWidth(this.n.toCharArray(), 0, this.n.length());
        this.k = (int) ((double) (3 * this.centerY) - var8.getHeight() / 2.0 - var8.getY());
        this.l = (4 + ((int) Math.ceil((double) this.a / (double) (2 * this.centerX)) << 1)) * this.centerX;
        this.m = 4 * this.centerY;
        Dimension var7 = new Dimension(this.l + 2 * this.centerX, this.m + 2 * this.centerY);
        this.forceSize(var7);
        this.j = new Rectangle(this.getWidth() / 2 - this.l / 2, this.centerY, this.l, this.m);
    }

    public void a(ABExecutable executable, boolean var2) {
        super.a(executable, var2);
        String var3;
        ABExecutionFragment var4;
        int var5;
        if (!var2 && (var4 = this.program.getNextFragment()) != null && var4.d() == this.executable && var4.c() == 1 && (var5 = (var3 = executable.c()).indexOf(46)) > 0) {
            var3 = var3.substring(0, var5);
            this.flowChartPanel.c().h(var3);
        }

    }

    @Override
    protected void modifyInstruction() {
        e var1 = new e((ABInstructionBlock) this.executable);
        if (com.github.kill05.algobuildce.package_a.a.b.a(this.flowChartPanel.getFrame(), (c) this.executable, this.program)) {
            this.flowChartPanel.c().a(var1);
            this.program.update(true);
        }

        this.program.a((ABExecutable) null);
    }
}
