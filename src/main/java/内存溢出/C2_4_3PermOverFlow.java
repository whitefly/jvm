package 内存溢出;

import java.util.ArrayList;
import java.util.List;

public class C2_4_3PermOverFlow {
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        int i = 0;
//        while (true) {
//            buffer.add(String.valueOf(i++).intern());
//        }

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);  // true

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern()==str2); //false
    }
}
