package indi.taicw.jvm.bytecode;

/**
 * @author taichangwei
 */
public class Demo3_6 {
    public Demo3_6() { }

    private void test1() { }

    private final void test2() { }

    public void test3() { }

    public static void test4() { }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        Demo3_6 d = new Demo3_6();
        d.test1();
        d.test2();
        d.test3();
        Demo3_6.test4();
        d.test4();
        d.toString();
    }
}
