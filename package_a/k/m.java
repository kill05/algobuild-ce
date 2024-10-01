package package_a.k;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

final class m extends AbstractAction {
   // $FF: synthetic field
   private c a;

   m(c var1, String var2) {
      this.a = var1;
      super(var2);
   }

   public final void actionPerformed(ActionEvent var1) {
      this.a.s();
   }
}
