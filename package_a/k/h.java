package package_a.k;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;

final class h extends AbstractAction {

   private final c a;

   h(c var1, String var2, Icon var3) {
      super(var2, var3);
      this.a = var1;
   }

   @Override
   public void actionPerformed(ActionEvent var1) {
      this.a.k();
   }
}
