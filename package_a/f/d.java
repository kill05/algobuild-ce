package package_a.f;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import javax.swing.JOptionPane;

public final class d {
   private static char[] a = "0123456789ABCDEF".toCharArray();

   public static byte[] a(String var0, String var1) {
      return a("https://algobuild.com/abkg/ab0080keyusrget.php", var0, var1);
   }

   private static byte[] a(String var0, String var1, String var2) {
      var0 = var0 + "?srequiring=" + var1 + "&srequired=" + var2;
      byte[] var9 = null;
      StringBuilder var11 = new StringBuilder();
      InputStreamReader var3 = null;

      int var4;
      try {
         URLConnection var7;
         if ((var7 = (new URL(var0)).openConnection()) != null) {
            var7.setReadTimeout(60000);
         }

         if (var7 != null && var7.getInputStream() != null) {
            var3 = new InputStreamReader(var7.getInputStream(), Charset.defaultCharset());
            BufferedReader var8 = new BufferedReader(var3);

            while((var4 = var8.read()) != -1) {
               var11.append((char)var4);
            }

            var8.close();
         }

         var3.close();
      } catch (Exception var6) {
         throw new RuntimeException("Exception while calling URL:", var6);
      }

      if (var11.length() >= 2 && var11.charAt(0) == '0' && (var11.charAt(1) == 'x' || var11.charAt(1) == 'X')) {
         var9 = new byte[(var11.length() - 2) / 2];
         int var10 = 0;

         for(var4 = 2; var4 < var11.length(); var4 += 2) {
            String var12 = var11.substring(var4, var4 + 2);

            try {
               int var13 = Integer.parseInt(var12, 16);
               var9[var10] = (byte)var13;
               ++var10;
            } catch (NumberFormatException var5) {
            }
         }
      }

      return var9;
   }

   private static String a(String var0, String var1, int var2, String var3, String var4, byte[] var5) {
      String var6 = null;

      try {
         String var13 = "0x" + a(var5);
         URLConnection var10;
         if ((var10 = (new URL(var0)).openConnection()) != null) {
            var10.setReadTimeout(60000);
         }

         var10.setRequestProperty("Cookie", "abver=" + var1 + "; ser=" + var2 + "; des=" + var3 + "; sc=" + var4 + "; uk=" + var13 + ";");
         var10.connect();

         for(var2 = 1; (var1 = var10.getHeaderFieldKey(var2)) != null; ++var2) {
            if (var1.equals("Set-Cookie")) {
               var1 = var10.getHeaderField(var2);
               System.out.println(var1);
               if (var1.startsWith("cc=")) {
                  var6 = var1.substring(3, var1.indexOf(";"));
               }
            }
         }

         InputStream var12 = var10.getInputStream();

         while(true) {
            int var11;
            while((var11 = var12.read()) != -1) {
               if (var11 != 10 && (var11 < 32 || var11 >= 128)) {
                  System.out.println("[" + var11 + "]");
               } else {
                  System.out.print((char)var11);
               }
            }

            var12.close();
            if (var6 == null) {
               throw new i("Key Register - Null Result");
            }

            return var6;
         }
      } catch (UnknownHostException var7) {
         throw new i("Key Register", var7);
      } catch (MalformedURLException var8) {
         throw new i("Key Register", var8);
      } catch (IOException var9) {
         throw new i("Key Register", var9);
      }
   }

   private static String a(byte[] var0) {
      char[] var1 = new char[var0.length << 1];

      for(int var2 = 0; var2 < var0.length; ++var2) {
         int var3 = var0[var2] & 255;
         var1[var2 << 1] = a[var3 >>> 4];
         var1[(var2 << 1) + 1] = a[var3 & 15];
      }

      return new String(var1);
   }

   public static String b(String var0, String var1) {
      String var2 = "AB0080";
      int var3 = k.a().c();
      byte[] var4 = f.a().b();
      String var5 = null;

      try {
         if ((var5 = a("https://algobuild.com/abkg/ab0080keyusrreg.php", var2, var3, var0, var1, var4)) != null) {
            k.a().a(var0, var5);
         }
      } catch (i var6) {
         JOptionPane.showMessageDialog((Component)null, "IMPOSSIBILE REGISTRARE " + var0 + "   " + var1);
      }

      return var5;
   }
}
