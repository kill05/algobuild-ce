package com.github.kill05.algobuildce;

import com.github.kill05.algobuildce.package_a.c.a.AlgoBuild;

import java.io.File;

public class Main {

    public static void main(String[] var0) {
        if ((new File(System.getProperty("java.class.path"))).isFile()) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException ignored) {
            }
        }

        AlgoBuild.init(var0);
    }
}
