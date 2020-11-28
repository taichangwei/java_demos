package indi.taicw.jvm.bytecode;

/**
 * @author taichangwei
 */
public class Demo3_7 {
    public static void main(String[] args) {
        int i = 0;
        try {
            i = 10;
        } catch (Exception e) {
            i = 20;
        }
    }
}
