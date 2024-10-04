package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutionFragment;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_c.ABInstructionException;

public final class ABDoWhileBlock extends h {

    public ABDoWhileBlock(String var1) {
        super(var1);
    }

    public ABDoWhileBlock() {
        super(null);
    }

    @Override
    public int a(ABProgram var1, int var2) {
        String var3 = this.l().replace('\n', ' ');
        if (var2 == 0) {
            ABExecutionFragment var8 = new ABExecutionFragment(this.m(), var1);
            var1.d().push(var8);
            return 1;
        } else {
            boolean var7;
            try {
                boolean var4;
                com.github.kill05.algobuildce.package_c.l var6;
                var7 = var4 = (var6 = var1.e().a(var3, var1.c())) instanceof com.github.kill05.algobuildce.package_c.h && ((com.github.kill05.algobuildce.package_c.h) var6).a();
                var1.h("DO-WHILE TEST:  " + var3 + "   RESULT: " + var4);
                var1.i();
            } catch (ABInstructionException var5) {
                var1.i("DO-WHILE ERROR: " + var5 + " IN " + var3);
                return -2;
            }

            return var7 ? 0 : -1;
        }
    }

    public String toString() {
        return "ABICycleDoWhile  [ " + super.toString() + "]";
    }

    @Override
    public ABExecutable copy() {
        ABDoWhileBlock var1 = new ABDoWhileBlock(this.l());

        try {
            for (int var2 = 0; var2 < this.getInstructionAmount(); ++var2) {
                ABInstructionBlock var3 = this.getInstruction(var2);
                var1.addInstruction((ABInstructionBlock) var3.copy());
            }
        } catch (r var4) {
            var4.printStackTrace();
        } catch (s var5) {
            var5.printStackTrace();
        }

        return var1;
    }

    @Override
    public boolean b(int var1) {
        return var1 == 1;
    }

    @Override
    protected String getId() {
        return "ABIDOW";
    }
}
