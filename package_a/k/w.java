package package_a.k;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

final class w extends AbstractAction {
    private final c a;

    w(c var1, String var2) {
        super(var2);
        this.a = var1;
    }

    public void actionPerformed(ActionEvent var1) {
        this.a.r();
    }
}
