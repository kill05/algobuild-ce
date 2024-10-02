package com.github.kill05.algobuildce.package_a.i;

import com.github.kill05.algobuildce.package_a.j.b.ABBasePanel;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import javax.swing.JComponent;

public final class d extends JComponent implements Printable {
    private Component a;

    public d(Component var1) {
        this.a = var1;
    }

    @Override
    public final int print(Graphics var1, PageFormat var2, int var3) {
        if (var3 > 0) {
            return 1;
        } else {
            Graphics2D var15 = (Graphics2D) var1;
            System.out.println("pageFormat.getImageableWidth=" + var2.getImageableWidth());
            System.out.println("pageFormat.getImageableHeight=" + var2.getImageableHeight());
            System.out.println("pageFormat.getImageableX=" + var2.getImageableX());
            System.out.println("pageFormat.getImageableY=" + var2.getImageableY());
            System.out.println("pageFormat.getWidth=" + var2.getWidth());
            System.out.println("pageFormat.getHeight=" + var2.getHeight());
            System.out.println("g2.getClipBounds=" + var15.getClipBounds());
            var15.translate(var2.getImageableX(), var2.getImageableY());
            double var7 = 1.0D;
            double var9 = 1.0D;
            if (var2.getImageableWidth() < (double) this.a.getWidth()) {
                var7 = 1.0D * var2.getImageableWidth() / (double) this.a.getWidth();
            }

            if (var2.getImageableHeight() < (double) this.a.getHeight()) {
                var9 = 1.0D * var2.getImageableHeight() / (double) this.a.getHeight();
            }

            double var5;
            if ((var5 = Math.min(var7, var9)) < 1.0D) {
                var15.transform(AffineTransform.getScaleInstance(var5, var5));
            }

            Component var12;
            boolean var10000;
            if (!((var12 = this.a) instanceof JComponent)) {
                var10000 = false;
            } else {
                JComponent var13;
                boolean var16 = (var13 = (JComponent) var12).isDoubleBuffered();
                var13.setDoubleBuffered(false);
                var10000 = var16;
            }

            boolean var14 = var10000;
            this.a(var1, (JComponent) this.a);
            Component var17 = this.a;
            boolean var11 = var14;
            var12 = var17;
            if (var17 instanceof JComponent) {
                ((JComponent) var12).setDoubleBuffered(var11);
            }

            return 0;
        }
    }

    public final void a(Graphics var1, JComponent var2) {
        if (var2 instanceof ABBasePanel) {
            ((ABBasePanel) var2).printComponent(var1);
        }

        Graphics2D var3;
        AffineTransform var4 = (var3 = (Graphics2D) var1).getTransform();

        for (int var5 = 0; var5 < var2.getComponentCount(); ++var5) {
            Component var6;
            if ((var6 = var2.getComponent(var5)) instanceof JComponent) {
                var3.translate(var6.getX(), var6.getY());
                this.a(var1, (JComponent) var6);
                var3.setTransform(var4);
            }
        }

    }
}
