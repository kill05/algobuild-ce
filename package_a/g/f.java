package package_a.g;

import package_a.c.b.n;
import package_a.c.b.s;
import package_a.c.b.t;

public final class f extends g {
   private package_a.c.a.b a;
   private String b;
   private int c;
   private n d;

   public f(package_a.c.a.b var1, String var2, int var3, n var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public final void a() {
      try {
         this.a.a(this.b, this.c, this.d);
      } catch (NumberFormatException var2) {
         var2.printStackTrace();
      } catch (s var3) {
         var3.printStackTrace();
      }
   }

   public final void b() {
      try {
         String var1 = this.b + "." + this.c;
         this.a.c(var1);
      } catch (NumberFormatException var2) {
         var2.printStackTrace();
      } catch (s var3) {
         var3.printStackTrace();
      } catch (t var4) {
         var4.printStackTrace();
      }
   }
}
