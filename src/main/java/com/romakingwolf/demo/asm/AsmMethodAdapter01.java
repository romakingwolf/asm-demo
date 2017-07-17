package com.romakingwolf.demo.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by shilei on 17/7/16.
 */
public class AsmMethodAdapter01 extends MethodVisitor implements Opcodes {

    public AsmMethodAdapter01(int api, MethodVisitor mv) {
        super(api, mv);
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        super.visitVarInsn(opcode, var);
        if (opcode == Opcodes.ISTORE) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "com/romakingwolf/demo/asm/AopService", "operation", "()V", false);
        }
    }

}
