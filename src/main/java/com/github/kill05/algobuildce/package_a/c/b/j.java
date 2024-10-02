package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.json.JSONObject;
import com.github.kill05.algobuildce.package_c.ABExecutionException;

public final class j extends k {
   private int b = 1;

   public j(String var1) {
      super(var1);
   }

   private j(String var1, int var2) {
      super(var1);
      this.e(var2);
   }

   public j() {
      super((String)null);
   }

   public final int j() {
      return this.b;
   }

   public final void e(int var1) {
      if (var1 < 0) {
         var1 = 0;
      } else if (var1 > 2) {
         var1 = 2;
      }

      this.b = var1;
      this.a(true);
   }

   @Override
   public final int a(com.github.kill05.algobuildce.package_a.c.a.b var1, int var2) {
      String[] var7 = this.l();

      for(int var3 = 0; var7 != null && var3 < var7.length; ++var3) {
         var1.h("OUTPUT: " + var7[var3]);
         String var4;
         String var5;
         if ((var4 = var7[var3]).startsWith("\"")) {
            var5 = var4.replace("\"", "");
            if (this.b == 2) {
               var1.g(var5);
            } else {
               var1.f(var5);
            }
         } else if (var4.startsWith("'")) {
            var5 = var4.replace("'", "");
            if (this.b == 2) {
               var1.g(var5);
            } else {
               var1.f(var5);
            }
         } else {
            try {
               com.github.kill05.algobuildce.package_c.l var8 = var1.e().a(var4, var1.c());
               if (this.b == 2) {
                  var1.g(var8.toString());
               } else {
                  var1.f(var8.toString());
               }
            } catch (ABExecutionException var6) {
               var1.i("OUTPUT ERROR: " + var6 + " IN " + var4);
               return -2;
            }
         }
      }

      if (this.b == 1) {
         var1.n();
      }

      return -1;
   }

   public final String toString() {
      return this.n() + "- ABIIOOutput: " + this.k().replace("\n", ", ") + "\n";
   }

   @Override
   public final com.github.kill05.algobuildce.package_a.f.g h() {
      com.github.kill05.algobuildce.package_a.f.g var1;
      (var1 = super.h()).a("lineSeparators", Integer.toString(this.b));
      return var1;
   }

   @Override
   public final void a(com.github.kill05.algobuildce.package_a.f.g var1) {
      super.a(var1);
      String var2 = var1.a("lineSeparators");
      this.b = Integer.parseInt(var2);
   }

   @Override
   public final JSONObject b(boolean var1) {
      JSONObject var2;
      (var2 = super.b(var1)).put("lineSeparators", Integer.toString(this.b));
      return var2;
   }

   @Override
   public final void a(JSONObject var1, boolean var2) {
      super.a(var1, var2);
      String var3 = var1.getAsString("lineSeparators");
      this.e(Integer.parseInt(var3));
   }

   @Override
   public final com.github.kill05.algobuildce.package_a.c.a.d e() {
      return new j(this.k(), this.b);
   }

   @Override
   protected final String g() {
      return "ABIOUT";
   }
}
