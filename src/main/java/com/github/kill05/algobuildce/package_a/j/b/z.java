package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.b.ABOutputBlock;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

public final class z extends C_subclass {
    private String[] b;
    private int[] c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private String j = "INPUT ";

    public z(p var1, D_subclass var2) {
        super(var2);
    }

    @Override
    public void a(ABBasePanel var1, Graphics var2) {
        int var3 = var1.getWidth();
        var1.getHeight();
        var1.setFillingColor(var2);
        var2.fillRect(0, 0, var3, this.e);
        var1.setLineColor(var2);
        var3 = this.f;
        var2.drawString(this.j, 0, var3);

        for (int var4 = 0; var4 < this.b.length; ++var4) {
            var2.drawString(this.b[var4], this.i, var3);
            var3 += 2 * var1.centerY;
        }

    }

    @Override
    public void a(ABBasePanel var1) {
        l var2;
        int var3;
        if ((var3 = ((ABOutputBlock) (var2 = (l) var1).executable).j()) == 0) {
            this.j = "OUT ";
        } else if (var3 == 1) {
            this.j = "OUTLN ";
        } else if (var3 == 2) {
            this.j = "OUT*LN ";
        }

        FontMetrics var4 = var2.getFontMetrics(var1.getFont());
        String var5 = ((com.github.kill05.algobuildce.package_a.c.b.k) var2.executable).k();
        this.i = var4.charsWidth(this.j.toCharArray(), 0, this.j.length());
        this.b = var5.split("\\n");
        this.c = new int[this.b.length];
        this.d = 0;
        this.e = ((this.b.length << 1) + 1) * var2.centerY;
        this.f = 2 * var2.centerY;

        for (var3 = 0; var3 < this.b.length; ++var3) {
            this.c[var3] = var4.charsWidth(this.b[var3].toCharArray(), 0, this.b[var3].length());
            this.d = Math.max(this.d, this.i + this.c[var3]);
        }

        this.g = ((int) Math.ceil((double) this.d / (double) (2 * var2.centerX)) << 1) * var2.centerX;
        this.h = ((this.b.length << 1) + 1) * var2.centerY;
        Dimension var6 = new Dimension(this.g, this.h);
        var2.forceSize(var6);
        this.a(new Rectangle(this.d, this.e));
    }
}
