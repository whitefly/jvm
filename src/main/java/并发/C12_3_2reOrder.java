package 并发;

public class C12_3_2reOrder {
    private static int x;
    private static int y;
    private static int a;
    private static int b;
    int threadSize = 2;

    private void init() {
        x = 0;
        y = 0;
        a = 0;
        b = 0;
    }

    private void test(int i) throws InterruptedException {
        init();
        Thread[] pool = new Thread[threadSize];
        pool[0] = new Thread(new Runnable() {
            public void run() {
                a = 1;
                x = b;
            }
        });

        pool[1] = new Thread(new Runnable() {
            public void run() {
                b = 1;
                y = a;
            }
        });

        pool[1].start();
        pool[0].start();

        pool[0].join();
        pool[1].join();

        System.out.println(String.format("第%d次 x:%d y:%d", i, x, y));
//        if (x == 0 && y == 0) {
//
//        }

    }

    public static void main(String[] args) throws InterruptedException {
        C12_3_2reOrder s = new C12_3_2reOrder();
        for (int i = 0; i < 100; i++) {
            s.test(i);
        }
    }
}
