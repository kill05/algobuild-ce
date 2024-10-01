package com.github.kill05.algobuildce.json;

import org.jetbrains.annotations.NotNull;

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

public final class JSONObject {

    private final Map<String, Object> b;
    public static final Object NULL = NullValue.INSTANCE;

    public JSONObject() {
        this.b = new HashMap<>();
    }

    public JSONObject(f var1) {
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
                    var1.a();
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

                            var1.a();
                            break;
                        case '}':
                            return;
                        default:
                            throw var1.throwJsonException("Expected a ',' or '}'");
                    }
            }
        }

    }

    private JSONObject(Map<?, ?> var1) {
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

    private JSONObject(Object var1) {
        this();
        JSONObject var9 = this;
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

    public JSONObject a(String var1, Object var2) {
        checkFinite(var2);
        Object var3;
        if ((var3 = this.c(var1)) == null) {
            this.b(var1, (new JSONArray()).a(var2));
        } else {
            if (!(var3 instanceof JSONArray)) {
                throw new JsonParseException("JSONObject[" + var1 + "] is not a JSONArray.");
            }

            this.b(var1, ((JSONArray) var3).a(var2));
        }

        return this;
    }

    @NotNull
    private Object get(String key) {
        if (key == null) {
            throw new JsonParseException("Null key.");
        }

        Object var2 = this.c(key);
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

    public JSONArray getAsArray(String var1) {
        Object var2;
        if ((var2 = this.get(var1)) instanceof JSONArray) {
            return (JSONArray) var2;
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

    public Object c(String var1) {
        return var1 == null ? null : this.b.get(var1);
    }

    public JSONArray d(String var1) {
        Object var2;
        return (var2 = this.c(var1)) instanceof JSONArray ? (JSONArray) var2 : null;
    }

    public JSONObject e(String var1) {
        Object var2;
        return (var2 = this.c(var1)) instanceof JSONObject ? (JSONObject) var2 : null;
    }

    public long a(String var1, long var2) {
        try {
            return this.getAsLong(var1);
        } catch (Exception var4) {
            return 0L;
        }
    }

    public String f(String var1) {
        return this.a(var1, "");
    }

    public String a(String var1, String var2) {
        Object var3 = this.c(var1);
        return NULL.equals(var3) ? var2 : var3.toString();
    }

    public JSONObject b(String var1, Object var2) {
        if (var1 == null) {
            throw new NullPointerException("Null key.");
        } else {
            if (var2 != null) {
                checkFinite(var2);
                this.b.put(var1, var2);
            } else {
                this.b.remove(var1);
            }

            return this;
        }
    }

    public JSONObject c(String var1, Object var2) {
        if (var1 != null && var2 != null) {
            if (this.c(var1) != null) {
                throw new JsonParseException("Duplicate key \"" + var1 + "\"");
            }

            this.b(var1, var2);
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
            return var1;
        } else {
            var1.write("\"\"");
            return var1;
        }
    }

    public static Object h(String var0) {
        if (var0.isEmpty()) {
            return var0;
        } else if (var0.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        } else if (var0.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        } else if (var0.equalsIgnoreCase("null")) {
            return NULL;
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

        if (object instanceof JSONSerializable) {
            String var4;
            try {
                var4 = ((JSONSerializable) object).serialize();
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
        } else if (!(object instanceof Boolean) && !(object instanceof JSONObject) && !(object instanceof JSONArray)) {
            if (object instanceof Map<?, ?>) {
                return (new JSONObject(object)).toString();
            } else if (object instanceof Collection<?>) {
                return (new JSONArray(object)).toString();
            } else {
                return object.getClass().isArray() ? (new JSONArray(object)).toString() : g(object.toString());
            }
        } else {
            return object.toString();
        }
    }

    public static Object encodeJson(Object object) {
        try {
            if (object == null) {
                return NULL;
            } else if (!(object instanceof JSONObject) &&
                    !(object instanceof JSONArray) &&
                    !NULL.equals(object) &&
                    !(object instanceof JSONSerializable) &&
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
                    return new JSONArray(object);
                } else {
                    Class<?> clazz = object.getClass();

                    if (clazz.isArray() || object instanceof Map<?, ?>) {
                        return new JSONArray(object);
                    }

                    Package var1 = clazz.getPackage();
                    String var3 = var1 != null ? var1.getName() : "";
                    return (!var3.startsWith("java.") && !var3.startsWith("javax.") && clazz.getClassLoader() != null)
                            ? new JSONObject(object)
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

        if (object instanceof JSONObject) {
            ((JSONObject) object).write(writer, var2, var3);
        } else if (object instanceof JSONArray) {
            ((JSONArray) object).write(writer, var2, var3);
        } else if (object instanceof Map<?, ?>) {
            new JSONObject((Map<?, ?>) object).write(writer, var2, var3);
        } else if (object instanceof Collection<?>) {
            new JSONArray((Collection<?>) object).write(writer, var2, var3);
        } else if (object.getClass().isArray()) {
            new JSONArray(object).write(writer, var2, var3);
        } else if (object instanceof Number) {
            writer.write(serializeNumber((Number) object));
        } else if (object instanceof Boolean) {
            writer.write(object.toString());
        } else if (object instanceof JSONSerializable) {
            try {
                String serialized = ((JSONSerializable) object).serialize();
                writer.write(serialized != null ? serialized : g(object.toString()));
            } catch (Exception e) {
                throw new JsonParseException(e);
            }
        } else {
            a(object.toString(), writer);
        }

        return writer;
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
