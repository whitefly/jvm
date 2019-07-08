package 垃圾回收;

import java.util.HashMap;
import java.util.Map;

public class C3_4_1stop_the_world {
    private final static int MB = 1024 * 1024;

    public static void main(String[] args) {
        final Thread task1 = new Thread(new Runnable() {
            public void run() {
                long start = System.currentTimeMillis();
                while (true) {
                    try {
                        long gap = System.currentTimeMillis() - start;
                        System.out.println("相对时间:" + gap);
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread task2 = new Thread(new Runnable() {
            public void run() {
                Map<Long, byte[]> map = new HashMap<Long, byte[]>();
                while (true) {
                    try {
                        int total = map.size();  //total以MB为单位
                        if (total > 450) {
                            System.out.println("map大小为:" + total + "MB" + " 执行map.clear()");
                            map.clear();
                            System.out.println(map.containsKey(232321L));
                        }
                        Thread.sleep(10);
                        map.put(System.nanoTime(), new byte[MB]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        task1.start();
        task2.start();
    }
}
