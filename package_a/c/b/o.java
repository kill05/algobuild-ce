package package_a.c.b;

import java.util.Iterator;
import java.util.Vector;

public final class o extends n {
   private Vector b = new Vector();

   public final boolean b(int var1) {
      return false;
   }

   public final boolean a(int var1) {
      int var2 = this.b.size();
      return var1 >= 0 && var1 < var2;
   }

   public final n c(int var1) {
      return (n)this.b.get(var1);
   }

   public final void a(n var1) {
      int var2 = this.b.size();
      var1.a((package_a.c.a.d)this, var2);
      this.b.add(var1);
      if (this.a != null) {
         Iterator var4 = this.a.iterator();

         while(var4.hasNext()) {
            ((package_a.c.a.k)var4.next()).a(var1, var2);
         }
      }

   }

   public final void a(n var1, int var2) {
      for(int var3 = var2; var3 < this.b.size(); ++var3) {
         this.c(var3).f(1);
      }

      var1.a((package_a.c.a.d)this, var2);
      this.b.add(var2, var1);
      if (this.a != null) {
         Iterator var4 = this.a.iterator();

         while(var4.hasNext()) {
            ((package_a.c.a.k)var4.next()).a(var1, var2);
         }
      }

      var1.f();
   }

   public final void d(int var1) {
      this.b.remove(var1);

      for(int var2 = var1; var2 < this.b.size(); ++var2) {
         this.c(var2).f(-1);
      }

      if (this.a != null) {
         Iterator var3 = this.a.iterator();

         while(var3.hasNext()) {
            ((package_a.c.a.k)var3.next()).a(var1);
         }
      }

   }

   public final void j() {
      while(this.b.size() > 0) {
         this.d(0);
      }

   }

   public final int d() {
      return this.b.size();
   }

   public final int a(package_a.c.a.b var1, int var2) {
      if (this.a(var2)) {
         int var3 = var2++;
         package_a.c.a.c var4 = new package_a.c.a.c((package_a.c.a.d)this.b.get(var3), var1);
         var1.d().push(var4);
      } else {
         var2 = -1;
      }

      return var2;
   }

   public final String toString() {
      return "ABICompound [getOrderInParent()=" + this.n() + "\ninstructions=" + this.b + "]";
   }

   public final boolean a() {
      return true;
   }

   public final void f() {
      if (this.a != null) {
         for(int var1 = 0; var1 < this.b.size(); ++var1) {
            n var2 = this.c(var1);
            Iterator var4 = this.a.iterator();

            while(var4.hasNext()) {
               ((package_a.c.a.k)var4.next()).a(var2, var1);
            }

            var2.f();
         }
      }

   }

   public final p i() {
      p var1 = new p();

      for(int var2 = 0; var2 < this.b.size(); ++var2) {
         n var3 = this.c(var2);
         var1.a(var3.i());
      }

      return var1;
   }
}
