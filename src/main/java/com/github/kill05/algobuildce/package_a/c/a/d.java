package com.github.kill05.algobuildce.package_a.c.a;

import com.github.kill05.algobuildce.package_a.c.b.n;
import com.github.kill05.algobuildce.package_a.c.b.r;
import com.github.kill05.algobuildce.package_a.c.b.s;
import com.github.kill05.algobuildce.package_a.c.b.t;

import java.util.Iterator;
import java.util.Vector;

public abstract class d {

    protected Vector<com.github.kill05.algobuildce.package_a.c.a.k> a = null;


    public abstract int a(b var1, int var2);

    public boolean a(int var1) {
        return var1 != -1;
    }

    public boolean b(int var1) {
        return true;
    }

    public boolean a() {
        return false;
    }

    public abstract String b();

    public abstract String c();

    public n c(int var1) {
        throw new s("ABEExecutable getInstr(" + var1 + ")");
    }

    public void a(n var1) {
        throw new s("ABEExecutable addInstr(" + var1 + ")");
    }

    public void a(n var1, int var2) {
        throw new s("ABEExecutable addInstr(" + var1 + "," + var2 + ")");
    }

    public void d(int var1) {
        throw new t("ABEExecutable removeInstr(" + var1 + ")");
    }

    public int d() {
        throw new r("ABEExecutable getNInstr()");
    }


    public final void a(k var1) {
        if (var1 != null) {
            if (this.a == null) {
                this.a = new Vector<>();
            }

            this.a.add(var1);
            var1.a(this);
        }

    }

    public final void a(boolean var1) {
        if (this.a != null) {
            for (com.github.kill05.algobuildce.package_a.c.a.k k : this.a) {
                k.a(this, var1);
            }
        }

    }

    public d e() {
        return null;
    }

    public void f() {
    }
}
