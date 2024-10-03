package com.github.kill05.algobuildce.package_a.c.a;

import com.github.kill05.algobuildce.package_a.c.b.p;
import com.github.kill05.algobuildce.package_a.c.b.q;
import com.github.kill05.algobuildce.package_a.f.ABFiles;
import com.github.kill05.algobuildce.package_a.f.ABProgramIO;
import com.github.kill05.algobuildce.package_a.f.ABUserData;
import com.github.kill05.algobuildce.package_a.f.ABConfigurator;
import com.github.kill05.algobuildce.package_a.i.Translator;
import com.github.kill05.algobuildce.package_a.k.ABFrameHolder;
import com.github.kill05.algobuildce.package_a.k.GlobalVariables;

import java.awt.Toolkit;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;

public class AlgoBuild {

    public static final String CE_VERSION = "1.0";

    private final Map<String, q> map;

    public AlgoBuild() {
        this.map = new TreeMap<>();
    }


    q a(String var1, int var2) {
        q var3 = new q(var1, var2);
        this.map.put(var3.j(), var3);
        return var3;
    }

    q a(q var1) {
        this.map.put(var1.j(), var1);
        return var1;
    }

    q a(String var1) {
        return this.map.get(var1);
    }

    void b(String var1) {
        this.map.remove(var1);
    }

    void c(String var1) {
        q var2 = this.map.remove(var1);
        this.map.put(var2.j(), var2);
    }

    public final Collection<q> a() {
        return this.map.values();
    }

    public final void b() {
        this.map.clear();
    }

    public final int c() {
        return this.map.size();
    }

    public final p d() {
        p var1 = new p();

        for (q value : this.map.values()) {
            var1.a(value.i());
        }

        return var1;
    }

    public static void init(String[] var0) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException var6) {
            var6.printStackTrace();
        }

        double var1 = 0.0D;

        int var3;
        for (var3 = 0; var3 < var0.length; ++var3) {
            if (var0[var3].toLowerCase().startsWith("fontzoom=")) {
                String var4 = var0[var3].substring(9);

                try {
                    if (var4.endsWith("%")) {
                        System.out.println("ZOOM %: " + var4);
                        var1 = Double.parseDouble(var4.substring(0, var4.length() - 1)) / 100.0D;
                    } else {
                        System.out.println("ZOOM FACTOR: " + var4);
                        var1 = Double.parseDouble(var4);
                    }

                    System.out.println("FONT ZOOM " + var1);
                    setFontZoomRatio(var1);
                    GlobalVariables.setFontZoomRatio(var1);
                } catch (NumberFormatException var5) {
                    System.out.println("INVALID NUMBER FORMAT: " + var4);
                }
            }
        }

        if (var1 == 0.0D && (var1 = e()) != 0.0D && var1 != 1.0D) {
            GlobalVariables.setFontZoomRatio(var1);
        }

        int var11 = 0;

        do {
            ++var11;
            if ((var3 = ABFiles.a()) != 0) {
                String var10;
                if (var3 == 1) {
                    var10 = Translator.translate("abpFirstRunQuestion");
                    if (JOptionPane.showConfirmDialog(null, var10, "AlgoBuild", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                        ABConfigurator.runFirstConfiguration();
                        var3 = -1;
                    } else {
                        System.exit(var3);
                    }
                }

                if (var3 == 2) {
                    var10 = Translator.translate("abpConfigurationWrong");
                    JOptionPane.showMessageDialog(null, var10, "AlgoBuild", JOptionPane.ERROR_MESSAGE);
                    System.exit(var3);
                }
            } else {
                // Initialize singletons
                SwingUtilities.invokeLater(() -> {
                    ABUserData.getInstance();
                    ABProgramIO.getInstance();
                    ABFrameHolder.getInstance();
                });
            }
        } while (var3 == -1 && var11 < 2);

    }

    public static void setFontZoomRatio(double var0) {
        if (var0 < 0.1D || var0 > 10.0D) {
            System.out.println("INVALID ZOOM RATIO: " + var0);
        }

        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        Enumeration<Object> var3 = defaults.keys();

        while (var3.hasMoreElements()) {
            Object var4 = var3.nextElement();
            Object var5;
            if ((var5 = defaults.get(var4)) instanceof FontUIResource) {
                FontUIResource var6 = (FontUIResource) var5;
                var6 = new FontUIResource(var6.getName(), var6.getStyle(), (int) ((double) var6.getSize() * var0));
                defaults.put(var4, var6);
            }
        }

    }

    public static double e() {
        double var0 = 1.0D;
        double var3 = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int var2 = Toolkit.getDefaultToolkit().getScreenResolution();
        System.out.println("SCREEN HEIGHT = " + var3);
        System.out.println("SCREEN RESOLUTION dpi = " + var2);
        UIDefaults var5;
        Object var6;
        if ((var6 = (var5 = UIManager.getLookAndFeelDefaults()).get("Panel.font")) != null) {
            FontUIResource var12 = (FontUIResource) var6;
            double var9;
            if ((var9 = 25.4D / (double) var2 * (double) var12.getSize()) < 3.0D) {
                System.out.println("ACTUAL ROW SIZE (mm) " + var9);
                var0 = var3 / 64.0D / (double) var12.getSize();
                System.out.println("HIGH RESOLUTION DISPLAY - APPLY ZOOM FACTOR: " + var0);
            }
        }

        if (var0 != 1.0D) {
            Enumeration<Object> var13 = var5.keys();

            while (var13.hasMoreElements()) {
                Object var14 = var13.nextElement();
                Object var10;
                if ((var10 = var5.get(var14)) instanceof FontUIResource) {
                    FontUIResource var11 = (FontUIResource) var10;
                    var11 = new FontUIResource(var11.getName(), var11.getStyle(), (int) ((double) var11.getSize() * var0));
                    var5.put(var14, var11);
                }
            }
        }

        return var0;
    }

    public static JButton createButton(String label) {
        char var1 = 0;
        if (label.contains("&&")) {
            int var2;
            if ((var2 = label.indexOf("&&")) + 2 < label.length()) {
                var1 = label.charAt(var2 + 2);
            }

            label = label.replace("&&", "");
        }

        JButton button = new JButton(label);
        if (var1 != 0) {
            button.setMnemonic(var1);
        }

        return button;
    }
}
