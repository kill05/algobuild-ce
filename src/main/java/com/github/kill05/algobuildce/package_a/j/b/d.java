package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.b.ABInstructionBlock;
import com.github.kill05.algobuildce.package_a.c.b.ABCommentBlock;
import com.github.kill05.algobuildce.package_a.g.e;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public final class d extends ABInstructionPanel {
    private String[] a;
    private int[] k;
    private int l;
    private int m;
    private int n;
    private int o;

    public d(com.github.kill05.algobuildce.package_a.c.a.b var1, com.github.kill05.algobuildce.package_a.j.a.a var2, ABExecutable var3) {
        super(var1, var2, var3);
        var3.a(this);
        this.g();
    }

    @Override
    public void a(Graphics var1) {
        int var2 = this.getWidth();
        int var3 = this.getHeight();
        int[] var4 = new int[]{var2 / 2 - this.n / 2, var2 / 2 + this.n / 2 - 2 * this.e, var2 / 2 + this.n / 2, var2 / 2 + this.n / 2, var2 / 2 - this.n / 2};
        int[] var5 = new int[]{this.f, this.f, this.f + 2 * this.f, this.f + this.o, this.f + this.o};
        this.b(var1);
        var1.fillPolygon(var4, var5, 5);
        this.c(var1);
        var1.drawPolygon(var4, var5, 5);
        var1.drawLine(var2 / 2 + this.n / 2 - 2 * this.e, this.f, var2 / 2 + this.n / 2 - 2 * this.e, 3 * this.f);
        var1.drawLine(var2 / 2 + this.n / 2 - 2 * this.e, 3 * this.f, var2 / 2 + this.n / 2, 3 * this.f);
        var1.drawLine(var2 / 2, 0, var2 / 2, this.f);
        var1.drawLine(var2 / 2, var3 - this.f, var2 / 2, var3);
        var3 = this.m;

        for (int var6 = 0; var6 < this.a.length; ++var6) {
            var1.drawString(this.a[var6], var2 / 2 - this.k[var6] / 2, var3);
            var3 += 2 * this.f;
        }

    }

    @Override
    public void a() {
        String var1 = this.i.b();
        FontMetrics var2 = this.getFontMetrics(this.getFont());
        this.a = var1.split("\\n");
        this.k = new int[this.a.length];
        this.l = 0;
        Rectangle2D var3 = var2.getStringBounds(this.a[0], this.getGraphics());
        this.m = (int) ((double) (3 * this.f) - var3.getHeight() / 2.0 - var3.getY());

        for (int var4 = 0; var4 < this.a.length; ++var4) {
            this.k[var4] = var2.charsWidth(this.a[var4].toCharArray(), 0, this.a[var4].length());
            this.l = Math.max(this.l, this.k[var4]);
        }

        this.n = (4 + ((int) Math.ceil((double) this.l / (double) (2 * this.e)) << 1)) * this.e;
        this.o = (this.a.length + 1 << 1) * this.f;
        Dimension var5 = new Dimension(this.n + 2 * this.e, this.o + 2 * this.f);
        this.a(var5);
        this.j = new Rectangle(this.getWidth() / 2 - this.n / 2, this.f, this.n, this.o);
    }

    @Override
    protected void modifyInstruction() {
        e var1 = new com.github.kill05.algobuildce.package_a.g.e((ABInstructionBlock) this.i);
        if (com.github.kill05.algobuildce.package_a.a.d.a(this.c.a(), (ABCommentBlock) this.i)) {
            this.c.c().a(var1);
            this.b.update(true);
        }

        this.b.a((ABExecutable) null);
    }
}

