package com.romakingwolf.demo.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by shilei on 17/7/16.
 */
public class AsmMethodAdapter02 extends MethodVisitor implements Opcodes {

    public AsmMethodAdapter02(int api, MethodVisitor mv) {
        super(api, mv);
    }

    private int constCnt = 0;

    @Override
    public void visitInsn(int opcode) {
        super.visitInsn(opcode);
        if (opcode == Opcodes.IADD) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "com/romakingwolf/demo/asm/AopService", "operation", "()V", false);
        }
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        super.visitVarInsn(opcode, var);
        constCnt++;
        if (constCnt == 2) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "com/romakingwolf/demo/asm/AopService", "operation", "()V", false);
        }
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        super.visitMethodInsn(opcode, owner, name, desc, itf);
        if (opcode == Opcodes.INVOKEVIRTUAL) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "com/romakingwolf/demo/asm/AopService", "operation", "()V", false);
        }
    }

}
