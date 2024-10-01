package package_a.a;

import package_a.i.Translator;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class k extends JDialog implements ActionListener {
    private Frame a;
    private JTextField b;
    private JTextField c;
    private JButton d;
    private JButton e;
    private JButton f;

    private k(Frame var1) {
        super(var1, Translator.translate("abedAuthorRegistrationTitle"));
        this.a = var1;
        JPanel var4;
        (var4 = new JPanel()).setLayout(new GridBagLayout());
        this.setLocation(100, 100);
        this.setResizable(false);
        GridBagConstraints var2;
        (var2 = new GridBagConstraints()).anchor = 13;
        this.f = new JButton("Test Internet Connection");
        this.f.addActionListener(new l(this));
        this.b = new JTextField(30);
        Dimension var3 = this.b.getPreferredSize();
        var2.insets.left = (int) (var3.getHeight() / 2.0D);
        var2.insets.right = (int) (var3.getHeight() / 2.0D);
        var2.insets.top = (int) (var3.getHeight() / 4.0D);
        var2.insets.bottom = (int) (var3.getHeight() / 4.0D);
        var2.gridx = 0;
        var2.gridy = 0;
        var4.add(new JLabel("Network Test"), var2);
        var2.gridx = 1;
        var4.add(this.f, var2);
        var2.gridx = 0;
        var2.gridy = 1;
        var4.add(new JLabel(Translator.translate("abedAuthorRegistrationName")), var2);
        var2.gridx = 1;
        var4.add(this.b, var2);
        this.c = new JTextField(30);
        var2.gridx = 0;
        ++var2.gridy;
        var4.add(new JLabel(Translator.translate("abedAuthorRegistrationSubsCode")), var2);
        var2.gridx = 1;
        var4.add(this.c, var2);
        this.d = package_a.c.a.a.d(Translator.translate("dialogButtonOK"));
        this.d.addActionListener(this);
        this.e = package_a.c.a.a.d(Translator.translate("dialogButtonCancel"));
        this.e.addActionListener(this);
        JPanel var5;
        (var5 = new JPanel()).setLayout(new GridLayout(1, 2, 10, 10));
        var5.add(this.d);
        var5.add(this.e);
        var2.gridx = 1;
        ++var2.gridy;
        var4.add(var5, var2);
        this.setContentPane(var4);
        this.b.setEnabled(false);
        this.c.setEnabled(false);
        this.d.setEnabled(false);
        this.pack();
        this.setVisible(true);
    }

    //todo: remove registration check
    @Override
    public final void actionPerformed(ActionEvent var1) {
        Object var4;
        if ((var4 = var1.getSource()) == this.d) {
            String var5 = this.b.getText();
            String var2 = this.c.getText();
            if (var5 != null && var5.length() > 0 && !var5.contains("'") && !var5.contains("\"") && var2 != null && var2.length() > 0 && !var2.contains("'") && !var2.contains("\"")) {
                if (package_a.f.d.b(var5, var2) != null) {
                    JOptionPane.showMessageDialog(null, "REGISTRATO " + var5 + "   " + var2);
                    package_a.k.c.a().a("mnuAuthorRegistration", false);
                }

                this.setVisible(false);
                return;
            }
        } else if (var4 == this.e) {
            this.setVisible(false);
        }

    }

    public static void a() {
        new k(package_a.k.c.a().b());
    }

    private static boolean b() {
        boolean var0 = false;

        try {
            (new URL("https://algobuild.com")).openConnection().connect();
            System.out.println("Internet is connected");
            var0 = true;
        } catch (MalformedURLException var2) {
            System.out.println("Internet is not connected");
        } catch (IOException var3) {
            System.out.println("Internet is not connected");
        }

        return var0;
    }

    // $FF: synthetic method
    static boolean a(k var0) {
        return b();
    }

    // $FF: synthetic method
    static Frame b(k var0) {
        return var0.a;
    }

    // $FF: synthetic method
    static JTextField c(k var0) {
        return var0.b;
    }

    // $FF: synthetic method
    static JTextField d(k var0) {
        return var0.c;
    }

    // $FF: synthetic method
    static JButton e(k var0) {
        return var0.d;
    }
}
