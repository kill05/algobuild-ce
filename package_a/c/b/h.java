package package_a.c.b;

import java.util.Iterator;

public abstract class h extends n {
   private o b;
   private String c;

   public h(String var1) {
      this.c = var1;
      this.b = new o();
   }

   public final String l() {
      return this.c;
   }

   public final void c(String var1) {
      this.c = var1;
      this.a(true);
   }

   public String b() {
      return this.c;
   }

   protected final o m() {
      return this.b;
   }

   public final void a(n var1) {
      int var2 = this.b.d();
      this.b.a(var1);
      var1.a((package_a.c.a.d)this, var2);
      if (this.a != null) {
         Iterator var4 = this.a.iterator();

         while(var4.hasNext()) {
            ((package_a.c.a.k)var4.next()).a(var1, var2);
         }

         var1.f();
      }

   }

   public final void a(n var1, int var2) {
      if (var2 < this.b.d()) {
         this.b.a(var1, var2);
         var1.a((package_a.c.a.d)this, var2);
         if (this.a != null) {
            Iterator var4 = this.a.iterator();

            while(var4.hasNext()) {
               ((package_a.c.a.k)var4.next()).a(var1, var2);
            }

            var1.f();
            return;
         }
      } else {
         this.a(var1);
      }

   }

   public final void d(int var1) {
      if (this.a != null) {
         Iterator var3 = this.a.iterator();

         while(var3.hasNext()) {
            ((package_a.c.a.k)var3.next()).a(var1);
         }
      }

      this.b.d(var1);
   }

   public final int d() {
      return this.b.d();
   }

   public final n c(int var1) {
      return this.b.c(var1);
   }

   public String toString() {
      return "ABICycle_Base [getOrderInParent()=" + this.n() + ", condition=" + this.c + "\nbody=" + this.b + ", condition=" + this.c + "]";
   }

   public final boolean a() {
      return true;
   }

   public package_a.f.g h() {
      package_a.f.g var1;
      (var1 = super.h()).a("condition", this.c);
      return var1;
   }

   public void a(package_a.f.g var1) {
      super.a(var1);
      String var2 = var1.a("condition");
      this.c(var2);
   }

   public package_b.a.c b(boolean var1) {
      package_b.a.c var2;
      (var2 = super.b(var1)).b("condition", this.c);
      if (var1) {
         for(int var3 = 0; var3 < this.b.d(); ++var3) {
            var2.a("body", (Object)this.b.c(var3).b(true));
         }
      }

      return var2;
   }

   public void a(package_b.a.c var1, boolean var2) {
      super.a(var1, var2);
      String var3 = var1.f("condition");
      this.c(var3);
      if (var2) {
         try {
            this.b.j();
         } catch (t var6) {
            var6.printStackTrace();
         }

         package_b.a.a var8;
         if ((var8 = var1.d("body")) != null) {
            for(int var7 = 0; var7 < var8.a(); ++var7) {
               package_b.a.c var4;
               n var5;
               (var5 = n.a(var4 = var8.c(var7))).a(var4, var2);
               this.a(var5);
            }
         }
      }

   }

   public final void f() {
      if (this.a != null) {
         try {
            for(int var1 = 0; var1 < this.b.d(); ++var1) {
               n var2 = this.c(var1);
               Iterator var4 = this.a.iterator();

               while(var4.hasNext()) {
                  ((package_a.c.a.k)var4.next()).a(var2, var1);
               }

               var2.f();
            }

            return;
         } catch (r var5) {
            var5.printStackTrace();
         }
      }

   }

   public p i() {
      p var1;
      (var1 = new p(1, this.c.length())).a(this.b.i());
      return var1;
   }
}
