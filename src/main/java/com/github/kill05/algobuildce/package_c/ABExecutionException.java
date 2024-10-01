package com.github.kill05.algobuildce.package_c;

public final class ABExecutionException extends RuntimeException {
   private int a;
   private String b;

   public ABExecutionException(int var1, String var2) {
      this.a = var1;
      this.b = String.format(a(this.a), var2);
   }

   public ABExecutionException(int var1) {
      this.a = 450;
      this.b = a(this.a);
   }

   public ABExecutionException(int var1, int var2, int var3, String var4) {
      this.a = var3;
      String var5 = a(this.a);
      this.b = String.format(var5, var4);
   }

   public ABExecutionException(int var1, int var2, int var3) {
      this.a = var3;
      this.b = a(this.a);
   }

   private static String a(int var0) {
      switch(var0) {
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
      return this.b;
   }
}
