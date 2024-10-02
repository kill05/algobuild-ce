package com.github.kill05.algobuildce.json;

import java.io.IOException;
import java.io.Writer;

public final class JsonWriter {
    private boolean a = false;
    private char b = 'i';
    private final JSONObject[] c = new JSONObject[200];
    private int d = 0;
    private final Writer e;

    public JsonWriter(Writer var1) {
        this.e = var1;
    }

    private JsonWriter b(String var1) {
        if (var1 == null) {
            throw new JsonParseException("Null pointer");
        } else if (this.b != 'o' && this.b != 'a') {
            throw new JsonParseException("Value out of sequence.");
        } else {
            try {
                if (this.a && this.b == 'a') {
                    this.e.write(44);
                }

                this.e.write(var1);
            } catch (IOException var2) {
                throw new JsonParseException(var2);
            }

            if (this.b == 'o') {
                this.b = 'k';
            }

            this.a = true;
            return this;
        }
    }

    private JsonWriter a(char var1, char var2) {
        if (this.b != 'k') {
            throw new JsonParseException("Misplaced endObject.");
        } else {
            byte var5 = 107;
            if (this.d <= 0) {
                throw new JsonParseException("Nesting error.");
            } else if ((this.c[this.d - 1] == null ? 97 : 107) != var5) {
                throw new JsonParseException("Nesting error.");
            } else {
                --this.d;
                this.b = (char) (this.d == 0 ? 100 : (this.c[this.d - 1] == null ? 97 : 107));

                try {
                    this.e.write(125);
                } catch (IOException var4) {
                    throw new JsonParseException(var4);
                }

                this.a = true;
                return this;
            }
        }
    }

    public JsonWriter end() {
        return this.a('k', '}');
    }

    public JsonWriter writeKey(String var1) {
        if (var1 == null) {
            throw new JsonParseException("Null key.");
        }

        if (this.b == 'k') {
            try {
                this.c[this.d - 1].c(var1, Boolean.TRUE);
                if (this.a) {
                    this.e.write(44);
                }

                this.e.write(JSONObject.g(var1));
                this.e.write(58);
                this.a = false;
                this.b = 'o';
                return this;
            } catch (IOException var2) {
                throw new JsonParseException(var2);
            }
        } else {
            throw new JsonParseException("Misplaced key.");
        }
    }

    public JsonWriter start() {
        if (this.b == 'i') {
            this.b = 'o';
        }

        if (this.b != 'o' && this.b != 'a') {
            throw new JsonParseException("Misplaced object.");
        } else {
            this.b("{");
            JSONObject var2 = new JSONObject();
            if (this.d >= 200) {
                throw new JsonParseException("Nesting too deep.");
            } else {
                this.c[this.d] = var2;
                this.b = 'k';
                ++this.d;
                this.a = false;
                return this;
            }
        }
    }

    public JsonWriter writeValue(Object var1) {
        return this.b(JSONObject.toJsonString(var1));
    }
}
