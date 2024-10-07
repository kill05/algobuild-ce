package com.github.kill05.algobuildce.frame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class A_innerclass extends AbstractAction {

    private final ABFrameHolder a;

    public A_innerclass(ABFrameHolder var1, String var2) {
        super(var2);
        this.a = var1;
    }

    public final void actionPerformed(ActionEvent var1) {
        this.a.q();
    }

}
