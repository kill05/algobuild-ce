package package_a.c.b;

import package_c.ABExecutionException;

public final class g extends h {
   public g(String var1) {
      super(var1);
   }

   public g() {
      super((String)null);
   }

   public final int a(package_a.c.a.b var1, int var2) {
      String var6 = this.l().replace('\n', ' ');

      boolean var7;
      try {
         package_c.l var3;
         boolean var4;
         var7 = var4 = (var3 = var1.e().a(var6, var1.c())) instanceof package_c.h && ((package_c.h)var3).a();
         var1.h("WHILE TEST:  " + var6 + "   RESULT: " + var4);
         var1.i();
      } catch (ABExecutionException var5) {
         var1.i("WHILE ERROR: " + var5 + " IN " + var6);
         return -2;
      }

      if (var7) {
         package_a.c.a.c var8 = new package_a.c.a.c(this.m(), var1);
         var1.d().push(var8);
         return 0;
      } else {
         return -1;
      }
   }

   public final String toString() {
      return "ABICycleWhile  [ " + super.toString() + "]";
   }

   public final package_a.c.a.d e() {
      g var1 = new g(this.l());

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

   protected final String g() {
      return "ABIWHI";
   }
}
