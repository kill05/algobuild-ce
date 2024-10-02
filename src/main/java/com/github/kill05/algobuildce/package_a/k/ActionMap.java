package com.github.kill05.algobuildce.package_a.k;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.TreeMap;

public final class ActionMap {

    private Map a = null;

    public ActionMap() {
        this.a = new TreeMap();
    }

    public final void a(String var1, Action var2) {
        this.a.put(var1, var2);
    }

    public final Action getAction(String var1) {
        Action var2 = null;
        if (var1 != null) {
            var2 = (Action) this.a.get(var1);
        } else {
            System.err.println("null ACTION for key:" + var1);
        }

        return var2;
    }

    public class A extends AbstractAction {
        ABFrameHolder a;

        A(ABFrameHolder var1, String var2) {
            super(var2);
            this.a = var1;
        }

        @Override
        public final void actionPerformed(ActionEvent var1) {
            this.a.q();
        }
    }

}
