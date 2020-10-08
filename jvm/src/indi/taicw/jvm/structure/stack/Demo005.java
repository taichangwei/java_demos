package indi.taicw.jvm.structure.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示 堆内存诊断
 * @author taichangwei
 */
public class Demo005 {
    public static void main1(String[] args) throws InterruptedException {
        System.out.println("1...");
        Thread.sleep(30000);
        byte[] array = new byte[1024 * 1024 * 10]; // 10 Mb
        System.out.println("2...");
        Thread.sleep(20000);
        array = null;
        System.gc();
        System.out.println("3...");
        Thread.sleep(1000000L);
    }

    public static void main(String[] args) throws InterruptedException {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            students.add(new Student());
        }
        Thread.sleep(1000000000L);
    }
}

class Student {
    private byte[] big = new byte[1024*1024];
}


