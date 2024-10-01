package package_c;

public final class k implements l {
   String a;

   public k(String var1) {
      this.a = var1;
   }

   public k(char var1) {
      this.a = Character.toString(var1);
   }

   public k() {
      this.a = "";
   }

   @Override
   public final boolean a(l var1) {
      return var1 instanceof k && this.a.equals(((k)var1).a);
   }

   @Override
   public final boolean b(l var1) {
      return var1 instanceof k && this.a.compareTo(((k)var1).a) < 0;
   }

   public final String toString() {
      return this.a;
   }

   @Override
   public final String b() {
      return "(string)";
   }

   @Override
   public final String c() {
      return "(string) \"" + this.a + "\"";
   }

   @Override
   public final String d() {
      return "\"" + this.a + "\"";
   }
}
