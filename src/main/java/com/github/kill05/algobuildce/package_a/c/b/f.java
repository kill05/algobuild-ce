package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.json.JSONObject;
import com.github.kill05.algobuildce.package_c.ABExecutionException;

public final class f extends h {
   private String b;
   private String c;

   public f(String var1, String var2, String var3) {
      super(var2);
      this.b = var1;
      this.c = var3;
   }

   public f() {
      super((String)null);
      this.b = null;
      this.c = null;
   }

   public final String b() {
      return this.b + "; " + this.l() + "; " + this.c;
   }

   public final String j() {
      return this.b;
   }

   public final void a(String var1) {
      this.b = var1;
      this.a(true);
   }

   public final String k() {
      return this.c;
   }

   public final void b(String var1) {
      this.c = var1;
      this.a(true);
   }

   public final int a(com.github.kill05.algobuildce.package_a.c.a.b var1, int var2) {
      com.github.kill05.algobuildce.package_c.l var3;
      String var8;
      if (var2 == 0) {
         var8 = this.b;

         try {
            var3 = var1.e().a(var8, var1.c());
            var1.h("FOR INITIALIZATION: " + var8 + "   RESULT: " + var3);
            return 1;
         } catch (ABExecutionException var5) {
            var1.i("FOR INITIALIZATION ERROR: " + var5 + " IN " + var8);
            return -2;
         }
      } else if (var2 == 1) {
         var8 = this.l();

         boolean var10;
         try {
            boolean var4;
            var10 = var4 = (var3 = var1.e().a(var8, var1.c())) instanceof com.github.kill05.algobuildce.package_c.h && ((com.github.kill05.algobuildce.package_c.h)var3).a();
            var1.h("FOR TEST:  " + var8 + "   RESULT: " + var4);
            var1.i();
         } catch (ABExecutionException var7) {
            var1.i("FOR TEST ERROR: " + var7 + " IN " + var8);
            return -2;
         }

         return var10 ? 2 : -1;
      } else if (var2 == 2) {
         com.github.kill05.algobuildce.package_a.c.a.c var9 = new com.github.kill05.algobuildce.package_a.c.a.c(this.m(), var1);
         var1.d().push(var9);
         return 3;
      } else if (var2 == 3) {
         var8 = this.c;

         try {
            var3 = var1.e().a(var8, var1.c());
            var1.h("FOR INCREMENT: " + var8 + "   RESULT: " + var3);
            return 1;
         } catch (ABExecutionException var6) {
            var1.i("FOR INCREMENT ERROR: " + var6 + " IN " + var8);
            return -2;
         }
      } else {
         return -1;
      }
   }

   public final String toString() {
      return "ABICycleFor  [ " + super.toString() + "]";
   }

   @Override
   protected final String g() {
      return "ABIFOR";
   }

   @Override
   public final com.github.kill05.algobuildce.package_a.f.g h() {
      com.github.kill05.algobuildce.package_a.f.g var1;
      (var1 = super.h()).a("initialization", this.b);
      var1.a("increment", this.c);
      return var1;
   }

   public final void a(com.github.kill05.algobuildce.package_a.f.g var1) {
      super.a(var1);
      String var2 = var1.a("initialization");
      this.a(var2);
      var2 = var1.a("increment");
      this.b(var2);
   }

   public final JSONObject b(boolean var1) {
      JSONObject var2;
      (var2 = super.b(var1)).b("initialization", this.b);
      var2.b("increment", this.c);
      return var2;
   }

   public final void a(JSONObject var1, boolean var2) {
      super.a(var1, var2);
      String var3 = var1.f("initialization");
      this.a(var3);
      var3 = var1.f("increment");
      this.b(var3);
   }

   public final com.github.kill05.algobuildce.package_a.c.a.d e() {
      f var1 = new f(this.b, this.l(), this.c);

      try {
         for(int var2 = 0; var2 < this.d(); ++var2) {
            n var3 = this.c(var2);
            var1.a((n)var3.e());
         }
      } catch (s var4) {
         var4.printStackTrace();
      } catch (r var5) {
         var5.printStackTrace();
      }

      return var1;
   }

   public final boolean b(int var1) {
      return var1 == 0 || var1 == 3;
   }

   @Override
   public final p i() {
      p var1;
      (var1 = super.i()).a(0, this.b.length() + this.c.length());
      return var1;
   }
}
