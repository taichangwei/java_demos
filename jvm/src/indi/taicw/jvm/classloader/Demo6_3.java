package indi.taicw.jvm.classloader;

/**
 * @author taichangwei
 */
public class Demo6_3 {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader1 = new MyClassLoader();
        ClassLoader classLoader2 = new MyClassLoader();
        Class c1 = classLoader1.loadClass("Student");
        Class c2 = classLoader1.loadClass("Student");
        Class c3 = classLoader2.loadClass("Student");

        System.out.println(c1 == c2);
        System.out.println(c1 == c3);

        Thread.currentThread().getContextClassLoader();
        ClassLoader.getSystemClassLoader();

    }


}

