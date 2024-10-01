package package_b.a;

public final class b extends RuntimeException {
   private Throwable a;

   public b(String var1) {
      super(var1);
   }

   public b(Throwable var1) {
      super(var1.getMessage());
      this.a = var1;
   }

   public final Throwable getCause() {
      return this.a;
   }
}
