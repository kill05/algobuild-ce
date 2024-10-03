package com.github.kill05.algobuildce.package_a.j.b;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

public final class t extends C_subclass {

    public t(p var1, D_subclass var2) {
        super(var2);
    }

    @Override
    public void a(ABBasePanel var1, Graphics var2) {
    }

    @Override
    public void a(ABBasePanel var1) {
        e var6 = (e) var1;
        Dimension var2 = new Dimension(2 * var6.e, 0);
        Component[] components = var6.getComponents();

        for (Component value : components) {
            if (value instanceof ABBasePanel) {
                ((ABBasePanel) value).g();
            }

            Dimension var5;
            if ((var5 = value.getMinimumSize()).width > var2.width) {
                var2.width = var5.width;
            }

            var2.height += var5.height;
        }

        var6.a(var2);
        int i = 0;

        for (Component component : components) {
            Dimension dim = component.getMinimumSize();
            component.setLocation(0, i);
            i = (int) ((double) i + dim.getHeight());
        }

    }
}
