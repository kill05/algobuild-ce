package package_a.i;

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

public final class e implements Transferable {
   private Image a;

   public e(Image var1) {
      this.a = var1;
   }

   public final DataFlavor[] getTransferDataFlavors() {
      return new DataFlavor[]{DataFlavor.imageFlavor};
   }

   public final boolean isDataFlavorSupported(DataFlavor var1) {
      return DataFlavor.imageFlavor.equals(var1);
   }

   public final Object getTransferData(DataFlavor var1) {
      if (!DataFlavor.imageFlavor.equals(var1)) {
         throw new UnsupportedFlavorException(var1);
      } else {
         return this.a;
      }
   }
}
