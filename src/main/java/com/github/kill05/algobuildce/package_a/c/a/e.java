package com.github.kill05.algobuildce.package_a.c.a;

import com.github.kill05.algobuildce.package_a.c.b.ABInstructionBlock;
import com.github.kill05.algobuildce.package_a.c.b.q;

public final class e {

    private final ABProgram program;

    public e(ABProgram program) {
        this.program = program;
    }

    public void a(String var1) {
        q var3 = this.program.a(var1);
        ABExecutionFragment var2 = new ABExecutionFragment(var3, this.program);
        this.program.d().push(var2);
        this.program.f();

        if (var3 != null) {
            var3.a(false);
        }

    }

    public void a() {
        ABExecutable var1;
        if (this.b() && (var1 = this.program.d().peek().d()) instanceof ABInstructionBlock) {
            var1.a(false);
        }

        this.program.reset();
    }

    public boolean b() {
        return this.program != null && !this.program.d().empty();
    }

    public void c() {
        boolean var1 = this.b();

        while (var1) {
            ABExecutionFragment var2;
            ABExecutable var3;
            if ((var2 = this.program.d().peek()) != null) {
                var2.a();
                if (var2.c() == -2) {
                    this.program.d().clear();
                }

                if ((var3 = var2.d()) instanceof ABInstructionBlock) {
                    var3.a(false);
                }
            }

            if (this.program.d().empty()) {
                var1 = false;
            } else {
                if ((var2 = this.program.d().peek()) == null || var2.b()) {
                    var1 = false;
                }

                if (var2 != null && (var3 = var2.d()) instanceof ABInstructionBlock) {
                    var3.a(false);
                }
            }
        }
    }
}
