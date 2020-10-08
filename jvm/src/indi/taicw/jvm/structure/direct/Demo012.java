package indi.taicw.jvm.structure.direct;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示 直接内存溢出
 */
public class Demo012 {
    static int _100Mb = 1024 * 1024 * 100;

    public static void main(String[] args) {
        List<ByteBuffer> list = new ArrayList<>();
        int i = 0;
        try {
            while (true) {
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_100Mb);
                list.add(byteBuffer);
                i++;
            }
        } finally {
            System.out.println(i);
        }
    }
}
