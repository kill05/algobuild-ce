package com.github.kill05.algobuildce.package_c;

public final class m implements f {
   private l a;

   public m(l var1) {
      this.a = var1;
   }

   public final l d() {
      return this.a;
   }

   public final void a(l var1) {
      String var2 = this.a.getClass().getSimpleName();
      String var3 = var1.getClass().getSimpleName();
      if (this.a instanceof i && !(this.a instanceof j) && var1 instanceof j) {
         j var4;
         i var5 = new i((var4 = (j)var1).a);
         this.a = var5;
      } else if (!var3.equals(var2)) {
         throw new ABExecutionException(105, " try to assign " + var1.b() + " to " + this.a.b());
      } else {
         this.a = var1;
      }
   }

   public final String toString() {
      return this.a.toString();
   }

   @Override
   public final String a() {
      return this.a.c();
   }

   public final String e() {
      return this.a.b();
   }

   @Override
   public final String b() {
      return this.a.d();
   }

   @Override
   public final f c() {
      return new m(this.a);
   }
}
