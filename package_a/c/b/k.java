package package_a.c.b;

public abstract class k extends n {
   private String b;
   private String[] c = null;

   public k(String var1) {
      this.b = var1;
   }

   public final String k() {
      return this.b;
   }

   public final void a(String var1) {
      this.b = var1;
      this.j();
      this.a(true);
   }

   private void j() {
      this.c = this.b.split("\n");
   }

   protected final String[] l() {
      if (this.c == null && this.b != null) {
         this.j();
      }

      return this.c;
   }

   public String toString() {
      return "ABIIO_Base [content=" + this.b + ", getOrderInParent()=" + this.n() + "]";
   }

   @Override
   public package_a.f.g h() {
      package_a.f.g var1;
      (var1 = super.h()).a("content", this.b);
      return var1;
   }

   @Override
   public void a(package_a.f.g var1) {
      super.a(var1);
      String var2 = var1.a("content");
      this.a(var2);
   }

   @Override
   public package_b.a.c b(boolean var1) {
      package_b.a.c var2;
      (var2 = super.b(var1)).b("content", this.b);
      return var2;
   }

   @Override
   public void a(package_b.a.c var1, boolean var2) {
      super.a(var1, var2);
      String var3 = var1.f("content");
      this.a(var3);
   }

   @Override
   public final p i() {
      return new p(1, this.b.length());
   }
}
