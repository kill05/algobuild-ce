package package_a.j.b;

import package_a.c.a.b;
import package_a.c.a.d;
import package_a.c.b.n;
import package_a.g.e;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public final class a extends o {
    private String[] a;
    private int[] k;
    private int l;
    private int m;
    private int n;
    private int o;

    public a(b var1, package_a.j.a.a var2, d var3) {
        super(var1, var2, var3);
        var3.a(this);
        this.g();
    }

    public final void a(Graphics var1) {
        int var2 = this.getWidth();
        int var3 = this.getHeight();
        this.b(var1);
        var1.fillRect(var2 / 2 - this.n / 2, this.f, this.n, this.o);
        this.c(var1);
        var1.drawRect(var2 / 2 - this.n / 2, this.f, this.n, this.o);
        var1.drawLine(var2 / 2, 0, var2 / 2, this.f);
        var1.drawLine(var2 / 2, var3 - this.f, var2 / 2, var3);
        var3 = this.m;

        for(int var4 = 0; var4 < this.a.length; ++var4) {
            var1.drawString(this.a[var4], var2 / 2 - this.k[var4] / 2, var3);
            var3 += 2 * this.f;
        }

    }

    public final void a() {
        String var1 = this.i.b();
        FontMetrics var2 = this.getFontMetrics(this.getFont());
        this.a = var1.split("\\n");
        this.k = new int[this.a.length];
        this.l = 0;
        var1 = "X";
        if (this.a.length > 0) {
            var1 = this.a[0];
        }

        Rectangle2D var3 = var2.getStringBounds(var1, this.getGraphics());
        this.m = (int)((double)(3 * this.f) - var3.getHeight() / 2.0 - var3.getY());

        for(int var4 = 0; var4 < this.a.length; ++var4) {
            this.k[var4] = var2.charsWidth(this.a[var4].toCharArray(), 0, this.a[var4].length());
            this.l = Math.max(this.l, this.k[var4]);
        }

        this.n = (2 + ((int)Math.ceil((double)this.l / (double)(2 * this.e)) << 1)) * this.e;
        this.o = (this.a.length + 1 << 1) * this.f;
        Dimension var5 = new Dimension(this.n + 2 * this.e, this.o + 2 * this.f);
        this.a(var5);
        this.j = new Rectangle(this.getWidth() / 2 - this.n / 2, this.f, this.n, this.o);
    }

    protected final void a_() {
        e var1 = new e((n)this.i);
        if (package_a.a.a.a(this.c.a(), (package_a.c.b.a)this.i)) {
            this.c.c().a(var1);
            this.b.a(true);
        }

        this.b.a((d)null);
    }
}

