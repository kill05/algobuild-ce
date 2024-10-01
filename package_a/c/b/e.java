package package_a.c.b;

import package_c.ABExecutionException;

public final class e extends h {
   public e(String var1) {
      super(var1);
   }

   public e() {
      super((String)null);
   }

   @Override
   public final int a(package_a.c.a.b var1, int var2) {
      String var3 = this.l().replace('\n', ' ');
      if (var2 == 0) {
         package_a.c.a.c var8 = new package_a.c.a.c(this.m(), var1);
         var1.d().push(var8);
         return 1;
      } else {
         boolean var7;
         try {
            boolean var4;
            package_c.l var6;
            var7 = var4 = (var6 = var1.e().a(var3, var1.c())) instanceof package_c.h && ((package_c.h)var6).a();
            var1.h("DO-WHILE TEST:  " + var3 + "   RESULT: " + var4);
            var1.i();
         } catch (ABExecutionException var5) {
            var1.i("DO-WHILE ERROR: " + var5 + " IN " + var3);
            return -2;
         }

         return var7 ? 0 : -1;
      }
   }

   public final String toString() {
      return "ABICycleDoWhile  [ " + super.toString() + "]";
   }

   @Override
   public final package_a.c.a.d e() {
      e var1 = new e(this.l());

      try {
         for(int var2 = 0; var2 < this.d(); ++var2) {
            n var3 = this.c(var2);
            var1.a((n)var3.e());
         }
      } catch (r var4) {
         var4.printStackTrace();
      } catch (s var5) {
         var5.printStackTrace();
      }

      return var1;
   }

   @Override
   public final boolean b(int var1) {
      return var1 == 1;
   }

   @Override
   protected final String g() {
      return "ABIDOW";
   }
}
