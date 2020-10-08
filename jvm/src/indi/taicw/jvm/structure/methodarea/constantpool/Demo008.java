package indi.taicw.jvm.structure.methodarea.constantpool;

/**
 * 演示 字符串与字符串常量池相关问题
 */
public class Demo008 {

    public static void main(String[] args) {
        String s1 = "a";    //字符串 "a" 放入串池，StringTable ["a"]
        String s2 = "b";    //字符串 "b" 放入串池，StringTable ["a", "b"]
        String s3 = "ab";   //字符串 "ab" 放入串池，StringTable ["a", "b", "ab"]

        //因为s1、s2是变量，只有运行时期才能确定具体值，所以底层实现是 new StringBuilder().append("a").append("b").toString()，返回一个新的"ab"字符串对象
        String s4 = s1 + s2;
        // javac 在编译期间的优化，结果已经在编译期确定为 "ab"，所以等价于 s5 = "ab"，此时常量池已存在不用再创建新的"ab"对象
        String s5 = "a" + "b";
        // s4调用intern()方法尝试把"ab"放入串池中，此时串池已存在"ab", 并返回串池中的"ab"对象引用赋值给s6
        String s6 = s4.intern();

        //false，原因：s3 是串池中"ab"字符串对象的引用，s4是堆中"ab"对象的引用
        System.out.println(s3 == s4);
        //true，原因：s3、s5 都是串池中"ab"字符串对象的引用
        System.out.println(s3 == s5);
        //true，原因：s3、s6 都是串池中"ab"字符串对象的引用
        System.out.println(s3 == s6);


        String x2 = new String("c") + new String("d");
        x2.intern(); //把字符串"cd"放入串池，StringTable ["a", "b", "ab", "cd"]
        String x1 = "cd"; //直接把串池中的"cd"对象引用赋值给 x1

        //JDK1.7及之后版本，结果为true, 原因：x2调用intern()方法尝试把"cd"放入串池，此时串池不存在"cd"放入成功，此时串池中的"cd"对象与堆中的是同一个
        //JDK1.6版本，结果为false, 原因：x2调用intern()方法尝试把"cd"放入串池，此时串池不存在"cd"字符串，会复制一个新的"cd"对象放入串池中，此时串池中的"cd"对象与堆中的不是同一个
        System.out.println(x1 == x2);

        String x4 = new String("e") + new String("f");
        String x3 = "ef"; //把字符串"cd"放入串池，StringTable ["a", "b", "ab", "cd", "ef"]
        x4.intern();
        //结果为false, 原因：x4调用intern()方法尝试把"ef"放入串池，此时串池已存在"cd"放入失败，此时x3是串池中"ef"对象的引用，而x4是堆中的"ef"对象引用
        System.out.println(x3 == x4);

        String xx1 = new StringBuilder().append("jav").append("va").toString();
        System.out.println(xx1.intern() == xx1);

    }
}
