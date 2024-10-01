package package_b.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public final class f {
   private long a;
   private boolean b;
   private long c;
   private long d;
   private char e;
   private Reader f;
   private boolean g;

   public f(Reader var1) {
      this.f = (Reader)(var1.markSupported() ? var1 : new BufferedReader(var1));
      this.b = false;
      this.g = false;
      this.e = 0;
      this.c = 0L;
      this.a = 1L;
      this.d = 1L;
   }

   public final void a() {
      if (!this.g && this.c > 0L) {
         --this.c;
         --this.a;
         this.g = true;
         this.b = false;
      } else {
         throw new b("Stepping back two steps is not supported");
      }
   }

   private char d() {
      int var1;
      if (this.g) {
         this.g = false;
         var1 = this.e;
      } else {
         try {
            var1 = this.f.read();
         } catch (IOException var2) {
            throw new b(var2);
         }

         if (var1 <= 0) {
            this.b = true;
            var1 = 0;
         }
      }

      ++this.c;
      if (this.e == '\r') {
         ++this.d;
         this.a = (long)(var1 == 10 ? 0 : 1);
      } else if (var1 == 10) {
         ++this.d;
         this.a = 0L;
      } else {
         ++this.a;
      }

      this.e = (char)var1;
      return this.e;
   }

   private String a(int var1) {
      char[] var4 = new char[4];

      for(int var2 = 0; var2 < 4; ++var2) {
         var4[var2] = this.d();
         if (this.b && !this.g) {
            throw this.a("Substring bounds error");
         }
      }

      return new String(var4);
   }

   public final char b() {
      char var1;
      while((var1 = this.d()) != 0 && var1 <= ' ') {
      }

      return var1;
   }

   public final Object c() {
      char var1;
      switch(var1 = this.b()) {
      case '"':
      case '\'':
         char var2 = var1;
         f var5 = this;
         StringBuilder var4 = new StringBuilder();

         while(true) {
            char var3;
            switch(var3 = var5.d()) {
            case '\u0000':
            case '\n':
            case '\r':
               throw var5.a("Unterminated string");
            case '\\':
               switch(var3 = var5.d()) {
               case '"':
               case '\'':
               case '/':
               case '\\':
                  var4.append(var3);
                  continue;
               case 'b':
                  var4.append('\b');
                  continue;
               case 'f':
                  var4.append('\f');
                  continue;
               case 'n':
                  var4.append('\n');
                  continue;
               case 'r':
                  var4.append('\r');
                  continue;
               case 't':
                  var4.append('\t');
                  continue;
               case 'u':
                  var4.append((char)Integer.parseInt(var5.a(4), 16));
                  continue;
               default:
                  throw var5.a("Illegal escape.");
               }
            default:
               if (var3 == var2) {
                  return var4.toString();
               }

               var4.append(var3);
            }
         }
      case '[':
         this.a();
         return new a(this);
      case '{':
         this.a();
         return new c(this);
      default:
         StringBuilder var7;
         for(var7 = new StringBuilder(); var1 >= ' ' && ",:]}/\\\"[{;=#".indexOf(var1) < 0; var1 = this.d()) {
            var7.append(var1);
         }

         this.a();
         String var6 = var7.toString().trim();
         if ("".equals(var6)) {
            throw this.a("Missing value");
         } else {
            return package_b.a.c.h(var6);
         }
      }
   }

   public final b a(String var1) {
      return new b(var1 + this.toString());
   }

   public final String toString() {
      return " at " + this.c + " [character " + this.a + " line " + this.d + "]";
   }
}
