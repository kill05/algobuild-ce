package package_a.j.b;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public final class D extends o {
   private String[] a;
   private int[] k;
   private int l;
   private int m;
   private int n;
   private int o;

   public D(package_a.c.a.b var1, package_a.j.a.a var2, package_a.c.a.d var3) {
      super(var1, var2, var3);
      var3.a((package_a.c.a.k)this);
      this.g();
   }

   public final void a(Graphics var1) {
      int var2 = this.getWidth();
      int var3 = this.getHeight();
      int[] var4 = new int[]{var2 / 2 - this.n / 2, var2 / 2 + this.n / 2 - 2 * this.e, var2 / 2 + this.n / 2, var2 / 2 + this.n / 2, var2 / 2 - this.n / 2};
      int[] var5 = new int[]{this.f, this.f, this.f + 2 * this.f, this.f + this.o, this.f + this.o};
      this.b(var1);
      var1.fillPolygon(var4, var5, 5);
      this.c(var1);
      var1.drawPolygon(var4, var5, 5);
      var1.drawLine(var2 / 2 + this.n / 2 - 2 * this.e, this.f, var2 / 2 + this.n / 2 - 2 * this.e, 3 * this.f);
      var1.drawLine(var2 / 2 + this.n / 2 - 2 * this.e, 3 * this.f, var2 / 2 + this.n / 2, 3 * this.f);
      var1.drawLine(var2 / 2, 0, var2 / 2, this.f);
      var1.drawLine(var2 / 2, var3 - this.f, var2 / 2, var3);
      var3 = this.m;

      for(int var6 = 0; var6 < this.a.length; ++var6) {
         var1.drawString(this.a[var6], var2 / 2 - this.k[var6] / 2, var3);
         var3 += 2 * this.f;
      }

   }

   public final void a() {
      String var1 = this.i.b();
      FontMetrics var2 = this.getFontMetrics(this.getFont());
      this.a = var1.split("\\n");
      this.k = new int[this.a.length];
      this.l = 0;
      Rectangle2D var3 = var2.getStringBounds(this.a[0], this.getGraphics());
      this.m = (int)((double)(3 * this.f) - var3.getHeight() / 2.0D - var3.getY());

      for(int var4 = 0; var4 < this.a.length; ++var4) {
         this.k[var4] = var2.charsWidth(this.a[var4].toCharArray(), 0, this.a[var4].length());
         this.l = Math.max(this.l, this.k[var4]);
      }

      this.n = (4 + ((int)Math.ceil((double)this.l / (double)(2 * this.e)) << 1)) * this.e;
      this.o = (this.a.length + 1 << 1) * this.f;
      Dimension var5 = new Dimension(this.n + 2 * this.e, this.o + 2 * this.f);
      this.a(var5);
      this.j = new Rectangle(this.getWidth() / 2 - this.n / 2, this.f, this.n, this.o);
   }

   protected final void a_() {
      package_a.g.e var1 = new package_a.g.e((package_a.c.b.n)this.i);
      if (a.a.d.a(this.c.a(), (package_a.c.b.d)this.i)) {
         this.c.c().a((package_a.g.g)var1);
         this.b.a(true);
      }

      this.b.a((package_a.c.a.d)null);
   }
}
