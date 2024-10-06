package com.github.kill05.algobuildce.package_a.j.a;

public final class ConsoleMessage {

    private String message;
    private int indent;
    private boolean isEndLine;
    private boolean isTrace;
    private boolean isError;

    public ConsoleMessage() {
    }

    public ConsoleMessage(String message, int indent, boolean isEndLine, boolean isTrace, boolean isError) {
        this.message = message;
        this.indent = indent;
        this.isEndLine = isEndLine;
        this.isTrace = isTrace;
        this.isError = isError;
    }

    public String getMessage() {
        return this.message;
    }

    public int getIndent() {
        return this.indent;
    }

    public boolean isEndLine() {
        return this.isEndLine;
    }

    public boolean isTrace() {
        return this.isTrace;
    }

    public boolean isError() {
        return this.isError;
    }

    public String toString() {
        return "ABVConsoleMessages [msgText=" + this.message + ", indent=" + this.indent + ", endLine=" + this.isEndLine + ", traceMsg=" + this.isTrace + ", errorMsg=" + this.isError + "]";
    }
}
