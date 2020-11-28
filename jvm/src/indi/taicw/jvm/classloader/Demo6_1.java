package indi.taicw.jvm.classloader;

/**
 * -Xbootclasspath/a:.
 */
public class Demo6_1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("indi.taicw.jvm.classloader.F");
        System.out.println("类加载器："+ aClass.getClassLoader());
    }
}