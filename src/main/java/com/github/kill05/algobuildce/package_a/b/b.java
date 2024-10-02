package com.github.kill05.algobuildce.package_a.b;

import com.github.kill05.algobuildce.package_a.charfactory.CharArrayFactory;

public final class b extends CharArrayFactory {
   @Override
   protected final int getArrayLength() {
      return 10;
   }

   @Override
   protected final char getCharAt(int var1) {
      char var2 = 0;
      switch(var1) {
      case 0:
         var2 = '.';
         break;
      case 1:
         var2 = 'a';
         break;
      case 2:
         var2 = 'l';
         break;
      case 3:
         var2 = 'g';
         break;
      case 4:
         var2 = 'o';
         break;
      case 5:
         var2 = 'b';
         break;
      case 6:
         var2 = 'u';
         break;
      case 7:
         var2 = 'i';
         break;
      case 8:
         var2 = 'l';
         break;
      case 9:
         var2 = 'd';
      }

      return var2;
   }
}
