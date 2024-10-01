package com.github.kill05.algobuildce.package_a.k;

import java.awt.*;

public final class GlobalVariables {
    public static Color color;
    private static double fontZoom;

    static {
        color = Color.white;
        fontZoom = 1.0;
        //String[] var10000 = new String[]{"AB0075"};
    }

    public static double getFontZoomRatio() {
        return fontZoom;
    }

    public static void setFontZoomRatio(double zoom) {
        fontZoom = Math.min(Math.max(zoom, 0.1), 10.0);
    }
}
