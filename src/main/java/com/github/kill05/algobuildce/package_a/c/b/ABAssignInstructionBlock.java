package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.json.JsonObject;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.f.ABBlockDataHolder;
import com.github.kill05.algobuildce.package_c.l;
import com.github.kill05.algobuildce.package_c.ABInstructionException;

public final class ABAssignInstructionBlock extends ABInstructionBlock {
    private String b;
    private String[] c = null;

    public ABAssignInstructionBlock(String var1) {
        this.a(var1);
    }

    public ABAssignInstructionBlock() {
        this.a((String) null);
    }

    @Override
    public String getDisplayName() {
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
    public int a(ABProgram var1, int var2) {
        for (var2 = 0; this.c != null && var2 < this.c.length; ++var2) {
            String var3 = this.c[var2];

            try {
                l var4 = var1.e().a(var3, var1.c());
                var1.h("ASSIGN: " + var3 + "   RESULT:" + var4);
            } catch (ABInstructionException var5) {
                var1.i("ASSIGN ERROR: " + var5 + " IN " + var3);
                return -2;
            }
        }

        var1.i();
        return -1;
    }

    public String toString() {
        return this.getOrderInParent() + "- ABIAssign: " + this.b + "\n";
    }

    @Override
    protected String getId() {
        return "ABIASS";
    }

    @Override
    public ABBlockDataHolder h() {
        ABBlockDataHolder var1;
        (var1 = super.h()).putData("label", this.b);
        return var1;
    }

    @Override
    public void a(ABBlockDataHolder var1) {
        super.a(var1);
        String var2 = var1.getData("label");
        this.a(var2);
    }

    @Override
    public JsonObject b(boolean var1) {
        JsonObject var2;
        (var2 = super.b(var1)).put("label", this.b);
        return var2;
    }

    @Override
    public void a(JsonObject var1, boolean var2) {
        super.a(var1, var2);
        String var3 = var1.getAsString("label");
        this.a(var3);
    }

    @Override
    public ABExecutable copy() {
        ABAssignInstructionBlock instruction = new ABAssignInstructionBlock();
        instruction.a(this.b);
        return instruction;
    }

    @Override
    public p i() {
        return new p(1, this.b.length());
    }
}
