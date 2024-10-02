package com.github.kill05.algobuildce.package_a.charfactory;

// Probably used to bypass false antivirus flags
public class CharArrayFactory {

    protected int getArrayLength() {
        return 0;
    }

    protected char getCharAt(int var1) {
        return '\u0000';
    }

    public final char[] createArray() {
        char[] chars = null;
        if (this.getArrayLength() > 0) {
            int var2;
            chars = new char[var2 = this.getArrayLength()];

            for (int var3 = 0; var3 < var2; ++var3) {
                chars[var3] = this.getCharAt(var3);
            }
        }

        return chars;
    }
}
