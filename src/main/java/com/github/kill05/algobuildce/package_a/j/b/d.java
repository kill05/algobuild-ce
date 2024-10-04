package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.b.ABInstructionBlock;
import com.github.kill05.algobuildce.package_a.c.b.ABCommentBlock;
import com.github.kill05.algobuildce.package_a.g.e;
import com.github.kill05.algobuildce.package_a.j.a.ABTabbedProgramPanel;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public final class d extends ABInstructionPanel {
    private String[] a;
    private int[] k;
    private int l;
    private int m;
    private int n;
    private int o;

    public d(ABProgram var1, ABTabbedProgramPanel var2, ABExecutable var3) {
        super(var1, var2, var3);
        var3.a(this);
        this.g();
    }

    @Override
    public void drawPanel(Graphics var1) {
        int var2 = this.getWidth();
        int var3 = this.getHeight();
        int[] var4 = new int[]{var2 / 2 - this.n / 2, var2 / 2 + this.n / 2 - 2 * this.centerX, var2 / 2 + this.n / 2, var2 / 2 + this.n / 2, var2 / 2 - this.n / 2};
        int[] var5 = new int[]{this.centerY, this.centerY, this.centerY + 2 * this.centerY, this.centerY + this.o, this.centerY + this.o};
        this.setFillingColor(var1);
        var1.fillPolygon(var4, var5, 5);
        this.setLineColor(var1);
        var1.drawPolygon(var4, var5, 5);
        var1.drawLine(var2 / 2 + this.n / 2 - 2 * this.centerX, this.centerY, var2 / 2 + this.n / 2 - 2 * this.centerX, 3 * this.centerY);
        var1.drawLine(var2 / 2 + this.n / 2 - 2 * this.centerX, 3 * this.centerY, var2 / 2 + this.n / 2, 3 * this.centerY);
        var1.drawLine(var2 / 2, 0, var2 / 2, this.centerY);
        var1.drawLine(var2 / 2, var3 - this.centerY, var2 / 2, var3);
        var3 = this.m;

        for (int var6 = 0; var6 < this.a.length; ++var6) {
            var1.drawString(this.a[var6], var2 / 2 - this.k[var6] / 2, var3);
            var3 += 2 * this.centerY;
        }

    }

    @Override
    public void a() {
        String var1 = this.executable.getDisplayName();
        FontMetrics var2 = this.getFontMetrics(this.getFont());
        this.a = var1.split("\\n");
        this.k = new int[this.a.length];
        this.l = 0;
        Rectangle2D var3 = var2.getStringBounds(this.a[0], this.getGraphics());
        this.m = (int) ((double) (3 * this.centerY) - var3.getHeight() / 2.0 - var3.getY());

        for (int var4 = 0; var4 < this.a.length; ++var4) {
            this.k[var4] = var2.charsWidth(this.a[var4].toCharArray(), 0, this.a[var4].length());
            this.l = Math.max(this.l, this.k[var4]);
        }

        this.n = (4 + ((int) Math.ceil((double) this.l / (double) (2 * this.centerX)) << 1)) * this.centerX;
        this.o = (this.a.length + 1 << 1) * this.centerY;
        Dimension var5 = new Dimension(this.n + 2 * this.centerX, this.o + 2 * this.centerY);
        this.forceSize(var5);
        this.j = new Rectangle(this.getWidth() / 2 - this.n / 2, this.centerY, this.n, this.o);
    }

    @Override
    protected void modifyInstruction() {
        e var1 = new com.github.kill05.algobuildce.package_a.g.e((ABInstructionBlock) this.executable);
        if (com.github.kill05.algobuildce.package_a.a.d.a(this.flowChartPanel.getFrame(), (ABCommentBlock) this.executable)) {
            this.flowChartPanel.c().a(var1);
            this.program.update(true);
        }

        this.program.a((ABExecutable) null);
    }
}

