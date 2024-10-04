package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.b.ABDoWhileBlock;
import com.github.kill05.algobuildce.package_a.c.b.ABInstructionBlock;
import com.github.kill05.algobuildce.package_a.j.a.ABTabbedProgramPanel;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public final class g extends ABInstructionPanel {
    private final e a;
    private String[] k;
    private int[] l;
    private int m;
    private int n;
    private int o;
    private int p;

    public g(ABProgram var1, ABTabbedProgramPanel var2, ABExecutable var3) {
        super(var1, var2, var3);
        this.a(var3);
        this.a = new e(var1, var2, null);
        this.add(this.a);
        this.g();
    }

    @Override
    public void drawPanel(Graphics var1) {
        int var2 = this.getWidth();
        int var3 = this.getHeight();
        this.setLineColor(var1);
        var1.drawString("do", var2 / 2 + 2, 2 * this.centerY - 2);
        var1.drawLine(var2 / 2, 0, var2 / 2, 2 * this.centerY);
        int[] var4 = new int[]{var2 / 2 - this.n / 2, var2 / 2, var2 / 2 + this.n / 2, var2 / 2};
        int[] var5 = new int[]{var3 - (this.o / 2 + 2 * this.centerY), var3 - (this.o + 2 * this.centerY), var3 - (this.o / 2 + 2 * this.centerY), var3 - 2 * this.centerY};
        this.setFillingColor(var1, 1);
        var1.fillPolygon(var4, var5, 4);
        this.setLineColor(var1);
        var1.drawPolygon(var4, var5, 4);
        int var6 = this.centerX;
        int var7 = this.program.getViewOptions().m();
        var1.drawLine(var6, this.centerY, var2 / 2, this.centerY);
        var1.drawLine(var2 / 2, this.centerY, var2 / 2 - var7, this.centerY - var7);
        var1.drawLine(var2 / 2, this.centerY, var2 / 2 - var7, this.centerY + var7);
        var1.drawLine(var6, this.centerY, var6, var3 - (this.o / 2 + 2 * this.centerY));
        var1.drawLine(var6, var3 - (this.o / 2 + 2 * this.centerY), var2 / 2 - this.n / 2, var3 - (this.o / 2 + 2 * this.centerY));
        var1.drawLine(var2 / 2, var3 - 2 * this.centerY, var2 / 2, var3);
        var6 = var3 - this.p - 2 * this.centerY;

        for (var7 = 0; var7 < this.k.length; ++var7) {
            var1.drawString(this.k[var7], var2 / 2 - this.l[var7] / 2, var6);
            var6 += 2 * this.centerY;
        }

        var6 = var1.getFontMetrics().charsWidth("T".toCharArray(), 0, 1);
        var1.drawString("F", var2 / 2 + 2, var3 - 2);
        var1.drawString("T", var2 / 2 - this.n / 2 - var6 + 2, var3 - (this.o / 2 + 2 * this.centerY) - 2);
    }

    @Override
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
        this.o = var3 + var12 / 2;
        this.n = this.o << 1;
        Rectangle2D var10 = var1.getStringBounds(this.k[0], this.getGraphics());
        this.p = (int) ((double) (this.o / 2 + var3 / 2 - this.centerY) + var10.getHeight() / 2.0D + var10.getY());
        int var11 = 2 * this.centerX;
        int var5 = 2 * this.centerX;
        int var6 = 2 * this.centerY;
        int var7 = 2 * this.centerY;
        Dimension var8 = this.a.getSize();
        int var9 = this.n;
        if (var8.getWidth() > (double) var9) {
            var9 = (int) var8.getWidth();
        }

        this.forceSize(new Dimension(var11 + var9 + var5, (int) ((double) (this.o + var6 + var7) + var8.getHeight())));
        var11 = (int) ((double) var11 + ((double) var9 - var8.getWidth()) / 2.0D);
        this.a.setLocation(var11, var6);
        this.j = new Rectangle(this.getWidth() / 2 - var12 / 2, this.getHeight() - this.p, var12, var3);
    }

    @Override
    public void a(ABExecutable var1, int var2) {
        ABInstructionPanel var3 = this.b(var1);
        this.a.a(var3, var2);
        if (this.h != null) {
            C_subclass var4 = this.h.a().a(var3);
            var3.a(var4);
        }

        var1.a(var3);
        this.g();
        this.revalidate();
        this.d = true;
        this.a(this.d);
    }

    @Override
    public void a(int var1) {
        this.a.b(var1);
        this.g();
        this.a(true);
        this.invalidate();
    }

    @Override
    protected void modifyInstruction() {
        com.github.kill05.algobuildce.package_a.g.e var1 = new com.github.kill05.algobuildce.package_a.g.e((ABInstructionBlock) this.executable);
        com.github.kill05.algobuildce.package_a.a.f.a(this.flowChartPanel.getFrame(), (ABDoWhileBlock) this.executable);
        this.flowChartPanel.c().a(var1);
        this.program.update(true);
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
