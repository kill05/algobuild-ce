package com.github.kill05.algobuildce.package_a.j.b;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;

public final class v extends C_subclass {
   private String[] b;
   private int[] c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private final String j = "DO ";
   private final String k = "END DO WHILE ";

   public v(p var1, D_subclass var2) {
      super(var2);
   }

   @Override
   public void a(ABBasePanel var1, Graphics var2) {
      int var3 = var1.getWidth();
      var1.getHeight();
      Dimension var4 = ((g)var1).d().getMinimumSize();
      var1.setFillingColor(var2, 2);
      var2.fillRect(0, 0, var3, 3 * var1.centerY);
      var2.fillRect(0, 0, var1.centerX, (int)(var4.getHeight() + (double)this.e + (double)(3 * var1.centerY)));
      var1.setLineColor(var2);
      int var5 = this.f;
      var2.drawString(this.j, 0, var5);
      var5 = (int)((double)(var5 + var1.centerY) + var4.getHeight());
      var1.setFillingColor(var2, 1);
      var2.fillRect(0, var5, var3, this.e);
      var5 += 2 * var1.centerY;
      var1.setLineColor(var2);
      var2.drawString(this.k, 0, var5);

      for(var3 = 0; var3 < this.b.length; ++var3) {
         var2.drawString(this.b[var3], this.i, var5);
         var5 += 2 * var1.centerY;
      }

   }

   @Override
   public void a(ABBasePanel var1) {
      g var2;
      FontMetrics var4 = (var2 = (g)var1).getFontMetrics(var1.getFont());
      String var3 = var2.executable.getDisplayName();
      this.i = var4.charsWidth(this.k.toCharArray(), 0, this.k.length());
      this.b = var3.split("\\n");
      this.c = new int[this.b.length];
      this.d = 0;
      this.e = ((this.b.length << 1) + 1) * var2.centerY;
      this.f = 2 * var2.centerY;

      for(int var7 = 0; var7 < this.b.length; ++var7) {
         this.c[var7] = var4.charsWidth(this.b[var7].toCharArray(), 0, this.b[var7].length());
         this.d = Math.max(this.d, this.i + this.c[var7]);
      }

      this.g = ((int)Math.ceil((double)this.d / (double)(2 * var2.centerX)) << 1) * var2.centerX;
      this.h = ((this.b.length << 1) + 1) * var2.centerY;
      Dimension var8 = new Dimension(this.g, this.h);
      var2.d().g();
      Dimension var5 = var2.d().getMinimumSize();
      var8.width = Math.max(var8.width, var5.width + 2 * var2.centerX) + 2 * var2.centerX;
      var8.height += var5.height + 4 * var2.centerY;
      var2.forceSize(var8);
      int var6 = 2 * var2.centerX;
      var2.d().setLocation(var6, 3 * var2.centerY);
      var2.revalidate();
   }
}
