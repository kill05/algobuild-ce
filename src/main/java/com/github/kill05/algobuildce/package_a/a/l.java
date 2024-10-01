package com.github.kill05.algobuildce.package_a.a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

final class l implements ActionListener {

    private final k a;

    l(k var1) {
        super();
        this.a = var1;
    }

    @Override
    public void actionPerformed(ActionEvent var1) {
        boolean var2 = k.a(this.a);
        String var3 = var2 ? "CONNESSIONE OK!" : "IMPOSSIBILE connettersi ad Internet.";
        JOptionPane.showMessageDialog(k.b(this.a), var3, "TestInternet Connection", JOptionPane.INFORMATION_MESSAGE);

        k.c(this.a).setEnabled(var2);
        k.d(this.a).setEnabled(var2);
        k.e(this.a).setEnabled(var2);
    }
}
