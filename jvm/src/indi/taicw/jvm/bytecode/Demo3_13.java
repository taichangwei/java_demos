package indi.taicw.jvm.bytecode;

/**
 * @author taichangwei
 */
public class Demo3_13 {
    public static void main(String[] args) {
        int result = test();
        System.out.println(result);
    }

    public static int test() {
        int i = 10;
        try {
            i = i/0; //这里一定异常，但并没有抛出
            return i;
        } finally {
            i = 20;
            return i;
        }
    }
}
