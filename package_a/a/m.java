package package_a.a;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public final class m extends JDialog implements ActionListener, ChangeListener {
   private Frame a;
   private JComboBox b;
   private Font c;
   private Font d;
   private JSpinner e;
   private JSpinner f;
   private JSpinner g;
   private JButton h;
   private JButton i;
   private JButton j;
   private JButton k;
   private JButton l;
   private a.c.a.b m;

   public m(Frame var1, a.c.a.b var2) {
      super(var1, a.i.c.a("fontDialogTitle"));
      this.a = var1;
      this.m = var2;
      JPanel var6;
      (var6 = new JPanel()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      this.setContentPane(var6);
      var6.setLayout(new GridBagLayout());
      this.setVisible(false);
      this.setLocation(100, 100);
      this.setResizable(false);
      this.c = var2.q().b();
      this.d = var2.q().c();
      this.b = new JComboBox();
      String[] var7 = new String[]{"Dialog", "DialogInput", "Monospaced", "Serif", "SansSerif"};
      System.currentTimeMillis();

      for(int var3 = 0; var3 < 5; ++var3) {
         if ((new Font(var7[var3], 0, 1)).canDisplayUpTo("abcdefghilmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789|!\"$%&/()=?'^[]@#<>,;.:_+-*/") < 0) {
            this.b.addItem(var7[var3]);
         }
      }

      try {
         this.b.setSelectedItem(this.c.getName());
      } catch (Exception var5) {
      }

      Dimension var10 = this.b.getPreferredSize();
      this.b.addActionListener(this);
      this.b.setMaximumSize(var10);
      this.b.setSelectedItem(this.c.getName());
      GridBagConstraints var4;
      (var4 = new GridBagConstraints()).anchor = 21;
      var4.weightx = 1.0D;
      var4.gridwidth = 3;
      var4.gridx = 0;
      var4.gridy = 0;
      this.add(new JLabel(a.i.c.a("fontFace")), var4);
      var4.gridx = 1;
      this.add(this.b, var4);
      SpinnerNumberModel var8 = new SpinnerNumberModel((int)Math.round((double)this.c.getSize() / a.k.b.a()), 8, 50, 2);
      this.e = new JSpinner(var8);
      Dimension var9 = this.e.getPreferredSize();
      this.e.setMaximumSize(var9);
      this.e.addChangeListener(this);
      var4.gridwidth = 1;
      var4.gridx = 0;
      var4.gridy = 1;
      this.add(new JLabel(a.i.c.a("fontSize")), var4);
      var4.gridx = 1;
      this.add(this.e, var4);
      SpinnerNumberModel var11 = new SpinnerNumberModel((int)Math.round((double)this.d.getSize() / a.k.b.a()), 8, 50, 2);
      this.f = new JSpinner(var11);
      var10 = this.f.getPreferredSize();
      this.f.setMaximumSize(var10);
      this.f.addChangeListener(this);
      var4.gridx = 0;
      var4.gridy = 2;
      this.add(new JLabel(a.i.c.a("fontRunSize")), var4);
      var4.gridx = 1;
      this.add(this.f, var4);
      this.h = new JButton();
      this.h.setPreferredSize(var9);
      this.h.setMaximumSize(var9);
      this.h.setBackground(this.m.q().d());
      this.h.addActionListener(this);
      var4.gridx = 0;
      var4.gridy = 3;
      this.add(new JLabel(a.i.c.a("btnBackgroundColor")), var4);
      var4.gridx = 1;
      this.add(this.h, var4);
      this.i = new JButton();
      this.i.setPreferredSize(var9);
      this.i.setMaximumSize(var9);
      this.i.setBackground(this.m.q().e());
      this.i.addActionListener(this);
      var4.gridx = 0;
      var4.gridy = 4;
      this.add(new JLabel(a.i.c.a("btnFillingColor")), var4);
      var4.gridx = 1;
      this.add(this.i, var4);
      this.j = new JButton("LC");
      this.j.setPreferredSize(var9);
      this.j.setMaximumSize(var9);
      this.j.setBackground(this.m.q().i());
      this.j.addActionListener(this);
      var4.gridx = 0;
      var4.gridy = 5;
      this.add(new JLabel(a.i.c.a("btnPenColor")), var4);
      var4.gridx = 1;
      this.add(this.j, var4);
      var11 = new SpinnerNumberModel(1, 1, 10, 1);
      this.g = new JSpinner(var11);
      var10 = this.g.getPreferredSize();
      this.g.setMaximumSize(var10);
      this.g.addChangeListener(this);
      this.g.setValue(var2.q().h());
      var4.gridx = 0;
      var4.gridy = 6;
      this.add(new JLabel(a.i.c.a("lineSize")), var4);
      var4.gridx = 1;
      this.add(this.g, var4);
      var4.gridx = 0;
      var4.gridy = 7;
      this.add(new JLabel(" "), var4);
      var4.gridx = 1;
      this.add(new JLabel(" "), var4);
      this.k = new JButton();
      this.k.setPreferredSize(var9);
      this.k.setMaximumSize(var9);
      this.k.addActionListener(this);
      var4.gridx = 0;
      var4.gridy = 8;
      this.add(new JLabel(a.i.c.a("btnSaveFontAndLinePreferences")), var4);
      var4.gridx = 1;
      this.add(this.k, var4);
      this.l = new JButton();
      this.l.setPreferredSize(var9);
      this.l.setMaximumSize(var9);
      this.l.addActionListener(this);
      var4.gridx = 0;
      var4.gridy = 9;
      this.add(new JLabel(a.i.c.a("btnRestoreFontAndLineDefaults")), var4);
      var4.gridx = 1;
      this.add(this.l, var4);
      this.pack();
   }

   public final void actionPerformed(ActionEvent var1) {
      Object var5;
      if ((var5 = var1.getSource()) == this.b) {
         this.b();
         this.a();
      } else {
         Color var6;
         if (var5 == this.h) {
            if ((var6 = JColorChooser.showDialog(this.a, a.i.c.a("btnBackgroundColor"), this.m.q().d())) != null) {
               this.h.setBackground(var6);
               this.m.q().a(var6);
               this.m.a(true);
               return;
            }
         } else if (var5 == this.i) {
            if ((var6 = JColorChooser.showDialog(this.a, a.i.c.a("btnFillingColor"), this.m.q().e())) != null) {
               this.i.setBackground(var6);
               this.m.q().b(var6);
               this.m.a(true);
               return;
            }
         } else if (var5 == this.j) {
            if ((var6 = JColorChooser.showDialog(this.a, a.i.c.a("btnPenColor"), this.m.q().i())) != null) {
               this.j.setBackground(var6);
               this.m.q().c(var6);
               this.m.a(true);
               return;
            }
         } else {
            if (var5 == this.k) {
               try {
                  b.a.c var8 = this.m.q().n();
                  b.a.c var2 = var8;
                  String var9 = "ViewOptions.abopt";
                  File var3 = a.f.j.c();
                  File var11 = new File(var3, var9);
                  FileWriter var12 = new FileWriter(var11);
                  b.a.g var10;
                  (var10 = new b.a.g(var12)).b();
                  var10.a("opt");
                  var10.a((Object)var2);
                  var10.a();
                  var12.close();
                  return;
               } catch (IOException var4) {
                  JOptionPane.showMessageDialog(this.a, a.i.c.a("abpErrorWritingFile"), a.i.c.a("abpErrorFileOperation"), 0);
                  return;
               }
            }

            if (var5 == this.l) {
               a.c.a.i var7;
               (var7 = this.m.q()).a();
               this.b.setSelectedItem(var7.b().getFontName());
               this.e.setValue((int)Math.round((double)var7.b().getSize() / a.k.b.a()));
               this.f.setValue((int)Math.round((double)var7.c().getSize() / a.k.b.a()));
               this.h.setBackground(var7.d());
               this.i.setBackground(var7.e());
               this.j.setBackground(var7.i());
               this.g.setValue(var7.h());
               this.m.a(true);
            }
         }

      }
   }

   private void a() {
      try {
         int var1 = (int)((double)new Integer(this.f.getValue().toString()) * a.k.b.a());
         Font var3 = new Font((String)this.b.getSelectedItem(), 0, var1);
         this.m.q().b(var3);
         this.m.a(true);
      } catch (Exception var2) {
      }
   }

   private void b() {
      try {
         int var1 = (int)((double)new Integer(this.e.getValue().toString()) * a.k.b.a());
         Font var2 = new Font((String)this.b.getSelectedItem(), 0, var1);
         this.m.q().a(var2);
         this.m.q().b((var1 + 1) / 2);
         this.m.a(true);
      } catch (Exception var3) {
      }
   }

   public final void stateChanged(ChangeEvent var1) {
      Object var2;
      if ((var2 = var1.getSource()) == this.e) {
         this.b();
      } else if (var2 == this.f) {
         this.a();
      } else {
         if (var2 == this.g) {
            this.m.q().a(new Integer(this.g.getValue().toString()));
            this.m.a(true);
         }

      }
   }
}
