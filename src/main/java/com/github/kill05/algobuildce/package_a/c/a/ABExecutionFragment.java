package com.github.kill05.algobuildce.package_a.c.a;

public final class ABExecutionFragment {
    private int a = -1;
    private final ABExecutable executable;
    private final ABProgram c;

    public ABExecutionFragment(ABExecutable var1, ABProgram var2) {
        this.executable = var1;
        this.c = var2;
        if (this.executable != null) {
            this.a = 0;
        }

    }

    public void a() {
        this.a = this.executable.a(this.c, this.a);
        if (this.a == -1) {
            this.c.d().pop();
        }

    }

    public String toString() {
        return "ABEExecFragment [status=" + this.a + ", executable=" + this.executable + "]";
    }

    public boolean b() {
        return this.executable.b(this.a);
    }

    public int c() {
        return this.a;
    }

    public ABExecutable d() {
        return this.executable;
    }
}
