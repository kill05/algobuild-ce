package package_a.c.a;

import package_a.c.b.n;
import package_a.c.b.p;
import package_a.c.b.q;
import java.awt.Component;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;
import javax.swing.JOptionPane;

public final class b {
   private Map a = null;
   private Stack b;
   private package_c.a c;
   private a d = null;
   private Stack e;
   private Vector f = null;
   private d g;
   private d h;
   private String i;
   private boolean j;
   private i k;
   private f l;
   private String m = "";
   private int n = 0;
   private boolean o = false;
   private g p;

   public final c a() {
      return this.b != null && !this.b.isEmpty() ? (c)this.b.peek() : null;
   }

   public b() {
      this.a = new TreeMap();
      this.b = new Stack();
      this.c = new package_c.a();
      this.d = new a();
      this.e = new Stack();
      this.k = new i();

      try {
         i var1 = this.k;
         String var2 = "ViewOptions.abopt";
         File var3 = package_a.f.j.c();
         File var5 = new File(var3, var2);
         FileReader var8 = new FileReader(var5);
         b.a.f var6 = new b.a.f(var8);
         b.a.c var7 = (new b.a.c(var6)).e("opt");
         var8.close();
         var1.a(var7);
      } catch (IOException var4) {
      }

      this.l = new f();
      this.p = new g();
   }

   public final void b() {
      this.b.clear();
      this.e.clear();
      this.a.clear();
      this.m = "";
      this.n = 0;
      this.o = false;
      this.p.c();
   }

   public final Map c() {
      return (Map)this.e.peek();
   }

   public final Stack d() {
      return this.b;
   }

   public final package_c.a e() {
      return this.c;
   }

   public final void f() {
      TreeMap var1 = new TreeMap();
      this.e.push(var1);
      this.a = var1;
   }

   public final void g() {
      if (!this.e.isEmpty()) {
         this.e.pop();
      }

      if (!this.e.isEmpty()) {
         this.a = (Map)this.e.firstElement();
      } else {
         this.a = null;
      }
   }

   public final a h() {
      return this.d;
   }

   public final void i() {
      String var1 = "";
      String var2 = "VARIABLES:\n";
      Map var3;
      Iterator var4;
      Entry var5;
      if ((var3 = this.c()) != null) {
         for(var4 = var3.entrySet().iterator(); var4.hasNext(); var2 = var2 + (String)var5.getKey() + "=" + ((package_c.f)var5.getValue()).a() + "\n") {
            var5 = (Entry)var4.next();
            var1 = var1 + " | " + (String)var5.getKey() + "=" + ((package_c.f)var5.getValue()).b();
         }
      }

      if (var1.length() > 0) {
         var1 = "    VAR: " + var1 + " |";
      }

      j var6;
      if (this.f != null && this.f.size() != 0) {
         for(var4 = this.f.iterator(); var4.hasNext(); var6.f(var2)) {
            var6 = (j)var4.next();
            if (var1.length() > 0) {
               var6.d(var1);
            }
         }
      } else if (var1.length() > 0) {
         this.h(var1);
         return;
      }

   }

   public final void a(String var1, int var2) {
      q var4 = this.d.a(var1, var2);
      if (this.f != null) {
         Iterator var3 = this.f.iterator();

         while(var3.hasNext()) {
            ((j)var3.next()).a((d)var4);
         }

         var4.f();
      }

      this.a(true);
   }

   public final void a(q var1) {
      var1 = this.d.a(var1);
      if (this.f != null) {
         Iterator var3 = this.f.iterator();

         while(var3.hasNext()) {
            ((j)var3.next()).a((d)var1);
         }

         var1.f();
      }

      this.a(true);
   }

   public final void a(String var1, q var2) {
      System.out.println("CODE VIEW - RENAME CODE:" + var1 + " to " + var2.j());
      q var3 = this.d.a(var1);
      q var4 = this.d.a(var2.j());
      if (var3 != null && var4 == null) {
         this.d.c(var1);
         this.a(true);
         if (this.f != null) {
            Iterator var5 = this.f.iterator();

            while(var5.hasNext()) {
               ((j)var5.next()).a(var1, var2);
            }
         }
      }

   }

   public final q a(String var1) {
      return this.d.a(var1);
   }

   public final void b(String var1) {
      q var2 = this.d.a(var1);
      this.d.b(var1);
      this.a(true);
      if (this.f != null) {
         Iterator var3 = this.f.iterator();

         while(var3.hasNext()) {
            ((j)var3.next()).b((d)var2);
         }
      }

   }

   public final void a(String var1, int var2, n var3) {
      this.l(var1).a(var3, var2);
      this.a(true);
   }

   public final void c(String var1) {
      int var2;
      if ((var2 = var1.lastIndexOf(".")) >= 0) {
         String var3 = var1.substring(0, var2);
         d var5 = this.l(var3);
         int var4 = Integer.parseInt(var1.substring(var2 + 1));
         var5.d(var4);
      } else {
         this.b(var1);
      }

      this.a(true);
   }

   public final n d(String var1) {
      int var2;
      if (var1 != null && !var1.isEmpty() && (var2 = var1.indexOf(46)) >= 0) {
         String var3 = var1.substring(0, var2);
         q var7 = this.a(var3);
         if ((var1 = var1.substring(var2 + 1)) != null) {
            String[] var4 = var1.split("[.]");
            String[] var6 = var4;
            if (var4.length == 1) {
               return var7.c(Integer.parseInt(var4[0]));
            }

            n var5 = var7.c(Integer.parseInt(var4[0]));

            for(int var8 = 1; var8 < var6.length - 1; ++var8) {
               var5 = var5.c(Integer.parseInt(var6[var8]));
            }

            return var5.c(Integer.parseInt(var6[var6.length - 1]));
         }
      }

      return null;
   }

   private d l(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         return (d)(var1.indexOf(46) >= 0 ? this.d(var1) : this.a(var1));
      } else {
         return null;
      }
   }

   public final d j() {
      return this.g;
   }

   public final void a(d var1) {
      d var2 = this.g;
      this.g = var1;
      if (var2 != null) {
         var2.a(false);
      }

      if (this.g != null) {
         this.g.a(false);
      }

   }

   public final d k() {
      return this.h;
   }

   public final void b(d var1) {
      this.h = var1;
   }

   public final void a(j var1) {
      if (var1 != null) {
         if (this.f == null) {
            this.f = new Vector();
         }

         this.f.add(var1);
         var1.a(this);
      }

   }

   public final void l() {
      ++this.n;
      if (this.f != null) {
         Iterator var2 = this.f.iterator();

         while(var2.hasNext()) {
            ((j)var2.next()).a(this.n);
         }
      }

   }

   public final void m() {
      this.m.length();
      if (this.n >= 0) {
         --this.n;
         if (this.f != null) {
            Iterator var2 = this.f.iterator();

            while(var2.hasNext()) {
               ((j)var2.next()).a(this.n);
            }
         }
      }

   }

   public final String e(String var1) {
      String var2 = null;
      if (this.f != null && this.f.size() != 0) {
         Iterator var3 = this.f.iterator();

         while(var3.hasNext()) {
            if ((var2 = ((j)var3.next()).g(var1)) != null) {
               return var2;
            }
         }
      }

      return var2;
   }

   public final void f(String var1) {
      if (this.f != null && this.f.size() != 0) {
         Iterator var3 = this.f.iterator();

         while(var3.hasNext()) {
            j var2 = (j)var3.next();
            if (this.o) {
               var2.a(this.m);
            }

            this.o = var1.endsWith("\n");
            var2.a(var1.replace("\n", "\n" + this.m));
         }

      } else {
         if (this.o) {
            System.out.print(this.m);
         }

         this.o = var1.endsWith("\n");
         System.out.print(var1.replace("\n", "\n" + this.m));
      }
   }

   public final void n() {
      if (this.f != null && this.f.size() != 0) {
         Iterator var2 = this.f.iterator();

         while(var2.hasNext()) {
            ((j)var2.next()).b();
         }
      } else {
         System.out.println();
      }

      this.o = true;
   }

   public final void g(String var1) {
      j var2;
      if (this.f != null && this.f.size() != 0) {
         for(Iterator var3 = this.f.iterator(); var3.hasNext(); var2.b(var1)) {
            var2 = (j)var3.next();
            if (this.o) {
               var2.a(this.m);
            }
         }
      } else {
         if (this.o) {
            System.out.print(this.m);
         }

         System.out.println(var1);
      }

      this.o = true;
   }

   public final void h(String var1) {
      if (this.f != null && this.f.size() != 0) {
         Iterator var3 = this.f.iterator();

         while(var3.hasNext()) {
            ((j)var3.next()).c(var1);
         }

      } else {
         this.g(var1);
      }
   }

   public final void i(String var1) {
      if (this.f != null && this.f.size() != 0) {
         Iterator var3 = this.f.iterator();

         while(var3.hasNext()) {
            ((j)var3.next()).e(var1);
         }

      } else {
         this.g(var1);
      }
   }

   private b.a.c t() {
      b.a.c var1;
      (var1 = new b.a.c()).b("abiid", "ABEENV");
      Iterator var2 = this.d.a().iterator();

      while(var2.hasNext()) {
         b.a.c var3 = ((q)var2.next()).b(true);
         var1.a("codepool", (Object)var3);
      }

      var1.b("viewOptions", this.k.n());
      var1.b("saveHistory", this.p.a());
      return var1;
   }

   public final void j(String var1) {
      package_a.f.f var2 = package_a.f.f.a();
      String var3;
      if ((var3 = package_a.f.k.a().d()) != null) {
         String var4 = package_a.f.k.a().b();
         p var5 = this.d.d();
         String var6 = var5.a() + "/" + var5.b();
         File var9 = new File(var1);
         this.p.a(var4, var3, var9.getName(), var6);
      }

      b.a.c var8 = this.t();

      try {
         var2.a(var1, var8);
         this.j = false;
         this.i = var1;
         Iterator var10 = this.f.iterator();

         while(var10.hasNext()) {
            ((j)var10.next()).b(this);
         }

      } catch (package_a.f.h var7) {
         JOptionPane.showMessageDialog((Component)null, var7.getMessage());
      }
   }

   public final void k(String var1) {
      package_a.f.f var2 = package_a.f.f.a();

      try {
         b.a.c var9;
         if ((var9 = var2.a(var1)) != null) {
            if (this.f != null) {
               Iterator var5 = this.f.iterator();

               while(var5.hasNext()) {
                  ((j)var5.next()).a();
               }
            }

            this.b();
            this.d.b();
            b.a.c var4 = var9;
            b var3 = this;
            b.a.c var13 = var9.e("saveHistory");
            this.p.c();
            if (var13 != null) {
               this.p.a(var13);
            }

            if ((var9 = var9.e("viewOptions")) != null) {
               this.k.a(var9);
            }

            b.a.a var10;
            if ((var10 = var4.d("codepool")) != null) {
               for(int var12 = 0; var12 < var10.a(); ++var12) {
                  n var6;
                  (var6 = package_a.c.b.n.a(var13 = var10.c(var12))).a(var13, true);
                  if (var6 instanceof q) {
                     var3.a((q)var6);
                  }
               }
            }

            this.j = false;
            this.i = var1;
            Iterator var11 = this.f.iterator();

            while(var11.hasNext()) {
               ((j)var11.next()).b(this);
            }

            return;
         }
      } catch (package_a.f.h var8) {
         JOptionPane.showMessageDialog((Component)null, var8.getMessage());
      }

   }

   public final String o() {
      return this.i;
   }

   public final boolean p() {
      return this.j;
   }

   public final void a(boolean var1) {
      this.j = var1;
      Iterator var3 = this.f.iterator();

      while(var3.hasNext()) {
         ((j)var3.next()).b(this);
      }

      if (var1) {
         Iterator var2 = this.d.a().iterator();

         while(var2.hasNext()) {
            ((q)var2.next()).a(true);
         }
      }

   }

   public final i q() {
      return this.k;
   }

   public final f r() {
      return this.l;
   }

   public final String s() {
      return this.p.b();
   }
}
