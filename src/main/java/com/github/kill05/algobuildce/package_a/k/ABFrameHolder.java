package com.github.kill05.algobuildce.package_a.k;

import com.github.kill05.algobuildce.package_a.f.ABFiles;
import com.github.kill05.algobuildce.package_a.f.ABUserData;
import com.github.kill05.algobuildce.package_a.i.ImageUtils;
import com.github.kill05.algobuildce.package_a.i.Translator;
import com.github.kill05.algobuildce.package_a.j.a.ABProgramPanel;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

public class ABFrameHolder {

    private static ABFrameHolder INSTANCE = null;

    private final ABFrame frame;
    private ActionMap actionMap;
    private final JFileChooser fileChooser;

    private ABFrameHolder() {
        this.frame = new ABFrame();

        Dimension var1 = Toolkit.getDefaultToolkit().getScreenSize();
        this.frame.setSize((int) (var1.getWidth() * 0.9), (int) (var1.getHeight() * 0.65));
        this.frame.setLocation((int) (var1.getWidth() * 0.05), (int) (var1.getHeight() * 0.05));
        this.actionMap = this.createActionMap();
        this.frame.setJMenuBar(this.createMenuBar());
        this.frame.setToolBar(this.createToolBar());
        this.frame.setVisible(true);
        this.frame.setProgramPanel(new ABProgramPanel(this));
        this.actionMap.getAction("mnuFileSaveAs").setEnabled(true);
        this.actionMap.getAction("execInstruction").setEnabled(true);
        this.actionMap.getAction("execOptions").setEnabled(true);
        this.frame.setFrameHolder(this);

        this.fileChooser = new JFileChooser(ABFiles.getABFolder().getAbsolutePath()); // todo: save last path selected
        this.fileChooser.setFileFilter(new FileNameExtensionFilter("AlgoBuild files *.algobuild", "algobuild"));
        this.fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    }

    public static ABFrameHolder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ABFrameHolder();
        }

        return INSTANCE;
    }

    public final ABFrame getFrame() {
        return this.frame;
    }

    private ActionMap createActionMap() {
        ActionMap var1 = new ActionMap();
        String var2 = "mnuFileNew";
        String var3 = Translator.translate("mnuFileNew");
        ImageIcon var4 = ImageUtils.loadImage("imgs/new_icon.gif");
        d var6 = new d(this, var3, var4);
        var1.putAction(var2, var6);
        var2 = "mnuFileOpen";
        var3 = Translator.translate("mnuFileOpen");
        var4 = ImageUtils.loadImage("imgs/open_icon.gif");
        o var7 = new o(this, var3, var4);
        var1.putAction(var2, var7);
        var2 = "mnuFileSave";
        var3 = Translator.translate("mnuFileSave");
        var4 = ImageUtils.loadImage("imgs/save_icon.gif");
        u var8;
        (var8 = new u(this, var3, var4)).setEnabled(false);
        var1.putAction(var2, var8);
        var2 = "mnuFileSaveAs";
        var3 = Translator.translate("mnuFileSaveAs");
        var4 = ImageUtils.loadImage("imgs/saveas_icon.gif");
        v var9;
        (var9 = new v(this, var3, var4)).setEnabled(false);
        var1.putAction(var2, var9);
        var2 = "mnuFileSaveImage";
        var3 = Translator.translate("mnuFileSaveImage");
        w var10 = new w(this, var3);
        var1.putAction(var2, var10);
        var2 = "mnuFileExit";
        var3 = Translator.translate("mnuFileExit");
        var4 = ImageUtils.loadImage("imgs/exit_icon.gif");
        x var11 = new x(this, var3, var4);
        var1.putAction(var2, var11);
        var2 = "mnuEditUndo";
        var3 = Translator.translate("mnuEditUndo");
        var4 = ImageUtils.loadImage("imgs/undo_icon.gif");
        y var12 = new y(this, var3, var4);
        if (this.frame != null && this.frame.getProgramPanel() != null) {
            var12.setEnabled(this.frame.getProgramPanel().m());
        }

        var1.putAction(var2, var12);
        var2 = "mnuEditRedo";
        var3 = Translator.translate("mnuEditRedo");
        var4 = ImageUtils.loadImage("imgs/redo_icon.gif");
        z var13 = new z(this, var3, var4);
        if (this.frame != null && this.frame.getProgramPanel() != null) {
            var13.setEnabled(this.frame.getProgramPanel().n());
        }

        var1.putAction(var2, var13);
        var2 = "mnuEditCopyImage";
        var3 = Translator.translate("mnuEditCopyImage");
        A_innerclass var14 = new A_innerclass(this, var3);
        var1.putAction(var2, var14);
        var2 = "fontAndLineOptions";
        var3 = Translator.translate("fontAndLineOptions");
        var4 = ImageUtils.loadImage("imgs/font_icon.gif");
        e var15 = new e(this, var3, var4);
        var1.putAction(var2, var15);
        var2 = "execInstruction";
        var3 = Translator.translate("execInstruction");
        var4 = ImageUtils.loadImage("imgs/run_icon.gif");
        f var16;
        (var16 = new f(this, var3, var4)).setEnabled(false);
        var16.putValue("AcceleratorKey", KeyStroke.getKeyStroke(120, 0));
        var1.putAction(var2, var16);
        var2 = "execPause";
        var3 = Translator.translate("execPause");
        var4 = ImageUtils.loadImage("imgs/pause_icon.gif");
        com.github.kill05.algobuildce.package_a.k.g var17;
        (var17 = new com.github.kill05.algobuildce.package_a.k.g(this, var3, var4)).setEnabled(false);
        var1.putAction(var2, var17);
        var2 = "execInterrupt";
        var3 = Translator.translate("execInterrupt");
        var4 = ImageUtils.loadImage("imgs/stop_icon.gif");
        h var18;
        (var18 = new h(this, var3, var4)).setEnabled(false);
        var1.putAction(var2, var18);
        var2 = "execOptions";
        var3 = Translator.translate("execOptions");
        var4 = ImageUtils.loadImage("imgs/execopt_icon.gif");
        i var19;
        (var19 = new i(this, var3, var4)).setEnabled(false);
        var1.putAction(var2, var19);
        Locale var5 = Translator.getLocale();
        var2 = "mnuLanguageItalian";
        var3 = Translator.translate("mnuLanguageItalian");
        var4 = ImageUtils.loadImage("imgs/flag_it.gif");
        j var20;
        (var20 = new j(this, var3, var4)).setEnabled(var5.getLanguage() != Locale.ITALIAN.getLanguage());
        var1.putAction(var2, var20);
        var2 = "mnuLanguageEnglish";
        var3 = Translator.translate("mnuLanguageEnglish");
        var4 = ImageUtils.loadImage("imgs/flag_gb.gif");
        k var21;
        (var21 = new k(this, var3, var4)).setEnabled(var5.getLanguage() != Locale.ENGLISH.getLanguage());
        var1.putAction(var2, var21);
        var2 = "mnuHistoryInfo";
        var3 = Translator.translate("mnuHistoryInfo");
        l var22;
        (var22 = new l(this, var3)).setEnabled(true);
        var1.putAction(var2, var22);
        var2 = "mnuAuthorInfo";
        var3 = Translator.translate("mnuAuthorInfo");
        m var23;
        (var23 = new m(this, var3)).setEnabled(true);
        var1.putAction(var2, var23);
        var2 = "mnuAuthorRegistration";
        var3 = Translator.translate("mnuAuthorRegistration");
        n var24;
        (var24 = new n(this, var3)).setEnabled(ABUserData.getInstance().d() == null);
        var1.putAction(var2, var24);
        var2 = "mnuHelpOnline";
        var3 = Translator.translate("mnuHelpOnline");
        p var25 = new p(this, var3);
        var1.putAction(var2, var25);
        var2 = "mnuHelpOnlineFunc";
        var3 = Translator.translate("mnuHelpOnlineFunc");
        q var26 = new q(this, var3);
        var1.putAction(var2, var26);
        var2 = "mnuHelpABSite";
        var3 = Translator.translate("mnuHelpABSite");
        r var27 = new r(this, var3);
        var1.putAction(var2, var27);
        var2 = "mnuHelpAbout";
        var3 = Translator.translate("mnuHelpAbout");
        s var28 = new s(this, var3);
        var1.putAction(var2, var28);
        return var1;
    }

    private static JMenu createMenu(String translationKey) {
        return new JMenu(Translator.translate(translationKey));
    }

    private JMenuItem createMenuItem(String key) {
        JMenuItem menuItem = new JMenuItem(Translator.translate(key));
        menuItem.setAction(this.actionMap.getAction(key));
        return menuItem;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu var2;
        (var2 = createMenu("mnuFile")).add(this.createMenuItem("mnuFileNew"));
        var2.addSeparator();
        var2.add(this.createMenuItem("mnuFileOpen"));
        var2.add(this.createMenuItem("mnuFileSave"));
        var2.add(this.createMenuItem("mnuFileSaveAs"));
        var2.addSeparator();
        var2.add(this.createMenuItem("mnuFileSaveImage"));
        var2.addSeparator();
        var2.add(this.createMenuItem("mnuFileExit"));
        menuBar.add(var2);
        (var2 = createMenu("mnuEdit")).add(this.createMenuItem("mnuEditUndo"));
        var2.add(this.createMenuItem("mnuEditRedo"));
        var2.add(this.createMenuItem("mnuEditCopyImage"));
        var2.addSeparator();
        var2.add(this.createMenuItem("fontAndLineOptions"));
        menuBar.add(var2);
        (var2 = createMenu("mnuRun")).add(this.createMenuItem("execInstruction"));
        var2.add(this.createMenuItem("execPause"));
        var2.add(this.createMenuItem("execInterrupt"));
        var2.addSeparator();
        var2.add(this.createMenuItem("execOptions"));
        menuBar.add(var2);
        (var2 = createMenu("mnuLanguage")).add(this.createMenuItem("mnuLanguageEnglish"));
        var2.add(this.createMenuItem("mnuLanguageItalian"));
        menuBar.add(var2);
        (var2 = createMenu("mnuAuthor")).add(this.createMenuItem("mnuHistoryInfo"));
        var2.addSeparator();
        var2.add(this.createMenuItem("mnuAuthorInfo"));
        var2.add(this.createMenuItem("mnuAuthorRegistration"));
        menuBar.add(var2);
        (var2 = createMenu("mnuHelp")).add(this.createMenuItem("mnuHelpABSite"));
        var2.addSeparator();
        var2.add(this.createMenuItem("mnuHelpOnline"));
        var2.add(this.createMenuItem("mnuHelpOnlineFunc"));
        var2.addSeparator();
        var2.add(this.createMenuItem("mnuHelpAbout"));
        menuBar.add(var2);
        return menuBar;
    }

    private JButton d(String var1) {
        JButton var2;
        (var2 = new JButton()).setAction(this.actionMap.getAction(var1));
        var2.setToolTipText(var2.getText());
        var2.setText("");
        var2.setMargin(new Insets(0, 0, 0, 0));
        return var2;
    }

    private JToolBar createToolBar() {
        JToolBar var1;
        (var1 = new JToolBar(Translator.translate("toolbarOperations"))).setFloatable(false);
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

    public final void setActionEnabled(String action, boolean enabled) {
        this.actionMap.getAction(action).setEnabled(enabled);
    }

    public final void reset() {
        if (!this.frame.hasMainPanel() || this.frame.getProgramPanel().e()) {
            this.frame.setProgramPanel(new ABProgramPanel(this));
            this.actionMap.getAction("execInstruction").setEnabled(true);
            this.actionMap.getAction("execOptions").setEnabled(true);
            this.frame.setTitle("");
        }

    }

    public final void d() {
        if (!this.frame.hasMainPanel()) {
            this.frame.setProgramPanel(new ABProgramPanel(this));
        }

        if (this.frame.hasMainPanel()) {
            this.frame.getProgramPanel().c();
        }

    }

    @Nullable
    public File selectFile(String approveButtonText) {
        if (this.fileChooser.showDialog(this.frame, approveButtonText) == JFileChooser.APPROVE_OPTION) {
            return this.fileChooser.getSelectedFile();
        }

        return null;
    }

    @Nullable
    public String selectFilePath(String approveButtonText) {
        File file = selectFile(approveButtonText);
        return file != null ? file.getAbsolutePath() : null;
    }

    public final String saveFile(String name) {
        if (name != null) {
            this.fileChooser.setSelectedFile(new File(name));
        }

        File file = selectFile(Translator.translate("mnuFileSave"));
        if (file == null) return null;

        name = file.getName();
        String path = file.getAbsolutePath();

        FileFilter filter = this.fileChooser.getFileFilter();
        if (filter instanceof FileNameExtensionFilter) {
            String[] extensions = ((FileNameExtensionFilter) filter).getExtensions();
            if (!name.contains(".") && extensions.length > 0 && extensions[0] != null) {
                path = path + "." + extensions[0];
            }
        }

        fileChooser.setSelectedFile(this.fileChooser.getSelectedFile().getParentFile());

        return path;
    }

    public final void f() {
        if (this.frame.hasMainPanel()) {
            this.frame.getProgramPanel().f();
        }

    }

    public final void g() {
        if (this.frame.hasMainPanel()) {
            this.frame.getProgramPanel().g();
        }

    }

    public final void onClose() {
        boolean close = true;
        if (this.frame.hasMainPanel() && !this.frame.getProgramPanel().e()) {
            close = JOptionPane.showConfirmDialog(this.frame, Translator.translate("modifiedSaveQuestion"), "AlgoBuild", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == 0;
        }

        if (close) {
            System.exit(0);
        }

    }

    public final void i() {
        if (this.frame.hasMainPanel()) {
            this.frame.getProgramPanel().h();
        }

    }

    public final void j() {
        if (this.frame.hasMainPanel()) {
            this.frame.getProgramPanel().i();
        }

    }

    public final void k() {
        if (this.frame.hasMainPanel()) {
            this.frame.getProgramPanel().j();
        }

    }

    public final void l() {
        if (this.frame.hasMainPanel()) {
            this.frame.getProgramPanel().k();
        }

    }

    public final void m() {
        if (this.frame.hasMainPanel()) {
            this.frame.getProgramPanel().l();
        }

    }

    public final void n() {
        if (this.frame.hasMainPanel()) {
            this.frame.getProgramPanel().o();
        }

    }

    public final void o() {
        if (this.frame.hasMainPanel()) {
            this.frame.getProgramPanel().p();
        }

    }

    public final void setLocale(Locale var1) {
        Translator.setLocale(var1);
        Translator.translate("mnuFileExit");
        Translator.translate("mnuEditUndo");
        SwingUtilities.invokeLater(() -> {
            actionMap = createActionMap();
            getFrame().setJMenuBar(createMenuBar());
            getFrame().setToolBar(createToolBar());
            setActionEnabled("mnuFileSaveAs", true);
            setActionEnabled("execInstruction", true);
            setActionEnabled("execOptions", true);

            if (frame.getProgramPanel() != null) {
                actionMap.getAction("mnuEditUndo").setEnabled(frame.getProgramPanel().m());
            }

            if (frame.getProgramPanel() != null) {
                actionMap.getAction("mnuEditRedo").setEnabled(frame.getProgramPanel().n());
            }

            if (frame.getProgramPanel() != null) {
                frame.getProgramPanel().d();
            }

            frame.revalidate();
        });
    }

    public final void p() {
        String var1;
        if ((var1 = ABUserData.getInstance().d()) == null) {
            var1 = Translator.translate("authorNotRegistered");
        }

        var1 = "AlgoBuild\n" + Translator.translate("infoVersion") + " 0" + ".85" + "\n" + Translator.translate("infoBuild") + " 00085_20200418_1930" + "\n(C) Paolo Santi 2011-2020" + "\n\n" + Translator.translate("authorRegisteredInfo") + "\n" + Translator.translate("infoSerial") + ": " + ABUserData.getInstance().getSerial() + "\n" + Translator.translate("authorName") + ": " + var1;
        Object[] var2 = new Object[]{"OK", Translator.translate("infoWebSite")};
        if (JOptionPane.showOptionDialog(this.frame, var1, Translator.translate("infoAbout"), 0, 1, new ImageIcon(this.frame.getIconImage()), var2, var2[0]) == 1) {
            try {
                Desktop.getDesktop().browse(new URI(Translator.translate("infoWebURL")));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }

    }

    public final void q() {
        ABProgramPanel var1;
        if (this.frame != null && (var1 = this.frame.getProgramPanel()) != null) {
            var1.q();
        }

    }

    public final void r() {
        ABProgramPanel var1;
        if (this.frame != null && (var1 = this.frame.getProgramPanel()) != null) {
            var1.r();
        }

    }

    public final void s() {
        ABUserData var1 = ABUserData.getInstance();
        if (this.frame != null && var1 != null) {
            String var2;
            String var5;
            if ((var5 = var1.d()) == null) {
                var5 = Translator.translate("authorNotRegistered");
                var2 = Translator.translate("authorCodeRequestToRegister");
            } else {
                var2 = Translator.translate("authorCodeRequestToRegisterOther");
            }

            var5 = Translator.translate("authorName") + ": " + var5 + "\n\n" + var2;
            Object[] var6 = new Object[]{"OK", Translator.translate("authorCodeRequestInfo")};
            if (JOptionPane.showOptionDialog(this.frame, var5, Translator.translate("authorInfo"), JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.frame.getIconImage()), var6, var6[0]) == 1) {
                try {
                    Desktop.getDesktop().browse(new URI(Translator.translate("authorCodeRequestPage")));
                } catch (IOException | URISyntaxException var3) {
                    var3.printStackTrace();
                }
            }
        }

    }

    public final void t() {
        if (this.frame != null) {
            this.frame.getProgramPanel().s();
        }

    }

}

