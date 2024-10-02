package com.github.kill05.algobuildce.package_a.f;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class ABFileOutputStream extends FileOutputStream {
    private static final String a = "AlgoBuild01.00\n";
    private int b = 0;

    public ABFileOutputStream(String var1) throws FileNotFoundException {
        super(var1);
    }

    @Override
    public void write(byte[] var1, int var2, int var3) throws IOException {
        if (this.b == 0) {
            byte[] var4 = this.a.getBytes();
            super.write(var4, 0, var4.length);
        }

        super.write(var1, var2, var3);
        this.b += var3;
    }

    @Override
    public void write(byte[] var1) throws IOException {
        if (this.b == 0) {
            byte[] var2 = this.a.getBytes();
            super.write(var2, 0, var2.length);
        }

        super.write(var1);
        this.b += var1.length;
    }

    @Override
    public final void write(int var1) throws IOException {
        if (this.b == 0) {
            byte[] var2 = this.a.getBytes();
            super.write(var2, 0, var2.length);
        }

        super.write(var1);
        ++this.b;
    }
}
