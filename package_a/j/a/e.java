package package_a.j.a;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

final class e extends AbstractAction {
    private d a;

    e(d var1) {
        super();
        this.a = var1;
    }

    @Override
    public void actionPerformed(ActionEvent var1) {
        d.a(this.a, null);
        this.a.setVisible(false);
    }
}
