package com.github.kill05.algobuildce.package_a.k;

import java.awt.event.ActionEvent;
import java.util.Locale;
import javax.swing.AbstractAction;
import javax.swing.Icon;

final class j extends AbstractAction {

    private final ABFrameHolder a;

    j(ABFrameHolder var1, String var2, Icon var3) {
        super(var2, var3);
        this.a = var1;
    }

    @Override
    public void actionPerformed(ActionEvent var1) {
        this.a.a(Locale.ITALIAN);
    }
}
