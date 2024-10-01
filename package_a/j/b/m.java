package package_a.j.b;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public final class m extends o {
   private e a;
   private e k;
   private String[] l;
   private int[] m;
   private int n;
   private int o;
   private int p;
   private int q;

   public m(package_a.c.a.b var1, package_a.j.a.a var2, package_a.c.a.d var3) {
      super(var1, var2, var3);
      this.a((package_a.c.a.d)var3);
      package_a.c.b.l var4 = (package_a.c.b.l)var3;
      this.k = new e(var1, var2, (package_a.c.a.d)null);
      this.add(this.k);
      var4.j().a(this.k);
      this.a = new e(var1, var2, (package_a.c.a.d)null);
      this.add(this.a);
      var4.k().a(this.a);
      this.g();
   }

   public final void a(Graphics var1) {
      int var2 = this.getWidth();
      int var3 = this.getHeight();
      int var4 = this.q;
      Dimension var5 = this.a.getSize();
      Dimension var6 = this.k.getSize();
      int var7;
      if ((double)(var7 = (int)var5.getWidth()) < var6.getWidth()) {
         var7 = (int)var6.getWidth();
      }

      if ((double)((int)var5.getHeight()) < var6.getHeight()) {
         var6.getHeight();
      }

      this.a.getWidth();
      this.k.getWidth();
      this.a.getSize();
      this.k.getSize();
      int[] var8 = new int[]{var2 / 2 - this.p / 2, var2 / 2, var2 / 2 + this.p / 2, var2 / 2};
      int[] var9 = new int[]{this.q / 2, 0, this.q / 2, this.q};
      this.a(var1, 0);
      var1.fillPolygon(var8, var9, 4);
      this.d(var1);
      var1.drawPolygon(var8, var9, 4);
      var1.drawLine(var7 / 2, this.q / 2, var2 / 2 - this.p / 2, this.q / 2);
      var1.drawLine(var7 / 2, this.q / 2, var7 / 2, var4);
      var1.drawLine(var2 / 2 + this.p / 2, this.q / 2, var2 - var7 / 2, this.q / 2);
      var1.drawLine(var2 - var7 / 2, this.q / 2, var2 - var7 / 2, var4);
      var1.drawLine(var7 / 2, (int)((double)(this.q / 2) + var5.getHeight() + (double)this.f), var7 / 2, var3 - this.f);
      var1.drawLine(var7 / 2, var3 - this.f, var2 / 2, var3 - this.f);
      var1.drawLine(var2 - var7 / 2, (int)((double)(this.q / 2) + var6.getHeight() + (double)this.f), var2 - var7 / 2, var3 - this.f);
      var1.drawLine(var2 - var7 / 2, var3 - this.f, var2 / 2, var3 - this.f);
      var1.drawLine(var2 / 2, var3 - 1 * this.f, var2 / 2, var3);
      var3 = this.o;

      for(var4 = 0; var4 < this.l.length; ++var4) {
         var1.drawString(this.l[var4], var2 / 2 - this.m[var4] / 2, var3);
         var3 += 2 * this.f;
      }

      var4 = var1.getFontMetrics().charsWidth("F".toCharArray(), 0, 1);
      var1.drawString("F", var2 / 2 - this.p / 2 - var4, this.q / 2 - 2);
      var1.drawString("T", var2 / 2 + this.p / 2, this.q / 2 - 2);
   }

   public final void a() {
      this.a.g();
      this.k.g();
      FontMetrics var1 = this.getFontMetrics(this.getFont());
      String var2 = this.i.b();
      this.l = var2.split("\\n");
      this.m = new int[this.l.length];
      this.n = 0;

      int var14;
      for(var14 = 0; var14 < this.l.length; ++var14) {
         this.m[var14] = var1.charsWidth(this.l[var14].toCharArray(), 0, this.l[var14].length());
         this.n = Math.max(this.n, this.m[var14]);
      }

      var14 = ((int)Math.ceil((double)this.n / (double)(2 * this.e)) << 1) * this.e;
      int var3 = (this.l.length << 1) * this.f;
      this.q = var3 + var14 / 2;
      this.p = this.q << 1;
      Rectangle2D var12 = var1.getStringBounds(this.l[0], this.getGraphics());
      this.o = (int)((double)(this.q / 2 - var3 / 2 + this.f) - var12.getHeight() / 2.0D - var12.getY());
      int var5 = 1 * this.e;
      int var6 = 1 * this.e;
      int var13 = 2 * this.f;
      int var4 = this.q;
      Dimension var7 = this.a.getSize();
      Dimension var8 = this.k.getSize();
      int var9 = this.p;
      int var10;
      if ((double)(var10 = (int)var7.getWidth()) < var8.getWidth()) {
         var10 = (int)var8.getWidth();
      }

      int var11;
      if ((double)(var11 = (int)var7.getHeight()) < var8.getHeight()) {
         var11 = (int)var8.getHeight();
      }

      if (var9 < var10) {
         var9 = var10;
      }

      this.a((Dimension)(new Dimension(var5 + var9 + var6 + var10, this.q + var13 + var11)));
      var13 = (int)(((double)var10 - var7.getWidth()) / 2.0D);
      this.a.setLocation(var13, var4);
      var13 = (int)((double)(var5 + var9 + var6 + var10 / 2) - var8.getWidth() / 2.0D);
      this.k.setLocation(var13, var4);
      this.j = new Rectangle(this.getWidth() / 2 - var14 / 2, this.o, var14, var3);
   }

   public final void a(package_a.j.b.c var1) {
      super.a((package_a.j.b.c)var1);
      package_a.j.b.c var2 = var1.a().a(this.k);
      this.k.a(var2);
      var2 = var1.a().a(this.a);
      this.a.a(var2);
   }

   public final e d() {
      return this.a;
   }

   public final e e() {
      return this.k;
   }

   protected final void a_() {
      package_a.g.e var1 = new package_a.g.e((package_a.c.b.n)this.i);
      if (a.a.i.a(this.c.a(), (package_a.c.b.l)this.i)) {
         this.c.c().a((package_a.g.g)var1);
         this.b.a(true);
      }

      this.b.a((package_a.c.a.d)null);
   }
}
