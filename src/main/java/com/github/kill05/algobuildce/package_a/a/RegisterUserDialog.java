package com.github.kill05.algobuildce.package_a.a;

import com.github.kill05.algobuildce.package_a.c.a.AlgoBuild;
import com.github.kill05.algobuildce.package_a.f.UserRegisterer;
import com.github.kill05.algobuildce.package_a.i.Translator;
import com.github.kill05.algobuildce.package_a.k.ABFrameHolder;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class RegisterUserDialog extends JDialog implements ActionListener {

    private Frame a;
    private JTextField usernameField;
    private JTextField activationKeyField;
    private JButton okButton;
    private JButton cancelButton;
    private JButton f;

    private RegisterUserDialog(Frame var1) {
        super(var1, Translator.translate("abedAuthorRegistrationTitle"));
        this.a = var1;
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        this.setLocation(100, 100);
        this.setResizable(false);
        GridBagConstraints var2;
        (var2 = new GridBagConstraints()).anchor = 13;
        this.f = new JButton("Test Internet Connection");
        this.f.addActionListener(new l(this));
        this.usernameField = new JTextField(30);
        Dimension var3 = this.usernameField.getPreferredSize();
        var2.insets.left = (int) (var3.getHeight() / 2.0D);
        var2.insets.right = (int) (var3.getHeight() / 2.0D);
        var2.insets.top = (int) (var3.getHeight() / 4.0D);
        var2.insets.bottom = (int) (var3.getHeight() / 4.0D);
        var2.gridx = 0;
        var2.gridy = 0;
        panel.add(new JLabel("Network Test"), var2);
        var2.gridx = 1;
        panel.add(this.f, var2);
        var2.gridx = 0;
        var2.gridy = 1;
        panel.add(new JLabel(Translator.translate("abedAuthorRegistrationName")), var2);
        var2.gridx = 1;
        panel.add(this.usernameField, var2);
        this.activationKeyField = new JTextField(30);
        var2.gridx = 0;
        ++var2.gridy;
        panel.add(new JLabel(Translator.translate("abedAuthorRegistrationSubsCode")), var2);
        var2.gridx = 1;
        panel.add(this.activationKeyField, var2);
        this.okButton = AlgoBuild.createButton(Translator.translate("dialogButtonOK"));
        this.okButton.addActionListener(this);
        this.cancelButton = AlgoBuild.createButton(Translator.translate("dialogButtonCancel"));
        this.cancelButton.addActionListener(this);
        JPanel var5;
        (var5 = new JPanel()).setLayout(new GridLayout(1, 2, 10, 10));
        var5.add(this.okButton);
        var5.add(this.cancelButton);
        var2.gridx = 1;
        ++var2.gridy;
        panel.add(var5, var2);
        this.setContentPane(panel);
        this.usernameField.setEnabled(false);
        this.activationKeyField.setEnabled(false);
        this.okButton.setEnabled(false);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == this.okButton) {
            String username = this.usernameField.getText();
            String activationKey = this.activationKeyField.getText();

            if (username != null && !username.isEmpty() && !username.contains("'") && !username.contains("\"") &&
                    activationKey != null && !activationKey.isEmpty() && !activationKey.contains("'") && !activationKey.contains("\"")
            ) {
                if (UserRegisterer.registerUser(username, activationKey) != null) {
                    JOptionPane.showMessageDialog(null, "REGISTRATO " + username + "   " + activationKey);
                    ABFrameHolder.getInstance().setActionEnabled("mnuAuthorRegistration", false);
                }

                this.setVisible(false);
            }
        } else if (source == this.cancelButton) {
            this.setVisible(false);
        }

    }

    public static void open() {
        new RegisterUserDialog(ABFrameHolder.getInstance().getFrame());
    }

    private static boolean checkConnection() {
        boolean var0 = false;

        try {
            new URI("https://algobuild.com").toURL().openConnection().connect();
            System.out.println("Internet is connected");
            var0 = true;
        } catch (IOException e) {
            System.out.println("Internet is not connected");
        } catch (URISyntaxException e) {
            throw new AssertionError(e);
        }

        return var0;
    }

    // $FF: synthetic method
    static boolean a(RegisterUserDialog var0) {
        return checkConnection();
    }

    // $FF: synthetic method
    static Frame b(RegisterUserDialog var0) {
        return var0.a;
    }

    // $FF: synthetic method
    static JTextField c(RegisterUserDialog var0) {
        return var0.usernameField;
    }

    // $FF: synthetic method
    static JTextField d(RegisterUserDialog var0) {
        return var0.activationKeyField;
    }

    // $FF: synthetic method
    static JButton e(RegisterUserDialog var0) {
        return var0.okButton;
    }
}
