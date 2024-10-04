package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutionFragment;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.a.IInstructionPanel;
import com.github.kill05.algobuildce.package_a.c.b.*;
import com.github.kill05.algobuildce.package_a.c.b.s;
import com.github.kill05.algobuildce.package_a.c.b.t;
import com.github.kill05.algobuildce.package_a.i.Translator;
import com.github.kill05.algobuildce.package_a.j.a.ABTabbedProgramPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class ABInstructionPanel extends ABBasePanel implements IInstructionPanel {

    protected ABExecutable executable;
    protected Rectangle j;

    public ABInstructionPanel(ABProgram var1, ABTabbedProgramPanel var2, ABExecutable var3) {
        super(var1, var2);
        this.executable = var3;
        this.setToolTipText("clic Modifica / Copia / Taglia");
    }

    @Override
    public final void a(ABExecutable var1) {
        this.executable = var1;
    }

    @Override
    public final boolean f() {
        return this.executable != null && this.executable.a();
    }

    protected void b_() {
        if (this.j != null) {
            boolean var2 = false;
            ABExecutable var3 = null;
            ABExecutionFragment a = this.program.getNextFragment();
            if (a != null) {
                var3 = a.d();
            }

            if (var3 == null) {
                if (this.program.j() == this.executable) {
                    var2 = true;
                }
            } else if (var3 == this.executable) {
                var2 = true;
            }

            if (var2) {
                this.scrollRectToVisible(this.j);
            }
        }

    }

    @Override
    protected final void setFillingColor(Graphics var1) {
        ABExecutable var2 = null;
        ABExecutionFragment a = this.program.getNextFragment();
        if (a != null) {
            var2 = a.d();
        }

        if (var2 == null) {
            if (!this.isHovered && this.program.j() != this.executable) {
                var1.setColor(this.program.getViewOptions().getFillingColor());
            } else {
                var1.setColor(this.program.getViewOptions().getFillingColorSelected());
            }
        } else if (var2 == this.executable) {
            var1.setColor(this.program.getViewOptions().getFillingColorRunning());
        } else {
            var1.setColor(this.program.getViewOptions().getFillingColor());
        }
    }

    @Override
    protected final void setFillingColor(Graphics var1, int var2) {
        ABExecutionFragment var3;
        if ((var3 = this.program.getNextFragment()) == null) {
            if (!this.isHovered && this.program.j() != this.executable) {
                var1.setColor(this.program.getViewOptions().getFillingColor());
            } else {
                var1.setColor(this.program.getViewOptions().getFillingColorSelected());
            }
        } else {
            ABExecutable var4 = var3.d();
            int var5 = var3.c();
            if (var4 == this.executable && var5 == var2 && var4.a(var5)) {
                var1.setColor(this.program.getViewOptions().getFillingColorRunning());
            } else {
                var1.setColor(this.program.getViewOptions().getFillingColor());
            }
        }
    }

    @Override
    protected final void setLineColor(Graphics var1) {
        ABExecutionFragment var2;
        if ((var2 = this.program.getNextFragment()) == null) {
            if (!this.isHovered && this.program.j() != this.executable) {
                var1.setColor(this.program.getViewOptions().getLineColor());
            } else {
                var1.setColor(this.program.getViewOptions().getLineColorSelected());
            }
        } else {
            ABExecutable var3 = var2.d();
            if ((var3) == this.executable && var3.a(var2.c())) {
                var1.setColor(this.program.getViewOptions().getLineColorRunning());
            } else {
                var1.setColor(this.program.getViewOptions().getLineColor());
            }
        }
    }

    /*
    @Override
    protected final void setLineColor1(Graphics var1) {
        ABExecutable var2 = null;
        ABExecutionFragment a = this.program.getNextFragment();
        if (a != null) {
            var2 = a.d();
        }

        if (var2 == null) {
            if (!this.isHovered && this.program.j() != this.i) {
                var1.setColor(this.program.getViewOptions().getLineColor());
            } else {
                var1.setColor(this.program.getViewOptions().getLineColorSelected());
            }
        } else if (var2 == this.i) {
            var1.setColor(this.program.getViewOptions().getLineColorRunning());
        } else {
            var1.setColor(this.program.getViewOptions().getLineColor());
        }
    }

     */



    @Override
    public void a(ABExecutable var1, boolean var2) {
        if (var2) {
            this.g();
            this.a(true);
            this.revalidate();
        }

        this.repaint();
        this.b_();
    }

    public final ABInstructionPanel b(ABExecutable var1) {
        if (var1 instanceof ABAssignInstructionBlock) {
            return new a(this.program, this.flowChartPanel, var1);
        } else if (var1 instanceof ABOutputBlock) {
            return new l(this.program, this.flowChartPanel, var1);
        } else if (var1 instanceof ABInputBlock) {
            return new k(this.program, this.flowChartPanel, var1);
        } else if (var1 instanceof ABForBlock) {
            return new h(this.program, this.flowChartPanel, var1);
        } else if (var1 instanceof ABWhileBlock) {
            return new WhileBlockPanel(this.program, this.flowChartPanel, var1);
        } else if (var1 instanceof ABDoWhileBlock) {
            return new g(this.program, this.flowChartPanel, var1);
        } else if (var1 instanceof ABIfBlock) {
            return new m(this.program, this.flowChartPanel, var1);
        } else if (var1 instanceof com.github.kill05.algobuildce.package_a.c.b.o) {
            return new e(this.program, this.flowChartPanel, var1);
        } else if (var1 instanceof ABCommentBlock) {
            return new d(this.program, this.flowChartPanel, var1);
        } else {
            return var1 instanceof ABBaseCallInstructionBlock ? new b(this.program, this.flowChartPanel, var1) : null;
        }
    }

    @Override
    public void a(ABExecutable var1, int var2) {
    }

    @Override
    public void a(int var1) {
    }

    @Override
    protected final void c() {
    }

    public final String h() {
        ABInstructionPanel parent = this;
        while (parent.executable == null) {
            parent = (ABInstructionPanel) this.getParent();
        }

        return parent.executable.c();
    }

    @Override
    public void a(MouseEvent var1) {
        JPopupMenu var2 = new JPopupMenu();
        JMenuItem var3;
        (var3 = new JMenuItem(Translator.translate("instructionModify"))).addActionListener(this);
        var2.add(var3);
        var2.addSeparator();
        (var3 = new JMenuItem(Translator.translate("instructionCopy"))).addActionListener(this);
        var2.add(var3);
        (var3 = new JMenuItem(Translator.translate("instructionCut"))).addActionListener(this);
        var2.add(var3);
        var2.show(var1.getComponent(), var1.getX(), var1.getY());
    }

    @Override
    public void actionPerformed(ActionEvent var1) {
        String var7;
        if ((var7 = var1.getActionCommand()) != null && !var7.isEmpty()) {
            if (var7.equals(Translator.translate("instructionModify"))) {
                this.program.a(this.executable);
                this.modifyInstruction();
                return;
            }

            if (var7.equals(Translator.translate("instructionCopy"))) {
                this.program.b(this.executable);
                return;
            }

            if (var7.equals(Translator.translate("instructionCut"))) {
                String var2 = this.h();

                try {
                    com.github.kill05.algobuildce.package_a.g.b var3 = new com.github.kill05.algobuildce.package_a.g.b(this.program, var2);
                    this.program.b(this.executable);
                    this.program.c(var2);
                    this.flowChartPanel.c().a(var3);
                } catch (s | NumberFormatException | t var4) {
                    var4.printStackTrace();
                }
            }
        }

    }

    protected void modifyInstruction() {
        JOptionPane.showMessageDialog(this, "ABVFCExecutable - modifyInstruction() - NOT IMPLEMENTED");
    }

    public final void b(Rectangle var1) {
        this.j = var1;
    }

    public final ABExecutable getExecutable() {
        return this.executable;
    }
}
