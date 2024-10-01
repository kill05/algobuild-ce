package package_a.f;

import java.io.FileOutputStream;

public final class b extends FileOutputStream {
   private String a = "AlgoBuild01.00\n";
   private int b = 0;

   public b(String var1) {
      super(var1);
   }

   public final void write(byte[] var1, int var2, int var3) {
      if (this.b == 0) {
         byte[] var4 = this.a.getBytes();
         super.write(var4, 0, var4.length);
      }

      super.write(var1, var2, var3);
      this.b += var3;
   }

   public final void write(byte[] var1) {
      if (this.b == 0) {
         byte[] var2 = this.a.getBytes();
         super.write(var2, 0, var2.length);
      }

      super.write(var1);
      this.b += var1.length;
   }

   public final void write(int var1) {
      if (this.b == 0) {
         byte[] var2 = this.a.getBytes();
         super.write(var2, 0, var2.length);
      }

      super.write(var1);
      ++this.b;
   }
}
