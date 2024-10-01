package com.github.kill05.algobuildce.package_a.i;

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

public final class e implements Transferable {
    private Image image;

    public e(Image var1) {
        this.image = var1;
    }

    @Override
    public final DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{DataFlavor.imageFlavor};
    }

    @Override
    public final boolean isDataFlavorSupported(DataFlavor var1) {
        return DataFlavor.imageFlavor.equals(var1);
    }

    @Override
    public final Object getTransferData(DataFlavor var1) throws UnsupportedFlavorException {
        if (!DataFlavor.imageFlavor.equals(var1)) {
            throw new UnsupportedFlavorException(var1);
        } else {
            return this.image;
        }
    }
}
