package com.github.kill05.algobuildce.package_a.c.b;

import java.util.Vector;

import com.github.kill05.algobuildce.json.JSONObject;
import com.github.kill05.algobuildce.package_c.f;

public final class c extends b {
   private String d;

   public c(String var1) {
      super(var1);
   }

   private c(String var1, Vector var2) {
      super(var1, var2);
   }

   public c() {
      this((String)null);
   }

   public final String l() {
      return this.d;
   }

   public final void b(String var1) {
      System.out.println("SET RETURN VARIABLE " + var1);
      this.d = var1;
      this.a(true);
   }

   @Override
   public final int a(com.github.kill05.algobuildce.package_a.c.a.b var1, int var2) {
      f var3 = null;
      boolean var4 = false;
      if (var2 == 1 && this.d != null && !this.d.isEmpty()) {
         var3 = (f) var1.c().get("_RETVAL_");
         var4 = true;
      }

      var2 = super.a(var1, var2);
      if (var4) {
         var1.c().put(this.d, var3);
         var1.h("RETURN VALUE: " + var3);
      }

      var1.i();
      return var2;
   }

   @Override
   public final com.github.kill05.algobuildce.package_a.f.g h() {
      com.github.kill05.algobuildce.package_a.f.g var1 = super.h();
      if (this.d != null) {
         var1.a("returnVariable", this.d);
      }

      return var1;
   }

   @Override
   public final void a(com.github.kill05.algobuildce.package_a.f.g var1) {
      super.a(var1);
      String var2;
      if ((var2 = var1.a("returnVariable")) != null) {
         this.b(var2);
      }

   }

   @Override
   public final JSONObject b(boolean var1) {
      JSONObject var2 = super.b(var1);
      System.out.println("getAsJSONObject RETURN VARIABLE " + this.d);
      if (this.d != null) {
         var2.b("returnVariable", this.d);
      }

      return var2;
   }

   @Override
   public final void a(JSONObject var1, boolean var2) {
      super.a(var1, var2);
      String var3 = var1.f("returnVariable");
      System.out.println("getAsJSONObject RETURN VARIABLE " + var3);
      if (var3 != null) {
         this.b(var3);
      }

   }

   @Override
   public final com.github.kill05.algobuildce.package_a.c.a.d e() {
      c var1;
      (var1 = new c(this.b, (Vector)this.c.clone())).b(this.d);
      return var1;
   }
}
