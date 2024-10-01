package com.github.kill05.algobuildce.package_a.f;

import java.util.TreeMap;

public final class g {
   private TreeMap a = new TreeMap();

   public final void a(String var1, String var2) {
      var2 = var2.replace("\n", "\\n");
      this.a.put(var1, var2);
   }

   public final String a(String var1) {
      if ((var1 = (String)this.a.get(var1)) != null) {
         var1 = var1.replace("\\n", "\n");
      }

      return var1;
   }

   public final String toString() {
      return "ABPElement [data=" + this.a + "]";
   }
}
