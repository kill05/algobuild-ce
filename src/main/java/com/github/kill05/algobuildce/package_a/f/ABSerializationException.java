package com.github.kill05.algobuildce.package_a.f;

import java.io.IOException;

// some error correlated to serialization
public final class ABSerializationException extends IOException {
   public ABSerializationException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public ABSerializationException(String var1) {
      super(var1);
   }
}
