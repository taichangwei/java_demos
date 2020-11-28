package indi.taicw.jvm.bytecode;

/**
 * @author taichangwei
 */
public class Demo3_5 {
    private String a = "s1";

    {
        b = 20;
    }

    private int b = 10;

    {
        a = "s2";
    }

    public Demo3_5(String a, int b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        Demo3_5 d = new Demo3_5("s3", 30);
        System.out.println(d.a);
        System.out.println(d.b);
    }
}
