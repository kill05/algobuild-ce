package com.github.kill05.algobuildce.package_a.f;

import com.github.kill05.algobuildce.json.JsonReader;
import com.github.kill05.algobuildce.package_a.i.Translator;
import com.github.kill05.algobuildce.json.JSONObject;
import com.github.kill05.algobuildce.json.JsonWriter;
import org.jetbrains.annotations.NotNull;

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
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class f implements Runnable {
    private static f INSTANCE = null;

    private c encoder = null;
    private c c = null;

    public static f getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new f();
        }

        return INSTANCE;
    }

    private f() {
        new Thread(this).start();
    }


    @Override
    public void run() {
        System.currentTimeMillis();
        File var1 = new File(ABFiles.getCoreFolder(), new String((new com.github.kill05.algobuildce.package_a.d.e()).createArray()));
        File var2 = new File(ABFiles.getCoreFolder(), new String((new com.github.kill05.algobuildce.package_a.d.d()).createArray()));
        this.c = new c(var1, 1);
        this.encoder = new c(var2, 0);
        System.currentTimeMillis();
    }

    @SuppressWarnings("ConstantValue")
    public void a(@NotNull String fileName, JSONObject jsonObject) throws ABSerializationException {
        k var3 = k.getInstance();
        if (var3 == null) {
            throw new ABSerializationException(Translator.translate("abpErrorConfigFile") + " system configuration NON LOADED");
        }

        if (fileName == null) {
            throw new ABSerializationException(Translator.translate("abpErrorWritingFile") + " file name is NULL");
        }

        if (this.encoder == null) {
            throw new ABSerializationException(Translator.translate("abpErrorWritingFile") + " ENCODER not READY");
        }


        JSONObject var4 = new JSONObject();
        var4.put("abuid", var3.e().toString());
        String var5 = var3.b();
        if (var5 != null) {
            var4.put("abusn", var5);
        }

        String var11 = var3.d();
        if (var11 != null) {
            var4.put("abuan", var11);
        }

        byte[] fdData = jsonObjectToBytes(var4);
        byte[] fcData = jsonObjectToBytes(jsonObject);

        try (ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new ABFileOutputStream(fileName)))) {
            ZipEntry entry = new ZipEntry("fd");
            out.putNextEntry(entry);
            out.write(fdData);

            ZipEntry var14 = new ZipEntry("fc");
            out.putNextEntry(var14);
            fcData = this.encoder.a(fcData);
            out.write(fcData, 0, fcData.length);

        } catch (FileNotFoundException var6) {
            var6.printStackTrace();
        } catch (IOException var7) {
            var7.printStackTrace();
        }
    }

    public JSONObject a(String filePath) throws ABSerializationException {
        JSONObject var2 = null;
        if (filePath == null) {
            throw new ABSerializationException(Translator.translate("abpErrorReadingFile") + " NULL");
        }

        if (this.c == null) {
            throw new ABSerializationException(Translator.translate("abpErrorReadingFile") + " DECODER not READY");
        }

        try {
            ABFileInputStream var3 = new ABFileInputStream(filePath);
            ZipInputStream var14 = new ZipInputStream(new BufferedInputStream(var3));
            byte[] var5 = new byte['썐'];
            int var6 = 0;
            String var7 = null;

            while (true) {
                while (true) {
                    ZipEntry var4;
                    do {
                        if ((var4 = var14.getNextEntry()) == null) {
                            var14.close();
                            return var2;
                        }

                        if (var4.getName().equals("fd")) {
                            InputStreamReader var8 = new InputStreamReader(var14);
                            JsonReader var9 = new JsonReader(var8);
                            JSONObject var15;
                            String var18 = (var15 = new JSONObject(var9)).getAsString("abuid", null);
                            String var10 = var15.getAsString("abuan", null);
                            if ((var7 = var15.getAsString("abusn", null)) != null) {
                                var6 = k.a(var7);
                            }

                            if (var18 == null) {
                                throw new ABSerializationException(Translator.translate("abpErrorReadingFile") + " ID not present");
                            }

                            UUID var16 = UUID.fromString(var18);
                            if (!k.getInstance().e().equals(var16) && var10 == null) {
                                throw new ABSerializationException(Translator.translate("abpCannotReadOtherUserPrivateFile"));
                            }
                        }
                    } while (!var4.getName().equals("fc"));

                    int var20 = 0;

                    int var17;
                    do {
                        if ((var17 = var14.read(var5, var20, '썐' - var20)) > 0) {
                            var20 += var17;
                        }
                    } while (var17 > 0);

                    var5 = Arrays.copyOf(var5, var20);
                    byte[] data;
                    if (var6 > 0 && var6 != k.getInstance().c()) {
                        c var24 = new c(ABFiles.getCacheFolder(), 2, var7);
                        data = var24.a(var5);
                        ByteArrayInputStream var22 = new ByteArrayInputStream(data, 0, var24.b());
                        InputStreamReader var26 = new InputStreamReader(var22, StandardCharsets.UTF_8);
                        JsonReader var13 = new JsonReader(var26);
                        var2 = new JSONObject(var13);
                    } else {
                        data = this.c.a(var5);
                        ByteArrayInputStream var25 = new ByteArrayInputStream(data, 0, this.c.b());
                        InputStreamReader var23 = new InputStreamReader(var25, StandardCharsets.UTF_8);
                        JsonReader var21 = new JsonReader(var23);
                        var2 = new JSONObject(var21);
                    }
                }
            }
        } catch (ABSerializationException var11) {
            throw var11;
        } catch (Exception var12) {
            System.out.println("Failed to read file.");
            var12.printStackTrace();
            throw new ABSerializationException(Translator.translate("abpErrorReadingFile") + filePath);
        }
    }

    private static byte[] jsonObjectToBytes(JSONObject jsonObject) throws ABSerializationException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1000);

        try (OutputStreamWriter writer = new OutputStreamWriter(baos, StandardCharsets.UTF_8)) {
            JsonWriter jsonWriter = new JsonWriter(writer);
            jsonWriter.start();

            for (String key : jsonObject.keySet()) {
                jsonWriter.writeKey(key);
                jsonWriter.writeValue(jsonObject.getNullable(key));
            }

            jsonWriter.end();
            return baos.toByteArray();
        } catch (UnsupportedEncodingException e) {
            throw new ABSerializationException(Translator.translate("abpErrorWritingFile"), e);
        } catch (IOException e) {
            throw new ABSerializationException(Translator.translate("abpErrorWritingFile"));
        }
    }

    public byte[] b() {
        return this.c.a();
    }
}
