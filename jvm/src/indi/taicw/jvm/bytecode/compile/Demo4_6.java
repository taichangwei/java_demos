package indi.taicw.jvm.bytecode.compile;

/**
 * @author taichangwei
 */
public class Demo4_6 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("running...");
            }
        };
    }
}
