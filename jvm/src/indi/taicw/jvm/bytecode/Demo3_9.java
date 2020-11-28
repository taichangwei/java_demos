package indi.taicw.jvm.bytecode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * @author taichangwei
 */
public class Demo3_9 {
    public static void main(String[] args) {
        try {
            Method test = Demo3_9.class.getMethod("test");
            test.invoke(null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void test() {
        System.out.println("ok");
    }
}
