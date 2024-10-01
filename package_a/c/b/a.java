package package_a.c.b;

import package_c.l;
import package_c.ABExecutionException;

public final class a extends n {
   private String b;
   private String[] c = null;

   public a(String var1) {
      this.a(var1);
   }

   public a() {
      this.a((String)null);
   }

   public final String b() {
      return this.b;
   }

   public final void a(String var1) {
      this.b = var1;
      if (var1 != null) {
         this.c = var1.split("\n|;");
      } else {
         this.c = null;
      }

      this.a(true);
   }

   public final int a(package_a.c.a.b var1, int var2) {
      for(var2 = 0; this.c != null && var2 < this.c.length; ++var2) {
         String var3 = this.c[var2];

         try {
            l var4 = var1.e().a(var3, var1.c());
            var1.h("ASSIGN: " + var3 + "   RESULT:" + var4);
         } catch (ABExecutionException var5) {
            var1.i("ASSIGN ERROR: " + var5 + " IN " + var3);
            return -2;
         }
      }

      var1.i();
      return -1;
   }

   public final String toString() {
      return this.n() + "- ABIAssign: " + this.b + "\n";
   }

   protected final String g() {
      return "ABIASS";
   }

   public final package_a.f.g h() {
      package_a.f.g var1;
      (var1 = super.h()).a("label", this.b);
      return var1;
   }

   public final void a(package_a.f.g var1) {
      super.a(var1);
      String var2 = var1.a("label");
      this.a(var2);
   }

   public final package_b.a.c b(boolean var1) {
      package_b.a.c var2;
      (var2 = super.b(var1)).b("label", this.b);
      return var2;
   }

   public final void a(package_b.a.c var1, boolean var2) {
      super.a(var1, var2);
      String var3 = var1.f("label");
      this.a(var3);
   }

   public final package_a.c.a.d e() {
      a var1;
      (var1 = new a()).a(this.b);
      return var1;
   }

   public final p i() {
      return new p(1, this.b.length());
   }
}
