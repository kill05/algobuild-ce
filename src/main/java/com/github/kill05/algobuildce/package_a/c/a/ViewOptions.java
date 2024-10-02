package com.github.kill05.algobuildce.package_a.c.a;

import com.github.kill05.algobuildce.json.JsonArray;
import com.github.kill05.algobuildce.json.JsonObject;
import com.github.kill05.algobuildce.package_a.k.GlobalVariables;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;

public final class ViewOptions {
    private Font codeFont;
    private Font consoleFont;
    private Color backgroundColor;
    private Color fillingColor;
    private Color fillingColorRunning;
    private Color fillingColorSelected;
    private int lineWidth;
    private Color lineColor;
    private Color lineColorRunning;
    private Color lineColorSelected;
    private Stroke stroke;
    private int l;

    public ViewOptions() {
        this.a();
    }

    public void a() {
        this.codeFont = new Font("SansSerif", Font.PLAIN, (int) (12.0D * GlobalVariables.getFontZoomRatio()));
        this.consoleFont = new Font("SansSerif", Font.PLAIN, (int) (12.0D * GlobalVariables.getFontZoomRatio()));
        this.backgroundColor = Color.WHITE;
        this.fillingColor = Color.WHITE;
        this.fillingColorRunning = Color.GREEN;
        this.fillingColorSelected = new Color(235, 235, 255);
        this.lineWidth = 1;
        this.lineColor = Color.BLACK;
        this.lineColorRunning = Color.BLACK;
        this.lineColorSelected = Color.DARK_GRAY;
        this.updateLineStroke();
        this.l = 6;
    }

    public Font getCodeFont() {
        return this.codeFont;
    }

    public void setCodeFont(Font var1) {
        this.codeFont = var1;
    }

    public Font getConsoleFont() {
        return this.consoleFont;
    }

    public void setConsoleFont(Font var1) {
        this.consoleFont = var1;
    }

    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(Color var1) {
        this.backgroundColor = var1;
    }

    public Color getFillingColor() {
        return this.fillingColor;
    }

    public void setFillingColor(Color var1) {
        this.fillingColor = var1;
    }

    public Color getFillingColorRunning() {
        return this.fillingColorRunning;
    }

    public Color getFillingColorSelected() {
        return this.fillingColorSelected;
    }

    public int getLineWidth() {
        return this.lineWidth;
    }

    public void setLineWidth(int lineWidth) {
        if (lineWidth > 0) {
            this.lineWidth = lineWidth;
            this.updateLineStroke();
        }
    }

    public Color getLineColor() {
        return this.lineColor;
    }

    public void setLineColor(Color var1) {
        this.lineColor = var1;
    }

    public Color getLineColorRunning() {
        return this.lineColorRunning;
    }

    public Color getLineColorSelected() {
        return this.lineColorSelected;
    }

    public Stroke getStroke() {
        return this.stroke;
    }

    private void updateLineStroke() {
        this.stroke = new BasicStroke((float) ((double) this.lineWidth * GlobalVariables.getFontZoomRatio()), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    }

    public int m() {
        return this.l;
    }

    public void b(int var1) {
        if (var1 > 0) {
            this.l = var1;
        }

    }

    public JsonObject serialize() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("abopt", "ViewOptions");
        jsonObject.put("codeFont", serializeFont(this.codeFont));
        jsonObject.put("consoleFont", serializeFont(this.consoleFont));
        jsonObject.put("backgroundColor", serializeColor(this.backgroundColor));
        jsonObject.put("fillingColor", serializeColor(this.fillingColor));
        jsonObject.put("fillingColorRunning", serializeColor(this.fillingColorRunning));
        jsonObject.put("fillingColorSelected", serializeColor(this.fillingColorSelected));
        jsonObject.put("lineWidth", this.lineWidth);
        jsonObject.put("lineColor", serializeColor(this.lineColor));
        jsonObject.put("lineColorRunning", serializeColor(this.lineColorRunning));
        jsonObject.put("lineColorSelected", serializeColor(this.lineColorSelected));
        return jsonObject;
    }

    public void deserializeOptions(JsonObject jsonObject) {
        if (jsonObject.getAsString("abopt").equals("ViewOptions")) {
            codeFont = deserializeFont(jsonObject.getAsArray("codeFont"));
            consoleFont = deserializeFont(jsonObject.getAsArray("consoleFont"));

            backgroundColor = deserializeColor(jsonObject.getAsArray("backgroundColor"));

            fillingColor = deserializeColor(jsonObject.getAsArray("fillingColor"));
            fillingColorRunning = deserializeColor(jsonObject.getAsArray("fillingColorRunning"));
            fillingColorSelected = deserializeColor(jsonObject.getAsArray("fillingColorSelected"));

            this.setLineWidth(jsonObject.getAsInt("lineWidth"));
            lineColor = deserializeColor(jsonObject.getAsArray("lineColor"));
            lineColorRunning = deserializeColor(jsonObject.getAsArray("lineColorRunning"));
            lineColorSelected = deserializeColor(jsonObject.getAsArray("lineColorSelected"));
        }

    }

    private static JsonArray serializeFont(Font font) {
        JsonArray var1 = new JsonArray();
        var1.add(font.getName());
        var1.add((int) ((double) font.getSize() * GlobalVariables.getFontZoomRatio()));
        var1.add(font.getStyle());
        return var1;
    }

    //todo: fix opening file messing up the zoom
    @SuppressWarnings("MagicConstant")
    private static Font deserializeFont(JsonArray jsonArray) {
        String fontName = (String) jsonArray.get(0);
        int zoom = jsonArray.getAsInt(1);
        int style = jsonArray.getAsInt(2);
        return new Font(fontName, style, (int) ((double) zoom * GlobalVariables.getFontZoomRatio()));
    }


    private static JsonArray serializeColor(Color color) {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(color.getRed());
        jsonArray.add(color.getGreen());
        jsonArray.add(color.getBlue());
        jsonArray.add(color.getAlpha());
        return jsonArray;
    }

    private static Color deserializeColor(JsonArray jsonArray) {
        int r = jsonArray.getAsInt(0);
        int g = jsonArray.getAsInt(1);
        int b = jsonArray.getAsInt(2);
        int a = jsonArray.getAsInt(3);
        return new Color(r, g, b, a);
    }
}
