package com.github.kill05.algobuildce.package_a.a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

final class l implements ActionListener {

    private final RegisterUserDialog a;

    l(RegisterUserDialog var1) {
        super();
        this.a = var1;
    }

    @Override
    public void actionPerformed(ActionEvent var1) {
        boolean var2 = RegisterUserDialog.a(this.a);
        String var3 = var2 ? "CONNESSIONE OK!" : "IMPOSSIBILE connettersi ad Internet.";
        JOptionPane.showMessageDialog(RegisterUserDialog.b(this.a), var3, "TestInternet Connection", JOptionPane.INFORMATION_MESSAGE);

        RegisterUserDialog.c(this.a).setEnabled(var2);
        RegisterUserDialog.d(this.a).setEnabled(var2);
        RegisterUserDialog.e(this.a).setEnabled(var2);
    }
}
