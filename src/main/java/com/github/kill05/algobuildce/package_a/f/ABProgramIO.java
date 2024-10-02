package com.github.kill05.algobuildce.package_a.f;

import com.github.kill05.algobuildce.json.JsonReader;
import com.github.kill05.algobuildce.package_a.charfactory.BootModelCoreCharArrayFactory;
import com.github.kill05.algobuildce.package_a.charfactory.WorkModelCoreCharArrayFactory;
import com.github.kill05.algobuildce.package_a.i.Translator;
import com.github.kill05.algobuildce.json.JsonObject;
import com.github.kill05.algobuildce.json.JsonWriter;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
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

public final class ABProgramIO implements Runnable {

    public static final String AB_UUID_KEY = "abuid";
    public static final String AB_USER_SERIAL_NUMBER_KEY = "abusn";
    public static final String AB_USER_AUTH_NUMBER_KEY = "abuan";
    public static final String FILE_CONTENT_NAME = "fc";
    public static final String FILE_DATA_NAME = "fd";
    private static ABProgramIO INSTANCE = null;

    private KeyedEncoder encoder = null;
    private KeyedEncoder decoder = null;

    public static ABProgramIO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ABProgramIO();
        }

        return INSTANCE;
    }

    private ABProgramIO() {
        new Thread(this).start();
    }


    @Override
    public void run() {
        //System.currentTimeMillis();
        this.decoder = new KeyedEncoder(new File(ABFiles.getCoreFolder(), new String((new BootModelCoreCharArrayFactory()).createArray())), 1);
        this.encoder = new KeyedEncoder(new File(ABFiles.getCoreFolder(), new String((new WorkModelCoreCharArrayFactory()).createArray())), 0);
        //System.currentTimeMillis();
    }

    public void writeProgram(@NotNull String fileName, JsonObject jsonObject) throws ABSerializationException {
        ABUserData user = ABUserData.getInstance();

        /*
        if (user == null) {
            throw new ABSerializationException(Translator.translate("abpErrorConfigFile") + " system configuration NON LOADED");
        }

        if (fileName == null) {
            throw new ABSerializationException(Translator.translate("abpErrorWritingFile") + " file name is NULL");
         */

        if (this.encoder == null) {
            throw new ABSerializationException(Translator.translate("abpErrorWritingFile") + " ENCODER not READY");
        }

        JsonObject fdJson = new JsonObject();
        fdJson.put(AB_UUID_KEY, user.getUserUuid().toString());
        String username = user.getSerial();
        if (username != null) {
            fdJson.put(AB_USER_SERIAL_NUMBER_KEY, username);
        }

        String var11 = user.d();
        if (var11 != null) {
            fdJson.put(AB_USER_AUTH_NUMBER_KEY, var11);
        }

        byte[] fdData = jsonObjectToBytes(fdJson);
        byte[] fcData = jsonObjectToBytes(jsonObject);

        try (ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new ABFileOutputStream(fileName)))) {
            ZipEntry entry = new ZipEntry(FILE_DATA_NAME);
            out.putNextEntry(entry);
            out.write(fdData);

            ZipEntry var14 = new ZipEntry(FILE_CONTENT_NAME);
            out.putNextEntry(var14);
            fcData = this.encoder.a(fcData);
            out.write(fcData, 0, fcData.length);
        } catch (IOException var7) {
            var7.printStackTrace();
        }
    }

    public JsonObject readProgram(String filePath) throws ABSerializationException {
        JsonObject var2 = null;
        if (filePath == null) {
            throw new ABSerializationException(Translator.translate("abpErrorReadingFile") + " NULL");
        }

        if (this.decoder == null) {
            throw new ABSerializationException(Translator.translate("abpErrorReadingFile") + " DECODER not READY");
        }

        try (ZipInputStream zipIn = new ZipInputStream(new BufferedInputStream(new ABFileInputStream(filePath)))) {
            byte[] var5 = new byte['썐'];
            int var6 = 0;
            String ownerSerial = null;

            while (true) {
                ZipEntry zipEntry;
                do {
                    zipEntry = zipIn.getNextEntry();
                    if (zipEntry == null) {
                        return var2;
                    }

                    if (!zipEntry.getName().equals(FILE_DATA_NAME)) {
                        continue;
                    }

                    // Don't close or else the zip stream is closed
                    InputStreamReader reader = new InputStreamReader(zipIn);
                    JsonObject jsonObject = new JsonObject(new JsonReader(reader));
                    String ownerUuid = jsonObject.getAsString(AB_UUID_KEY, null);
                    String ownerAuthNumber = jsonObject.getAsString(AB_USER_AUTH_NUMBER_KEY, null);
                    ownerSerial = jsonObject.getAsString(AB_USER_SERIAL_NUMBER_KEY, null);

                    //System.out.println(ownerUuid);
                    //System.out.println(ownerAuthNumber);
                    //System.out.println(ownerSerial);

                    if (ownerUuid != null) {
                        var6 = ABUserData.a(ownerSerial);
                    }

                    if (ownerUuid == null) {
                        throw new ABSerializationException(Translator.translate("abpErrorReadingFile") + " ID not present");
                    }

                    if (!ABUserData.getInstance().getUserUuid().equals(UUID.fromString(ownerUuid)) && ownerAuthNumber == null) {
                        throw new ABSerializationException(Translator.translate("abpCannotReadOtherUserPrivateFile"));
                    }
                } while (!zipEntry.getName().equals(FILE_CONTENT_NAME));

                int var20 = 0;

                int var17;
                do {
                    if ((var17 = zipIn.read(var5, var20, '썐' - var20)) > 0) {
                        var20 += var17;
                    }
                } while (var17 > 0);

                var5 = Arrays.copyOf(var5, var20);
                byte[] data;
                if (var6 > 0 && var6 != ABUserData.getInstance().c()) {
                    KeyedEncoder var24 = new KeyedEncoder(ABFiles.getCacheFolder(), 2, ownerSerial);
                    data = var24.a(var5);
                    ByteArrayInputStream in = new ByteArrayInputStream(data, 0, var24.b());
                    InputStreamReader var26 = new InputStreamReader(in, StandardCharsets.UTF_8);
                    JsonReader var13 = new JsonReader(var26);
                    var2 = new JsonObject(var13);
                } else {
                    data = this.decoder.a(var5);
                    ByteArrayInputStream in = new ByteArrayInputStream(data, 0, this.decoder.b());
                    InputStreamReader var23 = new InputStreamReader(in, StandardCharsets.UTF_8);
                    JsonReader var21 = new JsonReader(var23);
                    var2 = new JsonObject(var21);
                }
            }
        } catch (ABSerializationException e) {
            throw e;
        } catch (Exception e) {
            throw new ABSerializationException(Translator.translate("abpErrorReadingFile") + filePath, e);
        }
    }

    private static byte[] jsonObjectToBytes(JsonObject jsonObject) throws ABSerializationException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1000);

        try (OutputStreamWriter writer = new OutputStreamWriter(baos, StandardCharsets.UTF_8)) {
            JsonWriter jsonWriter = new JsonWriter(writer);
            jsonWriter.start();

            for (String key : jsonObject.keySet()) {
                jsonWriter.writeKey(key);
                jsonWriter.writeValue(jsonObject.getNullable(key));
            }

            jsonWriter.end();
        } catch (UnsupportedEncodingException e) {
            throw new ABSerializationException(Translator.translate("abpErrorWritingFile"), e);
        } catch (IOException e) {
            throw new ABSerializationException(Translator.translate("abpErrorWritingFile"));
        }

        return baos.toByteArray();
    }

    public byte[] getDecoderKey() {
        return this.decoder.getEncodedKey();
    }
}
