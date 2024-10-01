package com.github.kill05.algobuildce.package_a.j.b;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class j extends o {
   private String[] a;
   private int[] k;
   private int l;
   private int m;
   private int n;
   private int o;
   private int p;
   private String q = "I/O";

   public j(com.github.kill05.algobuildce.package_a.c.a.b var1, com.github.kill05.algobuildce.package_a.j.a.a var2, com.github.kill05.algobuildce.package_a.c.a.d var3) {
      super(var1, var2, var3);
      this.a((com.github.kill05.algobuildce.package_a.c.a.d)var3);
      this.g();
   }

   public final void a(String var1) {
      this.q = var1;
   }

   @Override
   public final void a(Graphics var1) {
      int var2 = this.getWidth();
      int var3 = this.getHeight();
      int[] var4 = new int[]{var2 / 2 - this.o, var2 / 2 + this.n, var2 / 2 + this.o, var2 / 2 - this.n};
      int[] var5 = new int[]{this.f, this.f, this.f + this.p, this.f + this.p};
      this.b(var1);
      var1.fillPolygon(var4, var5, 4);
      this.c(var1);
      var1.drawPolygon(var4, var5, 4);
      var1.drawLine(var2 / 2, 0, var2 / 2, this.f);
      var1.drawLine(var2 / 2, var3 - this.f, var2 / 2, var3);
      String var6 = this.q;
      int var7 = this.f + this.p;
      int var8 = var2 / 2 - this.n + this.e;
      var1.drawString(var6, var8 + this.b.q().h(), var7 - this.b.q().h());
      var7 = this.m;

      for(var8 = 0; var8 < this.a.length; ++var8) {
         var1.drawString(this.a[var8], var2 / 2 - this.k[var8] / 2, var7);
         var7 += 2 * this.f;
      }

   }

   @Override
   public void a() {
      String var1 = ((com.github.kill05.algobuildce.package_a.c.b.k)this.i).k();
      this.a = var1.split("\\n");
      this.k = new int[this.a.length];
      FontMetrics var4 = this.getFontMetrics(this.getFont());
      this.l = 0;
      Rectangle2D var2 = var4.getStringBounds(this.a[0], this.getGraphics());
      this.m = (int)((double)(3 * this.f) - var2.getHeight() / 2.0D - var2.getY());
      this.p = (this.a.length + 1 << 1) * this.f;

      int var5;
      for(var5 = 0; var5 < this.a.length; ++var5) {
         this.k[var5] = var4.charsWidth(this.a[var5].toCharArray(), 0, this.a[var5].length());
         int var3 = this.k[var5];
         if (var5 == this.a.length - 1) {
            var3 += 2 * (var4.charsWidth(this.q.toCharArray(), 0, this.q.length()) - this.p / 2 + this.e);
         }

         this.l = Math.max(this.l, var3);
      }

      var5 = this.l + 2 * this.e;
      this.o = var5 / 2;
      this.n = this.o + this.p / 2;
      this.a((Dimension)(new Dimension((this.n << 1) + 2 * this.e, this.p + 2 * this.f)));
      this.j = new Rectangle(this.getWidth() / 2 - var5 / 2, this.f, var5, this.p);
   }
}
