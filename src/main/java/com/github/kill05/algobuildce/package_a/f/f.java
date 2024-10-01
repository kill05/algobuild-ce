package com.github.kill05.algobuildce.package_a.f;

import com.github.kill05.algobuildce.package_a.i.Translator;
import com.github.kill05.algobuildce.json.JSONObject;
import com.github.kill05.algobuildce.json.g;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class f implements Runnable {
   private static f a = null;
   private c b = null;
   private c c = null;

   public static f a() {
      if (a == null) {
         a = new f();
      }

      return a;
   }

   private f() {
      (new Thread(this)).start();
   }

   @Override
   public final void run() {
      System.currentTimeMillis();
      File var1 = new File(j.e(), new String((new com.github.kill05.algobuildce.package_a.d.e()).b()));
      File var2 = new File(j.e(), new String((new com.github.kill05.algobuildce.package_a.d.d()).b()));
      c var3 = new c(var1, 1);
      this.c = var3;
      var3 = new c(var2, 0);
      this.b = var3;
      System.currentTimeMillis();
   }

   public final void a(String var1, JSONObject var2) {
      k var3;
      if ((var3 = k.a()) == null) {
         throw new h(Translator.translate("abpErrorConfigFile") + " system configuration NON LOADED");
      } else if (var1 == null) {
         throw new h(Translator.translate("abpErrorWritingFile") + " file name is NULL");
      } else if (this.b == null) {
         throw new h(Translator.translate("abpErrorWritingFile") + " ENCODER not READY");
      } else {
         JSONObject var4;
         (var4 = new JSONObject()).b("abuid", var3.e().toString());
         String var5;
         if ((var5 = var3.b()) != null) {
            var4.b("abusn", var5);
         }

         String var11;
         if ((var11 = var3.d()) != null) {
            var4.b("abuan", var11);
         }

         byte[] var12 = a(var4);
         byte[] var10 = a(var2);

         try {
            b var8 = new b(var1);
            ZipOutputStream var9 = new ZipOutputStream(new BufferedOutputStream(var8));
            String var13 = "fd";
            ZipEntry var15 = new ZipEntry(var13);
            var9.putNextEntry(var15);
            var9.write(var12);
            var9.flush();
            var11 = "fc";
            ZipEntry var14 = new ZipEntry(var11);
            var9.putNextEntry(var14);
            var10 = this.b.a(var10);
            var9.write(var10, 0, var10.length);
            var9.flush();
            var9.close();
         } catch (FileNotFoundException var6) {
            var6.printStackTrace();
         } catch (IOException var7) {
            var7.printStackTrace();
         }
      }
   }

   public final JSONObject a(String var1) {
      JSONObject var2 = null;
      if (var1 == null) {
         throw new h(Translator.translate("abpErrorReadingFile") + " NULL");
      } else if (this.c == null) {
         throw new h(Translator.translate("abpErrorReadingFile") + " DECODER not READY");
      } else {
         try {
            a var3 = new a(var1);
            ZipInputStream var14 = new ZipInputStream(new BufferedInputStream(var3));
            byte[] var5 = new byte['썐'];
            int var6 = 0;
            String var7 = null;

            while(true) {
               while(true) {
                  ZipEntry var4;
                  do {
                     if ((var4 = var14.getNextEntry()) == null) {
                        var14.close();
                        return var2;
                     }

                     if (var4.getName().equals("fd")) {
                        InputStreamReader var8 = new InputStreamReader(var14);
                        com.github.kill05.algobuildce.json.f var9 = new com.github.kill05.algobuildce.json.f(var8);
                        JSONObject var15;
                        String var18 = (var15 = new JSONObject(var9)).a("abuid", (String)null);
                        String var10 = var15.a("abuan", (String)null);
                        if ((var7 = var15.a("abusn", (String)null)) != null) {
                           var6 = k.a(var7);
                        }

                        if (var18 == null) {
                           throw new h(Translator.translate("abpErrorReadingFile") + " ID not present");
                        }

                        UUID var16 = UUID.fromString(var18);
                        if (!k.a().e().equals(var16) && var10 == null) {
                           throw new h(Translator.translate("abpCannotReadOtherUserPrivateFile"));
                        }
                     }
                  } while(!var4.getName().equals("fc"));

                  int var20 = 0;

                  int var17;
                  do {
                     if ((var17 = var14.read(var5, var20, '썐' - var20)) > 0) {
                        var20 += var17;
                     }
                  } while(var17 > 0);

                  var5 = Arrays.copyOf(var5, var20);
                  byte[] var19;
                  if (var6 > 0 && var6 != k.a().c()) {
                     j.b();
                     c var24;
                     var19 = (var24 = new c(j.f(), 2, var7)).a(var5);
                     ByteArrayInputStream var22 = new ByteArrayInputStream(var19, 0, var24.b());
                     InputStreamReader var26 = new InputStreamReader(var22, StandardCharsets.UTF_8);
                     com.github.kill05.algobuildce.json.f var13 = new com.github.kill05.algobuildce.json.f(var26);
                     var2 = new JSONObject(var13);
                  } else {
                     var19 = this.c.a(var5);
                     ByteArrayInputStream var25 = new ByteArrayInputStream(var19, 0, this.c.b());
                     InputStreamReader var23 = new InputStreamReader(var25, StandardCharsets.UTF_8);
                     com.github.kill05.algobuildce.json.f var21 = new com.github.kill05.algobuildce.json.f(var23);
                     var2 = new JSONObject(var21);
                  }
               }
            }
         } catch (h var11) {
            throw var11;
         } catch (Exception var12) {
            throw new h(Translator.translate("abpErrorReadingFile") + var1);
         }
      }
   }

   private static byte[] a(JSONObject var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream(1000);

      try {
         OutputStreamWriter var2 = new OutputStreamWriter(var1, "UTF-8");
         g var3;
         (var3 = new g(var2)).b();
         Iterator var5 = var0.keySet().iterator();

         while(var5.hasNext()) {
            String var4 = (String)var5.next();
            var3.a(var4);
            var3.a(var0.c(var4));
         }

         var3.a();
         var2.flush();
         byte[] var8 = var1.toByteArray();
         return var8;
      } catch (UnsupportedEncodingException var6) {
         throw new h(Translator.translate("abpErrorWritingFile"), var6);
      } catch (IOException var7) {
         throw new h(Translator.translate("abpErrorWritingFile"));
      }
   }

   public final byte[] b() {
      return this.c.a();
   }
}
