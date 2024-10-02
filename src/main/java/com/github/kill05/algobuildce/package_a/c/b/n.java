package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.json.JSONObject;

public abstract class n extends com.github.kill05.algobuildce.package_a.c.a.d {
   private com.github.kill05.algobuildce.package_a.c.a.d b = null;
   private int c = -1;

   public final void a(com.github.kill05.algobuildce.package_a.c.a.d var1, int var2) {
      this.b = var1;
      this.c = var2;
   }

   public final void f(int var1) {
      this.c += var1;
      if (this.c < 0) {
         this.c = 0;
      }

   }

   public final int n() {
      return this.c;
   }

   @Override
   public String c() {
      if (this.b != null) {
         String var1 = this.b.c();
         return this.c >= 0 ? var1 + "." + this.c : var1;
      } else {
         return Integer.toString(this.c);
      }
   }

   @Override
   public int a(com.github.kill05.algobuildce.package_a.c.a.b var1, int var2) {
      return 0;
   }

   public String toString() {
      return "ABI_Base [parent=" + this.b + ", orderInParent=" + this.c + "]";
   }

   @Override
   public String b() {
      return null;
   }

   @Override
   public boolean b(int var1) {
      return true;
   }

   protected String g() {
      return null;
   }

   public com.github.kill05.algobuildce.package_a.f.g h() {
      com.github.kill05.algobuildce.package_a.f.g var1;
      (var1 = new com.github.kill05.algobuildce.package_a.f.g()).a("path", this.c());
      var1.a("abiid", this.g());
      return var1;
   }

   public void a(com.github.kill05.algobuildce.package_a.f.g var1) {
   }

   public JSONObject b(boolean var1) {
      JSONObject var2;
      (var2 = new JSONObject()).put("abiid", this.g());
      return var2;
   }

   public void a(JSONObject var1, boolean var2) {
   }

   public static n a(JSONObject var0) {
      String var2 = (String)var0.getNullable("abiid");
      Object var1 = null;
      if (var2.equals("ABIASS")) {
         var1 = new a();
      } else if (var2.equals("ABICAL")) {
         var1 = new c();
      } else if (var2.equals("ABICOM")) {
         var1 = new d();
      } else if (var2.equals("ABIDOW")) {
         var1 = new e();
      } else if (var2.equals("ABIFOR")) {
         var1 = new f();
      } else if (var2.equals("ABIWHI")) {
         var1 = new g();
      } else if (var2.equals("ABIINP")) {
         var1 = new i();
      } else if (var2.equals("ABIOUT")) {
         var1 = new j();
      } else if (var2.equals("ABIIF_")) {
         var1 = new l();
      } else if (var2.equals("ABRCOD")) {
         var1 = new q();
      }

      return (n)var1;
   }

   public abstract p i();
}
