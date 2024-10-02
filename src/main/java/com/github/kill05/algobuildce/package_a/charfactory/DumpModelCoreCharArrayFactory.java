package com.github.kill05.algobuildce.package_a.charfactory;

public final class DumpModelCoreCharArrayFactory extends CharArrayFactory {

    protected int getArrayLength() {
        return 19;
    }

    protected char getCharAt(int var1) {
        char var2 = 0;
        switch (var1) {
            case 0:
                var2 = 'D';
                break;
            case 1:
                var2 = 'u';
                break;
            case 2:
                var2 = 'm';
                break;
            case 3:
                var2 = 'p';
                break;
            case 4:
                var2 = 'M';
                break;
            case 5:
            case 10:
                var2 = 'o';
                break;
            case 6:
                var2 = 'd';
                break;
            case 7:
            case 12:
                var2 = 'e';
                break;
            case 8:
            case 15:
                var2 = 'l';
                break;
            case 9:
                var2 = 'C';
                break;
            case 11:
                var2 = 'r';
                break;
            case 13:
                var2 = '.';
                break;
            case 14:
                var2 = 'c';
                break;
            case 16:
                var2 = 'a';
                break;
            case 17:
            case 18:
                var2 = 's';
        }

        return var2;
    }
}
