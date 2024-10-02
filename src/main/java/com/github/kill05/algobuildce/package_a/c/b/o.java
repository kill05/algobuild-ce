package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutionFragment;
import com.github.kill05.algobuildce.package_a.c.a.IInstructionPanel;

import java.util.Iterator;
import java.util.Vector;

public final class o extends ABInstructionBlock {
    private final Vector<ABInstructionBlock> instructions = new Vector<>();

    @Override
    public boolean b(int var1) {
        return false;
    }

    @Override
    public boolean a(int var1) {
        int var2 = this.instructions.size();
        return var1 >= 0 && var1 < var2;
    }

    @Override
    public ABInstructionBlock getInstruction(int index) {
        return this.instructions.get(index);
    }

    @Override
    public void addInstruction(ABInstructionBlock instruction) {
        int var2 = this.instructions.size();
        instruction.a((ABExecutable) this, var2);
        this.instructions.add(instruction);
        if (this.a != null) {
            for (IInstructionPanel k : this.a) {
                k.a(instruction, var2);
            }
        }

    }

    @Override
    public void addInstruction(ABInstructionBlock instruction, int index) {
        for (int var3 = index; var3 < this.instructions.size(); ++var3) {
            this.getInstruction(var3).f(1);
        }

        instruction.a((ABExecutable) this, index);
        this.instructions.add(index, instruction);
        if (this.a != null) {

            for (IInstructionPanel k : this.a) {
                k.a(instruction, index);
            }
        }

        instruction.f();
    }

    @Override
    public void removeInstruction(int index) {
        this.instructions.remove(index);

        for (int var2 = index; var2 < this.instructions.size(); ++var2) {
            this.getInstruction(var2).f(-1);
        }

        if (this.a != null) {
            for (IInstructionPanel k : this.a) {
                k.a(index);
            }
        }

    }

    public void j() {
        while (!this.instructions.isEmpty()) {
            this.removeInstruction(0);
        }

    }

    @Override
    public int getInstructionAmount() {
        return this.instructions.size();
    }

    @Override
    public int a(com.github.kill05.algobuildce.package_a.c.a.b var1, int var2) {
        if (this.a(var2)) {
            int var3 = var2++;
            ABExecutionFragment var4 = new ABExecutionFragment((ABExecutable) this.instructions.get(var3), var1);
            var1.d().push(var4);
        } else {
            var2 = -1;
        }

        return var2;
    }

    public String toString() {
        return "ABICompound [getOrderInParent()=" + this.getOrderInParent() + "\ninstructions=" + this.instructions + "]";
    }

    @Override
    public boolean a() {
        return true;
    }

    @Override
    public void f() {
        if (this.a != null) {
            for (int var1 = 0; var1 < this.instructions.size(); ++var1) {
                ABInstructionBlock var2 = this.getInstruction(var1);
                Iterator var4 = this.a.iterator();

                while (var4.hasNext()) {
                    ((IInstructionPanel) var4.next()).a(var2, var1);
                }

                var2.f();
            }
        }

    }

    @Override
    public p i() {
        p var1 = new p();

        for (int var2 = 0; var2 < this.instructions.size(); ++var2) {
            ABInstructionBlock var3 = this.getInstruction(var2);
            var1.a(var3.i());
        }

        return var1;
    }
}
