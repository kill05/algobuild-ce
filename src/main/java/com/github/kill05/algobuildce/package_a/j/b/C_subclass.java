package com.github.kill05.algobuildce.package_a.j.b;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class C_subclass {
    private D_subclass b;
    protected ABBasePanel a;

    public C_subclass(D_subclass var1) {
        this.b = var1;
    }

    public abstract void a(ABBasePanel var1, Graphics var2);

    public abstract void a(ABBasePanel var1);

    public final D_subclass a() {
        return this.b;
    }

    public final void b(ABBasePanel var1) {
        this.a = var1;
    }

    public final void a(Rectangle var1) {
        if (this.a != null && this.a instanceof ABInstructionPanel) {
            ((ABInstructionPanel)this.a).b(var1);
        }

    }
}
