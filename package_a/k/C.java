package package_a.k;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

final class c {
   private C b = new C();
   protected a a;
   private JFileChooser c;
   private String d;
   private static c e = null;

   private c() {
      Dimension var1 = Toolkit.getDefaultToolkit().getScreenSize();
      this.b.setSize((int)(var1.getWidth() * 0.9D), (int)(var1.getHeight() * 0.65D));
      this.b.setLocation((int)(var1.getWidth() * 0.05D), (int)(var1.getHeight() * 0.05D));
      this.a = this.u();
      this.b.setJMenuBar(this.v());
      this.b.a(this.w());
      this.b.setVisible(true);
      this.b.a(new package_a.j.a.g(this));
      this.a.a("mnuFileSaveAs").setEnabled(true);
      this.a.a("execInstruction").setEnabled(true);
      this.a.a("execOptions").setEnabled(true);
      this.b.a(this);
   }

   public static c a() {
      if (e == null) {
         e = new c();
      }

      return e;
   }

   public final C b() {
      return this.b;
   }

   private a u() {
      a var1 = new a();
      String var2 = "mnuFileNew";
      String var3 = a.i.c.a("mnuFileNew");
      ImageIcon var4 = a.i.b.a("imgs/new_icon.gif");
      d var6 = new d(this, var3, var4);
      var1.a(var2, var6);
      var2 = "mnuFileOpen";
      var3 = a.i.c.a("mnuFileOpen");
      var4 = a.i.b.a("imgs/open_icon.gif");
      o var7 = new o(this, var3, var4);
      var1.a(var2, var7);
      var2 = "mnuFileSave";
      var3 = a.i.c.a("mnuFileSave");
      var4 = a.i.b.a("imgs/save_icon.gif");
      u var8;
      (var8 = new u(this, var3, var4)).setEnabled(false);
      var1.a(var2, var8);
      var2 = "mnuFileSaveAs";
      var3 = a.i.c.a("mnuFileSaveAs");
      var4 = a.i.b.a("imgs/saveas_icon.gif");
      v var9;
      (var9 = new v(this, var3, var4)).setEnabled(false);
      var1.a(var2, var9);
      var2 = "mnuFileSaveImage";
      var3 = a.i.c.a("mnuFileSaveImage");
      w var10 = new w(this, var3);
      var1.a(var2, var10);
      var2 = "mnuFileExit";
      var3 = a.i.c.a("mnuFileExit");
      var4 = a.i.b.a("imgs/exit_icon.gif");
      x var11 = new x(this, var3, var4);
      var1.a(var2, var11);
      var2 = "mnuEditUndo";
      var3 = a.i.c.a("mnuEditUndo");
      var4 = a.i.b.a("imgs/undo_icon.gif");
      y var12 = new y(this, var3, var4);
      if (this.b != null && this.b.a() != null) {
         var12.setEnabled(this.b.a().m());
      }

      var1.a(var2, var12);
      var2 = "mnuEditRedo";
      var3 = a.i.c.a("mnuEditRedo");
      var4 = a.i.b.a("imgs/redo_icon.gif");
      z var13 = new z(this, var3, var4);
      if (this.b != null && this.b.a() != null) {
         var13.setEnabled(this.b.a().n());
      }

      var1.a(var2, var13);
      var2 = "mnuEditCopyImage";
      var3 = a.i.c.a("mnuEditCopyImage");
      A var14 = new A(this, var3);
      var1.a(var2, var14);
      var2 = "fontAndLineOptions";
      var3 = a.i.c.a("fontAndLineOptions");
      var4 = a.i.b.a("imgs/font_icon.gif");
      e var15 = new e(this, var3, var4);
      var1.a(var2, var15);
      var2 = "execInstruction";
      var3 = a.i.c.a("execInstruction");
      var4 = a.i.b.a("imgs/run_icon.gif");
      f var16;
      (var16 = new f(this, var3, var4)).setEnabled(false);
      var16.putValue("AcceleratorKey", KeyStroke.getKeyStroke(120, 0));
      var1.a(var2, var16);
      var2 = "execPause";
      var3 = a.i.c.a("execPause");
      var4 = a.i.b.a("imgs/pause_icon.gif");
      g var17;
      (var17 = new g(this, var3, var4)).setEnabled(false);
      var1.a(var2, var17);
      var2 = "execInterrupt";
      var3 = a.i.c.a("execInterrupt");
      var4 = a.i.b.a("imgs/stop_icon.gif");
      h var18;
      (var18 = new h(this, var3, var4)).setEnabled(false);
      var1.a(var2, var18);
      var2 = "execOptions";
      var3 = a.i.c.a("execOptions");
      var4 = a.i.b.a("imgs/execopt_icon.gif");
      i var19;
      (var19 = new i(this, var3, var4)).setEnabled(false);
      var1.a(var2, var19);
      Locale var5 = a.i.c.a();
      var2 = "mnuLanguageItalian";
      var3 = a.i.c.a("mnuLanguageItalian");
      var4 = a.i.b.a("imgs/flag_it.gif");
      j var20;
      (var20 = new j(this, var3, var4)).setEnabled(var5.getLanguage() != Locale.ITALIAN.getLanguage());
      var1.a(var2, var20);
      var2 = "mnuLanguageEnglish";
      var3 = a.i.c.a("mnuLanguageEnglish");
      var4 = a.i.b.a("imgs/flag_gb.gif");
      k var21;
      (var21 = new k(this, var3, var4)).setEnabled(var5.getLanguage() != Locale.ENGLISH.getLanguage());
      var1.a(var2, var21);
      var2 = "mnuHistoryInfo";
      var3 = a.i.c.a("mnuHistoryInfo");
      l var22;
      (var22 = new l(this, var3)).setEnabled(true);
      var1.a(var2, var22);
      var2 = "mnuAuthorInfo";
      var3 = a.i.c.a("mnuAuthorInfo");
      m var23;
      (var23 = new m(this, var3)).setEnabled(true);
      var1.a(var2, var23);
      var2 = "mnuAuthorRegistration";
      var3 = a.i.c.a("mnuAuthorRegistration");
      n var24;
      (var24 = new n(this, var3)).setEnabled(a.f.k.a().d() == null);
      var1.a(var2, var24);
      var2 = "mnuHelpOnline";
      var3 = a.i.c.a("mnuHelpOnline");
      p var25 = new p(this, var3);
      var1.a(var2, var25);
      var2 = "mnuHelpOnlineFunc";
      var3 = a.i.c.a("mnuHelpOnlineFunc");
      q var26 = new q(this, var3);
      var1.a(var2, var26);
      var2 = "mnuHelpABSite";
      var3 = a.i.c.a("mnuHelpABSite");
      r var27 = new r(this, var3);
      var1.a(var2, var27);
      var2 = "mnuHelpAbout";
      var3 = a.i.c.a("mnuHelpAbout");
      s var28 = new s(this, var3);
      var1.a(var2, var28);
      return var1;
   }

   private static JMenu b(String var0) {
      return new JMenu(a.i.c.a(var0));
   }

   private JMenuItem c(String var1) {
      JMenuItem var2;
      (var2 = new JMenuItem(a.i.c.a(var1))).setAction(this.a.a(var1));
      return var2;
   }

   private JMenuBar v() {
      JMenuBar var1 = new JMenuBar();
      JMenu var2;
      (var2 = b("mnuFile")).add(this.c("mnuFileNew"));
      var2.addSeparator();
      var2.add(this.c("mnuFileOpen"));
      var2.add(this.c("mnuFileSave"));
      var2.add(this.c("mnuFileSaveAs"));
      var2.addSeparator();
      var2.add(this.c("mnuFileSaveImage"));
      var2.addSeparator();
      var2.add(this.c("mnuFileExit"));
      var1.add(var2);
      (var2 = b("mnuEdit")).add(this.c("mnuEditUndo"));
      var2.add(this.c("mnuEditRedo"));
      var2.add(this.c("mnuEditCopyImage"));
      var2.addSeparator();
      var2.add(this.c("fontAndLineOptions"));
      var1.add(var2);
      (var2 = b("mnuRun")).add(this.c("execInstruction"));
      var2.add(this.c("execPause"));
      var2.add(this.c("execInterrupt"));
      var2.addSeparator();
      var2.add(this.c("execOptions"));
      var1.add(var2);
      (var2 = b("mnuLanguage")).add(this.c("mnuLanguageEnglish"));
      var2.add(this.c("mnuLanguageItalian"));
      var1.add(var2);
      (var2 = b("mnuAuthor")).add(this.c("mnuHistoryInfo"));
      var2.addSeparator();
      var2.add(this.c("mnuAuthorInfo"));
      var2.add(this.c("mnuAuthorRegistration"));
      var1.add(var2);
      (var2 = b("mnuHelp")).add(this.c("mnuHelpABSite"));
      var2.addSeparator();
      var2.add(this.c("mnuHelpOnline"));
      var2.add(this.c("mnuHelpOnlineFunc"));
      var2.addSeparator();
      var2.add(this.c("mnuHelpAbout"));
      var1.add(var2);
      return var1;
   }

   private JButton d(String var1) {
      JButton var2;
      (var2 = new JButton()).setAction(this.a.a(var1));
      var2.setToolTipText(var2.getText());
      var2.setText("");
      var2.setMargin(new Insets(0, 0, 0, 0));
      return var2;
   }

   private JToolBar w() {
      JToolBar var1;
      (var1 = new JToolBar(a.i.c.a("toolbarOperations"))).setFloatable(false);
      var1.add(this.d("mnuFileNew"));
      var1.add(this.d("mnuFileOpen"));
      var1.add(this.d("mnuFileSave"));
      var1.add(this.d("mnuFileSaveAs"));
      var1.addSeparator();
      var1.add(this.d("mnuEditUndo"));
      var1.add(this.d("mnuEditRedo"));
      var1.addSeparator();
      var1.add(this.d("fontAndLineOptions"));
      var1.add(this.d("execOptions"));
      var1.addSeparator();
      var1.add(this.d("execInstruction"));
      var1.add(this.d("execPause"));
      var1.add(this.d("execInterrupt"));
      return var1;
   }

   public final void a(String var1, boolean var2) {
      this.a.a(var1).setEnabled(var2);
   }

   public final void c() {
      if (!this.b.b() || this.b.a().e()) {
         this.b.a(new package_a.j.a.g(this));
         this.a.a("execInstruction").setEnabled(true);
         this.a.a("execOptions").setEnabled(true);
         this.b.setTitle("");
      }

   }

   public final void d() {
      if (!this.b.b()) {
         this.b.a(new package_a.j.a.g(this));
      }

      if (this.b.b()) {
         this.b.a().c();
      }

   }

   public final String e() {
      String var1 = null;
      if (this.c == null) {
         this.d = a.f.j.c().getAbsolutePath();
         this.c = new JFileChooser(this.d);
         FileNameExtensionFilter var2 = new FileNameExtensionFilter("AlgoBuild files *.algobuild", new String[]{"algobuild"});
         this.c.setFileFilter(var2);
         this.c.setFileSelectionMode(0);
      }

      if (this.c.showOpenDialog(this.b) == 0) {
         var1 = this.c.getSelectedFile().getAbsolutePath();
      }

      return var1;
   }

   public final String a(String var1) {
      String var2 = null;
      if (this.c == null) {
         this.d = a.f.j.c().getAbsolutePath();
         this.c = new JFileChooser(this.d);
         FileNameExtensionFilter var3 = new FileNameExtensionFilter("AlgoBuild files *.algobuild", new String[]{"algobuild"});
         this.c.setFileFilter(var3);
         this.c.setFileSelectionMode(0);
      }

      if (var1 != null) {
         this.c.setSelectedFile(new File(var1));
      }

      if (this.c.showSaveDialog(this.b) == 0) {
         var1 = this.c.getSelectedFile().getName();
         var2 = this.c.getSelectedFile().getAbsolutePath();
         FileFilter var4;
         if ((var4 = this.c.getFileFilter()) != null && var4 instanceof FileNameExtensionFilter) {
            String[] var5 = ((FileNameExtensionFilter)var4).getExtensions();
            if (!var1.contains(".") && var5.length > 0 && var5[0] != null) {
               var2 = var2 + "." + var5[0];
            }
         }

         String var6 = this.c.getSelectedFile().getParent();
         this.d = var6;
      }

      return var2;
   }

   public final void f() {
      if (this.b.b()) {
         this.b.a().f();
      }

   }

   public final void g() {
      if (this.b.b()) {
         this.b.a().g();
      }

   }

   public final void h() {
      boolean var1 = true;
      if (this.b.b() && !this.b.a().e()) {
         var1 = false;
         if (JOptionPane.showConfirmDialog(this.b, a.i.c.a("modifiedSaveQuestion"), "AlgoBuild", 2, 3) == 0) {
            var1 = true;
         }
      }

      if (var1) {
         System.exit(0);
      }

   }

   public final void i() {
      if (this.b.b()) {
         this.b.a().h();
      }

   }

   public final void j() {
      if (this.b.b()) {
         this.b.a().i();
      }

   }

   public final void k() {
      if (this.b.b()) {
         this.b.a().j();
      }

   }

   public final void l() {
      if (this.b.b()) {
         this.b.a().k();
      }

   }

   public final void m() {
      if (this.b.b()) {
         this.b.a().l();
      }

   }

   public final void n() {
      if (this.b.b()) {
         this.b.a().o();
      }

   }

   public final void o() {
      if (this.b.b()) {
         this.b.a().p();
      }

   }

   public final void a(Locale var1) {
      a.i.c.a(var1);
      a.i.c.a("mnuFileExit");
      a.i.c.a("mnuEditUndo");
      SwingUtilities.invokeLater(new t(this));
   }

   public final void p() {
      String var1;
      if ((var1 = a.f.k.a().d()) == null) {
         var1 = a.i.c.a("authorNotRegistered");
      }

      var1 = "AlgoBuild\n" + a.i.c.a("infoVersion") + " 0" + ".85" + "\n" + a.i.c.a("infoBuild") + " 00085_20200418_1930" + "\n(C) Paolo Santi 2011-2020" + "\n\n" + a.i.c.a("authorRegisteredInfo") + "\n" + a.i.c.a("infoSerial") + ": " + a.f.k.a().b() + "\n" + a.i.c.a("authorName") + ": " + var1;
      Object[] var2 = new Object[]{"OK", a.i.c.a("infoWebSite")};
      if (JOptionPane.showOptionDialog(this.b, var1, a.i.c.a("infoAbout"), 0, 1, new ImageIcon(this.b.getIconImage()), var2, var2[0]) == 1) {
         try {
            Desktop.getDesktop().browse(new URI(a.i.c.a("infoWebURL")));
            return;
         } catch (IOException var3) {
            var3.printStackTrace();
            return;
         } catch (URISyntaxException var4) {
            var4.printStackTrace();
         }
      }

   }

   public final void q() {
      package_a.j.a.g var1;
      if (this.b != null && (var1 = this.b.a()) != null) {
         var1.q();
      }

   }

   public final void r() {
      package_a.j.a.g var1;
      if (this.b != null && (var1 = this.b.a()) != null) {
         var1.r();
      }

   }

   public final void s() {
      package_a.f.k var1 = a.f.k.a();
      if (this.b != null && var1 != null) {
         String var2;
         String var5;
         if ((var5 = var1.d()) == null) {
            var5 = a.i.c.a("authorNotRegistered");
            var2 = a.i.c.a("authorCodeRequestToRegister");
         } else {
            var2 = a.i.c.a("authorCodeRequestToRegisterOther");
         }

         var5 = a.i.c.a("authorName") + ": " + var5 + "\n\n" + var2;
         Object[] var6 = new Object[]{"OK", a.i.c.a("authorCodeRequestInfo")};
         if (JOptionPane.showOptionDialog(this.b, var5, a.i.c.a("authorInfo"), 0, 1, new ImageIcon(this.b.getIconImage()), var6, var6[0]) == 1) {
            try {
               Desktop.getDesktop().browse(new URI(a.i.c.a("authorCodeRequestPage")));
               return;
            } catch (IOException var3) {
               var3.printStackTrace();
               return;
            } catch (URISyntaxException var4) {
               var4.printStackTrace();
            }
         }
      }

   }

   public final void t() {
      if (this.b != null) {
         this.b.a().s();
      }

   }

   // $FF: synthetic method
   static a a(c var0) {
      return var0.u();
   }

   // $FF: synthetic method
   static C b(c var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static JMenuBar c(c var0) {
      return var0.v();
   }

   // $FF: synthetic method
   static JToolBar d(c var0) {
      return var0.w();
   }

   // $FF: synthetic method
   static a e(c var0) {
      return var0.a;
   }
}
