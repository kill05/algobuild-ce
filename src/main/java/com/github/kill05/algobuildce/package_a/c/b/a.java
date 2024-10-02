package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.json.JSONObject;
import com.github.kill05.algobuildce.package_c.l;
import com.github.kill05.algobuildce.package_c.ABExecutionException;

public final class a extends n {
    private String b;
    private String[] c = null;

    public a(String var1) {
        this.a(var1);
    }

    public a() {
        this.a((String) null);
    }

    @Override
    public String b() {
        return this.b;
    }

    public void a(String var1) {
        this.b = var1;
        if (var1 != null) {
            this.c = var1.split("\n|;");
        } else {
            this.c = null;
        }

        this.a(true);
    }

    @Override
    public int a(com.github.kill05.algobuildce.package_a.c.a.b var1, int var2) {
        for (var2 = 0; this.c != null && var2 < this.c.length; ++var2) {
            String var3 = this.c[var2];

            try {
                l var4 = var1.e().a(var3, var1.c());
                var1.h("ASSIGN: " + var3 + "   RESULT:" + var4);
            } catch (ABExecutionException var5) {
                var1.i("ASSIGN ERROR: " + var5 + " IN " + var3);
                return -2;
            }
        }

        var1.i();
        return -1;
    }

    public String toString() {
        return this.n() + "- ABIAssign: " + this.b + "\n";
    }

    @Override
    protected String g() {
        return "ABIASS";
    }

    @Override
    public com.github.kill05.algobuildce.package_a.f.g h() {
        com.github.kill05.algobuildce.package_a.f.g var1;
        (var1 = super.h()).a("label", this.b);
        return var1;
    }

    @Override
    public void a(com.github.kill05.algobuildce.package_a.f.g var1) {
        super.a(var1);
        String var2 = var1.a("label");
        this.a(var2);
    }

    @Override
    public JSONObject b(boolean var1) {
        JSONObject var2;
        (var2 = super.b(var1)).put("label", this.b);
        return var2;
    }

    @Override
    public void a(JSONObject var1, boolean var2) {
        super.a(var1, var2);
        String var3 = var1.getAsString("label");
        this.a(var3);
    }

    @Override
    public com.github.kill05.algobuildce.package_a.c.a.d e() {
        a var1;
        (var1 = new a()).a(this.b);
        return var1;
    }

    @Override
    public p i() {
        return new p(1, this.b.length());
    }
}
