package package_a.k;

final class t implements Runnable {
   // $FF: synthetic field
   private c a;

   t(c var1) {
      this.a = var1;
      super();
   }

   public final void run() {
      this.a.a = c.a(this.a);
      c.b(this.a).setJMenuBar(c.c(this.a));
      c.b(this.a).a(c.d(this.a));
      c.e(this.a).a("mnuFileSaveAs").setEnabled(true);
      c.e(this.a).a("execInstruction").setEnabled(true);
      c.e(this.a).a("execOptions").setEnabled(true);
      if (c.b(this.a) != null && c.b(this.a).a() != null) {
         c.e(this.a).a("mnuEditUndo").setEnabled(c.b(this.a).a().m());
      }

      if (c.b(this.a) != null && c.b(this.a).a() != null) {
         c.e(this.a).a("mnuEditRedo").setEnabled(c.b(this.a).a().n());
      }

      if (c.b(this.a) != null && c.b(this.a).a() != null) {
         c.b(this.a).a().d();
      }

      c.b(this.a).revalidate();
   }
}
