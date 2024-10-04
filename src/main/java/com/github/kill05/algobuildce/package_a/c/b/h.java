package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.json.JsonArray;
import com.github.kill05.algobuildce.json.JsonObject;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.IInstructionPanel;
import com.github.kill05.algobuildce.package_a.f.ABBlockDataHolder;

import java.util.Iterator;

public abstract class h extends ABInstructionBlock {
    private o b;
    private String c;

    public h(String var1) {
        this.c = var1;
        this.b = new o();
    }

    public final String l() {
        return this.c;
    }

    public final void c(String var1) {
        this.c = var1;
        this.a(true);
    }

    public String getDisplayName() {
        return this.c;
    }

    protected final o m() {
        return this.b;
    }

    public final void addInstruction(ABInstructionBlock instruction) {
        int var2 = this.b.getInstructionAmount();
        this.b.addInstruction(instruction);
        instruction.a((ABExecutable) this, var2);
        if (this.a != null) {
            for (IInstructionPanel k : this.a) {
                k.a(instruction, var2);
            }

            instruction.f();
        }

    }

    public final void addInstruction(ABInstructionBlock instruction, int index) {
        if (index < this.b.getInstructionAmount()) {
            this.b.addInstruction(instruction, index);
            instruction.a((ABExecutable) this, index);
            if (this.a != null) {
                Iterator var4 = this.a.iterator();

                while (var4.hasNext()) {
                    ((IInstructionPanel) var4.next()).a(instruction, index);
                }

                instruction.f();
                return;
            }
        } else {
            this.addInstruction(instruction);
        }

    }

    @Override
    public final void removeInstruction(int index) {
        if (this.a != null) {
            Iterator var3 = this.a.iterator();

            while (var3.hasNext()) {
                ((IInstructionPanel) var3.next()).a(index);
            }
        }

        this.b.removeInstruction(index);
    }

    public final int getInstructionAmount() {
        return this.b.getInstructionAmount();
    }

    public final ABInstructionBlock getInstruction(int index) {
        return this.b.getInstruction(index);
    }

    public String toString() {
        return "ABICycle_Base [getOrderInParent()=" + this.getOrderInParent() + ", condition=" + this.c + "\nbody=" + this.b + ", condition=" + this.c + "]";
    }

    public final boolean a() {
        return true;
    }

    @Override
    public ABBlockDataHolder h() {
        ABBlockDataHolder var1;
        (var1 = super.h()).putData("condition", this.c);
        return var1;
    }

    public void a(ABBlockDataHolder var1) {
        super.a(var1);
        String var2 = var1.getData("condition");
        this.c(var2);
    }

    public JsonObject b(boolean var1) {
        JsonObject var2;
        (var2 = super.b(var1)).put("condition", this.c);
        if (var1) {
            for (int var3 = 0; var3 < this.b.getInstructionAmount(); ++var3) {
                var2.a("body", (Object) this.b.getInstruction(var3).b(true));
            }
        }

        return var2;
    }

    public void a(JsonObject var1, boolean var2) {
        super.a(var1, var2);
        String var3 = var1.getAsString("condition");
        this.c(var3);
        if (var2) {
            try {
                this.b.j();
            } catch (t var6) {
                var6.printStackTrace();
            }

            JsonArray var8;
            if ((var8 = var1.getAsJsonArray("body")) != null) {
                for (int var7 = 0; var7 < var8.size(); ++var7) {
                    JsonObject var4;
                    ABInstructionBlock var5;
                    (var5 = ABInstructionBlock.deserialize(var4 = var8.getAsJsonObject(var7))).a(var4, var2);
                    this.addInstruction(var5);
                }
            }
        }

    }

    @Override
    public final void f() {
        if (this.a != null) {
            try {
                for (int var1 = 0; var1 < this.b.getInstructionAmount(); ++var1) {
                    ABInstructionBlock var2 = this.getInstruction(var1);

                    for (IInstructionPanel panel : this.a) {
                        panel.a(var2, var1);
                    }

                    var2.f();
                }

            } catch (r var5) {
                var5.printStackTrace();
            }
        }

    }

    @Override
    public p i() {
        p var1;
        (var1 = new p(1, this.c.length())).a(this.b.i());
        return var1;
    }
}
