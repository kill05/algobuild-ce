package package_a.g;

import package_a.c.b.n;

public final class e extends g {
   private n a;
   private package_a.f.g b = null;
   private package_a.f.g c = null;

   public e(n var1) {
      this.a = var1;
      this.b = var1.h();
   }

   @Override
   public final void a() {
      this.a.a(this.c);
   }

   @Override
   public final void b() {
      if (this.c == null) {
         this.c = this.a.h();
      }

      this.a.a(this.b);
   }
}
