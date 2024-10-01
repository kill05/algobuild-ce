package package_a.j.a;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

final class f extends AbstractAction {
   // $FF: synthetic field
   private d a;

   f(d var1) {
      this.a = var1;
      super();
   }

   public final void actionPerformed(ActionEvent var1) {
      d.a(this.a, d.a(this.a).getText());
      this.a.setVisible(false);
   }
}
