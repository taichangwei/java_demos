package indi.taicw.jvm.structure.direct;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * 演示 显示垃圾回收对直接内存的影响。
 * 因为程序调用 System.gc() 会触发full gc，可能会长时间在垃圾回收，所以一般会警用显示垃圾回收。如果禁用了显示垃圾回收，代码调用 System.gc() 不会触发垃圾回收，因此直接内存也不会被回收
 * 禁用：-XX:-DisableExplicitGC，启用：-XX:-DisableExplicitGC
 */
public class Demo013 {

    static int _1Gb = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1Gb);
        System.out.println("分配完毕...");
        System.in.read(); //暂停等待
        System.out.println("开始释放...");
        byteBuffer = null;
        // 显式的垃圾回收，Full GC。如是禁用状态，这里代码无效
        System.gc();
        System.in.read(); //暂停等待
    }
}
