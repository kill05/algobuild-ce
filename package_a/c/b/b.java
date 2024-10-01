package package_a.c.b;

import java.util.Map;
import java.util.Vector;

public class b extends n {
   String b;
   Vector c;

   public b(String var1) {
      this.b = var1;
      this.c = new Vector();
   }

   public b(String var1, Vector var2) {
      this.b = var1;
      this.c = var2;
   }

   public b() {
      this((String)null);
   }

   public final String j() {
      return this.b;
   }

   public final void a(String var1) {
      this.b = var1;
      this.a(true);
   }

   public final Vector k() {
      return this.c;
   }

   private void b(String var1) {
      if (!this.c.contains(var1)) {
         this.c.add(var1);
         this.a(true);
      }

   }

   private String e(int var1) {
      return (String)this.c.get(var1);
   }

   public int a(a.c.a.b var1, int var2) {
      if (var2 == 0) {
         q var10;
         if ((var10 = var1.a(this.b)) != null) {
            Map var3 = var1.c();
            var1.f();
            Map var4 = var1.c();
            String var5 = "";

            for(int var6 = 0; var6 < this.c.size() && var6 < var10.c.size(); ++var6) {
               String var7 = (String)this.c.get(var6);
               c.f var8;
               if ((var8 = (c.f)var3.get(var7)) != null) {
                  var8 = var8.c();
                  if (var5.length() > 0) {
                     var5 = var5 + ", ";
                  }

                  var5 = var5 + var8.toString();
                  var4.put(var10.e(var6), var8);
               } else {
                  try {
                     if (!var7.isEmpty()) {
                        c.l var11 = var1.e().a(var7, var3);
                        if (var5.length() > 0) {
                           var5 = var5 + ", ";
                        }

                        var5 = var5 + var11;
                        var4.put(var10.e(var6), new c.m(var11));
                     }
                  } catch (c.g var9) {
                     var1.i("CALL PARAMETER " + (var6 + 1) + " ERROR: " + var9 + " IN " + var7);
                     return -2;
                  }
               }
            }

            var1.d().push(new a.c.a.c(var10, var1));
            var1.h("CALL: " + var10.b + "(" + var5 + ")");
            var1.l();
            return 1;
         }
      } else if (var2 == 1) {
         var1.m();
         var1.g();
         return -1;
      }

      return -1;
   }

   public String toString() {
      return "ABICall_Base [callName=" + this.b + ", actualParams=" + this.c + " orderInParent=" + this.n() + "]";
   }

   protected final String g() {
      return "ABICAL";
   }

   public a.f.g h() {
      a.f.g var1;
      (var1 = super.h()).a("callName", this.b);
      int var2;
      if ((var2 = this.c.size()) > 0) {
         String var3 = this.e(0);

         for(int var4 = 1; var4 < var2; ++var4) {
            var3 = var3 + "\n" + this.e(var4);
         }

         var1.a("actualParams", var3);
      }

      return var1;
   }

   public void a(a.f.g var1) {
      super.a(var1);
      String var2 = var1.a("callName");
      this.a(var2);
      String var3;
      if ((var3 = var1.a("actualParams")) != null) {
         this.c.removeAllElements();
         String[] var4 = var3.split("\\n");

         for(int var5 = 0; var5 < var4.length; ++var5) {
            this.b(var4[var5]);
         }
      }

   }

   public b.a.c b(boolean var1) {
      b.a.c var5;
      (var5 = super.b(var1)).b("callName", this.b);
      int var2 = this.c.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         String var4;
         if (!(var4 = this.e(var3).trim()).isEmpty()) {
            var5.a("actualParams", (Object)var4);
         }
      }

      return var5;
   }

   public void a(b.a.c var1, boolean var2) {
      super.a(var1, var2);
      String var4 = var1.f("callName");
      this.a(var4);
      this.c.removeAllElements();
      b.a.a var3;
      if ((var3 = var1.d("actualParams")) != null) {
         for(int var5 = 0; var5 < var3.a(); ++var5) {
            this.b(var3.d(var5));
         }
      }

   }

   public a.c.a.d e() {
      return new b(this.b, (Vector)this.c.clone());
   }

   public final boolean b(int var1) {
      return var1 == 0;
   }

   public final p i() {
      p var1 = new p(1, this.b.length());
      int var2 = this.c.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         var1.a(0, ((String)this.c.get(var3)).length());
      }

      return var1;
   }
}
