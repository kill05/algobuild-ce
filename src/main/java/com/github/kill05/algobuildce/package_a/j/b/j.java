package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.j.a.ABTabbedProgramPanel;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class j extends ABInstructionPanel {

    private String[] a;
    private int[] k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private String q = "I/O";

    public j(ABProgram var1, ABTabbedProgramPanel var2, ABExecutable var3) {
        super(var1, var2, var3);
        this.a(var3);
        this.g();
    }

    public final void a(String var1) {
        this.q = var1;
    }

    @Override
    public final void drawPanel(Graphics var1) {
        int width = this.getWidth();
        int height = this.getHeight();
        int[] var4 = new int[]{width / 2 - this.o, width / 2 + this.n, width / 2 + this.o, width / 2 - this.n};
        int[] var5 = new int[]{this.centerY, this.centerY, this.centerY + this.p, this.centerY + this.p};
        this.setFillingColor(var1);
        var1.fillPolygon(var4, var5, 4);
        this.setLineColor(var1);
        var1.drawPolygon(var4, var5, 4);
        var1.drawLine(width / 2, 0, width / 2, this.centerY);
        var1.drawLine(width / 2, height - this.centerY, width / 2, height);
        String var6 = this.q;
        int var7 = this.centerY + this.p;
        int var8 = width / 2 - this.n + this.centerX;
        var1.drawString(var6, var8 + this.program.getViewOptions().getLineStroke(), var7 - this.program.getViewOptions().getLineStroke());
        var7 = this.m;

        for (var8 = 0; var8 < this.a.length; ++var8) {
            var1.drawString(this.a[var8], width / 2 - this.k[var8] / 2, var7);
            var7 += 2 * this.centerY;
        }

    }

    @Override
    public void a() {
        String var1 = ((com.github.kill05.algobuildce.package_a.c.b.k) this.executable).k();
        this.a = var1.split("\\n");
        this.k = new int[this.a.length];
        FontMetrics var4 = this.getFontMetrics(this.getFont());
        this.l = 0;
        Rectangle2D var2 = var4.getStringBounds(this.a[0], this.getGraphics());
        this.m = (int) ((double) (3 * this.centerY) - var2.getHeight() / 2.0D - var2.getY());
        this.p = (this.a.length + 1 << 1) * this.centerY;

        int var5;
        for (var5 = 0; var5 < this.a.length; ++var5) {
            this.k[var5] = var4.charsWidth(this.a[var5].toCharArray(), 0, this.a[var5].length());
            int var3 = this.k[var5];
            if (var5 == this.a.length - 1) {
                var3 += 2 * (var4.charsWidth(this.q.toCharArray(), 0, this.q.length()) - this.p / 2 + this.centerX);
            }

            this.l = Math.max(this.l, var3);
        }

        var5 = this.l + 2 * this.centerX;
        this.o = var5 / 2;
        this.n = this.o + this.p / 2;
        this.forceSize(new Dimension((this.n << 1) + 2 * this.centerX, this.p + 2 * this.centerY));
        this.j = new Rectangle(this.getWidth() / 2 - var5 / 2, this.centerY, var5, this.p);
    }
}
