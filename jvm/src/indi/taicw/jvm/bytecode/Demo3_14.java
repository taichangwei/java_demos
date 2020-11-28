package indi.taicw.jvm.bytecode;

/**
 * @author taichangwei
 */
public class Demo3_14 {
    public static void main(String[] args) {
        Object lock = new Object();
        synchronized (lock) {
            System.out.println("ok");
        }
    }
}
