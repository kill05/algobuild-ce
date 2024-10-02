package com.github.kill05.algobuildce.package_a.f;

import java.io.File;

public final class ABFiles {
    private static int a = -1;

    public static final String USER_NAME = System.getProperties().getProperty("user.name");

    public static final String AB_FOLDER_NAME = "AlgoBuild";
    public static final String AB_SECRET_FOLDER_NAME = ".algobuild";
    public static final String CORE_FOLDER_NAME = "core";
    public static final String CACHE_FOLDER_NAME = "algbcache";
    public static final String USER_HOME_PATH = System.getProperties().getProperty("user.home");

    public static final File AB_FOLDER = new File(USER_HOME_PATH, AB_FOLDER_NAME);
    public static final File AB_SECRET_FOLDER = new File(USER_HOME_PATH, AB_SECRET_FOLDER_NAME);
    public static final File CORE_FOLDER = new File(AB_SECRET_FOLDER, CORE_FOLDER_NAME);
    public static final File CACHE_FOLDER = new File(AB_SECRET_FOLDER, CACHE_FOLDER_NAME);

    public static int a() {
        int var0 = 0;
        int var1 = 0;
        a = 0;
        byte var2 = -1;
        File var3;
        if ((var3 = new File(getCoreFolder(), new String((new com.github.kill05.algobuildce.package_a.d.d()).createArray()))).exists()) {
            if (!var3.isDirectory() && var3.length() > 0L) {
                var2 = 1;
            }
        } else {
            var2 = 0;
        }

        switch (var2) {
            case -1:
                ++var1;
            case 0:
            default:
                break;
            case 1:
                ++var0;
        }

        var2 = -1;
        if ((var3 = new File(getCoreFolder(), new String((new com.github.kill05.algobuildce.package_a.d.e()).createArray()))).exists()) {
            if (!var3.isDirectory() && var3.length() > 0L) {
                var2 = 1;
            }
        } else {
            var2 = 0;
        }

        switch (var2) {
            case -1:
                ++var1;
            case 0:
            default:
                break;
            case 1:
                ++var0;
        }

        var2 = -1;
        if ((var3 = new File(getCoreFolder(), new String((new com.github.kill05.algobuildce.package_a.d.g()).createArray()))).exists()) {
            if (!var3.isDirectory() && var3.length() > 0L) {
                var2 = 1;
            }
        } else {
            var2 = 0;
        }

        switch (var2) {
            case -1:
                ++var1;
            case 0:
            default:
                break;
            case 1:
                ++var0;
        }

        var2 = -1;
        if ((var3 = new File(getCoreFolder(), "ExecModelCore.class")).exists()) {
            if (!var3.isDirectory() && var3.length() > 0L) {
                var2 = 1;
            }
        } else {
            var2 = 0;
        }

        switch (var2) {
            case -1:
                ++var1;
            case 0:
            default:
                break;
            case 1:
                ++var0;
        }

        var2 = -1;
        if ((var3 = new File(getCoreFolder(), new String((new com.github.kill05.algobuildce.package_a.d.c()).createArray()))).exists()) {
            if (!var3.isDirectory() && var3.length() > 0L) {
                var2 = 1;
            }
        } else {
            var2 = 0;
        }

        switch (var2) {
            case -1:
                ++var1;
            case 0:
            default:
                break;
            case 1:
                ++var0;
        }

        if (var0 == 0 && var1 == 0) {
            a = 1;
        } else if (var0 == 5) {
            a = 0;
        } else {
            a = 2;
        }

        return a;
    }

    private static String getUserHomePath() {
        return USER_HOME_PATH;
    }

    public static String getCacheFolderName() {
        return CACHE_FOLDER_NAME;
    }

    public static File getABFolder() {
        return AB_FOLDER;
    }

    public static File getABSecretFolder() {
        return AB_SECRET_FOLDER;
    }

    public static File getCoreFolder() {
        return CORE_FOLDER;
    }

    public static File getCacheFolder() {
        return CACHE_FOLDER;
    }
}
