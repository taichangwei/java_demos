package indi.taicw.jvm.bytecode.compile;

/**
 * @author taichangwei
 */

enum Sex {
    MALE, FEMALE
}

public class Demo4_3_2 {
    public static void foo(Sex sex) {
        switch (sex) {
            case MALE:
                System.out.println("男"); break;
            case FEMALE:
                System.out.println("女"); break;
        }
    }
}


