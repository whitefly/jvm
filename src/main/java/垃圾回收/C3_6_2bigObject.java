package 垃圾回收;

public class C3_6_2bigObject {
    /*
    JVM配置: -XX:+UseSerialGC -Xmx20M -Xms20M  -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
     */
    private static final int MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] bigObject = new byte[7 * MB];
        System.out.println("分配完成");
    }
}
