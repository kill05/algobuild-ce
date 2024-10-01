package package_a.f;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public final class a extends FileInputStream {
   private String a = "AlgoBuild01.00\n";
   private int b = -1;

   public a(String var1) {
      super(var1);
   }

   public final int read() {
      this.a();
      int var1 = super.read();
      ++this.b;
      return var1;
   }

   public final int read(byte[] var1, int var2, int var3) {
      this.a();
      int var4 = super.read(var1, var2, var3);
      this.b += var4;
      return var4;
   }

   public final int read(byte[] var1) {
      this.a();
      int var2 = super.read(var1);
      this.b += var2;
      return var2;
   }

   private void a() {
      if (this.b < 0) {
         byte[] var1;
         byte[] var2 = new byte[(var1 = this.a.getBytes()).length];
         super.read(var2, 0, var2.length);
         if (!Arrays.equals(var1, var2)) {
            throw new IOException("Invalid file format!");
         }

         this.b = 0;
      }

   }
}
