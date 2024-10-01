package com.github.kill05.algobuildce.package_a.c.a;

import com.github.kill05.algobuildce.json.JSONArray;
import com.github.kill05.algobuildce.json.JSONObject;
import com.github.kill05.algobuildce.package_a.k.GlobalVariables;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;

public final class i {
    private Font a;
    private Font b;
    private Color c;
    private Color d;
    private Color e;
    private Color f;
    private int g;
    private Color h;
    private Color i;
    private Color j;
    private Stroke k;
    private int l;

    public i() {
        this.a();
    }

    public void a() {
        this.a = new Font("SansSerif", 0, (int) (12.0D * GlobalVariables.getFontZoomRatio()));
        this.b = new Font("SansSerif", 0, (int) (12.0D * GlobalVariables.getFontZoomRatio()));
        this.c = Color.WHITE;
        this.d = Color.WHITE;
        this.e = Color.GREEN;
        this.f = new Color(235, 235, 255);
        this.g = 1;
        this.h = Color.BLACK;
        this.i = Color.BLACK;
        this.j = Color.DARK_GRAY;
        this.o();
        this.l = 6;
    }

    public Font b() {
        return this.a;
    }

    public void a(Font var1) {
        this.a = var1;
    }

    public Font c() {
        return this.b;
    }

    public void b(Font var1) {
        this.b = var1;
    }

    public Color d() {
        return this.c;
    }

    public void a(Color var1) {
        this.c = var1;
    }

    public Color e() {
        return this.d;
    }

    public void b(Color var1) {
        this.d = var1;
    }

    public Color f() {
        return this.e;
    }

    public Color g() {
        return this.f;
    }

    public int h() {
        return this.g;
    }

    public void a(int var1) {
        if (var1 > 0) {
            this.g = var1;
            this.o();
        }

    }

    public Color i() {
        return this.h;
    }

    public void c(Color var1) {
        this.h = var1;
    }

    public Color j() {
        return this.i;
    }

    public Color k() {
        return this.j;
    }

    public Stroke l() {
        return this.k;
    }

    private void o() {
        this.k = new BasicStroke((float) ((double) this.g * GlobalVariables.getFontZoomRatio()), 1, 1);
    }

    public int m() {
        return this.l;
    }

    public void b(int var1) {
        if (var1 > 0) {
            this.l = var1;
        }

    }

    public JSONObject n() {
        JSONObject var1;
        (var1 = new JSONObject()).b("abopt", "ViewOptions");
        var1.b("codeFont", serializeFont(this.a));
        var1.b("consoleFont", serializeFont(this.b));
        var1.b("backgroundColor", serializeColor(this.c));
        var1.b("fillingColor", serializeColor(this.d));
        var1.b("fillingColorRunning", serializeColor(this.e));
        var1.b("fillingColorSelected", serializeColor(this.f));
        int var4 = this.g;
        String var3 = "lineWidth";
        var1.b(var3, var4);
        var1.b("lineColor", serializeColor(this.h));
        var1.b("lineColorRunning", serializeColor(this.i));
        var1.b("lineColorSelected", serializeColor(this.j));
        return var1;
    }

    public void a(JSONObject jsonObject) {
        if (jsonObject.f("abopt").equals("ViewOptions")) {
            Font var3 = deserializeFont(jsonObject.getAsArray("codeFont"));
            this.a = var3;
            var3 = deserializeFont(jsonObject.getAsArray("consoleFont"));
            this.b = var3;
            Color var4 = deserializeColor(jsonObject.getAsArray("backgroundColor"));
            this.c = var4;
            var4 = deserializeColor(jsonObject.getAsArray("fillingColor"));
            this.d = var4;
            var4 = deserializeColor(jsonObject.getAsArray("fillingColorRunning"));
            this.e = var4;
            var4 = deserializeColor(jsonObject.getAsArray("fillingColorSelected"));
            this.f = var4;
            var4 = deserializeColor(jsonObject.getAsArray("lineColor"));
            this.h = var4;
            var4 = deserializeColor(jsonObject.getAsArray("lineColorRunning"));
            this.i = var4;
            var4 = deserializeColor(jsonObject.getAsArray("lineColorSelected"));
            this.j = var4;
            this.a(jsonObject.getAsInt("lineWidth"));
        }

    }

    private static JSONArray serializeFont(Font font) {
        JSONArray var1 = new JSONArray();
        var1.a(font.getName());
        var1.add((int) ((double) font.getSize() * GlobalVariables.getFontZoomRatio()));
        var1.add(font.getStyle());
        return var1;
    }

    private static JSONArray serializeColor(Color color) {
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(color.getRed());
        jsonArray.add(color.getGreen());
        jsonArray.add(color.getBlue());
        jsonArray.add(color.getAlpha());
        return jsonArray;
    }

    //todo: fix opening file messing up the zoom
    @SuppressWarnings("MagicConstant")
    private static Font deserializeFont(JSONArray jsonArray) {
        String fontName = (String) jsonArray.a(0);
        int zoom = jsonArray.get(1);
        int style = jsonArray.get(2);
        return new Font(fontName, style, (int) ((double) zoom * GlobalVariables.getFontZoomRatio()));
    }

    private static Color deserializeColor(JSONArray jsonArray) {
        int r = jsonArray.get(0);
        int g = jsonArray.get(1);
        int b = jsonArray.get(2);
        int a = jsonArray.get(3);
        return new Color(r, g, b, a);
    }
}
