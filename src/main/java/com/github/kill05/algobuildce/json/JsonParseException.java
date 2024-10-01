package com.github.kill05.algobuildce.json;

public final class JsonParseException extends RuntimeException {

    private Throwable cause;

    public JsonParseException(String var1) {
        super(var1);
    }

    public JsonParseException(Throwable var1) {
        super(var1.getMessage());
        this.cause = var1;
    }

    @Override
    public Throwable getCause() {
        return this.cause;
    }
}
