package package_a.j.b;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public final class g extends o {
   private final e a;
   private String[] k;
   private int[] l;
   private int m;
   private int n;
   private int o;
   private int p;

   public g(package_a.c.a.b var1, package_a.j.a.a var2, package_a.c.a.d var3) {
      super(var1, var2, var3);
      this.a(var3);
      this.a = new e(var1, var2, null);
      this.add(this.a);
      this.g();
   }

   @Override
   public void a(Graphics var1) {
      int var2 = this.getWidth();
      int var3 = this.getHeight();
      this.d(var1);
      var1.drawString("do", var2 / 2 + 2, 2 * this.f - 2);
      var1.drawLine(var2 / 2, 0, var2 / 2, 2 * this.f);
      int[] var4 = new int[]{var2 / 2 - this.n / 2, var2 / 2, var2 / 2 + this.n / 2, var2 / 2};
      int[] var5 = new int[]{var3 - (this.o / 2 + 2 * this.f), var3 - (this.o + 2 * this.f), var3 - (this.o / 2 + 2 * this.f), var3 - 2 * this.f};
      this.a(var1, 1);
      var1.fillPolygon(var4, var5, 4);
      this.d(var1);
      var1.drawPolygon(var4, var5, 4);
      int var6 = this.e;
      int var7 = this.b.q().m();
      var1.drawLine(var6, this.f, var2 / 2, this.f);
      var1.drawLine(var2 / 2, this.f, var2 / 2 - var7, this.f - var7);
      var1.drawLine(var2 / 2, this.f, var2 / 2 - var7, this.f + var7);
      var1.drawLine(var6, this.f, var6, var3 - (this.o / 2 + 2 * this.f));
      var1.drawLine(var6, var3 - (this.o / 2 + 2 * this.f), var2 / 2 - this.n / 2, var3 - (this.o / 2 + 2 * this.f));
      var1.drawLine(var2 / 2, var3 - 2 * this.f, var2 / 2, var3);
      var6 = var3 - this.p - 2 * this.f;

      for(var7 = 0; var7 < this.k.length; ++var7) {
         var1.drawString(this.k[var7], var2 / 2 - this.l[var7] / 2, var6);
         var6 += 2 * this.f;
      }

      var6 = var1.getFontMetrics().charsWidth("T".toCharArray(), 0, 1);
      var1.drawString("F", var2 / 2 + 2, var3 - 2);
      var1.drawString("T", var2 / 2 - this.n / 2 - var6 + 2, var3 - (this.o / 2 + 2 * this.f) - 2);
   }

   @Override
   public void a() {
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
      this.o = var3 + var12 / 2;
      this.n = this.o << 1;
      Rectangle2D var10 = var1.getStringBounds(this.k[0], this.getGraphics());
      this.p = (int)((double)(this.o / 2 + var3 / 2 - this.f) + var10.getHeight() / 2.0D + var10.getY());
      int var11 = 2 * this.e;
      int var5 = 2 * this.e;
      int var6 = 2 * this.f;
      int var7 = 2 * this.f;
      Dimension var8 = this.a.getSize();
      int var9 = this.n;
      if (var8.getWidth() > (double)var9) {
         var9 = (int)var8.getWidth();
      }

      this.a(new Dimension(var11 + var9 + var5, (int)((double)(this.o + var6 + var7) + var8.getHeight())));
      var11 = (int)((double)var11 + ((double)var9 - var8.getWidth()) / 2.0D);
      this.a.setLocation(var11, var6);
      this.j = new Rectangle(this.getWidth() / 2 - var12 / 2, this.getHeight() - this.p, var12, var3);
   }

   @Override
   public void a(package_a.c.a.d var1, int var2) {
      o var3 = this.b(var1);
      this.a.a(var3, var2);
      if (this.h != null) {
         C_subclass var4 = this.h.a().a(var3);
         var3.a(var4);
      }

      var1.a(var3);
      this.g();
      this.revalidate();
      this.d = true;
      this.a(this.d);
   }

   @Override
   public void a(int var1) {
      this.a.b(var1);
      this.g();
      this.a(true);
      this.invalidate();
   }

   @Override
   protected void a_() {
      package_a.g.e var1 = new package_a.g.e((package_a.c.b.n)this.i);
      package_a.a.f.a(this.c.a(), (package_a.c.b.e)this.i);
      this.c.c().a(var1);
      this.b.a(true);
      this.b.a((package_a.c.a.d)null);
   }

   public e d() {
      return this.a;
   }

   @Override
   public void a(C_subclass var1) {
      super.a(var1);
      var1 = var1.a().a(this.a);
      this.a.a(var1);
   }
}
