package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.json.JsonArray;
import com.github.kill05.algobuildce.json.JsonObject;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutionFragment;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.a.IInstructionPanel;
import com.github.kill05.algobuildce.package_a.f.ABBlockDataHolder;
import com.github.kill05.algobuildce.package_c.ABInstructionException;

import java.util.Vector;

public final class q extends ABInstructionBlock {

    String name;
    private final o body;
    private int e;
    Vector<String> parameters;
    private String f = null;

    public q(String var1, int var2) {
        this.name = var1;
        this.e = var2;
        this.body = new o();
        this.body.a(this, -1);
        this.parameters = new Vector<>();
    }

    public q() {
        this.name = null;
        this.e = 0;
        this.body = new o();
        this.body.a(this, -1);
        this.parameters = new Vector<>();
    }

    public String j() {
        return this.name;
    }

    public void a(String var1) {
        this.name = var1;
    }

    public void b(String var1) {
        if (!this.parameters.contains(var1)) {
            this.parameters.add(var1);
        }

    }

    public int k() {
        return this.parameters.size();
    }

    public String e(int var1) {
        return this.parameters.get(var1);
    }

    public String l() {
        return this.f;
    }

    public void c(String var1) {
        this.f = var1;
    }

    @Override
    public int a(ABProgram var1, int var2) {
        if (var2 == 0) {
            var1.h("START:" + this.name);
            ABExecutionFragment var6 = new ABExecutionFragment(this.body, var1);
            var1.d().push(var6);
            return 1;
        } else if (var2 == 1) {
            if (this.f != null && !this.f.isEmpty()) {
                com.github.kill05.algobuildce.package_c.f var4;
                if ((var4 = (com.github.kill05.algobuildce.package_c.f) var1.c().get(this.f)) != null) {
                    var4 = var4.c();
                    var1.c().put("_RETVAL_", var4);
                    var1.h("FUNCTION RETURN:" + this.f + " result:" + var4.toString());
                } else {
                    try {
                        com.github.kill05.algobuildce.package_c.l var5 = var1.e().a(this.f, var1.c());
                        var1.c().put("_RETVAL_", new com.github.kill05.algobuildce.package_c.m(var5));
                        var1.h("FUNCTION RETURN:" + this.f + " result:" + var5);
                    } catch (ABInstructionException var3) {
                        var1.i("FUNCTION RETURN ERROR: " + var3 + " IN " + this.f);
                        return -2;
                    }
                }
            }

            if (this.e == 1) {
                var1.h("END:" + this.name);
            } else {
                var1.h("RET:" + this.name);
            }

            return -1;
        } else {
            return -1;
        }
    }

    @Override
    public void addInstruction(ABInstructionBlock instruction) {
        int var2 = this.body.getInstructionAmount();
        instruction.a(this, var2);
        this.body.addInstruction(instruction);
        if (this.a != null) {

            for (IInstructionPanel iInstructionPanel : this.a) {
                iInstructionPanel.a(instruction, var2);
            }

            instruction.f();
        }

    }

    @Override
    public void addInstruction(ABInstructionBlock instruction, int index) {
        if (index < this.body.getInstructionAmount()) {
            this.body.addInstruction(instruction, index);
            instruction.a(this, index);
            if (this.a != null) {

                for (IInstructionPanel iInstructionPanel : this.a) {
                    iInstructionPanel.a(instruction, index);
                }

                instruction.f();
            }
        } else {
            this.addInstruction(instruction);
        }

    }

    @Override
    public void removeInstruction(int index) {
        if (this.a != null) {

            for (IInstructionPanel panel : this.a) {
                panel.a(index);
            }
        }

        this.body.removeInstruction(index);
    }

    @Override
    public int getInstructionAmount() {
        return this.body.getInstructionAmount();
    }

    @Override
    public ABInstructionBlock getInstruction(int index) {
        return this.body.getInstruction(index);
    }

    @Override
    public String c() {
        return this.name;
    }

    public String toString() {
        return "ABR_Base [name=" + this.name + ", body=" + this.body + ", formalParams=" + this.parameters + "]";
    }

    @Override
    public String b() {
        return this.name;
    }

    @Override
    public boolean a() {
        return true;
    }

    public int m() {
        return this.e;
    }

    public void g(int var1) {
        this.e = var1;
    }

    public void o() {
        this.parameters.clear();
    }

    @Override
    public ABBlockDataHolder h() {
        ABBlockDataHolder var1;
        (var1 = super.h()).putData("codeType", Integer.toString(this.e));
        var1.putData("name", this.name);
        int var2;
        if ((var2 = this.parameters.size()) > 0) {
            String var3 = this.e(0);

            for (int var4 = 1; var4 < var2; ++var4) {
                var3 = var3 + "\n" + this.e(var4);
            }

            var1.putData("formalParams", var3);
        }

        if (this.f != null) {
            var1.putData("returnExpr", this.f);
        }

        return var1;
    }

    @Override
    public void a(ABBlockDataHolder var1) {
        super.a(var1);
        String var2 = var1.getData("codeType");
        this.e = Integer.parseInt(var2);
        var2 = var1.getData("name");
        this.name = var2;
        var2 = var1.getData("formalParams");
        this.parameters.clear();
        if (var2 != null) {
            String[] var4 = var2.split("\\n");

            for (String s : var4) {
                this.b(s);
            }
        }

        if ((var2 = var1.getData("returnExpr")) != null) {
            this.f = var2;
        }

        this.a(true);
    }

    @Override
    public JsonObject b(boolean var1) {
        JsonObject var2;
        (var2 = super.b(var1)).put("codeType", Integer.toString(this.e));
        var2.put("name", this.name);
        int var3;
        int var4;
        if ((var3 = this.parameters.size()) > 0) {
            for (var4 = 0; var4 < var3; ++var4) {
                String var5;
                if (!(var5 = this.e(var4).trim()).isEmpty()) {
                    var2.a("formalParams", var5);
                }
            }
        }

        var4 = this.body.getInstructionAmount();
        if (var1) {
            for (int var7 = 0; var7 < var4; ++var7) {
                JsonObject var6 = this.getInstruction(var7).b(true);
                var2.a("body", var6);
            }
        }

        if (this.f != null && !this.f.isEmpty()) {
            var2.put("returnExpr", this.f);
        }

        return var2;
    }

    @Override
    public void a(JsonObject var1, boolean var2) {
        super.a(var1, var2);
        this.e = var1.getAsInt("codeType");
        this.name = var1.getAsString("name");
        JsonArray var13 = var1.getAsJsonArray("formalParams");
        this.parameters.clear();

        if (var13 != null) {
            for (int var4 = 0; var4 < var13.size(); ++var4) {
                String var5 = var13.getAsString(var4);
                if (var4 < this.parameters.size()) {
                    this.parameters.set(var4, var5);
                } else {
                    this.parameters.add(var5);
                }

                System.out.println("SET PARAMETER  i=" + var4 + " par=" + var5);
            }
        }

        String var15;
        if ((var15 = var1.getAsString("returnExpr")) != null) {
            this.f = var15;
        }

        if (var2) {
            JsonArray var17 = var1.getAsJsonArray("body");

            try {
                this.body.j();
            } catch (t var9) {
                var9.printStackTrace();
            }

            if (var17 != null) {
                for (int var10 = 0; var10 < var17.size(); ++var10) {
                    JsonObject var14;
                    ABInstructionBlock var16;
                    (var16 = ABInstructionBlock.deserialize(var14 = var17.getAsJsonObject(var10))).a(var14, var2);
                    this.addInstruction(var16);
                }
            }
        }

        this.a(true);
    }

    @Override
    protected String getName() {
        return "ABRCOD";
    }

    @Override
    public void f() {
        if (this.a != null) {
            for (int var1 = 0; var1 < this.body.getInstructionAmount(); ++var1) {
                ABInstructionBlock var2 = this.getInstruction(var1);

                for (IInstructionPanel value : this.a) {
                    value.a(var2, var1);
                }

                var2.f();
            }
        }

    }

    @Override
    public p i() {
        p var1;
        (var1 = new p(1, this.name.length())).a(this.body.i());
        int var2 = this.parameters.size();

        for (int var3 = 0; var3 < var2; ++var3) {
            var1.a(0, this.e(var3).length());
        }

        return var1;
    }
}
