package com.github.kill05.algobuildce.package_c;

import java.util.Vector;

public final class e implements f {
   private Vector a;
   private m b;

   public e() {
      this.a = new Vector(10, 10);
   }

   private e(Vector var1) {
      this.a = (Vector)var1.clone();
   }

   public final l a(int var1, int var2) {
      l var3 = null;
      if (var1 >= 0 && var1 < this.a.size()) {
         m var4;
         if ((var4 = (m)((Vector)this.a.get(var1)).get(var2)) != null) {
            var3 = var4.d();
         }

         return var3;
      } else {
         System.out.println("INDEX - OUT - OF - BOUND " + var1);
         throw new ABInstructionException(450);
      }
   }

   public final void a(l var1, int var2, int var3) {
      int var4;
      if (this.a == null) {
         var4 = (int)Math.ceil((double)(var2 + 1) / 10.0D) * 10;
         this.a = new Vector(var4, 10);
      }

      if (var2 >= 0 && var3 >= 0) {
         if (var2 >= this.a.size()) {
            var4 = (int)Math.ceil((double)(var2 + 1) / 10.0D) * 10;
            this.a.ensureCapacity(var4);
            this.a.setSize(var2 + 1);
         }

         int var5;
         Vector var6;
         if ((var6 = (Vector)this.a.get(var2)) != null) {
            if (var3 >= var6.size()) {
               var5 = (int)Math.ceil((double)(var3 + 1) / 10.0D) * 10;
               var6.ensureCapacity(var5);
               var6.setSize(var3 + 1);
            }

            m var7;
            if ((var7 = (m)var6.get(var3)) != null) {
               var7.a(var1);
               return;
            }

            if (this.b != null) {
               this.b = (m)this.b.c();
               this.b.a(var1);
            } else {
               this.b = new m(var1);
            }

            var6.set(var3, new m(var1));
            return;
         }

         var5 = (int)Math.ceil((double)(var3 + 1) / 10.0D) * 10;
         System.out.println("index2=" + var3);
         System.out.println("dim2=" + var5);
         var6 = new Vector(var5, 10);
         if (this.b != null) {
            this.b = (m)this.b.c();
            this.b.a(var1);
         } else {
            this.b = new m(var1);
         }

         System.out.println(var6.capacity());
         System.out.println(var6.size());
         if (var6.size() <= var3) {
            var6.setSize(var3 + 1);
         }

         var6.setElementAt(new m(var1), var3);
         this.a.set(var2, var6);
      }

   }

   public final String toString() {
      return this.b();
   }

   @Override
   public final String a() {
      String var1 = "{";
      if (this.b != null) {
         var1 = var1 + this.b.e();
      }

      for(int var2 = 0; var2 < this.a.size(); ++var2) {
         if (var2 != 0) {
            var1 = var1 + ",";
         }

         Vector var3;
         if ((var3 = (Vector)this.a.get(var2)) != null) {
            var1 = var1 + "{";

            for(int var4 = 0; var4 < var3.size(); ++var4) {
               if (var4 != 0) {
                  var1 = var1 + ",";
               }

               m var5;
               if ((var5 = (m)var3.get(var4)) != null) {
                  var1 = var1 + var5.d();
               }
            }

            var1 = var1 + "}";
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

         Vector var3;
         if ((var3 = (Vector)this.a.get(var2)) != null) {
            var1 = var1 + "{";

            for(int var4 = 0; var4 < var3.size(); ++var4) {
               if (var4 != 0) {
                  var1 = var1 + ",";
               }

               m var5;
               if ((var5 = (m)var3.get(var4)) != null) {
                  var1 = var1 + var5.b();
               }
            }

            var1 = var1 + "}";
         }
      }

      return var1 + "}";
   }

   @Override
   public final f c() {
      return new e(this.a);
   }
}
