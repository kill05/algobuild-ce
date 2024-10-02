package com.github.kill05.algobuildce.package_a.k;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;

final class g extends AbstractAction {
   // $FF: synthetic field
   private ABFrameHolder a;

   g(ABFrameHolder var1, String var2, Icon var3) {
      super(var2, var3);
      this.a = var1;
   }

   public final void actionPerformed(ActionEvent var1) {
      this.a.j();
   }
}
