package package_a.i;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class c {
   private static ResourceBundle a = null;
   private static ResourceBundle b = null;
   private static ResourceBundle c = null;
   private static Locale d;

   public static Locale a() {
      if (d == null) {
         d = Locale.getDefault();
      }

      return d;
   }

   public static void a(Locale var0) {
      if (var0 != null && !var0.equals(d)) {
         d = var0;
         if (c != null) {
            c = null;
         }
      }

   }

   public static String a(String var0) {
      String var1;
      try {
         if (b == null) {
            (b = ResourceBundle.getBundle("AlgoBuildMsg", Locale.ENGLISH)).getString("mnuFileExit");
         }

         if (a == null) {
            (a = ResourceBundle.getBundle("AlgoBuildMsg", Locale.ITALIAN)).getString("mnuFileExit");
         }

         if (c == null) {
            if (a().getLanguage().equals(Locale.ITALIAN.getLanguage())) {
               c = a;
            } else {
               c = b;
            }
         }

         var1 = c.getString(var0);
      } catch (MissingResourceException var2) {
         var1 = var0 + " TO TRANSLATE";
         System.err.println(var1);
      } catch (NullPointerException var3) {
         var1 = "null given TO TRANSLATE";
      } catch (ClassCastException var4) {
         var1 = "improper type TO TRANSLATE";
      }

      return var1;
   }
}
