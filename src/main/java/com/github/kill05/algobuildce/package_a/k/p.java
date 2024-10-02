package com.github.kill05.algobuildce.package_a.k;

import com.github.kill05.algobuildce.package_a.i.Translator;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.AbstractAction;

final class p extends AbstractAction {
   p(ABFrameHolder var1, String var2) {
      super(var2);
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      try {
         Desktop.getDesktop().browse(new URI(Translator.translate("mnuHelpOnlineAddr")));
      } catch (IOException var2) {
      } catch (URISyntaxException var3) {
      }
   }
}
