package com.github.kill05.algobuildce.package_a.a;

import com.github.kill05.algobuildce.package_a.c.a.AlgoBuild;
import com.github.kill05.algobuildce.package_a.c.b.ABForBlock;
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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public final class e extends JDialog implements ActionListener, KeyListener, DocumentListener {
   private JButton a;
   private JButton b;
   private JTextField c;
   private JTextField d;
   private JTextField e;
   private String f;
   private String g;
   private String h;
   private ABForBlock i;
   private static e j = null;
   private static boolean k = false;

   private e(Window var1, ABForBlock var2, Point var3) {
      super((Frame)var1, Translator.translate("abedDialogCycleForTitle"), true);
      this.setLocation(var3);
      this.i = var2;
      this.a = AlgoBuild.createButton(Translator.translate("dialogButtonOK"));
      this.b = AlgoBuild.createButton(Translator.translate("dialogButtonCancel"));
      JTextArea var4;
      (var4 = new JTextArea(Translator.translate("abedDialogCycleForLabel"))).setEditable(false);
      var4.setEnabled(true);
      var4.setOpaque(false);
      var4.setFocusable(false);
      JPanel var5;
      (var5 = new JPanel()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      var5.setLayout(new BorderLayout(10, 10));
      this.c = new JTextField();
      this.d = new JTextField();
      this.e = new JTextField();
      this.c.getDocument().addDocumentListener(this);
      this.d.getDocument().addDocumentListener(this);
      this.e.getDocument().addDocumentListener(this);
      this.c.addKeyListener(this);
      this.d.addKeyListener(this);
      this.e.addKeyListener(this);
      JPanel var6;
      (var6 = new JPanel()).setLayout(new GridLayout(4, 2, 10, 10));
      var6.add(new JLabel(Translator.translate("abedDialogCycleForInitialization")));
      var6.add(this.c);
      var6.add(new JLabel(Translator.translate("abedDialogCycleForCondition")));
      var6.add(this.d);
      var6.add(new JLabel(Translator.translate("abedDialogCycleForUpdate")));
      var6.add(this.e);
      this.a.addActionListener(this);
      this.b.addActionListener(this);
      var6.add(this.a);
      var6.add(this.b);
      var5.add(var4, "North");
      var5.add(var6);
      this.setContentPane(var5);
      this.setResizable(false);
      this.pack();
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      if (var1.getSource() == this.a) {
         this.i.a(this.c.getText().trim());
         this.i.c(this.d.getText().trim());
         this.i.b(this.e.getText().trim());
         this.setVisible(false);
         k = true;
      } else {
         if (var1.getSource() == this.b) {
            this.i.a(this.f);
            this.i.c(this.g);
            this.i.b(this.h);
            this.setVisible(false);
            k = false;
         }

      }
   }

   @Override
   public final void changedUpdate(DocumentEvent var1) {
      String var4 = this.c.getText().trim();
      String var2 = this.d.getText().trim();
      String var3 = this.e.getText().trim();
      this.i.a(var4);
      this.i.c(var2);
      this.i.b(var3);
   }

   @Override
   public final void insertUpdate(DocumentEvent var1) {
      String var4 = this.c.getText().trim();
      String var2 = this.d.getText().trim();
      String var3 = this.e.getText().trim();
      this.i.a(var4);
      this.i.c(var2);
      this.i.b(var3);
   }

   @Override
   public final void removeUpdate(DocumentEvent var1) {
      String var4 = this.c.getText().trim();
      String var2 = this.d.getText().trim();
      String var3 = this.e.getText().trim();
      this.i.a(var4);
      this.i.c(var2);
      this.i.b(var3);
   }

   public static boolean a(Window var0, ABForBlock var1) {
      Point var2;
      (var2 = MouseInfo.getPointerInfo().getLocation()).translate(15, 15);
      if (j == null) {
         j = new e(var0, var1, var2);
      }

      e var6;
      (var6 = j).i = var1;
      var6.f = var1.j();
      var6.g = var1.l();
      var6.h = var1.k();
      var6.c.setText(var6.f);
      var6.d.setText(var6.g);
      var6.e.setText(var6.h);
      Dimension var7 = Toolkit.getDefaultToolkit().getScreenSize();
      Insets var3 = Toolkit.getDefaultToolkit().getScreenInsets(var6.getGraphicsConfiguration());
      int var4 = (int)var7.getWidth();
      int var8 = (int)var7.getHeight();
      Dimension var5 = var6.getSize();
      if (var2.x + var5.width > var4 - var3.right) {
         var2.x -= var2.x + var5.width - var4 + var3.right + 1;
      }

      if (var2.y + var5.height > var8 - var3.bottom) {
         var2.y -= var2.y + var5.height - var8 + var3.bottom + 1;
      }

      var6.setLocation(var2);
      var6.setVisible(true);
      return k;
   }

   @Override
   public final void keyPressed(KeyEvent var1) {
      if (var1.getKeyCode() == 27) {
         this.i.a(this.f);
         this.i.c(this.g);
         this.i.b(this.h);
         this.setVisible(false);
         k = false;
      } else {
         if (var1.getKeyCode() == 10) {
            if (var1.getSource() == this.c) {
               this.c.transferFocus();
               return;
            }

            if (var1.getSource() == this.d) {
               this.d.transferFocus();
               return;
            }

            if (var1.getSource() == this.e) {
               this.i.a(this.c.getText().trim());
               this.i.c(this.d.getText().trim());
               this.i.b(this.e.getText().trim());
               this.setVisible(false);
               k = true;
            }
         }

      }
   }

   @Override
   public final void keyReleased(KeyEvent var1) {
   }

   @Override
   public final void keyTyped(KeyEvent var1) {
   }
}
