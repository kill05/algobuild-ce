package package_a.j.b;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;

public final class s extends C {
   private String[] b;
   private int[] c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private String j = "//";

   public s(p var1, D var2) {
      super(var2);
   }

   public final void a(n var1, Graphics var2) {
      int var3 = var1.getWidth();
      var1.getHeight();
      var1.b(var2);
      var2.fillRect(0, 0, var3, this.e);
      var1.c(var2);
      var3 = this.f;

      for(int var4 = 0; var4 < this.b.length; ++var4) {
         var2.drawString(this.j, 0, var3);
         var2.drawString(this.b[var4], this.i, var3);
         var3 += 2 * var1.f;
      }

   }

   public final void a(n var1) {
      d var2;
      FontMetrics var4 = (var2 = (d)var1).getFontMetrics(var1.getFont());
      String var3 = var2.i.b();
      this.i = var4.charsWidth(this.j.toCharArray(), 0, this.j.length());
      this.b = var3.split("\\n");
      this.c = new int[this.b.length];
      this.d = 0;
      this.e = ((this.b.length << 1) + 1) * var2.f;
      this.f = 2 * var2.f;

      for(int var5 = 0; var5 < this.b.length; ++var5) {
         this.c[var5] = var4.charsWidth(this.b[var5].toCharArray(), 0, this.b[var5].length());
         this.d = Math.max(this.d, this.i + this.c[var5]);
      }

      this.g = ((int)Math.ceil((double)this.d / (double)(2 * var2.e)) << 1) * var2.e;
      this.h = ((this.b.length << 1) + 1) * var2.f;
      Dimension var6 = new Dimension(this.g, this.h);
      var2.a(var6);
   }
}
