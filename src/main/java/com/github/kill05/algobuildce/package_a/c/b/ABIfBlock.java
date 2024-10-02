package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.json.JsonArray;
import com.github.kill05.algobuildce.json.JsonObject;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutionFragment;
import com.github.kill05.algobuildce.package_c.ABInstructionException;

public final class ABIfBlock extends ABSelectionBlockBase {

    private final o trueBody;
    private final o falseBody;

    public ABIfBlock(String var1) {
        super(var1);
        this.trueBody = new o();
        this.trueBody.a(this, 1);
        this.falseBody = new o();
        this.falseBody.a(this, 2);
    }

    public ABIfBlock() {
        this(null);
    }

    public o j() {
        return this.trueBody;
    }

    public o k() {
        return this.falseBody;
    }

    @Override
    public ABInstructionBlock getInstruction(int index) {
        if (index == 1) {
            return this.trueBody;
        } else if (index == 2) {
            return this.falseBody;
        } else {
            throw new s("ABISelectionIf getInstr(" + index + ")");
        }
    }

    @Override
    public int a(com.github.kill05.algobuildce.package_a.c.a.b var1, int var2) {
        if (var2 == 0) {
            String condition = this.getCondition().replace('\n', ' ');

            boolean var7;
            try {
                com.github.kill05.algobuildce.package_c.l var3;
                boolean var4;
                var7 = var4 = (var3 = var1.e().a(condition, var1.c())) instanceof com.github.kill05.algobuildce.package_c.h && ((com.github.kill05.algobuildce.package_c.h) var3).a();
                var1.h("IF TEST:  " + condition + "   RESULT: " + var4);
                var1.i();
            } catch (ABInstructionException var5) {
                var1.i("IF ERROR: " + var5 + " IN " + condition);
                return -2;
            }

            ABExecutionFragment var8;
            if (var7) {
                var1.d().pop();
                var8 = new ABExecutionFragment(this.trueBody, var1);
                var1.d().push(var8);
                return 1;
            } else {
                var1.d().pop();
                var8 = new ABExecutionFragment(this.falseBody, var1);
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
        return "ABISelectionIf " + this.getCondition() + " [bodyTrue=" + this.trueBody + ", bodyFalse=" + this.falseBody + ", getOrderInParent()=" + this.getOrderInParent() + "]";
    }

    @Override
    public JsonObject b(boolean var1) {
        JsonObject var2 = super.b(var1);
        if (var1) {
            for (int i = 0; i < this.falseBody.getInstructionAmount(); i++) {
                var2.a("0", this.falseBody.getInstruction(i).b(true));
            }

            for (int i = 0; i < this.trueBody.getInstructionAmount(); i++) {
                var2.a("1", this.trueBody.getInstruction(i).b(true));
            }
        }

        return var2;
    }

    @Override
    public void a(JsonObject var1, boolean var2) {
        super.a(var1, var2);
        if (var2) {
            try {
                this.falseBody.j();
                this.trueBody.j();
            } catch (t var7) {
                var7.printStackTrace();
            }

            JsonArray var3;
            int var4;
            JsonObject var5;
            ABInstructionBlock var6;
            if ((var3 = var1.getAsJsonArray("0")) != null) {
                for (var4 = 0; var4 < var3.size(); ++var4) {
                    (var6 = ABInstructionBlock.deserialize(var5 = var3.getAsJsonObject(var4))).a(var5, var2);
                    this.falseBody.addInstruction(var6);
                }
            }

            if ((var3 = var1.getAsJsonArray("1")) != null) {
                for (var4 = 0; var4 < var3.size(); ++var4) {
                    (var6 = ABInstructionBlock.deserialize(var5 = var3.getAsJsonObject(var4))).a(var5, var2);
                    this.trueBody.addInstruction(var6);
                }
            }
        }

    }

    @Override
    public ABExecutable copy() {
        ABIfBlock var1 = new ABIfBlock(this.getCondition());

        int var2;
        for (var2 = 0; var2 < this.trueBody.getInstructionAmount(); ++var2) {
            ABInstructionBlock instruction = this.trueBody.getInstruction(var2);
            var1.trueBody.addInstruction((ABInstructionBlock) instruction.copy());
        }

        for (var2 = 0; var2 < this.falseBody.getInstructionAmount(); ++var2) {
            ABInstructionBlock instruction = this.falseBody.getInstruction(var2);
            var1.falseBody.addInstruction((ABInstructionBlock) instruction.copy());
        }

        return var1;
    }

    @Override
    public void f() {
        if (this.a != null) {
            this.trueBody.f();
            this.falseBody.f();
        }

    }

    @Override
    protected String getName() {
        return "ABIIF_";
    }

    @Override
    public p i() {
        p var1;
        (var1 = super.i()).a(this.trueBody.i());
        var1.a(this.falseBody.i());
        return var1;
    }
}
