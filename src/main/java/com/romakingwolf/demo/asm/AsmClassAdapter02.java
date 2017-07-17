package com.romakingwolf.demo.asm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by shilei on 17/7/16.
 */
public class AsmClassAdapter02 extends ClassVisitor implements Opcodes {

    public AsmClassAdapter02(int api, ClassVisitor cv) {
        super(api, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {

        MethodVisitor mv = this.cv.visitMethod(access, name, desc, signature, exceptions);
        MethodVisitor wrappedMv = mv;

        if(mv != null && name.equals("calculate")) {
            wrappedMv = new AsmMethodAdapter02(this.api, mv);
        }

        return wrappedMv;

    }

}
