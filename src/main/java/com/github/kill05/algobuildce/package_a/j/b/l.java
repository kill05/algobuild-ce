package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.b.ABInstructionBlock;
import com.github.kill05.algobuildce.package_a.c.b.ABOutputBlock;

public final class l extends j {

    public l(com.github.kill05.algobuildce.package_a.c.a.b var1, com.github.kill05.algobuildce.package_a.j.a.a var2, ABExecutable var3) {
        super(var1, var2, var3);
    }

    @Override
    public void a() {
        int var1;
        if ((var1 = ((ABOutputBlock) this.i).j()) == 0) {
            this.a("out");
        } else if (var1 == 1) {
            this.a("outln");
        } else if (var1 == 2) {
            this.a("outLN");
        }

        super.a();
    }

    @Override
    protected void modifyInstruction() {
        com.github.kill05.algobuildce.package_a.g.e var1 = new com.github.kill05.algobuildce.package_a.g.e((ABInstructionBlock) this.i);
        if (com.github.kill05.algobuildce.package_a.a.h.a(this.c.a(), (ABOutputBlock) this.i)) {
            this.c.c().a(var1);
            this.b.update(true);
        }

        this.b.a((ABExecutable) null);
    }
}
