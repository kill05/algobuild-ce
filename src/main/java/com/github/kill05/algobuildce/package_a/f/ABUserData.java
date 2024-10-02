package com.github.kill05.algobuildce.package_a.f;

import com.github.kill05.algobuildce.package_a.charfactory.LoadModelCoreCharArrayFactory;
import com.github.kill05.algobuildce.package_a.charfactory.TestModelCoreCharArrayFactory;
import com.github.kill05.algobuildce.package_a.charfactory.ToolModelCoreCharArrayFactory;
import com.github.kill05.algobuildce.package_a.h.UserNameCharArrayFactory;
import com.github.kill05.algobuildce.package_a.i.Translator;
import org.jetbrains.annotations.NotNull;

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
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.UUID;

public final class ABUserData {

    public static final String AB_VERSION = "AB0080";
    public static final String KEY_GEN_URL = "https://algobuild.com/abkg/ab0080keygen.php";

    private static ABUserData INSTANCE = null;

    private final char[] systemUsernameChars;
    private String serial = null;
    private int d = 0;
    private UUID e;
    private UUID f;
    private String g = null;

    @NotNull
    public static ABUserData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ABUserData();
        }

        return INSTANCE;
    }

    private ABUserData() {
        File loadModelCore = new File(ABFiles.getCoreFolder(), new String((new LoadModelCoreCharArrayFactory()).createArray()));

        String systemUsername = System.getProperties().getProperty(new String((new UserNameCharArrayFactory()).createArray()));
        try (DataInputStream inputStream = new DataInputStream(Files.newInputStream(loadModelCore.toPath()))) {
            byte var3 = inputStream.readByte();
            byte var4 = inputStream.readByte();
            byte var5 = inputStream.readByte();
            byte var6 = inputStream.readByte();
            long var12 = inputStream.readLong();
            long var14 = inputStream.readLong();
            this.e = new UUID(var12, var14);
            var12 = inputStream.readLong();
            var14 = inputStream.readLong();
            this.f = new UUID(var12, var14);
            UUID uuidFromSystemUsername = UUID.nameUUIDFromBytes(systemUsername.getBytes(StandardCharsets.UTF_8));

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

            if (!this.f.equals(uuidFromSystemUsername)) {
                throw new e(Translator.translate("abpErrorConfigFile") + " UUID2");
            }

        } catch (IOException var19) {
            var19.printStackTrace();
        }

        this.g();
        this.systemUsernameChars = new char[systemUsername.length()];

        for (int i = 0; i < systemUsername.length(); ++i) {
            this.systemUsernameChars[i] = systemUsername.charAt(i);
        }

        int i = this.h();
        String username = this.readUsername(AB_VERSION);
        if (i <= 0 && username == null) {
            try {
                this.generateUsername(KEY_GEN_URL, AB_VERSION);
            } catch (ABSerializationException ignored) {
            }
        }

        if (i > 0 && username == null) {
            try {
                if ((username = a(KEY_GEN_URL, i, AB_VERSION)) != null) {
                    this.c(username, AB_VERSION);
                } else {
                    username = a(i, AB_VERSION);
                }
            } catch (ABSerializationException var16) {
                var16.printStackTrace();
            }
        }

        if (i <= 0 && username != null) {
            i = a(username);
            this.a(i);
        }

        if (this.serial == null) {
            this.serial = username;
        }

        if (this.d == 0) {
            this.d = i;
        }

    }

    private void g() {
        File testModelCore = new File(ABFiles.getCoreFolder(), new String((new TestModelCoreCharArrayFactory()).createArray()));

        try (DataInputStream in = new DataInputStream(new FileInputStream(testModelCore))) {
            byte var2 = in.readByte();
            byte var3 = in.readByte();
            byte var4 = in.readByte();
            byte var5 = in.readByte();
            long var7 = in.readLong();
            long var9 = in.readLong();
            this.e = new UUID(var7, var9);
            var7 = in.readLong();
            var9 = in.readLong();
            this.f = new UUID(var7, var9);
            UUID uuidFromUsername = UUID.nameUUIDFromBytes(System.getProperties().getProperty(new String((new UserNameCharArrayFactory()).createArray())).getBytes(StandardCharsets.UTF_8));
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

            if (!this.f.equals(uuidFromUsername)) {
                throw new e(Translator.translate("abpErrorConfigFile") + " UUID2");
            }

            int var14;
            if ((var14 = in.readInt()) > 0) {
                byte[] var15 = new byte[var14];

                int var17;
                for (var17 = 0; var17 < var14; ++var17) {
                    int var18 = in.readInt() + 2 * var17 - 143;
                    var15[var17] = (byte) var18;
                }

                this.g = new String(var15, StandardCharsets.UTF_8);
                if ((var17 = in.readInt()) > 0) {
                    byte[] var19 = new byte[var17];

                    for (var14 = 0; var14 < var17; ++var14) {
                        int var16 = in.readInt() + 2 * var14 - 143;
                        var19[var14] = (byte) var16;
                    }

                    new String(var19, StandardCharsets.UTF_8);
                }
            }
        } catch (IOException ignored) {
        }

    }

    public void a(String username, String var2) {
        if (this.b(username, var2)) {
            this.g = username;
        }

    }

    private boolean b(String var1, String var2) {
        boolean var3 = false;
        File testModelFile = new File(ABFiles.getCoreFolder(), new String((new TestModelCoreCharArrayFactory()).createArray()));

        try (DataOutputStream out = new DataOutputStream(Files.newOutputStream(testModelFile.toPath()))) {
            out.write(171);
            out.write(207);
            out.write(1);
            out.write(4);
            out.writeLong(this.e.getMostSignificantBits());
            out.writeLong(this.e.getLeastSignificantBits());
            out.writeLong(this.f.getMostSignificantBits());
            out.writeLong(this.f.getLeastSignificantBits());
            byte[] var8 = var1.getBytes(StandardCharsets.UTF_8);
            out.writeInt(var8.length);

            int var5;
            for (var5 = 0; var5 < var8.length; ++var5) {
                out.writeInt(var8[var5] + 143 - 2 * var5);
            }

            var8 = var2.getBytes(StandardCharsets.UTF_8);
            out.writeInt(var8.length);

            for (var5 = 0; var5 < var8.length; ++var5) {
                out.writeInt(var8[var5] + 143 - 2 * var5);
            }

            for (var5 = 0; var5 < 123; ++var5) {
                out.write((byte) ((int) (Math.random() * 256.0D)));
            }

            out.close();
            var3 = true;
        } catch (IOException var7) {
            var7.printStackTrace();
        }

        return var3;
    }

    private boolean a(int var1) {
        boolean var2 = false;
        File var3 = new File(ABFiles.getCoreFolder(), new String((new ToolModelCoreCharArrayFactory()).createArray()));

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
            for (var4 = 0; var4 < 7; ++var4) {
                var7.writeInt((int) (Math.random() * 2.147483647E9D));
            }

            var7.writeInt(var1);

            for (var4 = 0; var4 < 11; ++var4) {
                var7.writeInt((int) (Math.random() * 2.147483647E9D));
            }

            var7.close();
            var2 = true;
        } catch (IOException var6) {
            var6.printStackTrace();
        }

        return var2;
    }

    private int h() {
        File toolModelCore = new File(ABFiles.getCoreFolder(), new String((new ToolModelCoreCharArrayFactory()).createArray()));
        int var2 = 0;

        try (DataInputStream in = new DataInputStream(Files.newInputStream(toolModelCore.toPath()))) {
            byte var3 = in.readByte();
            byte var4 = in.readByte();
            byte var5 = in.readByte();
            byte var6 = in.readByte();
            long var8 = in.readLong();
            long var10 = in.readLong();
            this.e = new UUID(var8, var10);
            var8 = in.readLong();
            var10 = in.readLong();
            this.f = new UUID(var8, var10);
            UUID uuidFromSystemUsername = UUID.nameUUIDFromBytes(System.getProperties().getProperty(new String((new UserNameCharArrayFactory()).createArray())).getBytes(StandardCharsets.UTF_8));

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

            if (!this.f.equals(uuidFromSystemUsername)) {
                throw new e(Translator.translate("abpErrorConfigFile") + " UUID2");
            }

            int var15;
            for (var15 = 0; var15 < 7; ++var15) {
                in.readInt();
            }

            var2 = in.readInt();

            for (var15 = 0; var15 < 11; ++var15) {
                in.readInt();
            }
        } catch (IOException var13) {
            var13.printStackTrace();
        }

        return var2;
    }

    public String getSerial() {
        return this.serial;
    }

    public int c() {
        return this.d;
    }

    public String d() {
        return this.g;
    }

    public UUID getUserUuid() {
        return this.e;
    }

    public UUID f() {
        return this.f;
    }

    private static String a(String var0, int var1, String var2) throws ABSerializationException {
        String var3 = null;
        String var4 = null;
        int var5 = -1;
        int var6 = -1;
        long var7 = -1L;
        boolean var9 = false;

        try {
            var9 = InetAddress.getByName((new URL(var0)).getHost()).isReachable(10000);
        } catch (IOException ignored) {
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
                for (var10 = 1; (var11 = var21.getHeaderFieldKey(var10)) != null; ++var10) {
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
                            var7 = Integer.parseInt(var12.substring(2, var12.indexOf(";")));
                        }
                    }
                }

                InputStream var22 = var21.getInputStream();

                while (true) {
                    int var25;
                    while ((var25 = var22.read()) != -1) {
                        if (var25 != 10 && (var25 < 32 || var25 >= 128)) {
                            System.out.println("[" + var25 + "]");
                        } else {
                            System.out.print((char) var25);
                        }
                    }

                    var22.close();
                    var10 = var5 + var6 * 10000 ^ 51627384;
                    if (var5 > 0 && var6 > 0 && var7 == -1L && var4 != null) {
                        URLConnection var23 = (new URL(var0)).openConnection();
                        String var24 = "PHPSESSID=" + var4 + "; abver=" + var2 + "; abexistingserialnum=" + var1 + "; pass=4; k=" + var10 + ";";
                        var23.setRequestProperty("Cookie", var24);
                        var23.connect();

                        for (int var13 = 1; (var12 = var23.getHeaderFieldKey(var13)) != null; ++var13) {
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

                        int var20;
                        while ((var20 = var26.read()) != -1) {
                            if (var20 != 10 && (var20 < 32 || var20 >= 128)) {
                                System.out.print('.');
                            } else {
                                System.out.print((char) var20);
                            }
                        }

                        var26.close();
                        return var3;
                    }
                    break;
                }
            } catch (ConnectException ignored) {
            } catch (IOException e) {
                throw new ABSerializationException(Translator.translate("abpErrorConfigFile"), e);
            }
        }

        return var3;
    }

    private void c(String username, String configFileName) throws ABSerializationException {
        File secretFolder = ABFiles.getABSecretFolder();

        if (!secretFolder.exists()) {
            return;
        }

        File file = new File(secretFolder, configFileName + ".sn");

        try (PrintStream stream = new PrintStream(file)) {
            if (!stream.checkError() && username != null) {
                long var6 = 0L;

                int var11;
                for (var11 = 0; var11 < this.systemUsernameChars.length; ++var11) {
                    var6 += this.systemUsernameChars[var11];
                }

                for (var11 = 0; var11 < username.length(); ++var11) {
                    var6 += username.charAt(var11);
                }

                stream.print(username);
                stream.print(' ');
                stream.println(var6);
            }
        } catch (FileNotFoundException var8) {
            throw new ABSerializationException(Translator.translate("abpErrorConfigFile"), var8);
        }
    }

    private void generateUsername(String url, String version) throws ABSerializationException {
        File configFile = ABFiles.getABSecretFolder();

        if (!configFile.exists()) {
            return;
        }

        try (PrintStream stream = new PrintStream(new File(configFile, version + ".sn"))) {
            String username = doGenerateUsername(url, version);

            if (stream.checkError() || username == null) {
                return;
            }

            stream.print(username);
            stream.print(' ');
            stream.println(computeUsernameHash(username));

            this.serial = username;
            this.d = a(username);
            this.a(this.d);
        } catch (FileNotFoundException var9) {
            throw new ABSerializationException(Translator.translate("abpErrorConfigFile"), var9);
        }
    }

    private long computeUsernameHash(String username) {
        long hash = 0L;

        for (char character : this.systemUsernameChars) {
            hash += character;
        }

        for (int i = 0; i < username.length(); ++i) {
            hash += username.charAt(i);
        }
        return hash;
    }

    private static String doGenerateUsername(String url, String version) throws ABSerializationException {
        String username = null;
        String sessionId = null;
        int x = -1;
        int y = -1;
        long k = -1L;

        try {
            URLConnection connection = new URL(url).openConnection();
            connection.setRequestProperty("Cookie", "abver=" + version + "; pass=1");
            connection.connect();

            int var8;
            String var10;
            for (var8 = 1; (var10 = connection.getHeaderFieldKey(var8)) != null; ++var8) {
                if (var10.equals("Set-Cookie")) {
                    String var11;
                    if ((var11 = connection.getHeaderField(var8)).startsWith("PHPSESSID=")) {
                        sessionId = var11.substring(10, var11.indexOf(";"));
                    }

                    if (var11.startsWith("x=")) {
                        x = Integer.parseInt(var11.substring(2, var11.indexOf(";")));
                    }

                    if (var11.startsWith("y=")) {
                        y = Integer.parseInt(var11.substring(2, var11.indexOf(";")));
                    }

                    if (var11.startsWith("k=")) {
                        k = Integer.parseInt(var11.substring(2, var11.indexOf(";")));
                    }
                }
            }

            InputStream var15 = connection.getInputStream();

            while (true) {
                int var18;
                while ((var18 = var15.read()) != -1) {
                    if (var18 != 10 && (var18 < 32 || var18 >= 128)) {
                        System.out.print('.');
                    } else {
                        System.out.print((char) var18);
                    }
                }

                var15.close();
                var8 = x + y * 10000 ^ 51627384;
                if (x > 0 && y > 0 && k == -1L && sessionId != null) {
                    URLConnection var17;
                    (var17 = (new URL(url)).openConnection()).setRequestProperty("Cookie", "PHPSESSID=" + sessionId + "; abver=" + version + "; pass=2; k=" + var8 + ";");
                    var17.connect();

                    String var16;
                    for (var18 = 1; (var16 = var17.getHeaderFieldKey(var18)) != null; ++var18) {
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
                                username = var12.substring(2, var12.indexOf(";"));
                            }
                        }
                    }

                    try (InputStream var19 = var17.getInputStream()) {
                        int var20;
                        while ((var20 = var19.read()) != -1) {
                            if (var20 != 10 && (var20 < 32 || var20 >= 128)) {
                                System.out.print('.');
                            } else {
                                System.out.print((char) var20);
                            }
                        }
                    }
                }

                return username;
            }
        } catch (IOException var14) {
            throw new ABSerializationException(Translator.translate("abpErrorConfigFile"), var14);
        }
    }

    private String readUsername(String version) {
        File var15 = new File(ABFiles.getABSecretFolder(), version + ".sn");

        try (Scanner scanner = new Scanner(Files.newInputStream(var15.toPath()))) {
            String username = scanner.next();
            long hash = computeUsernameHash(username);
            long expectedHash = scanner.nextLong();

            if (hash != expectedHash) {
                throw new ABSerializationException(Translator.translate("abpErrorConfigFile"));
            }

            return username;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int a(String var0) {
        int var1 = 0;
        boolean stop = false;

        for (int i = var0.length() - 1; i >= 0 && !stop; --i) {
            char var4 = var0.charAt(i);
            if (var4 >= 'F' && var4 <= 'O') {
                var1 = var1 * 10 + var4 - 70;
            } else {
                stop = true;
            }
        }

        return var1;
    }

    private static String a(int var0, String var1) {
        String var2 = null;
        if (var1.length() == 6) {
            for (int var4 = 0; var4 < 10; ++var4) {
                char var3 = (char) (70 + var0 % 10);
                var0 /= 10;
                var1 = var1 + var3;
            }

            var2 = var1;
        }

        return var2;
    }
}
