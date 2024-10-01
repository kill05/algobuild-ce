package package_c;

import java.util.Vector;

public final class d implements f {
   private Vector a;
   private m b;

   public d() {
      this.a = new Vector(10, 10);
   }

   private d(Vector var1) {
      this.a = (Vector)var1.clone();
   }

   public final l a(int var1) {
      l var2 = null;
      if (var1 >= 0 && var1 < this.a.size()) {
         m var3;
         if ((var3 = (m)this.a.get(var1)) != null) {
            var2 = var3.d();
         }

         return var2;
      } else {
         System.out.println("INDEX - OUT - OF - BOUND " + var1);
         throw new ABExecutionException(450);
      }
   }

   public final void a(l var1, int var2) {
      int var3;
      if (this.a == null) {
         var3 = (int)Math.ceil((double)(var2 + 1) / 10.0D) * 10;
         this.a = new Vector(var3, 10);
      }

      if (var2 >= 0) {
         if (var2 < this.a.size()) {
            m var4;
            if ((var4 = (m)this.a.get(var2)) != null) {
               var4.a(var1);
               return;
            }

            if (this.b != null) {
               this.b = (m)this.b.c();
               this.b.a(var1);
            } else {
               this.b = new m(var1);
            }

            this.a.set(var2, new m(var1));
            return;
         }

         for(var3 = this.a.size(); var3 <= var2; ++var3) {
            this.a.add((Object)null);
         }

         if (this.b != null) {
            this.b = (m)this.b.c();
            this.b.a(var1);
         } else {
            this.b = new m(var1);
         }

         this.a.set(var2, this.b);
      }

   }

   public final String toString() {
      String var1 = "{";

      for(int var2 = 0; var2 < this.a.size(); ++var2) {
         if (var2 != 0) {
            var1 = var1 + ",";
         }

         m var3;
         if ((var3 = (m)this.a.get(var2)) != null) {
            var1 = var1 + var3.d();
         }
      }

      return var1 + "}";
   }

   @Override
   public final String a() {
      String var1 = "{";

      for(int var2 = 0; var2 < this.a.size(); ++var2) {
         if (var2 != 0) {
            var1 = var1 + ",";
         }

         m var3;
         if ((var3 = (m)this.a.get(var2)) != null) {
            var1 = var1 + var3.d().c();
         }
      }

      return var1 + "}";
   }

   @Override
   public final String b() {
      String var1 = "{";

      for(int var2 = 0; var2 < this.a.size(); ++var2) {
         if (var2 != 0) {
            var1 = var1 + ",";
         }

         m var3;
         if ((var3 = (m)this.a.get(var2)) != null) {
            var1 = var1 + var3.d().d();
         }
      }

      return var1 + "}";
   }

   @Override
   public final f c() {
      return new d(this.a);
   }
}
