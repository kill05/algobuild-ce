package com.github.kill05.algobuildce.package_a.d;

import com.github.kill05.algobuildce.package_a.e.CharArrayFactory;

public final class e extends CharArrayFactory {
   @Override
   protected final int getArrayLength() {
      return 19;
   }

   @Override
   protected final char getCharAt(int var1) {
      char var2 = 0;
      switch(var1) {
      case 0:
         var2 = 'B';
         break;
      case 1:
      case 2:
      case 5:
      case 10:
         var2 = 'o';
         break;
      case 3:
         var2 = 't';
         break;
      case 4:
         var2 = 'M';
         break;
      case 6:
         var2 = 'd';
         break;
      case 7:
      case 12:
         var2 = 'e';
         break;
      case 8:
      case 15:
         var2 = 'l';
         break;
      case 9:
         var2 = 'C';
         break;
      case 11:
         var2 = 'r';
         break;
      case 13:
         var2 = '.';
         break;
      case 14:
         var2 = 'c';
         break;
      case 16:
         var2 = 'a';
         break;
      case 17:
      case 18:
         var2 = 's';
      }

      return var2;
   }
}
