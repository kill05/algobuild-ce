package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.json.JsonObject;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.f.ABBlockDataHolder;


public abstract class ABInstructionBlock extends ABExecutable {
    private ABExecutable parent = null;
    private int orderInParent = -1;

    public final void a(ABExecutable var1, int var2) {
        this.parent = var1;
        this.orderInParent = var2;
    }

    public final void f(int var1) {
        this.orderInParent += var1;
        if (this.orderInParent < 0) {
            this.orderInParent = 0;
        }

    }

    public final int getOrderInParent() {
        return this.orderInParent;
    }

    @Override
    public String c() {
        if (this.parent != null) {
            String var1 = this.parent.c();
            return this.orderInParent >= 0 ? var1 + "." + this.orderInParent : var1;
        } else {
            return Integer.toString(this.orderInParent);
        }
    }

    @Override
    public int a(com.github.kill05.algobuildce.package_a.c.a.b var1, int var2) {
        return 0;
    }

    public String toString() {
        return "ABI_Base [parent=" + this.parent + ", orderInParent=" + this.orderInParent + "]";
    }

    @Override
    public String b() {
        return null;
    }

    protected String getName() {
        return null;
    }

    public ABBlockDataHolder h() {
        ABBlockDataHolder var1;
        (var1 = new ABBlockDataHolder()).putData("path", this.c());
        var1.putData("abiid", this.getName());
        return var1;
    }

    public void a(ABBlockDataHolder var1) {
    }

    public JsonObject b(boolean var1) {
        JsonObject var2;
        (var2 = new JsonObject()).put("abiid", this.getName());
        return var2;
    }

    public void a(JsonObject var1, boolean var2) {
    }

    public static ABInstructionBlock deserialize(JsonObject jsonObject) {
        String instruction = (String) jsonObject.getNullable("abiid");
        if (instruction == null) return null;

        switch (instruction) {
            case "ABIASS":
                return new ABAssignInstructionBlock();
            case "ABICAL":
                return new c();
            case "ABICOM":
                return new ABCommentBlock();
            case "ABIDOW":
                return new ABDoWhileBlock();
            case "ABIFOR":
                return new ABForBlock();
            case "ABIWHI":
                return new ABWhileBlock();
            case "ABIINP":
                return new ABInputBlock();
            case "ABIOUT":
                return new ABOutputBlock();
            case "ABIIF_":
                return new ABIfBlock();
            case "ABRCOD":
                return new q();
        }

        return null;
    }

    public abstract p i();
}
