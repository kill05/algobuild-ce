package package_a.j.b;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class n extends JPanel implements ActionListener, MouseListener {
   protected package_a.c.a.b b;
   protected package_a.j.a.a c;
   protected boolean d = false;
   protected int e = (int)(6.0D * package_a.k.b.a());
   protected int f = (int)(6.0D * package_a.k.b.a());
   private int a = -1;
   protected boolean g = false;
   package_a.j.b.c h;

   public n(package_a.c.a.b var1, package_a.j.a.a var2) {
      this.b = var1;
      this.c = var2;
      this.setLayout((LayoutManager)null);
      this.a(new Dimension(2 * this.e, 2 * this.f));
      this.addMouseListener(this);
      this.setToolTipText((String)null);
      this.setFont(var1.q().b());
      this.setOpaque(false);
   }

   public final void a(n var1, int var2) {
      var1.add(this, 0);
      this.a = 0;
   }

   public int b() {
      return this.a;
   }

   public String toString() {
      return "ABVFC_BasePanel ";
   }

   public final void a(Dimension var1) {
      this.setPreferredSize(var1);
      this.setMinimumSize(var1);
      this.setMaximumSize(var1);
      this.setSize(var1);
   }

   protected final void a(boolean var1) {
      if (this.f()) {
         this.g();
      }

      this.d |= var1;

      try {
         ((n)this.getParent()).a(this.d);
      } catch (Exception var2) {
         this.invalidate();
      }
   }

   public void mouseClicked(MouseEvent var1) {
   }

   public void mouseEntered(MouseEvent var1) {
      this.g = true;
      this.repaint();
   }

   public void mouseExited(MouseEvent var1) {
      this.g = false;
      this.repaint();
   }

   public void mousePressed(MouseEvent var1) {
   }

   public void mouseReleased(MouseEvent var1) {
      if (var1.isPopupTrigger()) {
         this.c();
      } else {
         this.a(var1);
      }
   }

   protected void a(MouseEvent var1) {
   }

   protected void c() {
   }

   public void actionPerformed(ActionEvent var1) {
      JOptionPane.showMessageDialog(this, "ABVFC_BasePanel - ActionPerformed - NOT IMPLEMENTED");
   }

   public boolean f() {
      return false;
   }

   protected void b(Graphics var1) {
      if (this.g) {
         var1.setColor(this.b.q().g());
      } else {
         var1.setColor(this.b.q().e());
      }
   }

   protected void c(Graphics var1) {
      if (this.g) {
         var1.setColor(this.b.q().k());
      } else {
         var1.setColor(this.b.q().i());
      }
   }

   protected void a(Graphics var1, int var2) {
      if (this.g) {
         var1.setColor(this.b.q().g());
      } else {
         var1.setColor(this.b.q().e());
      }
   }

   protected void d(Graphics var1) {
      if (this.g) {
         var1.setColor(this.b.q().k());
      } else {
         var1.setColor(this.b.q().i());
      }
   }

   protected void paintComponent(Graphics var1) {
      super.paintComponent(var1);
      if (this.h != null) {
         this.h.a(this, var1);
      } else {
         this.a(var1);
      }
   }

   public final void g() {
      this.e = this.f = (this.b.q().b().getSize() + 1) / 2;
      this.setFont(this.b.q().b());
      if (this.h != null) {
         this.h.a(this);
      } else {
         this.a();
      }
   }

   public void a(Graphics var1) {
      ((Graphics2D)var1).setStroke(this.b.q().l());
      ((Graphics2D)var1).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   }

   public void a() {
   }

   public void a(package_a.j.b.c var1) {
      this.h = var1;
      if (var1 != null) {
         var1.b(this);
      }

   }

   public void printComponent(Graphics var1) {
      this.paintComponent(var1);
   }
}
