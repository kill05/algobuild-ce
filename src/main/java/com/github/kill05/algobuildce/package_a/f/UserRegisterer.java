package com.github.kill05.algobuildce.package_a.f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import javax.swing.JOptionPane;

public final class UserRegisterer {
    public static final String URL = "https://algobuild.com/abkg/ab0080keyusrget.php";
    private static final char[] CHARACTERS = "0123456789ABCDEF".toCharArray();

    public static byte[] a(String var0, String var1) {
        return a(URL, var0, var1);
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

                while ((var4 = var8.read()) != -1) {
                    var11.append((char) var4);
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

            for (var4 = 2; var4 < var11.length(); var4 += 2) {
                String var12 = var11.substring(var4, var4 + 2);

                try {
                    int var13 = Integer.parseInt(var12, 16);
                    var9[var10] = (byte) var13;
                    ++var10;
                } catch (NumberFormatException var5) {
                }
            }
        }

        return var9;
    }

    private static String a(int ser, String username, String activationKey, byte[] key) throws UserRegistrationException {
        String var6 = null;

        try {
            String uk = "0x" + a(key);
            URLConnection connection = new URL(UserRegisterer.URL).openConnection();

            connection.setReadTimeout(60000);
            connection.setRequestProperty("Cookie", "abver=" + ABUserData.AB_VERSION + "; ser=" + ser + "; des=" + username + "; sc=" + activationKey + "; uk=" + uk + ";");
            connection.connect();

            String header;
            for (int i = 1; (header = connection.getHeaderFieldKey(i)) != null; ++i) {
                if (header.equals("Set-Cookie")) {
                    header = connection.getHeaderField(i);
                    System.out.println(header);
                    if (header.startsWith("cc=")) {
                        var6 = header.substring(3, header.indexOf(";"));
                    }
                }
            }

            try (InputStream in = connection.getInputStream()) {
                int var11;
                while ((var11 = in.read()) != -1) {
                    if (var11 != 10 && (var11 < 32 || var11 >= 128)) {
                        System.out.println("[" + var11 + "]");
                    } else {
                        System.out.print((char) var11);
                    }
                }
            }
            if (var6 == null) {
                throw new UserRegistrationException("Key Register - Null Result");
            }

            return var6;
        } catch (IOException var9) {
            throw new UserRegistrationException("Key Register", var9);
        }
    }

    private static String a(byte[] var0) {
        char[] var1 = new char[var0.length << 1];

        for (int var2 = 0; var2 < var0.length; ++var2) {
            int var3 = var0[var2] & 255;
            var1[var2 << 1] = CHARACTERS[var3 >>> 4];
            var1[(var2 << 1) + 1] = CHARACTERS[var3 & 15];
        }

        return new String(var1);
    }

    public static String registerUser(String username, String activationKey) {
        int var3 = ABUserData.getInstance().c();
        byte[] key = ABProgramIO.getInstance().getDecoderKey();

        try {
            String var5 = a(var3, username, activationKey, key);
            ABUserData.getInstance().a(username, var5);
            return var5;
        } catch (UserRegistrationException var6) {
            JOptionPane.showMessageDialog(null, "IMPOSSIBILE REGISTRARE " + username + "   " + activationKey);
            //todo: add translation
        }

        return null;
    }
}
