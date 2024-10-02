package com.github.kill05.algobuildce.package_a.k;

import javax.swing.*;

final class t implements Runnable {

    private final ABFrameHolder a;

    t(ABFrameHolder var1) {
        super();
        this.a = var1;
    }

    @Override
    public void run() {
        /*
        a.b().setJMenuBar(c.c(this.a));
        a.b().a(c.d(this.a));
        a.actionMap.getAction("mnuFileSaveAs").setEnabled(true);
        a.actionMap.getAction("execInstruction").setEnabled(true);
        a.actionMap.getAction("execOptions").setEnabled(true);
        if (c.b(this.a) != null && c.b(this.a).a() != null) {
            c.e(this.a).a("mnuEditUndo").setEnabled(c.b(this.a).a().m());
        }


        if (c.b(this.a) != null && c.b(this.a).a() != null) {
            c.e(this.a).a("mnuEditRedo").setEnabled(c.b(this.a).a().n());
        }

        if (c.b(this.a) != null && c.b(this.a).a() != null) {
            c.b(this.a).a().d();
        }

        c.b(this.a).revalidate();

         */
        JOptionPane.showMessageDialog(null, "DIO CANE", "TestInternet Connection", JOptionPane.INFORMATION_MESSAGE);
    }
}
