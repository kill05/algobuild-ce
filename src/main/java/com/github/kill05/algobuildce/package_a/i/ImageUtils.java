package com.github.kill05.algobuildce.package_a.i;

import javax.swing.*;
import java.net.URL;
import java.util.Objects;

public final class ImageUtils {

    public static ImageIcon loadImage(String resource) {
        ImageIcon var1 = null;

        try {
            URL url = ImageUtils.class.getClassLoader().getResource(resource);
            var1 = new ImageIcon(Objects.requireNonNull(url));
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return var1;
    }
}
