package package_b.a;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class a implements Iterable {
   private final ArrayList a;

   public a() {
      this.a = new ArrayList();
   }

   public a(f var1) {
      this();
      if (var1.b() != '[') {
         throw var1.a("A JSONArray text must start with '['");
      } else if (var1.b() != ']') {
         var1.a();

         while(true) {
            if (var1.b() == ',') {
               var1.a();
               this.a.add(c.NULL);
            } else {
               var1.a();
               this.a.add(var1.c());
            }

            switch(var1.b()) {
            case ',':
               if (var1.b() == ']') {
                  return;
               }

               var1.a();
               break;
            case ']':
               return;
            default:
               throw var1.a("Expected a ',' or ']'");
            }
         }
      }
   }

   public a(Collection var1) {
      this.a = new ArrayList();
      if (var1 != null) {
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            this.a.add(c.b(var2.next()));
         }
      }

   }

   public a(Object var1) {
      this();
      if (!var1.getClass().isArray()) {
         throw new b("JSONArray initial value should be a string or collection or array.");
      } else {
         int var2 = Array.getLength(var1);

         for(int var3 = 0; var3 < var2; ++var3) {
            this.a(c.b(Array.get(var1, var3)));
         }

      }
   }

   @Override
   public final Iterator iterator() {
      return this.a.iterator();
   }

   public final Object a(int var1) {
      Object var10000 = var1 >= 0 && var1 < this.a.size() ? this.a.get(var1) : null;
      Object var2 = var10000;
      if (var10000 == null) {
         throw new b("JSONArray[" + var1 + "] not found.");
      } else {
         return var2;
      }
   }

   public final int b(int var1) {
      Object var2 = this.a(var1);

      try {
         return var2 instanceof Number ? ((Number)var2).intValue() : Integer.parseInt((String)var2);
      } catch (Exception var3) {
         throw new b("JSONArray[" + var1 + "] is not a number.");
      }
   }

   public final c c(int var1) {
      Object var2;
      if ((var2 = this.a(var1)) instanceof c) {
         return (c)var2;
      } else {
         throw new b("JSONArray[" + var1 + "] is not a JSONObject.");
      }
   }

   public final String d(int var1) {
      Object var2;
      if ((var2 = this.a(var1)) instanceof String) {
         return (String)var2;
      } else {
         throw new b("JSONArray[" + var1 + "] not a string.");
      }
   }

   public final int a() {
      return this.a.size();
   }

   public final a e(int var1) {
      this.a(new Integer(var1));
      return this;
   }

   public final a a(Object var1) {
      this.a.add(var1);
      return this;
   }

   public final String toString() {
      try {
         return this.f(0);
      } catch (Exception var1) {
         return null;
      }
   }

   private String f(int var1) {
      StringWriter var4;
      synchronized((var4 = new StringWriter()).getBuffer()) {
         return this.a(var4, 0, 0).toString();
      }
   }

   final Writer a(Writer var1, int var2, int var3) {
      try {
         boolean var4 = false;
         int var5 = this.a.size();
         var1.write(91);
         if (var5 == 1) {
            c.a(var1, this.a.get(0), var2, var3);
         } else if (var5 != 0) {
            int var6 = var3 + var2;

            for(int var7 = 0; var7 < var5; ++var7) {
               if (var4) {
                  var1.write(44);
               }

               if (var2 > 0) {
                  var1.write(10);
               }

               c.a(var1, var6);
               c.a(var1, this.a.get(var7), var2, var6);
               var4 = true;
            }

            if (var2 > 0) {
               var1.write(10);
            }

            c.a(var1, var3);
         }

         var1.write(93);
         return var1;
      } catch (IOException var8) {
         throw new b(var8);
      }
   }
}
