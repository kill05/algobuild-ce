package com.github.kill05.algobuildce.package_c;

public final class ABInstructionException extends RuntimeException {

    private final int errorCode;
    private final String errorMessage;

    public ABInstructionException(int var1, String var2) {
        this.errorCode = var1;
        this.errorMessage = String.format(getErrorMessageBase(this.errorCode), var2);
    }

    public ABInstructionException(int var1) {
        this.errorCode = 450;
        this.errorMessage = getErrorMessageBase(this.errorCode);
    }

    public ABInstructionException(int var1, int var2, int errorCode, String errorArgument) {
        this.errorCode = errorCode;
        this.errorMessage = String.format(getErrorMessageBase(this.errorCode), errorArgument);
    }

    public ABInstructionException(int var1, int var2, int var3) {
        this.errorCode = var3;
        this.errorMessage = getErrorMessageBase(this.errorCode);
    }

    private static String getErrorMessageBase(int errorCode) {
        switch (errorCode) {
            case 1:
                return "Syntax error in part \"%1s\"";
            case 2:
                return "Syntax error";
            case 3:
                return "Parentesis ) missing";
            case 4:
                return "Empty expression";
            case 5:
                return "Unexpected part \"%1s\"";
            case 6:
                return "Unexpected end of expression";
            case 7:
                return "Value expected";
            case 10:
                return "Wrong value in part \"%1s\"";
            case 101:
                return "Unknown operator %1s";
            case 102:
                return "Unknown function %1s";
            case 103:
                return "Unknown variable %1s";
            case 104:
                return "Unknown operator";
            case 105:
                return "Mismatch type %1s";
            case 106:
                return "Unknown array %1s";
            case 107:
                return "Unknown array index %1s";
            case 108:
                return "Mismatch type in expression";
            case 110:
                return "Missing parameter/s";
            case 111:
                return "Unexpected function parameter %1s";
            case 200:
                return "Too long expression, maximum number of characters exceeded";
            case 220:
                return "Defining reserved name  %1s  failed";
            case 400:
                return "Integer value expected in function %1s";
            case 450:
                return "Array index out of range";
            case 500:
                return "%1s";
            default:
                return "Unknown error";
        }
    }

    public final String toString() {
        return this.errorMessage;
    }
}
