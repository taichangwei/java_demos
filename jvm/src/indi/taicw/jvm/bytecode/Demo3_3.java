package indi.taicw.jvm.bytecode;

/**
 * @author taichangwei
 */
public class Demo3_3 {
    static Integer x = 0;
    public static void main(String[] args) {
        int i = 0;

        while (i < 10) {
            x = x++;
            i++;
        }
        System.out.println(x);
    }
}
