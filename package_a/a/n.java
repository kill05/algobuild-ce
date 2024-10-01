package package_a.a;

import package_a.i.Translator;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// settings class
public final class n extends JDialog implements ActionListener, ChangeListener {
   private JCheckBox a;
   private JCheckBox b;
   private JSpinner c;
   private package_a.c.a.b d;

   public n(Frame var1, package_a.c.a.b var2) {
      super(var1, Translator.translate("abedDialogRunOptionsTitle"));
      this.d = var2;
      JPanel var4;
      (var4 = new JPanel()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      this.setContentPane(var4);
      var4.setLayout(new GridBagLayout());
      this.setVisible(false);
      this.setLocation(100, 100);
      this.setResizable(false);
      GridBagConstraints var5;
      (var5 = new GridBagConstraints()).anchor = 21;
      var5.weightx = 1.0D;
      this.a = new JCheckBox();
      this.a.setSelected(this.d.r().a());
      this.a.addActionListener(this);
      var5.gridwidth = 1;
      var5.gridx = 0;
      var5.gridy = 0;
      this.add(new JLabel(Translator.translate("execTrace")), var5);
      var5.gridx = 1;
      this.add(this.a, var5);
      this.b = new JCheckBox();
      this.b.setSelected(this.d.r().b());
      this.b.addActionListener(this);
      var5.gridwidth = 1;
      var5.gridx = 0;
      var5.gridy = 1;
      this.add(new JLabel(Translator.translate("execOneStep")), var5);
      var5.gridx = 1;
      this.add(this.b, var5);
      Integer[] var6 = new Integer[]{5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000};
      SpinnerListModel var3 = new SpinnerListModel(var6);
      this.c = new JSpinner(var3);
      this.c.setValue(var6[9]);
      this.c.getPreferredSize();
      this.c.setValue(var6[7]);
      this.c.addChangeListener(this);
      var5.gridwidth = 1;
      var5.gridx = 0;
      var5.gridy = 2;
      this.add(new JLabel(Translator.translate("execStepTime")), var5);
      var5.gridx = 1;
      this.add(this.c, var5);
      this.c.setEnabled(!this.d.r().b());
      this.pack();
   }

   public final void actionPerformed(ActionEvent var1) {
      Object var2;
      if ((var2 = var1.getSource()) == this.a) {
         this.d.r().a(this.a.isSelected());
         this.d.a(true);
      } else {
         if (var2 == this.b) {
            boolean var3 = this.b.isSelected();
            this.c.setEnabled(!var3);
            this.d.r().b(var3);
            this.d.a(true);
         }

      }
   }

   public final void stateChanged(ChangeEvent var1) {
      if (var1.getSource() == this.c) {
         this.d.r().a(Integer.parseInt(this.c.getValue().toString()));
         this.d.a(true);
      }

   }
}
