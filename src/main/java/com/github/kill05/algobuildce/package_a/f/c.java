package com.github.kill05.algobuildce.package_a.f;

import com.github.kill05.algobuildce.package_a.i.Translator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.UUID;
import javax.crypto.Cipher;

public final class c {
    private static final String a = "RSA";
    private static final String b = "RSA/ECB/PKCS1PADDING";
    private static final int c = 1024;
    private final int d = 11;
    private boolean e = false;
    private Key f = null;
    private Cipher g = null;
    private int h = -1;
    private final File i;
    private int j = 0;
    private String k;
    private String l = null;

    public c(File var1, int var2) {
        this.i = var1;
        if (var2 == 0) {
            this.h = var2;
            this.c();
        } else {
            if (var2 == 1) {
                this.h = var2;
                this.c();
            }

        }
    }

    public c(File var1, int var2, String var3) {
        this.i = var1;
        this.h = 2;
        this.k = "tmp-" + Integer.toString(com.github.kill05.algobuildce.package_a.f.k.a(var3), 9);
        this.l = var3;
        this.c();
    }

    private void c() {
        try {
            DataInputStream var2;
            byte var3;
            byte var4;
            byte var5;
            byte var6;
            UUID var7;
            long var8;
            UUID var9;
            long var10;
            byte[] var11;
            KeyFactory var15;
            UUID var24;
            UUID var25;
            if (this.h == 0) {
                var3 = (var2 = new DataInputStream(new FileInputStream(this.i))).readByte();
                var4 = var2.readByte();
                var5 = var2.readByte();
                var6 = var2.readByte();
                var8 = var2.readLong();
                var10 = var2.readLong();
                var7 = new UUID(var8, var10);
                var8 = var2.readLong();
                var10 = var2.readLong();
                var24 = new UUID(var8, var10);
                var9 = com.github.kill05.algobuildce.package_a.f.k.getInstance().e();
                var25 = com.github.kill05.algobuildce.package_a.f.k.getInstance().f();
                var11 = new byte[(int) this.i.length() - 36];
                var2.read(var11);
                var2.close();
                if (var3 != -85 || var4 != -49 || var5 != 1 || var6 != 2 || !var7.equals(var9) || !var24.equals(var25)) {
                    throw new e(Translator.translate("abpErrorConfigFile"));
                }

                var15 = KeyFactory.getInstance(a);
                PKCS8EncodedKeySpec var16 = new PKCS8EncodedKeySpec(var11);
                this.f = var15.generatePrivate(var16);
                this.a(true);
            }

            if (this.h == 1) {
                var3 = (var2 = new DataInputStream(new FileInputStream(this.i))).readByte();
                var4 = var2.readByte();
                var5 = var2.readByte();
                var6 = var2.readByte();
                var8 = var2.readLong();
                var10 = var2.readLong();
                var7 = new UUID(var8, var10);
                var8 = var2.readLong();
                var10 = var2.readLong();
                var24 = new UUID(var8, var10);
                var9 = com.github.kill05.algobuildce.package_a.f.k.getInstance().e();
                var25 = com.github.kill05.algobuildce.package_a.f.k.getInstance().f();
                var11 = new byte[(int) this.i.length() - 36];
                var2.read(var11);
                var2.close();
                if (var3 != -85 || var4 != -49 || var5 != 1 || var6 != 1 || !var7.equals(var9) || !var24.equals(var25)) {
                    throw new e(Translator.translate("abpErrorConfigFile"));
                }

                var15 = KeyFactory.getInstance(a);
                X509EncodedKeySpec var18 = new X509EncodedKeySpec(var11);
                this.f = var15.generatePublic(var18);
                this.a(true);
            }

            if (this.h == 2) {
                File var17;
                byte[] var19;
                if ((var17 = new File(this.i, this.k)).exists()) {
                    FileInputStream var21 = new FileInputStream(var17);
                    var19 = new byte[(int) var17.length()];
                    var21.read(var19);
                    var21.close();
                } else if ((var19 = com.github.kill05.algobuildce.package_a.f.d.a(com.github.kill05.algobuildce.package_a.f.k.getInstance().b(), this.l)) != null && var19.length > 0) {
                    FileOutputStream var20;
                    (var20 = new FileOutputStream(var17)).write(var19);
                    var20.close();
                } else {
                    System.out.println("EWRROR DOWNLOADING PUBLIC_EXTERNAL_KEY key: " + this.l);
                }

                if (var19 != null && var19.length > 0) {
                    KeyFactory var22 = KeyFactory.getInstance(a);
                    X509EncodedKeySpec var23 = new X509EncodedKeySpec(var19);
                    this.f = var22.generatePublic(var23);
                    this.a(true);
                }
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException var12) {
            var12.printStackTrace();
        } catch (IOException ignored) {
        }

        if (this.d()) {
            if (this.h == 0) {
                byte[] var1 = new byte[]{1, 1, 1};
                this.a(var1);
            }
        } else {
            System.out.println("ERROR: Key not loaded!!! " + this.i.getAbsolutePath());
        }

    }

    public byte[] a() {
        return this.f.getEncoded();
    }

    public static void a(UUID var0, UUID var1, File var2, File var3) {
        try {
            KeyPairGenerator var4;
            (var4 = KeyPairGenerator.getInstance(a)).initialize(c);
            KeyPair var10000 = var4.genKeyPair();
            File var14 = var3;
            var3 = var2;
            UUID var12 = var1;
            var1 = var0;
            KeyPair var8 = var10000;
            PrivateKey var5 = var10000.getPrivate();
            PublicKey var9 = var8.getPublic();
            X509EncodedKeySpec var10 = new X509EncodedKeySpec(var9.getEncoded());
            DataOutputStream var13;
            (var13 = new DataOutputStream(new FileOutputStream(var3))).write(171);
            var13.write(207);
            var13.write(1);
            var13.write(1);
            var13.writeLong(var1.getMostSignificantBits());
            var13.writeLong(var1.getLeastSignificantBits());
            var13.writeLong(var12.getMostSignificantBits());
            var13.writeLong(var12.getLeastSignificantBits());
            var13.write(var10.getEncoded());
            var13.close();
            PKCS8EncodedKeySpec var11 = new PKCS8EncodedKeySpec(var5.getEncoded());
            (var13 = new DataOutputStream(new FileOutputStream(var14))).write(171);
            var13.write(207);
            var13.write(1);
            var13.write(2);
            var13.writeLong(var1.getMostSignificantBits());
            var13.writeLong(var1.getLeastSignificantBits());
            var13.writeLong(var12.getMostSignificantBits());
            var13.writeLong(var12.getLeastSignificantBits());
            var13.write(var11.getEncoded());
            var13.close();
        } catch (NoSuchAlgorithmException var6) {
            var6.printStackTrace();
        } catch (IOException var7) {
            var7.printStackTrace();
        }
    }

    private boolean d() {
        synchronized (this) {
            return this.e;
        }
    }

    private void a(boolean var1) {
        synchronized (this) {
            this.e = true;
        }
    }

    public byte[] a(byte[] var1) {
        if (this.h == -1) {
            return null;
        }

        if (!this.d()) {
            return null;
        }

        int var3;
        int var4 = (var3 = c / 8) - this.d;
        int var2;
        if (this.h == 0) {
            var2 = (var1.length + var4 - 1) / var4 * var3;
        } else {
            var2 = (var1.length + var3 - 1) / var3 * var3;
        }

        byte[] var10 = new byte[var2];

        try {
            if (this.g == null) {
                this.g = Cipher.getInstance(b);
            }

            int var5;
            int var6;
            int var7;
            int var8;
            if (this.h == 0) {
                this.g.init(1, this.f);
                var5 = var1.length;
                var6 = 0;
                var7 = Math.min(var5, var4);

                for (var8 = 0; var5 > 0; var8 += var3) {
                    var3 = this.g.doFinal(var1, var6, var7, var10, var8);
                    var6 += var4;
                    var7 = Math.min(var5 -= var4, var4);
                }

                this.j = var8;
            } else {
                this.g.init(2, this.f);
                var5 = var1.length;
                var6 = 0;
                var7 = Math.min(var5, var3);

                for (var8 = 0; var5 > 0; var8 += var4) {
                    var4 = this.g.doFinal(var1, var6, var7, var10, var8);
                    var6 += var3;
                    var7 = Math.min(var5 -= var3, var3);
                }

                this.j = var8;
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        return var10;

    }

    public int b() {
        return this.j;
    }
}
