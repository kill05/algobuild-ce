package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.b.r;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;

public final class A_subclass extends C_subclass {

    private static final String IF = "IF ";
    private static final String ELSE = "ELSE";
    private static final String END_IF = "END IF";

    private String[] b;
    private int[] c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    public A_subclass(p var1, D_subclass var2) {
        super(var2);
    }

    @Override
    public void a(ABBasePanel var1, Graphics var2) {
        int var3 = var1.getWidth();
        var1.getHeight();
        Dimension var4 = ((m)var1).e().getMinimumSize();
        Dimension var5 = ((m)var1).d().getMinimumSize();
        boolean var6 = false;

        try {
            if (((m)var1).d().getExecutable().getInstructionAmount() > 0) {
                var6 = true;
            }
        } catch (r var8) {
            var8.printStackTrace();
        }

        var1.setFillingColor(var2, 0);
        var2.fillRect(0, 0, var3, this.e);
        var1.setFillingColor(var2, 1);
        if (var6) {
            var2.fillRect(0, this.e + var4.height, var3, 3 * var1.f);
            var2.fillRect(0, this.e + var4.height + var5.height + 3 * var1.f, var3, 3 * var1.f);
            var2.fillRect(0, this.e, var1.e, this.e + var4.height + var5.height + 6 * var1.f);
        } else {
            var2.fillRect(0, this.e + var4.height, var3, var1.f);
            var2.fillRect(0, this.e + var4.height + var5.height + var1.f, var3, 3 * var1.f);
            var2.fillRect(0, this.e, var1.e, this.e + var4.height + var5.height + 4 * var1.f);
        }

        var1.setLineColor(var2);
        int var7 = this.f;
        var2.drawString(this.IF, 0, var7);

        for(var3 = 0; var3 < this.b.length; ++var3) {
            var2.drawString(this.b[var3], this.i, var7);
            var7 += 2 * var1.f;
        }

        var7 = (int)((double)(var7 + var1.f) + var4.getHeight());
        var1.setLineColor(var2);
        if (var6) {
            var2.drawString(ELSE, 0, var7);
            var7 += 3 * var1.f;
        } else {
            var7 += var1.f;
        }

        var7 = (int)((double)var7 + var5.getHeight());
        var2.drawString(END_IF, 0, var7);
    }

    @Override
    public void a(ABBasePanel var1) {
        m var2;
        FontMetrics var7 = (var2 = (m)var1).getFontMetrics(var1.getFont());
        String var3 = var2.executable.b();
        this.i = var7.charsWidth(this.IF.toCharArray(), 0, this.IF.length());
        this.b = var3.split("\\n");
        this.c = new int[this.b.length];
        this.d = 0;
        this.e = ((this.b.length << 1) + 1) * var2.f;
        this.f = 2 * var2.f;

        for(int var9 = 0; var9 < this.b.length; ++var9) {
            this.c[var9] = var7.charsWidth(this.b[var9].toCharArray(), 0, this.b[var9].length());
            this.d = Math.max(this.d, this.i + this.c[var9]);
        }

        this.g = ((int)Math.ceil((double)this.d / (double)(2 * var2.e)) << 1) * var2.e;
        this.h = ((this.b.length << 1) + 1) * var2.f;
        Dimension var10 = new Dimension(this.g, this.h);
        var2.e().g();
        Dimension var8 = var2.e().getMinimumSize();
        var2.d().g();
        Dimension var4 = var2.d().getMinimumSize();
        var10.width = Math.max(var10.width, var8.width + 2 * var2.e) + 2 * var2.e;
        var10.height += var8.height;
        var10.width = Math.max(var10.width, var4.width + 2 * var2.e) + 2 * var2.e;
        var10.height += var4.height;
        int var11 = 0;

        try {
            if (var2.d().getExecutable().getInstructionAmount() > 0) {
                var10.height += 6 * var2.f;
                var11 = 3 * var2.f;
            } else {
                var10.height += 4 * var2.f;
                var11 = var2.f;
            }
        } catch (r var6) {
            var6.printStackTrace();
        }

        var2.a(var10);
        int var5 = 2 * var2.e;
        var2.e().setLocation(var5, this.e);
        var2.d().setLocation(var5, (int)((double)this.e + var8.getHeight() + (double)var11));
        var2.revalidate();
    }
}
