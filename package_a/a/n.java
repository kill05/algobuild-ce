package package_a.a;

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

public final class n extends JDialog implements ActionListener, ChangeListener {
   private JCheckBox a;
   private JCheckBox b;
   private JSpinner c;
   private a.c.a.b d;

   public n(Frame var1, a.c.a.b var2) {
      super(var1, a.i.c.a("abedDialogRunOptionsTitle"));
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
      this.add(new JLabel(a.i.c.a("execTrace")), var5);
      var5.gridx = 1;
      this.add(this.a, var5);
      this.b = new JCheckBox();
      this.b.setSelected(this.d.r().b());
      this.b.addActionListener(this);
      var5.gridwidth = 1;
      var5.gridx = 0;
      var5.gridy = 1;
      this.add(new JLabel(a.i.c.a("execOneStep")), var5);
      var5.gridx = 1;
      this.add(this.b, var5);
      Integer[] var6 = new Integer[]{new Integer(5), new Integer(10), new Integer(20), new Integer(50), new Integer(100), new Integer(200), new Integer(500), new Integer(1000), new Integer(2000), new Integer(5000)};
      SpinnerListModel var3 = new SpinnerListModel(var6);
      this.c = new JSpinner(var3);
      this.c.setValue(var6[9]);
      this.c.getPreferredSize();
      this.c.setValue(var6[7]);
      this.c.addChangeListener(this);
      var5.gridwidth = 1;
      var5.gridx = 0;
      var5.gridy = 2;
      this.add(new JLabel(a.i.c.a("execStepTime")), var5);
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
         this.d.r().a(new Integer(this.c.getValue().toString()));
         this.d.a(true);
      }

   }
}
