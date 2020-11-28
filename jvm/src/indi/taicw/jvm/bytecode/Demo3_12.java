package indi.taicw.jvm.bytecode;

/**
 * @author taichangwei
 */
public class Demo3_12 {
    public static void main(String[] args) {
        int result = test();
        System.out.println(result);
    }

    public static int test() {
        int i = 10;
        try {
            return i;
        } finally {
            i = 20;
            return i;
        }
    }
}
