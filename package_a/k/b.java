package package_a.k;

import java.awt.*;

public final class b {
    public static Color a;
    private static double b;

    static {
        a = Color.white;
        //String[] var10000 = new String[]{"AB0075"};
        b = 1.0;
    }

    public static double a() {
        return b;
    }

    public static void a(double var0) {
        if (var0 < 0.1) {
            var0 = 0.1;
        } else if (var0 > 10.0) {
            var0 = 10.0;
        }

        b = var0;
    }
}
