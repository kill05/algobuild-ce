package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.json.JsonObject;
import com.github.kill05.algobuildce.package_a.f.ABBlockDataHolder;

public abstract class ABSelectionBlockBase extends ABInstructionBlock {

    private String condition;

    public ABSelectionBlockBase(String condition) {
        this.condition = condition;
    }

    public final String getCondition() {
        return this.condition;
    }

    public final void setCondition(String var1) {
        this.condition = var1;
        this.a(true);
    }

    @Override
    public final String getDisplayName() {
        return this.condition;
    }

    public String toString() {
        return "ABISelection_Base [condition=" + this.condition + ", getOrderInParent()=" + this.getOrderInParent() + "]";
    }

    @Override
    public final boolean a() {
        return true;
    }

    @Override
    public final ABBlockDataHolder h() {
        ABBlockDataHolder var1;
        (var1 = super.h()).putData("condition", this.condition);
        return var1;
    }

    @Override
    public final void a(ABBlockDataHolder var1) {
        super.a(var1);
        String var2 = var1.getData("condition");
        this.setCondition(var2);
    }

    @Override
    public JsonObject b(boolean var1) {
        JsonObject var2;
        (var2 = super.b(var1)).put("condition", this.condition);
        return var2;
    }

    @Override
    public void a(JsonObject var1, boolean var2) {
        super.a(var1, var2);
        String var3 = var1.getAsString("condition");
        this.setCondition(var3);
    }

    @Override
    public p i() {
        return new p(1, this.condition.length());
    }
}
