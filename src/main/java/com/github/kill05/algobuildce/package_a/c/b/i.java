package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.package_c.ABExecutionException;

public final class i extends k {
   public i(String var1) {
      super(var1);
   }

   public i() {
      super((String)null);
   }

   @Override
   public final int a(com.github.kill05.algobuildce.package_a.c.a.b var1, int var2) {
      String[] var13 = this.l();

      for(int var3 = 0; var13 != null && var3 < var13.length; ++var3) {
         String var4 = null;

         try {
            if ((var4 = var1.e("Input richiesto")).equals("execPause")) {
               return 0;
            }

            System.out.println("DOING INPUT: ..... parts[i]=" + var13[var3]);
            String var5;
            double var8;
            if (var13[var3].toUpperCase().startsWith("DOUBLE ")) {
               var5 = var13[var3].substring(7);
               var8 = Double.parseDouble(var4);
               var5 = var5 + "=" + var8;
               System.out.println("IS DOUBLE");
            } else if (var13[var3].toUpperCase().startsWith("INT ")) {
               var5 = var13[var3].substring(4);
               int var15 = Integer.parseInt(var4);
               var5 = var5 + "=" + var15;
               System.out.println("IS INT");
            } else if (var13[var3].toUpperCase().startsWith("STRING ")) {
               var5 = var13[var3].substring(7);
               var5 = var5 + "=\"" + var4 + "\"";
               System.out.println("IS STRING");
            } else {
               var5 = var13[var3];
               var8 = Double.parseDouble(var4);
               var5 = var5 + "=" + var8;
               System.out.println("ELSE... IS DOUBLE");
            }

            System.out.println("INPUT TEST: assignCommand:" + var5);
            com.github.kill05.algobuildce.package_c.l var14 = var1.e().a(var5, var1.c());
            var1.h("INPUT: " + var13[var3] + "   VALUE: " + var14);
            var1.g(var14.toString());
         } catch (NullPointerException var10) {
            var1.i("INVALID INPUT !");
            return -2;
         } catch (NumberFormatException var11) {
            var1.i("INVALID INPUT NUMBER " + var4);
            return -2;
         } catch (ABExecutionException var12) {
            var1.i("INPUT ERROR: " + var12 + " IN " + var13[var3]);
            return -2;
         }
      }

      var1.i();
      return -1;
   }

   public final String toString() {
      return this.n() + "- ABIIOInput: " + this.k().replace("\n", ", ") + "\n";
   }

   @Override
   public final com.github.kill05.algobuildce.package_a.c.a.d e() {
      return new i(this.k());
   }

   @Override
   protected final String g() {
      return "ABIINP";
   }
}
