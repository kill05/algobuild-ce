package package_a.j.a;

import package_a.a.m;
import package_a.a.n;
import package_a.c.a.j;
import package_a.c.b.q;
import package_a.i.Translator;
import package_a.k.ABFrame;
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
   private final package_a.k.c a;
   private package_a.c.a.b b;
   private final package_a.c.a.e c;
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
   private n s;
   private final Stack t;
   private final Stack u;
    private package_a.c.a.d var1;

    public g(package_a.k.c var1) {
      this.a = var1;
      this.b = new package_a.c.a.b();
      this.c = new package_a.c.a.e(this.b);
      this.d = new Timer(1000, this);
      this.d.setInitialDelay(10);
      this.setLayout(new BorderLayout());
      this.l = new a();
      this.l.a(this);
      this.b.a(this);
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
      if (!this.b.p()) {
         var1 = true;
      } else {
         int var2;
         if ((var2 = JOptionPane.showConfirmDialog(null, Translator.translate("modifiedSaveQuestion"), "AlgoBuild", 1)) == 0) {
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

   public boolean d() {
      boolean var1 = this.b.p();
      this.a.a("mnuFileSave", var1);
      return var1;
   }

   public boolean e() {
      boolean var1 = false;
      if (!this.b.p()) {
         var1 = true;
      } else {
         int var2;
         if ((var2 = JOptionPane.showConfirmDialog(null, Translator.translate("modifiedSaveQuestion"), "AlgoBuild", 1)) == 0) {
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

   public void f() {
      boolean var1 = this.b.p();

       if (var1) {
         String var2;
         if ((var2 = this.b.o()) != null) {
            this.b.j(var2);
            if (!this.b.p()) {
               this.a.a("mnuFileSave", false);
            }
         } else {
            this.g();
         }
      }

   }

   public void g() {
      String var1;
      if ((var1 = this.a.a(this.b.o())) != null && !var1.isEmpty()) {
         this.b.j(var1);
         if (!this.b.p()) {
            this.a.a("mnuFileSave", false);
         }
      }

   }

   public void h() {
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

   public void i() {
      if (this.d.isRunning()) {
         this.d.stop();
      }

      this.a.a("execInstruction", true);
      this.a.a("execPause", false);
      this.a.a("execInterrupt", this.c.b());
   }

   public void j() {
      if (this.c.b()) {
         this.c.a();
         boolean var1 = this.c.b();
         this.a.a("execInstruction", true);
         this.a.a("execPause", var1);
         this.a.a("execInterrupt", var1);
      }

   }

   @Override
   public void a(package_a.c.a.b var1) {
      this.b = var1;
      this.l.a = var1;
   }

   @Override
   public void a(package_a.c.a.d var1) {
       this.var1 = var1;
       this.l.a(var1);
   }

   @Override
   public void b(package_a.c.a.b var1) {
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
         this.r = new m(this.q, this.b);
      }

      if (this.r != null) {
         this.r.setVisible(!this.r.isVisible());
      }

   }

   public void l() {
      if (this.s == null) {
         this.s = new n(this.q, this.b);
      }

      if (this.s != null) {
         this.s.setVisible(!this.s.isVisible());
      }

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

   public void a(package_a.g.g var1) {
      this.t.push(var1);
      if (!this.u.empty()) {
         this.u.removeAllElements();
      }

      this.a.a("mnuEditUndo", true);
      this.a.a("mnuEditRedo", false);
   }

   public boolean m() {
      return !this.t.empty();
   }

   public boolean n() {
      return !this.u.empty();
   }

   public void o() {
      if (this.m()) {
         package_a.g.g var1;
         (var1 = (package_a.g.g)this.t.pop()).b();
         this.u.push(var1);
         this.a.a("mnuEditUndo", this.m());
         this.a.a("mnuEditRedo", this.n());
      }

   }

   public void p() {
      if (this.n()) {
         package_a.g.g var1;
         (var1 = (package_a.g.g)this.u.pop()).a();
         this.t.push(var1);
         this.a.a("mnuEditUndo", this.m());
         this.a.a("mnuEditRedo", this.n());
      }

   }

   @Override
   public void b(package_a.c.a.d var1) {
      this.l.b(var1);
   }

   public void q() {
      this.l.d();
   }

   public void r() {
      this.l.e();
   }

   public void s() {
      String var1 = this.b.s();
      JOptionPane.showMessageDialog(this.q, var1, Translator.translate("mnuHistoryInfo"), 1);
   }
}
