package package_b.a;

import java.io.IOException;
import java.io.Writer;

public final class g {
   private boolean a = false;
   private char b = 'i';
   private final c[] c = new c[200];
   private int d = 0;
   private Writer e;

   public g(Writer var1) {
      this.e = var1;
   }

   private g b(String var1) {
      if (var1 == null) {
         throw new b("Null pointer");
      } else if (this.b != 'o' && this.b != 'a') {
         throw new b("Value out of sequence.");
      } else {
         try {
            if (this.a && this.b == 'a') {
               this.e.write(44);
            }

            this.e.write(var1);
         } catch (IOException var2) {
            throw new b(var2);
         }

         if (this.b == 'o') {
            this.b = 'k';
         }

         this.a = true;
         return this;
      }
   }

   private g a(char var1, char var2) {
      if (this.b != 'k') {
         throw new b("Misplaced endObject.");
      } else {
         byte var5 = 107;
         if (this.d <= 0) {
            throw new b("Nesting error.");
         } else if ((this.c[this.d - 1] == null ? 97 : 107) != var5) {
            throw new b("Nesting error.");
         } else {
            --this.d;
            this.b = (char)(this.d == 0 ? 100 : (this.c[this.d - 1] == null ? 97 : 107));

            try {
               this.e.write(125);
            } catch (IOException var4) {
               throw new b(var4);
            }

            this.a = true;
            return this;
         }
      }
   }

   public final g a() {
      return this.a('k', '}');
   }

   public final g a(String var1) {
      if (var1 == null) {
         throw new b("Null key.");
      } else if (this.b == 'k') {
         try {
            this.c[this.d - 1].c(var1, Boolean.TRUE);
            if (this.a) {
               this.e.write(44);
            }

            this.e.write(package_b.a.c.g(var1));
            this.e.write(58);
            this.a = false;
            this.b = 'o';
            return this;
         } catch (IOException var2) {
            throw new b(var2);
         }
      } else {
         throw new b("Misplaced key.");
      }
   }

   public final g b() {
      if (this.b == 'i') {
         this.b = 'o';
      }

      if (this.b != 'o' && this.b != 'a') {
         throw new b("Misplaced object.");
      } else {
         this.b("{");
         c var2 = new c();
         if (this.d >= 200) {
            throw new b("Nesting too deep.");
         } else {
            this.c[this.d] = var2;
            this.b = 'k';
            ++this.d;
            this.a = false;
            return this;
         }
      }
   }

   public final g a(Object var1) {
      return this.b(package_b.a.c.a(var1));
   }
}
