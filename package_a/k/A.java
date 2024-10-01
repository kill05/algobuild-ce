package package_a.k;

import java.util.Map;
import java.util.TreeMap;
import javax.swing.Action;

public final class A {
   private Map a = null;

   public A() {
      this.a = new TreeMap();
   }

   public final void a(String var1, Action var2) {
      this.a.put(var1, var2);
   }

   public final Action a(String var1) {
      Action var2 = null;
      if (var1 != null) {
         var2 = (Action)this.a.get(var1);
      } else {
         System.err.println("null ACTION for key:" + var1);
      }

      return var2;
   }
}
