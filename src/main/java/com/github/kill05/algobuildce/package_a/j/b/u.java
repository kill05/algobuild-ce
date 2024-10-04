package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public final class u extends C_subclass {

    public u(p var1, D_subclass var2) {
        super(var2);
    }

    @Override
    public final void a(ABBasePanel var1, Graphics var2) {
        int var3 = var1.getWidth();
        int var4 = var1.getHeight();
        ABExecutable var5 = null;
        if (var1.program.getNextFragment() != null) {
            var5 = var1.program.getNextFragment().d();
        }

        var1.setLineColor(var2);
        if (var1.isHovered && var5 == null) {
            var1.setFillingColor(var2);
            var2.fillRect(0, 0, var3 - 1, var4 - 1);
            var1.setLineColor(var2);
            var2.drawRect(0, 0, var3 - 1, var4 - 1);
            String var8 = " * * * ";
            Rectangle2D var9;
            int var6 = (int) ((var9 = var2.getFontMetrics().getStringBounds(var8, var2)).getWidth() / 2.0D);
            int var10 = (int) Math.round(-var9.getHeight() / 2.0D - var9.getY());
            var3 = var3 / 2 - var6;
            int var7 = 1 * var1.centerY + var10;
            var2.drawString(var8, var3, var7);
        } else {
            var2.drawLine(0, 0, 0, var4);
        }
    }

    @Override
    public final void a(ABBasePanel var1) {
        var1.forceSize(new Dimension(10 * var1.centerX, 1 * var1.centerY));
    }
}
