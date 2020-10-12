package indi.taicw.jvm.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * -Xms20M -Xmx20M -Xmn10M -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
 */
public class GCDemo04 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            String s = String.valueOf(new Random().nextInt());
            if (i%2 == 0) {
                list.add(s);
            }
        }
        System.out.println("-----------------------------");
        list = null;
        System.gc();
        System.out.println("====================================");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
