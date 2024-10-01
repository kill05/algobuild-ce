package com.github.kill05.algobuildce.package_a.j.b;

import java.awt.Component;
import java.awt.Dimension;

public final class e extends o {
    public e(com.github.kill05.algobuildce.package_a.c.a.b var1, com.github.kill05.algobuildce.package_a.j.a.a var2, com.github.kill05.algobuildce.package_a.c.a.d var3) {
        super(var1, var2, var3);
        this.a(var3);
        this.setLayout(null);
        (new f(var1, var2)).a(this, 0);
        this.g();
        this.a(this.d);
    }

    @Override
    public final void a(com.github.kill05.algobuildce.package_a.c.a.d var1, int var2) {
        o var3 = this.b(var1);
        this.a(var3, var2);
        var1.a(var3);
        this.g();
        this.d = true;
        this.a(this.d);
        this.revalidate();
    }

    @Override
    public final void a() {
        Dimension var1 = new Dimension(2 * this.e, 0 * this.f);
        Component[] var2 = this.getComponents();

        int var3;
        for (var3 = 0; var3 < var2.length; ++var3) {
            if (var2[var3] instanceof n) {
                ((n) var2[var3]).g();
            }

            Dimension var4;
            if ((var4 = var2[var3].getMinimumSize()).width > var1.width) {
                var1.width = var4.width;
            }

            var1.height += var4.height;
        }

        this.a(var1);
        var3 = 0;

        for (int var7 = 0; var7 < var2.length; ++var7) {
            Dimension var5 = var2[var7].getMinimumSize();
            int var6 = (int) (var1.getWidth() - var5.getWidth()) / 2;
            var2[var7].setLocation(var6, var3);
            var3 = (int) ((double) var3 + var5.getHeight());
        }

    }

    public final void a(o var1, int var2) {
        if (var1 != null) {
            f var3 = new f(this.b, this.c);
            this.add(var3, var2 << 1);
            this.add(var1, (var2 << 1) + 1);
            if (this.h != null) {
                C_subclass var4 = this.h.a().a(var3);
                var3.a(var4);
                var4 = this.h.a().a(var1);
                var1.a(var4);
            }

            this.g();
        }

    }

    public final void b(int var1) {
        if ((var1 << 1) + 1 < this.getComponentCount()) {
            this.remove(var1 << 1);
            this.remove(var1 << 1);
            this.g();
        }

    }

    @Override
    public final void a(int var1) {
        this.b(var1);
        this.a(true);
        this.invalidate();
    }

    @Override
    public final void a(C_subclass var1) {
        super.a(var1);
        Component[] var2 = this.getComponents();

        for (int var3 = 0; var3 < var2.length; ++var3) {
            if (var2[var3] instanceof n) {
                n var4 = (n) var2[var3];
                C_subclass var5 = var1.a().a(var4);
                var4.a(var5);
            }
        }

    }
}
