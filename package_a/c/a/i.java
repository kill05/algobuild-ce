package package_a.c.a;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;

public final class i {
   private Font a;
   private Font b;
   private Color c;
   private Color d;
   private Color e;
   private Color f;
   private int g;
   private Color h;
   private Color i;
   private Color j;
   private Stroke k;
   private int l;

   public i() {
      this.a();
   }

   public final void a() {
      this.a = new Font("SansSerif", 0, (int)(12.0D * a.k.b.a()));
      this.b = new Font("SansSerif", 0, (int)(12.0D * a.k.b.a()));
      this.c = Color.WHITE;
      this.d = Color.WHITE;
      this.e = Color.GREEN;
      this.f = new Color(235, 235, 255);
      this.g = 1;
      this.h = Color.BLACK;
      this.i = Color.BLACK;
      this.j = Color.DARK_GRAY;
      this.o();
      this.l = 6;
   }

   public final Font b() {
      return this.a;
   }

   public final void a(Font var1) {
      this.a = var1;
   }

   public final Font c() {
      return this.b;
   }

   public final void b(Font var1) {
      this.b = var1;
   }

   public final Color d() {
      return this.c;
   }

   public final void a(Color var1) {
      this.c = var1;
   }

   public final Color e() {
      return this.d;
   }

   public final void b(Color var1) {
      this.d = var1;
   }

   public final Color f() {
      return this.e;
   }

   public final Color g() {
      return this.f;
   }

   public final int h() {
      return this.g;
   }

   public final void a(int var1) {
      if (var1 > 0) {
         this.g = var1;
         this.o();
      }

   }

   public final Color i() {
      return this.h;
   }

   public final void c(Color var1) {
      this.h = var1;
   }

   public final Color j() {
      return this.i;
   }

   public final Color k() {
      return this.j;
   }

   public final Stroke l() {
      return this.k;
   }

   private void o() {
      this.k = new BasicStroke((float)((double)this.g * a.k.b.a()), 1, 1);
   }

   public final int m() {
      return this.l;
   }

   public final void b(int var1) {
      if (var1 > 0) {
         this.l = var1;
      }

   }

   public final b.a.c n() {
      b.a.c var1;
      (var1 = new b.a.c()).b("abopt", "ViewOptions");
      var1.b("codeFont", c(this.a));
      var1.b("consoleFont", c(this.b));
      var1.b("backgroundColor", d(this.c));
      var1.b("fillingColor", d(this.d));
      var1.b("fillingColorRunning", d(this.e));
      var1.b("fillingColorSelected", d(this.f));
      int var4 = this.g;
      String var3 = "lineWidth";
      var1.b(var3, new Integer(var4));
      var1.b("lineColor", d(this.h));
      var1.b("lineColorRunning", d(this.i));
      var1.b("lineColorSelected", d(this.j));
      return var1;
   }

   public final void a(b.a.c var1) {
      if (var1.f("abopt").equals("ViewOptions")) {
         Font var3 = a(var1.b("codeFont"));
         this.a = var3;
         var3 = a(var1.b("consoleFont"));
         this.b = var3;
         Color var4 = b(var1.b("backgroundColor"));
         this.c = var4;
         var4 = b(var1.b("fillingColor"));
         this.d = var4;
         var4 = b(var1.b("fillingColorRunning"));
         this.e = var4;
         var4 = b(var1.b("fillingColorSelected"));
         this.f = var4;
         var4 = b(var1.b("lineColor"));
         this.h = var4;
         var4 = b(var1.b("lineColorRunning"));
         this.i = var4;
         var4 = b(var1.b("lineColorSelected"));
         this.j = var4;
         this.a(var1.a("lineWidth"));
      }

   }

   private static b.a.a c(Font var0) {
      b.a.a var1;
      (var1 = new b.a.a()).a(var0.getName());
      var1.e((int)((double)var0.getSize() * a.k.b.a()));
      var1.e(var0.getStyle());
      return var1;
   }

   private static b.a.a d(Color var0) {
      b.a.a var1;
      (var1 = new b.a.a()).e(var0.getRed());
      var1.e(var0.getGreen());
      var1.e(var0.getBlue());
      var1.e(var0.getAlpha());
      return var1;
   }

   private static Font a(b.a.a var0) {
      String var1 = (String)var0.a(0);
      int var2 = var0.b(1);
      int var3 = var0.b(2);
      return new Font(var1, var3, (int)((double)var2 * a.k.b.a()));
   }

   private static Color b(b.a.a var0) {
      int var1 = var0.b(0);
      int var2 = var0.b(1);
      int var3 = var0.b(2);
      int var4 = var0.b(3);
      return new Color(var1, var2, var3, var4);
   }
}
