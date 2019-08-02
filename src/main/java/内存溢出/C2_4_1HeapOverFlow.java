package 内存溢出;

import java.util.ArrayList;
import java.util.List;

public class C2_4_1HeapOverFlow {
    static class BigObj {
        private int[] num;

        BigObj() {
            num = new int[1000];
        }
    }

    public static void main(String[] args) {
        List<BigObj> buffer = new ArrayList<BigObj>();
        while (true) {
            buffer.add(new BigObj());
            System.out.println("创建对象成功");
        }
    }
}
