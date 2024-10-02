package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.json.JsonObject;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.f.ABBlockDataHolder;
import com.github.kill05.algobuildce.package_c.ABInstructionException;

public final class ABOutputBlock extends k {
    private int b = 1;

    public ABOutputBlock(String var1) {
        super(var1);
    }

    private ABOutputBlock(String var1, int var2) {
        super(var1);
        this.e(var2);
    }

    public ABOutputBlock() {
        super((String) null);
    }

    public final int j() {
        return this.b;
    }

    public final void e(int var1) {
        if (var1 < 0) {
            var1 = 0;
        } else if (var1 > 2) {
            var1 = 2;
        }

        this.b = var1;
        this.a(true);
    }

    @Override
    public final int a(ABProgram var1, int var2) {
        String[] var7 = this.l();

        for (int var3 = 0; var7 != null && var3 < var7.length; ++var3) {
            var1.h("OUTPUT: " + var7[var3]);
            String var4;
            String var5;
            if ((var4 = var7[var3]).startsWith("\"")) {
                var5 = var4.replace("\"", "");
                if (this.b == 2) {
                    var1.g(var5);
                } else {
                    var1.f(var5);
                }
            } else if (var4.startsWith("'")) {
                var5 = var4.replace("'", "");
                if (this.b == 2) {
                    var1.g(var5);
                } else {
                    var1.f(var5);
                }
            } else {
                try {
                    com.github.kill05.algobuildce.package_c.l var8 = var1.e().a(var4, var1.c());
                    if (this.b == 2) {
                        var1.g(var8.toString());
                    } else {
                        var1.f(var8.toString());
                    }
                } catch (ABInstructionException var6) {
                    var1.i("OUTPUT ERROR: " + var6 + " IN " + var4);
                    return -2;
                }
            }
        }

        if (this.b == 1) {
            var1.n();
        }

        return -1;
    }

    public final String toString() {
        return this.getOrderInParent() + "- ABIIOOutput: " + this.k().replace("\n", ", ") + "\n";
    }

    @Override
    public final ABBlockDataHolder h() {
        ABBlockDataHolder var1;
        (var1 = super.h()).putData("lineSeparators", Integer.toString(this.b));
        return var1;
    }

    @Override
    public final void a(ABBlockDataHolder var1) {
        super.a(var1);
        String var2 = var1.getData("lineSeparators");
        this.b = Integer.parseInt(var2);
    }

    @Override
    public final JsonObject b(boolean var1) {
        JsonObject var2;
        (var2 = super.b(var1)).put("lineSeparators", Integer.toString(this.b));
        return var2;
    }

    @Override
    public final void a(JsonObject var1, boolean var2) {
        super.a(var1, var2);
        String var3 = var1.getAsString("lineSeparators");
        this.e(Integer.parseInt(var3));
    }

    @Override
    public final ABExecutable copy() {
        return new ABOutputBlock(this.k(), this.b);
    }

    @Override
    protected final String getName() {
        return "ABIOUT";
    }
}
