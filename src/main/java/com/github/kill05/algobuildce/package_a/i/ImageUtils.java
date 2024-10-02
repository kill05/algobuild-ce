package com.github.kill05.algobuildce.package_a.i;

import java.net.URL;
import java.util.Objects;
import javax.swing.ImageIcon;

public final class ImageUtils {

    public static ImageIcon loadImage(String var0) {
        ImageIcon var1 = null;

        try {
            URL url = ImageUtils.class.getClassLoader().getResource(var0);
            var1 = new ImageIcon(Objects.requireNonNull(url));
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return var1;
    }
}
