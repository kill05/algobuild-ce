package com.github.kill05.algobuildce.package_a.j.a;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.b.q;
import com.github.kill05.algobuildce.package_a.f.ABFiles;
import com.github.kill05.algobuildce.package_a.i.ImageUtils;
import com.github.kill05.algobuildce.package_a.i.Translator;
import com.github.kill05.algobuildce.package_a.j.b.C_subclass;
import com.github.kill05.algobuildce.package_a.j.b.D_subclass;
import com.github.kill05.algobuildce.package_a.j.b.p;
import com.github.kill05.algobuildce.package_a.k.ABFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.Box;
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
    ABProgram a;
    private ABProgramPanel c;
    JTabbedPane b;
    private int d = -1;
    private ABFrame e;
    private final D_subclass h;
    private final Vector<com.github.kill05.algobuildce.package_a.j.b.c> i = new Vector<>();

    public a() {
        this.setLayout(new BorderLayout());
        this.h = new p();
        ImageUtils.loadImage("imgs/logo2_arancio_small.png");
        ImageUtils.loadImage("imgs/logo2_arancio_small.png");
        this.b = new JTabbedPane();
        this.add(this.b, "Center");
        this.b.addTab("+", new JPanel());
        this.b.addChangeListener(this);
    }

    public ABFrame a() {
        return this.e;
    }

    public void a(ABFrame var1) {
        this.e = var1;
    }

    @Override
    public void actionPerformed(ActionEvent var1) {
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

    public void a(ABExecutable var1) {
        int var2 = this.b.getTabCount();
        String var3 = var1.b();
        com.github.kill05.algobuildce.package_a.j.b.c var4;
        (var4 = new com.github.kill05.algobuildce.package_a.j.b.c(this.a, this, var1)).setBackground(Color.YELLOW);
        var1.a(var4);
        var4.g();
        var4.setAlignmentX(0.5F);
        Box var5;
        (var5 = Box.createVerticalBox()).add(var4);
        JScrollPane var11;
        (var11 = new JScrollPane(var5)).getHorizontalScrollBar().setUnitIncrement(15);
        var11.getVerticalScrollBar().setUnitIncrement(15);
        com.github.kill05.algobuildce.package_a.j.b.c var6 = new com.github.kill05.algobuildce.package_a.j.b.c(this.a, this, var1);
        var1.a(var6);
        var6.g();
        var6.setAlignmentX(0.5F);
        Box var8;
        (var8 = Box.createVerticalBox()).add(var6);
        JScrollPane var9 = new JScrollPane(var8);
        var11.getHorizontalScrollBar().setUnitIncrement(15);
        var11.getVerticalScrollBar().setUnitIncrement(15);
        C_subclass var7 = this.h.a(var6);
        var6.a(var7);
        JSplitPane var10;
        (var10 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, var11, var9)).setResizeWeight(0.5D);
        var10.setDividerSize(4);
        if (var2 == 0) {
            this.b.addTab(var3, var10);
            this.i.add(var4);
        } else {
            this.b.insertTab(var3, null, var10, null, var2 - 1);
            this.b.setSelectedIndex(var2 - 1);
            this.i.add(var2 - 1, var4);
        }

        var4.revalidate();
        this.updateUI();
    }

    public void b() {
        this.b.removeAll();
        this.d = -1;
        this.b.addTab("+", new JPanel());
    }

    @Override
    public void stateChanged(ChangeEvent var1) {
        int var7;
        if ((var7 = this.b.getSelectedIndex()) >= 0) {
            String var2 = this.b.getTitleAt(var7);
            if (this.d >= 0 && var2.equals("+")) {
                this.d = -1;
                boolean var3 = false;
                String var4 = "newCode";

                for (int var5 = 0; var5 < 10 && !var3; ++var5) {
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
                    if (!com.github.kill05.algobuildce.package_a.a.c.a(this.e, var9, this.a)) {
                        this.d = 0;
                        this.b.setSelectedIndex(0);
                        this.a.b(var4);
                    } else {
                        com.github.kill05.algobuildce.package_a.g.a var8 = new com.github.kill05.algobuildce.package_a.g.a(this.a, var9);
                        this.c.a(var8);
                    }
                }
            }

            if (!var2.equals("+")) {
                this.d = var7;
            }
        }

    }

    public void a(ABProgramPanel var1) {
        this.c = var1;
    }

    public ABProgramPanel c() {
        return this.c;
    }

    public void a(String var1, q var2) {
        int var3;
        if ((var3 = this.b.indexOfTab(var1)) >= 0) {
            this.b.setTitleAt(var3, var2.j());
        }

    }

    public void b(ABExecutable var1) {
        String var2 = ((q) var1).j();
        int var3 = this.b.indexOfTab(var2);
        this.d = 0;
        this.b.setSelectedIndex(0);
        if (var3 >= 0) {
            this.b.remove(var3);
            this.i.remove(var3);
        }

    }

    public void d() {
        int var1 = this.b.getSelectedIndex();
        com.github.kill05.algobuildce.package_a.j.b.c var5 = (com.github.kill05.algobuildce.package_a.j.b.c) this.i.elementAt(var1);
        com.github.kill05.algobuildce.package_a.i.d var2 = new com.github.kill05.algobuildce.package_a.i.d(var5);
        int var3 = var5.getWidth();
        int var4 = var5.getHeight();
        BufferedImage var7;
        Graphics2D var8;
        (var8 = (var7 = new BufferedImage(var3, var4, 1)).createGraphics()).setFont(this.a.getViewOptions().getCodeFont());
        var2.a(var8, var5);
        var8.dispose();
        com.github.kill05.algobuildce.package_a.i.e var6 = new com.github.kill05.algobuildce.package_a.i.e(var7);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(var6, null);
    }

    public void e() {
        JFileChooser var1 = new JFileChooser(ABFiles.getABFolder().getAbsolutePath());
        FileNameExtensionFilter var2 = new FileNameExtensionFilter("Immagine *.gif", "gif");
        var1.addChoosableFileFilter(var2);
        var2 = new FileNameExtensionFilter("Immagine *.jpg", "jpg");
        var1.addChoosableFileFilter(var2);
        var2 = new FileNameExtensionFilter("Immagine *.png", "png");
        var1.addChoosableFileFilter(var2);
        var1.setFileSelectionMode(0);
        var1.setFileFilter(var2);
        if (var1.showSaveDialog(this.e) == 0) {
            String var11 = var1.getSelectedFile().getAbsolutePath();
            FileFilter var8;
            if ((var8 = var1.getFileFilter()) != null && var8 instanceof FileNameExtensionFilter) {
                String[] var9 = ((FileNameExtensionFilter) var8).getExtensions();
                if (!var11.contains(".") && var9.length > 0 && var9[0] != null) {
                    var11 = var11 + "." + var9[0];
                }
            }

            String var10 = var11.substring(var11.lastIndexOf(46) + 1);
            int var3 = this.b.getSelectedIndex();
            com.github.kill05.algobuildce.package_a.j.b.c var12 = (com.github.kill05.algobuildce.package_a.j.b.c) this.i.elementAt(var3);
            com.github.kill05.algobuildce.package_a.i.d var4 = new com.github.kill05.algobuildce.package_a.i.d(var12);
            int var5 = var12.getWidth();
            int var6 = var12.getHeight();
            BufferedImage var14;
            Graphics2D var15;
            (var15 = (var14 = new BufferedImage(var5, var6, 1)).createGraphics()).setFont(this.a.getViewOptions().getCodeFont());
            var4.a(var15, var12);
            var15.dispose();

            try {
                File var13 = new File(var11);
                ImageIO.write(var14, var10, var13);
            } catch (IOException var7) {
                var7.printStackTrace();
            }
        }

    }
}
