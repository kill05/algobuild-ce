package package_a.j.a;

import package_a.c.a.k;
import package_a.c.b.q;
import package_a.f.j;
import package_a.i.Translator;
import package_a.j.b.p;
import package_a.k.ABFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public final class a extends JPanel implements ActionListener, ChangeListener {
   protected package_a.c.a.b a;
   private g c;
   protected JTabbedPane b;
   private int d = -1;
   private ABFrame e;
   private package_a.i.a f;
   private package_a.i.a g;
   private D h;
   private Vector i = new Vector();

   public a() {
      this.setLayout(new BorderLayout());
      this.h = new p();
      ImageIcon var1 = package_a.i.b.a("imgs/logo2_arancio_small.png");
      this.f = new package_a.i.a(var1);
      var1 = package_a.i.b.a("imgs/logo2_arancio_small.png");
      this.g = new package_a.i.a(var1);
      this.b = new JTabbedPane();
      this.add(this.b, "Center");
      this.b.addTab("+", new JPanel());
      this.b.addChangeListener(this);
   }

   public final ABFrame a() {
      return this.e;
   }

   public final void a(ABFrame var1) {
      this.e = var1;
   }

   public final void actionPerformed(ActionEvent var1) {
      if (var1.getSource() == null) {
         JPopupMenu var5 = new JPopupMenu();
         JMenuItem var6;
         (var6 = new JMenuItem(Translator.translate("instructionConnectorNewMsg"))).setEnabled(false);
         var5.add(var6);
         JMenuItem var3;
         (var3 = new JMenuItem(Translator.translate("abvfcAddCodePopupNewProcedure"))).addActionListener(this);
         var5.add(var3);
         (var3 = new JMenuItem(Translator.translate("abvfcAddCodePopupNewFunction"))).addActionListener(this);
         var5.add(var3);
         var5.show(this, this.getX(), this.getY()); //todo: figure out why getX and getY were called on 'null'
      } else {
         String var2;
         String var4;
         if ((var4 = var1.getActionCommand()) != null && var4.equals(Translator.translate("abvfcAddCodePopupNewProcedure"))) {
            var2 = JOptionPane.showInputDialog(this, Translator.translate("abvfcAddCodeNewProcedureNameMsg"));
            if (this.a.a(var2) == null) {
               this.a.a(var2, 2);
            } else {
               JOptionPane.showMessageDialog(this, Translator.translate("abvfcAddCodeNameAlreadyPresentMsg"), Translator.translate("abvfcAddCodePopupNewMsg"), 0);
            }
         } else {
            if (var4 != null && var4.equals(Translator.translate("abvfcAddCodePopupNewFunction"))) {
               var2 = JOptionPane.showInputDialog(this, Translator.translate("abvfcAddCodeNewFunctionNameMsg"));
               if (this.a.a(var2) == null) {
                  this.a.a(var2, 3);
                  return;
               }

               JOptionPane.showMessageDialog(this, Translator.translate("abvfcAddCodeNameAlreadyPresentMsg"), Translator.translate("abvfcAddCodePopupNewMsg"), 0);
            }

         }
      }
   }

   public final void a(package_a.c.a.d var1) {
      int var2 = this.b.getTabCount();
      String var3 = var1.b();
      package_a.j.b.c var4;
      (var4 = new package_a.j.b.c(this.a, this, var1)).setBackground(Color.YELLOW);
      var1.a((k)var4);
      var4.g();
      var4.setAlignmentX(0.5F);
      Box var5;
      (var5 = Box.createVerticalBox()).add(var4);
      JScrollPane var11;
      (var11 = new JScrollPane(var5)).getHorizontalScrollBar().setUnitIncrement(15);
      var11.getVerticalScrollBar().setUnitIncrement(15);
      package_a.j.b.c var6 = new package_a.j.b.c(this.a, this, var1);
      var1.a((k)var6);
      var6.g();
      var6.setAlignmentX(0.5F);
      Box var8;
      (var8 = Box.createVerticalBox()).add(var6);
      JScrollPane var9 = new JScrollPane(var8);
      var11.getHorizontalScrollBar().setUnitIncrement(15);
      var11.getVerticalScrollBar().setUnitIncrement(15);
      package_a.j.b.C var7 = this.h.a(var6);
      var6.a(var7);
      JSplitPane var10;
      (var10 = new JSplitPane(1, var11, var9)).setResizeWeight(0.5D);
      var10.setDividerSize(4);
      if (var2 == 0) {
         this.b.addTab(var3, var10);
         this.i.add(var4);
      } else {
         this.b.insertTab(var3, (Icon)null, var10, (String)null, var2 - 1);
         this.b.setSelectedIndex(var2 - 1);
         this.i.add(var2 - 1, var4);
      }

      var4.revalidate();
      this.updateUI();
   }

   public final void b() {
      this.b.removeAll();
      this.d = -1;
      this.b.addTab("+", new JPanel());
   }

   public final void stateChanged(ChangeEvent var1) {
      int var7;
      if ((var7 = this.b.getSelectedIndex()) >= 0) {
         String var2 = this.b.getTitleAt(var7);
         if (this.d >= 0 && var2.equals("+")) {
            this.d = -1;
            boolean var3 = false;
            String var4 = "newCode";

            for(int var5 = 0; var5 < 10 && !var3; ++var5) {
               if (var5 > 0) {
                  var4 = "newCode" + var5;
               }

               if (this.a.a(var4) == null) {
                  this.a.a(var4, 2);
                  var3 = true;
               }
            }

            q var9;
            if (var3 && (var9 = this.a.a(var4)).m() != 1) {
               if (!a.a.c.a(this.e, var9, this.a)) {
                  this.d = 0;
                  this.b.setSelectedIndex(0);
                  this.a.b(var4);
               } else {
                  a.g.a var8 = new a.g.a(this.a, var9);
                  this.c.a((a.g.g)var8);
               }
            }
         }

         if (!var2.equals("+")) {
            this.d = var7;
         }
      }

   }

   public final void a(g var1) {
      this.c = var1;
   }

   public final g c() {
      return this.c;
   }

   public final void a(String var1, q var2) {
      int var3;
      if ((var3 = this.b.indexOfTab(var1)) >= 0) {
         this.b.setTitleAt(var3, var2.j());
      }

   }

   public final void b(package_a.c.a.d var1) {
      String var2 = ((q)var1).j();
      int var3 = this.b.indexOfTab(var2);
      this.d = 0;
      this.b.setSelectedIndex(0);
      if (var3 >= 0) {
         this.b.remove(var3);
         this.i.remove(var3);
      }

   }

   public final void d() {
      int var1 = this.b.getSelectedIndex();
      package_a.j.b.c var5 = (package_a.j.b.c)this.i.elementAt(var1);
      package_a.i.d var2 = new package_a.i.d(var5);
      int var3 = var5.getWidth();
      int var4 = var5.getHeight();
      BufferedImage var7;
      Graphics2D var8;
      (var8 = (var7 = new BufferedImage(var3, var4, 1)).createGraphics()).setFont(this.a.q().b());
      var2.a(var8, var5);
      var8.dispose();
      package_a.i.e var6 = new package_a.i.e(var7);
      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(var6, (ClipboardOwner)null);
   }

   public final void e() {
      JFileChooser var1 = new JFileChooser(j.c().getAbsolutePath());
      FileNameExtensionFilter var2 = new FileNameExtensionFilter("Immagine *.gif", new String[]{"gif"});
      var1.addChoosableFileFilter(var2);
      var2 = new FileNameExtensionFilter("Immagine *.jpg", new String[]{"jpg"});
      var1.addChoosableFileFilter(var2);
      var2 = new FileNameExtensionFilter("Immagine *.png", new String[]{"png"});
      var1.addChoosableFileFilter(var2);
      var1.setFileSelectionMode(0);
      var1.setFileFilter(var2);
      if (var1.showSaveDialog(this.e) == 0) {
         String var11 = var1.getSelectedFile().getAbsolutePath();
         FileFilter var8;
         if ((var8 = var1.getFileFilter()) != null && var8 instanceof FileNameExtensionFilter) {
            String[] var9 = ((FileNameExtensionFilter)var8).getExtensions();
            if (!var11.contains(".") && var9.length > 0 && var9[0] != null) {
               var11 = var11 + "." + var9[0];
            }
         }

         String var10 = var11.substring(var11.lastIndexOf(46) + 1);
         int var3 = this.b.getSelectedIndex();
         package_a.j.b.c var12 = (package_a.j.b.c)this.i.elementAt(var3);
         package_a.i.d var4 = new package_a.i.d(var12);
         int var5 = var12.getWidth();
         int var6 = var12.getHeight();
         BufferedImage var14;
         Graphics2D var15;
         (var15 = (var14 = new BufferedImage(var5, var6, 1)).createGraphics()).setFont(this.a.q().b());
         var4.a(var15, var12);
         var15.dispose();

         try {
            File var13 = new File(var11);
            ImageIO.write(var14, var10, var13);
            return;
         } catch (IOException var7) {
            var7.printStackTrace();
         }
      }

   }
}
