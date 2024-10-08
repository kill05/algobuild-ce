package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.b.ABForBlock;
import com.github.kill05.algobuildce.package_a.c.b.ABInstructionBlock;
import com.github.kill05.algobuildce.package_a.j.a.ABTabbedProgramPanel;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public final class h extends ABInstructionPanel {
    private final e a;
    private String[] k;
    private int[] l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;

    public h(ABProgram var1, ABTabbedProgramPanel var2, ABExecutable var3) {
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
        int[] var4 = new int[]{var2 / 2 - this.o, var2 / 2 - this.p, var2 / 2 + this.p, var2 / 2 + this.o, var2 / 2 + this.p, var2 / 2 - this.p};
        int[] var5 = new int[]{this.q / 2 + 2 * this.centerY, 2 * this.centerY, 2 * this.centerY, this.q / 2 + 2 * this.centerY, this.q + 2 * this.centerY, this.q + 2 * this.centerY};
        this.setFillingColor(var1);
        var1.fillPolygon(var4, var5, 6);
        this.setLineColor(var1);
        var1.drawPolygon(var4, var5, 6);
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
        var1.drawLine(var2 / 2, this.q + 4 * this.centerY, var2 / 2, this.q + 2 * this.centerY);
        var1.drawLine(var2 / 2 + this.o, this.q / 2 + 2 * this.centerY, var8, this.q / 2 + 2 * this.centerY);
        var1.drawLine(var8, this.q / 2 + 2 * this.centerY, var8, var3 - this.centerY);
        var1.drawLine(var8, var3 - this.centerY, var2 / 2, var3 - this.centerY);
        var1.drawLine(var2 / 2, var3 - this.centerY, var2 / 2, var3);
        if (this.executable.getDisplayName() != null) {
            var3 = this.n;

            for (var7 = 0; var7 < this.k.length; ++var7) {
                var1.drawString(this.k[var7], var2 / 2 - this.l[var7] / 2, var3);
                var3 += 2 * this.centerY;
            }
        }

        var1.drawString("F", var2 / 2 + this.o + 2, this.q / 2 + 2 * this.centerY - 2);
        var1.drawString("T", var2 / 2 + 2, this.q + 4 * this.centerY - 2);
    }

    @Override
    public void a() {
        String var1 = this.executable.getDisplayName();
        this.a.g();
        FontMetrics var2 = this.getFontMetrics(this.getFont());
        this.k = var1.split("\\\\n");
        this.l = new int[this.k.length];
        this.m = 0;
        Rectangle2D var9 = var2.getStringBounds(this.k[0], this.getGraphics());
        this.n = (int) ((double) (4 * this.centerY) - var9.getHeight() / 2.0D - var9.getY());

        int var10;
        for (var10 = 0; var10 < this.k.length; ++var10) {
            this.l[var10] = var2.charsWidth(this.k[var10].toCharArray(), 0, this.k[var10].length());
            this.m = Math.max(this.m, this.l[var10]);
        }

        var10 = (2 + ((int) Math.ceil((double) this.m / (double) (2 * this.centerX)) << 1)) * this.centerX;
        this.q = (this.k.length + 1 << 1) * this.centerY;
        this.p = var10 / 2;
        this.o = this.p + this.q / 2;
        int var11 = 2 * this.centerX;
        int var4 = 2 * this.centerX;
        int var5 = 4 * this.centerY;
        int var6 = 3 * this.centerY;
        int var3 = this.q + var5;
        Dimension var7 = this.a.getSize();
        int var8 = this.o << 1;
        if (var7.getWidth() > (double) var8) {
            var8 = (int) var7.getWidth();
        }

        this.forceSize(new Dimension(var11 + var8 + var4, (int) ((double) (this.q + var5 + var6) + var7.getHeight())));
        var11 = (int) ((double) var11 + ((double) var8 - var7.getWidth()) / 2.0D);
        this.a.setLocation(var11, var3);
        this.j = new Rectangle(this.getWidth() / 2 - var10 / 2, 2 * this.centerY, var10, (this.k.length + 1 << 1) * this.centerY);
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
        this.d = true;
        this.a(this.d);
        this.revalidate();
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
        if (com.github.kill05.algobuildce.package_a.a.e.a(this.flowChartPanel.getFrame(), (ABForBlock) this.executable)) {
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
