package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.b.ABInstructionBlock;
import com.github.kill05.algobuildce.package_a.c.b.ABWhileBlock;
import com.github.kill05.algobuildce.package_a.j.a.ABTabbedProgramPanel;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public final class WhileBlockPanel extends ABInstructionPanel {

    private final e a;
    private String[] k;
    private int[] l;
    private int m;
    private int n;
    private int o;
    private int p;

    public WhileBlockPanel(ABProgram var1, ABTabbedProgramPanel var2, ABExecutable var3) {
        super(var1, var2, var3);
        this.a(var3);
        this.a = new e(var1, var2, null);
        this.add(this.a);
        this.g();
    }

    public void drawPanel(Graphics var1) {
        int var2 = this.getWidth();
        int var3 = this.getHeight();
        int[] var4 = new int[]{var2 / 2 - this.o / 2, var2 / 2, var2 / 2 + this.o / 2, var2 / 2};
        int[] var5 = new int[]{this.p / 2 + 2 * this.centerY, 2 * this.centerY, this.p / 2 + 2 * this.centerY, this.p + 2 * this.centerY};
        this.setFillingColor(var1, 0);
        var1.fillPolygon(var4, var5, 4);
        this.setLineColor(var1);
        var1.drawPolygon(var4, var5, 4);
        this.setLineColor(var1);
        int var7 = this.centerX;
        int var8 = var2 - this.centerX;
        var1.drawLine(var2 / 2, 0, var2 / 2, 2 * this.centerY);
        var1.drawLine(var7, this.centerY, var2 / 2, this.centerY);
        int var6 = this.program.getViewOptions().m();
        var1.drawLine(var2 / 2, this.centerY, var2 / 2 - var6, this.centerY - var6);
        var1.drawLine(var2 / 2, this.centerY, var2 / 2 - var6, this.centerY + var6);
        var1.drawLine(var7, this.centerY, var7, var3 - 2 * this.centerY);
        var1.drawLine(var7, var3 - 2 * this.centerY, var2 / 2, var3 - 2 * this.centerY);
        var1.drawLine(var2 / 2, var3 - 2 * this.centerY, var2 / 2, var3 - 3 * this.centerY);
        var1.drawLine(var2 / 2, this.p + 4 * this.centerY, var2 / 2, this.p + 2 * this.centerY);
        var1.drawLine(var2 / 2 + this.o / 2, this.p / 2 + 2 * this.centerY, var8, this.p / 2 + 2 * this.centerY);
        var1.drawLine(var8, this.p / 2 + 2 * this.centerY, var8, var3 - this.centerY);
        var1.drawLine(var8, var3 - this.centerY, var2 / 2, var3 - this.centerY);
        var1.drawLine(var2 / 2, var3 - this.centerY, var2 / 2, var3);
        var3 = this.n;

        for (var7 = 0; var7 < this.k.length; ++var7) {
            var1.drawString(this.k[var7], var2 / 2 - this.l[var7] / 2, var3);
            var3 += 2 * this.centerY;
        }

        var1.drawString("F", var2 / 2 + this.o / 2 + 2, this.p / 2 + 2 * this.centerY - 2);
        var1.drawString("T", var2 / 2 + 2, this.p + 4 * this.centerY - 2);
    }

    public void a() {
        this.a.g();
        FontMetrics var1 = this.getFontMetrics(this.getFont());
        String var2 = this.executable.getDisplayName();
        this.k = var2.split("\\n");
        this.l = new int[this.k.length];
        this.m = 0;

        int var12;
        for (var12 = 0; var12 < this.k.length; ++var12) {
            this.l[var12] = var1.charsWidth(this.k[var12].toCharArray(), 0, this.k[var12].length());
            this.m = Math.max(this.m, this.l[var12]);
        }

        var12 = ((int) Math.ceil((double) this.m / (double) (2 * this.centerX)) << 1) * this.centerX;
        int var3 = (this.k.length << 1) * this.centerY;
        this.p = var3 + var12 / 2;
        this.o = this.p << 1;
        Rectangle2D var10 = var1.getStringBounds(this.k[0], this.getGraphics());
        this.n = (int) ((double) (this.p / 2 - var3 / 2 + 3 * this.centerY) - var10.getHeight() / 2.0D - var10.getY());
        int var11 = 2 * this.centerX;
        int var5 = 2 * this.centerX;
        int var6 = 4 * this.centerY;
        int var7 = 3 * this.centerY;
        int var4 = this.p + var6;
        Dimension var8 = this.a.getSize();
        int var9 = this.o;
        if (var8.getWidth() > (double) var9) {
            var9 = (int) var8.getWidth();
        }

        Dimension var13 = new Dimension(var11 + var9 + var5, (int) ((double) (this.p + var6 + var7) + var8.getHeight()));
        this.forceSize(var13);
        var11 = (int) ((double) var11 + ((double) var9 - var8.getWidth()) / 2.0D);
        this.a.setLocation(var11, var4);
        this.j = new Rectangle(this.getWidth() / 2 - var12 / 2, this.n, var12, var3);
    }

    public void a(ABExecutable var1, int var2) {
        ABInstructionPanel var3 = this.b(var1);
        this.a.a(var3, var2);
        if (this.h != null) {
            C_subclass var4 = this.h.a().a(var3);
            var3.a(var4);
        }

        var1.a(var3);
        this.g();
        this.d = true;
        this.a(this.d);
        this.revalidate();
    }

    public void a(int var1) {
        this.a.b(var1);
        this.g();
        this.a(true);
        this.revalidate();
    }

    @Override
    protected void modifyInstruction() {
        com.github.kill05.algobuildce.package_a.g.e var1 = new com.github.kill05.algobuildce.package_a.g.e((ABInstructionBlock) this.executable);
        if (com.github.kill05.algobuildce.package_a.a.j.a(this.flowChartPanel.getFrame(), (ABWhileBlock) this.executable)) {
            this.flowChartPanel.c().a(var1);
            this.program.update(true);
        }

        this.program.a((ABExecutable) null);
    }

    public e d() {
        return this.a;
    }

    @Override
    public void a(C_subclass var1) {
        super.a(var1);
        var1 = var1.a().a(this.a);
        this.a.a(var1);
    }
}
