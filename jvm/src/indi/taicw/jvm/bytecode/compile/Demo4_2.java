package indi.taicw.jvm.bytecode.compile;

/**
 * @author taichangwei
 */
public class Demo4_2 {
    public static void foo(String... args) {
        String[] array = args; //可以直接复制给数组
        System.out.println(array);
    }

    public static void main(String[] args) {
        foo("hello", "world");
    }
}
