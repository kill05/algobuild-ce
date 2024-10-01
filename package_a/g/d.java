package package_a.g;

import package_a.c.b.q;

public final class d extends g {
   private a.c.a.b a;
   private q b;
   private a.f.g c = null;
   private a.f.g d = null;
   private String e = null;
   private String f = null;

   public d(a.c.a.b var1, q var2) {
      this.a = var1;
      this.b = var2;
      this.f = var2.j();
      this.c = var2.h();
   }

   public final void a() {
      this.b.a(this.d);
      this.a.a(this.f, this.b);
   }

   public final void b() {
      if (this.d == null) {
         this.d = this.b.h();
         this.e = this.b.j();
      }

      this.b.a(this.c);
      this.a.a(this.e, this.b);
   }
}
