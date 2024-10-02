package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.json.JsonObject;
import com.github.kill05.algobuildce.package_a.f.ABBlockDataHolder;

public abstract class k extends ABInstructionBlock {
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
      return "ABIIO_Base [content=" + this.b + ", getOrderInParent()=" + this.getOrderInParent() + "]";
   }

   @Override
   public ABBlockDataHolder h() {
      ABBlockDataHolder var1;
      (var1 = super.h()).putData("content", this.b);
      return var1;
   }

   @Override
   public void a(ABBlockDataHolder var1) {
      super.a(var1);
      String var2 = var1.getData("content");
      this.a(var2);
   }

   @Override
   public JsonObject b(boolean var1) {
      JsonObject var2;
      (var2 = super.b(var1)).put("content", this.b);
      return var2;
   }

   @Override
   public void a(JsonObject var1, boolean var2) {
      super.a(var1, var2);
      String var3 = var1.getAsString("content");
      this.a(var3);
   }

   @Override
   public final p i() {
      return new p(1, this.b.length());
   }
}
