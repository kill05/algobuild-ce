package package_a.a;

import package_a.i.Translator;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public final class g extends JDialog implements ActionListener, KeyListener, DocumentListener {
   private JButton a;
   private JButton b;
   private JTextArea c = new JTextArea();
   private String d;
   private String e;
   private package_a.c.b.i f;
   private static g g = null;
   private static boolean h = false;

   private g(Window var1, package_a.c.b.i var2) {
      super((Frame)var1, Translator.translate("abedDialogIOInputTitle"), true);
      this.f = var2;
      this.a = package_a.c.a.a.d(Translator.translate("dialogButtonOK"));
      this.b = package_a.c.a.a.d(Translator.translate("dialogButtonCancel"));
      JTextArea var4;
      (var4 = new JTextArea(Translator.translate("abedDialogIOInputLabel"))).setEditable(false);
      var4.setEnabled(true);
      var4.setOpaque(false);
      var4.setFocusable(false);
      JPanel var6;
      (var6 = new JPanel()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      var6.setLayout(new BorderLayout(10, 10));
      JPanel var3;
      (var3 = new JPanel()).setLayout(new GridLayout(1, 2, 10, 10));
      this.c.setText("CIAOCIAOCIAOCIAOCIAO\na\nb\nc\nd\ne");
      var6.add(this.c);
      this.c.getDocument().addDocumentListener(this);
      this.c.addKeyListener(this);
      this.a.addActionListener(this);
      this.b.addActionListener(this);
      var6.add(var4, "North");
      JScrollPane var5 = new JScrollPane(this.c);
      var6.add(var5, "Center");
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
         this.f.a(this.c.getText().trim());
         this.setVisible(false);
         h = true;
      } else {
         if (var1.getSource() == this.b) {
            this.f.a(this.e);
            this.setVisible(false);
            h = false;
         }

      }
   }

   @Override
   public final void changedUpdate(DocumentEvent var1) {
      String var2;
      if (!(var2 = this.c.getText()).equals(this.d)) {
         this.f.a(var2);
         this.d = var2;
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

            this.f.a(this.c.getText(0, var9));
         } catch (BadLocationException var7) {
         }

         this.setVisible(false);
         h = true;
      } else if (var3) {
         this.f.a(this.e);
         this.setVisible(false);
         h = false;
      } else {
         this.f.a(this.c.getText());
      }
   }

   @Override
   public final void removeUpdate(DocumentEvent var1) {
      this.f.a(this.c.getText());
   }

   public static boolean a(Window var0, package_a.c.b.i var1) {
      Point var2;
      (var2 = MouseInfo.getPointerInfo().getLocation()).translate(15, 15);
      if (g == null) {
         g = new g(var0, var1);
      } else {
         g.f = var1;
      }

      g var6;
      (var6 = g).e = var1.k();
      var6.d = var6.e;
      var6.f = var1;
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
      var6.c.setText(var6.e);
      var6.c.requestFocusInWindow();
      var6.setVisible(true);
      return h;
   }

   @Override
   public final void keyPressed(KeyEvent var1) {
      if (var1.getKeyCode() == 27) {
         this.f.a(this.e);
         this.setVisible(false);
         h = false;
      }

   }

   @Override
   public final void keyReleased(KeyEvent var1) {
   }

   @Override
   public final void keyTyped(KeyEvent var1) {
   }
}
