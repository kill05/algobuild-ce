package com.github.kill05.algobuildce.package_a.c.a;

import com.github.kill05.algobuildce.json.JsonObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class SaveHistoryEntry {
    private String serial;
    private String authorName;
    private long saveTime;
    private String fileName;
    private String sizeDescription;

    public SaveHistoryEntry() {
        this.serial = null;
        this.authorName = null;
        this.saveTime = 0L;
        this.fileName = null;
        this.sizeDescription = null;
    }

    public SaveHistoryEntry(String serial, String authorName, long saveTime, String fileName, String sizeDescription) {
        this.serial = serial;
        this.authorName = authorName;
        this.saveTime = saveTime;
        this.fileName = fileName;
        this.sizeDescription = sizeDescription;
    }

    public JsonObject serialize() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("s", this.serial);
        jsonObject.put("a", this.authorName);
        jsonObject.put("t", this.saveTime);
        jsonObject.put("f", this.fileName);
        jsonObject.put("z", this.sizeDescription);
        return jsonObject;
    }

    //todo: check if package_a is wrong
    public void deserialize(JsonObject jsonObject) {
        this.serial = jsonObject.getAsString("s");
        this.authorName = jsonObject.getAsString("a");
        this.saveTime = jsonObject.getAsLong("t", 0L);
        this.fileName = jsonObject.getAsString("f");
        this.sizeDescription = jsonObject.getAsString("z");
    }

    public String toString() {
        return "SaveHistoryEntry [serial=" + this.serial +
                ", authorName=" + this.authorName +
                ", saveTime=" + this.saveTime +
                ", fileName=" + this.fileName +
                ", sizeDescription=" + this.sizeDescription +
                "]";
    }

    public String b() {
        String var1 = "";
        SimpleDateFormat var2;
        (var2 = new SimpleDateFormat()).applyPattern("yyyy-MM-dd HH:mm:ss");
        Date var3 = new Date(this.saveTime);
        String var4 = var2.format(var3);
        if (this.authorName != null && !this.authorName.isEmpty()) {
            var1 = var1 + "u:" + this.authorName;
        }

        if (this.serial != null && !this.serial.isEmpty()) {
            var1 = var1 + "  /  s:" + this.serial;
        }

        if (!var4.isEmpty()) {
            var1 = var1 + "  /  d:" + var4;
        }

        if (this.fileName != null && !this.fileName.isEmpty()) {
            var1 = var1 + " fn:" + this.fileName;
        }

        if (this.sizeDescription != null && !this.sizeDescription.isEmpty()) {
            var1 = var1 + " fs:" + this.sizeDescription;
        }

        return var1;
    }
}
