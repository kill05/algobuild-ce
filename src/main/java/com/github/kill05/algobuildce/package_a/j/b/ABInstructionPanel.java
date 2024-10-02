package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutionFragment;
import com.github.kill05.algobuildce.package_a.c.a.IInstructionPanel;
import com.github.kill05.algobuildce.package_a.c.b.*;
import com.github.kill05.algobuildce.package_a.c.b.s;
import com.github.kill05.algobuildce.package_a.c.b.t;
import com.github.kill05.algobuildce.package_a.i.Translator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class ABInstructionPanel extends ABBasePanel implements IInstructionPanel {
    protected ABExecutable i;
    protected Rectangle j;

    public ABInstructionPanel(com.github.kill05.algobuildce.package_a.c.a.b var1, com.github.kill05.algobuildce.package_a.j.a.a var2, ABExecutable var3) {
        super(var1, var2);
        this.i = var3;
        this.setToolTipText("clic Modifica / Copia / Taglia");
    }

    @Override
    public final void a(ABExecutable var1) {
        this.i = var1;
    }

    @Override
    public final boolean f() {
        return this.i != null && this.i.a();
    }

    protected void b_() {
        if (this.j != null) {
            boolean var2 = false;
            ABExecutable var3 = null;
            ABExecutionFragment a = this.b.a();
            if (a != null) {
                var3 = a.d();
            }

            if (var3 == null) {
                if (this.b.j() == this.i) {
                    var2 = true;
                }
            } else if (var3 == this.i) {
                var2 = true;
            }

            if (var2) {
                this.scrollRectToVisible(this.j);
            }
        }

    }

    @Override
    protected final void b(Graphics var1) {
        ABExecutable var2 = null;
        ABExecutionFragment a = this.b.a();
        if (a != null) {
            var2 = a.d();
        }

        if (var2 == null) {
            if (!this.g && this.b.j() != this.i) {
                var1.setColor(this.b.getViewOptions().getFillingColor());
            } else {
                var1.setColor(this.b.getViewOptions().getFillingColorSelected());
            }
        } else if (var2 == this.i) {
            var1.setColor(this.b.getViewOptions().getFillingColorRunning());
        } else {
            var1.setColor(this.b.getViewOptions().getFillingColor());
        }
    }

    @Override
    protected final void c(Graphics var1) {
        ABExecutable var2 = null;
        ABExecutionFragment a = this.b.a();
        if (a != null) {
            var2 = a.d();
        }

        if (var2 == null) {
            if (!this.g && this.b.j() != this.i) {
                var1.setColor(this.b.getViewOptions().getLineColor());
            } else {
                var1.setColor(this.b.getViewOptions().getLineColorSelected());
            }
        } else if (var2 == this.i) {
            var1.setColor(this.b.getViewOptions().getLineColorRunning());
        } else {
            var1.setColor(this.b.getViewOptions().getLineColor());
        }
    }

    @Override
    protected final void a(Graphics var1, int var2) {
        ABExecutionFragment var3;
        if ((var3 = this.b.a()) == null) {
            if (!this.g && this.b.j() != this.i) {
                var1.setColor(this.b.getViewOptions().getFillingColor());
            } else {
                var1.setColor(this.b.getViewOptions().getFillingColorSelected());
            }
        } else {
            ABExecutable var4 = var3.d();
            int var5 = var3.c();
            if (var4 == this.i && var5 == var2 && var4.a(var5)) {
                var1.setColor(this.b.getViewOptions().getFillingColorRunning());
            } else {
                var1.setColor(this.b.getViewOptions().getFillingColor());
            }
        }
    }

    @Override
    protected final void d(Graphics var1) {
        ABExecutionFragment var2;
        if ((var2 = this.b.a()) == null) {
            if (!this.g && this.b.j() != this.i) {
                var1.setColor(this.b.getViewOptions().getLineColor());
            } else {
                var1.setColor(this.b.getViewOptions().getLineColorSelected());
            }
        } else {
            ABExecutable var3;
            if ((var3 = var2.d()) == this.i && var3.a(var2.c())) {
                var1.setColor(this.b.getViewOptions().getLineColorRunning());
            } else {
                var1.setColor(this.b.getViewOptions().getLineColor());
            }
        }
    }

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
            return new a(this.b, this.c, var1);
        } else if (var1 instanceof ABOutputBlock) {
            return new l(this.b, this.c, var1);
        } else if (var1 instanceof ABInputBlock) {
            return new k(this.b, this.c, var1);
        } else if (var1 instanceof ABForBlock) {
            return new h(this.b, this.c, var1);
        } else if (var1 instanceof ABWhileBlock) {
            return new i(this.b, this.c, var1);
        } else if (var1 instanceof ABDoWhileBlock) {
            return new g(this.b, this.c, var1);
        } else if (var1 instanceof ABIfBlock) {
            return new m(this.b, this.c, var1);
        } else if (var1 instanceof com.github.kill05.algobuildce.package_a.c.b.o) {
            return new e(this.b, this.c, var1);
        } else if (var1 instanceof ABCommentBlock) {
            return new d(this.b, this.c, var1);
        } else {
            return var1 instanceof ABBaseCallInstructionBlock ? new b(this.b, this.c, var1) : null;
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
        while (parent.i == null) {
            parent = (ABInstructionPanel) this.getParent();
        }

        return parent.i.c();
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
                this.b.a(this.i);
                this.modifyInstruction();
                return;
            }

            if (var7.equals(Translator.translate("instructionCopy"))) {
                this.b.b(this.i);
                return;
            }

            if (var7.equals(Translator.translate("instructionCut"))) {
                String var2 = this.h();

                try {
                    com.github.kill05.algobuildce.package_a.g.b var3 = new com.github.kill05.algobuildce.package_a.g.b(this.b, var2);
                    this.b.b(this.i);
                    this.b.c(var2);
                    this.c.c().a(var3);
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

    public final ABExecutable i() {
        return this.i;
    }
}
