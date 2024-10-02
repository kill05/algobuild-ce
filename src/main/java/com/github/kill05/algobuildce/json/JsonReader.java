package com.github.kill05.algobuildce.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public final class JsonReader {
    private long a;
    private boolean b;
    private long c;
    private long d;
    private char e;
    private final Reader f;
    private boolean g;

    public JsonReader(Reader var1) {
        this.f = var1.markSupported() ? var1 : new BufferedReader(var1);
        this.b = false;
        this.g = false;
        this.e = 0;
        this.c = 0L;
        this.a = 1L;
        this.d = 1L;
    }

    public void stepBack() {
        if (!this.g && this.c > 0L) {
            --this.c;
            --this.a;
            this.g = true;
            this.b = false;
        } else {
            throw new JsonParseException("Stepping back two steps is not supported");
        }
    }

    private char d() {
        int var1;
        if (this.g) {
            this.g = false;
            var1 = this.e;
        } else {
            try {
                var1 = this.f.read();
            } catch (IOException e) {
                throw new JsonParseException(e);
            }

            if (var1 <= 0) {
                this.b = true;
                var1 = 0;
            }
        }

        ++this.c;
        if (this.e == '\r') {
            ++this.d;
            this.a = var1 == 10 ? 0 : 1;
        } else if (var1 == 10) {
            ++this.d;
            this.a = 0L;
        } else {
            ++this.a;
        }

        this.e = (char) var1;
        return this.e;
    }

    private String a(int var1) {
        char[] var4 = new char[4];

        for (int var2 = 0; var2 < 4; ++var2) {
            var4[var2] = this.d();
            if (this.b && !this.g) {
                throw this.throwJsonException("Substring bounds error");
            }
        }

        return new String(var4);
    }

    public char b() {
        char var1;
        while ((var1 = this.d()) != 0 && var1 <= ' ') {
        }

        return var1;
    }

    public Object c() {
        char var1;
        switch (var1 = this.b()) {
            case '"':
            case '\'':
                char var2 = var1;
                JsonReader var5 = this;
                StringBuilder var4 = new StringBuilder();

                while (true) {
                    char var3;
                    switch (var3 = var5.d()) {
                        case '\u0000':
                        case '\n':
                        case '\r':
                            throw var5.throwJsonException("Unterminated string");
                        case '\\':
                            switch (var3 = var5.d()) {
                                case '"':
                                case '\'':
                                case '/':
                                case '\\':
                                    var4.append(var3);
                                    continue;
                                case 'b':
                                    var4.append('\b');
                                    continue;
                                case 'f':
                                    var4.append('\f');
                                    continue;
                                case 'n':
                                    var4.append('\n');
                                    continue;
                                case 'r':
                                    var4.append('\r');
                                    continue;
                                case 't':
                                    var4.append('\t');
                                    continue;
                                case 'u':
                                    var4.append((char) Integer.parseInt(var5.a(4), 16));
                                    continue;
                                default:
                                    throw var5.throwJsonException("Illegal escape.");
                            }
                        default:
                            if (var3 == var2) {
                                return var4.toString();
                            }

                            var4.append(var3);
                    }
                }
            case '[':
                this.stepBack();
                return new JSONArray(this);
            case '{':
                this.stepBack();
                return new JSONObject(this);
            default:
                StringBuilder var7;
                for (var7 = new StringBuilder(); var1 >= ' ' && ",:]}/\\\"[{;=#".indexOf(var1) < 0; var1 = this.d()) {
                    var7.append(var1);
                }

                this.stepBack();
                String var6 = var7.toString().trim();
                if (var6.isEmpty()) {
                    throw this.throwJsonException("Missing value");
                } else {
                    return JSONObject.h(var6);
                }
        }
    }

    public JsonParseException throwJsonException(String var1) {
        return new JsonParseException(var1 + this.toString());
    }

    public String toString() {
        return " at " + this.c + " [character " + this.a + " line " + this.d + "]";
    }
}
