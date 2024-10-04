package com.github.kill05.algobuildce.package_a.j.a;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.b.q;
import com.github.kill05.algobuildce.package_a.f.ABFiles;
import com.github.kill05.algobuildce.package_a.i.ImageUtils;
import com.github.kill05.algobuildce.package_a.i.Translator;
import com.github.kill05.algobuildce.package_a.j.b.ABFlowChartPanel;
import com.github.kill05.algobuildce.package_a.j.b.C_subclass;
import com.github.kill05.algobuildce.package_a.j.b.D_subclass;
import com.github.kill05.algobuildce.package_a.j.b.p;
import com.github.kill05.algobuildce.package_a.k.ABFrame;
import org.jetbrains.annotations.Nullable;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public final class ABTabbedProgramPanel extends JPanel implements ActionListener, ChangeListener {

    ABProgram program;
    private ABProgramPanel c;
    JTabbedPane tabbedPane;
    private int d = -1;
    private ABFrame frame;
    private final D_subclass h;
    private final Vector<ABFlowChartPanel> i = new Vector<>();

    public ABTabbedProgramPanel() {
        this.setLayout(new BorderLayout());
        this.h = new p();
        ImageUtils.loadImage("imgs/logo2_arancio_small.png");
        ImageUtils.loadImage("imgs/logo2_arancio_small.png");
        this.tabbedPane = new JTabbedPane();
        this.add(this.tabbedPane, "Center");
        this.tabbedPane.addTab("+", new JPanel());
        this.tabbedPane.addChangeListener(this);
    }

    public ABFrame getFrame() {
        return this.frame;
    }

    public void setFrame(ABFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        /*
        if (event.getSource() == null) {
            JPopupMenu var5 = new JPopupMenu();
            JMenuItem var6;
            (var6 = new JMenuItem(Translator.translate("instructionConnectorNewMsg"))).setEnabled(false);
            var5.add(var6);
            JMenuItem var3;
            (var3 = new JMenuItem(Translator.translate("abvfcAddCodePopupNewProcedure"))).addActionListener(this);
            var5.add(var3);
            (var3 = new JMenuItem(Translator.translate("abvfcAddCodePopupNewFunction"))).addActionListener(this);
            var5.add(var3);
            var5.show(this, this.getX(), this.getY());
        } else {
         */

        String var2;
        String var4;
        if ((var4 = event.getActionCommand()) != null && var4.equals(Translator.translate("abvfcAddCodePopupNewProcedure"))) {
            var2 = JOptionPane.showInputDialog(this, Translator.translate("abvfcAddCodeNewProcedureNameMsg"));
            if (this.program.a(var2) == null) {
                this.program.createPage(var2, 2);
            } else {
                JOptionPane.showMessageDialog(this, Translator.translate("abvfcAddCodeNameAlreadyPresentMsg"), Translator.translate("abvfcAddCodePopupNewMsg"), 0);
            }
        } else {
            if (var4 != null && var4.equals(Translator.translate("abvfcAddCodePopupNewFunction"))) {
                var2 = JOptionPane.showInputDialog(this, Translator.translate("abvfcAddCodeNewFunctionNameMsg"));
                if (this.program.a(var2) == null) {
                    this.program.createPage(var2, 3);
                    return;
                }

                JOptionPane.showMessageDialog(this, Translator.translate("abvfcAddCodeNameAlreadyPresentMsg"), Translator.translate("abvfcAddCodePopupNewMsg"), 0);
            }

        }

    }

    public void a(ABExecutable executable) {
        int tabCount = this.tabbedPane.getTabCount();
        String name = executable.getDisplayName();

        // Left
        ABFlowChartPanel leftPanel = new ABFlowChartPanel(this.program, this, executable) {
            @Override
            public void forceSize(@Nullable Dimension size) {
                setPreferredSize(size);
                if (size != null) setSize(size);
            }
        };

        executable.a(leftPanel);
        leftPanel.g();
        leftPanel.setAlignmentX(0.5F);
        leftPanel.setLayout(new BorderLayout()); // Set layout to fill the entire box
        leftPanel.setBackground(Color.YELLOW);

        Box leftBox = Box.createVerticalBox();
        leftBox.add(leftPanel);

        JScrollPane leftScrollPane = new JScrollPane(leftBox);
        leftScrollPane.getHorizontalScrollBar().setUnitIncrement(15);
        leftScrollPane.getVerticalScrollBar().setUnitIncrement(15);

        // Right
        ABFlowChartPanel rightPane = new ABFlowChartPanel(this.program, this, executable);
        executable.a(rightPane);
        rightPane.g();
        rightPane.setAlignmentX(0.5F);

        Box rightBox = Box.createVerticalBox();
        rightBox.add(rightPane, BorderLayout.CENTER);

        JScrollPane rightScrollPane = new JScrollPane(rightBox);
        leftScrollPane.getHorizontalScrollBar().setUnitIncrement(15);
        leftScrollPane.getVerticalScrollBar().setUnitIncrement(15);

        C_subclass var7 = this.h.a(rightPane);
        rightPane.a(var7);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, rightScrollPane);
        splitPane.setResizeWeight(0.5D);
        splitPane.setDividerSize(4);

        if (tabCount == 0) {
            this.tabbedPane.addTab(name, splitPane);
            this.i.add(leftPanel);
        } else {
            this.tabbedPane.insertTab(name, null, splitPane, null, tabCount - 1);
            this.tabbedPane.setSelectedIndex(tabCount - 1);
            this.i.add(tabCount - 1, leftPanel);
        }

        leftPanel.revalidate();
        this.updateUI();
    }

    public void b() {
        this.tabbedPane.removeAll();
        this.d = -1;
        this.tabbedPane.addTab("+", new JPanel());
    }

    @Override
    public void stateChanged(ChangeEvent var1) {
        int var7;
        if ((var7 = this.tabbedPane.getSelectedIndex()) >= 0) {
            String var2 = this.tabbedPane.getTitleAt(var7);
            if (this.d >= 0 && var2.equals("+")) {
                this.d = -1;
                boolean var3 = false;
                String var4 = "newCode";

                for (int var5 = 0; var5 < 10 && !var3; ++var5) {
                    if (var5 > 0) {
                        var4 = "newCode" + var5;
                    }

                    if (this.program.a(var4) == null) {
                        this.program.createPage(var4, 2);
                        var3 = true;
                    }
                }

                q var9;
                if (var3 && (var9 = this.program.a(var4)).m() != 1) {
                    if (!com.github.kill05.algobuildce.package_a.a.c.a(this.frame, var9, this.program)) {
                        this.d = 0;
                        this.tabbedPane.setSelectedIndex(0);
                        this.program.b(var4);
                    } else {
                        com.github.kill05.algobuildce.package_a.g.a var8 = new com.github.kill05.algobuildce.package_a.g.a(this.program, var9);
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
        if ((var3 = this.tabbedPane.indexOfTab(var1)) >= 0) {
            this.tabbedPane.setTitleAt(var3, var2.j());
        }

    }

    public void b(ABExecutable var1) {
        String var2 = ((q) var1).j();
        int var3 = this.tabbedPane.indexOfTab(var2);
        this.d = 0;
        this.tabbedPane.setSelectedIndex(0);
        if (var3 >= 0) {
            this.tabbedPane.remove(var3);
            this.i.remove(var3);
        }

    }

    public void d() {
        int var1 = this.tabbedPane.getSelectedIndex();
        ABFlowChartPanel var5 = (ABFlowChartPanel) this.i.elementAt(var1);
        com.github.kill05.algobuildce.package_a.i.d var2 = new com.github.kill05.algobuildce.package_a.i.d(var5);
        int var3 = var5.getWidth();
        int var4 = var5.getHeight();
        BufferedImage var7;
        Graphics2D var8;
        (var8 = (var7 = new BufferedImage(var3, var4, 1)).createGraphics()).setFont(this.program.getViewOptions().getCodeFont());
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
        if (var1.showSaveDialog(this.frame) == 0) {
            String var11 = var1.getSelectedFile().getAbsolutePath();
            FileFilter var8;
            if ((var8 = var1.getFileFilter()) != null && var8 instanceof FileNameExtensionFilter) {
                String[] var9 = ((FileNameExtensionFilter) var8).getExtensions();
                if (!var11.contains(".") && var9.length > 0 && var9[0] != null) {
                    var11 = var11 + "." + var9[0];
                }
            }

            String var10 = var11.substring(var11.lastIndexOf(46) + 1);
            int var3 = this.tabbedPane.getSelectedIndex();
            ABFlowChartPanel var12 = (ABFlowChartPanel) this.i.elementAt(var3);
            com.github.kill05.algobuildce.package_a.i.d var4 = new com.github.kill05.algobuildce.package_a.i.d(var12);
            int var5 = var12.getWidth();
            int var6 = var12.getHeight();
            BufferedImage var14;
            Graphics2D var15;
            (var15 = (var14 = new BufferedImage(var5, var6, 1)).createGraphics()).setFont(this.program.getViewOptions().getCodeFont());
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
