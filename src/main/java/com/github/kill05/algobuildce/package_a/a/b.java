package com.github.kill05.algobuildce.package_a.a;

import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.a.AlgoBuild;
import com.github.kill05.algobuildce.package_a.c.b.q;
import com.github.kill05.algobuildce.package_a.i.Translator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public final class b extends JDialog implements ActionListener, DocumentListener {
   private final JButton okButton;
   private final JButton cancelButton;
   private final JComboBox<String> comboBox = new JComboBox<>();
   private final JTextField d = new JTextField();
   private final JTextArea e = new JTextArea();
   private final JTextArea f = new JTextArea();
   private final JTextField g = new JTextField();
   private String h;
   private String i;
   private String j;
   private String k;
   private com.github.kill05.algobuildce.package_a.c.b.c l;
   private ABProgram m;
   private static b n = null;
   private static boolean o = false;

   private b(Window var1, com.github.kill05.algobuildce.package_a.c.b.c var2, Point var3, ABProgram var4) {
      super((Frame)var1, Translator.translate("abedDialogCallFuncTitle"), true);
      this.setLocation(var3);
      this.l = var2;
      this.m = var4;
      this.okButton = AlgoBuild.createButton(Translator.translate("dialogButtonOK"));
      this.cancelButton = AlgoBuild.createButton(Translator.translate("dialogButtonCancel"));
      JPanel var5;
      (var5 = new JPanel()).setLayout(new GridLayout(5, 1, 10, 10));
      JLabel var8 = new JLabel(Translator.translate("abedDialogCallFuncCodename"));
      var5.add(var8);
      var5.add(this.comboBox);
      this.comboBox.addActionListener(this);
      var8 = new JLabel(Translator.translate("abedDialogCodeCodetype"));
      var5.add(var8);
      this.d.setEditable(false);
      this.d.setEnabled(true);
      this.d.setOpaque(false);
      this.d.setFocusable(false);
      var5.add(this.d);
      var8 = new JLabel(Translator.translate("abedDialogCallFuncActualParameters"));
      var5.add(var8);
      JPanel var10;
      (var10 = new JPanel()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      var10.setLayout(new BorderLayout(10, 10));
      var10.add(var5, "North");
      this.e.setText("CIAOCIAO\na\nb\nc\nd\ne");
      this.e.setEditable(false);
      this.e.setEnabled(true);
      this.e.setOpaque(false);
      this.e.setFocusable(false);
      this.f.setText("CIAOCIAOCIAOCIAOCIAO\na\nb\nc\nd\ne");
      this.f.getDocument().addDocumentListener(this);
      Box var6;
      (var6 = Box.createHorizontalBox()).add(this.e);
      var6.add(this.f);
      this.okButton.addActionListener(this);
      this.cancelButton.addActionListener(this);
      JScrollPane var7 = new JScrollPane(var6);
      var10.add(var7, "Center");
      (var5 = new JPanel()).setLayout(new GridLayout(3, 1, 10, 10));
      JPanel var11;
      (var11 = new JPanel()).setLayout(new GridLayout(1, 2, 10, 10));
      var5.add(new JLabel(Translator.translate("abedDialogCallFuncReturnVar")));
      this.g.setText(this.k);
      var5.add(this.g);
      this.g.getDocument().addDocumentListener(this);
      var11.add(this.okButton);
      var11.add(this.cancelButton);
      var5.add(var11);
      var10.add(var5, "South");
      this.setContentPane(var10);
      this.setResizable(false);
      this.pack();
      Dimension var9 = this.f.getPreferredSize();
      this.f.setMinimumSize(var9);
      var9.height *= 10;
      this.f.setMaximumSize(var9);
      var9 = this.e.getPreferredSize();
      this.e.setMinimumSize(var9);
      var9.height *= 10;
      this.e.setMaximumSize(var9);
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      Object var4;
      if ((var4 = var1.getSource()) == this.comboBox) {
         this.a();
      } else {
         Vector var2;
         int var3;
         String[] var5;
         if (var4 == this.okButton) {
            var5 = this.f.getText().split("\n");
            (var2 = this.l.getParameters()).clear();

            for(var3 = 0; var3 < var5.length; ++var3) {
               var2.add(var5[var3]);
            }

            String var6 = (String)this.comboBox.getSelectedItem();
            this.l.a(var6);
            if (this.g.isEnabled()) {
               this.l.b(this.g.getText());
            } else {
               this.l.b((String)null);
            }

            this.setVisible(false);
            o = true;
         } else {
            if (var4 == this.cancelButton) {
               var5 = this.i.split("\n");
               (var2 = this.l.getParameters()).clear();

               for(var3 = 0; var3 < var5.length; ++var3) {
                  var2.add(var5[var3]);
               }

               this.l.a(this.j);
               this.l.b(this.k);
               this.setVisible(false);
               o = false;
            }

         }
      }
   }

   private void a() {
      System.out.println("CODE NAME CHANGED");
      String var1 = (String)this.comboBox.getSelectedItem();
      System.out.println(var1);
      if (var1 != null) {
         q var4 = this.m.a(var1);
         String var2 = "";

         for(int var3 = 0; var3 < var4.k(); ++var3) {
            System.out.println("param " + var3 + " = " + var4.e(var3));
            if (var3 != 0) {
               var2 = var2 + "\n";
            }

            var2 = var2 + var4.e(var3);
         }

         this.e.setText(var2);
         if (var4.m() == 3) {
            this.d.setText("Function");
            this.g.setEnabled(true);
            this.l.b(this.g.getText());
         } else {
            this.d.setText("Procedure");
            this.g.setEnabled(false);
            this.l.b((String)null);
         }
      }

      this.l.a((String)this.comboBox.getSelectedItem());
      this.l.a(true);
   }

   @Override
   public final void changedUpdate(DocumentEvent var1) {
      this.a(var1);
   }

   @Override
   public final void insertUpdate(DocumentEvent var1) {
      this.a(var1);
   }

   @Override
   public final void removeUpdate(DocumentEvent var1) {
      this.a(var1);
   }

   private void a(DocumentEvent var1) {
      String var2;
      Document var6;
      if ((var6 = var1.getDocument()) == this.f.getDocument() && !(var2 = this.f.getText()).equals(this.h)) {
         String[] var3 = var2.split("\n");
         Vector var4;
         (var4 = this.l.getParameters()).clear();

         for(int var5 = 0; var5 < var3.length; ++var5) {
            var4.add(var3[var5]);
         }

         this.h = var2;
      }

      if (var6 == this.g.getDocument()) {
         if ((var2 = this.g.getText()) != null && var2.length() != 0) {
            this.d.setText("Function");
            this.l.b(this.g.getText());
         } else {
            this.d.setText("Procedure");
            this.l.b((String)null);
         }
      }

      this.l.a(true);
   }

   public static boolean a(Window var0, com.github.kill05.algobuildce.package_a.c.b.c var1, ABProgram var2) {
      Point var3;
      (var3 = MouseInfo.getPointerInfo().getLocation()).translate(15, 15);
      if (n == null) {
         n = new b(var0, var1, var3, var2);
      }

      b var6;
      (var6 = n).l = var1;
      var6.m = var2;
      var6.i = "";

      int var7;
      for(var7 = 0; var7 < var6.l.getParameters().size(); ++var7) {
         if (var7 > 0) {
            var6.i = var6.i + "\n" + (String)var6.l.getParameters().get(var7);
         } else {
            var6.i = (String)var6.l.getParameters().get(var7);
         }
      }

      var6.j = var6.l.getCallName();
      var6.h = var6.i;
      var6.k = var6.l.l();
      System.out.println("add to combobox - START");
      var7 = 0;
      Iterator<q> var11 = var2.getAlgoBuild().a().iterator();
      var6.comboBox.removeAllItems();

      while(true) {
         q var4;
         do {
            if (!var11.hasNext()) {
               System.out.println("add to combobox - END");
               var6.f.setText(var6.i);
               var6.a();
               Dimension var9 = Toolkit.getDefaultToolkit().getScreenSize();
               Insets var12 = Toolkit.getDefaultToolkit().getScreenInsets(var6.getGraphicsConfiguration());
               int var13 = (int)var9.getWidth();
               int var14 = (int)var9.getHeight();
               var9 = var6.getSize();
               if (var3.x + var9.width > var13 - var12.right) {
                  var3.x -= var3.x + var9.width - var13 + var12.right + 1;
               }

               if (var3.y + var9.height > var14 - var12.bottom) {
                  var3.y -= var3.y + var9.height - var14 + var12.bottom + 1;
               }

               var6.setLocation(var3);
               var6.f.requestFocusInWindow();
               var6.setVisible(true);
               return o;
            }
         } while((var4 = (q)var11.next()).m() != 3 && var4.m() != 2);

         String var5 = var4.j();
         System.out.println("ADD code name to combo box " + var5);
         var6.comboBox.addItem(var5);
         if (var5.equals(var6.j)) {
            var6.comboBox.setSelectedIndex(var7);
         }

         ++var7;
      }
   }
}
