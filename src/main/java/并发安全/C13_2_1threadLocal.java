package 并发安全;


public class C13_2_1threadLocal {
    public static ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();

    public static void main(String[] args) {

        Runnable task = new Runnable() {
            public void run() {
                threadLocal.set(0L);
                Long aLong = threadLocal.get();
                for (int i = 0; i < 10; i++) {
                    aLong++;
                    System.out.println(Thread.currentThread().getName() + "-->" + aLong);
                }
                threadLocal.set(aLong);
            }
        };
        Thread t1 = new Thread(task, "ThreadA");
        Thread t2 = new Thread(task, "ThreadB");
        t1.start();
        t2.start();
    }
}
