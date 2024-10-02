package com.github.kill05.algobuildce.package_a.f;

import com.github.kill05.algobuildce.package_a.d.TestModelCoreCharArrayFactory;
import com.github.kill05.algobuildce.package_a.h.UserNameCharArrayFactory;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;

public final class l {
    private static int a = -1;

    public static int runFirstConfiguration() {
        if (a == -1) {
            a = 0;
            a(0);
            boolean var10000;
            File var0;
            if ((var0 = ABFiles.getABFolder()).exists() && var0.isDirectory()) {
                var10000 = true;
            } else {
                var0.mkdirs();
                var10000 = var0.exists() && var0.isDirectory();
            }

            if (var10000) {
                a(10);
            } else {
                a = 1;
            }

            if (a == 0 && c()) {
                a(20);
            } else {
                a = 3;
            }

            if (a == 0 && d()) {
                a(30);
            } else {
                a = 2;
            }

            label88:
            {
                if (a == 0) {
                    if ((var0 = ABFiles.getCacheFolder()).exists() && var0.isDirectory()) {
                        var10000 = true;
                    } else {
                        var0.mkdirs();
                        var10000 = var0.exists() && var0.isDirectory();
                    }

                    if (var10000) {
                        a(40);
                        break label88;
                    }
                }

                a = 4;
            }

            label75:
            {
                if (a == 0) {
                    if ((var0 = ABFiles.getCoreFolder()).exists() && var0.isDirectory()) {
                        var10000 = true;
                    } else {
                        var0.mkdirs();
                        var10000 = var0.exists() && var0.isDirectory();
                    }

                    if (var10000) {
                        a(50);
                        break label75;
                    }
                }

                a = 4;
            }

            if (a == 0) {
                b();
                a(100);
            } else {
                a = 6;
            }

            if (a == 0) {

                try {
                    Thread.sleep(200L);
                } catch (InterruptedException var2) {
                }
            }

            System.out.println("Config Progress Complete");
        }

        return a;
    }

    private static boolean b() {
        UUID var0 = UUID.randomUUID();
        String var1 = System.getProperties().getProperty(new String((new UserNameCharArrayFactory()).createArray()));

        UUID var5 = UUID.nameUUIDFromBytes(var1.getBytes(StandardCharsets.UTF_8));
        File var2 = new File(ABFiles.getCoreFolder(), new String((new com.github.kill05.algobuildce.package_a.d.e()).createArray()));
        File var3 = new File(ABFiles.getCoreFolder(), new String((new com.github.kill05.algobuildce.package_a.d.d()).createArray()));
        c.a(var0, var5, var2, var3);
        a(50);
        var2 = new File(ABFiles.getCoreFolder(), new String((new com.github.kill05.algobuildce.package_a.d.g()).createArray()));
        a(var0, var5, var2);
        a(60);
        var2 = new File(ABFiles.getCoreFolder(), new String((new com.github.kill05.algobuildce.package_a.d.b()).createArray()));
        a(var0, var5, var2);
        a(70);
        var2 = new File(ABFiles.getCoreFolder(), new String((new com.github.kill05.algobuildce.package_a.d.c()).createArray()));
        a(var0, var5, var2);
        a(80);
        var2 = new File(ABFiles.getCoreFolder(), new String((new TestModelCoreCharArrayFactory()).createArray()));
        b(var0, var5, var2);
        a(100);

        return true;
    }

    private static boolean a(UUID var0, UUID var1, File var2) {
        boolean var3 = false;

        try {
            DataOutputStream var7;
            (var7 = new DataOutputStream(new FileOutputStream(var2))).write(171);
            var7.write(207);
            var7.write(1);
            var7.write(3);
            var7.writeLong(var0.getMostSignificantBits());
            var7.writeLong(var0.getLeastSignificantBits());
            var7.writeLong(var1.getMostSignificantBits());
            var7.writeLong(var1.getLeastSignificantBits());

            for (int var6 = 0; var6 < 123; ++var6) {
                var7.write((byte) ((int) (Math.random() * 256.0D)));
            }

            var7.close();
            var3 = true;
        } catch (FileNotFoundException var4) {
            var4.printStackTrace();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

        return var3;
    }

    private static boolean c() {
        boolean var0 = false;
        File var1 = ABFiles.getABFolder();
        int var2 = (int) (Math.random() * 100000.0D);
        var1 = new File(var1, "tmp-test-" + var2);
        byte[] var7;
        Arrays.fill(var7 = new byte[100], (byte) 0);

        for (int var3 = 0; var3 < 50; ++var3) {
            var7[var3] = (byte) ((int) (Math.random() * 256.0D - 128.0D));
        }

        try {
            FileOutputStream var8;
            (var8 = new FileOutputStream(var1)).write(var7, 0, 50);
            var8.close();
            FileInputStream var9;
            (var9 = new FileInputStream(var1)).read(var7, 50, 50);
            var9.close();
            System.out.println("temp write:" + var1.getAbsolutePath());
            var1.delete();
            var0 = true;

            for (int var6 = 0; var6 < 50 && var0; ++var6) {
                var0 = var7[var6] == var7[var6 + 50];
            }
        } catch (FileNotFoundException var4) {
            var4.printStackTrace();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

        return var0;
    }

    private static boolean d() {
        File var0;
        if ((var0 = ABFiles.getABSecretFolder()).exists() && var0.isDirectory()) {
            return true;
        } else {
            var0.mkdirs();
            String var1;
            if ((var1 = System.getProperty("os.name")) != null && var1.toLowerCase().contains("win")) {
                var1 = "attrib +H " + var0;

                try {
                    Runtime.getRuntime().exec(var1);
                } catch (IOException var2) {
                }
            }

            return var0.exists() && var0.isDirectory();
        }
    }

    private static void a(int var0) {
        System.out.println("Config Progress Update % " + var0);
    }

    private static boolean b(UUID var0, UUID var1, File var2) {
        boolean var3 = false;

        try {
            DataOutputStream var8;
            (var8 = new DataOutputStream(new FileOutputStream(var2))).write(171);
            var8.write(207);
            var8.write(1);
            var8.write(4);
            var8.writeLong(var0.getMostSignificantBits());
            var8.writeLong(var0.getLeastSignificantBits());
            var8.writeLong(var1.getMostSignificantBits());
            var8.writeLong(var1.getLeastSignificantBits());
            var8.writeInt(0);
            var8.writeInt(0);
            int var6 = 128 + (int) (Math.random() * 256.0D);

            for (int var7 = 0; var7 < var6; ++var7) {
                var8.write((byte) ((int) (Math.random() * 256.0D)));
            }

            var8.close();
            var3 = true;
        } catch (FileNotFoundException var4) {
            var4.printStackTrace();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

        return var3;
    }
}
