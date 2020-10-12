package indi.taicw.jvm.gc;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示软引用
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 */
public class GcDemo01 {
    private static final int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) throws IOException {

        //strong();
       soft();
    }

    //使用强引用导致堆内存溢出 java.lang.OutOfMemoryError: Java heap space
    public static void strong(){
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new byte[_4MB]);
        }
    }

    //使用软引用，当内存不足垃圾回收时list中个别软引用对象所引用的byte[]对象会被回收，所以ref.get()可能返回null
    public static void soft() {
        // list --> SoftReference --> byte[]
        List<SoftReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SoftReference<byte[]> softRef = new SoftReference<>(new byte[_4MB]);
            System.out.println(softRef.get());
            list.add(softRef);
            System.out.println(list.size());
        }
        System.out.println("循环结束：" + list.size());
        for (SoftReference<byte[]> ref : list) {
            System.out.println(ref.get());
        }
    }
}
