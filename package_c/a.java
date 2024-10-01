package package_c;

import java.util.HashMap;
import java.util.Map;

public final class a {
   private String a = "";
   private int b = -1;
   private char c = 0;
   private String d = "";
   private int e = -1;
   private int f = -1;
   private c g;
   private l h;
   private Map i;
   // $FF: synthetic field
   private static int[] j;
   // $FF: synthetic field
   private static int[] k;

   private l a(String var1, int var2, int var3) {
      if (this.i.containsKey(var1)) {
         package_c.f var4;
         if ((var4 = (package_c.f)this.i.get(var1)) instanceof d && var3 < 0) {
            return ((d)var4).a(var2);
         } else if (var4 instanceof e) {
            return ((e)var4).a(var2, var3);
         } else {
            throw new ABAssignException(-1, this.a(), 105, var1);
         }
      } else {
         throw new ABAssignException(-1, this.a(), 106, var1);
      }
   }

   public a() {
      this.g = c.c.a;
   }

   public final l a(String var1, Map var2) {
      if (var2 != null) {
         this.i = var2;
      }

      if (this.i == null) {
         this.i = new HashMap();
      }

      this.a = var1;
      this.h = null;
      this.b = 0;
      if (this.b < this.a.length()) {
         this.c = this.a.charAt(this.b);
      } else {
         this.c = 0;
      }

      this.d();
      if (this.g == c.c.b && this.c == 0) {
         throw new ABAssignException(-1, this.a(), 4);
      } else {
         this.h = this.e();
         if (this.g == c.c.b && this.d.length() <= 0) {
            return this.h;
         } else if (this.g == c.c.b) {
            throw new ABAssignException(-1, this.a(), 101, this.d);
         } else {
            throw new ABAssignException(-1, this.a(), 5, this.d);
         }
      }
   }

   private int a() {
      return this.b - this.d.length() + 1;
   }

   private static boolean a(char var0) {
      return var0 == ' ' || var0 == '\t';
   }

   private static boolean b(char var0) {
      return "&|<>=+/*%^!,()[]".indexOf(var0) != -1;
   }

   private static boolean c(char var0) {
      var0 = Character.toUpperCase(var0);
      return "ABCDEFGHIJKLMNOPQRSTUVWXYZ_".indexOf(var0) != -1;
   }

   private static boolean d(char var0) {
      return "0123456789.".indexOf(var0) != -1;
   }

   private static boolean e(char var0) {
      return "0123456789".indexOf(var0) != -1;
   }

   private static boolean a(String var0) {
      if ((var0 = var0.toUpperCase()).equals("EULER")) {
         return false;
      } else {
         return !var0.equals("PI");
      }
   }

   private void b() {
      ++this.b;
      if (this.b < this.a.length()) {
         this.c = this.a.charAt(this.b);
      } else {
         this.c = 0;
      }
   }

   private char c() {
      char var1 = 0;
      if (this.b + 1 < this.a.length()) {
         var1 = this.a.charAt(this.b + 1);
      }

      return var1;
   }

   private void d() {
      this.g = c.c.a;
      this.d = "";

      while(a(this.c)) {
         this.b();
      }

      if (this.c == 0) {
         this.g = c.c.b;
      } else if (this.c == '+') {
         this.g = c.c.b;
         this.d = this.d + this.c;
         this.b();
      } else if (this.c == '-') {
         this.g = c.c.b;
         this.d = this.d + this.c;
         this.b();
      } else if (this.c == '*') {
         this.g = c.c.b;
         this.d = this.d + this.c;
         this.b();
      } else if (this.c == '/') {
         this.g = c.c.b;
         this.d = this.d + this.c;
         this.b();
      } else if (this.c == '!') {
         this.g = c.c.b;
         this.d = this.d + this.c;
         this.b();
         if (this.c == '=') {
            this.d = this.d + this.c;
            this.b();
         }

      } else if (this.c == '=') {
         this.g = c.c.b;
         this.d = this.d + this.c;
         this.b();
         if (this.c == '=') {
            this.d = this.d + this.c;
            this.b();
         }

      } else if (this.c == '&') {
         this.g = c.c.b;
         this.d = this.d + this.c;
         this.b();
         if (this.c == '&') {
            this.d = this.d + this.c;
            this.b();
         }

      } else if (this.c == '|') {
         this.g = c.c.b;
         this.d = this.d + this.c;
         this.b();
         if (this.c == '|') {
            this.d = this.d + this.c;
            this.b();
         }

      } else if (this.c != '(' && this.c != ')') {
         if (this.c != '[' && this.c != ']') {
            if (b(this.c)) {
               this.g = c.c.b;

               while(b(this.c)) {
                  this.d = this.d + this.c;
                  this.b();
               }

            } else if (this.c == '"') {
               this.g = c.c.h;
               this.b();

               while(this.c != '"' && this.c != 0) {
                  this.d = this.d + this.c;
                  this.b();
                  if (this.c == '\\') {
                     this.b();
                     if (this.c == 'n') {
                        this.d = this.d + '\n';
                        this.b();
                     } else if (this.c != 0) {
                        this.d = this.d + this.c;
                        this.b();
                     }
                  }
               }

               if (this.c == '"') {
                  this.b();
               } else {
                  this.g = c.c.m;
               }
            } else if (d(this.c)) {
               if (e(this.c)) {
                  this.g = c.c.c;
                  if (this.c == '0') {
                     this.g = c.c.d;
                     this.d = this.d + this.c;
                     this.b();
                     if (this.c != 'x' && this.c != 'X') {
                        if (this.c == 'b' || this.c == 'B') {
                           this.g = c.c.f;
                           this.d = "";
                           this.b();
                        }
                     } else {
                        this.g = c.c.e;
                        this.d = "";
                        this.b();
                     }
                  }
               } else {
                  this.g = c.c.g;
               }

               while(true) {
                  if (this.g != c.c.c && this.g != c.c.g || !e(this.c)) {
                     label290: {
                        char var1;
                        if (this.g == c.c.d) {
                           var1 = this.c;
                           if ("01234567".indexOf(var1) != -1) {
                              break label290;
                           }
                        }

                        if (this.g == c.c.e) {
                           var1 = this.c;
                           if ("0123456789abcdefABCDEF".indexOf(var1) != -1) {
                              break label290;
                           }
                        }

                        if (this.g != c.c.f) {
                           break;
                        }

                        var1 = this.c;
                        if ("01".indexOf(var1) == -1) {
                           break;
                        }
                     }
                  }

                  this.d = this.d + this.c;
                  this.b();
               }

               while(d(this.c)) {
                  this.g = c.c.g;
                  this.d = this.d + this.c;
                  this.b();
               }

               if (this.c == 'e' || this.c == 'E') {
                  this.g = c.c.g;
                  this.d = this.d + this.c;
                  this.b();
                  if (this.c == '+' || this.c == '-') {
                     this.d = this.d + this.c;
                     this.b();
                  }

                  while(e(this.c)) {
                     this.d = this.d + this.c;
                     this.b();
                  }
               }

            } else if (c(this.c)) {
               while(c(this.c) || e(this.c)) {
                  this.d = this.d + this.c;
                  this.b();
               }

               while(a(this.c)) {
                  this.b();
               }

               if (this.c == '(') {
                  this.g = c.c.j;
               } else if (this.c == '[') {
                  this.g = c.c.k;
               } else {
                  this.g = c.c.i;
               }
            } else {
               this.g = c.c.m;

               while(this.c != 0) {
                  this.d = this.d + this.c;
                  this.b();
               }

               throw new ABAssignException(-1, this.a(), 1, this.d);
            }
         } else {
            this.g = c.c.b;
            this.d = this.d + this.c;
            this.b();
         }
      } else {
         this.g = c.c.b;
         this.d = this.d + this.c;
         this.b();
      }
   }

   private l e() {
      String var1;
      if (this.g == c.c.i) {
         while(true) {
            if (!a(this.c)) {
               var1 = this.d;
               if (this.c == '=' && this.c() != '=') {
                  this.d();
                  this.d();
                  l var8 = this.f();
                  if (a(var1)) {
                     if (this.i.containsKey(var1)) {
                        package_c.f var6;
                        if ((var6 = (package_c.f)this.i.get(var1)) instanceof m) {
                           ((m)var6).a(var8);
                        }
                     } else {
                        this.i.put(var1, new m(var8));
                     }

                     return var8;
                  }

                  throw new ABAssignException(-1, this.a(), 220, var1);
               }
               break;
            }

            this.b();
         }
      } else if (this.g == c.c.k) {
         var1 = this.d;
         int var2 = -1;
         int var3 = -1;
         this.d();
         l var4;
         j var9;
         if (this.g == c.c.b && this.d.equals("[")) {
            this.d();
            var3 = -1;
            var4 = this.f();
            if (this.g != c.c.b || !this.d.equals("]")) {
               throw new ABAssignException(-1, this.a(), 3);
            }

            if (!(var4 instanceof j)) {
               throw new ABAssignException(-1, this.a(), 3);
            }

            var2 = (int)(var9 = (j)var4).b;
         }

         while(a(this.c)) {
            this.b();
         }

         if (this.c == '[') {
            this.d();
            this.d();
            var4 = this.f();
            if (this.g != c.c.b || !this.d.equals("]")) {
               throw new ABAssignException(-1, this.a(), 3);
            }

            if (!(var4 instanceof j)) {
               throw new ABAssignException(-1, this.a(), 108);
            }

            var3 = (int)(var9 = (j)var4).b;

            while(a(this.c)) {
               this.b();
            }
         }

         if (this.c == '=' && this.c() != '=') {
            this.d();
            this.d();
            var4 = this.f();
            if (a(var1)) {
               if (this.i.containsKey(var1)) {
                  package_c.f var7;
                  if ((var7 = (package_c.f)this.i.get(var1)) instanceof d) {
                     ((d)var7).a(var4, var2);
                  } else {
                     if (!(var7 instanceof e)) {
                        throw new ABAssignException(-1, this.a(), 105, var1);
                     }

                     ((e)var7).a(var4, var2, var3);
                  }
               } else if (var3 == -1) {
                  d var10;
                  (var10 = new d()).a(var4, var2);
                  this.i.put(var1, var10);
               } else {
                  e var11;
                  (var11 = new e()).a(var4, var2, var3);
                  this.i.put(var1, var11);
               }

               return var4;
            }

            throw new ABAssignException(-1, this.a(), 220, var1);
         }

         this.d = var1;
         this.e = var2;
         this.f = var3;
         this.g = c.c.l;
      }

      return this.f();
   }

   private l f() {
      Object var2 = this.g();

      while(true) {
         b var1;
         while((var1 = b(this.d)) == c.b.c || var1 == c.b.d || var1 == c.b.e || var1 == c.b.f || var1 == c.b.g || var1 == c.b.h) {
            this.d();
            l var3 = this.g();
            if (var1 == c.b.c || var1 == c.b.d) {
               h var10000;
               h var6;
               boolean var7;
               switch(o()[var1.ordinal()]) {
               case 3:
                  if (!(var2 instanceof h)) {
                     throw new ABAssignException(108, ((l)var2).toString());
                  }

                  if (!(var6 = (h)var2).a) {
                     var10000 = new h(false);
                  } else {
                     if (!(var3 instanceof h)) {
                        throw new ABAssignException(108, var3.toString());
                     }

                     var7 = (var6 = (h)var3).a;
                     var10000 = new h(var7);
                  }
                  break;
               case 4:
                  if (!(var2 instanceof h)) {
                     throw new ABAssignException(108, ((l)var2).toString());
                  }

                  boolean var5;
                  if (var5 = (var6 = (h)var2).a) {
                     var10000 = new h(true);
                  } else {
                     if (!(var3 instanceof h)) {
                        throw new ABAssignException(108, var3.toString());
                     }

                     var7 = (var6 = (h)var3).a;
                     var10000 = new h(var5 || var7);
                  }
                  break;
               default:
                  throw new ABAssignException(-1, this.a(), 104);
               }

               var2 = var10000;
            } else {
               var2 = this.a(var1, (l)var2, var3);
            }
         }

         return (l)var2;
      }
   }

   private l g() {
      l var2 = this.h();

      for(b var1 = b(this.d); var1 == c.b.i || var1 == c.b.j || var1 == c.b.k || var1 == c.b.l || var1 == c.b.m || var1 == c.b.n; var1 = b(this.d)) {
         this.d();
         var2 = this.a(var1, var2, this.h());
      }

      return var2;
   }

   private l h() {
      l var2 = this.i();

      for(b var1 = b(this.d); var1 == c.b.o || var1 == c.b.p; var1 = b(this.d)) {
         this.d();
         var2 = this.a(var1, var2, this.i());
      }

      return var2;
   }

   private l i() {
      l var2 = this.j();

      for(b var1 = b(this.d); var1 == c.b.r || var1 == c.b.s || var1 == c.b.t || var1 == c.b.u; var1 = b(this.d)) {
         this.d();
         var2 = this.a(var1, var2, this.j());
      }

      return var2;
   }

   private l j() {
      l var2 = this.k();

      for(b var1 = b(this.d); var1 == c.b.v; var1 = b(this.d)) {
         this.d();
         var2 = this.a(var1, var2, this.k());
      }

      return var2;
   }

   private l k() {
      b var2 = b(this.d);
      Object var3;
      l var4;
      if (this.g == c.c.b && var2 == c.b.q) {
         this.d();
         if (!((var4 = this.l()) instanceof h)) {
            throw new ABAssignException(-1, this.a(), 108);
         }

         var3 = new h(!((h)var4).a);
      } else if (this.g == c.c.b && var2 == c.b.p) {
         this.d();
         if ((var4 = this.l()) instanceof j) {
            var3 = new j(-((j)var4).b);
         } else {
            if (!(var4 instanceof i)) {
               throw new ABAssignException(-1, this.a(), 108);
            }

            var3 = new i(-((i)var4).a);
         }
      } else {
         var3 = this.l();
      }

      var3 = var3;

      for(b var1 = b(this.d); var1 == c.b.w; var1 = b(this.d)) {
         this.d();
         var3 = this.a(var1, (l)var3, new i(0.0D));
      }

      return (l)var3;
   }

   private l l() {
      String var1;
      l var5;
      if (this.g == c.c.j) {
         var1 = this.d;
         this.d();
         var5 = this.c(var1);
      } else if (this.g != c.c.k) {
         var5 = this.m();
      } else {
         var1 = this.d;
         int var2 = -1;
         int var3 = -1;
         this.d();
         if (this.g == c.c.b) {
            l var4;
            j var6;
            if (this.d.equals("[")) {
               this.d();
               var3 = -1;
               var4 = this.f();
               if (this.g != c.c.b || !this.d.equals("]")) {
                  throw new ABAssignException(-1, this.a(), 3);
               }

               if (!(var4 instanceof j)) {
                  throw new ABAssignException(-1, this.a(), 108);
               }

               var2 = (int)(var6 = (j)var4).b;
            }

            while(a(this.c)) {
               this.b();
            }

            if (this.c == '[') {
               this.d();
               this.d();
               var4 = this.f();
               if (this.g != c.c.b || !this.d.equals("]")) {
                  throw new ABAssignException(-1, this.a(), 3);
               }

               if (!(var4 instanceof j)) {
                  throw new ABAssignException(-1, this.a(), 108);
               }

               var3 = (int)(var6 = (j)var4).b;
            }
         }

         var5 = this.a(var1, var2, var3);
         this.d();
      }

      return var5;
   }

   private l m() {
      if (this.g == c.c.b && this.d.equals("(")) {
         this.d();
         l var1 = this.f();
         if (this.g == c.c.b && this.d.equals(")")) {
            this.d();
            return var1;
         } else {
            throw new ABAssignException(-1, this.a(), 3);
         }
      } else {
         Object var2;
         switch(n()[this.g.ordinal()]) {
         case 3:
            var2 = new j((long)Integer.parseInt(this.d));
            this.d();
            break;
         case 4:
            var2 = new j((long)Integer.parseInt(this.d, 8));
            this.d();
            break;
         case 5:
            var2 = new j((long)Integer.parseInt(this.d, 16));
            this.d();
            break;
         case 6:
            var2 = new j((long)Integer.parseInt(this.d, 2));
            this.d();
            break;
         case 7:
            var2 = new i(Double.parseDouble(this.d));
            this.d();
            break;
         case 8:
            var2 = new k(this.d);
            this.d();
            break;
         case 9:
            String var3 = this.d;
            Object var10000;
            if (var3.equals("EULER")) {
               var10000 = new i(2.718281828459045D);
            } else if (var3.equals("PI")) {
               var10000 = new i(3.141592653589793D);
            } else if (var3.equals("INFINITY")) {
               var10000 = new i(Double.POSITIVE_INFINITY);
            } else if (var3.equals("NaN")) {
               var10000 = new i(Double.NaN);
            } else if (!var3.equals("TRUE") && !var3.equals("true")) {
               if (!var3.equals("FALSE") && !var3.equals("false")) {
                  if (!this.i.containsKey(var3)) {
                     throw new ABAssignException(-1, this.a(), 103, var3);
                  }

                  package_c.f var4;
                  if (!((var4 = (package_c.f)this.i.get(var3)) instanceof m)) {
                     throw new ABAssignException(-1, this.a(), 105, var3);
                  }

                  var10000 = ((m)var4).d();
               } else {
                  var10000 = new h(false);
               }
            } else {
               var10000 = new h(true);
            }

            var2 = var10000;
            this.d();
            break;
         case 10:
         case 11:
         default:
            if (this.d.length() == 0) {
               throw new ABAssignException(-1, this.a(), 6);
            }

            throw new ABAssignException(-1, this.a(), 7);
         case 12:
            var2 = this.a(this.d, this.e, this.f);
            this.d();
         }

         return (l)var2;
      }
   }

   private static b b(String var0) {
      if (var0.equals("&&")) {
         return c.b.c;
      } else if (var0.equals("||")) {
         return c.b.d;
      } else if (var0.equals("&")) {
         return c.b.e;
      } else if (var0.equals("|")) {
         return c.b.f;
      } else if (var0.equals("<<")) {
         return c.b.g;
      } else if (var0.equals(">>")) {
         return c.b.h;
      } else if (var0.equals("=")) {
         return c.b.b;
      } else if (var0.equals("==")) {
         return c.b.i;
      } else if (var0.equals("!=")) {
         return c.b.j;
      } else if (var0.equals("<")) {
         return c.b.k;
      } else if (var0.equals(">")) {
         return c.b.l;
      } else if (var0.equals("<=")) {
         return c.b.m;
      } else if (var0.equals(">=")) {
         return c.b.n;
      } else if (var0.equals("+")) {
         return c.b.o;
      } else if (var0.equals("-")) {
         return c.b.p;
      } else if (var0.equals("*")) {
         return c.b.r;
      } else if (var0.equals("/")) {
         return c.b.s;
      } else if (var0.equals("%")) {
         return c.b.t;
      } else if (var0.equals("^")) {
         return c.b.v;
      } else {
         return var0.equals("!") ? c.b.q : c.b.a;
      }
   }

   private l a(b var1, l var2, l var3) {
      double var4;
      double var6;
      i var12;
      j var13;
      long var14;
      long var15;
      switch(o()[var1.ordinal()]) {
      case 5:
         if (var2 instanceof j && var3 instanceof j) {
            var14 = (var13 = (j)var2).b;
            var15 = (var13 = (j)var3).b;
            return new j(var14 & var15);
         } else {
            if (!(var2 instanceof j)) {
               throw new ABAssignException(108, var2.toString());
            }

            throw new ABAssignException(108, var3.toString());
         }
      case 6:
         if (var2 instanceof j && var3 instanceof j) {
            var14 = (var13 = (j)var2).b;
            var15 = (var13 = (j)var3).b;
            return new j(var14 | var15);
         } else {
            if (!(var2 instanceof j)) {
               throw new ABAssignException(108, var2.toString());
            }

            throw new ABAssignException(108, var3.toString());
         }
      case 7:
         if (var2 instanceof j && var3 instanceof j) {
            var14 = (var13 = (j)var2).b;
            var15 = (var13 = (j)var3).b;
            return new j(var14 << (int)var15);
         } else {
            if (!(var2 instanceof j)) {
               throw new ABAssignException(108, var2.toString());
            }

            throw new ABAssignException(108, var3.toString());
         }
      case 8:
         if (var2 instanceof j && var3 instanceof j) {
            var14 = (var13 = (j)var2).b;
            var15 = (var13 = (j)var3).b;
            return new j(var14 >> (int)var15);
         } else {
            if (!(var2 instanceof j)) {
               throw new ABAssignException(108, var2.toString());
            }

            throw new ABAssignException(108, var3.toString());
         }
      case 9:
         return new h(var2.a(var3));
      case 10:
         return new h(!var2.a(var3));
      case 11:
         return new h(var2.b(var3));
      case 12:
         return new h(var3.b(var2));
      case 13:
         return new h(var2.b(var3) || var2.a(var3));
      case 14:
         return new h(var3.b(var2) || var2.a(var3));
      case 15:
         if (var2 instanceof j && var3 instanceof j) {
            var14 = (var13 = (j)var2).b;
            var15 = (var13 = (j)var3).b;
            return new j(var14 + var15);
         } else if (var2 instanceof i && var3 instanceof i) {
            var4 = (var12 = (i)var2).a;
            var6 = (var12 = (i)var3).a;
            return new i(var4 + var6);
         } else {
            if (var2 instanceof k && var3 instanceof k) {
               k var17;
               String var16 = (var17 = (k)var2).a;
               String var5 = (var17 = (k)var3).a;
               return new k(var16 + var5);
            }

            throw new ABAssignException(108, var2.toString() + " OR " + var3.toString());
         }
      case 16:
         if (var2 instanceof j && var3 instanceof j) {
            var14 = (var13 = (j)var2).b;
            var15 = (var13 = (j)var3).b;
            return new j(var14 - var15);
         } else {
            if (!(var2 instanceof i) && !(var3 instanceof i)) {
               throw new ABAssignException(108, var2.toString() + " OR " + var3.toString());
            }

            var4 = (var12 = (i)var2).a;
            var6 = (var12 = (i)var3).a;
            return new i(var4 - var6);
         }
      case 17:
      default:
         throw new ABAssignException(-1, this.a(), 104);
      case 18:
         if (var2 instanceof j && var3 instanceof j) {
            var14 = (var13 = (j)var2).b;
            var15 = (var13 = (j)var3).b;
            return new j(var14 * var15);
         } else {
            if (!(var2 instanceof i) && !(var3 instanceof i)) {
               throw new ABAssignException(108, var2.toString() + " OR " + var3.toString());
            }

            var4 = (var12 = (i)var2).a;
            var6 = (var12 = (i)var3).a;
            return new i(var4 * var6);
         }
      case 19:
         if (var2 instanceof j && var3 instanceof j) {
            var14 = (var13 = (j)var2).b;
            var15 = (var13 = (j)var3).b;
            return new j(var14 / var15);
         } else {
            if (!(var2 instanceof i) && !(var3 instanceof i)) {
               throw new ABAssignException(108, var2.toString() + " OR " + var3.toString());
            }

            var4 = (var12 = (i)var2).a;
            var6 = (var12 = (i)var3).a;
            return new i(var4 / var6);
         }
      case 20:
         if (var2 instanceof j && var3 instanceof j) {
            var14 = (var13 = (j)var2).b;
            var15 = (var13 = (j)var3).b;
            return new j(var14 % var15);
         } else {
            if (var2 instanceof i && var3 instanceof i) {
               var4 = (var12 = (i)var2).a;
               var6 = (var12 = (i)var3).a;
               double var8 = Math.floor(var4);
               double var10 = Math.floor(var6);
               if (var4 == var8 && var6 == var10) {
                  return new j(Math.round(var4) % Math.round(var6));
               }

               throw new ABAssignException(108, var3.toString());
            }

            throw new ABAssignException(108, var2.toString());
         }
      case 21:
         if (var2 instanceof j && var3 instanceof j) {
            var14 = (var13 = (j)var2).b;
            var15 = (var13 = (j)var3).b;
            return new j(var14 ^ var15);
         } else {
            if (!(var2 instanceof j)) {
               throw new ABAssignException(108, var2.toString());
            }

            throw new ABAssignException(108, var3.toString());
         }
      case 22:
         if (var2 instanceof j && var3 instanceof j) {
            var14 = (var13 = (j)var2).b;
            var15 = (var13 = (j)var3).b;
            return new j(var14 ^ var15);
         } else {
            if (!(var2 instanceof i) && !(var3 instanceof i)) {
               throw new ABAssignException(108, var2.toString() + " OR " + var2.toString());
            }

            var4 = (var12 = (i)var2).a;
            var6 = (var12 = (i)var3).a;
            return new i(Math.pow(var4, var6));
         }
      case 23:
         if (var2 instanceof i) {
            var4 = (var12 = (i)var2).a;
            return new i(a(var4));
         } else {
            throw new ABAssignException(108, var2.toString());
         }
      }
   }

   private l c(String var1) {
      i var2;
      double var4;
      l var17;
      if (var1.equals("abs")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i(Math.abs(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("ceil")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i(Math.ceil(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("floor")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i(Math.floor(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("round")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i((double)Math.round(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("exp")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i(Math.exp(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("sqrt")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i(Math.sqrt(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("ln")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i(Math.log(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("log10")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i(Math.log10(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("sin")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i(Math.sin(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("cos")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i(Math.cos(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("tan")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i(Math.tan(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("cotan")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i(1.0D / Math.tan(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("asin")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i(Math.asin(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("acos")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i(Math.acos(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("atan")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i(Math.atan(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("acotan")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i(1.5707963267948966D - Math.atan(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("sinh")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i(Math.sinh(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("cosh")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i(Math.cosh(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("tanh")) {
         if ((var17 = this.m()) instanceof i) {
            var4 = (var2 = (i)var17).a;
            return new i(Math.tanh(var4));
         } else {
            throw new ABAssignException(108, var17.toString());
         }
      } else if (var1.equals("random")) {
         if (this.g == c.c.b && this.d.equals("(")) {
            this.d();
            if (this.g != c.c.b || !this.d.equals(")")) {
               throw new ABAssignException(-1, this.a(), 3);
            }

            this.d();
         }

         return new i(Math.random());
      } else if (var1.equals("strlen")) {
         if ((var17 = this.m()) instanceof k) {
            return new j((long)((k)var17).a.length());
         } else {
            throw new ABAssignException(-1, this.a(), 108, var17.toString());
         }
      } else {
         l[] var3;
         j var14;
         k var18;
         int var21;
         String var23;
         if (var1.equals("strchar")) {
            if ((var3 = this.a((int)2))[0] instanceof k && var3[1] instanceof j) {
               var23 = (var18 = (k)var3[0]).a;
               var21 = (int)(var14 = (j)var3[1]).b;
               return new k(var23.substring(var21, var21 + 1));
            } else if (var3[0] != null && var3[1] != null) {
               throw new ABAssignException(-1, this.a(), 108, var3[0].toString() + "," + var3[1].toString());
            } else {
               throw new ABAssignException(-1, this.a(), 110);
            }
         } else {
            int var13;
            if (var1.equals("substr")) {
               if ((var3 = this.a((int)3))[0] instanceof k && var3[1] instanceof j && var3[2] instanceof j) {
                  var23 = (var18 = (k)var3[0]).a;
                  var21 = (int)(var14 = (j)var3[1]).b;
                  var13 = (int)(var14 = (j)var3[2]).b;
                  return new k(var23.substring(var21, var13));
               } else if (var3[0] != null && var3[1] != null && var3[2] != null) {
                  throw new ABAssignException(-1, this.a(), 108, var3[0].toString() + "," + var3[1].toString() + "," + var3[2].toString());
               } else {
                  throw new ABAssignException(-1, this.a(), 110);
               }
            } else if (var1.equals("strpos")) {
               if ((var3 = this.a((int)2))[0] instanceof k && var3[1] instanceof k) {
                  var23 = (var18 = (k)var3[0]).a;
                  String var22 = (var18 = (k)var3[1]).a;
                  return new j((long)var23.indexOf(var22));
               } else if (var3[0] != null && var3[1] != null) {
                  throw new ABAssignException(-1, this.a(), 108, var3[0].toString() + "," + var3[1].toString());
               } else {
                  throw new ABAssignException(-1, this.a(), 110);
               }
            } else if (var1.equals("strupr")) {
               if ((var17 = this.m()) instanceof k) {
                  var23 = (var18 = (k)var17).a;
                  return new k(var23.toUpperCase());
               } else {
                  throw new ABAssignException(-1, this.a(), 108, var17.toString());
               }
            } else if (var1.equals("strlwr")) {
               if ((var17 = this.m()) instanceof k) {
                  var23 = (var18 = (k)var17).a;
                  return new k(var23.toLowerCase());
               } else {
                  throw new ABAssignException(-1, this.a(), 108, var17.toString());
               }
            } else if (var1.equals("trim")) {
               if ((var17 = this.m()) instanceof k) {
                  var23 = (var18 = (k)var17).a;
                  return new k(var23.trim());
               } else {
                  throw new ABAssignException(-1, this.a(), 108, var17.toString());
               }
            } else if (var1.equals("ctoi")) {
               if ((var17 = this.m()) instanceof k) {
                  if ((var23 = (var18 = (k)var17).a).length() > 0) {
                     return new j((long)var23.charAt(0));
                  } else {
                     throw new ABAssignException(-1, this.a(), 10);
                  }
               } else {
                  throw new ABAssignException(-1, this.a(), 108, var17.toString());
               }
            } else {
               int var19;
               if (var1.equals("itoc")) {
                  if ((var17 = this.m()) instanceof j) {
                     var19 = (int)(var14 = (j)var17).b;
                     return new k((char)var19);
                  } else {
                     throw new ABAssignException(-1, this.a(), 108, var17.toString());
                  }
               } else if (var1.equals("stoi")) {
                  if ((var17 = this.m()) instanceof k) {
                     var23 = (var18 = (k)var17).a.trim();

                     try {
                        return new j(Long.parseLong(var23));
                     } catch (NumberFormatException var10) {
                        throw new ABAssignException(-1, this.a(), 108, var23);
                     }
                  } else {
                     throw new ABAssignException(-1, this.a(), 10, var17.toString());
                  }
               } else {
                  long var24;
                  if (var1.equals("itos")) {
                     if ((var17 = this.m()) instanceof j) {
                        var24 = (var14 = (j)var17).b;
                        return new k(Long.toString(var24));
                     } else {
                        throw new ABAssignException(-1, this.a(), 108, var17.toString());
                     }
                  } else if (var1.equals("sbasetoi")) {
                     if ((var3 = this.a((int)2))[0] instanceof k && var3[1] instanceof j) {
                        var23 = (var18 = (k)var3[0]).a;
                        var21 = (int)(var14 = (j)var3[1]).b;

                        try {
                           return new j(Long.parseLong(var23, var21));
                        } catch (NumberFormatException var11) {
                           throw new ABAssignException(-1, this.a(), 108, var23);
                        }
                     } else if (var3[0] != null && var3[1] != null) {
                        throw new ABAssignException(-1, this.a(), 108, var3[0].toString() + "," + var3[1].toString());
                     } else {
                        throw new ABAssignException(-1, this.a(), 110);
                     }
                  } else if (var1.equals("ibasetos")) {
                     if ((var3 = this.a((int)2))[0] instanceof j && var3[1] instanceof j) {
                        var24 = (var14 = (j)var3[0]).b;
                        var13 = (int)(var14 = (j)var3[1]).b;
                        return new k(Long.toString(var24, var13));
                     } else if (var3[0] != null && var3[1] != null) {
                        throw new ABAssignException(-1, this.a(), 108, var3[0].toString() + "," + var3[1].toString());
                     } else {
                        throw new ABAssignException(-1, this.a(), 110);
                     }
                  } else if (var1.equals("iformats")) {
                     if ((var3 = this.a((int)2))[0] instanceof j && var3[1] instanceof j) {
                        var24 = (var14 = (j)var3[0]).b;
                        var13 = (int)(var14 = (j)var3[1]).b;
                        String var20;
                        if ((var20 = Long.toString(var24)).length() >= var13) {
                           return new k(var20);
                        } else {
                           StringBuilder var25 = new StringBuilder(var13);

                           for(int var9 = var20.length(); var9 < var13; ++var9) {
                              var25.append(' ');
                           }

                           var25.append(var20);
                           return new k(var25.toString());
                        }
                     } else if (var3[0] != null && var3[1] != null) {
                        throw new ABAssignException(-1, this.a(), 108, var3[0].toString() + "," + var3[1].toString());
                     } else {
                        throw new ABAssignException(-1, this.a(), 110);
                     }
                  } else if (!var1.equals("dformats")) {
                     if (var1.equals("stod") && (var17 = this.m()) instanceof k) {
                        var23 = (var18 = (k)var17).a;

                        try {
                           return new i(Double.parseDouble(var23));
                        } catch (NumberFormatException var12) {
                           throw new ABAssignException(-1, this.a(), 108, var23);
                        }
                     } else if (var1.equals("dtos")) {
                        if ((var17 = this.m()) instanceof i) {
                           var4 = (var2 = (i)var17).a;
                           return new k(Double.toString(var4));
                        } else {
                           throw new ABAssignException(-1, this.a(), 108, var17.toString());
                        }
                     } else if (var1.equals("dtoi")) {
                        if ((var17 = this.m()) instanceof i) {
                           var4 = (var2 = (i)var17).a;
                           return new j((long)((int)var4));
                        } else {
                           throw new ABAssignException(-1, this.a(), 108, var17.toString());
                        }
                     } else if (var1.equals("type")) {
                        var17 = this.m();
                        return new k(var17.b());
                     } else {
                        throw new ABAssignException(-1, this.a(), 102, var1);
                     }
                  } else if ((var3 = this.a((int)3))[0] instanceof i && var3[1] instanceof j && var3[2] instanceof j) {
                     var4 = (var2 = (i)var3[0]).a;
                     var13 = (int)(var14 = (j)var3[1]).b;
                     int var15 = (int)(var14 = (j)var3[2]).b;
                     double var8 = Math.pow(10.0D, (double)var15);
                     if (var15 <= 0) {
                        var8 = 1.0D;
                     }

                     System.out.println("v prima " + var4);
                     var4 = (double)Math.round(var4 * var8) / var8;
                     System.out.println("v dopo " + var4);
                     String var16;
                     var19 = (var16 = Double.toString(var4)).indexOf(46) + 1;
                     var19 = var16.length() - var19;
                     StringBuilder var5 = new StringBuilder(var13);

                     for(int var6 = var16.length(); var6 < var13 - var15 + var19; ++var6) {
                        var5.append(' ');
                     }

                     var5.append(var16);

                     while(var19 < var15) {
                        var5.append('0');
                        ++var19;
                     }

                     return new k(var5.toString());
                  } else if (var3[0] != null && var3[1] != null && var3[2] != null) {
                     throw new ABAssignException(-1, this.a(), 108, var3[0] + "," + var3[1] + "," + var3[1]);
                  } else {
                     throw new ABAssignException(-1, this.a(), 110);
                  }
               }
            }
         }
      }
   }

   private l[] a(int var1) {
      if (this.g == c.c.b && this.d.equals("(")) {
         l[] var2 = new l[var1];
         int var3 = 0;
         boolean var4 = false;

         do {
            if (var4) {
               this.d();
               return var2;
            }

            this.d();
            var2[var3] = this.f();
            ++var3;
            if (this.g != c.c.b || !this.d.equals(")") && !this.d.equals(",")) {
               throw new ABAssignException(-1, this.a(), 3);
            }

            if (this.d.equals(")")) {
               var4 = true;
            }
         } while(!this.d.equals(",") || var3 < var1);

         throw new ABAssignException(-1, this.a(), 111, "TOO MANY ARGUMENTS");
      } else {
         return null;
      }
   }

   private static double a(double var0) {
      int var4 = (int)var0;
      if (var0 != (double)var4) {
         throw new ABAssignException(400, "factorial");
      } else {
         double var2 = (double)var4;
         --var4;

         while(var4 > 1) {
            var2 *= (double)var4;
            --var4;
         }

         if (var2 == 0.0D) {
            var2 = 1.0D;
         }

         return var2;
      }
   }

   // $FF: synthetic method
   private static int[] n() {
      int[] var10000 = j;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[c.c.a().length];

         try {
            var0[c.c.k.ordinal()] = 11;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[c.c.l.ordinal()] = 12;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[c.c.f.ordinal()] = 6;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[c.c.b.ordinal()] = 2;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[c.c.g.ordinal()] = 7;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[c.c.j.ordinal()] = 10;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[c.c.e.ordinal()] = 5;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[c.c.c.ordinal()] = 3;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[c.c.a.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[c.c.d.ordinal()] = 4;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[c.c.h.ordinal()] = 8;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[c.c.m.ordinal()] = 13;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[c.c.i.ordinal()] = 9;
         } catch (NoSuchFieldError var1) {
         }

         j = var0;
         return var0;
      }
   }

   // $FF: synthetic method
   private static int[] o() {
      int[] var10000 = k;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[c.b.a().length];

         try {
            var0[c.b.c.ordinal()] = 3;
         } catch (NoSuchFieldError var23) {
         }

         try {
            var0[c.b.b.ordinal()] = 2;
         } catch (NoSuchFieldError var22) {
         }

         try {
            var0[c.b.e.ordinal()] = 5;
         } catch (NoSuchFieldError var21) {
         }

         try {
            var0[c.b.f.ordinal()] = 6;
         } catch (NoSuchFieldError var20) {
         }

         try {
            var0[c.b.g.ordinal()] = 7;
         } catch (NoSuchFieldError var19) {
         }

         try {
            var0[c.b.h.ordinal()] = 8;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[c.b.s.ordinal()] = 19;
         } catch (NoSuchFieldError var17) {
         }

         try {
            var0[c.b.i.ordinal()] = 9;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[c.b.w.ordinal()] = 23;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[c.b.l.ordinal()] = 12;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[c.b.n.ordinal()] = 14;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[c.b.p.ordinal()] = 16;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[c.b.t.ordinal()] = 20;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[c.b.r.ordinal()] = 18;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[c.b.q.ordinal()] = 17;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[c.b.d.ordinal()] = 4;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[c.b.o.ordinal()] = 15;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[c.b.v.ordinal()] = 22;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[c.b.k.ordinal()] = 11;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[c.b.m.ordinal()] = 13;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[c.b.j.ordinal()] = 10;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[c.b.a.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[c.b.u.ordinal()] = 21;
         } catch (NoSuchFieldError var1) {
         }

         k = var0;
         return var0;
      }
   }
}
