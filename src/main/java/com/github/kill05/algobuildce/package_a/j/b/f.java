package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.b.*;
import com.github.kill05.algobuildce.package_a.c.b.s;
import com.github.kill05.algobuildce.package_a.i.ImageUtils;
import com.github.kill05.algobuildce.package_a.i.Translator;
import com.github.kill05.algobuildce.package_a.k.GlobalVariables;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public final class f extends ABBasePanel {

    public f(ABProgram var1, com.github.kill05.algobuildce.package_a.j.a.a var2) {
        super(var1, var2);
        this.a(new Dimension(6 * this.e, 2 * this.f));
        this.setLocation(10, 10);
        this.setToolTipText("clic Nuovo.../Incolla");
    }

    public void a(Graphics var1) {
        ABExecutable var2 = null;
        if (this.b.getNextFragment() != null) {
            var2 = this.b.getNextFragment().d();
        }

        int var3 = this.getWidth();
        int var4 = this.getHeight();
        int var5 = (int) ((double) this.b.getViewOptions().getLineWidth() * GlobalVariables.getFontZoomRatio());
        int var6 = (int) ((double) this.b.getViewOptions().m() * GlobalVariables.getFontZoomRatio());
        this.c(var1);
        if (this.g && var2 == null) {
            this.b(var1);
            var1.fillRect(0, 0, var3 - 1, var4 - 1);
            this.c(var1);
            var1.drawRect(0, 0, var3 - 1, var4 - 1);
            String var7 = "NEW";
            Rectangle2D var8;
            var5 = (int) ((var8 = var1.getFontMetrics().getStringBounds(var7, var1)).getWidth() / 2.0D);
            var4 = (int) Math.round(-var8.getHeight() / 2.0D - var8.getY());
            var3 = var3 / 2 - var5;
            var4 += this.f;
            var1.drawString(var7, var3, var4);
        } else {
            var1.drawLine(var3 / 2, 0, var3 / 2, var4);
            var1.drawLine(var3 / 2, var4 - var5, var3 / 2 - var6, var4 - var6 - var5);
            var1.drawLine(var3 / 2, var4 - var5, var3 / 2 + var6, var4 - var6 - var5);
        }
    }

    public int b() {
        int var1 = -1;
        Container var2 = this.getParent();

        for (int var3 = 0; var1 < 0 && var3 < var2.getComponentCount(); ++var3) {
            if (this == var2.getComponent(var3)) {
                var1 = var3 / 2;
            }
        }

        return var1;
    }

    private String d() {
        ABInstructionPanel var1 = (ABInstructionPanel) this.getParent();
        return var1.h() + "." + this.b();
    }

    public void a(MouseEvent var1) {
        ABExecutable var2 = null;
        if (this.b.getNextFragment() != null) {
            var2 = this.b.getNextFragment().d();
        }

        if (var2 == null) {
            JPopupMenu var4 = new JPopupMenu();
            JLabel var3;
            (var3 = new JLabel(Translator.translate("instructionConnectorNewMsg"))).setIcon(ImageUtils.loadImage("imgs/new_instruction.gif"));
            var4.insert(var3, 0);
            JMenuItem var5;
            (var5 = new JMenuItem(Translator.translate("instructionConnectorNewAssign"), ImageUtils.loadImage("imgs/assign_icon.gif"))).addActionListener(this);
            var4.add(var5);
            (var5 = new JMenuItem(Translator.translate("instructionConnectorNewInput"), ImageUtils.loadImage("imgs/input_icon.gif"))).addActionListener(this);
            var4.add(var5);
            (var5 = new JMenuItem(Translator.translate("instructionConnectorNewOutput"), ImageUtils.loadImage("imgs/output_icon.gif"))).addActionListener(this);
            var4.add(var5);
            (var5 = new JMenuItem(Translator.translate("instructionConnectorNewIf"), ImageUtils.loadImage("imgs/if_icon.gif"))).addActionListener(this);
            var4.add(var5);
            (var5 = new JMenuItem(Translator.translate("instructionConnectorNewFor"), ImageUtils.loadImage("imgs/for_icon.gif"))).addActionListener(this);
            var4.add(var5);
            (var5 = new JMenuItem(Translator.translate("instructionConnectorNewWhile"), ImageUtils.loadImage("imgs/while_icon.gif"))).addActionListener(this);
            var4.add(var5);
            (var5 = new JMenuItem(Translator.translate("instructionConnectorNewDoWhile"), ImageUtils.loadImage("imgs/dowhile_icon.gif"))).addActionListener(this);
            var4.add(var5);
            (var5 = new JMenuItem(Translator.translate("instructionConnectorNewComment"), ImageUtils.loadImage("imgs/comment_icon.gif"))).addActionListener(this);
            var4.add(var5);
            (var5 = new JMenuItem(Translator.translate("instructionConnectorNewCall"), ImageUtils.loadImage("imgs/call_icon.gif"))).addActionListener(this);
            if (this.b.getAlgoBuild().c() <= 1) {
                var5.setEnabled(false);
            }

            var4.add(var5);
            var4.addSeparator();
            var5 = new JMenuItem(Translator.translate("instructionConnectorPaste"));
            if (this.b.k() == null) {
                var5.setEnabled(false);
            }

            var5.addActionListener(this);
            var4.add(var5);
            var4.show(var1.getComponent(), var1.getX(), var1.getY());
        }
    }

    public void actionPerformed(ActionEvent var1) {
        String var12;
        if ((var12 = var1.getActionCommand()) != null && var12.length() > 0) {
            String var2;
            int var4;
            int var5;
            f var13;
            String var19;
            if (var12.equals(Translator.translate("instructionConnectorPaste"))) {
                var13 = this;
                var2 = this.d();
                ABExecutable var17 = this.b.k();
                var4 = var2.lastIndexOf(46);

                try {
                    if (var17 != null && var4 > 0) {
                        var5 = Integer.parseInt(var2.substring(var4 + 1));
                        var19 = var2.substring(0, var4);
                        ABExecutable var27 = var17.copy();

                        try {
                            if (var27 != null) {
                                var13.b.a(var19, var5, (ABInstructionBlock) var27);
                                com.github.kill05.algobuildce.package_a.g.f var23 = new com.github.kill05.algobuildce.package_a.g.f(var13.b, var19, var5, (ABInstructionBlock) var27);
                                var13.c.c().a(var23);
                                return;
                            }
                        } catch (Exception var10) {
                            var10.printStackTrace();
                            return;
                        }
                    }
                } catch (NumberFormatException var11) {
                    var11.printStackTrace();
                }

            } else {
                var2 = var12;
                var13 = this;
                if (var2 != null && var2.length() > 0) {
                    String var3;
                    var4 = (var3 = this.d()).lastIndexOf(46);

                    try {
                        if (var4 > 0) {
                            var5 = Integer.parseInt(var3.substring(var4 + 1));
                            var19 = var3.substring(0, var4);
                            boolean var6 = var13.b.p();

                            try {
                                com.github.kill05.algobuildce.package_a.g.f var15;
                                if (var2.equals(Translator.translate("instructionConnectorNewAssign"))) {
                                    ABAssignInstructionBlock var26 = new ABAssignInstructionBlock("");
                                    var13.b.a(var19, var5, var26);
                                    var13.b.a(var26);
                                    if (!com.github.kill05.algobuildce.package_a.a.a.a(var13.c.a(), var26)) {
                                        var13.b.c(var3);
                                        var13.b.update(var6);
                                    } else {
                                        var15 = new com.github.kill05.algobuildce.package_a.g.f(var13.b, var19, var5, var26);
                                        var13.c.c().a(var15);
                                    }

                                    var13.b.a((ABExecutable) null);
                                    return;
                                }

                                if (var2.equals(Translator.translate("instructionConnectorNewInput"))) {
                                    ABInputBlock var25 = new ABInputBlock("");
                                    var13.b.a(var19, var5, var25);
                                    var13.b.a(var25);
                                    if (!com.github.kill05.algobuildce.package_a.a.g.a(var13.c.a(), var25)) {
                                        var13.b.c(var3);
                                        var13.b.update(var6);
                                    } else {
                                        var15 = new com.github.kill05.algobuildce.package_a.g.f(var13.b, var19, var5, var25);
                                        var13.c.c().a(var15);
                                    }

                                    var13.b.a((ABExecutable) null);
                                    return;
                                }

                                if (var2.equals(Translator.translate("instructionConnectorNewOutput"))) {
                                    ABOutputBlock var24 = new ABOutputBlock("");
                                    var13.b.a(var19, var5, var24);
                                    var13.b.a(var24);
                                    if (!com.github.kill05.algobuildce.package_a.a.h.a(var13.c.a(), var24) && var24.j() == 0) {
                                        var13.b.c(var3);
                                        var13.b.update(var6);
                                    } else {
                                        var15 = new com.github.kill05.algobuildce.package_a.g.f(var13.b, var19, var5, var24);
                                        var13.c.c().a(var15);
                                    }

                                    var13.b.a((ABExecutable) null);
                                    return;
                                }

                                if (var2.equals(Translator.translate("instructionConnectorNewIf"))) {
                                    ABIfBlock var22 = new ABIfBlock("");
                                    var13.b.a(var19, var5, var22);
                                    var13.b.a(var22);
                                    if (!com.github.kill05.algobuildce.package_a.a.i.a(var13.c.a(), var22)) {
                                        var13.b.c(var3);
                                        var13.b.update(var6);
                                    } else {
                                        var15 = new com.github.kill05.algobuildce.package_a.g.f(var13.b, var19, var5, var22);
                                        var13.c.c().a(var15);
                                    }

                                    var13.b.a((ABExecutable) null);
                                    return;
                                }

                                if (var2.equals(Translator.translate("instructionConnectorNewFor"))) {
                                    ABForBlock var21 = new ABForBlock("", "", "");
                                    var13.b.a(var19, var5, var21);
                                    var13.b.a(var21);
                                    if (!com.github.kill05.algobuildce.package_a.a.e.a(var13.c.a(), var21)) {
                                        var13.b.c(var3);
                                        var13.b.update(var6);
                                    } else {
                                        var15 = new com.github.kill05.algobuildce.package_a.g.f(var13.b, var19, var5, var21);
                                        var13.c.c().a(var15);
                                    }

                                    var13.b.a((ABExecutable) null);
                                    return;
                                }

                                if (var2.equals(Translator.translate("instructionConnectorNewWhile"))) {
                                    ABWhileBlock var20 = new ABWhileBlock("");
                                    var13.b.a(var19, var5, var20);
                                    var13.b.a(var20);
                                    if (!com.github.kill05.algobuildce.package_a.a.j.a(var13.c.a(), var20)) {
                                        var13.b.c(var3);
                                        var13.b.update(var6);
                                    } else {
                                        var15 = new com.github.kill05.algobuildce.package_a.g.f(var13.b, var19, var5, var20);
                                        var13.c.c().a(var15);
                                    }

                                    var13.b.a((ABExecutable) null);
                                    return;
                                }

                                if (var2.equals(Translator.translate("instructionConnectorNewDoWhile"))) {
                                    ABDoWhileBlock var18 = new ABDoWhileBlock("");
                                    var13.b.a(var19, var5, var18);
                                    var13.b.a(var18);
                                    if (!com.github.kill05.algobuildce.package_a.a.f.a(var13.c.a(), var18)) {
                                        var13.b.c(var3);
                                        var13.b.update(var6);
                                    } else {
                                        var15 = new com.github.kill05.algobuildce.package_a.g.f(var13.b, var19, var5, var18);
                                        var13.c.c().a(var15);
                                    }

                                    var13.b.a((ABExecutable) null);
                                    return;
                                }

                                if (var2.equals(Translator.translate("instructionConnectorNewComment"))) {
                                    ABCommentBlock var16 = new ABCommentBlock("");
                                    var13.b.a(var19, var5, var16);
                                    var13.b.a(var16);
                                    if (!com.github.kill05.algobuildce.package_a.a.d.a(var13.c.a(), var16)) {
                                        var13.b.c(var3);
                                        var13.b.update(var6);
                                    } else {
                                        var15 = new com.github.kill05.algobuildce.package_a.g.f(var13.b, var19, var5, var16);
                                        var13.c.c().a(var15);
                                    }

                                    var13.b.a((ABExecutable) null);
                                    return;
                                }

                                if (var2.equals(Translator.translate("instructionConnectorNewCall"))) {
                                    com.github.kill05.algobuildce.package_a.c.b.c var14 = new com.github.kill05.algobuildce.package_a.c.b.c("test");
                                    var13.b.a(var19, var5, var14);
                                    var13.b.a(var14);
                                    if (!com.github.kill05.algobuildce.package_a.a.b.a(var13.c.a(), var14, var13.b)) {
                                        var13.b.c(var3);
                                        var13.b.update(var6);
                                    } else {
                                        var15 = new com.github.kill05.algobuildce.package_a.g.f(var13.b, var19, var5, var14);
                                        var13.c.c().a(var15);
                                    }

                                    var13.b.a((ABExecutable) null);
                                }
                            } catch (Exception var8) {
                                var8.printStackTrace();
                            }
                        }
                    } catch (NumberFormatException var9) {
                        var9.printStackTrace();
                    }
                }
            }
        }

    }

    protected void c() {
        String var1;
        int var2 = (var1 = this.d()).lastIndexOf(46);

        try {
            if (var2 > 0) {
                int var3 = Integer.parseInt(var1.substring(var2 + 1));
                var1 = var1.substring(0, var2);
                this.b.a(var1, var3, new ABOutputBlock("'Added test output'"));
            }
        } catch (NumberFormatException | s var4) {
            var4.printStackTrace();
        }

    }

    public void a() {
        new Dimension(2 * this.e, 0);
        this.a(new Dimension(6 * this.e, 2 * this.f));
    }
}
