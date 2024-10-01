package package_c;

public class i implements l {
   double a;

   public i(double var1) {
      this.a = var1;
   }

   public i() {
      this.a = 0.0D;
   }

   public boolean a(l var1) {
      return var1 instanceof i && this.a == ((i)var1).a;
   }

   public boolean b(l var1) {
      return var1 instanceof i && this.a < ((i)var1).a;
   }

   public String toString() {
      return Double.toString(this.a);
   }

   public String b() {
      return "(double)";
   }

   public String c() {
      return "(double) " + Double.toString(this.a);
   }

   public String d() {
      return Double.toString(this.a);
   }
}
