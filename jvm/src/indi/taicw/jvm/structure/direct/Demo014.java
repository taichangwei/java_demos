package indi.taicw.jvm.structure.direct;

import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * 演示 直接内存分配及回收的底层原理演示
 */
public class Demo014 {

    static int _1Gb = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        Unsafe unsafe = getUnsafe();
        // 分配内存
        long base = unsafe.allocateMemory(_1Gb);
        unsafe.setMemory(base, _1Gb, (byte) 0);
        //暂定等待。此时查看任务管理器(windows系统)，会发现有一个占用1G内存的java程序
        System.in.read();

        // 释放内存
        unsafe.freeMemory(base);
        //暂定等待。此时查看任务管理器(windows系统)，会发现刚才占用1G内存的java程序内存释放了
        System.in.read();
    }

    public static Unsafe getUnsafe() {
        try {
            //Unsafe 构造方法是私有化的，只能通过反射获得
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);
            return unsafe;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
