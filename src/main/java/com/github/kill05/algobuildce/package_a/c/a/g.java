package com.github.kill05.algobuildce.package_a.c.a;

import com.github.kill05.algobuildce.json.JSONArray;
import com.github.kill05.algobuildce.package_a.i.Translator;
import com.github.kill05.algobuildce.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Vector;

public final class g {
    private Vector<h> a = null;
    private h b = null;

    g() {
    }

    public JSONObject a() {
        JSONObject var1 = new JSONObject();
        if (this.a != null) {
            Iterator var3 = this.a.iterator();

            while (var3.hasNext()) {
                h var2 = (h) var3.next();
                var1.a("saveHistoryItems", var2.a());
            }
        }

        if (this.b != null) {
            var1.a("saveHistoryItems", this.b.a());
        }

        return var1;
    }

    public void a(String var1, String var2, String var3, String var4) {
        this.b = new h(this, var1, var2, System.currentTimeMillis(), var3, var4);
    }

    public void a(JSONObject var1) {
        JSONArray var5;
        if ((var5 = var1.d("saveHistoryItems")) != null) {
            int var2 = var5.size();
            this.a = new Vector<>(var2);
            this.b = null;

            for (var2 = 0; var2 < var5.size(); ++var2) {
                JSONObject var3 = var5.c(var2);
                h var4;
                (var4 = new h(this)).a(var3);
                this.a.add(var4);
            }
        }

    }

    public String toString() {
        return "ABESaveHistory [saveHistory=" + this.a + ", actualSessionSave=" + this.b + "]";
    }

    public String b() {
        String var1 = null;
        (new SimpleDateFormat()).applyPattern("yyyy-MM-dd HH:mm:ss");
        if (this.b != null) {
            var1 = this.b.b() + "\n\n";
        }

        if (this.a != null && !this.a.isEmpty()) {
            if (var1 == null) {
                var1 = "";
            }

            for (int var2 = this.a.size() - 1; var2 >= 0; --var2) {
                h var3 = (h) this.a.get(var2);
                var1 = var1 + var3.b() + "\n";
            }
        }

        if (var1 == null) {
            var1 = Translator.translate("mnuHistoryIsEmpty");
        }

        return var1;
    }

    public void c() {
        this.a = null;
        this.b = null;
    }
}
