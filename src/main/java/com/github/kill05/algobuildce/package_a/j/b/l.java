package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.b.ABInstructionBlock;
import com.github.kill05.algobuildce.package_a.c.b.ABOutputBlock;
import com.github.kill05.algobuildce.package_a.j.a.ABTabbedProgramPanel;

public final class l extends j {

    public l(ABProgram var1, ABTabbedProgramPanel var2, ABExecutable var3) {
        super(var1, var2, var3);
    }

    @Override
    public void a() {
        int var1;
        if ((var1 = ((ABOutputBlock) this.executable).j()) == 0) {
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
        com.github.kill05.algobuildce.package_a.g.e var1 = new com.github.kill05.algobuildce.package_a.g.e((ABInstructionBlock) this.executable);
        if (com.github.kill05.algobuildce.package_a.a.h.a(this.flowChartPanel.getFrame(), (ABOutputBlock) this.executable)) {
            this.flowChartPanel.c().a(var1);
            this.program.update(true);
        }

        this.program.a((ABExecutable) null);
    }
}
