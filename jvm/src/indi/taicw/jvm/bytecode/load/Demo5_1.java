package indi.taicw.jvm.bytecode.load;

import java.io.IOException;

/**
 * @author taichangwei
 */
public class Demo5_1 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ClassLoader classloader = Demo5_1.class.getClassLoader();
        // loadClass 方法不会导致类的解析和初始化
        Class<?> c = classloader.loadClass("indi.taicw.jvm.bytecode.load.C");
        // new 会导致类的解析和初始化
        new E();
        System.in.read();
    }
}

class C {
    D d = new D();
}
class D {
}

class E {
    F f = new F();
}

class F {

}