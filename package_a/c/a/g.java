package package_a.c.a;

import package_a.i.Translator;
import package_b.a.c;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Vector;

public final class g {
   private Vector a = null;
   private h b = null;

   g() {
   }

   public final c a() {
      c var1 = new c();
      if (this.a != null) {
         Iterator var3 = this.a.iterator();

         while(var3.hasNext()) {
            h var2 = (h)var3.next();
            var1.a("saveHistoryItems", (Object)var2.a());
         }
      }

      if (this.b != null) {
         var1.a("saveHistoryItems", (Object)this.b.a());
      }

      return var1;
   }

   public final void a(String var1, String var2, String var3, String var4) {
      this.b = new h(this, var1, var2, System.currentTimeMillis(), var3, var4);
   }

   public final void a(c var1) {
      package_b.a.a var5;
      if ((var5 = var1.d("saveHistoryItems")) != null) {
         int var2 = var5.a();
         this.a = new Vector(var2);
         this.b = null;

         for(var2 = 0; var2 < var5.a(); ++var2) {
            c var3 = var5.c(var2);
            h var4;
            (var4 = new h(this)).a(var3);
            this.a.add(var4);
         }
      }

   }

   public final String toString() {
      return "ABESaveHistory [saveHistory=" + this.a + ", actualSessionSave=" + this.b + "]";
   }

   public final String b() {
      String var1 = null;
      (new SimpleDateFormat()).applyPattern("yyyy-MM-dd HH:mm:ss");
      if (this.b != null) {
         var1 = this.b.b() + "\n\n";
      }

      if (this.a != null && this.a.size() > 0) {
         if (var1 == null) {
            var1 = "";
         }

         for(int var2 = this.a.size() - 1; var2 >= 0; --var2) {
            h var3 = (h)this.a.get(var2);
            var1 = var1 + var3.b() + "\n";
         }
      }

      if (var1 == null) {
         var1 = Translator.translate("mnuHistoryIsEmpty");
      }

      return var1;
   }

   public final void c() {
      this.a = null;
      this.b = null;
   }
}
