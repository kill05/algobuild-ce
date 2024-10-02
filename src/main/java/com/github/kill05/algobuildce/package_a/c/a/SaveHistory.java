package com.github.kill05.algobuildce.package_a.c.a;

import com.github.kill05.algobuildce.json.JsonArray;
import com.github.kill05.algobuildce.package_a.i.Translator;
import com.github.kill05.algobuildce.json.JsonObject;

import java.text.SimpleDateFormat;
import java.util.Vector;

public final class SaveHistory {
    private Vector<SaveHistoryEntry> entries = null;
    private SaveHistoryEntry actualSessionSave = null;

    SaveHistory() {
    }

    public JsonObject serialize() {
        JsonObject var1 = new JsonObject();
        if (this.entries != null) {

            for (SaveHistoryEntry var2 : this.entries) {
                var1.a("saveHistoryItems", var2.serialize());
            }
        }

        if (this.actualSessionSave != null) {
            var1.a("saveHistoryItems", this.actualSessionSave.serialize());
        }

        return var1;
    }

    public void setActualSessionSave(String serial, String authorName, String fileName, String sizeDescription) {
        this.actualSessionSave = new SaveHistoryEntry(serial, authorName, System.currentTimeMillis(), fileName, sizeDescription);
    }

    public void deserialize(JsonObject var1) {
        JsonArray items = var1.getAsJsonArray("saveHistoryItems");
        if (items == null) return;

        this.entries = new Vector<>(items.size());
        this.actualSessionSave = null;

        for (int i = 0; i < items.size(); i++) {
            JsonObject jsonEntry = items.getAsJsonObject(i);
            SaveHistoryEntry entry = new SaveHistoryEntry();
            entry.deserialize(jsonEntry);
            this.entries.add(entry);
        }
    }

    public String toString() {
        return "ABESaveHistory [saveHistory=" + this.entries + ", actualSessionSave=" + this.actualSessionSave + "]";
    }

    public String b() {
        String var1 = null;
        (new SimpleDateFormat()).applyPattern("yyyy-MM-dd HH:mm:ss");
        if (this.actualSessionSave != null) {
            var1 = this.actualSessionSave.b() + "\n\n";
        }

        if (this.entries != null && !this.entries.isEmpty()) {
            if (var1 == null) {
                var1 = "";
            }

            for (int var2 = this.entries.size() - 1; var2 >= 0; --var2) {
                SaveHistoryEntry var3 = this.entries.get(var2);
                var1 = var1 + var3.b() + "\n";
            }
        }

        if (var1 == null) {
            var1 = Translator.translate("mnuHistoryIsEmpty");
        }

        return var1;
    }

    public void clear() {
        this.entries = null;
        this.actualSessionSave = null;
    }
}
