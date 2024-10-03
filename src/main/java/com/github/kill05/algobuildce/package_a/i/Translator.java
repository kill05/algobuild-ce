package com.github.kill05.algobuildce.package_a.i;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class Translator {
    private static ResourceBundle italian = null;
    private static ResourceBundle english = null;
    private static ResourceBundle activeLanguage = null;
    private static Locale locale;

    public static Locale getLocale() {
        if (locale == null) {
            locale = Locale.getDefault();
        }

        return locale;
    }

    public static void setLocale(Locale locale) {
        if (locale != null && !locale.equals(Translator.locale)) {
            Translator.locale = locale;
            if (activeLanguage != null) {
                activeLanguage = null;
            }
        }

    }

    public static String translate(String translationKey) {
        String var1;
        try {
            if (english == null) {
                (english = ResourceBundle.getBundle("AlgoBuildMsg", Locale.ENGLISH)).getString("mnuFileExit");
            }

            if (italian == null) {
                (italian = ResourceBundle.getBundle("AlgoBuildMsg", Locale.ITALIAN)).getString("mnuFileExit");
            }

            if (activeLanguage == null) {
                if (getLocale().getLanguage().equals(Locale.ITALIAN.getLanguage())) {
                    activeLanguage = italian;
                } else {
                    activeLanguage = english;
                }
            }

            var1 = activeLanguage.getString(translationKey);
        } catch (MissingResourceException var2) {
            var1 = translationKey + " TO TRANSLATE";
            System.err.println(var1);
        } catch (NullPointerException var3) {
            var1 = "null given TO TRANSLATE";
        } catch (ClassCastException var4) {
            var1 = "improper type TO TRANSLATE";
        }

        return var1;
    }
}
