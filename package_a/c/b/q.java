package package_a.c.b;

import package_c.ABExecutionException;

import java.util.Iterator;
import java.util.Vector;

public final class q extends n {
   String b;
   private o d;
   private int e;
   Vector c;
   private String f = null;

   public q(String var1, int var2) {
      this.b = var1;
      this.e = var2;
      this.d = new o();
      this.d.a((package_a.c.a.d)this, -1);
      this.c = new Vector();
   }

   public q() {
      this.b = null;
      this.e = 0;
      this.d = new o();
      this.d.a((package_a.c.a.d)this, -1);
      this.c = new Vector();
   }

   public final String j() {
      return this.b;
   }

   public final void a(String var1) {
      this.b = var1;
   }

   public final void b(String var1) {
      if (!this.c.contains(var1)) {
         this.c.add(var1);
      }

   }

   public final int k() {
      return this.c.size();
   }

   public final String e(int var1) {
      return (String)this.c.get(var1);
   }

   public final String l() {
      return this.f;
   }

   public final void c(String var1) {
      this.f = var1;
   }

   @Override
   public final int a(package_a.c.a.b var1, int var2) {
      if (var2 == 0) {
         var1.h("START:" + this.b);
         package_a.c.a.c var6 = new package_a.c.a.c(this.d, var1);
         var1.d().push(var6);
         return 1;
      } else if (var2 == 1) {
         if (this.f != null && this.f.length() > 0) {
            package_c.f var4;
            if ((var4 = (package_c.f)var1.c().get(this.f)) != null) {
               var4 = var4.c();
               var1.c().put("_RETVAL_", var4);
               var1.h("FUNCTION RETURN:" + this.f + " result:" + var4.toString());
            } else {
               try {
                  package_c.l var5 = var1.e().a(this.f, var1.c());
                  var1.c().put("_RETVAL_", new package_c.m(var5));
                  var1.h("FUNCTION RETURN:" + this.f + " result:" + var5);
               } catch (ABExecutionException var3) {
                  var1.i("FUNCTION RETURN ERROR: " + var3 + " IN " + this.f);
                  return -2;
               }
            }
         }

         if (this.e == 1) {
            var1.h("END:" + this.b);
         } else {
            var1.h("RET:" + this.b);
         }

         return -1;
      } else {
         return -1;
      }
   }

   @Override
   public final void a(n var1) {
      int var2 = this.d.d();
      var1.a((package_a.c.a.d)this, var2);
      this.d.a(var1);
      if (this.a != null) {
         Iterator var4 = this.a.iterator();

         while(var4.hasNext()) {
            ((package_a.c.a.k)var4.next()).a(var1, var2);
         }

         var1.f();
      }

   }

   @Override
   public final void a(n var1, int var2) {
      if (var2 < this.d.d()) {
         this.d.a(var1, var2);
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

   @Override
   public final void d(int var1) {
      if (this.a != null) {
         Iterator var3 = this.a.iterator();

         while(var3.hasNext()) {
            ((package_a.c.a.k)var3.next()).a(var1);
         }
      }

      this.d.d(var1);
   }

   @Override
   public final int d() {
      return this.d.d();
   }

   @Override
   public final n c(int var1) {
      return this.d.c(var1);
   }

   @Override
   public final String c() {
      return this.b;
   }

   public final String toString() {
      return "ABR_Base [name=" + this.b + ", body=" + this.d + ", formalParams=" + this.c + "]";
   }

   @Override
   public final String b() {
      return this.b;
   }

   @Override
   public final boolean a() {
      return true;
   }

   public final int m() {
      return this.e;
   }

   public final void g(int var1) {
      this.e = var1;
   }

   public final void o() {
      this.c.clear();
   }

   @Override
   public final package_a.f.g h() {
      package_a.f.g var1;
      (var1 = super.h()).a("codeType", Integer.toString(this.e));
      var1.a("name", this.b);
      int var2;
      if ((var2 = this.c.size()) > 0) {
         String var3 = this.e(0);

         for(int var4 = 1; var4 < var2; ++var4) {
            var3 = var3 + "\n" + this.e(var4);
         }

         var1.a("formalParams", var3);
      }

      if (this.f != null) {
         var1.a("returnExpr", this.f);
      }

      return var1;
   }

   @Override
   public final void a(package_a.f.g var1) {
      super.a(var1);
      String var2 = var1.a("codeType");
      this.e = Integer.parseInt(var2);
      var2 = var1.a("name");
      this.b = var2;
      var2 = var1.a("formalParams");
      this.c.clear();
      if (var2 != null) {
         String[] var4 = var2.split("\\n");

         for(int var3 = 0; var3 < var4.length; ++var3) {
            this.b(var4[var3]);
         }
      }

      if ((var2 = var1.a("returnExpr")) != null) {
         this.f = var2;
      }

      this.a(true);
   }

   @Override
   public final package_b.a.c b(boolean var1) {
      package_b.a.c var2;
      (var2 = super.b(var1)).b("codeType", Integer.toString(this.e));
      var2.b("name", this.b);
      int var3;
      int var4;
      if ((var3 = this.c.size()) > 0) {
         for(var4 = 0; var4 < var3; ++var4) {
            String var5;
            if (!(var5 = this.e(var4).trim()).isEmpty()) {
               var2.a("formalParams", (Object)var5);
            }
         }
      }

      var4 = this.d.d();
      if (var1) {
         for(int var7 = 0; var7 < var4; ++var7) {
            package_b.a.c var6 = this.c(var7).b(true);
            var2.a("body", (Object)var6);
         }
      }

      if (this.f != null && !this.f.isEmpty()) {
         var2.b("returnExpr", this.f);
      }

      return var2;
   }

   @Override
   public final void a(package_b.a.c var1, boolean var2) {
      super.a(var1, var2);
      Integer var3 = var1.a("codeType");
      int var11 = var3;
      this.e = var11;
      String var12 = var1.f("name");
      this.b = var12;
      package_b.a.a var13 = var1.d("formalParams");
      this.c.clear();
      if (var13 != null) {
         for(int var4 = 0; var4 < var13.a(); ++var4) {
            String var5 = var13.d(var4);
            if (var4 < this.c.size()) {
               this.c.set(var4, var5);
            } else {
               this.c.add(var5);
            }

            System.out.println("SET PARAMETER  i=" + var4 + " par=" + var5);
         }
      }

      String var15;
      if ((var15 = var1.f("returnExpr")) != null) {
         this.f = var15;
      }

      if (var2) {
         package_b.a.a var17 = var1.d("body");

         try {
            this.d.j();
         } catch (t var9) {
            var9.printStackTrace();
         }

         if (var17 != null) {
            for(int var10 = 0; var10 < var17.a(); ++var10) {
               package_b.a.c var14;
               n var16;
               (var16 = n.a(var14 = var17.c(var10))).a(var14, var2);
               this.a(var16);
            }
         }
      }

      this.a(true);
   }

   @Override
   protected final String g() {
      return "ABRCOD";
   }

   @Override
   public final void f() {
      if (this.a != null) {
         for(int var1 = 0; var1 < this.d.d(); ++var1) {
            n var2 = this.c(var1);
            Iterator var4 = this.a.iterator();

            while(var4.hasNext()) {
               ((package_a.c.a.k)var4.next()).a(var2, var1);
            }

            var2.f();
         }
      }

   }

   @Override
   public final p i() {
      p var1;
      (var1 = new p(1, this.b.length())).a(this.d.i());
      int var2 = this.c.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         var1.a(0, this.e(var3).length());
      }

      return var1;
   }
}
