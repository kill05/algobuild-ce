package com.github.kill05.algobuildce.package_a.b;

import com.github.kill05.algobuildce.package_a.charfactory.CharArrayFactory;

public final class c extends CharArrayFactory {
   @Override
   protected final int getArrayLength() {
      return 4;
   }

   @Override
   protected final char getCharAt(int var1) {
      char var2 = 0;
      switch(var1) {
      case 0:
         var2 = 'c';
         break;
      case 1:
         var2 = 'o';
         break;
      case 2:
         var2 = 'r';
         break;
      case 3:
         var2 = 'e';
      }

      return var2;
   }
}
