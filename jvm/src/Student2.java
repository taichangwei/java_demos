/**
 * @author taichangwei
 */
public class Student2 {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class clazz = classLoader.loadClass("Student2");
        Object obj = clazz.newInstance();
        clazz.getMethod("display").invoke(obj);
    }

    public void display() {
        Class<Student2> clazz = Student2.class;
        System.out.println();clazz.getResource("");
        System.out.println("类名：" + clazz.getName());
        System.out.println("Student.class的类加载器：" + clazz.getClassLoader().toString());
        System.out.println("Student.class的类加载器的上级类加载器：" + clazz.getClassLoader().getParent().toString());
        System.out.println("Student.class的文件位置：" + clazz.getClassLoader().getResource(""));
        System.out.println("I'm a student!");
    }
}
