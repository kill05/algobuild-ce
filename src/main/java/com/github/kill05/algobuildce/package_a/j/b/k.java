package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.b.ABInputBlock;
import com.github.kill05.algobuildce.package_a.c.b.ABInstructionBlock;

public final class k extends j {
    public k(com.github.kill05.algobuildce.package_a.c.a.b var1, com.github.kill05.algobuildce.package_a.j.a.a var2, ABExecutable var3) {
        super(var1, var2, var3);
        this.a("in");
    }

    @Override
    protected void modifyInstruction() {
        com.github.kill05.algobuildce.package_a.g.e var1 = new com.github.kill05.algobuildce.package_a.g.e((ABInstructionBlock) this.i);
        if (com.github.kill05.algobuildce.package_a.a.g.a(this.c.a(), (ABInputBlock) this.i)) {
            this.c.c().a(var1);
            this.b.update(true);
        }

        this.b.a((ABExecutable) null);
    }
}
