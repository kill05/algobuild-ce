package package_a.c.b;

public final class d extends n {
   private String b;

   public d(String var1) {
      this.a(var1);
   }

   public d() {
      this.a((String)null);
   }

   public final String b() {
      return this.b;
   }

   public final void a(String var1) {
      this.b = var1;
      if (var1 != null) {
         var1.split("\n|;");
      }

      this.a(true);
   }

   public final int a(package_a.c.a.b var1, int var2) {
      return -1;
   }

   public final String toString() {
      return this.n() + "- ABIComment: " + this.b + "\n";
   }

   @Override
   protected final String g() {
      return "ABICOM";
   }

   @Override
   public final package_a.f.g h() {
      package_a.f.g var1;
      (var1 = super.h()).a("label", this.b);
      return var1;
   }

   public final void a(package_a.f.g var1) {
      super.a(var1);
      String var2 = var1.a("label");
      this.a(var2);
   }

   public final package_b.a.c b(boolean var1) {
      package_b.a.c var2;
      (var2 = super.b(var1)).b("label", this.b);
      return var2;
   }

   public final void a(package_b.a.c var1, boolean var2) {
      super.a(var1, var2);
      String var3 = var1.f("label");
      this.a(var3);
   }

   public final package_a.c.a.d e() {
      d var1;
      (var1 = new d()).a(this.b);
      return var1;
   }

   public final boolean b(int var1) {
      return false;
   }

   @Override
   public final p i() {
      return new p(1, this.b.length());
   }
}
