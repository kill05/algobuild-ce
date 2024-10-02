package com.github.kill05.algobuildce.json;

public class JsonNull {

    public static final JsonNull INSTANCE = new JsonNull();

    private JsonNull() {
    }

    @SuppressWarnings("RedundantThrows")
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this;
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object var1) {
        return var1 == null || var1 == this;
    }

    public String toString() {
        return "null";
    }

}
