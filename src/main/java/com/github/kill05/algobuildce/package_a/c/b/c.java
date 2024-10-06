package com.github.kill05.algobuildce.package_a.c.b;

import java.util.Vector;

import com.github.kill05.algobuildce.json.JsonObject;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.f.ABBlockDataHolder;
import com.github.kill05.algobuildce.package_c.f;

public final class c extends ABBaseCallBlock {
    private String d;

    public c(String var1) {
        super(var1);
    }

    private c(String var1, Vector var2) {
        super(var1, var2);
    }

    public c() {
        this(null);
    }

    public String l() {
        return this.d;
    }

    public void b(String var1) {
        System.out.println("SET RETURN VARIABLE " + var1);
        this.d = var1;
        this.a(true);
    }

    @Override
    public int a(ABProgram var1, int var2) {
        f var3 = null;
        boolean var4 = false;
        if (var2 == 1 && this.d != null && !this.d.isEmpty()) {
            var3 = (f) var1.c().get("_RETVAL_");
            var4 = true;
        }

        var2 = super.a(var1, var2);
        if (var4) {
            var1.c().put(this.d, var3);
            var1.h("RETURN VALUE: " + var3);
        }

        var1.i();
        return var2;
    }

    @Override
    public ABBlockDataHolder h() {
        ABBlockDataHolder var1 = super.h();
        if (this.d != null) {
            var1.putData("returnVariable", this.d);
        }

        return var1;
    }

    @Override
    public void a(ABBlockDataHolder var1) {
        super.a(var1);
        String var2;
        if ((var2 = var1.getData("returnVariable")) != null) {
            this.b(var2);
        }

    }

    @Override
    public JsonObject b(boolean var1) {
        JsonObject var2 = super.b(var1);
        System.out.println("getAsJSONObject RETURN VARIABLE " + this.d);
        if (this.d != null) {
            var2.put("returnVariable", this.d);
        }

        return var2;
    }

    @Override
    public void a(JsonObject var1, boolean var2) {
        super.a(var1, var2);
        String var3 = var1.getAsString("returnVariable");
        System.out.println("getAsJSONObject RETURN VARIABLE " + var3);
        if (var3 != null) {
            this.b(var3);
        }

    }

    @Override
    public ABExecutable copy() {
        c var1;
        (var1 = new c(this.callName, (Vector) this.parameters.clone())).b(this.d);
        return var1;
    }
}
