package indi.taicw.jvm.bytecode.compile;

/**
 * @author taichangwei
 */
public class Demo4_3 {

    public static void main(String[] args) {
        choose("world");
    }

    public static void choose(String str) {
        switch (str) {
            case "hello":
                System.out.println("你好");
                break;

            case "world":
                System.out.println("世界");
                break;

            case "hello world":
                System.out.println("你好世界");
                break;
            case "C.":
                System.out.println("123");
                break;
            case "BM":
                System.out.println("abc");
                break;
        }
    }
}