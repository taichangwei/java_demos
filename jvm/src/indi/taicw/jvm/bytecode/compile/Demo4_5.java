package indi.taicw.jvm.bytecode.compile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author taichangwei
 */
public class Demo4_5 {
    public static void main(String[] args) {
        try(InputStream is = new FileInputStream("d:\\1.txt")) {
            System.out.println(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
