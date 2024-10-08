package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.b.q;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public final class B_subclass extends C_subclass {
    private String b;
    private String c;
    private int d;
    private int e;
    private int f;

    public B_subclass(p var1, D_subclass var2) {
        super(var2);
    }

    @Override
    public final void a(ABBasePanel var1, Graphics var2) {
        ABFlowChartPanel var3;
        int var4 = (var3 = (ABFlowChartPanel)var1).getWidth();
        int var5 = var3.getHeight();
        var2.setColor(var3.program.getViewOptions().getBackgroundColor());
        int var6 = this.f;
        var2.setColor(var3.program.getViewOptions().getBackgroundColor());
        var2.fillRect(0, 0, var4, var5);
        var3.setFillingColor(var2, 2);
        var2.fillRect(var3.centerX, var3.centerY, var3.centerX, 6 * var3.centerY + var3.a.getHeight());
        var3.setFillingColor(var2, 0);
        var2.fillRect(var3.centerX, var3.centerY, var4, 3 * var3.centerY);
        var1.setLineColor(var2);
        var2.drawString(this.b, var3.centerX, var6);
        var6 += 3 * var1.centerY + var3.a.getHeight();
        var3.setFillingColor(var2, 1);
        var2.fillRect(var3.centerX, var6 - 2 * var3.centerY, var4, 3 * var3.centerY);
        var3.setLineColor(var2);
        var2.drawString(this.c, var3.centerX, var6);
    }

    @Override
    public final void a(ABBasePanel var1) {
        q var2;
        int var3;
        ABFlowChartPanel var5;
        if ((var2 = (q)(var5 = (ABFlowChartPanel)var1).getExecutable()).m() == 2) {
            this.b = "PROC " + var2.j() + "(";

            for(var3 = 0; var3 < var2.k(); ++var3) {
                if (var3 > 0) {
                    this.b = this.b + ", ";
                }

                this.b = this.b + var2.e(var3);
            }

            this.b = this.b + ")";
            this.c = "RET";
        } else if (var2.m() == 3) {
            this.b = "FUNC " + var2.j() + "(";

            for(var3 = 0; var3 < var2.k(); ++var3) {
                if (var3 > 0) {
                    this.b = this.b + ", ";
                }

                this.b = this.b + var2.e(var3);
            }

            this.b = this.b + ")";
            this.c = "RET " + var2.l();
        } else {
            this.b = "PROGRAM " + var2.j();
            this.c = "END";
        }

        var5.a.g();
        FontMetrics var9 = var5.getFontMetrics(var5.getFont());
        this.d = 0;
        this.e = 3 * var5.centerY;
        Rectangle2D var6 = var9.getStringBounds(this.b, var5.getGraphics());
        this.f = 3 * var5.centerY;
        Dimension var10 = new Dimension((int)var6.getWidth(), this.e + 2 * var5.centerY);
        this.d = (int)var6.getWidth();
        Dimension var7 = var5.a.getMinimumSize();
        var10.width = Math.max(var10.width, var7.width + 3 * var5.centerX) + 2 * var5.centerX;
        var10.height += var7.height + 3 * var5.centerY;
        var5.forceSize(var10);
        int var8 = 3 * var5.centerX;
        var5.a.setLocation(var8, this.e + var5.centerY);
        var5.revalidate();
        this.a(new Rectangle(this.d, this.e));
        if (this.a != null && this.a instanceof ABFlowChartPanel) {
            ((ABFlowChartPanel)this.a).a(new Rectangle(0, var10.height - 2 * var5.centerY, this.d, 2 * var5.centerY));
        }

    }
}

