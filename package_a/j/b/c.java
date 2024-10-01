package package_a.j.b;

import package_a.c.a.b;
import package_a.c.a.d;
import package_a.c.b.q;
import package_a.i.Translator;
import package_a.j.a.a;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public final class c extends o {
    e a;
    private String k;
    private String l;
    private Rectangle m;

    public final void a(Rectangle var1) {
        this.m = var1;
    }

    public c(package_a.c.a.b var1, package_a.j.a.a var2, package_a.c.a.d var3) {
        super(var1, var2, var3);
        this.a((d)var3);
        this.setOpaque(true);
        this.a = new e(var1, var2, null);
        this.add(this.a);
        this.a.g();
        this.g();
        this.a(this.d);
        this.revalidate();
        int var4;
        if ((var4 = ((package_a.c.b.q)var3).m()) != 3 && var4 != 2) {
            this.setToolTipText(null);
        } else {
            this.setToolTipText("clic Modifica / Copia / Taglia");
        }
    }

    public final void a(Graphics var1) {
        super.a(var1);
        this.i.b();
        Dimension var2;
        int var3 = (int)(var2 = this.getPreferredSize()).getWidth();
        int var8 = (int)var2.getHeight();
        int var4 = this.getWidth();
        int var5 = this.getHeight();
        var1.setColor(this.b.q().d());
        var1.fillRect(0, 0, var4, var5);
        this.a(var1, 0);
        var1.fillOval(var3 / 2 - 10 * this.e, 1 * this.f, 20 * this.e, 4 * this.f - 1);
        this.d(var1);
        String var9 = this.k;
        FontMetrics var10 = var1.getFontMetrics();
        var1.drawOval(var3 / 2 - 10 * this.e, 1 * this.f, 20 * this.e, 4 * this.f - 1);
        var1.drawLine(var3 / 2, 5 * this.f, var3 / 2, 6 * this.f);
        Rectangle2D var6;
        int var7 = (int)((var6 = var10.getStringBounds(var9, var1)).getWidth() / 2.0);
        int var11 = (int)Math.round(-var6.getHeight() / 2.0 - var6.getY());
        var7 = var3 / 2 - var7;
        var11 += 3 * this.f;
        var1.drawString(var9, var7, var11);
        this.a(var1, 1);
        var1.fillOval(var3 / 2 - 10 * this.e, var8 - 5 * this.f, 20 * this.e, 4 * this.f - 1);
        this.d(var1);
        var9 = this.l;
        var1.drawLine(var3 / 2, var8 - 6 * this.f, var3 / 2, var8 - 5 * this.f);
        var1.drawOval(var3 / 2 - 10 * this.e, var8 - 5 * this.f, 20 * this.e, 4 * this.f);
        var7 = (int)((var6 = var10.getStringBounds(var9, var1)).getWidth() / 2.0);
        var11 = (int)Math.round(-var6.getHeight() / 2.0 - var6.getY());
        var7 = var3 / 2 - var7;
        var11 += var8 - 3 * this.f;
        var1.drawString(var9, var7, var11);
    }

    public final void a() {
        package_a.c.b.q var1;
        int var2;
        if ((var1 = (package_a.c.b.q)this.i).m() == 2) {
            this.k = "PROC " + var1.j() + "(";

            for(var2 = 0; var2 < var1.k(); ++var2) {
                if (var2 > 0) {
                    this.k = this.k + ", ";
                }

                this.k = this.k + var1.e(var2);
            }

            this.k = this.k + ")";
            this.l = "RET";
        } else if (var1.m() == 3) {
            this.k = "FUNC " + var1.j() + "(";

            for(var2 = 0; var2 < var1.k(); ++var2) {
                if (var2 > 0) {
                    this.k = this.k + ", ";
                }

                this.k = this.k + var1.e(var2);
            }

            this.k = this.k + ")";
            this.l = "RET " + var1.l();
        } else {
            this.k = "START " + var1.j();
            this.l = "END";
        }

        Dimension var5 = new Dimension(22 * this.e, 12 * this.f);
        this.a.g();
        Dimension var3 = this.a.getMinimumSize();
        var5.width = Math.max(var5.width, var3.width);
        var5.height += var3.height;
        this.a((Dimension)var5);
        int var4 = (int)(var5.getWidth() - var3.getWidth()) / 2;
        this.a.setLocation(var4, 6 * this.f);
        this.j = new Rectangle(var4, this.f, 20 * this.e, 4 * this.f);
        this.m = new Rectangle(var4, var5.height - 5 * this.f, 20 * this.e, 4 * this.f);
        this.revalidate();
    }

    public final void a(d var1, int var2) {
        o var3 = this.b(var1);
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

    public final void a(int var1) {
        this.a.b(var1);
        this.g();
        this.invalidate();
    }

    public final void a(d var1, boolean var2) {
        super.a(var1, var2);
        package_a.c.a.c var3;
        if (!var2 && (var3 = this.b.a()) != null && var3.d() == this.i && var3.c() == 0) {
            String var4 = ((q)this.i).j();
            this.c.c().h(var4);
        }

    }

    @Override
    protected final void b_() {
        d var1 = null;
        package_a.c.a.c var2;
        if ((var2 = this.b.a()) != null) {
            var1 = this.b.a().d();
        }

        if (var1 == null) {
            if (this.b.j() != this.i || this.j == null) {
                return;
            }
        } else if (var1 == this.i && var2.c() == 1) {
            this.scrollRectToVisible(this.m);
            return;
        }

        this.scrollRectToVisible(this.j);
    }

    @Override
    public final void a(MouseEvent var1) {
        if (((q)this.i).m() != 1) {
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
    public final void actionPerformed(ActionEvent var1) {
        String var2;
        if ((var2 = var1.getActionCommand()) != null && var2.length() > 0) {
            if (var2.equals(Translator.translate("instructionModify"))) {
                this.a_();
                return;
            }

            if (var2.equals(Translator.translate("codeDuplicate"))) {
                JOptionPane.showMessageDialog(this.c.a(), "TO DO!");
                return;
            }

            if (var2.equals(Translator.translate("codeDelete"))) {
                package_a.g.c var3 = new package_a.g.c(this.b, (q)this.i);
                this.b.b(((q)this.i).j());
                this.c.c().a(var3);
            }
        }

    }

    @Override
    protected final void a_() {
        if (((q)this.i).m() != 1) {
            package_a.g.d var1 = new package_a.g.d(this.b, (q)this.i);
            if (package_a.a.c.a(this.c.a(), (q)this.i, this.b)) {
                this.c.c().a(var1);
                this.b.a(true);
            }

            this.b.a((d)null);
        }

    }

    @Override
    public final void a(C_subclass var1) {
        super.a(var1);
        var1 = var1.a().a(this.a);
        this.a.a(var1);
    }
}

