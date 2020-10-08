package indi.taicw.jvm.structure.stack;

/**
 * 演示虚拟机栈
 * @author taichangwei
 */
public class Demo001 {
    public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        method2(1, 2);
    }

    private static int method2(int a, int b) {
        int c = a + b;
        return c;
    }
}
