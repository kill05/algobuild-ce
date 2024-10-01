package package_a.c.b;

public final class l extends m {
   private o b;
   private o c;

   public l(String var1) {
      super(var1);
      this.b = new o();
      this.b.a((a.c.a.d)this, 1);
      this.c = new o();
      this.c.a((a.c.a.d)this, 2);
   }

   public l() {
      this((String)null);
   }

   public final o j() {
      return this.b;
   }

   public final o k() {
      return this.c;
   }

   public final n c(int var1) {
      if (var1 == 1) {
         return this.b;
      } else if (var1 == 2) {
         return this.c;
      } else {
         throw new s("ABISelectionIf getInstr(" + var1 + ")");
      }
   }

   public final int a(a.c.a.b var1, int var2) {
      if (var2 == 0) {
         String var6 = this.l().replace('\n', ' ');

         boolean var7;
         try {
            c.l var3;
            boolean var4;
            var7 = var4 = (var3 = var1.e().a(var6, var1.c())) instanceof c.h && ((c.h)var3).a();
            var1.h("IF TEST:  " + var6 + "   RESULT: " + var4);
            var1.i();
         } catch (c.g var5) {
            var1.i("IF ERROR: " + var5 + " IN " + var6);
            return -2;
         }

         a.c.a.c var8;
         if (var7) {
            var1.d().pop();
            var8 = new a.c.a.c(this.b, var1);
            var1.d().push(var8);
            return 1;
         } else {
            var1.d().pop();
            var8 = new a.c.a.c(this.c, var1);
            var1.d().push(var8);
            return 2;
         }
      } else if (var2 == 1) {
         return -1;
      } else {
         return var2 == 2 ? -1 : -1;
      }
   }

   public final String toString() {
      return "ABISelectionIf " + this.l() + " [bodyTrue=" + this.b + ", bodyFalse=" + this.c + ", getOrderInParent()=" + this.n() + "]";
   }

   public final b.a.c b(boolean var1) {
      b.a.c var2 = super.b(var1);
      if (var1) {
         int var3;
         for(var3 = 0; var3 < this.c.d(); ++var3) {
            var2.a("0", (Object)this.c.c(var3).b(true));
         }

         for(var3 = 0; var3 < this.b.d(); ++var3) {
            var2.a("1", (Object)this.b.c(var3).b(true));
         }
      }

      return var2;
   }

   public final void a(b.a.c var1, boolean var2) {
      super.a(var1, var2);
      if (var2) {
         try {
            this.c.j();
            this.b.j();
         } catch (t var7) {
            var7.printStackTrace();
         }

         b.a.a var3;
         int var4;
         b.a.c var5;
         n var6;
         if ((var3 = var1.d("0")) != null) {
            for(var4 = 0; var4 < var3.a(); ++var4) {
               (var6 = n.a(var5 = var3.c(var4))).a(var5, var2);
               this.c.a(var6);
            }
         }

         if ((var3 = var1.d("1")) != null) {
            for(var4 = 0; var4 < var3.a(); ++var4) {
               (var6 = n.a(var5 = var3.c(var4))).a(var5, var2);
               this.b.a(var6);
            }
         }
      }

   }

   public final a.c.a.d e() {
      l var1 = new l(this.l());

      int var2;
      n var3;
      for(var2 = 0; var2 < this.b.d(); ++var2) {
         var3 = this.b.c(var2);
         var1.b.a((n)var3.e());
      }

      for(var2 = 0; var2 < this.c.d(); ++var2) {
         var3 = this.c.c(var2);
         var1.c.a((n)var3.e());
      }

      return var1;
   }

   public final void f() {
      if (this.a != null) {
         this.b.f();
         this.c.f();
      }

   }

   protected final String g() {
      return "ABIIF_";
   }

   public final p i() {
      p var1;
      (var1 = super.i()).a(this.b.i());
      var1.a(this.c.i());
      return var1;
   }
}
