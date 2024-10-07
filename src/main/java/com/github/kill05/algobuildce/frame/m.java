package com.github.kill05.algobuildce.frame;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

final class m extends AbstractAction {

    private final ABFrameHolder a;

    m(ABFrameHolder var1, String var2) {
        super(var2);
        this.a = var1;
    }

    public void actionPerformed(ActionEvent var1) {
        this.a.s();
    }

}
