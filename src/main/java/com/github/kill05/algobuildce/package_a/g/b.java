package com.github.kill05.algobuildce.package_a.g;

import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.b.ABInstructionBlock;
import com.github.kill05.algobuildce.package_a.c.b.s;
import com.github.kill05.algobuildce.package_a.c.b.t;

public final class b extends g {
   private ABProgram a;
   private ABInstructionBlock b;
   private int c = 0;
   private String d = "";

   public b(ABProgram var1, String var2) {
      this.a = var1;
      int var3 = var2.lastIndexOf(46);
      this.c = Integer.parseInt(var2.substring(var3 + 1));
      this.d = var2.substring(0, var3);

      try {
         this.b = var1.d(var2);
      } catch (NumberFormatException var4) {
         var4.printStackTrace();
      } catch (s var5) {
         var5.printStackTrace();
      }
   }

   @Override
   public final void b() {
      try {
         this.a.a(this.d, this.c, this.b);
         this.a.a(this.b);
      } catch (NumberFormatException var2) {
         var2.printStackTrace();
      } catch (s var3) {
         var3.printStackTrace();
      }
   }

   @Override
   public final void a() {
      try {
         this.a.c(this.d + "." + this.c);
      } catch (NumberFormatException var2) {
         var2.printStackTrace();
      } catch (s var3) {
         var3.printStackTrace();
      } catch (t var4) {
         var4.printStackTrace();
      }
   }
}
