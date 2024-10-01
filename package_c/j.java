package package_c;

public final class j extends i {
   long b;

   public j(long var1) {
      this.b = var1;
      this.a = (double)var1;
   }

   public j() {
      this.b = 0L;
      this.a = 0.0D;
   }

   public final boolean a(l var1) {
      boolean var2 = false;
      if (var1 instanceof j) {
         long var3 = ((j)var1).b;
         var2 = this.b == var3;
      } else if (var1 instanceof i) {
         double var5 = ((i)var1).a;
         var2 = this.a == var5;
      }

      return var2;
   }

   public final boolean b(l var1) {
      boolean var2 = false;
      if (var1 instanceof j) {
         long var3 = ((j)var1).b;
         var2 = this.b < var3;
      } else if (var1 instanceof i) {
         double var5 = ((i)var1).a;
         var2 = this.a < var5;
      }

      return var2;
   }

   public final String toString() {
      return Long.toString(this.b);
   }

   public final String b() {
      return "(int)";
   }

   public final String c() {
      return "(int) " + Long.toString(this.b);
   }

   public final String d() {
      return Long.toString(this.b);
   }
}
