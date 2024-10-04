package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.j.a.ABTabbedProgramPanel;

import java.awt.Component;
import java.awt.Dimension;

public final class e extends ABInstructionPanel {

    public e(ABProgram var1, ABTabbedProgramPanel var2, ABExecutable var3) {
        super(var1, var2, var3);
        this.a(var3);
        this.setLayout(null);
        (new f(var1, var2)).a(this, 0);
        this.g();
        this.a(this.d);
    }

    @Override
    public void a(ABExecutable var1, int var2) {
        ABInstructionPanel var3 = this.b(var1);
        this.a(var3, var2);
        var1.a(var3);
        this.g();
        this.d = true;
        this.a(this.d);
        this.revalidate();
    }

    @Override
    public void a() {
        Dimension var1 = new Dimension(2 * this.centerX, 0);
        Component[] var2 = this.getComponents();

        int var3;
        for (var3 = 0; var3 < var2.length; ++var3) {
            if (var2[var3] instanceof ABBasePanel) {
                ((ABBasePanel) var2[var3]).g();
            }

            Dimension var4;
            if ((var4 = var2[var3].getMinimumSize()).width > var1.width) {
                var1.width = var4.width;
            }

            var1.height += var4.height;
        }

        this.forceSize(var1);
        var3 = 0;

        for (int var7 = 0; var7 < var2.length; ++var7) {
            Dimension var5 = var2[var7].getMinimumSize();
            int var6 = (int) (var1.getWidth() - var5.getWidth()) / 2;
            var2[var7].setLocation(var6, var3);
            var3 = (int) ((double) var3 + var5.getHeight());
        }

    }

    public void a(ABInstructionPanel var1, int var2) {
        if (var1 != null) {
            f var3 = new f(this.program, this.flowChartPanel);
            this.add(var3, var2 << 1);
            this.add(var1, (var2 << 1) + 1);
            if (this.h != null) {
                C_subclass var4 = this.h.a().a(var3);
                var3.a(var4);
                var4 = this.h.a().a(var1);
                var1.a(var4);
            }

            this.g();
        }

    }

    public void b(int var1) {
        if ((var1 << 1) + 1 < this.getComponentCount()) {
            this.remove(var1 << 1);
            this.remove(var1 << 1);
            this.g();
        }

    }

    @Override
    public void a(int var1) {
        this.b(var1);
        this.a(true);
        this.invalidate();
    }

    @Override
    public void a(C_subclass var1) {
        super.a(var1);
        Component[] var2 = this.getComponents();

        for (int var3 = 0; var3 < var2.length; ++var3) {
            if (var2[var3] instanceof ABBasePanel) {
                ABBasePanel var4 = (ABBasePanel) var2[var3];
                C_subclass var5 = var1.a().a(var4);
                var4.a(var5);
            }
        }

    }
}
