package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutionFragment;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.b.q;
import com.github.kill05.algobuildce.package_a.i.ImageUtils;
import com.github.kill05.algobuildce.package_a.i.Translator;
import com.github.kill05.algobuildce.package_a.j.a.ABTabbedProgramPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class ABFlowChartPanel extends ABInstructionPanel {

    e a;
    private String startText;
    private String endText;

    private Rectangle m;

    public void a(Rectangle var1) {
        this.m = var1;
    }

    public ABFlowChartPanel(ABProgram program, ABTabbedProgramPanel tabbedPanel, ABExecutable executable) {
        super(program, tabbedPanel, executable);
        this.a(executable);
        this.setOpaque(true);
        this.a = new e(program, tabbedPanel, null);
        this.add(this.a);
        this.a.g();
        this.g();
        this.a(this.d);
        this.revalidate();
        int var4;
        if ((var4 = ((com.github.kill05.algobuildce.package_a.c.b.q) executable).m()) != 3 && var4 != 2) {
            this.setToolTipText(null);
        } else {
            this.setToolTipText("clic Modifica / Copia / Taglia");
        }
    }

    @Override
    public void drawPanel(Graphics g) {
        super.drawPanel(g);

        g.drawImage(ImageUtils.loadImage("imgs/background.jpg").getImage(), 0, 0, getWidth(), getHeight(), this);

        Dimension prefSize = this.getPreferredSize();
        int prefWidth = (int) prefSize.getWidth();
        int prefHeight = (int) prefSize.getHeight();
        //g.setColor(this.program.getViewOptions().getBackgroundColor());
        //g.fillRect(0, 0, this.getWidth(), this.getHeight());
        this.setFillingColor(g, 0);
        g.fillOval(prefWidth / 2 - 10 * this.centerX, this.centerY, 20 * this.centerX, 4 * this.centerY - 1);
        this.setLineColor(g);
        FontMetrics fontMetrics = g.getFontMetrics();
        g.drawOval(prefWidth / 2 - 10 * this.centerX, this.centerY, 20 * this.centerX, 4 * this.centerY - 1);
        g.drawLine(prefWidth / 2, 5 * this.centerY, prefWidth / 2, 6 * this.centerY);
        Rectangle2D startTextBounds = fontMetrics.getStringBounds(this.startText, g);
        int startX = (int) (startTextBounds.getWidth() / 2.0);
        int startY = (int) Math.round(-startTextBounds.getHeight() / 2.0 - startTextBounds.getY());
        startX = prefWidth / 2 - startX;
        startY += 3 * this.centerY;
        g.drawString(this.startText, startX, startY);

        // End
        this.setFillingColor(g, 1);
        g.fillOval(prefWidth / 2 - 10 * this.centerX, prefHeight - 5 * this.centerY, 20 * this.centerX, 4 * this.centerY - 1);
        this.setLineColor(g);
        g.drawLine(prefWidth / 2, prefHeight - 6 * this.centerY, prefWidth / 2, prefHeight - 5 * this.centerY);
        g.drawOval(prefWidth / 2 - 10 * this.centerX, prefHeight - 5 * this.centerY, 20 * this.centerX, 4 * this.centerY);

        Rectangle2D endTextBounds = fontMetrics.getStringBounds(this.endText, g);
        startX = (int) (endTextBounds.getWidth() / 2.0);
        startY = (int) Math.round(-endTextBounds.getHeight() / 2.0 - endTextBounds.getY());
        startX = prefWidth / 2 - startX;
        startY += prefHeight - 3 * this.centerY;
        g.drawString(this.endText, startX, startY);
    }

    @Override
    public void a() {
        com.github.kill05.algobuildce.package_a.c.b.q var1;
        int var2;
        if ((var1 = (com.github.kill05.algobuildce.package_a.c.b.q) this.executable).m() == 2) {
            this.startText = "PROC " + var1.j() + "(";

            for (var2 = 0; var2 < var1.k(); ++var2) {
                if (var2 > 0) {
                    this.startText = this.startText + ", ";
                }

                this.startText = this.startText + var1.e(var2);
            }

            this.startText = this.startText + ")";
            this.endText = "RET";
        } else if (var1.m() == 3) {
            this.startText = "FUNC " + var1.j() + "(";

            for (var2 = 0; var2 < var1.k(); ++var2) {
                if (var2 > 0) {
                    this.startText = this.startText + ", ";
                }

                this.startText = this.startText + var1.e(var2);
            }

            this.startText = this.startText + ")";
            this.endText = "RET " + var1.l();
        } else {
            this.startText = "START " + var1.j();
            this.endText = "END";
        }

        Dimension var5 = new Dimension(22 * this.centerX, 12 * this.centerY);
        this.a.g();
        Dimension var3 = this.a.getMinimumSize();
        var5.width = Math.max(var5.width, var3.width);
        var5.height += var3.height;
        this.forceSize(var5);
        int var4 = (int) (var5.getWidth() - var3.getWidth()) / 2;
        this.a.setLocation(var4, 6 * this.centerY);
        this.j = new Rectangle(var4, this.centerY, 20 * this.centerX, 4 * this.centerY);
        this.m = new Rectangle(var4, var5.height - 5 * this.centerY, 20 * this.centerX, 4 * this.centerY);
        this.revalidate();
    }

    @Override
    public void a(ABExecutable var1, int var2) {
        ABInstructionPanel var3 = this.b(var1);
        if (this.h != null) {
            C_subclass var4 = this.h.a().a(var3);
            var3.a(var4);
        }

        this.a.a(var3, var2);
        var1.a(var3);
        this.g();
        this.d = true;
        this.a(this.d);
        this.revalidate();
    }

    @Override
    public void a(int var1) {
        this.a.b(var1);
        this.g();
        this.invalidate();
    }

    @Override
    public void a(ABExecutable var1, boolean var2) {
        super.a(var1, var2);
        ABExecutionFragment var3;
        if (!var2 && (var3 = this.program.getNextFragment()) != null && var3.d() == this.executable && var3.c() == 0) {
            String var4 = ((q) this.executable).j();
            this.flowChartPanel.c().h(var4);
        }

    }

    @Override
    protected void b_() {
        ABExecutable var1 = null;
        ABExecutionFragment var2;
        if ((var2 = this.program.getNextFragment()) != null) {
            var1 = this.program.getNextFragment().d();
        }

        if (var1 == null) {
            if (this.program.j() != this.executable || this.j == null) {
                return;
            }
        } else if (var1 == this.executable && var2.c() == 1) {
            this.scrollRectToVisible(this.m);
            return;
        }

        this.scrollRectToVisible(this.j);
    }

    @Override
    public void a(MouseEvent var1) {
        if (((q) this.executable).m() != 1) {
            JPopupMenu var2 = new JPopupMenu();
            JMenuItem var3;
            (var3 = new JMenuItem(Translator.translate("instructionModify"))).addActionListener(this);
            var2.add(var3);
            var2.addSeparator();
            (var3 = new JMenuItem(Translator.translate("codeDuplicate"))).addActionListener(this);
            var2.add(var3);
            (var3 = new JMenuItem(Translator.translate("codeDelete"))).addActionListener(this);
            var2.add(var3);
            var2.show(var1.getComponent(), var1.getX(), var1.getY());
        }

    }

    @Override
    public void actionPerformed(ActionEvent var1) {
        String var2;
        if ((var2 = var1.getActionCommand()) != null && !var2.isEmpty()) {
            if (var2.equals(Translator.translate("instructionModify"))) {
                this.modifyInstruction();
                return;
            }

            if (var2.equals(Translator.translate("codeDuplicate"))) {
                JOptionPane.showMessageDialog(this.flowChartPanel.getFrame(), "TO DO!");
                return;
            }

            if (var2.equals(Translator.translate("codeDelete"))) {
                com.github.kill05.algobuildce.package_a.g.c var3 = new com.github.kill05.algobuildce.package_a.g.c(this.program, (q) this.executable);
                this.program.b(((q) this.executable).j());
                this.flowChartPanel.c().a(var3);
            }
        }

    }

    @Override
    protected void modifyInstruction() {
        if (((q) this.executable).m() != 1) {
            com.github.kill05.algobuildce.package_a.g.d var1 = new com.github.kill05.algobuildce.package_a.g.d(this.program, (q) this.executable);
            if (com.github.kill05.algobuildce.package_a.a.c.a(this.flowChartPanel.getFrame(), (q) this.executable, this.program)) {
                this.flowChartPanel.c().a(var1);
                this.program.update(true);
            }

            this.program.a((ABExecutable) null);
        }

    }

    @Override
    public void a(C_subclass var1) {
        super.a(var1);
        var1 = var1.a().a(this.a);
        this.a.a(var1);
    }
}

