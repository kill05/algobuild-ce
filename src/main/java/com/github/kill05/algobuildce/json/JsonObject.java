package com.github.kill05.algobuildce.json;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public final class JsonObject {

    private final Map<String, Object> b;

    public JsonObject() {
        this.b = new HashMap<>();
    }

    public JsonObject(JsonReader var1) {
        this();
        if (var1.b() != '{') {
            throw var1.throwJsonException("A JSONObject text must begin with '{'");
        }

        while (true) {
            switch (var1.b()) {
                case '\u0000':
                    throw var1.throwJsonException("A JSONObject text must end with '}'");
                case '}':
                    return;
                default:
                    var1.stepBack();
                    String var3 = var1.c().toString();
                    if (var1.b() != ':') {
                        throw var1.throwJsonException("Expected a ':' after a key");
                    }

                    this.c(var3, var1.c());
                    switch (var1.b()) {
                        case ',':
                        case ';':
                            if (var1.b() == '}') {
                                return;
                            }

                            var1.stepBack();
                            break;
                        case '}':
                            return;
                        default:
                            throw var1.throwJsonException("Expected a ',' or '}'");
                    }
            }
        }

    }

    private JsonObject(Map<?, ?> var1) {
        this.b = new HashMap<>();

        if (var1 != null) {
            for (Entry<?, ?> entry : var1.entrySet()) {
                Object var3 = entry.getValue();

                if (var3 != null) {
                    this.b.put(entry.getKey().toString(), encodeJson(var3));
                }
            }
        }

    }

    private JsonObject(Object var1) {
        this();
        JsonObject var9 = this;
        Class<?> var3 = var1.getClass();
        Method[] var10 = var3.getClassLoader() != null ? var3.getMethods() : var3.getDeclaredMethods();

        for (Method method : var10) {
            try {
                Method var5;
                if (Modifier.isPublic((var5 = method).getModifiers())) {
                    String var6 = var5.getName();
                    String var7 = "";
                    if (var6.startsWith("get")) {
                        if (!"getClass".equals(var6) && !"getDeclaringClass".equals(var6)) {
                            var7 = var6.substring(3);
                        } else {
                            var7 = "";
                        }
                    } else if (var6.startsWith("is")) {
                        var7 = var6.substring(2);
                    }

                    if (!var7.isEmpty() && Character.isUpperCase(var7.charAt(0)) && var5.getParameterTypes().length == 0) {
                        if (var7.length() == 1) {
                            var7 = var7.toLowerCase();
                        } else if (!Character.isUpperCase(var7.charAt(1))) {
                            var7 = var7.substring(0, 1).toLowerCase() + var7.substring(1);
                        }

                        Object var11;
                        if ((var11 = var5.invoke(var1, (Object[]) null)) != null) {
                            var9.b.put(var7, encodeJson(var11));
                        }
                    }
                }
            } catch (Exception ignored) {
            }
        }

    }

    public JsonObject a(String var1, Object var2) {
        checkFinite(var2);
        Object var3;
        if ((var3 = this.getNullable(var1)) == null) {
            this.put(var1, (new JsonArray()).add(var2));
        } else {
            if (!(var3 instanceof JsonArray)) {
                throw new JsonParseException("JSONObject[" + var1 + "] is not a JSONArray.");
            }

            this.put(var1, ((JsonArray) var3).add(var2));
        }

        return this;
    }

    @NotNull
    private Object get(String key) {
        if (key == null) {
            throw new JsonParseException("Null key.");
        }

        Object var2 = this.getNullable(key);
        if (var2 == null) {
            throw new JsonParseException("JSONObject[" + g(key) + "] not found.");
        }

        return var2;
    }

    public int getAsInt(String key) {
        Object var2 = this.get(key);

        try {
            return var2 instanceof Number ? ((Number) var2).intValue() : Integer.parseInt((String) var2);
        } catch (Exception var3) {
            throw new JsonParseException("JSONObject[" + g(key) + "] is not an int.");
        }
    }

    public JsonArray getAsArray(String var1) {
        Object var2;
        if ((var2 = this.get(var1)) instanceof JsonArray) {
            return (JsonArray) var2;
        } else {
            throw new JsonParseException("JSONObject[" + g(var1) + "] is not a JSONArray.");
        }
    }

    private long getAsLong(String var1) {
        Object var2 = this.get(var1);

        try {
            return var2 instanceof Number ? ((Number) var2).longValue() : Long.parseLong((String) var2);
        } catch (Exception var3) {
            throw new JsonParseException("JSONObject[" + g(var1) + "] is not a long.");
        }
    }

    public Set<String> keySet() {
        return this.b.keySet();
    }

    private static String serializeNumber(Number var0) {
        if (var0 == null) {
            throw new JsonParseException("Null pointer");
        }

        checkFinite(var0);

        String var1 = var0.toString();
        if (var1.indexOf(46) > 0 && var1.indexOf(101) < 0 && var1.indexOf(69) < 0) {
            while (var1.endsWith("0")) {
                var1 = var1.substring(0, var1.length() - 1);
            }

            if (var1.endsWith(".")) {
                var1 = var1.substring(0, var1.length() - 1);
            }
        }

        return var1;
    }

    @Nullable
    public Object getNullable(String key) {
        return key != null ? this.b.get(key) : null;
    }

    @Nullable
    public JsonArray getAsJsonArray(String key) {
        Object value = this.getNullable(key);
        return (value instanceof JsonArray) ? (JsonArray) value : null;
    }

    @Nullable
    public JsonObject getAsJsonObject(String key) {
        Object var2 = getNullable(key);
        return var2 instanceof JsonObject ? (JsonObject) var2 : null;
    }

    public long getAsLong(String key, long def) {
        try {
            return this.getAsLong(key);
        } catch (Exception var4) {
            return def;
        }
    }

    public String getAsString(String key) {
        return this.getAsString(key, "");
    }

    public String getAsString(String key, String def) {
        Object value = this.getNullable(key);
        return isJsonNull(value) ? def : String.valueOf(value);
    }



    public JsonObject put(String key, Object value) {
        if (key == null) {
            throw new NullPointerException("Null key.");
        }

        if (value != null) {
            checkFinite(value);
            this.b.put(key, value);
        } else {
            this.b.remove(key);
        }

        return this;
    }

    public JsonObject c(String var1, Object var2) {
        if (var1 != null && var2 != null) {
            if (this.getNullable(var1) != null) {
                throw new JsonParseException("Duplicate key \"" + var1 + "\"");
            }

            this.put(var1, var2);
        }

        return this;
    }

    public static String g(String var0) {
        StringWriter var1;
        synchronized ((var1 = new StringWriter()).getBuffer()) {
            String var10000;
            try {
                var10000 = a(var0, var1).toString();
            } catch (IOException var3) {
                return "";
            }

            return var10000;
        }
    }

    private static Writer a(String var0, Writer var1) throws IOException {
        if (var0 != null && !var0.isEmpty()) {
            char var3 = 0;
            int var5 = var0.length();
            var1.write(34);

            for (int var4 = 0; var4 < var5; ++var4) {
                char var2 = var3;
                switch (var3 = var0.charAt(var4)) {
                    case '\b':
                        var1.write("\\b");
                        continue;
                    case '\t':
                        var1.write("\\t");
                        continue;
                    case '\n':
                        var1.write("\\n");
                        continue;
                    case '\f':
                        var1.write("\\f");
                        continue;
                    case '\r':
                        var1.write("\\r");
                        continue;
                    case '"':
                    case '\\':
                        var1.write(92);
                        break;
                    case '/':
                        if (var2 == '<') {
                            var1.write(92);
                        }

                        var1.write(var3);
                        continue;
                    default:
                        if (var3 < ' ' || var3 >= 128 && var3 < 160 || var3 >= 8192 && var3 < 8448) {
                            var1.write("\\u");
                            String var6 = Integer.toHexString(var3);
                            var1.write("0000", 0, 4 - var6.length());
                            var1.write(var6);
                            continue;
                        }
                }

                var1.write(var3);
            }

            var1.write(34);
        } else {
            var1.write("\"\"");
        }
        return var1;
    }

    public static Object h(String var0) {
        if (var0.isEmpty()) {
            return var0;
        } else if (var0.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        } else if (var0.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        } else if (var0.equalsIgnoreCase("null")) {
            return JsonNull.INSTANCE;
        } else {
            char var1;
            if ((var1 = var0.charAt(0)) >= '0' && var1 <= '9' || var1 == '-') {
                try {
                    if (var0.indexOf(46) < 0 && var0.indexOf(101) < 0 && var0.indexOf(69) < 0) {
                        long var4 = Long.parseLong(var0);
                        if (var0.equals(Long.toString(var4))) {
                            if (var4 == (long) (int) var4) {
                                return (int) var4;
                            }

                            return var4;
                        }
                    } else {
                        double var3;
                        if (!Double.isInfinite(var3 = Double.parseDouble(var0)) && !Double.isNaN(var3)) {
                            return var3;
                        }
                    }
                } catch (Exception ignored) {
                }
            }

            return var0;
        }
    }

    private static void checkFinite(Object object) {
        if (object == null) return;

        if (object instanceof Double) {
            Double value = (Double) object;

            if (value.isInfinite() || value.isNaN()) {
                throw new JsonParseException("JSON does not allow non-finite numbers.");
            }
        }

        if (object instanceof Float) {
            Float value = (Float) object;

            if (value.isInfinite() || value.isNaN()) {
                throw new JsonParseException("JSON does not allow non-finite numbers.");
            }
        }
    }

    public String toString() {
        try {
            return this.a();
        } catch (Exception var1) {
            return null;
        }
    }

    private String a() {
        StringWriter var4;
        synchronized ((var4 = new StringWriter()).getBuffer()) {
            return this.write(var4, 0, 0).toString();
        }
    }

    public static String toJsonString(Object object) {
        if (object == null) {
            return "null";
        }

        if (object instanceof JsonSerializable) {
            String var4;
            try {
                var4 = ((JsonSerializable) object).serialize();
            } catch (Exception var1) {
                throw new JsonParseException(var1);
            }

            if (var4 != null) {
                return var4;
            } else {
                throw new JsonParseException("Bad value from toJSONString: " + null);
            }
        } else if (object instanceof Number) {
            return serializeNumber((Number) object);
        } else if (!(object instanceof Boolean) && !(object instanceof JsonObject) && !(object instanceof JsonArray)) {
            if (object instanceof Map<?, ?>) {
                return (new JsonObject(object)).toString();
            } else if (object instanceof Collection<?>) {
                return (new JsonArray(object)).toString();
            } else {
                return object.getClass().isArray() ? (new JsonArray(object)).toString() : g(object.toString());
            }
        } else {
            return object.toString();
        }
    }

    public static Object encodeJson(Object object) {
        try {
            if (object == null) {
                return JsonNull.INSTANCE;
            } else if (!(object instanceof JsonObject) &&
                    !(object instanceof JsonArray) &&
                    !isJsonNull(object) &&
                    !(object instanceof JsonSerializable) &&
                    !(object instanceof Byte) &&
                    !(object instanceof Character) &&
                    !(object instanceof Short) &&
                    !(object instanceof Integer) &&
                    !(object instanceof Long) &&
                    !(object instanceof Boolean) &&
                    !(object instanceof Float) &&
                    !(object instanceof Double) &&
                    !(object instanceof String) &&
                    !(object instanceof BigInteger) &&
                    !(object instanceof BigDecimal)
            ) {
                if (object instanceof Collection<?>) {
                    return new JsonArray(object);
                } else {
                    Class<?> clazz = object.getClass();

                    if (clazz.isArray() || object instanceof Map<?, ?>) {
                        return new JsonArray(object);
                    }

                    Package var1 = clazz.getPackage();
                    String var3 = var1 != null ? var1.getName() : "";
                    return (!var3.startsWith("java.") && !var3.startsWith("javax.") && clazz.getClassLoader() != null)
                            ? new JsonObject(object)
                            : object.toString();
                }
            } else {
                return object;
            }
        } catch (Exception var2) {
            return null;
        }
    }

    @SuppressWarnings("UnusedReturnValue")
    static Writer writeJson(Writer writer, Object object, int var2, int var3) throws IOException {
        if (object == null) {
            writer.write("null");
            return writer;
        }

        if (object instanceof JsonObject) {
            ((JsonObject) object).write(writer, var2, var3);
        } else if (object instanceof JsonArray) {
            ((JsonArray) object).write(writer, var2, var3);
        } else if (object instanceof Map<?, ?>) {
            new JsonObject((Map<?, ?>) object).write(writer, var2, var3);
        } else if (object instanceof Collection<?>) {
            new JsonArray((Collection<?>) object).write(writer, var2, var3);
        } else if (object.getClass().isArray()) {
            new JsonArray(object).write(writer, var2, var3);
        } else if (object instanceof Number) {
            writer.write(serializeNumber((Number) object));
        } else if (object instanceof Boolean) {
            writer.write(object.toString());
        } else if (object instanceof JsonSerializable) {
            try {
                String serialized = ((JsonSerializable) object).serialize();
                writer.write(serialized != null ? serialized : g(object.toString()));
            } catch (Exception e) {
                throw new JsonParseException(e);
            }
        } else {
            a(object.toString(), writer);
        }

        return writer;
    }


    private static boolean isJsonNull(Object value) {
        return JsonNull.INSTANCE.equals(value);
    }


    static void a(Writer var0, int var1) throws IOException {
        for (int var2 = 0; var2 < var1; ++var2) {
            var0.write(32);
        }

    }

    private Writer write(Writer writer, int var2, int var3) {
        try {
            boolean var4 = false;
            int var5 = this.b.size();
            Iterator<String> var6 = this.keySet().iterator();
            writer.write(123);
            if (var5 == 1) {
                Object var9 = var6.next();
                writer.write(g(var9.toString()));
                writer.write(58);
                if (var2 > 0) {
                    writer.write(32);
                }

                writeJson(writer, this.b.get(var9), var2, var3);
            } else if (var5 != 0) {
                for (var5 = var3 + var2; var6.hasNext(); var4 = true) {
                    Object var7 = var6.next();
                    if (var4) {
                        writer.write(44);
                    }

                    if (var2 > 0) {
                        writer.write(10);
                    }

                    a(writer, var5);
                    writer.write(g(var7.toString()));
                    writer.write(58);
                    if (var2 > 0) {
                        writer.write(32);
                    }

                    writeJson(writer, this.b.get(var7), var2, var5);
                }

                if (var2 > 0) {
                    writer.write(10);
                }

                a(writer, var3);
            }

            writer.write(125);
            return writer;
        } catch (IOException var8) {
            throw new JsonParseException(var8);
        }
    }
}
