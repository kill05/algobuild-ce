package com.github.kill05.algobuildce.package_a.c.b;

import java.util.Iterator;
import java.util.Vector;

public final class o extends n {
    private final Vector<n> b = new Vector<>();

    @Override
    public boolean b(int var1) {
        return false;
    }

    @Override
    public boolean a(int var1) {
        int var2 = this.b.size();
        return var1 >= 0 && var1 < var2;
    }

    @Override
    public n c(int var1) {
        return this.b.get(var1);
    }

    @Override
    public void a(n var1) {
        int var2 = this.b.size();
        var1.a((com.github.kill05.algobuildce.package_a.c.a.d) this, var2);
        this.b.add(var1);
        if (this.a != null) {
            for (com.github.kill05.algobuildce.package_a.c.a.k k : this.a) {
                k.a(var1, var2);
            }
        }

    }

    @Override
    public void a(n var1, int var2) {
        for (int var3 = var2; var3 < this.b.size(); ++var3) {
            this.c(var3).f(1);
        }

        var1.a((com.github.kill05.algobuildce.package_a.c.a.d) this, var2);
        this.b.add(var2, var1);
        if (this.a != null) {

            for (com.github.kill05.algobuildce.package_a.c.a.k k : this.a) {
                k.a(var1, var2);
            }
        }

        var1.f();
    }

    @Override
    public void d(int var1) {
        this.b.remove(var1);

        for (int var2 = var1; var2 < this.b.size(); ++var2) {
            this.c(var2).f(-1);
        }

        if (this.a != null) {
            for (com.github.kill05.algobuildce.package_a.c.a.k k : this.a) {
                k.a(var1);
            }
        }

    }

    public void j() {
        while (!this.b.isEmpty()) {
            this.d(0);
        }

    }

    @Override
    public int d() {
        return this.b.size();
    }

    @Override
    public int a(com.github.kill05.algobuildce.package_a.c.a.b var1, int var2) {
        if (this.a(var2)) {
            int var3 = var2++;
            com.github.kill05.algobuildce.package_a.c.a.c var4 = new com.github.kill05.algobuildce.package_a.c.a.c((com.github.kill05.algobuildce.package_a.c.a.d) this.b.get(var3), var1);
            var1.d().push(var4);
        } else {
            var2 = -1;
        }

        return var2;
    }

    public String toString() {
        return "ABICompound [getOrderInParent()=" + this.n() + "\ninstructions=" + this.b + "]";
    }

    @Override
    public boolean a() {
        return true;
    }

    @Override
    public void f() {
        if (this.a != null) {
            for (int var1 = 0; var1 < this.b.size(); ++var1) {
                n var2 = this.c(var1);
                Iterator var4 = this.a.iterator();

                while (var4.hasNext()) {
                    ((com.github.kill05.algobuildce.package_a.c.a.k) var4.next()).a(var2, var1);
                }

                var2.f();
            }
        }

    }

    @Override
    public p i() {
        p var1 = new p();

        for (int var2 = 0; var2 < this.b.size(); ++var2) {
            n var3 = this.c(var2);
            var1.a(var3.i());
        }

        return var1;
    }
}
