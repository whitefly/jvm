package 垃圾回收;

public class C3_6_1allocate_on_eden {
    /*
    配置: -XX:+UseSerialGC -Xmx20M -Xms20M  -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    final static private int MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] task1, task2, task3, task4;


        //以下3个会分配到Egen区
        task1 = new byte[2 * MB];
        task2 = new byte[2 * MB];
        task3 = new byte[2 * MB];

        //发现4MB不够,会触发一次Minor GC,但是由于task1,2,3不是垃圾,还是无法搞出足够的空间. 所以讲task1,task2,task3都转移到老年代. Egen腾出空间,装下了Task4
        task4 = new byte[4 * MB];

        System.out.println("所以任务完成");

    }
}


