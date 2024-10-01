package package_a.j.a;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

final class e extends AbstractAction {
   // $FF: synthetic field
   private d a;

   e(d var1) {
      this.a = var1;
      super();
   }

   public final void actionPerformed(ActionEvent var1) {
      d.a(this.a, (String)null);
      this.a.setVisible(false);
   }
}
