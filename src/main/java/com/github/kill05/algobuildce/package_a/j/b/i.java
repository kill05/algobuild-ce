package com.github.kill05.algobuildce.package_a.j.b;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public final class i extends o {
   private e a;
   private String[] k;
   private int[] l;
   private int m;
   private int n;
   private int o;
   private int p;

   public i(com.github.kill05.algobuildce.package_a.c.a.b var1, com.github.kill05.algobuildce.package_a.j.a.a var2, com.github.kill05.algobuildce.package_a.c.a.d var3) {
      super(var1, var2, var3);
      this.a((com.github.kill05.algobuildce.package_a.c.a.d)var3);
      this.a = new e(var1, var2, (com.github.kill05.algobuildce.package_a.c.a.d)null);
      this.add(this.a);
      this.g();
   }

   public final void a(Graphics var1) {
      int var2 = this.getWidth();
      int var3 = this.getHeight();
      int[] var4 = new int[]{var2 / 2 - this.o / 2, var2 / 2, var2 / 2 + this.o / 2, var2 / 2};
      int[] var5 = new int[]{this.p / 2 + 2 * this.f, 2 * this.f, this.p / 2 + 2 * this.f, this.p + 2 * this.f};
      this.a(var1, 0);
      var1.fillPolygon(var4, var5, 4);
      this.d(var1);
      var1.drawPolygon(var4, var5, 4);
      this.d(var1);
      int var7 = this.e;
      int var8 = var2 - this.e;
      var1.drawLine(var2 / 2, 0, var2 / 2, 2 * this.f);
      var1.drawLine(var7, 1 * this.f, var2 / 2, 1 * this.f);
      int var6 = this.b.q().m();
      var1.drawLine(var2 / 2, 1 * this.f, var2 / 2 - var6, 1 * this.f - var6);
      var1.drawLine(var2 / 2, 1 * this.f, var2 / 2 - var6, 1 * this.f + var6);
      var1.drawLine(var7, 1 * this.f, var7, var3 - 2 * this.f);
      var1.drawLine(var7, var3 - 2 * this.f, var2 / 2, var3 - 2 * this.f);
      var1.drawLine(var2 / 2, var3 - 2 * this.f, var2 / 2, var3 - 3 * this.f);
      var1.drawLine(var2 / 2, this.p + 4 * this.f, var2 / 2, this.p + 2 * this.f);
      var1.drawLine(var2 / 2 + this.o / 2, this.p / 2 + 2 * this.f, var8, this.p / 2 + 2 * this.f);
      var1.drawLine(var8, this.p / 2 + 2 * this.f, var8, var3 - this.f);
      var1.drawLine(var8, var3 - 1 * this.f, var2 / 2, var3 - 1 * this.f);
      var1.drawLine(var2 / 2, var3 - 1 * this.f, var2 / 2, var3);
      var3 = this.n;

      for(var7 = 0; var7 < this.k.length; ++var7) {
         var1.drawString(this.k[var7], var2 / 2 - this.l[var7] / 2, var3);
         var3 += 2 * this.f;
      }

      var1.drawString("F", var2 / 2 + this.o / 2 + 2, this.p / 2 + 2 * this.f - 2);
      var1.drawString("T", var2 / 2 + 2, this.p + 4 * this.f - 2);
   }

   public final void a() {
      this.a.g();
      FontMetrics var1 = this.getFontMetrics(this.getFont());
      String var2 = this.i.b();
      this.k = var2.split("\\n");
      this.l = new int[this.k.length];
      this.m = 0;

      int var12;
      for(var12 = 0; var12 < this.k.length; ++var12) {
         this.l[var12] = var1.charsWidth(this.k[var12].toCharArray(), 0, this.k[var12].length());
         this.m = Math.max(this.m, this.l[var12]);
      }

      var12 = ((int)Math.ceil((double)this.m / (double)(2 * this.e)) << 1) * this.e;
      int var3 = (this.k.length << 1) * this.f;
      this.p = var3 + var12 / 2;
      this.o = this.p << 1;
      Rectangle2D var10 = var1.getStringBounds(this.k[0], this.getGraphics());
      this.n = (int)((double)(this.p / 2 - var3 / 2 + 3 * this.f) - var10.getHeight() / 2.0D - var10.getY());
      int var11 = 2 * this.e;
      int var5 = 2 * this.e;
      int var6 = 4 * this.f;
      int var7 = 3 * this.f;
      int var4 = this.p + var6;
      Dimension var8 = this.a.getSize();
      int var9 = this.o;
      if (var8.getWidth() > (double)var9) {
         var9 = (int)var8.getWidth();
      }

      Dimension var13 = new Dimension(var11 + var9 + var5, (int)((double)(this.p + var6 + var7) + var8.getHeight()));
      this.a((Dimension)var13);
      var11 = (int)((double)var11 + ((double)var9 - var8.getWidth()) / 2.0D);
      this.a.setLocation(var11, var4);
      this.j = new Rectangle(this.getWidth() / 2 - var12 / 2, this.n, var12, var3);
   }

   public final void a(com.github.kill05.algobuildce.package_a.c.a.d var1, int var2) {
      o var3 = this.b(var1);
      this.a.a(var3, var2);
      if (this.h != null) {
         C_subclass var4 = this.h.a().a(var3);
         var3.a(var4);
      }

      var1.a(var3);
      this.g();
      this.d = true;
      this.a(this.d);
      this.revalidate();
   }

   public final void a(int var1) {
      this.a.b(var1);
      this.g();
      this.a(true);
      this.revalidate();
   }

   @Override
   protected final void a_() {
      com.github.kill05.algobuildce.package_a.g.e var1 = new com.github.kill05.algobuildce.package_a.g.e((com.github.kill05.algobuildce.package_a.c.b.n)this.i);
      if (com.github.kill05.algobuildce.package_a.a.j.a(this.c.a(), (com.github.kill05.algobuildce.package_a.c.b.g)this.i)) {
         this.c.c().a((com.github.kill05.algobuildce.package_a.g.g)var1);
         this.b.a(true);
      }

      this.b.a((com.github.kill05.algobuildce.package_a.c.a.d)null);
   }

   public final e d() {
      return this.a;
   }

   @Override
   public final void a(C_subclass var1) {
      super.a(var1);
      var1 = var1.a().a(this.a);
      this.a.a(var1);
   }
}
