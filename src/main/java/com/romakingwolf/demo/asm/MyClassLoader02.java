package com.romakingwolf.demo.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by shilei on 17/7/16.
 */
public class MyClassLoader02 {

    public static void loadClass() throws IOException {

        ClassReader cr = new ClassReader("com/romakingwolf/demo/asm/Action");
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        AsmClassAdapter02 classAdapter = new AsmClassAdapter02(Opcodes.ASM5, cw);
        cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
        byte[] data = cw.toByteArray();
        File file = new File("target/classes/com/romakingwolf/demo/asm/Action.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(data);
        fout.close();

    }

    public static void main(String[] args) throws IOException {

        loadClass();

    }

}
