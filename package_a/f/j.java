package package_a.f;

import java.io.File;

public final class j {
   private static int a = -1;
   private static String b = null;
   private static String c = null;
   private static String d = null;
   private static String e = null;
   private static String f = null;
   private static File g;
   private static File h;
   private static File i;
   private static File j;

   public static int a() {
      int var0 = 0;
      int var1 = 0;
      a = -1;
      if (-1 == -1) {
         a = 0;
         byte var2 = -1;
         File var3;
         if ((var3 = new File(e(), new String((new a.d.d()).b()))).exists()) {
            if (!var3.isDirectory() && var3.length() > 0L) {
               var2 = 1;
            }
         } else {
            var2 = 0;
         }

         switch(var2) {
         case -1:
            ++var1;
         case 0:
         default:
            break;
         case 1:
            ++var0;
         }

         var2 = -1;
         if ((var3 = new File(e(), new String((new a.d.e()).b()))).exists()) {
            if (!var3.isDirectory() && var3.length() > 0L) {
               var2 = 1;
            }
         } else {
            var2 = 0;
         }

         switch(var2) {
         case -1:
            ++var1;
         case 0:
         default:
            break;
         case 1:
            ++var0;
         }

         var2 = -1;
         if ((var3 = new File(e(), new String((new a.d.g()).b()))).exists()) {
            if (!var3.isDirectory() && var3.length() > 0L) {
               var2 = 1;
            }
         } else {
            var2 = 0;
         }

         switch(var2) {
         case -1:
            ++var1;
         case 0:
         default:
            break;
         case 1:
            ++var0;
         }

         var2 = -1;
         if ((var3 = new File(e(), new String((new a.d.b()).b()))).exists()) {
            if (!var3.isDirectory() && var3.length() > 0L) {
               var2 = 1;
            }
         } else {
            var2 = 0;
         }

         switch(var2) {
         case -1:
            ++var1;
         case 0:
         default:
            break;
         case 1:
            ++var0;
         }

         var2 = -1;
         if ((var3 = new File(e(), new String((new a.d.c()).b()))).exists()) {
            if (!var3.isDirectory() && var3.length() > 0L) {
               var2 = 1;
            }
         } else {
            var2 = 0;
         }

         switch(var2) {
         case -1:
            ++var1;
         case 0:
         default:
            break;
         case 1:
            ++var0;
         }

         if (var0 == 0 && var1 == 0) {
            a = 1;
         } else if (var0 == 5) {
            a = 0;
         } else {
            a = 2;
         }
      }

      return a;
   }

   private static String g() {
      if (f == null) {
         f = System.getProperties().getProperty(new String((new a.h.a()).b()));
      }

      return f;
   }

   public static String b() {
      if (e == null) {
         e = new String((new a.b.a()).b());
      }

      return e;
   }

   public static File c() {
      if (i == null) {
         File var10000;
         String var10002 = g();
         if (b == null) {
            b = new String((new a.b.d()).b());
         }

         var10000 = new File(var10002, b);
         i = var10000;
      }

      return i;
   }

   public static File d() {
      if (g == null) {
         File var10000;
         String var10002 = g();
         if (c == null) {
            c = new String((new a.b.b()).b());
         }

         var10000 = new File(var10002, c);
         g = var10000;
      }

      return g;
   }

   public static File e() {
      if (h == null) {
         File var10000;
         File var10002 = d();
         if (d == null) {
            d = new String((new a.b.c()).b());
         }

         var10000 = new File(var10002, d);
         h = var10000;
      }

      return h;
   }

   public static File f() {
      if (j == null) {
         j = new File(d(), b());
      }

      return j;
   }
}
