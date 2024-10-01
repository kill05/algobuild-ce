package package_a.j.a;

import package_a.a.m;
import package_a.a.n;
import package_a.c.a.j;
import package_a.c.b.q;
import package_a.k.C;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.Timer;

public final class g extends JPanel implements j, ActionListener {
   private a.k.c a;
   private a.c.a.b b;
   private a.c.a.e c;
   private Timer d;
   private boolean e = false;
   private JSplitPane f;
   private JSplitPane g;
   private int h = 4;
   private double i = 0.75D;
   private double j = 0.75D;
   private int k = -1;
   private a l;
   private c m;
   private JScrollPane n;
   private h o;
   private JScrollPane p;
   private C q;
   private m r;
   private n s;
   private Stack t;
   private Stack u;

   public g(a.k.c var1) {
      this.a = var1;
      this.b = new a.c.a.b();
      this.c = new a.c.a.e(this.b);
      this.d = new Timer(1000, this);
      this.d.setInitialDelay(10);
      this.setLayout(new BorderLayout());
      this.l = new a();
      this.l.a(this);
      this.b.a((j)this);
      this.b.a("main", 1);
      this.b.a(false);
      this.m = new c(this.b);
      this.n = new JScrollPane(this.m);
      this.o = new h();
      this.p = new JScrollPane(this.o);
      this.t = new Stack();
      this.u = new Stack();
      this.a.a("mnuEditUndo", false);
      this.a.a("mnuEditRedo", false);
   }

   public final void b(int var1) {
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

   public final void a(C var1) {
      this.q = var1;
      if (this.l != null) {
         this.l.a(var1);
      }

   }

   public final void c() {
      boolean var1 = false;
      if (!this.b.p()) {
         var1 = true;
      } else {
         int var2;
         if ((var2 = JOptionPane.showConfirmDialog((Component)null, a.i.c.a("modifiedSaveQuestion"), "AlgoBuild", 1)) == 0) {
            this.f();
            if (!this.b.p()) {
               var1 = true;
            }
         } else if (var2 == 1) {
            var1 = true;
         }
      }

      String var3;
      if (var1 && (var3 = this.a.e()) != null && !var3.isEmpty()) {
         this.b.k(var3);
         if (!this.b.p() && this.a != null) {
            this.a.a("execInstruction", true);
            this.a.a("execOptions", true);
         }

         this.l.b.setSelectedIndex(0);
         this.l.repaint();
      }

   }

   public final boolean d() {
      boolean var1 = this.b.p();
      this.a.a("mnuFileSave", var1);
      return var1;
   }

   public final boolean e() {
      boolean var1 = false;
      if (!this.b.p()) {
         var1 = true;
      } else {
         int var2;
         if ((var2 = JOptionPane.showConfirmDialog((Component)null, a.i.c.a("modifiedSaveQuestion"), "AlgoBuild", 1)) == 0) {
            this.f();
            if (!this.b.p()) {
               var1 = true;
            }
         } else if (var2 == 1) {
            var1 = true;
         }
      }

      return var1;
   }

   public final void f() {
      boolean var1 = false;
      if (this.b.p()) {
         var1 = true;
      }

      if (var1) {
         String var2;
         if ((var2 = this.b.o()) != null) {
            this.b.j(var2);
            if (!this.b.p()) {
               this.a.a("mnuFileSave", false);
               return;
            }
         } else {
            this.g();
         }
      }

   }

   public final void g() {
      String var1;
      if ((var1 = this.a.a(this.b.o())) != null && !var1.isEmpty()) {
         this.b.j(var1);
         if (!this.b.p()) {
            this.a.a("mnuFileSave", false);
         }
      }

   }

   public final void h() {
      int var1 = this.b.r().c();
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
         this.a.a("execInterrupt", var2);
         if (!this.b.r().b()) {
            this.d.start();
            this.a.a("execInstruction", !var2);
            this.a.a("execPause", var2);
            this.a.a("execInterrupt", var2);
            return;
         }
      } else {
         if (this.b.r().b()) {
            this.c.c();
            var2 = this.c.b();
            this.a.a("execInstruction", true);
            this.a.a("execPause", false);
            this.a.a("execInterrupt", var2);
            return;
         }

         this.d.start();
         this.a.a("execInstruction", false);
         this.a.a("execPause", true);
         this.a.a("execInterrupt", true);
      }

   }

   public final void i() {
      if (this.d.isRunning()) {
         this.d.stop();
      }

      this.a.a("execInstruction", true);
      this.a.a("execPause", false);
      this.a.a("execInterrupt", this.c.b());
   }

   public final void j() {
      if (this.c.b()) {
         this.c.a();
         boolean var1 = this.c.b();
         this.a.a("execInstruction", true);
         this.a.a("execPause", var1);
         this.a.a("execInterrupt", var1);
      }

   }

   public final void a(a.c.a.b var1) {
      this.b = var1;
      this.l.a = var1;
   }

   public final void a(a.c.a.d var1) {
      this.l.a(var1);
   }

   public final void b(a.c.a.b var1) {
      this.d();

      try {
         this.m.setFont(this.b.q().c());
         this.m.a();
         this.o.setFont(this.b.q().c());
         int var2 = this.b.r().c();
         if (this.d.getDelay() != var2) {
            this.d.setDelay(var2);
            this.d.setInitialDelay(var2);
         }

         this.q.setTitle(var1.o());
      } catch (Exception var3) {
      }
   }

   public final void h(String var1) {
      int var2;
      if ((var2 = this.l.b.indexOfTab(var1)) >= 0) {
         this.l.b.setSelectedIndex(var2);
      }

   }

   public final void a() {
      this.l.b();
   }

   public final void a(int var1) {
      this.m.a(var1);
   }

   public final String g(String var1) {
      if ((var1 = (new d(this.q, var1)).a()) == null) {
         this.e = true;
         var1 = "execPause";
      }

      return var1;
   }

   public final void a(String var1) {
      this.m.a(var1, false, false, false);
   }

   public final void b() {
      this.m.a("", true, false, false);
   }

   public final void b(String var1) {
      this.m.a(var1, true, false, false);
   }

   public final void c(String var1) {
      this.m.a(var1, true, true, false);
   }

   public final void e(String var1) {
      this.m.a(var1, true, true, true);
   }

   public final void d(String var1) {
      this.m.a(var1, false, true, false);
   }

   public final void f(String var1) {
      this.o.setText(var1);
   }

   public final void a(String var1, q var2) {
      this.l.a(var1, var2);
   }

   public final void k() {
      if (this.r == null) {
         this.r = new m(this.q, this.b);
      }

      if (this.r != null) {
         this.r.setVisible(!this.r.isVisible());
      }

   }

   public final void l() {
      if (this.s == null) {
         this.s = new n(this.q, this.b);
      }

      if (this.s != null) {
         this.s.setVisible(!this.s.isVisible());
      }

   }

   public final void actionPerformed(ActionEvent var1) {
      if (var1.getSource() == this.d) {
         if (this.c.b()) {
            this.c.c();
         } else {
            this.d.stop();
         }

         if (!this.e) {
            boolean var3 = this.c.b();
            boolean var2 = this.b.r().b();
            this.a.a("execInstruction", !var3 || var2);
            this.a.a("execPause", var3 && !var2);
            this.a.a("execInterrupt", var3);
            return;
         }

         this.i();
         this.e = false;
      }

   }

   public final void a(a.g.g var1) {
      this.t.push(var1);
      if (!this.u.empty()) {
         this.u.removeAllElements();
      }

      this.a.a("mnuEditUndo", true);
      this.a.a("mnuEditRedo", false);
   }

   public final boolean m() {
      return !this.t.empty();
   }

   public final boolean n() {
      return !this.u.empty();
   }

   public final void o() {
      if (this.m()) {
         a.g.g var1;
         (var1 = (a.g.g)this.t.pop()).b();
         this.u.push(var1);
         this.a.a("mnuEditUndo", this.m());
         this.a.a("mnuEditRedo", this.n());
      }

   }

   public final void p() {
      if (this.n()) {
         a.g.g var1;
         (var1 = (a.g.g)this.u.pop()).a();
         this.t.push(var1);
         this.a.a("mnuEditUndo", this.m());
         this.a.a("mnuEditRedo", this.n());
      }

   }

   public final void b(a.c.a.d var1) {
      this.l.b(var1);
   }

   public final void q() {
      this.l.d();
   }

   public final void r() {
      this.l.e();
   }

   public final void s() {
      String var1 = this.b.s();
      JOptionPane.showMessageDialog(this.q, var1, a.i.c.a("mnuHistoryInfo"), 1);
   }
}
