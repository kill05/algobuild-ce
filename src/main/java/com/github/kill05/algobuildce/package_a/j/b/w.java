package com.github.kill05.algobuildce.package_a.j.b;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

public final class w extends C_subclass {
   private String[] b;
   private int[] c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private String j = "FOR ";
   private String k = "END FOR";

   public w(p var1, D_subclass var2) {
      super(var2);
   }

   @Override
   public final void a(ABBasePanel var1, Graphics var2) {
      int var3 = var1.getWidth();
      var1.getHeight();
      Dimension var4 = ((h)var1).d().getMinimumSize();
      var1.setFillingColor(var2);
      var2.fillRect(0, 0, var3, this.e);
      var1.setFillingColor((Graphics)var2, 1);
      var2.fillRect(0, this.e, var1.centerY, (int)((double)this.e + var4.getHeight() + (double)(3 * var1.centerY)));
      var1.setLineColor(var2);
      int var5 = this.f;
      var2.drawString(this.j, 0, var5);

      for(int var6 = 0; var6 < this.b.length; ++var6) {
         var2.drawString(this.b[var6], this.i, var5);
         var5 += 2 * var1.centerY;
      }

      var5 = (int)((double)(var5 + var1.centerY) + var4.getHeight());
      var1.setFillingColor((Graphics)var2, 1);
      var2.fillRect(0, var5 - 2 * var1.centerY, var3, 3 * var1.centerY);
      var1.setLineColor(var2);
      var2.drawString(this.k, 0, var5);
   }

   @Override
   public final void a(ABBasePanel var1) {
      h var2;
      FontMetrics var4 = (var2 = (h)var1).getFontMetrics(var1.getFont());
      String var3 = var2.executable.getDisplayName();
      this.i = var4.charsWidth(this.j.toCharArray(), 0, this.j.length());
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
      var8.height += var5.height + 3 * var2.centerY;
      var2.forceSize((Dimension)var8);
      int var6 = 2 * var2.centerX;
      var2.d().setLocation(var6, 3 * var2.centerY);
      this.a(new Rectangle(this.d, this.e));
      var2.revalidate();
   }
}
