package package_a.f;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.UUID;

public final class k {
   private static k a = null;
   private char[] b;
   private String c = null;
   private int d = 0;
   private UUID e;
   private UUID f;
   private String g = null;
   private String h = "https://algobuild.com/abkg/ab0080keygen.php";

   public static k a() {
      if (a == null) {
         a = new k();
      }

      return a;
   }

   private k() {
      k var1 = this;
      File var2 = new File(j.e(), new String((new a.d.g()).b()));

      try {
         DataInputStream var21;
         byte var3 = (var21 = new DataInputStream(new FileInputStream(var2))).readByte();
         byte var4 = var21.readByte();
         byte var5 = var21.readByte();
         byte var6 = var21.readByte();
         long var12 = var21.readLong();
         long var14 = var21.readLong();
         var1.e = new UUID(var12, var14);
         var12 = var21.readLong();
         var14 = var21.readLong();
         var1.f = new UUID(var12, var14);
         UUID var22 = UUID.nameUUIDFromBytes(System.getProperties().getProperty(new String((new a.h.b()).b())).getBytes("UTF-8"));
         if (var3 != -85) {
            throw new e(Translator.translate("abpErrorConfigFile") + " b1 " + var3);
         }

         if (var4 != -49) {
            throw new e(Translator.translate("abpErrorConfigFile") + " b2 " + var4);
         }

         if (var5 != 1) {
            throw new e(Translator.translate("abpErrorConfigFile") + " b3 " + var5);
         }

         if (var6 != 3) {
            throw new e(Translator.translate("abpErrorConfigFile") + " b4 " + var6);
         }

         if (!var1.f.equals(var22)) {
            throw new e(Translator.translate("abpErrorConfigFile") + " UUID2");
         }
      } catch (FileNotFoundException var18) {
         var18.printStackTrace();
      } catch (IOException var19) {
         var19.printStackTrace();
      }

      this.g();
      String var20 = System.getProperties().getProperty(new String((new a.h.b()).b()));
      this.b = new char[var20.length()];

      int var23;
      for(var23 = 0; var23 < var20.length(); ++var23) {
         this.b[var23] = var20.charAt(var23);
      }

      var23 = this.h();
      var20 = this.b("AB0080");
      if (var23 <= 0 && var20 == null) {
         try {
            this.d(this.h, "AB0080");
         } catch (h var17) {
         }
      }

      if (var23 > 0 && var20 == null) {
         try {
            if ((var20 = a(this.h, var23, "AB0080")) != null) {
               this.c(var20, "AB0080");
            } else {
               var20 = a(var23, "AB0080");
            }
         } catch (h var16) {
            var16.printStackTrace();
         }
      }

      if (var23 <= 0 && var20 != null) {
         var23 = a(var20);
         this.a(var23);
      }

      if (this.c == null) {
         this.c = var20;
      }

      if (this.d == 0) {
         this.d = var23;
      }

   }

   private void g() {
      File var1 = new File(j.e(), new String((new a.d.a()).b()));

      try {
         DataInputStream var13;
         byte var2 = (var13 = new DataInputStream(new FileInputStream(var1))).readByte();
         byte var3 = var13.readByte();
         byte var4 = var13.readByte();
         byte var5 = var13.readByte();
         long var7 = var13.readLong();
         long var9 = var13.readLong();
         this.e = new UUID(var7, var9);
         var7 = var13.readLong();
         var9 = var13.readLong();
         this.f = new UUID(var7, var9);
         UUID var6 = UUID.nameUUIDFromBytes(System.getProperties().getProperty(new String((new a.h.b()).b())).getBytes("UTF-8"));
         if (var2 != -85) {
            throw new e(Translator.translate("abpErrorConfigFile") + " b1 " + var2);
         }

         if (var3 != -49) {
            throw new e(Translator.translate("abpErrorConfigFile") + " b2 " + var3);
         }

         if (var4 != 1) {
            throw new e(Translator.translate("abpErrorConfigFile") + " b3 " + var4);
         }

         if (var5 != 4) {
            throw new e(Translator.translate("abpErrorConfigFile") + " b4 " + var5);
         }

         if (!this.f.equals(var6)) {
            throw new e(Translator.translate("abpErrorConfigFile") + " UUID2");
         }

         int var14;
         if ((var14 = var13.readInt()) > 0) {
            byte[] var15 = new byte[var14];

            int var17;
            for(var17 = 0; var17 < var14; ++var17) {
               int var18 = var13.readInt() + 2 * var17 - 143;
               var15[var17] = (byte)var18;
            }

            this.g = new String(var15, "UTF-8");
            if ((var17 = var13.readInt()) > 0) {
               byte[] var19 = new byte[var17];

               for(var14 = 0; var14 < var17; ++var14) {
                  int var16 = var13.readInt() + 2 * var14 - 143;
                  var19[var14] = (byte)var16;
               }

               new String(var19, "UTF-8");
               return;
            }
         }
      } catch (FileNotFoundException var11) {
         return;
      } catch (IOException var12) {
      }

   }

   public final void a(String var1, String var2) {
      if (this.b(var1, var2)) {
         this.g = var1;
      }

   }

   private boolean b(String var1, String var2) {
      boolean var3 = false;
      File var4 = new File(j.e(), new String((new a.d.a()).b()));

      try {
         DataOutputStream var9;
         (var9 = new DataOutputStream(new FileOutputStream(var4))).write(171);
         var9.write(207);
         var9.write(1);
         var9.write(4);
         var9.writeLong(this.e.getMostSignificantBits());
         var9.writeLong(this.e.getLeastSignificantBits());
         var9.writeLong(this.f.getMostSignificantBits());
         var9.writeLong(this.f.getLeastSignificantBits());
         byte[] var8 = var1.getBytes("UTF-8");
         var9.writeInt(var8.length);

         int var5;
         for(var5 = 0; var5 < var8.length; ++var5) {
            var9.writeInt(var8[var5] + 143 - 2 * var5);
         }

         var8 = var2.getBytes("UTF-8");
         var9.writeInt(var8.length);

         for(var5 = 0; var5 < var8.length; ++var5) {
            var9.writeInt(var8[var5] + 143 - 2 * var5);
         }

         for(var5 = 0; var5 < 123; ++var5) {
            var9.write((byte)((int)(Math.random() * 256.0D)));
         }

         var9.close();
         var3 = true;
      } catch (FileNotFoundException var6) {
         var6.printStackTrace();
      } catch (IOException var7) {
         var7.printStackTrace();
      }

      return var3;
   }

   private boolean a(int var1) {
      boolean var2 = false;
      File var3 = new File(j.e(), new String((new a.d.f()).b()));

      try {
         DataOutputStream var7;
         (var7 = new DataOutputStream(new FileOutputStream(var3))).write(171);
         var7.write(207);
         var7.write(1);
         var7.write(5);
         var7.writeLong(this.e.getMostSignificantBits());
         var7.writeLong(this.e.getLeastSignificantBits());
         var7.writeLong(this.f.getMostSignificantBits());
         var7.writeLong(this.f.getLeastSignificantBits());

         int var4;
         for(var4 = 0; var4 < 7; ++var4) {
            var7.writeInt((int)(Math.random() * 2.147483647E9D));
         }

         var7.writeInt(var1);

         for(var4 = 0; var4 < 11; ++var4) {
            var7.writeInt((int)(Math.random() * 2.147483647E9D));
         }

         var7.close();
         var2 = true;
      } catch (FileNotFoundException var5) {
         var5.printStackTrace();
      } catch (IOException var6) {
         var6.printStackTrace();
      }

      return var2;
   }

   private int h() {
      File var1 = new File(j.e(), new String((new a.d.f()).b()));
      int var2 = 0;

      try {
         DataInputStream var14;
         byte var3 = (var14 = new DataInputStream(new FileInputStream(var1))).readByte();
         byte var4 = var14.readByte();
         byte var5 = var14.readByte();
         byte var6 = var14.readByte();
         long var8 = var14.readLong();
         long var10 = var14.readLong();
         this.e = new UUID(var8, var10);
         var8 = var14.readLong();
         var10 = var14.readLong();
         this.f = new UUID(var8, var10);
         UUID var7 = UUID.nameUUIDFromBytes(System.getProperties().getProperty(new String((new a.h.b()).b())).getBytes("UTF-8"));
         if (var3 != -85) {
            throw new e(Translator.translate("abpErrorConfigFile") + " b1 " + var3);
         }

         if (var4 != -49) {
            throw new e(Translator.translate("abpErrorConfigFile") + " b2 " + var4);
         }

         if (var5 != 1) {
            throw new e(Translator.translate("abpErrorConfigFile") + " b3 " + var5);
         }

         if (var6 != 5) {
            throw new e(Translator.translate("abpErrorConfigFile") + " b4 " + var6);
         }

         if (!this.f.equals(var7)) {
            throw new e(Translator.translate("abpErrorConfigFile") + " UUID2");
         }

         int var15;
         for(var15 = 0; var15 < 7; ++var15) {
            var14.readInt();
         }

         var2 = var14.readInt();

         for(var15 = 0; var15 < 11; ++var15) {
            var14.readInt();
         }
      } catch (FileNotFoundException var12) {
      } catch (IOException var13) {
      }

      return var2;
   }

   public final String b() {
      return this.c;
   }

   public final int c() {
      return this.d;
   }

   public final String d() {
      return this.g;
   }

   public final UUID e() {
      return this.e;
   }

   public final UUID f() {
      return this.f;
   }

   private static String a(String var0, int var1, String var2) {
      String var3 = null;
      String var4 = null;
      var4 = null;
      int var5 = -1;
      int var6 = -1;
      long var7 = -1L;
      boolean var9 = false;

      try {
         var9 = InetAddress.getByName((new URL(var0)).getHost()).isReachable(10000);
      } catch (MalformedURLException var14) {
      } catch (UnknownHostException var15) {
      } catch (IOException var16) {
      }

      if (var9) {
         System.out.println("REACHABLE   ");

         try {
            URLConnection var21;
            (var21 = (new URL(var0)).openConnection()).setReadTimeout(10000);
            var21.setRequestProperty("Cookie", "abver=" + var2 + "; pass=1");
            var21.connect();

            int var10;
            String var11;
            String var12;
            for(var10 = 1; (var11 = var21.getHeaderFieldKey(var10)) != null; ++var10) {
               if (var11.equals("Set-Cookie")) {
                  if ((var12 = var21.getHeaderField(var10)).startsWith("PHPSESSID=")) {
                     var4 = var12.substring(10, var12.indexOf(";"));
                  }

                  if (var12.startsWith("x=")) {
                     var5 = Integer.parseInt(var12.substring(2, var12.indexOf(";")));
                  }

                  if (var12.startsWith("y=")) {
                     var6 = Integer.parseInt(var12.substring(2, var12.indexOf(";")));
                  }

                  if (var12.startsWith("k=")) {
                     var7 = (long)Integer.parseInt(var12.substring(2, var12.indexOf(";")));
                  }
               }
            }

            InputStream var22 = var21.getInputStream();

            while(true) {
               int var25;
               while((var25 = var22.read()) != -1) {
                  if (var25 != 10 && (var25 < 32 || var25 >= 128)) {
                     System.out.println("[" + var25 + "]");
                  } else {
                     System.out.print((char)var25);
                  }
               }

               var22.close();
               var10 = var5 + var6 * 10000 ^ 51627384;
               if (var5 > 0 && var6 > 0 && var7 == -1L && var4 != null) {
                  URLConnection var23 = (new URL(var0)).openConnection();
                  String var24 = "PHPSESSID=" + var4 + "; abver=" + var2 + "; abexistingserialnum=" + var1 + "; pass=4; k=" + var10 + ";";
                  var23.setRequestProperty("Cookie", var24);
                  var23.connect();

                  for(int var13 = 1; (var12 = var23.getHeaderFieldKey(var13)) != null; ++var13) {
                     if (var12.equals("Set-Cookie")) {
                        if ((var0 = var23.getHeaderField(var13)).startsWith("PHPSESSID=")) {
                           var0.substring(10, var0.indexOf(";"));
                        }

                        if (var0.startsWith("x=")) {
                           Integer.parseInt(var0.substring(2, var0.indexOf(";")));
                        }

                        if (var0.startsWith("y=")) {
                           Integer.parseInt(var0.substring(2, var0.indexOf(";")));
                        }

                        if (var0.startsWith("kk=") && var0.indexOf(";") > 3) {
                           var3 = var0.substring(3, var0.indexOf(";"));
                        }
                     }
                  }

                  InputStream var26 = var23.getInputStream();

                  while(true) {
                     int var20;
                     while((var20 = var26.read()) != -1) {
                        if (var20 != 10 && (var20 < 32 || var20 >= 128)) {
                           System.out.print('.');
                        } else {
                           System.out.print((char)var20);
                        }
                     }

                     var26.close();
                     return var3;
                  }
               }
               break;
            }
         } catch (MalformedURLException var17) {
            throw new h(Translator.translate("abpErrorConfigFile"), var17);
         } catch (ConnectException var18) {
         } catch (IOException var19) {
            throw new h(Translator.translate("abpErrorConfigFile"), var19);
         }
      }

      return var3;
   }

   private void c(String var1, String var2) {
      File var3;
      if ((var3 = j.d()).exists()) {
         try {
            File var9 = new File(var3, var2 + ".sn");
            PrintStream var10;
            if (!(var10 = new PrintStream(var9)).checkError() && var1 != null) {
               long var6 = 0L;

               int var11;
               for(var11 = 0; var11 < this.b.length; ++var11) {
                  var6 += (long)this.b[var11];
               }

               for(var11 = 0; var11 < var1.length(); ++var11) {
                  var6 += (long)var1.charAt(var11);
               }

               var10.print(var1);
               var10.print(' ');
               var10.println(var6);
            }

            var10.close();
         } catch (FileNotFoundException var8) {
            throw new h(Translator.translate("abpErrorConfigFile"), var8);
         }
      }
   }

   private void d(String var1, String var2) {
      File var3;
      if ((var3 = j.d()).exists()) {
         try {
            var3 = new File(var3, var2 + ".sn");
            PrintStream var11;
            if (!(var11 = new PrintStream(var3)).checkError() && (var1 = e(var1, var2)) != null) {
               long var7 = 0L;

               int var10;
               for(var10 = 0; var10 < this.b.length; ++var10) {
                  var7 += (long)this.b[var10];
               }

               for(var10 = 0; var10 < var1.length(); ++var10) {
                  var7 += (long)var1.charAt(var10);
               }

               var11.print(var1);
               var11.print(' ');
               var11.println(var7);
               this.c = var1;
               this.d = a(var1);
               this.a(this.d);
            }

            var11.close();
         } catch (FileNotFoundException var9) {
            throw new h(Translator.translate("abpErrorConfigFile"), var9);
         }
      }
   }

   private static String e(String var0, String var1) {
      String var2 = null;
      String var3 = null;
      int var4 = -1;
      int var5 = -1;
      long var6 = -1L;

      try {
         URLConnection var9;
         (var9 = (new URL(var0)).openConnection()).setRequestProperty("Cookie", "abver=" + var1 + "; pass=1");
         var9.connect();

         int var8;
         String var10;
         for(var8 = 1; (var10 = var9.getHeaderFieldKey(var8)) != null; ++var8) {
            if (var10.equals("Set-Cookie")) {
               String var11;
               if ((var11 = var9.getHeaderField(var8)).startsWith("PHPSESSID=")) {
                  var3 = var11.substring(10, var11.indexOf(";"));
               }

               if (var11.startsWith("x=")) {
                  var4 = Integer.parseInt(var11.substring(2, var11.indexOf(";")));
               }

               if (var11.startsWith("y=")) {
                  var5 = Integer.parseInt(var11.substring(2, var11.indexOf(";")));
               }

               if (var11.startsWith("k=")) {
                  var6 = (long)Integer.parseInt(var11.substring(2, var11.indexOf(";")));
               }
            }
         }

         InputStream var15 = var9.getInputStream();

         while(true) {
            int var18;
            while((var18 = var15.read()) != -1) {
               if (var18 != 10 && (var18 < 32 || var18 >= 128)) {
                  System.out.print('.');
               } else {
                  System.out.print((char)var18);
               }
            }

            var15.close();
            var8 = var4 + var5 * 10000 ^ 51627384;
            if (var4 > 0 && var5 > 0 && var6 == -1L && var3 != null) {
               URLConnection var17;
               (var17 = (new URL(var0)).openConnection()).setRequestProperty("Cookie", "PHPSESSID=" + var3 + "; abver=" + var1 + "; pass=2; k=" + var8 + ";");
               var17.connect();

               String var16;
               for(var18 = 1; (var16 = var17.getHeaderFieldKey(var18)) != null; ++var18) {
                  if (var16.equals("Set-Cookie")) {
                     String var12;
                     if ((var12 = var17.getHeaderField(var18)).startsWith("PHPSESSID=")) {
                        var12.substring(10, var12.indexOf(";"));
                     }

                     if (var12.startsWith("x=")) {
                        Integer.parseInt(var12.substring(2, var12.indexOf(";")));
                     }

                     if (var12.startsWith("y=")) {
                        Integer.parseInt(var12.substring(2, var12.indexOf(";")));
                     }

                     if (var12.startsWith("k=") && var12.indexOf(";") > 2) {
                        var2 = var12.substring(2, var12.indexOf(";"));
                     }
                  }
               }

               InputStream var19 = var17.getInputStream();

               while(true) {
                  int var20;
                  while((var20 = var19.read()) != -1) {
                     if (var20 != 10 && (var20 < 32 || var20 >= 128)) {
                        System.out.print('.');
                     } else {
                        System.out.print((char)var20);
                     }
                  }

                  var19.close();
                  break;
               }
            }

            return var2;
         }
      } catch (MalformedURLException var13) {
         throw new h(Translator.translate("abpErrorConfigFile"), var13);
      } catch (IOException var14) {
         throw new h(Translator.translate("abpErrorConfigFile"), var14);
      }
   }

   private String b(String var1) {
      String var2 = null;
      File var15 = new File(j.d(), var1 + ".sn");

      try {
         FileInputStream var16 = new FileInputStream(var15);
         Scanner var3;
         String var4 = (var3 = new Scanner(var16)).next();
         long var7 = 0L;

         int var9;
         for(var9 = 0; var9 < this.b.length; ++var9) {
            var7 += (long)this.b[var9];
         }

         for(var9 = 0; var9 < var4.length(); ++var9) {
            var7 += (long)var4.charAt(var9);
         }

         long var14 = var3.nextLong();
         var3.close();
         var16.close();
         if (var7 != var14) {
            throw new h(Translator.translate("abpErrorConfigFile"));
         }

         var2 = var4;
      } catch (FileNotFoundException var11) {
      } catch (IOException var12) {
         var12.printStackTrace();
      } catch (Exception var13) {
      }

      return var2;
   }

   public static int a(String var0) {
      int var1 = 0;
      boolean var2 = false;

      for(int var3 = var0.length() - 1; var3 >= 0 && !var2; --var3) {
         char var4;
         if ((var4 = var0.charAt(var3)) >= 'F' && var4 <= 'O') {
            var1 = var1 * 10 + var4 - 70;
         } else {
            var2 = true;
         }
      }

      return var1;
   }

   private static String a(int var0, String var1) {
      String var2 = null;
      if (var1.length() == 6) {
         var1 = var1;

         for(int var4 = 0; var4 < 10; ++var4) {
            char var3 = (char)(70 + var0 % 10);
            var0 /= 10;
            var1 = var1 + var3;
         }

         var2 = var1;
      }

      return var2;
   }
}
