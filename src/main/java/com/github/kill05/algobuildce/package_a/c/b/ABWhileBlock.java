package com.github.kill05.algobuildce.package_a.c.b;

import com.github.kill05.algobuildce.package_a.c.a.ABExecutable;
import com.github.kill05.algobuildce.package_a.c.a.ABExecutionFragment;
import com.github.kill05.algobuildce.package_c.ABInstructionException;

public final class ABWhileBlock extends h {
   public ABWhileBlock(String var1) {
      super(var1);
   }

   public ABWhileBlock() {
      super((String)null);
   }

   @Override
   public final int a(com.github.kill05.algobuildce.package_a.c.a.b var1, int var2) {
      String var6 = this.l().replace('\n', ' ');

      boolean var7;
      try {
         com.github.kill05.algobuildce.package_c.l var3;
         boolean var4;
         var7 = var4 = (var3 = var1.e().a(var6, var1.c())) instanceof com.github.kill05.algobuildce.package_c.h && ((com.github.kill05.algobuildce.package_c.h)var3).a();
         var1.h("WHILE TEST:  " + var6 + "   RESULT: " + var4);
         var1.i();
      } catch (ABInstructionException var5) {
         var1.i("WHILE ERROR: " + var5 + " IN " + var6);
         return -2;
      }

      if (var7) {
         ABExecutionFragment var8 = new ABExecutionFragment(this.m(), var1);
         var1.d().push(var8);
         return 0;
      } else {
         return -1;
      }
   }

   public final String toString() {
      return "ABICycleWhile  [ " + super.toString() + "]";
   }

   @Override
   public final ABExecutable copy() {
      ABWhileBlock var1 = new ABWhileBlock(this.l());

      try {
         for(int var2 = 0; var2 < this.getInstructionAmount(); ++var2) {
            ABInstructionBlock var3 = this.getInstruction(var2);
            var1.addInstruction((ABInstructionBlock)var3.copy());
         }
      } catch (s var4) {
         var4.printStackTrace();
      } catch (r var5) {
         var5.printStackTrace();
      }

      return var1;
   }

   @Override
   protected final String getName() {
      return "ABIWHI";
   }
}
