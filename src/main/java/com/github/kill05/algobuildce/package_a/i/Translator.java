package com.github.kill05.algobuildce.package_a.i;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class Translator {
   private static ResourceBundle a = null;
   private static ResourceBundle b = null;
   private static ResourceBundle c = null;
   private static Locale locale;

   public static Locale getLocale() {
      if (locale == null) {
         locale = Locale.getDefault();
      }

      return locale;
   }

   public static void setLocale(Locale locale) {
      if (locale != null && !locale.equals(Translator.locale)) {
         Translator.locale = locale;
         if (c != null) {
            c = null;
         }
      }

   }

   public static String translate(String translationKey) {
      String var1;
      try {
         if (b == null) {
            (b = ResourceBundle.getBundle("AlgoBuildMsg", Locale.ENGLISH)).getString("mnuFileExit");
         }

         if (a == null) {
            (a = ResourceBundle.getBundle("AlgoBuildMsg", Locale.ITALIAN)).getString("mnuFileExit");
         }

         if (c == null) {
            if (getLocale().getLanguage().equals(Locale.ITALIAN.getLanguage())) {
               c = a;
            } else {
               c = b;
            }
         }

         var1 = c.getString(translationKey);
      } catch (MissingResourceException var2) {
         var1 = translationKey + " TO TRANSLATE";
         System.err.println(var1);
      } catch (NullPointerException var3) {
         var1 = "null given TO TRANSLATE";
      } catch (ClassCastException var4) {
         var1 = "improper type TO TRANSLATE";
      }

      return var1;
   }
}
