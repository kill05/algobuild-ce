package package_b.a;

final class NullValue {

   public static final NullValue INSTANCE = new NullValue();

   private NullValue() {
   }

   @Override
   protected Object clone() {
      return this;
   }

   @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
   public boolean equals(Object var1) {
      return var1 == null || var1 == this;
   }

   public String toString() {
      return "null";
   }

}
