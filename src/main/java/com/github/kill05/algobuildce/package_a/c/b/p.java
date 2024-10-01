package com.github.kill05.algobuildce.package_a.c.b;

public final class p {
   private int a;
   private int b;

   public p() {
      this.a = 0;
      this.b = 0;
   }

   public p(int var1, int var2) {
      this.a(1);
      this.b(var2);
   }

   public final int a() {
      return this.a;
   }

   private void a(int var1) {
      if (var1 >= 0) {
         this.a = var1;
      }

   }

   public final int b() {
      return this.b;
   }

   private void b(int var1) {
      if (var1 >= 0) {
         this.b = var1;
      }

   }

   public final void a(int var1, int var2) {
      this.a(this.a);
      if (var2 >= 0) {
         this.b(this.b + var2);
      }

   }

   public final void a(p var1) {
      if (var1.a >= 0) {
         this.a(this.a + var1.a);
      }

      if (var1.b >= 0) {
         this.b(this.b + var1.b);
      }

   }

   public final String toString() {
      return Integer.toString(this.a) + "(I) " + Integer.toString(this.b) + "(C)";
   }
}
