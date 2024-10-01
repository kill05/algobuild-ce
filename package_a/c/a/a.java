package package_a.c.a;

import package_a.c.b.p;
import package_a.c.b.q;
import package_a.f.l;
import package_a.i.Translator;
import package_a.k.Runnable_B;

import java.awt.Component;
import java.awt.Toolkit;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;

public class a {
   private Map a = null;

   public a() {
      this.a = new TreeMap();
   }

   final q a(String var1, int var2) {
      q var3 = new q(var1, var2);
      this.a.put(var3.j(), var3);
      return var3;
   }

   final q a(q var1) {
      this.a.put(var1.j(), var1);
      return var1;
   }

   final q a(String var1) {
      return (q)this.a.get(var1);
   }

   final void b(String var1) {
      this.a.remove(var1);
   }

   final void c(String var1) {
      q var2 = (q)this.a.remove(var1);
      this.a.put(var2.j(), var2);
   }

   public final Collection a() {
      return this.a.values();
   }

   public final void b() {
      if (this.a != null) {
         this.a.clear();
      }

   }

   public final int c() {
      return this.a != null ? this.a.size() : 0;
   }

   public final p d() {
      p var1 = new p();
      Iterator var3 = this.a.values().iterator();

      while(var3.hasNext()) {
         q var2 = (q)var3.next();
         var1.a(var2.i());
      }

      return var1;
   }

   public static void a(String[] var0) {
      try {
         UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
               UnsupportedLookAndFeelException var6) {
         var6.printStackTrace();
      }

       double var1 = 0.0D;

      int var3;
      for(var3 = 0; var3 < var0.length; ++var3) {
         if (var0[var3].toLowerCase().startsWith("fontzoom=")) {
            String var4 = var0[var3].substring(9);

            try {
               if (var4.endsWith("%")) {
                  System.out.println("ZOOM %: " + var4);
                  var1 = Double.parseDouble(var4.substring(0, var4.length() - 1)) / 100.0D;
               } else {
                  System.out.println("ZOOM FACTOR: " + var4);
                  var1 = Double.parseDouble(var4);
               }

               System.out.println("FONT ZOOM " + var1);
               a(var1);
               package_a.k.b.a(var1);
            } catch (NumberFormatException var5) {
               System.out.println("INVALID NUMBER FORMAT: " + var4);
            }
         }
      }

      if (var1 == 0.0D && (var1 = e()) != 0.0D && var1 != 1.0D) {
         package_a.k.b.a(var1);
      }

      int var11 = 0;

      do {
         ++var11;
         if ((var3 = package_a.f.j.a()) != 0) {
            String var10;
            if (var3 == 1) {
               var10 = Translator.translate("abpFirstRunQuestion");
               if (JOptionPane.showConfirmDialog((Component)null, var10, "AlgoBuild", 0, 3) == 0) {
                  l.a();
                  var3 = -1;
               } else {
                  System.exit(var3);
               }
            }

            if (var3 == 2) {
               var10 = Translator.translate("abpConfigurationWrong");
               JOptionPane.showMessageDialog((Component)null, var10, "AlgoBuild", 0);
               System.exit(var3);
            }
         } else {
            SwingUtilities.invokeLater(new Runnable_B());
         }
      } while(var3 == -1 && var11 < 2);

   }

   public static void a(double var0) {
      if (var0 < 0.1D || var0 > 10.0D) {
         System.out.println("INVALID ZOOM RATIO: " + var0);
      }

      UIDefaults var2;
      Enumeration var3 = (var2 = UIManager.getLookAndFeelDefaults()).keys();

      while(var3.hasMoreElements()) {
         Object var4 = var3.nextElement();
         Object var5;
         if ((var5 = var2.get(var4)) instanceof FontUIResource) {
            FontUIResource var6 = (FontUIResource)var5;
            var6 = new FontUIResource(var6.getName(), var6.getStyle(), (int)((double)var6.getSize() * var0));
            var2.put(var4, var6);
         }
      }

   }

   public static double e() {
      double var0 = 1.0D;
      double var3 = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
      int var2 = Toolkit.getDefaultToolkit().getScreenResolution();
      System.out.println("SCREEN HEIGHT = " + var3);
      System.out.println("SCREEN RESOLUTION dpi = " + var2);
      UIDefaults var5;
      Object var6;
      if ((var6 = (var5 = UIManager.getLookAndFeelDefaults()).get("Panel.font")) != null) {
         FontUIResource var12 = (FontUIResource)var6;
         double var9;
         if ((var9 = 25.4D / (double)var2 * (double)var12.getSize()) < 3.0D) {
            System.out.println("ACTUAL ROW SIZE (mm) " + var9);
            var0 = var3 / 64.0D / (double)var12.getSize();
            System.out.println("HIGH RESOLUTION DISPLAY - APPLY ZOOM FACTOR: " + var0);
         }
      }

      if (var0 != 1.0D) {
         Enumeration var13 = var5.keys();

         while(var13.hasMoreElements()) {
            Object var14 = var13.nextElement();
            Object var10;
            if ((var10 = var5.get(var14)) instanceof FontUIResource) {
               FontUIResource var11 = (FontUIResource)var10;
               var11 = new FontUIResource(var11.getName(), var11.getStyle(), (int)((double)var11.getSize() * var0));
               var5.put(var14, var11);
            }
         }
      }

      return var0;
   }

   public static JButton d(String var0) {
      char var1 = 0;
      if (var0.contains("&&")) {
         int var2;
         if ((var2 = var0.indexOf("&&")) + 2 < var0.length()) {
            var1 = var0.charAt(var2 + 2);
         }

         var0 = var0.replace("&&", "");
      }

      JButton var3 = new JButton(var0);
      if (var1 != 0) {
         var3.setMnemonic(var1);
      }

      return var3;
   }
}
