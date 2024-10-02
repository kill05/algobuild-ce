package com.github.kill05.algobuildce.package_a.c.a;

import com.github.kill05.algobuildce.package_a.c.b.ABInstructionBlock;
import com.github.kill05.algobuildce.package_a.c.b.r;
import com.github.kill05.algobuildce.package_a.c.b.s;
import com.github.kill05.algobuildce.package_a.c.b.t;

import java.util.Vector;

public abstract class ABExecutable {

    protected Vector<IInstructionPanel> a = null;


    public abstract int a(ABProgram var1, int var2);

    public boolean a(int var1) {
        return var1 != -1;
    }

    public boolean b(int var1) {
        return true;
    }

    public boolean a() {
        return false;
    }

    public abstract String b();

    public abstract String c();

    public ABInstructionBlock getInstruction(int index) {
        throw new s("ABEExecutable getInstr(" + index + ")");
    }

    public void addInstruction(ABInstructionBlock instruction) {
        throw new s("ABEExecutable addInstr(" + instruction + ")");
    }

    public void addInstruction(ABInstructionBlock instruction, int index) {
        throw new s("ABEExecutable addInstr(" + instruction + "," + index + ")");
    }

    public void removeInstruction(int index) {
        throw new t("ABEExecutable removeInstr(" + index + ")");
    }

    public int getInstructionAmount() {
        throw new r("ABEExecutable getNInstr()");
    }


    public final void a(IInstructionPanel var1) {
        if (var1 != null) {
            if (this.a == null) {
                this.a = new Vector<>();
            }

            this.a.add(var1);
            var1.a(this);
        }

    }

    public final void a(boolean var1) {
        if (this.a != null) {
            for (IInstructionPanel k : this.a) {
                k.a(this, var1);
            }
        }

    }

    public ABExecutable copy() {
        return null;
    }

    public void f() {
    }
}
