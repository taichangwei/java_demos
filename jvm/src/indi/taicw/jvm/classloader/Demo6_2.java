package indi.taicw.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Driver;
import java.util.ServiceLoader;

/**
 * @author taichangwei
 */
public class Demo6_2 {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new MyClassLoader();
        Class clazz = classLoader.loadClass("Student");
        Object obj = clazz.newInstance();
        clazz.getMethod("display").invoke(obj);

        ServiceLoader.load(Driver.class).iterator();
    }
}

