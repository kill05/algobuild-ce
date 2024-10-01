package package_a.c.a;

import package_b.a.c;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class h {
   private String a;
   private String b;
   private long c;
   private String d;
   private String e;

   public h(g var1) {
      this.a = null;
      this.b = null;
      this.c = 0L;
      this.d = null;
      this.e = null;
   }

   public h(g var1, String var2, String var3, long var4, String var6, String var7) {
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var6;
      this.e = var7;
   }

   public final package_b.a.c a() {
      package_b.a.c var1;
      (var1 = new c()).b("s", this.a);
      var1.b("package_a", this.b);
      long var4 = this.c;
      String var3 = "t";
      var1.b(var3, new Long(var4));
      var1.b("f", this.d);
      var1.b("z", this.e);
      return var1;
   }

   public final void a(package_b.a.c var1) {
      this.a = var1.f("s");
      this.b = var1.f("package_a");
      String var3 = "t";
      this.c = var1.a(var3, 0L);
      this.d = var1.f("f");
      this.e = var1.f("z");
   }

   public final String toString() {
      return "SaveHistoryEntry [serial=" + this.a + ", authorName=" + this.b + ", saveTime=" + this.c + ", fileName=" + this.d + ", sizeDescription=" + this.e + "]";
   }

   public final String b() {
      String var1 = "";
      SimpleDateFormat var2;
      (var2 = new SimpleDateFormat()).applyPattern("yyyy-MM-dd HH:mm:ss");
      Date var3 = new Date(this.c);
      String var4 = var2.format(var3);
      if (this.b != null && this.b.length() > 0) {
         var1 = var1 + "u:" + this.b;
      }

      if (this.a != null && this.a.length() > 0) {
         var1 = var1 + "  /  s:" + this.a;
      }

      if (var4 != null && var4.length() > 0) {
         var1 = var1 + "  /  d:" + var4;
      }

      if (this.d != null && this.d.length() > 0) {
         var1 = var1 + " fn:" + this.d;
      }

      if (this.e != null && this.e.length() > 0) {
         var1 = var1 + " fs:" + this.e;
      }

      return var1;
   }
}
