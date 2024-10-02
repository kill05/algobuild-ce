package com.github.kill05.algobuildce.package_a.c.a;

import com.github.kill05.algobuildce.package_a.c.b.n;
import com.github.kill05.algobuildce.package_a.c.b.q;

public final class e {
   private b a;

   public e(b var1) {
      this.a = var1;
   }

   public final void a(String var1) {
      q var3 = this.a.a(var1);
      c var2 = new c(var3, this.a);
      this.a.d().push(var2);
      this.a.f();
      if (var3 instanceof n) {
         ((n)var3).a(false);
      }

   }

   public final void a() {
      d var1;
      if (this.b() && (var1 = ((c)this.a.d().peek()).d()) instanceof n) {
         ((n)var1).a(false);
      }

      this.a.reset();
   }

   public final boolean b() {
      return this.a != null && !this.a.d().empty();
   }

   public final void c() {
      boolean var1 = this.b();

      while(true) {
         while(var1) {
            c var2;
            d var3;
            if ((var2 = (c)this.a.d().peek()) != null) {
               var2.a();
               if (var2.c() == -2) {
                  this.a.d().clear();
               }

               if ((var3 = var2.d()) instanceof n) {
                  ((n)var3).a(false);
               }
            }

            if (this.a.d().empty()) {
               var1 = false;
            } else {
               if ((var2 = (c)this.a.d().peek()) == null || var2.b()) {
                  var1 = false;
               }

               if (var2 != null && (var3 = var2.d()) instanceof n) {
                  ((n)var3).a(false);
               }
            }
         }

         return;
      }
   }
}
