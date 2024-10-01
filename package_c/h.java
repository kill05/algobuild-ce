package package_c;

public final class h implements l {
   boolean a;

   public h(boolean var1) {
      this.a = var1;
   }

   public h() {
      this.a = false;
   }

   public final boolean a() {
      return this.a;
   }

   public final boolean a(l var1) {
      return var1 instanceof h && this.a == ((h)var1).a;
   }

   public final boolean b(l var1) {
      return var1 instanceof h && !this.a && ((h)var1).a;
   }

   public final String toString() {
      return Boolean.toString(this.a);
   }

   public final String b() {
      return "(boolean)";
   }

   public final String c() {
      return "(boolean) " + Boolean.toString(this.a);
   }

   public final String d() {
      return Boolean.toString(this.a);
   }
}
