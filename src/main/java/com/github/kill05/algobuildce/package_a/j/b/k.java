package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.blocks.ABInputBlock;
import com.github.kill05.algobuildce.package_a.c.blocks.ABInstructionBlock;
import com.github.kill05.algobuildce.package_a.j.a.ABTabbedProgramPanel;

public final class k extends j {
    public k(ABProgram var1, ABTabbedProgramPanel var2, ABExecutable var3) {
        super(var1, var2, var3);
        this.a("in");
    }

    @Override
    protected void modifyInstruction() {
        com.github.kill05.algobuildce.package_a.g.e var1 = new com.github.kill05.algobuildce.package_a.g.e((ABInstructionBlock) this.executable);
        if (com.github.kill05.algobuildce.package_a.dialogs.g.a(this.flowChartPanel.getFrame(), (ABInputBlock) this.executable)) {
            this.flowChartPanel.c().a(var1);
            this.program.update(true);
        }

        this.program.a((ABExecutable) null);
    }
}
