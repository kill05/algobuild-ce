package com.github.kill05.algobuildce.package_a.g;

import com.github.kill05.algobuildce.package_a.c.b.ABInstructionBlock;
import com.github.kill05.algobuildce.package_a.f.ABBlockDataHolder;

public final class e extends g {

    private final ABInstructionBlock block;
    private final ABBlockDataHolder holder1;
    private ABBlockDataHolder holder2 = null;

    public e(ABInstructionBlock var1) {
        this.block = var1;
        this.holder1 = var1.h();
    }

    @Override
    public void a() {
        this.block.a(this.holder2);
    }

    @Override
    public void b() {
        if (this.holder2 == null) {
            this.holder2 = this.block.h();
        }

        this.block.a(this.holder1);
    }
}
