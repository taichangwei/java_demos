package indi.taicw.jvm.bytecode;

/**
 * @author taichangwei
 */
public class Demo3_10 {
    public static void main(String[] args) {
        int i = 0;
        try {
            i = 10;
        } catch (Exception e) {
            i = 20;
        } finally {
            i = 30;
        }
    }
}
