package com.github.kill05.algobuildce.package_a.j.b;

import com.github.kill05.algobuildce.package_a.c.b.s;
import com.github.kill05.algobuildce.package_a.c.b.t;
import com.github.kill05.algobuildce.package_a.i.Translator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class o extends n implements com.github.kill05.algobuildce.package_a.c.a.k {
    protected com.github.kill05.algobuildce.package_a.c.a.d i;
    protected Rectangle j;

    public o(com.github.kill05.algobuildce.package_a.c.a.b var1, com.github.kill05.algobuildce.package_a.j.a.a var2, com.github.kill05.algobuildce.package_a.c.a.d var3) {
        super(var1, var2);
        this.i = var3;
        this.setToolTipText("clic Modifica / Copia / Taglia");
    }

    @Override
    public final void a(com.github.kill05.algobuildce.package_a.c.a.d var1) {
        this.i = var1;
    }

    @Override
    public final boolean f() {
        return this.i != null && this.i.a();
    }

    protected void b_() {
        if (this.j != null) {
            boolean var2 = false;
            com.github.kill05.algobuildce.package_a.c.a.d var3 = null;
            com.github.kill05.algobuildce.package_a.c.a.c a = this.b.a();
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
        com.github.kill05.algobuildce.package_a.c.a.d var2 = null;
        com.github.kill05.algobuildce.package_a.c.a.c a = this.b.a();
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
        com.github.kill05.algobuildce.package_a.c.a.d var2 = null;
        com.github.kill05.algobuildce.package_a.c.a.c a = this.b.a();
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
        com.github.kill05.algobuildce.package_a.c.a.c var3;
        if ((var3 = this.b.a()) == null) {
            if (!this.g && this.b.j() != this.i) {
                var1.setColor(this.b.getViewOptions().getFillingColor());
            } else {
                var1.setColor(this.b.getViewOptions().getFillingColorSelected());
            }
        } else {
            com.github.kill05.algobuildce.package_a.c.a.d var4 = var3.d();
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
        com.github.kill05.algobuildce.package_a.c.a.c var2;
        if ((var2 = this.b.a()) == null) {
            if (!this.g && this.b.j() != this.i) {
                var1.setColor(this.b.getViewOptions().getLineColor());
            } else {
                var1.setColor(this.b.getViewOptions().getLineColorSelected());
            }
        } else {
            com.github.kill05.algobuildce.package_a.c.a.d var3;
            if ((var3 = var2.d()) == this.i && var3.a(var2.c())) {
                var1.setColor(this.b.getViewOptions().getLineColorRunning());
            } else {
                var1.setColor(this.b.getViewOptions().getLineColor());
            }
        }
    }

    @Override
    public void a(com.github.kill05.algobuildce.package_a.c.a.d var1, boolean var2) {
        if (var2) {
            this.g();
            this.a(true);
            this.revalidate();
        }

        this.repaint();
        this.b_();
    }

    public final o b(com.github.kill05.algobuildce.package_a.c.a.d var1) {
        if (var1 instanceof com.github.kill05.algobuildce.package_a.c.b.a) {
            return new a(this.b, this.c, var1);
        } else if (var1 instanceof com.github.kill05.algobuildce.package_a.c.b.j) {
            return new l(this.b, this.c, var1);
        } else if (var1 instanceof com.github.kill05.algobuildce.package_a.c.b.i) {
            return new k(this.b, this.c, var1);
        } else if (var1 instanceof com.github.kill05.algobuildce.package_a.c.b.f) {
            return new h(this.b, this.c, var1);
        } else if (var1 instanceof com.github.kill05.algobuildce.package_a.c.b.g) {
            return new i(this.b, this.c, var1);
        } else if (var1 instanceof com.github.kill05.algobuildce.package_a.c.b.e) {
            return new g(this.b, this.c, var1);
        } else if (var1 instanceof com.github.kill05.algobuildce.package_a.c.b.l) {
            return new m(this.b, this.c, var1);
        } else if (var1 instanceof com.github.kill05.algobuildce.package_a.c.b.o) {
            return new e(this.b, this.c, var1);
        } else if (var1 instanceof com.github.kill05.algobuildce.package_a.c.b.d) {
            return new d(this.b, this.c, var1);
        } else {
            return var1 instanceof com.github.kill05.algobuildce.package_a.c.b.b ? new b(this.b, this.c, var1) : null;
        }
    }

    @Override
    public void a(com.github.kill05.algobuildce.package_a.c.a.d var1, int var2) {
    }

    @Override
    public void a(int var1) {
    }

    @Override
    protected final void c() {
    }

    public final String h() {
        o parent = this;
        while (parent.i == null) {
            parent = (o) this.getParent();
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
                this.a_();
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

    protected void a_() {
        JOptionPane.showMessageDialog(this, "ABVFCExecutable - modifyInstruction() - NOT IMPLEMENTED");
    }

    public final void b(Rectangle var1) {
        this.j = var1;
    }

    public final com.github.kill05.algobuildce.package_a.c.a.d i() {
        return this.i;
    }
}
