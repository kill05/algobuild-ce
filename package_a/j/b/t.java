package package_a.j.b;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

public final class t extends package_a.j.b.c {
   public t(p var1, D var2) {
      super(var2);
   }

   public final void a(n var1, Graphics var2) {
   }

   public final void a(n var1) {
      e var6 = (e)var1;
      Dimension var2 = new Dimension(2 * var6.e, 0 * var6.f);
      Component[] var3 = var6.getComponents();

      int var4;
      for(var4 = 0; var4 < var3.length; ++var4) {
         if (var3[var4] instanceof n) {
            ((n)var3[var4]).g();
         }

         Dimension var5;
         if ((var5 = var3[var4].getMinimumSize()).width > var2.width) {
            var2.width = var5.width;
         }

         var2.height += var5.height;
      }

      var6.a(var2);
      var4 = 0;

      for(int var8 = 0; var8 < var3.length; ++var8) {
         Dimension var7 = var3[var8].getMinimumSize();
         var3[var8].setLocation(0, var4);
         var4 = (int)((double)var4 + var7.getHeight());
      }

   }
}
