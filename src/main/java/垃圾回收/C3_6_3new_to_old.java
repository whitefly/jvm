package 垃圾回收;

public class C3_6_3new_to_old {
    private static final int MB = 1024 * 1024;
    /*
    -XX:+UseSerialGC -Xmx20M -Xms20M  -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
     */

    public static void main(String[] args) {
        byte[] task1, task2, task3;

        task1 = new byte[MB / 5];  //0.25M
        System.out.println("task1分配完成: 0.25M");
        task2 = new byte[4 * MB];
        System.out.println("task2分配完成: 2MB");
        task3 = new byte[4 * MB];
        System.out.println("task3分配完成: 4MB");
        //产生4MB垃圾
        task3 = null;
        task3 = new byte[4 * MB];
        System.out.println("task3再次分配完成: 4MB");

        //若设置年纪阈值为1
        //需要4MB的空间,启动一次minor GC,将之前的4MB垃圾回收,
        // task1,task2从Eden移动到survivor区,年龄变为1,阈值为1,task1,task2所以直接变为老生代, survivor区无内容,Eden用来给task3新分配4MB;
        //最后状态: eden: task3   老年代: taks1,taks2

        // 若设置年纪阈值为15
        //启动一次minor GC,将之前的4MB垃圾回收
        // task1,task2从Eden移动到survivor区,年龄变为1,由于survivor只有1MB,task1可以被容纳,task2太大无法容纳,所以task1进入survivor,task2进入老生代
        //最后状态: eden:task3 from: task1  老年代: task2


    }
}
