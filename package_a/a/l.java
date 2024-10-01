package package_a.a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

final class l implements ActionListener {
    // $FF: synthetic field
    private k a;

    l(k var1) {
        super();
        this.a = var1;
    }

    @Override
    public final void actionPerformed(ActionEvent var1) {
        boolean var2;
        String var3;
        if (var2 = k.a(this.a)) {
            var3 = "CONNESSIONE OK!";
            JOptionPane.showMessageDialog(k.b(this.a), var3, "TestInternet Connection", 1);
        } else {
            var3 = "IMPOSSIBILE connettersi ad Internet.";
            JOptionPane.showMessageDialog(k.b(this.a), var3, "TestInternet Connection", 0);
        }

        k.c(this.a).setEnabled(var2);
        k.d(this.a).setEnabled(var2);
        k.e(this.a).setEnabled(var2);
    }
}
