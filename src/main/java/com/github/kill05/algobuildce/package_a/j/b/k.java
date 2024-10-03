package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.b.ABInputBlock;
import com.github.kill05.algobuildce.package_a.c.b.ABInstructionBlock;
import com.github.kill05.algobuildce.package_a.j.a.ABFlowChartPanel;

public final class k extends j {
    public k(ABProgram var1, ABFlowChartPanel var2, ABExecutable var3) {
        super(var1, var2, var3);
        this.a("in");
    }

    @Override
    protected void modifyInstruction() {
        com.github.kill05.algobuildce.package_a.g.e var1 = new com.github.kill05.algobuildce.package_a.g.e((ABInstructionBlock) this.executable);
        if (com.github.kill05.algobuildce.package_a.a.g.a(this.flowChartPanel.getFrame(), (ABInputBlock) this.executable)) {
            this.flowChartPanel.c().a(var1);
            this.program.update(true);
        }

        this.program.a((ABExecutable) null);
    }
}
