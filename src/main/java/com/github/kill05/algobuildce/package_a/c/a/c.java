package com.github.kill05.algobuildce.package_a.c.a;

public final class c {
    private int a = -1;
    private final d b;
    private final b c;

    public c(d var1, b var2) {
        this.b = var1;
        this.c = var2;
        if (this.b != null) {
            this.a = 0;
        }

    }

    public void a() {
        this.a = this.b.a(this.c, this.a);
        if (this.a == -1) {
            this.c.d().pop();
        }

    }

    public String toString() {
        return "ABEExecFragment [status=" + this.a + ", executable=" + this.b + "]";
    }

    public boolean b() {
        return this.b.b(this.a);
    }

    public int c() {
        return this.a;
    }

    public d d() {
        return this.b;
    }
}
