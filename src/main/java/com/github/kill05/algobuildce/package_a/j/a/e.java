package com.github.kill05.algobuildce.package_a.j.a;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

final class e extends AbstractAction {
    private VariableInputDialog a;

    e(VariableInputDialog var1) {
        super();
        this.a = var1;
    }

    @Override
    public void actionPerformed(ActionEvent var1) {
        VariableInputDialog.a(this.a, null);
        this.a.setVisible(false);
    }
}
