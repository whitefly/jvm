package 垃圾回收;


public class C3_2_1引用计数算法 {
    public Object ref = null;
    final static int size = 1024 * 1024;

    public byte[] ownSpace = new byte[size];

    public static void main(String[] args) throws InterruptedException {
        C3_2_1引用计数算法 o1 = new C3_2_1引用计数算法();
        C3_2_1引用计数算法 o2 = new C3_2_1引用计数算法();

        //构成循环引用
        o1.ref = o2;
        o2.ref = o1;

        //引用对象置空,并强行gc;
        o1 = null;
        o2 = null;

        System.gc();

        Thread.sleep(2000L);
    }
}
