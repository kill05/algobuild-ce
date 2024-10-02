package com.github.kill05.algobuildce.package_a.g;

import com.github.kill05.algobuildce.package_a.c.b.q;
import com.github.kill05.algobuildce.package_a.f.ABBlockDataHolder;

public final class d extends g {
   private com.github.kill05.algobuildce.package_a.c.a.b a;
   private q b;
   private ABBlockDataHolder c = null;
   private ABBlockDataHolder d = null;
   private String e = null;
   private String f = null;

   public d(com.github.kill05.algobuildce.package_a.c.a.b var1, q var2) {
      this.a = var1;
      this.b = var2;
      this.f = var2.j();
      this.c = var2.h();
   }

   @Override
   public final void a() {
      this.b.a(this.d);
      this.a.a(this.f, this.b);
   }

   @Override
   public final void b() {
      if (this.d == null) {
         this.d = this.b.h();
         this.e = this.b.j();
      }

      this.b.a(this.c);
      this.a.a(this.e, this.b);
   }
}
