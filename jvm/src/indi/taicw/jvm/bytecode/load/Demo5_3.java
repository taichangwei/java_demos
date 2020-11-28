package indi.taicw.jvm.bytecode.load;

/**
 * @author taichangwei
 */
public class Demo5_3 {
    public static void main(String[] args) {
        System.out.println(EE.a);
        System.out.println(EE.b);
        System.out.println(EE.c);

    }
}

class EE {
    public static final int a = 10;
    public static final String b = "hello";
    public static final Integer c = 20;  // Integer.valueOf(20)
    static {
        System.out.println("init E");
    }
}