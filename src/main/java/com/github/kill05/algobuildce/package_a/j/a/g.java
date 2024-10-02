package com.github.kill05.algobuildce.package_a.j.a;

import com.github.kill05.algobuildce.package_a.a.m;
import com.github.kill05.algobuildce.package_a.a.ExecutionOptionsDialogue;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABProgram;
import com.github.kill05.algobuildce.package_a.c.a.j;
import com.github.kill05.algobuildce.package_a.c.b.q;
import com.github.kill05.algobuildce.package_a.i.Translator;
import com.github.kill05.algobuildce.package_a.k.ABFrame;
import com.github.kill05.algobuildce.package_a.k.ABFrameHolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public final class g extends JPanel implements j, ActionListener {
    private final ABFrameHolder abFrameHolder;
    private ABProgram abProgram;
    private final com.github.kill05.algobuildce.package_a.c.a.e c;
    private final Timer d;
    private boolean e = false;
    private JSplitPane f;
    private JSplitPane g;
    private final int h = 4;
    private final double i = 0.75D;
    private final double j = 0.75D;
    private int k = -1;
    private final a l;
    private final c m;
    private final JScrollPane n;
    private final h o;
    private final JScrollPane p;
    private ABFrame q;
    private m r;
    private ExecutionOptionsDialogue s;
    private final Stack<com.github.kill05.algobuildce.package_a.g.g> t;
    private final Stack<com.github.kill05.algobuildce.package_a.g.g> u;

    public g(ABFrameHolder var1) {
        this.abFrameHolder = var1;
        this.abProgram = new ABProgram();
        this.c = new com.github.kill05.algobuildce.package_a.c.a.e(this.abProgram);
        this.d = new Timer(1000, this);
        this.d.setInitialDelay(10);
        this.setLayout(new BorderLayout());
        this.l = new a();
        this.l.a(this);
        this.abProgram.a(this);
        this.abProgram.a("main", 1);
        this.abProgram.update(false);
        this.m = new c(this.abProgram);
        this.n = new JScrollPane(this.m);
        this.o = new h();
        this.p = new JScrollPane(this.o);
        this.t = new Stack();
        this.u = new Stack();
        this.abFrameHolder.setActionEnabled("mnuEditUndo", false);
        this.abFrameHolder.setActionEnabled("mnuEditRedo", false);
    }

    public void b(int var1) {
        this.getWidth();
        this.getHeight();
        if (1 != this.k) {
            this.removeAll();
            this.f = new JSplitPane(0);
            this.g = new JSplitPane(1);
            this.f.setDividerSize(this.h);
            this.g.setDividerSize(this.h);
            this.f.setTopComponent(this.l);
            this.f.setBottomComponent(this.g);
            this.g.setLeftComponent(this.n);
            this.g.setRightComponent(this.p);
            this.add(this.f, "Center");
            this.f.setResizeWeight(this.i);
            this.g.setResizeWeight(this.j);
            this.k = 1;
        }

    }

    public void a(ABFrame var1) {
        this.q = var1;
        if (this.l != null) {
            this.l.a(var1);
        }

    }

    public void c() {
        boolean var1 = false;
        if (!this.abProgram.p()) {
            var1 = true;
        } else {
            int var2;
            if ((var2 = JOptionPane.showConfirmDialog(null, Translator.translate("modifiedSaveQuestion"), "AlgoBuild", JOptionPane.YES_NO_CANCEL_OPTION)) == 0) {
                this.f();
                if (!this.abProgram.p()) {
                    var1 = true;
                }
            } else if (var2 == 1) {
                var1 = true;
            }
        }

        String filePath = this.abFrameHolder.selectFilePath(Translator.translate("mnuFileOpen1"));
        if (var1 && filePath != null && !filePath.isEmpty()) {
            this.abProgram.load(filePath);
            if (!this.abProgram.p()) {
                this.abFrameHolder.setActionEnabled("execInstruction", true);
                this.abFrameHolder.setActionEnabled("execOptions", true);
            }

            this.l.b.setSelectedIndex(0);
            this.l.repaint();
        }

    }

    public boolean d() {
        boolean var1 = this.abProgram.p();
        this.abFrameHolder.setActionEnabled("mnuFileSave", var1);
        return var1;
    }

    public boolean e() {
        boolean var1 = false;
        if (!this.abProgram.p()) {
            var1 = true;
        } else {
            int var2;
            if ((var2 = JOptionPane.showConfirmDialog(null, Translator.translate("modifiedSaveQuestion"), "AlgoBuild", JOptionPane.YES_NO_CANCEL_OPTION)) == 0) {
                this.f();
                if (!this.abProgram.p()) {
                    var1 = true;
                }
            } else if (var2 == 1) {
                var1 = true;
            }
        }

        return var1;
    }

    public void f() {
        boolean var1 = this.abProgram.p();

        if (var1) {
            String var2;
            if ((var2 = this.abProgram.o()) != null) {
                this.abProgram.saveProgram(var2);
                if (!this.abProgram.p()) {
                    this.abFrameHolder.setActionEnabled("mnuFileSave", false);
                }
            } else {
                this.g();
            }
        }

    }

    public void g() {
        String var1;
        if ((var1 = this.abFrameHolder.saveFile(this.abProgram.o())) != null && !var1.isEmpty()) {
            this.abProgram.saveProgram(var1);
            if (!this.abProgram.p()) {
                this.abFrameHolder.setActionEnabled("mnuFileSave", false);
            }
        }

    }

    public void h() {
        int var1 = this.abProgram.getExecutionOptions().getClockSpeed();
        this.d.setDelay(var1);
        this.d.setInitialDelay(10);
        boolean var2;
        if (!this.c.b()) {
            if (this.k == 0) {
                this.b(1);
                this.doLayout();
                this.updateUI();
            }

            this.m.b();
            this.o.setText("");
            this.c.a("main");
            var2 = this.c.b();
            this.abFrameHolder.setActionEnabled("execInterrupt", var2);
            if (!this.abProgram.getExecutionOptions().isStepEnabled()) {
                this.d.start();
                this.abFrameHolder.setActionEnabled("execInstruction", !var2);
                this.abFrameHolder.setActionEnabled("execPause", var2);
                this.abFrameHolder.setActionEnabled("execInterrupt", var2);
            }
        } else {
            if (this.abProgram.getExecutionOptions().isStepEnabled()) {
                this.c.c();
                var2 = this.c.b();
                this.abFrameHolder.setActionEnabled("execInstruction", true);
                this.abFrameHolder.setActionEnabled("execPause", false);
                this.abFrameHolder.setActionEnabled("execInterrupt", var2);
                return;
            }

            this.d.start();
            this.abFrameHolder.setActionEnabled("execInstruction", false);
            this.abFrameHolder.setActionEnabled("execPause", true);
            this.abFrameHolder.setActionEnabled("execInterrupt", true);
        }

    }

    public void i() {
        if (this.d.isRunning()) {
            this.d.stop();
        }

        this.abFrameHolder.setActionEnabled("execInstruction", true);
        this.abFrameHolder.setActionEnabled("execPause", false);
        this.abFrameHolder.setActionEnabled("execInterrupt", this.c.b());
    }

    public void j() {
        if (this.c.b()) {
            this.c.a();
            boolean var1 = this.c.b();
            this.abFrameHolder.setActionEnabled("execInstruction", true);
            this.abFrameHolder.setActionEnabled("execPause", var1);
            this.abFrameHolder.setActionEnabled("execInterrupt", var1);
        }

    }

    @Override
    public void a(ABProgram var1) {
        this.abProgram = var1;
        this.l.a = var1;
    }

    @Override
    public void a(ABExecutable var1) {
        this.l.a(var1);
    }

    @Override
    public void b(ABProgram var1) {
        this.d();

        try {
            this.m.setFont(this.abProgram.getViewOptions().getConsoleFont());
            this.m.a();
            this.o.setFont(this.abProgram.getViewOptions().getConsoleFont());
            int var2 = this.abProgram.getExecutionOptions().getClockSpeed();
            if (this.d.getDelay() != var2) {
                this.d.setDelay(var2);
                this.d.setInitialDelay(var2);
            }

            this.q.setTitle(var1.o());
        } catch (Exception ignored) {
        }
    }

    public void h(String var1) {
        int var2;
        if ((var2 = this.l.b.indexOfTab(var1)) >= 0) {
            this.l.b.setSelectedIndex(var2);
        }

    }

    @Override
    public void a() {
        this.l.b();
    }

    @Override
    public void a(int var1) {
        this.m.a(var1);
    }

    @Override
    public String g(String var1) {
        if ((var1 = (new d(this.q, var1)).a()) == null) {
            this.e = true;
            var1 = "execPause";
        }

        return var1;
    }

    @Override
    public void a(String var1) {
        this.m.a(var1, false, false, false);
    }

    @Override
    public void b() {
        this.m.a("", true, false, false);
    }

    @Override
    public void b(String var1) {
        this.m.a(var1, true, false, false);
    }

    @Override
    public void c(String var1) {
        this.m.a(var1, true, true, false);
    }

    @Override
    public void e(String var1) {
        this.m.a(var1, true, true, true);
    }

    @Override
    public void d(String var1) {
        this.m.a(var1, false, true, false);
    }

    @Override
    public void f(String var1) {
        this.o.setText(var1);
    }

    @Override
    public void a(String var1, q var2) {
        this.l.a(var1, var2);
    }

    public void k() {
        if (this.r == null) {
            this.r = new m(this.q, this.abProgram);
        }

        this.r.setVisible(!this.r.isVisible());

    }

    public void l() {
        if (this.s == null) {
            this.s = new ExecutionOptionsDialogue(this.q, this.abProgram);
        }

        this.s.setVisible(!this.s.isVisible());

    }

    @Override
    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.d) {
            if (this.c.b()) {
                this.c.c();
            } else {
                this.d.stop();
            }

            if (!this.e) {
                boolean var3 = this.c.b();
                boolean var2 = this.abProgram.getExecutionOptions().isStepEnabled();
                this.abFrameHolder.setActionEnabled("execInstruction", !var3 || var2);
                this.abFrameHolder.setActionEnabled("execPause", var3 && !var2);
                this.abFrameHolder.setActionEnabled("execInterrupt", var3);
                return;
            }

            this.i();
            this.e = false;
        }

    }

    public void a(com.github.kill05.algobuildce.package_a.g.g var1) {
        this.t.push(var1);
        if (!this.u.empty()) {
            this.u.removeAllElements();
        }

        this.abFrameHolder.setActionEnabled("mnuEditUndo", true);
        this.abFrameHolder.setActionEnabled("mnuEditRedo", false);
    }

    public boolean m() {
        return !this.t.empty();
    }

    public boolean n() {
        return !this.u.empty();
    }

    public void o() {
        if (this.m()) {
            com.github.kill05.algobuildce.package_a.g.g var1 = this.t.pop();
            var1.b();
            this.u.push(var1);
            this.abFrameHolder.setActionEnabled("mnuEditUndo", this.m());
            this.abFrameHolder.setActionEnabled("mnuEditRedo", this.n());
        }

    }

    public void p() {
        if (this.n()) {
            com.github.kill05.algobuildce.package_a.g.g var1;
            (var1 = this.u.pop()).a();
            this.t.push(var1);
            this.abFrameHolder.setActionEnabled("mnuEditUndo", this.m());
            this.abFrameHolder.setActionEnabled("mnuEditRedo", this.n());
        }

    }

    @Override
    public void b(ABExecutable var1) {
        this.l.b(var1);
    }

    public void q() {
        this.l.d();
    }

    public void r() {
        this.l.e();
    }

    public void s() {
        String var1 = this.abProgram.s();
        JOptionPane.showMessageDialog(this.q, var1, Translator.translate("mnuHistoryInfo"), JOptionPane.INFORMATION_MESSAGE);
    }
}
