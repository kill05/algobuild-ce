package package_a.c.b;

public abstract class m extends n {
   private String b;

   public m(String var1) {
      this.b = var1;
   }

   public final String l() {
      return this.b;
   }

   public final void a(String var1) {
      this.b = var1;
      this.a(true);
   }

   @Override
   public final String b() {
      return this.b;
   }

   public String toString() {
      return "ABISelection_Base [condition=" + this.b + ", getOrderInParent()=" + this.n() + "]";
   }

   @Override
   public final boolean a() {
      return true;
   }

   @Override
   public final package_a.f.g h() {
      package_a.f.g var1;
      (var1 = super.h()).a("condition", this.b);
      return var1;
   }

   @Override
   public final void a(package_a.f.g var1) {
      super.a(var1);
      String var2 = var1.a("condition");
      this.a(var2);
   }

   @Override
   public package_b.a.c b(boolean var1) {
      package_b.a.c var2;
      (var2 = super.b(var1)).b("condition", this.b);
      return var2;
   }

   @Override
   public void a(package_b.a.c var1, boolean var2) {
      super.a(var1, var2);
      String var3 = var1.f("condition");
      this.a(var3);
   }

   @Override
   public p i() {
      return new p(1, this.b.length());
   }
}
