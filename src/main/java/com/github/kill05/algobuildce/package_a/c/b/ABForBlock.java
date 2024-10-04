package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.json.JsonObject;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutionFragment;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.f.ABBlockDataHolder;
import com.github.kill05.algobuildce.package_c.ABInstructionException;

public final class ABForBlock extends h {
    private String b;
    private String c;

    public ABForBlock(String var1, String var2, String var3) {
        super(var2);
        this.b = var1;
        this.c = var3;
    }

    public ABForBlock() {
        super(null);
        this.b = null;
        this.c = null;
    }

    @Override
    public String getDisplayName() {
        return this.b + "; " + this.l() + "; " + this.c;
    }

    public String j() {
        return this.b;
    }

    public void a(String var1) {
        this.b = var1;
        this.a(true);
    }

    public String k() {
        return this.c;
    }

    public void b(String var1) {
        this.c = var1;
        this.a(true);
    }

    @Override
    public int a(ABProgram var1, int var2) {
        com.github.kill05.algobuildce.package_c.l var3;
        String var8;
        if (var2 == 0) {
            var8 = this.b;

            try {
                var3 = var1.e().a(var8, var1.c());
                var1.h("FOR INITIALIZATION: " + var8 + "   RESULT: " + var3);
                return 1;
            } catch (ABInstructionException var5) {
                var1.i("FOR INITIALIZATION ERROR: " + var5 + " IN " + var8);
                return -2;
            }
        } else if (var2 == 1) {
            var8 = this.l();

            boolean var10;
            try {
                boolean var4;
                var10 = var4 = (var3 = var1.e().a(var8, var1.c())) instanceof com.github.kill05.algobuildce.package_c.h && ((com.github.kill05.algobuildce.package_c.h) var3).a();
                var1.h("FOR TEST:  " + var8 + "   RESULT: " + var4);
                var1.i();
            } catch (ABInstructionException var7) {
                var1.i("FOR TEST ERROR: " + var7 + " IN " + var8);
                return -2;
            }

            return var10 ? 2 : -1;
        } else if (var2 == 2) {
            ABExecutionFragment var9 = new ABExecutionFragment(this.m(), var1);
            var1.d().push(var9);
            return 3;
        } else if (var2 == 3) {
            var8 = this.c;

            try {
                var3 = var1.e().a(var8, var1.c());
                var1.h("FOR INCREMENT: " + var8 + "   RESULT: " + var3);
                return 1;
            } catch (ABInstructionException var6) {
                var1.i("FOR INCREMENT ERROR: " + var6 + " IN " + var8);
                return -2;
            }
        } else {
            return -1;
        }
    }

    public String toString() {
        return "ABICycleFor  [ " + super.toString() + "]";
    }

    @Override
    protected String getId() {
        return "ABIFOR";
    }

    @Override
    public ABBlockDataHolder h() {
        ABBlockDataHolder var1 = super.h();
        var1.putData("initialization", this.b);
        var1.putData("increment", this.c);
        return var1;
    }

    @Override
    public void a(ABBlockDataHolder var1) {
        super.a(var1);
        String var2 = var1.getData("initialization");
        this.a(var2);
        var2 = var1.getData("increment");
        this.b(var2);
    }

    @Override
    public JsonObject b(boolean var1) {
        JsonObject var2;
        (var2 = super.b(var1)).put("initialization", this.b);
        var2.put("increment", this.c);
        return var2;
    }

    @Override
    public void a(JsonObject var1, boolean var2) {
        super.a(var1, var2);
        String var3 = var1.getAsString("initialization");
        this.a(var3);
        var3 = var1.getAsString("increment");
        this.b(var3);
    }

    @Override
    public ABExecutable copy() {
        ABForBlock var1 = new ABForBlock(this.b, this.l(), this.c);

        try {
            for (int var2 = 0; var2 < this.getInstructionAmount(); ++var2) {
                ABInstructionBlock var3 = this.getInstruction(var2);
                var1.addInstruction((ABInstructionBlock) var3.copy());
            }
        } catch (s var4) {
            var4.printStackTrace();
        } catch (r var5) {
            var5.printStackTrace();
        }

        return var1;
    }

    @Override
    public boolean b(int var1) {
        return var1 == 0 || var1 == 3;
    }

    @Override
    public p i() {
        p var1;
        (var1 = super.i()).a(0, this.b.length() + this.c.length());
        return var1;
    }
}
