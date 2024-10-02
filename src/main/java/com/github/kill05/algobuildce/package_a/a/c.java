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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public final class c extends JDialog implements ActionListener, DocumentListener {
   private JButton a;
   private JButton b;
   private JTextField c = new JTextField();
   private JTextField d = new JTextField();
   private JTextArea e = new JTextArea();
   private JTextField f = new JTextField();
   private String g;
   private String h;
   private String i;
   private String j;
   private ABProgram k;
   private q l;
   private static c m = null;
   private static boolean n = false;

   private c(Window var1, q var2, ABProgram var3) {
      super((Frame)var1, Translator.translate("abedDialogCodeTitle"), true);
      this.l = var2;
      this.k = var3;
      this.g = var2.j();
      this.a = AlgoBuild.d(Translator.translate("dialogButtonOK"));
      this.b = AlgoBuild.d(Translator.translate("dialogButtonCancel"));
      this.setModal(true);
      JPanel var4;
      (var4 = new JPanel()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      var4.setLayout(new BorderLayout(10, 10));
      JPanel var5;
      (var5 = new JPanel()).setLayout(new GridLayout(5, 1, 10, 10));
      JLabel var7 = new JLabel(Translator.translate("abedDialogCodeCodename"));
      var5.add(var7);
      var5.add(this.c);
      this.c.getDocument().addDocumentListener(this);
      var7 = new JLabel(Translator.translate("abedDialogCodeCodetype"));
      var5.add(var7);
      this.d.setEditable(false);
      this.d.setEnabled(true);
      this.d.setOpaque(false);
      this.d.setFocusable(false);
      var5.add(this.d);
      var7 = new JLabel(Translator.translate("abedDialogCodeFormalParameters"));
      var5.add(var7);
      var4.add(var5, "North");
      this.e.setText("CIAOCIAOCIAOCIAOCIAO\na\nb\nc\nd\ne");
      this.e.getDocument().addDocumentListener(this);
      this.a.addActionListener(this);
      this.b.addActionListener(this);
      JScrollPane var6 = new JScrollPane(this.e);
      var4.add(var6, "Center");
      (var5 = new JPanel()).setLayout(new GridLayout(3, 1, 10, 10));
      JPanel var8;
      (var8 = new JPanel()).setLayout(new GridLayout(1, 2, 10, 10));
      var5.add(new JLabel(Translator.translate("abedDialogCodeReturnExpr")));
      var5.add(this.f);
      this.f.getDocument().addDocumentListener(this);
      var8.add(this.a);
      var8.add(this.b);
      var5.add(var8);
      var4.add(var5, "South");
      this.setContentPane(var4);
      this.setResizable(false);
      this.pack();
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      int var2;
      String[] var3;
      if (var1.getSource() == this.a) {
         var3 = this.e.getText().split("\n");
         this.l.o();

         for(var2 = 0; var2 < var3.length; ++var2) {
            this.l.b(var3[var2]);
         }

         this.l.c(this.f.getText());
         String var4 = this.c.getText();
         if (!this.g.equals(var4)) {
            this.l.a(var4);
            this.k.a(this.g, this.l);
         }

         this.l.a(true);
         this.setVisible(false);
         n = true;
      } else {
         if (var1.getSource() == this.b) {
            var3 = this.i.split("\n");
            this.l.o();

            for(var2 = 0; var2 < var3.length; ++var2) {
               this.l.b(var3[var2]);
            }

            this.l.c(this.j);
            this.l.a(true);
            this.setVisible(false);
            n = false;
         }

      }
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
      Document var5;
      if ((var5 = var1.getDocument()) == this.e.getDocument() && !(var2 = this.e.getText()).equals(this.h)) {
         String[] var3 = var2.split("\n");
         this.l.o();

         for(int var4 = 0; var4 < var3.length; ++var4) {
            this.l.b(var3[var4]);
         }

         this.h = var2;
      }

      if (var5 == this.f.getDocument()) {
         if ((var2 = this.f.getText()) != null && var2.length() != 0) {
            this.d.setText("Function");
            this.l.g(3);
         } else {
            this.d.setText("Procedure");
            this.l.g(2);
         }

         this.l.c(this.f.getText());
      }

      this.l.a(true);
   }

   public static boolean a(Window var0, q var1, ABProgram var2) {
      Point var3;
      (var3 = MouseInfo.getPointerInfo().getLocation()).translate(15, 15);
      if (m == null) {
         m = new c(var0, var1, var2);
      }

      c var6;
      (var6 = m).l = var1;
      var6.g = var1.j();
      var6.i = "";

      int var7;
      for(var7 = 0; var7 < var6.l.k(); ++var7) {
         if (var7 > 0) {
            var6.i = var6.i + "\n" + var6.l.e(var7);
         } else {
            var6.i = var6.l.e(var7);
         }
      }

      var6.h = var6.i;
      var6.j = var6.l.l();
      if (var6.j != null && var6.j.length() != 0) {
         var6.d.setText("Function");
      } else {
         var6.d.setText("Procedure");
      }

      var6.c.setText(var6.g);
      var6.f.setText(var6.j);
      Dimension var8 = Toolkit.getDefaultToolkit().getScreenSize();
      Insets var10 = Toolkit.getDefaultToolkit().getScreenInsets(var6.getGraphicsConfiguration());
      int var4 = (int)var8.getWidth();
      var7 = (int)var8.getHeight();
      Dimension var5 = var6.getSize();
      if (var3.x + var5.width > var4 - var10.right) {
         var3.x -= var3.x + var5.width - var4 + var10.right + 1;
      }

      if (var3.y + var5.height > var7 - var10.bottom) {
         var3.y -= var3.y + var5.height - var7 + var10.bottom + 1;
      }

      var6.setLocation(var3);
      var6.e.setText(var6.i);
      var6.e.requestFocusInWindow();
      var6.setVisible(true);
      return n;
   }
}
