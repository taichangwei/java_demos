package indi.taicw.jvm.structure.direct;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 演示 普通内存与直接内存读取文件效率
 */
public class Demo011 {
    static final String FROM = "C:\\Users\\taichangwei\\Downloads\\CentOS-6.10-x86_64-bin-DVD2.iso"; //一个2.03G的文件
    static final String TO = "E:\\a.iso";
    static final int _1Mb = 1024 * 1024;

    public static void main(String[] args) {
        io();
        directBuffer();
    }

    private static void directBuffer() {
        long start = System.nanoTime();
        try (FileChannel from = new FileInputStream(FROM).getChannel();
             FileChannel to = new FileOutputStream(TO).getChannel();
        ) {
            ByteBuffer bb = ByteBuffer.allocateDirect(_1Mb);
            while (true) {
                int len = from.read(bb);
                if (len == -1) {
                    break;
                }
                bb.flip();
                to.write(bb);
                bb.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("directBuffer 用时：" + (end - start) / 1000_000.0);
    }

    private static void io() {
        long start = System.nanoTime();
        try (FileInputStream from = new FileInputStream(FROM);
             FileOutputStream to = new FileOutputStream(TO);
        ) {
            byte[] buf = new byte[_1Mb];
            while (true) {
                int len = from.read(buf);
                if (len == -1) {
                    break;
                }
                to.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("io 用时：" + (end - start) / 1000_000.0);
    }
}

/*
执行三次分别用时
io 用时：4944.8368
directBuffer 用时：1927.7912

io 用时：4989.7547
directBuffer 用时：2287.7028

io 用时：5022.2618
directBuffer 用时：2453.5307
 */
