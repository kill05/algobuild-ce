package com.github.kill05.algobuildce.package_a.h;

import com.github.kill05.algobuildce.package_a.charfactory.CharArrayFactory;

public final class UserNameCharArrayFactory extends CharArrayFactory {
   @Override
   protected final int getArrayLength() {
      return 9;
   }

   @Override
   protected final char getCharAt(int var1) {
      char var2 = 0;
      switch(var1) {
      case 0:
         var2 = 'u';
         break;
      case 1:
         var2 = 's';
         break;
      case 2:
      case 8:
         var2 = 'e';
         break;
      case 3:
         var2 = 'r';
         break;
      case 4:
         var2 = '.';
         break;
      case 5:
         var2 = 'n';
         break;
      case 6:
         var2 = 'a';
         break;
      case 7:
         var2 = 'm';
      }

      return var2;
   }
}
