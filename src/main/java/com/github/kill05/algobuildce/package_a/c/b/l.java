package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.json.JSONArray;
import com.github.kill05.algobuildce.json.JSONObject;
import com.github.kill05.algobuildce.package_c.ABExecutionException;

public final class l extends m {

    private final o b;
    private final o c;

    public l(String var1) {
        super(var1);
        this.b = new o();
        this.b.a((com.github.kill05.algobuildce.package_a.c.a.d) this, 1);
        this.c = new o();
        this.c.a((com.github.kill05.algobuildce.package_a.c.a.d) this, 2);
    }

    public l() {
        this(null);
    }

    public o j() {
        return this.b;
    }

    public o k() {
        return this.c;
    }

    @Override
    public n c(int var1) {
        if (var1 == 1) {
            return this.b;
        } else if (var1 == 2) {
            return this.c;
        } else {
            throw new s("ABISelectionIf getInstr(" + var1 + ")");
        }
    }

    @Override
    public int a(com.github.kill05.algobuildce.package_a.c.a.b var1, int var2) {
        if (var2 == 0) {
            String var6 = this.l().replace('\n', ' ');

            boolean var7;
            try {
                com.github.kill05.algobuildce.package_c.l var3;
                boolean var4;
                var7 = var4 = (var3 = var1.e().a(var6, var1.c())) instanceof com.github.kill05.algobuildce.package_c.h && ((com.github.kill05.algobuildce.package_c.h) var3).a();
                var1.h("IF TEST:  " + var6 + "   RESULT: " + var4);
                var1.i();
            } catch (ABExecutionException var5) {
                var1.i("IF ERROR: " + var5 + " IN " + var6);
                return -2;
            }

            com.github.kill05.algobuildce.package_a.c.a.c var8;
            if (var7) {
                var1.d().pop();
                var8 = new com.github.kill05.algobuildce.package_a.c.a.c(this.b, var1);
                var1.d().push(var8);
                return 1;
            } else {
                var1.d().pop();
                var8 = new com.github.kill05.algobuildce.package_a.c.a.c(this.c, var1);
                var1.d().push(var8);
                return 2;
            }
        } else if (var2 == 1) {
            return -1;
        } else {
            return -1;
        }
    }

    public String toString() {
        return "ABISelectionIf " + this.l() + " [bodyTrue=" + this.b + ", bodyFalse=" + this.c + ", getOrderInParent()=" + this.n() + "]";
    }

    @Override
    public JSONObject b(boolean var1) {
        JSONObject var2 = super.b(var1);
        if (var1) {
            int var3;
            for (var3 = 0; var3 < this.c.d(); ++var3) {
                var2.a("0", this.c.c(var3).b(true));
            }

            for (var3 = 0; var3 < this.b.d(); ++var3) {
                var2.a("1", this.b.c(var3).b(true));
            }
        }

        return var2;
    }

    @Override
    public void a(JSONObject var1, boolean var2) {
        super.a(var1, var2);
        if (var2) {
            try {
                this.c.j();
                this.b.j();
            } catch (t var7) {
                var7.printStackTrace();
            }

            JSONArray var3;
            int var4;
            JSONObject var5;
            n var6;
            if ((var3 = var1.getAsJsonArray("0")) != null) {
                for (var4 = 0; var4 < var3.size(); ++var4) {
                    (var6 = n.a(var5 = var3.getAsJsonObject(var4))).a(var5, var2);
                    this.c.a(var6);
                }
            }

            if ((var3 = var1.getAsJsonArray("1")) != null) {
                for (var4 = 0; var4 < var3.size(); ++var4) {
                    (var6 = n.a(var5 = var3.getAsJsonObject(var4))).a(var5, var2);
                    this.b.a(var6);
                }
            }
        }

    }

    @Override
    public com.github.kill05.algobuildce.package_a.c.a.d e() {
        l var1 = new l(this.l());

        int var2;
        n var3;
        for (var2 = 0; var2 < this.b.d(); ++var2) {
            var3 = this.b.c(var2);
            var1.b.a((n) var3.e());
        }

        for (var2 = 0; var2 < this.c.d(); ++var2) {
            var3 = this.c.c(var2);
            var1.c.a((n) var3.e());
        }

        return var1;
    }

    @Override
    public void f() {
        if (this.a != null) {
            this.b.f();
            this.c.f();
        }

    }

    @Override
    protected String g() {
        return "ABIIF_";
    }

    @Override
    public p i() {
        p var1;
        (var1 = super.i()).a(this.b.i());
        var1.a(this.c.i());
        return var1;
    }
}
