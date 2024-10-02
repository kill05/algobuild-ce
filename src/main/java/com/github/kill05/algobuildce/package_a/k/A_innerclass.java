package com.github.kill05.algobuildce.package_a.k;

import javax.swing.*;
import java.awt.event.ActionEvent;

class A_innerclass extends AbstractAction {

    private final ABFrameHolder a;

    A_innerclass(ABFrameHolder var1, String var2) {
        super(var2);
        this.a = var1;
    }

    public final void actionPerformed(ActionEvent var1) {
        this.a.q();
    }

}
