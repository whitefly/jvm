package 性能监控工具;

import java.util.HashMap;
import java.util.Map;

public class C4_2_2jstat {
    private static final int MB = 1024 * 1024;
    private static final int threshold = 400;


    public static void main(String[] args) throws InterruptedException {
        Map<Long, byte[]> container = new HashMap<Long, byte[]>();
        long memorySize = 0;  // 单位B
        while (true) {
            if ((memorySize / MB) >= threshold) {
                container.clear();
                System.out.println("container清空完成");
                memorySize = 0;
            }
            long l = System.currentTimeMillis();
            container.put(l, new byte[MB]);
            memorySize += MB;
            if ((memorySize / MB) % 40 == 0) {
                System.out.println("总大小为:" + (memorySize / MB) + "MB");
            }
            Thread.sleep(100);
        }
    }
}
