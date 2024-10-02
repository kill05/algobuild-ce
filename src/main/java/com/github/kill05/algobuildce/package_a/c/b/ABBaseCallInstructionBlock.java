package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.json.JsonArray;
import com.github.kill05.algobuildce.json.JsonObject;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutionFragment;
import com.github.kill05.algobuildce.package_a.f.ABBlockDataHolder;
import com.github.kill05.algobuildce.package_c.ABInstructionException;

import java.util.Map;
import java.util.Vector;

public class ABBaseCallInstructionBlock extends ABInstructionBlock {
    String callName;
    Vector<String> parameters;

    public ABBaseCallInstructionBlock(String var1) {
        this.callName = var1;
        this.parameters = new Vector<>();
    }

    public ABBaseCallInstructionBlock(String var1, Vector<String> var2) {
        this.callName = var1;
        this.parameters = var2;
    }

    public ABBaseCallInstructionBlock() {
        this((String) null);
    }

    public final String j() {
        return this.callName;
    }

    public final void a(String var1) {
        this.callName = var1;
        this.a(true);
    }

    public final Vector<String> k() {
        return this.parameters;
    }

    private void b(String var1) {
        if (!this.parameters.contains(var1)) {
            this.parameters.add(var1);
            this.a(true);
        }

    }

    private String e(int var1) {
        return this.parameters.get(var1);
    }

    @Override
    public int a(com.github.kill05.algobuildce.package_a.c.a.b var1, int var2) {
        if (var2 == 0) {
            q var10;
            if ((var10 = var1.a(this.callName)) != null) {
                Map var3 = var1.c();
                var1.f();
                Map var4 = var1.c();
                String var5 = "";

                for (int var6 = 0; var6 < this.parameters.size() && var6 < var10.parameters.size(); ++var6) {
                    String var7 = (String) this.parameters.get(var6);
                    com.github.kill05.algobuildce.package_c.f var8;
                    if ((var8 = (com.github.kill05.algobuildce.package_c.f) var3.get(var7)) != null) {
                        var8 = var8.c();
                        if (!var5.isEmpty()) {
                            var5 = var5 + ", ";
                        }

                        var5 = var5 + var8.toString();
                        var4.put(var10.e(var6), var8);
                    } else {
                        try {
                            if (!var7.isEmpty()) {
                                com.github.kill05.algobuildce.package_c.l var11 = var1.e().a(var7, var3);
                                if (var5.length() > 0) {
                                    var5 = var5 + ", ";
                                }

                                var5 = var5 + var11;
                                var4.put(var10.e(var6), new com.github.kill05.algobuildce.package_c.m(var11));
                            }
                        } catch (ABInstructionException var9) {
                            var1.i("CALL PARAMETER " + (var6 + 1) + " ERROR: " + var9 + " IN " + var7);
                            return -2;
                        }
                    }
                }

                var1.d().push(new ABExecutionFragment(var10, var1));
                var1.h("CALL: " + var10.name + "(" + var5 + ")");
                var1.l();
                return 1;
            }
        } else if (var2 == 1) {
            var1.m();
            var1.g();
            return -1;
        }

        return -1;
    }

    public String toString() {
        return "ABICall_Base [callName=" + this.callName + ", actualParams=" + this.parameters + " orderInParent=" + this.getOrderInParent() + "]";
    }

    @Override
    protected final String getName() {
        return "ABICAL";
    }

    @Override
    public ABBlockDataHolder h() {
        ABBlockDataHolder var1;
        (var1 = super.h()).putData("callName", this.callName);
        int var2;
        if ((var2 = this.parameters.size()) > 0) {
            String var3 = this.e(0);

            for (int var4 = 1; var4 < var2; ++var4) {
                var3 = var3 + "\n" + this.e(var4);
            }

            var1.putData("actualParams", var3);
        }

        return var1;
    }

    @Override
    public void a(ABBlockDataHolder var1) {
        super.a(var1);
        String var2 = var1.getData("callName");
        this.a(var2);
        String var3;
        if ((var3 = var1.getData("actualParams")) != null) {
            this.parameters.removeAllElements();
            String[] var4 = var3.split("\\n");

            for (int var5 = 0; var5 < var4.length; ++var5) {
                this.a(var4[var5]);
            }
        }

    }

    @Override
    public JsonObject b(boolean var1) {
        JsonObject var5;
        (var5 = super.b(var1)).put("callName", this.callName);
        int var2 = this.parameters.size();

        for (int var3 = 0; var3 < var2; ++var3) {
            String var4;
            if (!(var4 = this.e(var3).trim()).isEmpty()) {
                var5.a("actualParams", (Object) var4);
            }
        }

        return var5;
    }

    @Override
    public void a(JsonObject var1, boolean var2) {
        super.a(var1, var2);
        String var4 = var1.getAsString("callName");
        this.a(var4);
        this.parameters.removeAllElements();
        JsonArray var3;
        if ((var3 = var1.getAsJsonArray("actualParams")) != null) {
            for (int var5 = 0; var5 < var3.size(); ++var5) {
                this.a(var3.getAsString(var5));
            }
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public ABExecutable copy() {
        return new ABBaseCallInstructionBlock(this.callName, (Vector<String>) this.parameters.clone());
    }

    @Override
    public final boolean b(int var1) {
        return var1 == 0;
    }

    @Override
    public final p i() {
        p var1 = new p(1, this.callName.length());

        for (String parameter : this.parameters) {
            var1.a(0, parameter.length());
        }

        return var1;
    }
}
