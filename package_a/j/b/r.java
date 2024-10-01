package package_a.j.b;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Vector;

public final class r extends c.C {
   private String[] b;
   private int[] c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private String j = "CALL ";

   public r(p var1, D var2) {
      super(var2);
   }

   public final void a(n var1, Graphics var2) {
      int var3 = var1.getWidth();
      var1.getHeight();
      var1.b(var2);
      var2.fillRect(0, 0, var3, this.e);
      var1.c(var2);
      var3 = this.f;
      var2.drawString(this.j, 0, var3);

      for(int var4 = 0; var4 < this.b.length; ++var4) {
         var2.drawString(this.b[var4], this.i, var3);
         var3 += 2 * var1.f;
      }

   }

   public final void a(n var1) {
      b var2;
      FontMetrics var7 = (var2 = (b)var1).getFontMetrics(var1.getFont());
      this.i = var7.charsWidth(this.j.toCharArray(), 0, this.j.length());
      package_a.c.b.b var3;
      Vector var4 = (var3 = (package_a.c.b.b)var2.i).k();
      String var8 = var3.j() + "(";
      int var5 = var4.size();

      int var6;
      for(var6 = 0; var6 < var5; ++var6) {
         if (var6 == 0) {
            var8 = var8 + (String)var4.elementAt(var6);
         } else {
            var8 = var8 + ", " + (String)var4.elementAt(var6);
         }
      }

      var8 = var8 + ")";
      String var9;
      if (var2.i instanceof package_a.c.b.c && (var9 = ((package_a.c.b.c)var2.i).l()) != null && var9.length() > 0) {
         var8 = var9 + " = " + var8;
      }

      this.b = var8.split("\\n");
      this.c = new int[this.b.length];
      this.d = 0;
      this.e = ((this.b.length << 1) + 1) * var2.f;
      this.f = 2 * var2.f;

      for(var6 = 0; var6 < this.b.length; ++var6) {
         this.c[var6] = var7.charsWidth(this.b[var6].toCharArray(), 0, this.b[var6].length());
         this.d = Math.max(this.d, this.i + this.c[var6]);
      }

      this.g = ((int)Math.ceil((double)this.d / (double)(2 * var2.e)) << 1) * var2.e;
      this.h = ((this.b.length << 1) + 1) * var2.f;
      Dimension var10 = new Dimension(this.g, this.h);
      var2.a(var10);
   }
}
