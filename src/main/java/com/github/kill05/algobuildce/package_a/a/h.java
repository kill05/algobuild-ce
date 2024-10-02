package com.github.kill05.algobuildce.package_a.a;

import com.github.kill05.algobuildce.package_a.c.a.AlgoBuild;
import com.github.kill05.algobuildce.package_a.c.b.ABOutputBlock;
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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public final class h extends JDialog implements ActionListener, KeyListener, DocumentListener {
   private JButton a;
   private JButton b;
   private JTextArea c = new JTextArea();
   private JComboBox d;
   private static String[] e = new String[]{Translator.translate("abedDialogIOOutputNLNo"), Translator.translate("abedDialogIOOutputNLYes")};
   private String f;
   private String g;
   private ABOutputBlock h;
   private static h i = null;
   private static boolean j = false;

   private h(Window var1, ABOutputBlock var2) {
      super((Frame)var1, Translator.translate("abedDialogIOOutputTitle"), true);
      this.h = var2;
      this.a = AlgoBuild.createButton(Translator.translate("dialogButtonOK"));
      this.b = AlgoBuild.createButton(Translator.translate("dialogButtonCancel"));
      this.setModal(true);
      JTextArea var4;
      (var4 = new JTextArea(Translator.translate("abedDialogIOOutputLabel"))).setEditable(false);
      var4.setEnabled(true);
      var4.setOpaque(false);
      var4.setFocusable(false);
      JPanel var6;
      (var6 = new JPanel()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      var6.setLayout(new BorderLayout(10, 10));
      JPanel var3;
      (var3 = new JPanel()).setLayout(new GridLayout(2, 2, 10, 10));
      this.c.setText("CIAOCIAOCIAOCIAOCIAO\na\nb\nc\nd\ne");
      this.d = new JComboBox(e);
      this.d.addActionListener(this);
      this.d.addKeyListener(this);
      var6.add(this.c);
      this.c.getDocument().addDocumentListener(this);
      this.c.addKeyListener(this);
      this.a.addActionListener(this);
      this.b.addActionListener(this);
      var6.add(var4, "North");
      JScrollPane var5 = new JScrollPane(this.c);
      var6.add(var5, "Center");
      var3.add(new JLabel(Translator.translate("abedDialogIOOutputNLLabel")));
      var3.add(this.d);
      var3.add(this.a);
      var3.add(this.b);
      var6.add(var3, "South");
      this.setContentPane(var6);
      this.setResizable(false);
      this.pack();
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      if (var1.getSource() == this.a) {
         this.h.a(this.c.getText().trim());
         this.setVisible(false);
         j = true;
      } else if (var1.getSource() == this.b) {
         this.h.a(this.g);
         this.setVisible(false);
         j = false;
      } else {
         if (var1.getSource() == this.d) {
            this.h.e(this.d.getSelectedIndex());
         }

      }
   }

   @Override
   public final void changedUpdate(DocumentEvent var1) {
      String var2;
      if (!(var2 = this.c.getText()).equals(this.f)) {
         this.h.a(var2);
         this.f = var2;
      }

   }

   @Override
   public final void insertUpdate(DocumentEvent var1) {
      boolean var2 = false;
      boolean var3 = false;
      int var9;
      if (var1.getLength() == 1) {
         int var4;
         Document var5;
         if ((var4 = (var5 = var1.getDocument()).getLength()) == 1) {
            try {
               var3 = var5.getText(0, 1).equals("\n");
            } catch (BadLocationException var6) {
            }
         } else {
            try {
               var9 = var1.getOffset();
               String var10 = var5.getText(var9 - 1, var4 - var9 + 1);
               var2 = true;

               for(var4 = 0; var2 && var4 < var10.length(); ++var4) {
                  if (var10.charAt(var4) != '\n') {
                     var2 = false;
                  }
               }
            } catch (BadLocationException var8) {
            }
         }
      }

      if (var2) {
         try {
            String var11;
            for(var9 = (var11 = this.c.getText()).length(); var9 > 1 && var11.charAt(var9 - 1) == '\n' && var11.charAt(var9 - 2) == '\n'; --var9) {
            }

            this.h.a(this.c.getText(0, var9));
         } catch (BadLocationException var7) {
         }

         this.setVisible(false);
         j = true;
      } else if (var3) {
         this.h.a(this.g);
         this.setVisible(false);
         j = false;
      } else {
         this.h.a(this.c.getText());
      }
   }

   @Override
   public final void removeUpdate(DocumentEvent var1) {
      this.h.a(this.c.getText());
   }

   public static boolean a(Window var0, ABOutputBlock var1) {
      Point var2;
      (var2 = MouseInfo.getPointerInfo().getLocation()).translate(15, 15);
      if (i == null) {
         i = new h(var0, var1);
      }

      h var6;
      (var6 = i).g = var1.k();
      var6.f = var6.g;
      int var3;
      if ((var3 = var6.h.j()) >= e.length) {
         var3 = e.length - 1;
         var6.h.e(var3);
      } else if (var3 < 0) {
         var3 = 0;
         var6.h.e(0);
      }

      var6.d.setSelectedIndex(var3);
      var6.h = var1;
      Dimension var7 = Toolkit.getDefaultToolkit().getScreenSize();
      Insets var9 = Toolkit.getDefaultToolkit().getScreenInsets(var6.getGraphicsConfiguration());
      int var4 = (int)var7.getWidth();
      int var8 = (int)var7.getHeight();
      Dimension var5 = var6.getSize();
      if (var2.x + var5.width > var4 - var9.right) {
         var2.x -= var2.x + var5.width - var4 + var9.right + 1;
      }

      if (var2.y + var5.height > var8 - var9.bottom) {
         var2.y -= var2.y + var5.height - var8 + var9.bottom + 1;
      }

      var6.setLocation(var2);
      var6.c.setText(var6.g);
      var6.c.requestFocusInWindow();
      var6.setVisible(true);
      return j;
   }

   @Override
   public final void keyPressed(KeyEvent var1) {
      if (var1.getKeyCode() == 27) {
         this.h.a(this.g);
         this.setVisible(false);
         j = false;
      }

   }

   @Override
   public final void keyReleased(KeyEvent var1) {
   }

   @Override
   public final void keyTyped(KeyEvent var1) {
   }
}
