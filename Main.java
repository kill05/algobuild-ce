import package_a.c.a.a;

import java.io.File;

public class Main {

    public static void main(String[] var0) {
        if ((new File(System.getProperty("java.class.path"))).isFile()) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException ignored) {
            }
        }

        a.a(var0);
    }
}
