package com.github.kill05.algobuildce.package_a.g;

import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.b.ABInstructionBlock;
import com.github.kill05.algobuildce.package_a.c.b.s;
import com.github.kill05.algobuildce.package_a.c.b.t;

public final class f extends g {
   private ABProgram a;
   private String b;
   private int c;
   private ABInstructionBlock d;

   public f(ABProgram var1, String var2, int var3, ABInstructionBlock var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   @Override
   public final void a() {
      try {
         this.a.a(this.b, this.c, this.d);
      } catch (NumberFormatException var2) {
         var2.printStackTrace();
      } catch (s var3) {
         var3.printStackTrace();
      }
   }

   @Override
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
