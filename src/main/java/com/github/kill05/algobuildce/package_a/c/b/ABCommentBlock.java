package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.json.JsonObject;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.f.ABBlockDataHolder;

public final class ABCommentBlock extends ABInstructionBlock {
    private String b;

    public ABCommentBlock(String var1) {
        this.a(var1);
    }

    public ABCommentBlock() {
        this.a((String) null);
    }

    @Override
    public String b() {
        return this.b;
    }

    public void a(String var1) {
        this.b = var1;
        if (var1 != null) {
            var1.split("\n|;");
        }

        this.a(true);
    }

    @Override
    public int a(com.github.kill05.algobuildce.package_a.c.a.b var1, int var2) {
        return -1;
    }

    @Override
    public String toString() {
        return this.getOrderInParent() + "- ABIComment: " + this.b + "\n";
    }

    @Override
    protected String getName() {
        return "ABICOM";
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
        ABCommentBlock var1;
        (var1 = new ABCommentBlock()).a(this.b);
        return var1;
    }

    @Override
    public boolean b(int var1) {
        return false;
    }

    @Override
    public p i() {
        return new p(1, this.b.length());
    }
}
