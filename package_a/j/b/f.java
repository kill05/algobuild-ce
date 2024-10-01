package package_a.j.b;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public final class f extends n {
   public f(package_a.c.a.b var1, package_a.j.a.a var2) {
      super(var1, var2);
      this.a((Dimension)(new Dimension(6 * this.e, 2 * this.f)));
      this.setLocation(10, 10);
      this.setToolTipText("clic Nuovo.../Incolla");
   }

   public final void a(Graphics var1) {
      package_a.c.a.d var2 = null;
      if (this.b.a() != null) {
         var2 = this.b.a().d();
      }

      int var3 = this.getWidth();
      int var4 = this.getHeight();
      int var5 = (int)((double)this.b.q().h() * package_a.k.b.a());
      int var6 = (int)((double)this.b.q().m() * package_a.k.b.a());
      this.c(var1);
      if (this.g && var2 == null) {
         this.b(var1);
         var1.fillRect(0, 0, var3 - 1, var4 - 1);
         this.c(var1);
         var1.drawRect(0, 0, var3 - 1, var4 - 1);
         String var7 = "NEW";
         Rectangle2D var8;
         var5 = (int)((var8 = var1.getFontMetrics().getStringBounds(var7, var1)).getWidth() / 2.0D);
         var4 = (int)Math.round(-var8.getHeight() / 2.0D - var8.getY());
         var3 = var3 / 2 - var5;
         var4 += 1 * this.f;
         var1.drawString(var7, var3, var4);
      } else {
         var1.drawLine(var3 / 2, 0, var3 / 2, var4);
         var1.drawLine(var3 / 2, var4 - var5, var3 / 2 - var6, var4 - var6 - var5);
         var1.drawLine(var3 / 2, var4 - var5, var3 / 2 + var6, var4 - var6 - var5);
      }
   }

   public final int b() {
      int var1 = -1;
      Container var2 = this.getParent();

      for(int var3 = 0; var1 < 0 && var3 < var2.getComponentCount(); ++var3) {
         if (this == var2.getComponent(var3)) {
            var1 = var3 / 2;
         }
      }

      return var1;
   }

   private String d() {
      o var1 = (o)this.getParent();
      return var1.h() + "." + this.b();
   }

   public final void a(MouseEvent var1) {
      package_a.c.a.d var2 = null;
      if (this.b.a() != null) {
         var2 = this.b.a().d();
      }

      if (var2 == null) {
         JPopupMenu var4 = new JPopupMenu();
         JLabel var3;
         (var3 = new JLabel(package_a.i.c.a("instructionConnectorNewMsg"))).setIcon(package_a.i.b.a("imgs/new_instruction.gif"));
         var4.insert(var3, 0);
         JMenuItem var5;
         (var5 = new JMenuItem(package_a.i.c.a("instructionConnectorNewAssign"), package_a.i.b.a("imgs/assign_icon.gif"))).addActionListener(this);
         var4.add(var5);
         (var5 = new JMenuItem(package_a.i.c.a("instructionConnectorNewInput"), package_a.i.b.a("imgs/input_icon.gif"))).addActionListener(this);
         var4.add(var5);
         (var5 = new JMenuItem(package_a.i.c.a("instructionConnectorNewOutput"), package_a.i.b.a("imgs/output_icon.gif"))).addActionListener(this);
         var4.add(var5);
         (var5 = new JMenuItem(package_a.i.c.a("instructionConnectorNewIf"), package_a.i.b.a("imgs/if_icon.gif"))).addActionListener(this);
         var4.add(var5);
         (var5 = new JMenuItem(package_a.i.c.a("instructionConnectorNewFor"), package_a.i.b.a("imgs/for_icon.gif"))).addActionListener(this);
         var4.add(var5);
         (var5 = new JMenuItem(package_a.i.c.a("instructionConnectorNewWhile"), package_a.i.b.a("imgs/while_icon.gif"))).addActionListener(this);
         var4.add(var5);
         (var5 = new JMenuItem(package_a.i.c.a("instructionConnectorNewDoWhile"), package_a.i.b.a("imgs/dowhile_icon.gif"))).addActionListener(this);
         var4.add(var5);
         (var5 = new JMenuItem(package_a.i.c.a("instructionConnectorNewComment"), package_a.i.b.a("imgs/comment_icon.gif"))).addActionListener(this);
         var4.add(var5);
         (var5 = new JMenuItem(package_a.i.c.a("instructionConnectorNewCall"), package_a.i.b.a("imgs/call_icon.gif"))).addActionListener(this);
         if (this.b.h().c() <= 1) {
            var5.setEnabled(false);
         }

         var4.add(var5);
         var4.addSeparator();
         var5 = new JMenuItem(package_a.i.c.a("instructionConnectorPaste"));
         if (this.b.k() == null) {
            var5.setEnabled(false);
         }

         var5.addActionListener(this);
         var4.add(var5);
         var4.show(var1.getComponent(), var1.getX(), var1.getY());
      }
   }

   public final void actionPerformed(ActionEvent var1) {
      String var12;
      if ((var12 = var1.getActionCommand()) != null && var12.length() > 0) {
         String var2;
         int var4;
         int var5;
         f var13;
         String var19;
         if (var12.equals(package_a.i.c.a("instructionConnectorPaste"))) {
            var13 = this;
            var2 = this.d();
            package_a.c.a.d var17 = this.b.k();
            var4 = var2.lastIndexOf(46);

            try {
               if (var17 != null && var4 > 0) {
                  var5 = Integer.parseInt(var2.substring(var4 + 1));
                  var19 = var2.substring(0, var4);
                  package_a.c.a.d var27 = var17.e();

                  try {
                     if (var27 != null) {
                        var13.b.a(var19, var5, (package_a.c.b.n)var27);
                        package_a.g.f var23 = new package_a.g.f(var13.b, var19, var5, (package_a.c.b.n)var27);
                        var13.c.c().a((package_a.g.g)var23);
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

            return;
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
                        package_a.g.f var15;
                        if (var2.equals(package_a.i.c.a("instructionConnectorNewAssign"))) {
                           package_a.c.b.a var26 = new package_a.c.b.a("");
                           var13.b.a(var19, var5, var26);
                           var13.b.a((package_a.c.a.d)var26);
                           if (!package_a.a.a.a(var13.c.a(), (package_a.c.b.a)var26)) {
                              var13.b.c(var3);
                              var13.b.a(var6);
                           } else {
                              var15 = new package_a.g.f(var13.b, var19, var5, var26);
                              var13.c.c().a((package_a.g.g)var15);
                           }

                           var13.b.a((package_a.c.a.d)null);
                           return;
                        }

                        if (var2.equals(package_a.i.c.a("instructionConnectorNewInput"))) {
                           package_a.c.b.i var25 = new package_a.c.b.i("");
                           var13.b.a(var19, var5, var25);
                           var13.b.a((package_a.c.a.d)var25);
                           if (!package_a.a.g.a(var13.c.a(), (package_a.c.b.i)var25)) {
                              var13.b.c(var3);
                              var13.b.a(var6);
                           } else {
                              var15 = new package_a.g.f(var13.b, var19, var5, var25);
                              var13.c.c().a((package_a.g.g)var15);
                           }

                           var13.b.a((package_a.c.a.d)null);
                           return;
                        }

                        if (var2.equals(package_a.i.c.a("instructionConnectorNewOutput"))) {
                           package_a.c.b.j var24 = new package_a.c.b.j("");
                           var13.b.a(var19, var5, var24);
                           var13.b.a((package_a.c.a.d)var24);
                           if (!package_a.a.h.a(var13.c.a(), (package_a.c.b.j)var24) && ((package_a.c.b.j)var24).j() == 0) {
                              var13.b.c(var3);
                              var13.b.a(var6);
                           } else {
                              var15 = new package_a.g.f(var13.b, var19, var5, var24);
                              var13.c.c().a((package_a.g.g)var15);
                           }

                           var13.b.a((package_a.c.a.d)null);
                           return;
                        }

                        if (var2.equals(package_a.i.c.a("instructionConnectorNewIf"))) {
                           package_a.c.b.l var22 = new package_a.c.b.l("");
                           var13.b.a(var19, var5, var22);
                           var13.b.a((package_a.c.a.d)var22);
                           if (!package_a.a.i.a(var13.c.a(), (package_a.c.b.l)var22)) {
                              var13.b.c(var3);
                              var13.b.a(var6);
                           } else {
                              var15 = new package_a.g.f(var13.b, var19, var5, var22);
                              var13.c.c().a((package_a.g.g)var15);
                           }

                           var13.b.a((package_a.c.a.d)null);
                           return;
                        }

                        if (var2.equals(package_a.i.c.a("instructionConnectorNewFor"))) {
                           package_a.c.b.f var21 = new package_a.c.b.f("", "", "");
                           var13.b.a(var19, var5, var21);
                           var13.b.a((package_a.c.a.d)var21);
                           if (!package_a.a.e.a(var13.c.a(), (package_a.c.b.f)var21)) {
                              var13.b.c(var3);
                              var13.b.a(var6);
                           } else {
                              var15 = new package_a.g.f(var13.b, var19, var5, var21);
                              var13.c.c().a((package_a.g.g)var15);
                           }

                           var13.b.a((package_a.c.a.d)null);
                           return;
                        }

                        if (var2.equals(package_a.i.c.a("instructionConnectorNewWhile"))) {
                           package_a.c.b.g var20 = new package_a.c.b.g("");
                           var13.b.a(var19, var5, var20);
                           var13.b.a((package_a.c.a.d)var20);
                           if (!package_a.a.j.a(var13.c.a(), (package_a.c.b.g)var20)) {
                              var13.b.c(var3);
                              var13.b.a(var6);
                           } else {
                              var15 = new package_a.g.f(var13.b, var19, var5, var20);
                              var13.c.c().a((package_a.g.g)var15);
                           }

                           var13.b.a((package_a.c.a.d)null);
                           return;
                        }

                        if (var2.equals(package_a.i.c.a("instructionConnectorNewDoWhile"))) {
                           package_a.c.b.e var18 = new package_a.c.b.e("");
                           var13.b.a(var19, var5, var18);
                           var13.b.a((package_a.c.a.d)var18);
                           if (!package_a.a.f.a(var13.c.a(), (package_a.c.b.e)var18)) {
                              var13.b.c(var3);
                              var13.b.a(var6);
                           } else {
                              var15 = new package_a.g.f(var13.b, var19, var5, var18);
                              var13.c.c().a((package_a.g.g)var15);
                           }

                           var13.b.a((package_a.c.a.d)null);
                           return;
                        }

                        if (var2.equals(package_a.i.c.a("instructionConnectorNewComment"))) {
                           package_a.c.b.d var16 = new package_a.c.b.d("");
                           var13.b.a(var19, var5, var16);
                           var13.b.a((package_a.c.a.d)var16);
                           if (!package_a.a.d.a(var13.c.a(), (package_a.c.b.d)var16)) {
                              var13.b.c(var3);
                              var13.b.a(var6);
                           } else {
                              var15 = new package_a.g.f(var13.b, var19, var5, var16);
                              var13.c.c().a((package_a.g.g)var15);
                           }

                           var13.b.a((package_a.c.a.d)null);
                           return;
                        }

                        if (var2.equals(package_a.i.c.a("instructionConnectorNewCall"))) {
                           package_a.c.b.c var14 = new package_a.c.b.c("test");
                           var13.b.a(var19, var5, var14);
                           var13.b.a((package_a.c.a.d)var14);
                           if (!package_a.a.b.a(var13.c.a(), (package_a.c.b.c)var14, var13.b)) {
                              var13.b.c(var3);
                              var13.b.a(var6);
                           } else {
                              var15 = new package_a.g.f(var13.b, var19, var5, var14);
                              var13.c.c().a((package_a.g.g)var15);
                           }

                           var13.b.a((package_a.c.a.d)null);
                           return;
                        }
                     } catch (Exception var8) {
                        var8.printStackTrace();
                        return;
                     }
                  }
               } catch (NumberFormatException var9) {
                  var9.printStackTrace();
               }
            }
         }
      }

   }

   protected final void c() {
      String var1;
      int var2 = (var1 = this.d()).lastIndexOf(46);

      try {
         if (var2 > 0) {
            int var3 = Integer.parseInt(var1.substring(var2 + 1));
            var1 = var1.substring(0, var2);
            this.b.a(var1, var3, new package_a.c.b.j("'Added test output'"));
            return;
         }
      } catch (NumberFormatException var4) {
         var4.printStackTrace();
         return;
      } catch (package_a.c.b.s var5) {
         var5.printStackTrace();
      }

   }

   public final void a() {
      new Dimension(2 * this.e, 0 * this.f);
      this.a((Dimension)(new Dimension(6 * this.e, 2 * this.f)));
   }
}
