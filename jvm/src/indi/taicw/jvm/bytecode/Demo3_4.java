package indi.taicw.jvm.bytecode;

/**
 * @author taichangwei
 */
public class Demo3_4 {
    static {
        i = 20;
    }

    static {
        i = 30;
    }

    static int i = 10;

    public static void main(String[] args) {
        System.out.println(i);
    }
}
