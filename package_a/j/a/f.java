package package_a.j.a;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

final class f extends AbstractAction {
    private final d a;

    f(d var1) {
        super();
        this.a = var1;
    }

    @Override
    public void actionPerformed(ActionEvent var1) {
        d.a(this.a, d.a(this.a).getText());
        this.a.setVisible(false);
    }
}
