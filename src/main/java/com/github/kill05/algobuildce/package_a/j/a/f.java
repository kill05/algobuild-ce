package com.github.kill05.algobuildce.package_a.j.a;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

final class f extends AbstractAction {
    private final VariableInputDialog a;

    f(VariableInputDialog var1) {
        super();
        this.a = var1;
    }

    @Override
    public void actionPerformed(ActionEvent var1) {
        VariableInputDialog.a(this.a, VariableInputDialog.a(this.a).getText());
        this.a.setVisible(false);
    }
}
