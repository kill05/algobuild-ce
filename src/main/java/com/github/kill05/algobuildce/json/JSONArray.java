package com.github.kill05.algobuildce.json;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class JSONArray implements Iterable<Object> {

    private final ArrayList<Object> list;

    public JSONArray() {
        this.list = new ArrayList<>();
    }

    public JSONArray(f var1) {
        this();
        if (var1.b() != '[') {
            throw var1.throwJsonException("A JSONArray text must start with '['");
        } else if (var1.b() != ']') {
            var1.a();

            while (true) {
                if (var1.b() == ',') {
                    var1.a();
                    this.list.add(JSONObject.NULL);
                } else {
                    var1.a();
                    this.list.add(var1.c());
                }

                switch (var1.b()) {
                    case ',':
                        if (var1.b() == ']') {
                            return;
                        }

                        var1.a();
                        break;
                    case ']':
                        return;
                    default:
                        throw var1.throwJsonException("Expected a ',' or ']'");
                }
            }
        }
    }

    public JSONArray(@Nullable Collection<?> var1) {
        this.list = var1 != null ? new ArrayList<>(var1.size()) : new ArrayList<>();

        if (var1 != null) {
            for (Object object : var1) {
                this.list.add(JSONObject.encodeJson(object));
            }
        }
    }

    public JSONArray(Object var1) {
        this();
        if (!var1.getClass().isArray()) {
            throw new JsonParseException("JSONArray initial value should be a string or collection or array.");
        }

        int var2 = Array.getLength(var1);

        for (int var3 = 0; var3 < var2; ++var3) {
            this.a(JSONObject.encodeJson(Array.get(var1, var3)));
        }
    }

    @Override
    public @NotNull Iterator<Object> iterator() {
        return this.list.iterator();
    }

    public Object a(int var1) {
        Object var10000 = var1 >= 0 && var1 < this.list.size() ? this.list.get(var1) : null;
        Object var2 = var10000;
        if (var10000 == null) {
            throw new JsonParseException("JSONArray[" + var1 + "] not found.");
        } else {
            return var2;
        }
    }

    public int get(int var1) {
        Object var2 = this.a(var1);

        try {
            return var2 instanceof Number ? ((Number) var2).intValue() : Integer.parseInt((String) var2);
        } catch (Exception var3) {
            throw new JsonParseException("JSONArray[" + var1 + "] is not a number.");
        }
    }

    public JSONObject c(int var1) {
        Object var2;
        if ((var2 = this.a(var1)) instanceof JSONObject) {
            return (JSONObject) var2;
        } else {
            throw new JsonParseException("JSONArray[" + var1 + "] is not a JSONObject.");
        }
    }

    public String d(int var1) {
        Object var2;
        if ((var2 = this.a(var1)) instanceof String) {
            return (String) var2;
        } else {
            throw new JsonParseException("JSONArray[" + var1 + "] not a string.");
        }
    }

    public int size() {
        return this.list.size();
    }

    public JSONArray add(int var1) {
        this.a(var1);
        return this;
    }

    public JSONArray a(Object var1) {
        this.list.add(var1);
        return this;
    }

    public String toString() {
        try {
            return this.f(0);
        } catch (Exception var1) {
            return null;
        }
    }

    private String f(int var1) {
        StringWriter var4;
        synchronized ((var4 = new StringWriter()).getBuffer()) {
            return this.write(var4, 0, 0).toString();
        }
    }

    Writer write(Writer var1, int var2, int var3) {
        try {
            boolean var4 = false;
            int var5 = this.list.size();
            var1.write(91);
            if (var5 == 1) {
                JSONObject.writeJson(var1, this.list.get(0), var2, var3);
            } else if (var5 != 0) {
                int var6 = var3 + var2;

                for (int var7 = 0; var7 < var5; ++var7) {
                    if (var4) {
                        var1.write(44);
                    }

                    if (var2 > 0) {
                        var1.write(10);
                    }

                    JSONObject.a(var1, var6);
                    JSONObject.writeJson(var1, this.list.get(var7), var2, var6);
                    var4 = true;
                }

                if (var2 > 0) {
                    var1.write(10);
                }

                JSONObject.a(var1, var3);
            }

            var1.write(93);
            return var1;
        } catch (IOException var8) {
            throw new JsonParseException(var8);
        }
    }
}
