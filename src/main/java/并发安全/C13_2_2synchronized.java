package 并发安全;

import java.util.concurrent.atomic.AtomicInteger;

public class C13_2_2synchronized {
    public int demo() {
        synchronized (this) {
            int a = 10;
            int b = 20;
            return a + b;
        }

    }

    public static void main(String[] args) {
        System.out.println("Ok");
        C13_2_2synchronized s = new C13_2_2synchronized();
        System.out.println(s.demo());
        AtomicInteger my = new AtomicInteger();
        my.getAndIncrement();
    }
}
