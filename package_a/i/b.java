package package_a.i;

import java.net.URL;
import javax.swing.ImageIcon;

public final class b {
   private static b a = new b();

   public static ImageIcon a(String var0) {
      ImageIcon var1 = null;

      try {
         URL var4 = a.getClass().getClassLoader().getResource(var0);
         var1 = new ImageIcon(var4);
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      return var1;
   }
}
