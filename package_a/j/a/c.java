package package_a.j.a;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Vector;
import javax.swing.JPanel;

public final class c extends JPanel {
   private a.c.a.b a;
   private Vector b;
   private int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private static Color[] j;

   public c(a.c.a.b var1) {
      (j = new Color[6])[0] = new Color(191, 255, 255);
      j[1] = new Color(255, 191, 255);
      j[2] = new Color(255, 255, 191);
      j[3] = new Color(255, 191, 191);
      j[4] = new Color(191, 255, 191);
      j[5] = new Color(191, 191, 255);
      this.b = new Vector(100);
      this.a = var1;
      this.e = 0;
      this.setBackground(Color.WHITE);
   }

   protected final void paintComponent(Graphics var1) {
      super.paintComponent(var1);
      FontMetrics var2 = this.getFontMetrics(this.getFont());
      int var3 = 0;
      int var4 = 0;

      for(int var5 = 0; var5 < this.b.size(); ++var5) {
         b var6;
         String var7 = (var6 = (b)this.b.get(var5)).a();
         Rectangle2D var8;
         if (!((var8 = var2.getStringBounds(var7, var1)).getWidth() < 5.0D)) {
            var8.getHeight();
         }

         int var9;
         int var10;
         if (!var6.d()) {
            var9 = 0;
            if (this.a.r().a()) {
               var10 = (int)(0.25D * (double)var2.getHeight());
               var9 = var6.b() * var2.getHeight();
               var1.setColor(j[var6.b() % j.length]);
               var1.fillRect(var9 - var10, var3, var10, var2.getHeight());
            }

            var1.setColor(Color.BLACK);
            var1.drawString(var7, var4 + var9, (int)((double)var3 - var8.getY()));
            var4 += (int)var8.getWidth();
            if (var6.c()) {
               var4 = 0;
            }

            if (var6.c() || this.a.r().a()) {
               var3 += (int)var8.getHeight();
            }
         } else if (this.a.r().a()) {
            var9 = (int)(0.25D * (double)var2.getHeight());
            var10 = var6.b() * var2.getHeight();
            var1.setColor(j[var6.b() % j.length]);
            var1.fillRect(var10 - var9, var3, var9, var2.getHeight());
            var1.fillRect(var10, var3, (int)var8.getWidth(), (int)var8.getHeight());
            if (var6.e()) {
               var1.setColor(Color.RED);
            } else {
               var1.setColor(Color.BLUE);
            }

            var1.drawString(var7, var10, (int)((double)var3 - var8.getY()));
            var3 += (int)var8.getHeight();
         }
      }

   }

   protected final void a() {
      Graphics var1 = this.getGraphics();
      FontMetrics var2 = this.getFontMetrics(this.getFont());
      int var3 = 0;
      int var4 = 0;
      int var5 = 10;
      this.d = this.c = this.g = this.f = 0;

      for(int var6 = 0; var6 < this.b.size(); ++var6) {
         b var7;
         String var10 = (var7 = (b)this.b.get(var6)).a();
         Rectangle2D var8;
         var5 = (int)(var8 = var2.getStringBounds(var10, var1)).getHeight();
         int var9;
         if (!var7.d()) {
            var9 = var7.b() * var2.getHeight();
            if ((var4 += (int)var8.getWidth()) > this.d) {
               this.d = var4;
            }

            if (var4 + var9 > this.g) {
               this.g = var4 + var9;
            }

            this.c = (int)var8.getHeight() + var3;
            if (var7.c()) {
               var4 = 0;
            }

            if (var7.c()) {
               var3 += (int)var8.getHeight();
            }
         } else if ((var9 = var7.b() * var2.getHeight()) + (int)var8.getWidth() > this.g) {
            this.g = var9 + (int)var8.getWidth();
         }
      }

      this.f = this.b.size() * var5;
      this.revalidate();
      this.repaint();
   }

   public final void a(String var1, boolean var2, boolean var3, boolean var4) {
      if (var3) {
         var1 = var1.replaceAll("\\\\n", "");
         var2 = false;
      }

      String[] var12 = var1.split("\\\\n");
      FontMetrics var5 = this.getFontMetrics(this.getFont());
      int var6 = this.e * var5.getHeight();
      Graphics var7 = this.getGraphics();
      Rectangle2D var8 = null;
      int var9 = 0;

      for(int var10 = 0; var10 < var12.length; ++var10) {
         boolean var11 = var2 || var10 < var12.length - 1;
         if (var12[var10].length() > 0 || var11) {
            ++var9;
            b var13 = new b(var12[var10], this.e, var11, var3, var4);
            this.b.add(var13);
            var8 = var5.getStringBounds(var12[var10], var7);
            if (!var3) {
               if (var11) {
                  this.h = 0;
                  this.i += (int)var8.getHeight();
               } else {
                  this.h += (int)var8.getWidth();
               }

               if ((double)this.h + var8.getWidth() > (double)this.d) {
                  this.d = this.h + (int)var8.getWidth();
               }

               this.c = this.i + (int)var8.getHeight();
            }

            if ((double)(var6 + this.h) + var8.getWidth() > (double)this.g) {
               this.g = var6 + this.h + (int)var8.getWidth();
            }
         }
      }

      if (var9 > 0) {
         this.f = this.b.size() * (int)var8.getHeight();
         this.revalidate();
         if (var8 != null) {
            if (!this.a.r().a()) {
               this.scrollRectToVisible(new Rectangle(this.h, this.i, (int)var8.getWidth(), (int)var8.getHeight()));
            } else {
               this.scrollRectToVisible(new Rectangle(var6 + this.h, this.f - (int)var8.getHeight(), (int)var8.getWidth(), (int)var8.getHeight()));
            }
         }

         this.repaint();
      }

   }

   public final void a(int var1) {
      if (var1 >= 0 && var1 <= 100) {
         this.e = var1;
      }

   }

   public final void b() {
      this.b.removeAllElements();
      this.d = this.c = 0;
      this.h = this.i = 0;
      this.e = 0;
      Dimension var1 = new Dimension(this.d, this.c);
      this.setPreferredSize(var1);
      this.setMinimumSize(var1);
      this.revalidate();
      this.repaint();
   }

   public final Dimension getPreferredSize() {
      Dimension var1;
      if (!this.a.r().a()) {
         var1 = new Dimension(this.d, this.c);
      } else {
         var1 = new Dimension(this.g, this.f);
      }

      return var1;
   }
}
