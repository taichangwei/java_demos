package indi.taicw.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author taichangwei
 */
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String path = "E:/code/" + name + ".class";

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Files.copy(Paths.get(path), out);

            byte[] bytes = out.toByteArray();

            return defineClass(name, bytes, 0, bytes.length);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException("类文件未找到", e);
        }

    }
}

