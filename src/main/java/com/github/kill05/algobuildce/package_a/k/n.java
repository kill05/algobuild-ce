package com.github.kill05.algobuildce.package_a.k;

import com.github.kill05.algobuildce.package_a.a.RegisterUserDialog;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

final class n extends AbstractAction {

    n(ABFrameHolder var1, String var2) {
        super(var2);
    }

    @Override
    public void actionPerformed(ActionEvent var1) {
        RegisterUserDialog.open();
    }
}
