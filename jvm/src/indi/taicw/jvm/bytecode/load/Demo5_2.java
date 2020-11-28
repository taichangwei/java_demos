package indi.taicw.jvm.bytecode.load;

import java.io.IOException;

/**
 * @author taichangwei
 */
public class Demo5_2 {
    static {
        System.out.println("main init");
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {

//        //-------------会触发类的初始化的情况----------------
//        // 1. 首次访问这个类的静态变量或静态方法时，会触发
//        System.out.println(A.a);
//        // 2. 子类初始化，如果父类还没初始化，会触发
//        System.out.println(B.c);
//        // 3. 子类访问父类静态变量，只触发父类初始化
//        System.out.println(B.a);
//        // 4. 会初始化类 B，并先初始化类 A
//        Class.forName("indi.taicw.jvm.bytecode.load.B");
//        //new 关键字会触发初始化
//        new B();

//        //---------------不会触发类的初始化的情况---------------
//        // 1. 静态常量不会触发初始化
//        System.out.println(B.b);
//        // 2. 类对象.class 不会触发初始化
//        System.out.println(B.class);
//        // 3. 创建该类的数组不会触发初始化
//        System.out.println(new B[0]);
//        // 4. 不会初始化类 B，但会加载 B、A
//        ClassLoader cl = Thread.currentThread().getContextClassLoader();
//        cl.loadClass("indi.taicw.jvm.bytecode.load.B");
//        // 5. 不会初始化类 B，但会加载 B、A
//        ClassLoader c2 = Thread.currentThread().getContextClassLoader();
//        Class.forName("indi.taicw.jvm.bytecode.load.B", false, c2);

    }
}

class A {
    static int a = 0;

    static {
        System.out.println("a init");
    }
}

class B extends A {
    final static double b = 5.0;
    static boolean c = false;

    static {
        System.out.println("b init");
    }
}