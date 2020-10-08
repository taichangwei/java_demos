package indi.taicw.jvm.structure.stack;

/**
 * 演示局部变量是否线程安全
 * @author taichangwei
 */
public class Demo002 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(4);
        sb.append(5);
        sb.append(6);
        new Thread(()->{
            m2(sb);
        }).start();
    }

    //是线程安全的，因为局部变量sb只在方法内使用
    public static void m1() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    //不是线程安全的，因为局部变量sb是作为参数传过来的，m2()执行的同时可能会被其他线程修改
    public static void m2(StringBuilder sb) {
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    //不是线程安全的，因为局部变量sb是作为返回值，可能会被多个其他线程拿到并同时修改
    public static StringBuilder m3() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        return sb;
    }
}
